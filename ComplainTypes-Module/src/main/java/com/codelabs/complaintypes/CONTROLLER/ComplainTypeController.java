/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.complaintypes.CONTROLLER;

import com.codelabs.complaintypes.DTO.ComplainTypesDTO;
import com.codelabs.complaintypes.SERVICE.ComplainTypeService;
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
@RequestMapping(value = "/complainType")
public class ComplainTypeController {

    @Autowired
    private ComplainTypeService complainTypeService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    private String index() {
        return "complainTypes:index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<ComplainTypesDTO> getAll() {
        return complainTypeService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    private ComplainTypesDTO save(ComplainTypesDTO complainTypesDTO) {
        return complainTypeService.insert(complainTypesDTO);
    }
     @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    private String update(ComplainTypesDTO complainTypesDTO) {
        complainTypeService.update(complainTypesDTO);
        return "[response:\"success\"]";
    }
      @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ComplainTypesDTO getById(@PathVariable("id") int id) {
        return complainTypeService.getById(id);
    }
     @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        complainTypeService.delete(id);
        return "[response:\"success\"]";
    }
}
