/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.items.CONTROLLER;

import com.codelabs.items.DTO.ItemsDTO;
import com.codelabs.items.SERVICE.ItemsService;
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
@RequestMapping(value = "/items")
public class ItemsController {
    
      @Autowired
    private ItemsService itemsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    private String index() {
        return "items:index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemsDTO> getAll() {
        return itemsService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    private ItemsDTO save(ItemsDTO itemsDTO) {
        return itemsService.insert(itemsDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    private String update(ItemsDTO itemsDTO) {
        itemsService.update(itemsDTO);
        return "[response:\"success\"]";
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ItemsDTO getById(@PathVariable("id") int id) {
        return itemsService.getById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable("id") int id) {
        itemsService.delete(id);
        return "[response:\"success\"]";
    }

    
}
