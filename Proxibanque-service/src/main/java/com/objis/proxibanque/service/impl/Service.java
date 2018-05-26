/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service.impl;

import java.sql.Connection;
import org.apache.logging.log4j.Logger;

/**Classe Abstraite Service
 * Cette classe permet de créer une Couche d'abstraction permettant 
 * d'utiliser une Connection détachée Connection.
 *
 * @author Achi Blay Kevin C. 
 */
public abstract class Service {
    /**
     * bjet Connection
     */
    public static Connection connection;
    
    public Logger logger;
    
    /**Constructeur Service()
     *Constructeur avec un paramètre Connection permettant d'initialiser celui-ci.
     * 
     * @param connection - Connection représentant l'Objet Connection.
     */
    public Service(Connection connection){
        Service.connection = connection;
    }
}
