/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao;

import com.objis.proxibanque.domaine.CompteEpargne;
import java.util.List;

/**
 * Interface ICompteEpargneDao Cette interface fournit des méthodes Abstraites
 * spécifiques à la classe de notre domaine CompteEpargne.
 *
 * @author yeo sglo
 */
public interface ICompteEpargneDao extends IDao<CompteEpargne> {

    /**
     * Méthode findByNumCompte(String numCpteEpargne) Cette méthode permet
     * d'effectuer une recherche suivant le numéro de compte disposant du
     * compte.
     *
     * @param numCpteEpargne - String représentant le numero du Compte.
     * @return CompteCourant ou null
     */
    public CompteEpargne findByNumCompteEpargne(String numCpteEpargne);

    /**
     * *Méthode findByCodeClient(String numClient) Cette méthode permet
     * d'effectuer une recherche suivant le code du client disposant du compte.
     *
     * @param codeClient - String représentant le code du client.
     * @return Liste de CompteEpargne ou null
     */
    public List<CompteEpargne> findByCodeClient(String codeClient);
}
