/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.domaine;

/**
 * Classe Gestionnaire, représentant un Gestionnaire elle hérite de la
 * classe Personne.
 *
 * @author Achi Blay Kevin C. 
 */
public class Gestionnaire extends Personne {

    private String codeGestionnaire;
    private String login;
    private String password;

    public Gestionnaire() {
        super();
    }

    public String getCodeGestionnaire() {
        return codeGestionnaire;
    }

    public void setCodeGestionnaire(String codeGestionnaire) {
        this.codeGestionnaire = codeGestionnaire;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
