/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.customers.DAO.IMPL;

import com.codelabs.core.DAO.IMPL.GenericDAOImpl;
import com.codelabs.customers.DAO.CustomerDAO;
import com.codelabs.entity.Customers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sd14d
 */
@Repository(value = "CustomerDAO")
public class CustomerDAOImpl  extends GenericDAOImpl<Customers> implements CustomerDAO{
   
}
