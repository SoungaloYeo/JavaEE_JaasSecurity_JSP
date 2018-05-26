/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.dao;

import java.util.List;

/**
 * Interface IDao L'interface IDao propose des Méthodes basiques de CRUD pour
 * éffectuer des traitements sur les Tables représentants les classes de notre
 * Domaine.
 *
 * @author yeo sglo
 * @param <T>
 */
public interface IDao<T> {

    /**
     * Méthode Abstraite create(T t). Elle permet d'effectuer une
     * création(sauvegarde) de l'objet en question.
     *
     * @param t - Objet a crée au niveau de la base de données
     * @return - true ou false
     */
    public Boolean create(T t);

    /**
     * Méthode Abstraite update(T t). Elle permet d'effectuer une mise à
     * jour(sauvegarde) de l'objet en question.
     *
     * @param t - Objet a mettre à jour au niveau de la base de données
     * @return - true ou false
     */
    public Boolean update(T t);

    /**
     * Méthode Abstraite delet(T t). Elle permet d'effectuer une
     * création(sauvegarde) de l'objet en question.
     *
     * @param t - Objet a supprimé de la base de données
     * @return - true ou false
     */
    public Boolean delete(T t);

    /**
     * Méthode Abstraite getAll(). Elle permet de récupérer tous les
     * enregistrements de la base de donnnées.
     *
     * @return - List du parametre T ou null
     */
    public List<T> getAll();

    /**
     * Méthode Abstraite find(). Elle permet d'effectuer une recherche de
     * l'objet enregistré en dernière position.
     *
     * @return - T ou null
     */
    public T find();

    /**
     * Méthode Abstraite findById(int val). Elle permet d'effectuer une
     * recherche d'un objet en question.
     *
     * @param val - Id Identifiant d'un Objet
     * @return - true ou false
     */
    public T findById(Integer val);
}
