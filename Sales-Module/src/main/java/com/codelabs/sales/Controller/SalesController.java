/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.sales.Controller;

import com.codelabs.sales.DTO.SalesDTO;
import com.codelabs.sales.SERVICE.SalesService;
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
@RequestMapping(value = "/sales")

public class SalesController {

    @Autowired
    private SalesService salesService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    private String index() {
        return "sales:index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<SalesDTO> getAll() {
        return salesService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    private SalesDTO save(SalesDTO salesDTO) {
        return salesService.insert(salesDTO);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SalesDTO getById(@PathVariable("id") int id) {
        return salesService.getById(id);

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        salesService.delete(id);
        return "[response:\"success\"]";
    }
}
