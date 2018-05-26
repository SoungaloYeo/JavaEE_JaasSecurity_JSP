/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.connexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author yeo sglo
 */
public class ConnexionDaoWeb {

    private static DataSource ds;
    private static Connection conn = null;

    private ConnexionDaoWeb() {
    }

    
    /**
     *
     * @return a connection Object
     */
    public static Connection myConnexionWeb() {
        
        if (conn == null) {
            try {
                Context ctx = new InitialContext();
                ds = (DataSource) ctx.lookup("java:comp/env/jdbc/proxibanque_db");
                conn = ds.getConnection();
                return conn;
            } catch (NamingException ex) {
               // Logger.getLogger(ConnexionDaoWeb.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
               // Logger.getLogger(ConnexionDaoWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

}
