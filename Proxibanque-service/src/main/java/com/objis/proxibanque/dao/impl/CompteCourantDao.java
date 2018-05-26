/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao.impl;

import com.objis.proxibanque.dao.ICompteCourantDao;
import com.objis.proxibanque.domaine.CompteCourant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * Classe CompteCourantDao Classe implémentant l'interface ICompteCourantDao et
 * permettant d'eefectuer des traitements sur la Table CompteCourant.
 *
 * @author yeo sglo
 */
public class CompteCourantDao extends DAO implements ICompteCourantDao {

    private final String createStatement = "insert into compte_courant(num_compte, solde_compte, code_client) values (?,?,?)";
    private final String readAllStatement = "select * from compte_courant";
    private final String updateStatement = "update compte_courant set solde_compte=? where num_compte=?";
    private final String deleteStatement = "delete from compte_courant where id=?";
    private final String findLastStatement = "select * from compte_courant order by id desc";
    private final String findByIdStatement = "select * from compte_courant where id=?";
    private final String findByNumCpteCourantSt = "select * from compte_courant where num_compte =?";
    private final String findByCodeClientSt = "select * from compte_courant where code_client =?";
    PreparedStatement ps;

    /**
     * CompteCourantDao(Connection connection) Constructeur avec un paramètre
     *
     * @param conn - COnnection représentant l'Objet Connection
     */
    public CompteCourantDao(Connection conn) {
        super(conn);
        this.logger = LogManager.getLogger(CompteCourantDao.class.getName());
    }

    @Override
    public Boolean create(CompteCourant t) {
        int test = -1;

        try {
            ps = this.cnx.prepareStatement(createStatement);
            ps.setString(1, t.getNumeroCompte());
            ps.setDouble(2, t.getSoldeCompte());
            ps.setString(3, t.getCodeClient());
            test = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return test > 0;
    }

    @Override
    public Boolean update(CompteCourant t) {
        int test = -1;
        try {
            ps = this.cnx.prepareStatement(updateStatement);
            ps.setDouble(1, t.getSoldeCompte());
            ps.setString(2, t.getNumeroCompte());
            test = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return test > 0;
    }

    @Override
    public Boolean delete(CompteCourant t) {
        return true;
    }

    @Override
    public List<CompteCourant> getAll() {
        List<CompteCourant> compteCourants = null;
        CompteCourant compteCourant = null;
        try {
            ps = this.cnx.prepareStatement(readAllStatement);
            ResultSet rs = ps.executeQuery();
            compteCourants = new LinkedList<>();

            while (rs.next()) {
                compteCourant = new CompteCourant();
                compteCourant.setNumeroCompte(rs.getString("num_compte"));
                compteCourant.setSoldeCompte(rs.getDouble("solde_compte"));
                compteCourant.setCodeClient(rs.getString("code_client"));
                compteCourants.add(compteCourant);
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteCourants;
    }

    @Override
    public CompteCourant find() {
        CompteCourant compteCourant = null;
        try {
            ps = this.cnx.prepareStatement(findLastStatement);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                compteCourant = new CompteCourant();
                compteCourant.setNumeroCompte(rs.getString("num_compte"));
                compteCourant.setSoldeCompte(rs.getDouble("solde_compte"));
                compteCourant.setCodeClient(rs.getString("code_client"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteCourant;
    }

    @Override
    public CompteCourant findById(Integer val) {
        CompteCourant compteCourant = null;
        try {
            ps = this.cnx.prepareStatement(findByIdStatement);
            ps.setLong(1, val);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compteCourant = new CompteCourant();
                compteCourant.setNumeroCompte(rs.getString("num_compte"));
                compteCourant.setSoldeCompte(rs.getDouble("solde_compte"));
                compteCourant.setCodeClient(rs.getString("code_client"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteCourant;
    }

    @Override
    public CompteCourant findByNumCompteCourant(String numCpteCourant) {
        CompteCourant compteCourant = null;
        try {
            ps = this.cnx.prepareStatement(findByNumCpteCourantSt);
            ps.setString(1, numCpteCourant);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compteCourant = new CompteCourant();
                compteCourant.setNumeroCompte(rs.getString("num_compte"));
                compteCourant.setSoldeCompte(rs.getDouble("solde_compte"));
                compteCourant.setCodeClient(rs.getString("code_client"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteCourant;
    }

    @Override
    public CompteCourant findByCodeClient(String numClient) {
        CompteCourant compteCourant = null;
        try {
            ps = this.cnx.prepareStatement(findByCodeClientSt);
            ps.setString(1, numClient);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compteCourant = new CompteCourant();
                compteCourant.setNumeroCompte(rs.getString("num_compte"));
                compteCourant.setSoldeCompte(rs.getDouble("solde_compte"));
                compteCourant.setCodeClient(rs.getString("code_client"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteCourant;
    }

}
