/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao.impl;

import com.objis.proxibanque.dao.IClientDao;
import com.objis.proxibanque.domaine.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * Classe ClientDao Classe implémentant l'interface IClientDao permettant
 * d'effectuer des traitements au niveau de la table Client.
 *
 * @author yeo sglo
 */
public class ClientDao extends DAO implements IClientDao {

    private final String createStatement = "insert into client(code_client,nom,prenom,email,adresse,code_gestionnaire) values (?,?,?,?,?,?)";
    private final String readAllStatement = "select * from client";
    private final String updateStatement = "update client set nom=?, prenom=?, email=?, adresse=? where code_client=?";
    private final String deleteStatement = "delete from client where id=?";
    private final String findLastStatement = "select * from client order by id desc";
    private final String findByIdStatement = "select * from client where id=?";
    private final String findByCodeGestionnaire = "select * from client where code_gestionnaire =?";
    private final String findByCodeClientStatement = "select * from client where code_client =?";
    PreparedStatement ps;

    /**
     * Construteur ClientDao(Connection connection) Constructeur avec un
     * paramètre Connection
     *
     * @param conn - Conection représentant la Connection
     */
    public ClientDao(Connection conn) {
        super(conn);
        this.logger = LogManager.getLogger(ClientDao.class.getName());
    }

    @Override
    public Boolean create(Client t) {
        int test = -1;

        try {
            ps = this.cnx.prepareStatement(createStatement);
            ps.setString(1, t.getCodeClient());
            ps.setString(2, t.getNom());
            ps.setString(3, t.getPrenoms());
            ps.setString(4, t.getEmail());
            ps.setString(5, t.getAdresse());
            ps.setString(6, t.getCodeGestionnaire());
            test = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return test > 0;
    }

    @Override
    public Boolean update(Client t) {
        int test = -1;
        try {
            ps = this.cnx.prepareStatement(updateStatement);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getPrenoms());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getAdresse());
            ps.setString(5, t.getCodeClient());
            test = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return test > 0;
    }

//"update client set nom=?, prenom=?, email=?, adresse=? where code_client=?";

    @Override
    public Boolean delete(Client t) {
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
    public List<Client> getAll() {
        List<Client> clients = null;
        try {
            ps = this.cnx.prepareStatement(readAllStatement);
            ResultSet rs = ps.executeQuery();
            clients = new LinkedList<>();

            while (rs.next()) {
                Client client = new Client();
                client.setCodeClient(rs.getString("code_client"));
                client.setNom(rs.getString("nom"));
                client.setPrenoms(rs.getString("prenom"));
                client.setEmail(rs.getString("email"));
                client.setAdresse(rs.getString("adresse"));
                client.setCodeGestionnaire(rs.getString("code_gestionnaire"));
                clients.add(client);
            }
            logger.info("////////////// recuperation de tous les clients du gestionnaire connect////////");
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return clients;
    }

    @Override
    public Client find() {
        Client client = null;
        try {
            ps = this.cnx.prepareStatement(findLastStatement);
            ResultSet rs = ps.executeQuery();

            if (rs.first()) {
                client = new Client();
                client.setCodeClient(rs.getString("code_client"));
                client.setNom(rs.getString("nom"));
                client.setPrenoms(rs.getString("prenom"));
                client.setEmail(rs.getString("email"));
                client.setAdresse(rs.getString("adresse"));
                client.setCodeGestionnaire(rs.getString("code_gestionnaire"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return client;
    }

    @Override
    public Client findById(Integer val) {
        Client client = null;
        try {
            ps = this.cnx.prepareStatement(findByIdStatement);
            ps.setLong(1, val);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                client = new Client();
                client.setCodeClient(rs.getString("code_client"));
                client.setNom(rs.getString("nom"));
                client.setPrenoms(rs.getString("prenom"));
                client.setEmail(rs.getString("email"));
                client.setAdresse(rs.getString("adresse"));
                client.setCodeGestionnaire(rs.getString("code_gestionnaire"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return client;
    }

    @Override
    public List<Client> findByCodeGestionnaire(String codeGestionnaire) {
        List<Client> clients = null;
        Client client = null;
        try {
            ps = this.cnx.prepareStatement(findByCodeGestionnaire);
            ps.setString(1, codeGestionnaire);
            ResultSet rs = ps.executeQuery();
            clients = new LinkedList<>();

            while (rs.next()) {
                client = new Client();
                client.setCodeClient(rs.getString("code_client"));
                client.setNom(rs.getString("nom"));
                client.setPrenoms(rs.getString("prenom"));
                client.setEmail(rs.getString("email"));
                client.setAdresse(rs.getString("adresse"));
                client.setCodeGestionnaire(rs.getString("code_gestionnaire"));
                clients.add(client);
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return clients;
    }

    @Override
    public Client findByCodeClient(String codeClient) {
        Client client = null;
        try {
            ps = this.cnx.prepareStatement(findByCodeClientStatement);
            ps.setString(1, codeClient);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                client = new Client();
                client.setCodeClient(rs.getString("code_client"));
                client.setNom(rs.getString("nom"));
                client.setPrenoms(rs.getString("prenom"));
                client.setEmail(rs.getString("email"));
                client.setAdresse(rs.getString("adresse"));
                client.setCodeGestionnaire(rs.getString("code_gestionnaire"));
            }
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return client;
    }

}
