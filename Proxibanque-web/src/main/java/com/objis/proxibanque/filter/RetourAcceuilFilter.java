/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author yeo sglo
 */
@WebFilter(filterName = "RetourAcceuilFilter", urlPatterns = {"/gestionnaire/acceuil.jsp","/acceuil.jsp"})
public class RetourAcceuilFilter implements Filter {

    private static final boolean debug = true;
    private String action;
    private String choix;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public RetourAcceuilFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RetourAcceuilFilter:DoBeforeProcessing");
        }

    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("RetourAcceuilFilter:DoAfterProcessing");
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("RetourAcceuilFilter:doFilter()");
        }

        doBeforeProcessing(request, response);

        Throwable problem = null;
        try {
            //============================================================================================   
            HttpServletRequest req = (HttpServletRequest)request;
            choix ="";
            action = req.getParameter("action");
            if (action != null) {
                if (action.equals("acceuil")) {
                    System.out.println("@@@@@@@@@@@@@@@@@@====le suis dans RetourAcceuilFilter: action=acceuil====@@@@@@@@@@@@@@@@@@");
                    choix = action;
                } else if (action.equals("liste-cpte")) {
                    System.out.println("@@@@@@@@@@@@@@@@@@====le suis dans RetourAcceuilFilter: action=liste-cpte====@@@@@@@@@@@@@@@@@@");
                    choix = action;
                } else if (action.equals("editer")) {
                    System.out.println("@@@@@@@@@@@@@@@@@@====le suis dans RetourAcceuilFilter: action=editer====@@@@@@@@@@@@@@@@@@");
                    choix = action;
                } else if (action.equals("virement")) {
                    System.out.println("@@@@@@@@@@@@@@@@@@====le suis dans RetourAcceuilFilter: action=virement====@@@@@@@@@@@@@@@@@@");
                    choix = action;
                }
                req.setAttribute("choix", choix);
            }
            
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
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
                log("RetourAcceuilFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("RetourAcceuilFilter()");
        }
        StringBuffer sb = new StringBuffer("RetourAcceuilFilter(");
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
