/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.core.SERVICE;

import java.util.List;

/**
 *
 * @author sd14d
 */
public interface GenericService<T>{ List<T> getAll();

    T insert(T t);

    void delete(int id);

    void update(T t);

    T getById(int id);
   
    
}
