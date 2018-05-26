
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service.impl;

import com.objis.proxibanque.domaine.Compte;
import com.objis.proxibanque.domaine.CompteCourant;
import com.objis.proxibanque.domaine.CompteEpargne;
import com.objis.proxibanque.service.ICompteCourantService;
import com.objis.proxibanque.service.ICompteEpargneService;
import com.objis.proxibanque.service.ICompteService;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

/**
 * Classe CompteService Cette Classe implémente l'interface ICompteService et
 * permet d'effectuer des traitements surles Objets de notre POJO CompteCourant
 * et CompteEpargne.
 *
 * @author Achi Blay Kevin C. 
 */
public class CompteService extends Service implements ICompteService {

    private CompteCourant cc;
    private CompteEpargne ce;

    private ICompteCourantService courantService;
    private ICompteEpargneService epargneService;

    /**
     * CompteService(Connection connection) Constructeur avec paramètre
     * Connection.
     *
     * @param connection - Connection représentant l'Objet Connection
     */
    public CompteService(Connection connection) {
        super(connection);
        this.logger = LogManager.getLogger(CompteService.class.getName());
    }

    @Override
    public List<Compte> listerComptes(String codeClient) {
        List<Compte> result = null;

        if (codeClient != null) {
            result = new ArrayList<>();

            courantService = new CompteCourantService(connection);
            result.add(courantService.findByCodeClient(codeClient));

            epargneService = new CompteEpargneService(connection);
            List<CompteEpargne> compteEpargnes = epargneService.findByCodeClient(codeClient);
            for (CompteEpargne ce : compteEpargnes) {
                result.add(ce);
            }
        }
        this.logger.info((result != null ? "[REUSSI]" : "[ECHEC]") + " LISTER COMPTES CLIENT == [CODECLIENT:" + codeClient + "] == ", Level.INFO);
        return result;
    }

    @Override
    public Compte findCompteByNumCompte(String numCompte) {
        Compte result = null;

        if (numCompte != null) {

            switch (numCompte.charAt(4)) {
                case 'E':
                    epargneService = new CompteEpargneService(connection);
                    result = epargneService.findByCompteEpargne(numCompte);
                    break;
                case 'C':
                    courantService = new CompteCourantService(connection);
                    result = courantService.findByNumCompteCourant(numCompte);
                    break;
                default:
                    result = null;
                    break;
            }
        }

        return result;
    }

    @Override
    public Double findSoldeByNumCompte(String numCompte) {
        Compte compte = findCompteByNumCompte(numCompte);
        double solde = compte.getSoldeCompte();
        this.logger.info("[RESULTAT SOLDE DU COMPTE OBTENU AVEC SUCCES] soit " + compte.getSoldeCompte() + " == ", Level.INFO);

        return solde;
    }

    @Override
    public ArrayList<String> tousLesComptes() {
        ArrayList<String> tousComptes = new ArrayList<>();
        epargneService = new CompteEpargneService(connection);
        for (CompteEpargne cpte : epargneService.findAll()) {
            tousComptes.add(cpte.getNumeroCompte());
        }
        courantService = new CompteCourantService(connection);
        for (CompteCourant cpte : courantService.findAll()) {
            tousComptes.add(cpte.getNumeroCompte());
        }

        return tousComptes;
    }

}
