/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aayush.web.dao;

import java.util.List;

/**
 *
 * @author dell
 */
public interface GenericDAO<T> {
    List<T> getAll();
    T getById (int id);
    int insert(T model);
}
