/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.objis.proxibanque.service;

import java.util.List;

/**
 * INterface IService Elle fournit des méthodes abstraites permettant d'effetuer
 * des traitements de CRUD.
 *
 * @author Achi Blay Kevin C. 
 * @param <T>
 */
public interface IService<T> {

    /**
     * create(T t) Elle permet de créer un élément T
     *
     * @param t - Objet
     * @return - true ou false
     */
    public boolean create(T t);

    /**
     * update(T t) Elle permet de mettre à jour un élément T
     *
     * @param t - Objet
     * @return - true ou false
     */
    public boolean update(T t);

    /**
     * delete(T t) Elle permet de supprimer un élément T
     *
     * @param t - Objet
     * @return - true ou false
     */
    public boolean delete(T t);

    /**
     * findById(T t) Elle permet de rechercher un élément T
     *
     * @param id - Entier representant l'Id
     * @return - T ou null
     */
    public T findById(int id);

    /**
     * findAll() Elle permet de rechercher un ensemble d'élément T.
     *
     * @return - Liste de l'objet passé en parametre (T) ou null
     */
    public List<T> findAll();
}
