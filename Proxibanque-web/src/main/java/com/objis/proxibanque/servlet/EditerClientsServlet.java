/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.servlet;

import com.objis.proxibanque.connexion.ConnexionDaoWeb;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.service.IClientService;
import com.objis.proxibanque.service.impl.ClientService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yeo sglo
 */
@WebServlet(name = "EditerClientServlet", urlPatterns = {"/editerclient"})
public class EditerClientsServlet extends HttpServlet {

    private String codeCli = "";
    private String nom = "";
    private String prenom = "";
    private String email = "";
    private String adresse = "";
    private Client clientAJour;
    private IClientService clientService = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        codeCli = request.getParameter("codeCli");
        nom = request.getParameter("nom");
        prenom = request.getParameter("prenom");
        email = request.getParameter("email");
        adresse = request.getParameter("adresse");

        clientAJour = new Client();
        clientAJour.setCodeClient(codeCli);
        clientAJour.setNom(nom);
        clientAJour.setPrenoms(prenom);
        clientAJour.setEmail(email);
        clientAJour.setAdresse(adresse);
        clientService = new ClientService(ConnexionDaoWeb.myConnexionWeb());

        if (clientService.update(clientAJour)) {
            request.setAttribute("clientAJour", clientAJour);
            request.getRequestDispatcher("gestionnaire/editerclient.jsp").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
