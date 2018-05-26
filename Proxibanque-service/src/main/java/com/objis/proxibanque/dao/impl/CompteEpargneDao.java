/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao.impl;

import com.objis.proxibanque.domaine.CompteEpargne;
import java.util.List;
import com.objis.proxibanque.dao.ICompteEpargneDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * Classe CompteEpargneDao Classe implémentant l'interface ICompteEpargneDao et
 * permettant d'eefectuer des traitements sur la Table CompteEpargne.
 *
 * @author yeo sglo
 */
public class CompteEpargneDao extends DAO implements ICompteEpargneDao {

    private final String createStatement = "insert into compte_epargne(num_compte, solde_compte, code_client) values (?,?,?)";
    private final String readAllStatement = "select * from compte_epargne";
    private final String updateStatement = "update compte_epargne set solde_compte=? where num_compte=?";
    private final String deleteStatement = "delete from compte_epargne where id=?";
    private final String findLastStatement = "select * from compte_epargne order by id desc";
    private final String findByIdStatement = "select * from compte_epargne where id=?";
    private final String findByCpteEpargneSt = "select * from compte_epargne where num_compte =?";
    private final String findBycode_clientSt = "select * from compte_epargne where code_client =?";
    PreparedStatement ps = null;

    /**
     * CompteEpargneDao(Connection connection) Constructeur avec un paramètre
     *
     * @param conn - COnnection représentant l'Objet Connection
     */
    public CompteEpargneDao(Connection conn) {
        super(conn);
        logger = LogManager.getLogger(this.getClass().getName());
    }

    @Override
    public Boolean create(CompteEpargne t) {
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
    public Boolean update(CompteEpargne t) {
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
    public Boolean delete(CompteEpargne t) {
        return true;
    }

    @Override
    public List<CompteEpargne> getAll() {
        List<CompteEpargne> compteEpargnes = null;
        CompteEpargne compteEpargne = null;
        try {
            ps = this.cnx.prepareStatement(readAllStatement);
            ResultSet rs = ps.executeQuery();
            compteEpargnes = new LinkedList<>();

            while (rs.next()) {
                compteEpargne = new CompteEpargne();
                compteEpargne.setNumeroCompte(rs.getString("num_compte"));
                compteEpargne.setSoldeCompte(rs.getDouble("solde_compte"));
                compteEpargne.setCodeClient(rs.getString("code_client"));
                compteEpargnes.add(compteEpargne);
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteEpargnes;
    }

    @Override
    public CompteEpargne find() {
        CompteEpargne compteEpargne = null;
        try {
            ps = this.cnx.prepareStatement(findLastStatement);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                compteEpargne = new CompteEpargne();
                compteEpargne.setNumeroCompte(rs.getString("num_compte"));
                compteEpargne.setSoldeCompte(rs.getDouble("solde_compte"));
                compteEpargne.setCodeClient(rs.getString("code_client"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteEpargne;
    }

    @Override
    public CompteEpargne findById(Integer id) {
        CompteEpargne compteEpargne = null;
        try {
            ps = this.cnx.prepareStatement(findByIdStatement);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compteEpargne = new CompteEpargne();
                compteEpargne.setNumeroCompte(rs.getString("num_compte"));
                compteEpargne.setSoldeCompte(rs.getDouble("solde_compte"));
                compteEpargne.setCodeClient(rs.getString("code_client"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteEpargne;
    }

    @Override
    public CompteEpargne findByNumCompteEpargne(String numCpteEpargne) {
        CompteEpargne compteEpargne = null;
        try {
            ps = this.cnx.prepareStatement(findByCpteEpargneSt);
            ps.setString(1, numCpteEpargne);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compteEpargne = new CompteEpargne();
                compteEpargne.setNumeroCompte(rs.getString("num_compte"));
                compteEpargne.setSoldeCompte(rs.getDouble("solde_compte"));
                compteEpargne.setCodeClient(rs.getString("code_client"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteEpargne;
    }

    @Override
    public List<CompteEpargne> findByCodeClient(String codeClient) {
        CompteEpargne compteEpargne = null;
        List<CompteEpargne> compteEpargnes = null;
        try {
            ps = this.cnx.prepareStatement(findBycode_clientSt);
            ps.setString(1, codeClient);
            ResultSet rs = ps.executeQuery();
            compteEpargnes = new LinkedList<>();

            while (rs.next()) {
                compteEpargne = new CompteEpargne();
                compteEpargne.setNumeroCompte(rs.getString("num_compte"));
                compteEpargne.setSoldeCompte(rs.getDouble("solde_compte"));
                compteEpargne.setCodeClient(rs.getString("code_client"));
                compteEpargnes.add(compteEpargne);
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return compteEpargnes;
    }
}
