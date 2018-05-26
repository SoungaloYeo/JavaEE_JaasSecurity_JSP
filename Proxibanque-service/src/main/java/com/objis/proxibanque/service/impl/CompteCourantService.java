/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service.impl;

import com.objis.proxibanque.dao.ICompteCourantDao;
import com.objis.proxibanque.dao.impl.CompteCourantDao;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.CompteCourant;
import com.objis.proxibanque.service.ICompteCourantService;
import java.sql.Connection;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**Classe CompteCourantService
 * Cette Classe implémente l'interface ICompteCourantService et
 * permet d'effectuer des traitements sur es Objets de notre POJO CompteCourant.
 *
 * @author Achi Blay Kevin C. 
 */
public class CompteCourantService extends Service implements ICompteCourantService {

    private ICompteCourantDao compteCourantService;

      /**CompteCourantService(Connection connection)
     * Constructeur avec un paramètre Connection
     *
     * @param connection - Connection représentant l'Objet Connection
     */
    public CompteCourantService(Connection connection) {
        super(connection);
         this.logger = LogManager.getLogger(CompteCourantService.class.getName());
    }

    @Override
    public boolean create(CompteCourant t) {
         logger.info("== CREER COMPTE COURANT ==", Level.INFO);
        compteCourantService = new CompteCourantDao(connection);
        return compteCourantService.create(t);
    }

    @Override
    public boolean update(CompteCourant t) {
         logger.info("== MISE A JOUR COMPTE COURANT ==", Level.INFO);
        compteCourantService = new CompteCourantDao(connection);
        return compteCourantService.update(t);
    }

    @Override
    public boolean delete(CompteCourant t) {
         logger.info("== SUPPRIMER COMPTE COURANT ==", Level.INFO);
        compteCourantService = new CompteCourantDao(connection);
        return compteCourantService.delete(t);
    }

    @Override
    public CompteCourant findById(int id) {
        compteCourantService = new CompteCourantDao(connection);
        return compteCourantService.findById(id);
    }

    @Override
    public List<CompteCourant> findAll() {
        compteCourantService = new CompteCourantDao(connection);
        return compteCourantService.getAll();
    }

    @Override
    public CompteCourant findByNumCompteCourant(String numCompte) {
        compteCourantService = new CompteCourantDao(connection);
        return compteCourantService.findByNumCompteCourant(numCompte);
    }

    @Override
    public CompteCourant findByCodeClient(String codeClient) {
        compteCourantService = new CompteCourantDao(connection);
        return compteCourantService.findByCodeClient(codeClient);
    }

    @Override
    public boolean creerCompte(Client client, double solde) {
        if (client != null) {
            compteCourantService = new CompteCourantDao(connection);

            CompteCourant cc = new CompteCourant();
            cc.setCodeClient(client.getCodeClient());
            cc.setSoldeCompte(solde);
            cc.setNumeroCompte((CompteCourant.COMPTE_COURANT_ID).concat(String.valueOf(compteCourantService.getAll().size() + 1)));
            compteCourantService.create(cc);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CompteCourant find() {
    compteCourantService = new CompteCourantDao(connection);
    return compteCourantService.find();
    }

}
