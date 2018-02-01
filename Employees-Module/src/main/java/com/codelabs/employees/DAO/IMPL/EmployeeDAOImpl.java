/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.employees.DAO.IMPL;

import com.codelabs.core.DAO.IMPL.GenericDAOImpl;
import com.codelabs.employees.DAO.EmployeeDAO;
import com.codelabs.entity.Employees;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sd14d
 */
@Repository(value = "EmployeeDAO")
public class EmployeeDAOImpl extends GenericDAOImpl<Employees> implements EmployeeDAO {

}
