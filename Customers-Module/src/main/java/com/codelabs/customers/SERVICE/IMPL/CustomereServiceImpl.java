/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.customers.SERVICE.IMPL;

import com.codelabs.customers.DAO.CustomerDAO;
import com.codelabs.customers.DTO.CustomerDTO;
import com.codelabs.customers.SERVICE.CustomerService;
import com.codelabs.entity.Customers;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "CustomerService")
public class CustomereServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public List<CustomerDTO> getAll() {
        List<CustomerDTO> customerDTO = new ArrayList<>();
        for (Customers customers : customerDAO.getAll()) {
            CustomerDTO cdto = new CustomerDTO();
            cdto.setId(customers.getId());
            cdto.setFirstName(customers.getFirstName());
            cdto.setLastName(customers.getLastName());
            cdto.setEmail(customers.getEmail());
            cdto.setPhNo(customers.getPhNo());
            cdto.setAddress(customers.getAddress());
            cdto.setCreatedDate(customers.getCreatedDate());
            cdto.setModifiedDate(customers.getModifiedDate());

             customerDTO.add(cdto);
        }
        return customerDTO;
    }

    @Override
    public CustomerDTO insert(CustomerDTO customerDTO) {
        Customers customers = new Customers();
        customers.setId(customerDTO.getId());
        customers.setFirstName(customerDTO.getFirstName());
        customers.setEmail(customerDTO.getEmail());
        customers.setLastName(customerDTO.getLastName());
        customers.setAddress(customerDTO.getAddress());
        customers.setPhNo(customerDTO.getPhNo());
         
        customerDAO.insert(customers);
       
        return customerDTO;

    }

    @Override
    public void delete(int id) {
        customerDAO.delete(id);

    }

    @Override
    public void update(CustomerDTO customerDTO) {
        Customers customers = customerDAO.getById(customerDTO.getId());

        customers.setFirstName(customerDTO.getFirstName());
        customers.setEmail(customerDTO.getEmail());
        customers.setLastName(customerDTO.getLastName());
        customers.setAddress(customerDTO.getAddress());

        customers.setPhNo(customerDTO.getPhNo());
        customers.setModifiedDate(new Date());
        customerDAO.update(customers);

    }

    @Override
    public CustomerDTO getById(int id) {
        Customers customers = customerDAO.getById(id);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customers.getId());
        customerDTO.setFirstName(customers.getFirstName());
        customerDTO.setEmail(customers.getEmail());
        customerDTO.setLastName(customers.getLastName());
        customerDTO.setAddress(customers.getAddress());
        customerDTO.setPhNo(customers.getPhNo());
        customerDTO.setCreatedDate(customers.getCreatedDate());
        customerDTO.setModifiedDate(customers.getModifiedDate());

        return customerDTO;

    }

}
