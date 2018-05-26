/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service;

import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.Gestionnaire;
import java.util.List;

/**
 * Interface IGestionnaire Elle fournit des méthodes abstraites a implémenté
 * permettant d'effecuter des traitements sur les Objets eGestionnaire ou sur le
 * POJO Gestionnaire.
 *
 * @author Achi Blay Kevin C. 
 */
public interface IGestionnaireService extends IService<Gestionnaire> {

    /**
     * clientsGestionnaire(String gestionnaire) Cette méthode abstraite permet
     * de récupérer les Clients d'un gestionnaire spécifique en utilisant son
     * code Gestionnaire.
     *
     * @param codeGestionnaire - String représentant le code gestionnaire
     * @return - Liste de Client ou null
     */
    public List<Client> clientsGestionnaire(String codeGestionnaire);

    /**
     * creerGestionnaire(Gestionnaire gestionnaire) Cette méthode abstraite
     * permet de créer un gestionnaire en utilisant le Gestionnaire donné en
     * paramètre,.
     *
     * @param gestionnaire - Gestionnaire représentant le Gestionnaire a crée
     * @return - true ou false
     */
    public boolean creerGestionnaire(Gestionnaire gestionnaire);

    /**
     * findByUsername(String username) Cette méthode abstraite permet de
     * rechercher un Gestionnaire en utilisant son username ou login.
     *
     * @param username - String représentant l'Username ou le Login
     * @return - Gestionnaire ou null
     */
    public Gestionnaire findByUsername(String username);
}
