/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service;

import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.Compte;
import java.util.List;

/**
 * Interface IClientService Elle permet de fournir des méthodes permettant
 * d'éffectuer des traitments sur nos Objets Client.
 *
 * @author Achi Blay Kevin C. 
 */
public interface IClientService extends IService<Client> {

    /**
     * creerNouveauClient(Client client) Cette méthode permet de créer un
     * nouveau client.
     *
     * @param client - Client représentant l'objet à crée
     * @return true ou false
     */
    public boolean creerNouveauClient(Client client);

    /**
     * miseAJourClient(Client client) Cette méthode permet d'apporter des
     * modifications sur un CLient donné.
     *
     * @param client - Client représentant les modifiactions à apporter.
     * @return true ou false
     */
    public boolean miseAJourClient(Client client);

    /**
     * findByCodeGestionnaire(String code) Elle permet de rechercher les clients
     * d'un gestionnaire en utilisant le code Gestionnaire.
     *
     * @param code - String representant le code du Gestionnaire
     * @return - Liste de Client ou null
     */
    public List<Client> findByCodeGestionnaire(String code);

    /**
     * listerClientComptes(String codeClient) Cette méthode permet de lister les
     * comptes d'un client en se servant de son code Client.
     *
     * @param codeClient - String representant le code du CLient
     * @return - Liste de Compte ou null
     */
    public List<Compte> listerClientComptes(String codeClient);

    /**
     * findByCodeClient(String codeClient) Cette méthode permet de rechercher un
     * Client en utilisant son code Client.
     *
     * @param codeClient - String représentant le code Client
     * @return - CLient ou null
     */
    public Client findByCodeClient(String codeClient);

    /**
     * findLast() Cette méthode permet de rechercher le dernier Client
     * enregister au niveau de la base de données.
     *
     * @return - Client ou null
     */
    public Client findLast();
}
