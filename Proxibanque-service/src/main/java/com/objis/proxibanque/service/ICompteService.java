/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service;

import com.objis.proxibanque.domaine.Compte;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface ICompteService Elle nous fournit des méthodes abstraites a
 * implémenter.
 *
 * @author Achi Blay Kevin C. 
 */
public interface ICompteService {

    /**
     * listerComptes(String codeClient) Cette méthode permet de lister les
     * COmptes d'un Client.
     *
     * @param codeClient - String
     * @return - Liste de Compte ou null
     */
    public List<Compte> listerComptes(String codeClient);

    /**
     * findCompteByNumCompte(String numCompte) Cette méthode permet de
     * rechercher un compte en utilisant le numéro de compte.
     *
     * @param numCompte - String
     * @return - Compte ou null
     */
    public Compte findCompteByNumCompte(String numCompte);

    /**
     * findSoldeByNumCompte(String numCompte) cette methode permet de d'obtenir
     * le solde d'un compte dont le numero de compte est connu
     *
     * @param numCompte
     * @return
     */
    public Double findSoldeByNumCompte(String numCompte);

    /**
     * la methode tousLesComptes() retourne un tableau de chaine de caractère elle nous
     * permet d'avoir la liste complete de tous les comptes de la Base de
     * données
     *
     * @return
     */
    public ArrayList<String> tousLesComptes();
}
