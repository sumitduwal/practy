/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.employees.CONTROLLER;

import com.codelabs.employees.DTO.EmployeeDTO;
import com.codelabs.employees.SERVICE.EmployeeService;
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
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    private String index() {
        return "employees:index";
    }
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<EmployeeDTO> getAll() {
        return employeeService.getAll();
    }
 @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    private EmployeeDTO save(EmployeeDTO employeeDTO) {
        return employeeService.insert(employeeDTO);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    private String update(EmployeeDTO employeeDTO) {
        employeeService.update(employeeDTO);
        return "[response:\"success\"]";
    }
    
     @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public EmployeeDTO getById(@PathVariable("id") int id) {
        return employeeService.getById(id);
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "[response:\"success\"]";
    }
}
