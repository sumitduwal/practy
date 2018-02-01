/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.items.DAO.Impl;

import com.codelabs.core.DAO.IMPL.GenericDAOImpl;
import com.codelabs.entity.Items;
import com.codelabs.items.DAO.ItemsDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sd14d
 */
@Repository(value = "ItemsDAO")
public class ItemsDAOImpl extends GenericDAOImpl<Items> implements ItemsDAO{
    
}
