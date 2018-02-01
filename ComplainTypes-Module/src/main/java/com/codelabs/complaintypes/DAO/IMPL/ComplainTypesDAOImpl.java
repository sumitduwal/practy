/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.complaintypes.DAO.IMPL;

import com.codelabs.complaintypes.DAO.ComplainTypeDAO;
import com.codelabs.core.DAO.IMPL.GenericDAOImpl;
import com.codelabs.entity.ComplaintTypes;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sd14d
 */
@Repository(value = "ComplainTypeDAO")
public class ComplainTypesDAOImpl extends GenericDAOImpl<ComplaintTypes> implements ComplainTypeDAO{
    
    
}
