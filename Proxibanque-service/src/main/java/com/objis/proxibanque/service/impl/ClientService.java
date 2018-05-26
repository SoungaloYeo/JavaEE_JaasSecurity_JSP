/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service.impl;

import com.objis.proxibanque.dao.IClientDao;
import com.objis.proxibanque.dao.impl.ClientDao;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.Compte;
import com.objis.proxibanque.service.IClientService;
import com.objis.proxibanque.service.ICompteService;
import java.sql.Connection;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * Classe ClientService Cette classe implémente les méthodes abstraites de
 * IClientService et permet d'effectuer des traitements sur les Objets du POJO
 * Client.
 *
 * @author yeo sglo
 */
public class ClientService extends Service implements IClientService {

    private IClientDao clientDao;
    private ICompteService compteService;

    private static final String CLIENT_ID = "PB-CLI-000";

    /**
     * ClientService(Connection) Construteur avec un paramètres Connection.
     *
     * @param connection - Connection représentant L'Objet Connection
     */
    public ClientService(Connection connection) {
        super(connection);
        this.logger = LogManager.getLogger(ClientService.class.getName());
    }

    @Override
    public boolean creerNouveauClient(Client client) {
        boolean result = false;

        if (client != null) {
            client.setCodeClient(this.genererCodeClient(this.findAll().size() + 1));

            compteService = new CompteService(connection);
            this.create(client);
            result = true;
            this.logger.info("[REUSSI] CREATION NOUVEAU CLIENT == [CODECLIENT:" + client.getCodeClient() + "] == [CODEGESTIONNAIRE:" + client.getCodeGestionnaire() + "]", Level.INFO);
        } else {
            result = false;
            this.logger.warn("[ECHEC] CREATION NOUVEAU CLIENT == ", Level.WARN);
        }

        return result;
    }

    @Override
    public boolean miseAJourClient(Client client) {
        Client clientA = null;
        boolean result = false;

        if (client != null) {
            clientA = this.findById(client.getId());

            if (clientA != null) {
                this.update(client);
                result = true;
            }
        } else {
            this.logger.info("[REUSSI] MISE A JOUR CLIENT == " + client.getCodeClient() + " == " + client.getCodeGestionnaire(), Level.INFO);
            result = false;
        }

        return result;
    }

    @Override
    public List<Compte> listerClientComptes(String codeClient) {
        compteService = new CompteService(connection);
        return compteService.listerComptes(codeClient);
    }

    @Override
    public boolean create(Client t) {
        logger.info("== CREER CLIENT ==", Level.INFO);
        clientDao = new ClientDao(connection);
        return clientDao.create(t);
    }

    @Override
    public boolean update(Client t) {
        logger.info("== MISE A JOUR CLIENT ==", Level.INFO);
        clientDao = new ClientDao(connection);
        return clientDao.update(t);
    }

    @Override
    public boolean delete(Client t) {
        logger.info("== SUPPRIMER CLIENT ==", Level.INFO);
        clientDao = new ClientDao(connection);
        return clientDao.delete(t);
    }

    @Override
    public Client findById(int id) {
        clientDao = new ClientDao(connection);
        return clientDao.findById(id);
    }

    @Override
    public List<Client> findAll() {
        clientDao = new ClientDao(connection);
        return clientDao.getAll();
    }

    @Override
    public List<Client> findByCodeGestionnaire(String code) {
        clientDao = new ClientDao(connection);
        return clientDao.findByCodeGestionnaire(code);
    }

    private String genererCodeClient(int val) {
        return CLIENT_ID.concat(String.valueOf(val));
    }

    @Override
    public Client findByCodeClient(String codeClient) {
        clientDao = new ClientDao(connection);
        return clientDao.findByCodeClient(codeClient);
    }

    @Override
    public Client findLast() {
        clientDao = new ClientDao(connection);
        return clientDao.find();
    }

}
