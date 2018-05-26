/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.servlet;

import com.objis.proxibanque.connexion.ConnexionDaoWeb;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.Compte;
import com.objis.proxibanque.domaine.Virement;
import com.objis.proxibanque.service.IClientService;
import com.objis.proxibanque.service.ICompteService;
import com.objis.proxibanque.service.IVirementService;
import com.objis.proxibanque.service.impl.ClientService;
import com.objis.proxibanque.service.impl.CompteService;
import com.objis.proxibanque.service.impl.VirementService;
import java.io.IOException;
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
@WebServlet(name = "VirementServlet", urlPatterns = {"/virement"})
public class VirementServlet extends HttpServlet {

    private double soldeE = 0;
    private double soldeB = 0;
    private double montant = 0.0;
    private String message = "";
    private String numCpteE = "";
    private String numCpteB = "";
    private String Veffectuer = "";
    private String btnValider = "";
    private String choixCpteE = "";
    private String choixCpteB = "";
    private String btnActualiserE = "";
    private String btnActualiserB = "";
    private Compte compteE = null;
    private Compte compteB = null;
    private Client clientB = null;
    private Virement virement = null;
    private IVirementService virementService = null;
    private IClientService clientService = null;
    private ICompteService compteService = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.virement = new Virement();
        this.btnValider = request.getParameter("btnValider");
        this.btnActualiserE = request.getParameter("btnActualiserE");
        this.btnActualiserB = request.getParameter("btnActualiserB");
        this.Veffectuer = "";
        this.message = "";

        HttpSession session = request.getSession();

        if (btnActualiserE != null && btnActualiserE.equals("btnActualiserE")) {
            numCpteE = request.getParameter("numCpteE");
            this.compteService = new CompteService(ConnexionDaoWeb.myConnexionWeb());
            soldeE = compteService.findSoldeByNumCompte(numCpteE);

            this.choixCpteE = numCpteE;
            session.setAttribute("choixCpteE", choixCpteE);

        } else if (btnActualiserB != null && btnActualiserB.equals("btnActualiserB")) {
            numCpteB = request.getParameter("numCpteB");
            this.compteService = new CompteService(ConnexionDaoWeb.myConnexionWeb());
            this.compteB = new Compte();
            this.compteB = compteService.findCompteByNumCompte(numCpteB);

            this.clientB = new Client();
            this.clientService = new ClientService(ConnexionDaoWeb.myConnexionWeb());
            this.clientB = clientService.findByCodeClient(compteB.getCodeClient());
            session.setAttribute("clientB", clientB);

            choixCpteB = numCpteB;
            session.setAttribute("choixCpteB", choixCpteB);

            soldeB = compteService.findSoldeByNumCompte(numCpteB);
            session.setAttribute("soldeB", soldeB);

        } else if (btnValider != null && btnValider.equals("btnValider")) {
            this.montant = Double.valueOf(request.getParameter("montant"));
            this.soldeE = Double.valueOf(request.getParameter("soldeEAffiche"));

            if (montant <= 0) {
                this.message = "Revoyer le montant entré il doit être superieur à 0 F CFA";
            } else if (soldeE < montant) {
                this.message = "le solde de ce compte ne vous permet pas d'effectuer ce virement";
            } else {
                numCpteE = choixCpteE;
                numCpteB = choixCpteB;
                if (!numCpteE.equals(numCpteB)) {
                    virement = new Virement();
                    virement.setMontant(montant);
                    virement.setNumCompteEmetteur(numCpteE);
                    virement.setNumCompteBeneficiaire(numCpteB);
                    virementService = new VirementService(ConnexionDaoWeb.myConnexionWeb());
                    if (virementService.effectuerVirement(virement)) {
                        this.compteE = new Compte();
                        compteService = new CompteService(ConnexionDaoWeb.myConnexionWeb());
                        this.compteE = compteService.findCompteByNumCompte(numCpteE);

                        this.soldeE = this.compteE.getSoldeCompte();

                        this.compteB = new Compte();
                        this.compteB = compteService.findCompteByNumCompte(numCpteB);

                        this.soldeB = compteB.getSoldeCompte();

                        Veffectuer = "Veffectuer";
                    }
                } else {
                    message = "virement impossible entre deux meme comptes";
                }
            }
        }
            request.setAttribute("Veffectuer", Veffectuer);
            request.setAttribute("montant", montant);
            request.setAttribute("soldeB", soldeB);
            request.setAttribute("soldeE", soldeE);
            request.setAttribute("message", message);

            request.getRequestDispatcher("gestionnaire/virement.jsp").forward(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
