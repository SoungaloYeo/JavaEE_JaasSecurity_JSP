/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao.impl;

import java.sql.Connection;
import org.apache.logging.log4j.Logger;

/**
 * Classe Dao Cette Classe permet d'initialiser la Connection
 *
 * @author yeo sglo
 */
public class DAO {

    public Logger logger;
    /**
     * DAO(Connection connection) Constructeur avec un paramètre Connection
     *
     * @param conn - Connection représentant l'Objet COnnection
     */
    Connection cnx;

    public DAO(Connection conn) {
        this.cnx = conn;
    }

}
