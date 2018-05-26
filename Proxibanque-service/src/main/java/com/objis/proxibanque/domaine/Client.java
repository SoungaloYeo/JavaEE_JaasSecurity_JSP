/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.domaine;

import java.io.Serializable;

/**
 * Classe Client représentant un Client, elle hérite de la Classe
 * personne.
 *
 * @author Achi Blay Kevin C. 
 */
public class Client extends Personne implements Serializable {

    private String codeClient;
    private String codeGestionnaire;

    public String getCodeGestionnaire() {
        return codeGestionnaire;
    }

    public void setCodeGestionnaire(String codeGestionnaire) {
        this.codeGestionnaire = codeGestionnaire;
    }

    public String getCodeClient() {
        return codeClient;
    }

    public void setCodeClient(String codeClient) {
        this.codeClient = codeClient;
    }

    public Client() {
    }

    public Client(String codeClient, String codeGestionnaire) {
        this.codeClient = codeClient;
        this.codeGestionnaire = codeGestionnaire;
    }

    
}
