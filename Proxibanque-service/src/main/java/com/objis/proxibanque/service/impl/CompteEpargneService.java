/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service.impl;

import com.objis.proxibanque.dao.ICompteEpargneDao;
import com.objis.proxibanque.dao.impl.CompteEpargneDao;
import com.objis.proxibanque.domaine.Client;
import com.objis.proxibanque.domaine.CompteEpargne;
import com.objis.proxibanque.service.ICompteEpargneService;
import java.sql.Connection;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**Classe CompteEpargneService
 * Cette Classe implémente l'interface ICompteEpargneService et
 * permet d'effectuer des traitements sur les Objets de notre POJO CompteEpargne.
 *
 * @author Achi Blay Kevin C. <Achi Blay Kevin C. at blay12cedric@gmail.com>
 */
public class CompteEpargneService extends Service implements ICompteEpargneService {

    private ICompteEpargneDao compteEpargneDao;
    /**CompteEpargneService(Connection connection)
     * Constructeur avec un paramètre Connection
     *
     * @param connection - Connection représentant l'Objet Connection
     */

    public CompteEpargneService(Connection connection) {
        super(connection);
        this.logger = LogManager.getLogger(CompteEpargneService.class.getName());
    }

    @Override
    public boolean create(CompteEpargne t) {
        logger.info("== CREER COMPTE EPARGNE ==", Level.INFO);
        compteEpargneDao = new CompteEpargneDao(connection);
        return compteEpargneDao.create(t);
    }

    @Override
    public boolean update(CompteEpargne t) {
         logger.info("== MISE A JOUR COMPTE EPARGNE ==", Level.INFO);
        compteEpargneDao = new CompteEpargneDao(connection);
        return compteEpargneDao.update(t);
    }

    @Override
    public boolean delete(CompteEpargne t) {
         logger.info("== SUPPRIMER COMPTE EPARGNE ==", Level.INFO);
        compteEpargneDao = new CompteEpargneDao(connection);
        return compteEpargneDao.delete(t);
    }

    @Override
    public CompteEpargne findById(int id) {
        compteEpargneDao = new CompteEpargneDao(connection);
        return compteEpargneDao.findById(id);
    }

    @Override
    public List<CompteEpargne> findAll() {
        compteEpargneDao = new CompteEpargneDao(connection);
        return compteEpargneDao.getAll();
    }

    @Override
    public CompteEpargne findByCompteEpargne(String codeClient) {
        compteEpargneDao = new CompteEpargneDao(connection);
        return compteEpargneDao.findByNumCompteEpargne(codeClient);
    }

    @Override
    public List<CompteEpargne> findByCodeClient(String codeClient) {
        compteEpargneDao = new CompteEpargneDao(connection);
        return compteEpargneDao.findByCodeClient(codeClient);
    }

    @Override
    public boolean creerCompte(Client client, double solde) {
        compteEpargneDao = new CompteEpargneDao(connection);
        if (client != null) {
            CompteEpargne ce = new CompteEpargne();
            ce.setCodeClient(client.getCodeClient());
            ce.setSoldeCompte(solde);
            ce.setNumeroCompte((CompteEpargne.COMPTE_EPARGNE_ID).concat(String.valueOf(compteEpargneDao.getAll().size() + 1)));
            compteEpargneDao.create(ce);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public CompteEpargne find() {
        compteEpargneDao = new CompteEpargneDao(connection);
        return compteEpargneDao.find();
    }

}
