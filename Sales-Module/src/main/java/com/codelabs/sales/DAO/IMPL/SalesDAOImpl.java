/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.sales.DAO.IMPL;

import com.codelabs.core.DAO.IMPL.GenericDAOImpl;
import com.codelabs.entity.Sales;
import com.codelabs.sales.DAO.SalesDAO;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sd14d
 */
@Repository(value = "SalesDAO")
public class SalesDAOImpl extends GenericDAOImpl<Sales> implements SalesDAO{
    
}
