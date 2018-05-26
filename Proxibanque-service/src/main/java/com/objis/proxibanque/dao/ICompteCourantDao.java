/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao;

import com.objis.proxibanque.domaine.CompteCourant;

/**
 * Interface ICompteCourantDao Cette interface fournit des méthodes Abstraites
 * spécifiques à la classe de notre domaine CompteCourant.
 *
 * @author yeo sglo
 */
public interface ICompteCourantDao extends IDao<CompteCourant> {

    /**
     * Méthode findByNumCompteCourant(String codeCpteCourant) Cette méthode nous
     * permettra d'éffectuer une recherche d'un compte Courant en utilisatn le
     * code de ce compte.
     *
     * @param codeCpteCourant - String représentant le code du compte.
     * @return CompteCourant ou null
     */
    public CompteCourant findByNumCompteCourant(String codeCpteCourant);

    /**
     * Méthode findByCodeClient(String numClient) Cette méthode permet
     * d'effectuer une recherche suivant le code du client disposant du compte.
     *
     * @param numClient - String représentant le code du client.
     * @return CompteCourant ou null
     */
    public CompteCourant findByCodeClient(String numClient);
}
