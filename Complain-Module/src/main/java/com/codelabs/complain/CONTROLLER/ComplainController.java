/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.complain.CONTROLLER;

import com.codelabs.complain.DTO.ComplainDTO;
import com.codelabs.complain.Service.ComplainService;
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
@RequestMapping(value = "/complains")

public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    private String index() {
        return "complain:index";
    }
    
     @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<ComplainDTO> getAll() {
        return complainService.getAll();
    }
     @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    private ComplainDTO save(ComplainDTO complainDTO) {
        return complainService.insert(complainDTO);
    }
     @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ComplainDTO getById(@PathVariable("id") int id) {
        return complainService.getById(id);

    }
     @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        complainService.delete(id);
        return "[response:\"success\"]";
    }
}
