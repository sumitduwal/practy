/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.stock.DAO.IMPL;

import com.codelabs.core.DAO.IMPL.GenericDAOImpl;
import com.codelabs.entity.Stocks;
import com.codelabs.stock.DAO.StockDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sd14d
 */
@Repository(value = "/StockDAO")
public class StockDAOImpl extends GenericDAOImpl<Stocks> implements StockDAO{
    
}
