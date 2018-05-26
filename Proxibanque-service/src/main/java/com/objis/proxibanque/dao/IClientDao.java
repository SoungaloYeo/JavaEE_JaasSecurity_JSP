/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao;

import com.objis.proxibanque.domaine.Client;
import java.util.List;

/**
 * Interface IClientDao Cette interface fournit des méthodes Abstraites
 * spécifiques à la classe de notre domaine Client.
 *
 *
 * @author yeo sglo 
 */
public interface IClientDao extends IDao<Client> {

    /**
     * Méthode Abstraite findByCodeGestionnaire(String codeGestionnaire) Cette
     * méthode nous permettra de rechercher une liste de clients à travers le
     * code du Gestionnaire qui les a crée.
     *
     * @param codeGestionnaire - String représentant le code du gestionnaire.
     * @return une List de client ou null
     */
    public List<Client> findByCodeGestionnaire(String codeGestionnaire);

    /**
     * Méthode Abstraite findByCodeClient(String code codeClient) Cette méthode
     * nous permettra de rechercher un Client suivant son codeClient.
     *
     * @param codeClient - String représentant le code client.
     * @return Client ou null
     */
    public Client findByCodeClient(String codeClient);
}
