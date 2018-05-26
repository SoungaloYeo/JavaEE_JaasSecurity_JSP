/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author yeo sglo
 */
public class ConnectionTest {

    private String url = "jdbc:mysql://localhost:3306/proxibanque_db";
    private String user = "root";
    private String pass = "";
    private static Connection conx = null;
    Logger logger;
    

    private ConnectionTest() {
        this.logger = LogManager.getLogger(this.getClass().getName());
        try {
            conx = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            logger.warn("connection échouée");
        }
    }

    public static Connection getInstence() {
        if (conx == null) {
            new ConnectionTest();
        }
        return conx;
    }
}
