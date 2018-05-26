/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.servlet;

import com.objis.proxibanque.connexion.ConnexionDaoWeb;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.CompteCourant;
import com.objis.proxibanque.domaine.CompteEpargne;
import com.objis.proxibanque.service.IClientService;
import com.objis.proxibanque.service.ICompteCourantService;
import com.objis.proxibanque.service.ICompteEpargneService;
import com.objis.proxibanque.service.impl.ClientService;
import com.objis.proxibanque.service.impl.CompteCourantService;
import com.objis.proxibanque.service.impl.CompteEpargneService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Achi Blay Kevin C. 
 */
@WebServlet(name = "CreerClientServlet", urlPatterns = {"/creerclient"})
public class CreerClientServlet extends HttpServlet {

    IClientService clientService;
    Client nvoClient = null;
    String creerCC = "";
    String creerCE = "";
    CompteCourant compteCourant = null;
    ICompteCourantService compteCourantService = null;
    CompteEpargne compteEpargne = null;
    ICompteEpargneService compteEpargneService = null;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Client client = new Client();
        String nom = request.getParameter("nom");
        String prenoms = request.getParameter("prenoms");
        String email = request.getParameter("email");
        String adresse = request.getParameter("adresse");
        String codeGest = request.getParameter("codeGest");

        creerCE = request.getParameter("creerCE");
        creerCC = request.getParameter("creerCC");

        client.setNom(nom);
        client.setPrenoms(prenoms);
        client.setEmail(email);
        client.setAdresse(adresse);
        client.setCodeGestionnaire(codeGest);

        clientService = new ClientService(ConnexionDaoWeb.myConnexionWeb());
        compteCourantService = new CompteCourantService(ConnexionDaoWeb.myConnexionWeb());
        compteEpargneService = new CompteEpargneService(ConnexionDaoWeb.myConnexionWeb());
        String str ="";
        if (clientService.creerNouveauClient(client)) {

            nvoClient = new Client();
            nvoClient = clientService.findLast();
            request.setAttribute("nvoClient", nvoClient);
            double depotCC = 0.0; //sur compte courant pas d'epargne
            if ((creerCC != null && !creerCC.isEmpty()) && compteCourantService.creerCompte(nvoClient, depotCC)) {
                compteCourant = new CompteCourant();

                compteCourant = compteCourantService.find();
                compteCourant.setSoldeCompte(depotCC);
                request.setAttribute("compteCourant", compteCourant);
            }

            double depotCE = Double.valueOf(request.getParameter("depotCE"));
            if ((creerCE != null && !creerCE.isEmpty()) && compteEpargneService.creerCompte(nvoClient, depotCE)) {
                compteEpargne = new CompteEpargne();
                compteEpargne = compteEpargneService.find();
                compteEpargne.setSoldeCompte(depotCE);
                request.setAttribute("compteEpargne", compteEpargne);
            }
            str = "pasVide";
        }
        request.setAttribute("str", str);
//        request.getRequestDispatcher("gestionnaire/creerclient.jsp").forward(request, response);
        request.getRequestDispatcher("gestionnaire/creerclientResultat.jsp").forward(request, response);
    }

}
