/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.domaine;

import java.io.Serializable;

/**
 * Classe Virement; représentant un virement.
 *
 * @author Achi Blay Kevin C. 
 */
public class Virement implements Serializable {

    private int id;
    private String codeVirement;
    private double montant;
    private String numCompteEmetteur;
    private String NumCompteBeneficiaire;

    public Virement() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeVirement() {
        return codeVirement;
    }

    public void setCodeVirement(String codeVirement) {
        this.codeVirement = codeVirement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getNumCompteEmetteur() {
        return numCompteEmetteur;
    }

    public void setNumCompteEmetteur(String numCompteEmetteur) {
        this.numCompteEmetteur = numCompteEmetteur;
    }

    public String getNumCompteBeneficiaire() {
        return NumCompteBeneficiaire;
    }

    public void setNumCompteBeneficiaire(String NumCompteBeneficiaire) {
        this.NumCompteBeneficiaire = NumCompteBeneficiaire;
    }

}
