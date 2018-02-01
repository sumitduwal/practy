/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.employees.SERVICE.IMPL;

import com.codelabs.employees.DAO.EmployeeDAO;
import com.codelabs.employees.DTO.EmployeeDTO;
import com.codelabs.employees.SERVICE.EmployeeService;
import com.codelabs.entity.Employees;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "EmployeeService")
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDAO employeeDAO;
    
    
    @Override
    public List<EmployeeDTO> getAll() {
             List<EmployeeDTO> employeeDTO = new ArrayList<>();
             for(Employees employees :employeeDAO.getAll()){
             EmployeeDTO edto = new EmployeeDTO();
             edto.setId(employees.getId());
             edto.setFirstName(employees.getFirstName());
             edto.setEmail(employees.getEmail());
             edto.setLastName(employees.getLastName());
             edto.setAddress(employees.getAddress());
             edto.setPhNo(employees.getPhNo());
             edto.setJoinedDate(employees.getJoinedDate());
             edto.setCreatedDate(employees.getCreatedDate());
             edto.setModifiedDate(employees.getModifiedDate());
             edto.setStatus(employees.getStatus());
             
             employeeDTO.add(edto);
            
             
             
             }
              return employeeDTO;
    }
    

    @Override
    public EmployeeDTO insert(EmployeeDTO employeeDTO) {
           Employees emp = new Employees();
           emp.setId(employeeDTO.getId());
           emp.setFirstName(employeeDTO.getFirstName());
           emp.setEmail(employeeDTO.getEmail());
           emp.setLastName(employeeDTO.getLastName());
           emp.setAddress(employeeDTO.getAddress());
           emp.setPhNo(employeeDTO.getPhNo());
           emp.setJoinedDate(employeeDTO.getJoinedDate());
      
           emp.setStatus(employeeDTO.getStatus());
           
           employeeDAO.insert(emp);
           
           return employeeDTO;
           
    }

    @Override
    public void delete(int id) {
      employeeDAO.delete(id);

    }

    @Override
    public void update(EmployeeDTO employeeDTO) {
        Employees emp = employeeDAO.getById(employeeDTO.getId());
        
        emp.setFirstName(employeeDTO.getFirstName());
        emp.setEmail(employeeDTO.getEmail());
        emp.setLastName(employeeDTO.getLastName());
        emp.setAddress(employeeDTO.getAddress());
        emp.setJoinedDate(employeeDTO.getJoinedDate());
        emp.setPhNo(emp.getPhNo());
        emp.setModifiedDate(new Date());
        emp.setStatus(emp.getStatus());
        employeeDAO.update(emp);
        
    }

    @Override
    public EmployeeDTO getById(int id) {
        Employees emp = employeeDAO.getById(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(emp.getId());
        employeeDTO.setFirstName(emp.getFirstName());
        employeeDTO.setEmail(emp.getEmail());
        employeeDTO.setLastName(emp.getLastName());
        employeeDTO.setAddress(emp.getAddress());
        employeeDTO.setPhNo(emp.getPhNo());
        employeeDTO.setJoinedDate(emp.getJoinedDate());
        employeeDTO.setCreatedDate(emp.getCreatedDate());
        employeeDTO.setModifiedDate(emp.getModifiedDate());
        employeeDTO.setStatus(emp.getStatus());
        
        return employeeDTO;
        

    }
    
}
