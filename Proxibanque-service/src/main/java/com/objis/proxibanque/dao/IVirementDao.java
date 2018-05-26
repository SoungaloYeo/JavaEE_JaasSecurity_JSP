/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao;

import com.objis.proxibanque.domaine.Virement;

/**Interface IVirementDao
 *Cette méthode fournit des méthodes abstraites permet d'éffectuer des
 * traitements au niveau de la Base de données représentant le POJO Virement
 * 
 * @author yeo sglo
 */
public interface IVirementDao  {
    
     /**Méthode create(T t)
     *Cette méthode permet d'enregistrer au niveau de la Base de données un nouveau
     * virement0
     * 
     * @param v - Virement représentant l'objet Virement
     * @return - true ou false
     */
    public boolean create(Virement v);   
}
