/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.complain.DAO.IMPL;

import com.codelabs.complain.DAO.ComplainDAO;
import com.codelabs.core.DAO.IMPL.GenericDAOImpl;
import com.codelabs.entity.Complaints;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sd14d
 */
@Repository(value="ComplainDAO")
public class ComplainDAOImpl extends GenericDAOImpl<Complaints> implements ComplainDAO{
    
}
