/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.filter;

import com.objis.proxibanque.connexion.ConnexionDaoWeb;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.Compte;
import com.objis.proxibanque.service.IClientService;
import com.objis.proxibanque.service.ICompteService;
import com.objis.proxibanque.service.impl.ClientService;
import com.objis.proxibanque.service.impl.CompteService;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yeo sglo
 */
@WebFilter(filterName = "VirementFilter", urlPatterns = {"/virement"})
public class VirementFilter implements Filter {

    private static final boolean debug = true;
    //toutes mes vafiables
    private String btnValider = "";
    private String btnActualiserE = "";
    private String btnActualiserB = "";

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public VirementFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("Virement:DoBeforeProcessing");
        }

    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("////////////////////////Virement:DoAfterProcessing//////////////////////");
        }

    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (debug) {
            log("Virement:doFilter()");
        }

        doBeforeProcessing(request, response);
        Throwable problem = null;
        try {
            this.btnValider = req.getParameter("btnValider");
            this.btnActualiserE = req.getParameter("btnActualiserE");
            this.btnActualiserB = req.getParameter("btnActualiserB");

            if ((btnActualiserE == null || btnActualiserE.equals("")) && (btnActualiserB == null || btnActualiserB.equals("")) && (btnValider == null || btnValider.equals(""))) {
                Client clientE = new Client();
                IClientService clientService = new ClientService(ConnexionDaoWeb.myConnexionWeb());
                String codeCli = request.getParameter("codeCli");
                clientE = clientService.findByCodeClient(codeCli);

                session.setAttribute("clientE", clientE);

                ICompteService compteService = new CompteService(ConnexionDaoWeb.myConnexionWeb());
                List<Compte> comptesE = new LinkedList<>();
                comptesE = compteService.listerComptes(codeCli);
                session.setAttribute("comptesE", comptesE);

                //initialiser la liste de tous les comptes
                ArrayList<String> comptesCli = new ArrayList<>();
                ICompteService cpteService = null;
                cpteService = new CompteService(ConnexionDaoWeb.myConnexionWeb());
                comptesCli = cpteService.tousLesComptes();
                session.setAttribute("comptesCli", comptesCli);
                
                //initialiser le solde et code compte choisi pour emetteur et beneficiaire par rapport au expressionLanguage
                //pour l'affichage ou pas de l'info et des solde
                String soldeE = "";
                session.setAttribute("soldeE", soldeE);
                
                String soldeB = "";
                session.setAttribute("soldeB", soldeB);
                
                String choixCpte = "";
                session.setAttribute("choixCpte", choixCpte);
                
                String choixCpteE = "";
                session.setAttribute("choixCpteE", choixCpteE);
                String choixCpteB = "";
                session.setAttribute("choixCpteB", choixCpteB);
                
                String Veffectuer = "";
                session.setAttribute("Veffectuer", Veffectuer);                
               
                Client clientB = new Client();
                session.setAttribute("clientB", clientB);
                
                req.getRequestDispatcher("gestionnaire/virement.jsp").forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        } catch (Throwable t) {

            problem = t;
            t.printStackTrace();
        }

        doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("Virement:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("Virement()");
        }
        StringBuffer sb = new StringBuffer("Virement(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
