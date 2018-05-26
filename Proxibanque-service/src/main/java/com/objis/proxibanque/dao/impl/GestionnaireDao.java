/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao.impl;

import com.objis.proxibanque.dao.IGestionnaireDao;
import com.objis.proxibanque.domaine.Gestionnaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * Classe GestionnaireDao Classe implémentant l'interface IGestionnaireDao et
 * permettant d'eefectuer des traitements sur la Table Gestionnaire.
 *
 * @author yeo sglo
 */
public class GestionnaireDao extends DAO implements IGestionnaireDao {

    private final String createStatement = "insert into gestionnaire(code_gestionnaire,nom,prenom,email,adresse,login,password) values (?,?,?,?,?,?)";
    private final String readAllStatement = "select * from gestionnaire";
    private final String updateStatement = "update gestionnaire set code_gestionnaire=?, nom=?, prenom=?, email=?, adresse=?, login=?, password=? where id=?";
    private final String deleteStatement = "delete from gestionnaire where id=?";
    private final String findLastStatement = "select * from gestionnaire order by id desc";
    private final String findByIdStatement = "select * from gestionnaire where id=?";
    private final String findByCodeGestionnaire = "select * from gestionnaire  where code_gestionnaire =?";
    private final String findByUserStm = "select * from gestionnaire  where login =?";
    PreparedStatement ps;

    /**
     * GestionnaireDao(Connection connection) Constructeur avec un paramètre
     *
     * @param conn - COnnection représentant l'Objet Connection
     */
    public GestionnaireDao(Connection conn) {
        super(conn);
        this.logger = LogManager.getLogger(VirementDao.class.getName());
    }

    @Override
    public Boolean create(Gestionnaire t) {
        int test = -1;

        try {
            ps = this.cnx.prepareStatement(createStatement);
            ps.setString(1, t.getCodeGestionnaire());
            ps.setString(2, t.getNom());
            ps.setString(3, t.getPrenoms());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getAdresse());
            ps.setString(6, t.getLogin());
            ps.setString(7, t.getPassword());
            test = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return test > 0;
    }

    @Override
    public Boolean update(Gestionnaire t) {
        int test = -1;
        try {
            ps = this.cnx.prepareStatement(updateStatement);
            ps.setString(1, t.getCodeGestionnaire());
            ps.setString(2, t.getNom());
            ps.setString(3, t.getPrenoms());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getAdresse());
            ps.setString(6, t.getLogin());
            ps.setString(7, t.getPassword());
            test = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return test > 0;
    }

    @Override
    public Boolean delete(Gestionnaire t) {
        int test = -1;
        try {
            ps = this.cnx.prepareStatement(deleteStatement);
            ps.setLong(1, t.getId());
            test = ps.executeUpdate();

        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }

        return test > 0;
    }

    @Override
    public List<Gestionnaire> getAll() {
        List<Gestionnaire> gestionnaires = null;
        Gestionnaire gestionnaire = null;
        try {
            ps = this.cnx.prepareStatement(readAllStatement);
            ResultSet rs = ps.executeQuery();
            gestionnaires = new LinkedList<>();

            while (rs.next()) {
                gestionnaire = new Gestionnaire();
                gestionnaire.setCodeGestionnaire(rs.getString("code_gestionnaire"));
                gestionnaire.setNom(rs.getString("nom"));
                gestionnaire.setPrenoms(rs.getString("prenom"));
                gestionnaire.setEmail(rs.getString("email"));
                gestionnaire.setAdresse(rs.getString("adresse"));
                gestionnaire.setLogin(rs.getString("login"));
                gestionnaire.setPassword(rs.getString("password"));
                gestionnaires.add(gestionnaire);
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return gestionnaires;
    }

    @Override
    public Gestionnaire find() {
        Gestionnaire gestionnaire = null;
        try {
            ps = this.cnx.prepareStatement(findLastStatement);
            ResultSet rs = ps.executeQuery();

                gestionnaire = new Gestionnaire();
            if (rs.first()) {
                gestionnaire.setCodeGestionnaire(rs.getString("code_gestionnaire"));
                gestionnaire.setNom(rs.getString("nom"));
                gestionnaire.setPrenoms(rs.getString("prenom"));
                gestionnaire.setEmail(rs.getString("email"));
                gestionnaire.setAdresse(rs.getString("adresse"));
                gestionnaire.setLogin(rs.getString("login"));
                gestionnaire.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return gestionnaire;
    }

    @Override
    public Gestionnaire findById(Integer val) {
        Gestionnaire gestionnaire = null;
        try {
            ps = this.cnx.prepareStatement(findByIdStatement);
            ps.setLong(1, val);
            ResultSet rs = ps.executeQuery();

                gestionnaire = new Gestionnaire();
            while (rs.next()) {
                gestionnaire.setCodeGestionnaire(rs.getString("code_gestionnaire"));
                gestionnaire.setNom(rs.getString("nom"));
                gestionnaire.setPrenoms(rs.getString("prenom"));
                gestionnaire.setEmail(rs.getString("email"));
                gestionnaire.setAdresse(rs.getString("adresse"));
                gestionnaire.setLogin(rs.getString("login"));
                gestionnaire.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return gestionnaire;
    }

    @Override
    public Gestionnaire findByCodeGestionnaire(String codeGestionnaire) {
        Gestionnaire gestionnaire = null;
        try {
            ps = this.cnx.prepareStatement(findByIdStatement);
            ps.setString(1, codeGestionnaire);
            ResultSet rs = ps.executeQuery();

            gestionnaire = new Gestionnaire();
            while (rs.next()) {
                gestionnaire.setCodeGestionnaire(rs.getString("code_gestionnaire"));
                gestionnaire.setNom(rs.getString("nom"));
                gestionnaire.setPrenoms(rs.getString("prenom"));
                gestionnaire.setEmail(rs.getString("email"));
                gestionnaire.setAdresse(rs.getString("adresse"));
                gestionnaire.setLogin(rs.getString("login"));
                gestionnaire.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return gestionnaire;
    }

    @Override
    public Gestionnaire findByUsername(String login) {
        Gestionnaire gestionnaire = null;

        try {
            ps = this.cnx.prepareStatement(findByUserStm);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            gestionnaire = new Gestionnaire();
            while (rs.next()) {
                gestionnaire.setCodeGestionnaire(rs.getString("code_gestionnaire"));
                gestionnaire.setNom(rs.getString("nom"));
                gestionnaire.setPrenoms(rs.getString("prenom"));
                gestionnaire.setEmail(rs.getString("email"));
                gestionnaire.setAdresse(rs.getString("adresse"));
                gestionnaire.setLogin(rs.getString("login"));
                gestionnaire.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return gestionnaire;
    }
}
