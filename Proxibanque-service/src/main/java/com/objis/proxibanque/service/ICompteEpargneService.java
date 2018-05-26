/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service;

import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.CompteEpargne;
import java.util.List;

/**
 * interface ICompteEpargneService
 *
 * @author Achi Blay Kevin C. 
 */
public interface ICompteEpargneService extends IService<CompteEpargne> {

    /**
     * findByNumCompteEpargne(String numCompte) Méthode permettant de rechercher
     * un compte en utilisant son numéro de compte.
     *
     * @param numCompte - String
     * @return - CompteEpargne ou null
     */
    public CompteEpargne findByCompteEpargne(String numCompte);

    /**
     * findByCodeClient(String codeClient) Méthode permettant de rechercher un
     * compte en utilisant le code du client propriétaire du compte.
     *
     * @param codeClient - String
     * @return - CompteCourant ou null
     */
    public List<CompteEpargne> findByCodeClient(String codeClient);

    /**
     * creerCompte(Client client, double solde)
     * cette methode  nous permet donc de creer des comptes reletif 
     * au client passé en parametre
     *
     * @param client
     * @param solde
     * @return
     */
    public boolean creerCompte(Client client, double solde);

    /**
     * cette methode nous permet de faire ressortir le dernier compte 
     * dans la base de donnée
     * 
     * @return 
     */
    public CompteEpargne find();
}
