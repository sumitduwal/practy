/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.items.SERVICE.IMPL;

import com.codelabs.entity.Items;
import com.codelabs.items.DAO.ItemsDAO;
import com.codelabs.items.DTO.ItemsDTO;
import com.codelabs.items.SERVICE.ItemsService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "ItemsService")
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    ItemsDAO itemsDAO;

    @Override
    public List<ItemsDTO> getAll() {
        List<ItemsDTO> itemsDTO = new ArrayList<>();
        for (Items items : itemsDAO.getAll()) {
            ItemsDTO itmDTO = new ItemsDTO();
            itmDTO.setId(items.getId());
            itmDTO.setCompanyName(items.getCompanyName());
            itmDTO.setModelNo(items.getModelNo());
            itmDTO.setManfacturedNo(items.getManfacturedNo());
            itmDTO.setPrice(items.getPrice());
            itmDTO.setCreatedDate(items.getCreatedDate());
            itmDTO.setModifiedDate(items.getModifiedDate());

            itemsDTO.add(itmDTO);
        }
        return itemsDTO;
    }

    @Override
    public ItemsDTO insert(ItemsDTO itemsDTO) {
        Items items = new Items();
        items.setId(itemsDTO.getId());
        items.setItemName(itemsDTO.getItemName());
        items.setCompanyName(itemsDTO.getCompanyName());
        items.setModelNo(itemsDTO.getModelNo());
        items.setManfacturedNo(itemsDTO.getManfacturedNo());
        items.setPrice(itemsDTO.getPrice());

        itemsDAO.insert(items);

        return itemsDTO;
    }

    @Override
    public void delete(int id) {
        itemsDAO.delete(id);
    }

    @Override
    public void update(ItemsDTO itemsDTO) {
        Items items = itemsDAO.getById(itemsDTO.getId());

        items.setItemName(itemsDTO.getItemName());
        items.setCompanyName(itemsDTO.getCompanyName());
        items.setModelNo(itemsDTO.getModelNo());
        items.setManfacturedNo(itemsDTO.getManfacturedNo());
        items.setPrice(itemsDTO.getPrice());
        items.setModifiedDate(new Date());
        itemsDAO.update(items);

    }

    @Override
    public ItemsDTO getById(int id) {

        Items items = itemsDAO.getById(id);
        ItemsDTO itemsDTO = new ItemsDTO();
        itemsDTO.setId(items.getId());
        itemsDTO.setItemName(items.getItemName());
        itemsDTO.setCompanyName(items.getCompanyName());
        itemsDTO.setModelNo(items.getModelNo());
        itemsDTO.setManfacturedNo(items.getManfacturedNo());
        itemsDTO.setPrice(items.getPrice());
        itemsDTO.setCreatedDate(items.getCreatedDate());
        itemsDTO.setModifiedDate(items.getModifiedDate());

        return itemsDTO;
    }

}
