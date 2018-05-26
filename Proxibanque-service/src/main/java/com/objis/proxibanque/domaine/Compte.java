/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.domaine;

import java.io.Serializable;

/**
 * Classe Classe représentant un Compte.
 *
 * @author Achi Blay Kevin C. 
 */
public class Compte implements Serializable {

    private int id;
    private String codeClient;
    private String numeroCompte;
    private double soldeCompte;

    public Compte() {

    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(double soldeCompte) {
        this.soldeCompte = soldeCompte;
    }

}
