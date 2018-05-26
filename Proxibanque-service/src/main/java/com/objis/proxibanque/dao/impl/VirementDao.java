/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao.impl;

import com.objis.proxibanque.dao.IVirementDao;
import com.objis.proxibanque.domaine.Virement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * Classe VirementDao Cette classe implémente l'interface IVirementDao et permet
 * d'éffectuer des traitements au niveau de la Table Virement.
 *
 * @author yeo sglo
 */
public class VirementDao extends DAO implements IVirementDao {

    private final String createStatement = "insert into virement(code_virement, montant, num_compte_e, num_compte_b) values (?,?,?,?)";
    PreparedStatement ps;

    /**
     * VirementDao(Connection connection) Constructeur avec un paramètre
     * Connection
     *
     * @param conn - Connection représentant l'Objet Connection
     */
    public VirementDao(Connection conn) {
        super(conn);
        this.logger = LogManager.getLogger(VirementDao.class.getName());
    }

    @Override
    public boolean create(Virement v) {
        int test = -1;
        try {
            ps = this.cnx.prepareStatement(createStatement);
            ps.setString(1, v.getCodeVirement());
            ps.setDouble(2, v.getMontant());
            ps.setString(3, v.getNumCompteEmetteur());
            ps.setString(4, v.getNumCompteBeneficiaire());

            test = ps.executeUpdate();
        } catch (SQLException ex) {
            logger.warn(Level.WARN, ex);
        }
        return test > 0;
    }
}
