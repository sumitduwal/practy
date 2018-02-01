/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.customers.CONTROLLER;

import com.codelabs.customers.DTO.CustomerDTO;
import com.codelabs.customers.SERVICE.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author sd14d
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    private String index() {
        return "customers:index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<CustomerDTO> getAll() {
        return customerService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    private CustomerDTO save(CustomerDTO customerDTO) {
        return customerService.insert(customerDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    private String update(CustomerDTO customerDTO) {
        customerService.update(customerDTO);
        return "[response:\"success\"]";
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CustomerDTO getById(@PathVariable("id") int id) {
        return customerService.getById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        customerService.delete(id);
        return "[response:\"success\"]";
    }

}
