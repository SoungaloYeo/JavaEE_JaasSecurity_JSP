/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.servlet;

import com.objis.proxibanque.connexion.ConnexionDaoWeb;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.Gestionnaire;
import com.objis.proxibanque.service.IClientService;
import com.objis.proxibanque.service.IGestionnaireService;
import com.objis.proxibanque.service.impl.ClientService;
import com.objis.proxibanque.service.impl.GestionnaireService;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Achi Blay Kevin C. 
 */
@WebServlet(name = "AcceuilServlet", urlPatterns = {"/AcceuilServlet"})
public class AcceuilServlet extends HttpServlet {

    Gestionnaire gestionnaire;
    IGestionnaireService igs;
    String value;
    IClientService clientService;

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
         String user = request.getRemoteUser();
        igs = new GestionnaireService(ConnexionDaoWeb.myConnexionWeb());

        gestionnaire = igs.findByUsername(user);

        List<Client> clients = igs.clientsGestionnaire(gestionnaire.getCodeGestionnaire());

        request.getSession().setAttribute("gestionnaire", gestionnaire);
        
        String codeGest = gestionnaire.getCodeGestionnaire();
        request.getSession().setAttribute("codeGest", codeGest);

        request.setAttribute("clients", clients);
        request.getRequestDispatcher("gestionnaire/acceuil.jsp").forward(request, response);

    }
}