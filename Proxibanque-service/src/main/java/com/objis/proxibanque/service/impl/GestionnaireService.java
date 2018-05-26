/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service.impl;

import com.objis.proxibanque.dao.IGestionnaireDao;
import com.objis.proxibanque.dao.impl.GestionnaireDao;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.Gestionnaire;
import com.objis.proxibanque.service.IClientService;
import com.objis.proxibanque.service.IGestionnaireService;
import java.sql.Connection;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * Classe GestionnaireService Cette Classe implémente L'interface
 * IGestionnaireService permettant d'effectuer des traitements sur les Objets de
 * notre POJO GEstionnaire.
 *
 * @author Achi Blay Kevin C. 
 */
public class GestionnaireService extends Service implements IGestionnaireService {

    private IGestionnaireDao gestionnaireDao;
    private IClientService clientService;

    private static final String GESTIONNAIRE_ID = "PB-GEST-00";

    /**
     * GestionnairService(Connection connection) Constructeur avec un paramètre
     * Connection.
     *
     * @param connection - Connection représentant l'Objet Connection.
     */
    public GestionnaireService(Connection connection) {
        super(connection);
        this.logger = LogManager.getLogger(GestionnaireService.class.getName());
    }

    @Override
    public List<Client> clientsGestionnaire(String codeGestionnaire) {
        List<Client> clients = null;

        clientService = new ClientService(connection);
        if (clientService.findByCodeGestionnaire(codeGestionnaire) != null) {
            clients = clientService.findByCodeGestionnaire(codeGestionnaire);
        }
        this.logger.info((clients != null ? "[REUSSI]" : "[ECHEC]") + "CHARGEMENT CLIENTS GESTIONAIRE == [CODEGESTIONNAIRE: " + codeGestionnaire + "]", clients != null ? Level.INFO : Level.WARN);
        return clients;
    }

    @Override
    public boolean creerGestionnaire(Gestionnaire gestionnaire) {
        boolean result = false;

        if (gestionnaire != null) {

            gestionnaire.setId(this.findAll().size() + 1);
            gestionnaire.setCodeGestionnaire(this.genererCodeGestionnaire());

            if (this.create(gestionnaire)) {
                result = true;
                logger.info("[REUSSI] CREATION GESTIONNAIRE == [CODEGESTIONNAIRE: " + gestionnaire.getCodeGestionnaire() + "]", Level.INFO);
            } else {
                logger.info("[ECHEC] CREATION GESTIONNAIRE ", Level.WARN);
                return result;
            }
        } else {
            logger.info("[ECHEC] CREATION GESTIONNAIRE ", Level.WARN);
            return result;
        }
        return result;
    }

    @Override
    public boolean create(Gestionnaire t) {
        logger.info("== CREER GESTIONNAIRE ==", Level.INFO);
        gestionnaireDao = new GestionnaireDao(connection);
        return gestionnaireDao.create(t);
    }

    @Override
    public boolean update(Gestionnaire t) {
         logger.info("== MISE A JOUR GESTIONNAIRE ==", Level.INFO);
        gestionnaireDao = new GestionnaireDao(connection);
        return gestionnaireDao.update(t);
    }

    @Override
    public boolean delete(Gestionnaire t) {
        logger.info("== SUPPRIMER GESTIONNAIRE ==", Level.INFO);
        gestionnaireDao = new GestionnaireDao(connection);
        return gestionnaireDao.delete(t);
    }

    @Override
    public Gestionnaire findById(int id ) {
        gestionnaireDao = new GestionnaireDao(connection);
        return gestionnaireDao.findById(id);
    }

    @Override
    public List<Gestionnaire> findAll() {
        gestionnaireDao = new GestionnaireDao(connection);
        return gestionnaireDao.getAll();
    }

    private String genererCodeGestionnaire() {
        int id = this.findAll().size() + 1;
        return GESTIONNAIRE_ID.concat(String.valueOf(id));
    }

    @Override
    public Gestionnaire findByUsername(String username) {
        gestionnaireDao = new GestionnaireDao(connection);
        return gestionnaireDao.findByUsername(username);
    }
}
