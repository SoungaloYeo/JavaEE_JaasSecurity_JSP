/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao;

import com.objis.proxibanque.domaine.Gestionnaire;

/**Interface IGestionnaireDao
 *Cette interface met à disposition des méthodes abstraites propres aux traitements
 * liés au Gestionnaire
 * 
 * @author yeo sglo
 */
public interface IGestionnaireDao extends IDao<Gestionnaire>{
    
    /**Méthode findByCodeGestionnaire(String codeGestionnaire)
     *Cette méthode permet de rechercher un gestionnaire au niveau de la Base de 
     * données en utilisant son Code gestionnaire 
     * 
     * @param codeGestionnaire - String représentant le code u gestionnaire
     * @return - Gestionnaire ou null
     */
    public Gestionnaire findByCodeGestionnaire(String codeGestionnaire);
    
     /**Méthode findByUsername(String login)
     *Cette méthode permet rechercher un gestionnaire ne utilisant son username ou
     * login.
     * 
     * @param login - String représentant l'Username ou le login del'utilisateur
     * @return - gestionnaire ou null
     */
    public Gestionnaire findByUsername(String login);
}
