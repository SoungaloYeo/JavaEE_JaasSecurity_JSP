/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service.impl;

import com.objis.proxibanque.dao.IVirementDao;
import com.objis.proxibanque.dao.impl.VirementDao;
import com.objis.proxibanque.domaine.Compte;
import com.objis.proxibanque.domaine.CompteCourant;
import com.objis.proxibanque.domaine.CompteEpargne;
import com.objis.proxibanque.domaine.Virement;
import com.objis.proxibanque.service.ICompteCourantService;
import com.objis.proxibanque.service.ICompteEpargneService;
import com.objis.proxibanque.service.ICompteService;
import com.objis.proxibanque.service.IVirementService;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Achi Blay Kevin C. 
 */
public class VirementService extends Service implements IVirementService {

    private IVirementDao virementDao;
    private ICompteCourantService courantService;
    private ICompteEpargneService epargneService;
    private ICompteService compteService;
    ICompteCourantService compteCourantService = null;
    ICompteEpargneService compteEpargneService = null;
    private static final String INDICE = "PB-V-";

    public VirementService(Connection connection) {
        super(connection);
        this.logger = LogManager.getLogger(VirementService.class.getName());
    }

    @Override
    public boolean effectuerVirement(Virement virement) {
        boolean result = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy'-'hh:mm:ss");

        if (virement != null) {
            compteService = new CompteService(connection);
            Compte compteEm = compteService.findCompteByNumCompte(virement.getNumCompteEmetteur());
            Compte compteBe = compteService.findCompteByNumCompte(virement.getNumCompteBeneficiaire());

            if (compteBe != null && compteEm != null
                    && virement.getMontant() < compteEm.getSoldeCompte()) {
                virement.setCodeVirement(String.valueOf(dateFormat.format(new Date())));

                double soldeEm = compteEm.getSoldeCompte() - virement.getMontant();
                double soldeBe = compteBe.getSoldeCompte() + virement.getMontant();

                this.miseJourCompte(compteEm, compteBe, soldeEm, soldeBe);

                this.create(virement);
                this.logger.info("[REUSSI] NOUVEAU VIREMENT == [COMPTE EMETTEUR:"
                        + virement.getNumCompteEmetteur() + "] == [COMPTE BENEFICIAIRE:" + virement.getNumCompteBeneficiaire() + "]", Level.INFO);
                result = true;
            } else {
                this.logger.info("[ECHEC] NOUVEAU VIREMENT == [COMPTE EMETTEUR:"
                        + virement.getNumCompteEmetteur() + "] == [COMPTE BENEFICIAIRE:" + virement.getNumCompteBeneficiaire() + "]", Level.WARN);
                result = false;
            }

        } else {
            this.logger.info("[ECHEC] NOUVEAU VIREMENT ==", Level.WARN);
            result = false;
        }

        return result;
    }

    @Override
    public boolean create(Virement t) {
        logger.info("== CREER VIREMENT ==", Level.INFO);
        virementDao = new VirementDao(connection);
        return virementDao.create(t);
    }

    private boolean miseJourCompte(Compte em, Compte be, double mem, double mbe) {
        boolean result = true;
        compteCourantService = new CompteCourantService(connection);
        compteEpargneService = new CompteEpargneService(connection);

        em.setSoldeCompte(mem);
        be.setSoldeCompte(mbe);

        if (em instanceof CompteCourant) {
            compteCourantService.update((CompteCourant) em);
        } else {
            compteEpargneService.update((CompteEpargne) em);
        }

        if (be instanceof CompteEpargne) {
            compteEpargneService.update((CompteEpargne) be);
        } else {
            compteCourantService.update((CompteCourant) be);
        }

        return result;
    }
}
