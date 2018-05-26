/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service;

import com.objis.proxibanque.domaine.Virement;

/**
 * Interface IVirementService Interface fournissant des méthodes spécifiques aux
 * traitements des Objets Vierement.
 *
 * @author Achi Blay Kevin C. 
 */
public interface IVirementService {

    /**
     * create(Virement v) Cette méthode abstraite permet de de créer un nouveau
     * virement et d'effectuer toutes les verifications nécessaires.
     *
     * @param v - Virement représentant le virement a crée
     * @return - true ou false
     */
    public boolean create(Virement v);

    /**
     * effectuerVirement(Virement virement) Cette méthode permet d'effectuer un
     * virement.
     *
     * @param virement - Virement représentant le virement a crée
     * @return - true ou false
     */
    public boolean effectuerVirement(Virement virement);
}
