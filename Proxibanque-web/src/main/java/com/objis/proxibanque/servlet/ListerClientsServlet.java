/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.servlet;

import com.objis.proxibanque.connexion.ConnexionDaoWeb;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.Compte;
import com.objis.proxibanque.service.IClientService;
import com.objis.proxibanque.service.ICompteService;
import com.objis.proxibanque.service.impl.ClientService;
import com.objis.proxibanque.service.impl.CompteService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yeo sglo
 */
@WebServlet(name = "ListerClientsServlet", urlPatterns = {"/listerclients"})
public class ListerClientsServlet extends HttpServlet {

    String btnVoirClient;
    List<String> typeComptes;
    List<Compte> comptes = null;
    ICompteService compteService = null;
    IClientService clientService = null;
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codeCli = request.getParameter("codeCli");
        clientService = new ClientService(ConnexionDaoWeb.myConnexionWeb());
        Client client = new Client();
        client = clientService.findByCodeClient(codeCli);
        request.setAttribute("client", client);

        compteService = new CompteService(ConnexionDaoWeb.myConnexionWeb());
        comptes = new LinkedList<>();
        comptes = compteService.listerComptes(codeCli);
        request.setAttribute("comptes", comptes);

        typeComptes = new ArrayList<>();
        if (comptes != null) {
            for (int i = 0; i < comptes.size(); i++) {
                if (comptes.get(i).getNumeroCompte().startsWith("PB-CE")) {
                    typeComptes.add("COMPTE EPARGNE");
                } else {
                    typeComptes.add("COMPTE COURANT");
                }
            }
        request.setAttribute("typeCompte", typeComptes);
        }


//        RequestDispatcher requestDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/listerclients.jsp");
//        requestDispatcher.forward(request, response);
        request.getRequestDispatcher("gestionnaire/listerclients.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
