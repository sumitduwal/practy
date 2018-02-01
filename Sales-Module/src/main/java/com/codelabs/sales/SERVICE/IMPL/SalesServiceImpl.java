/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.sales.SERVICE.IMPL;

import com.codelabs.customers.DTO.CustomerDTO;
import com.codelabs.entity.Customers;
import com.codelabs.entity.Items;
import com.codelabs.entity.Sales;
import com.codelabs.items.DTO.ItemsDTO;
import com.codelabs.sales.DAO.SalesDAO;
import com.codelabs.sales.DTO.SalesDTO;
import com.codelabs.sales.SERVICE.SalesService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "SalesService")
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesDAO salesDAO;

    @Override
    
    public List<SalesDTO> getAll() {
        List<SalesDTO> salesDTO = new ArrayList<>();
        for (Sales sales : salesDAO.getAll()) {
            SalesDTO sDTO = new SalesDTO();
            sDTO.setId(sales.getId());
            sDTO.setSaleDate(sales.getSaleDate());
            sDTO.setWarranty(sales.getWarranty());
            sDTO.setSellingPrice(sales.getSellingPrice());

            //customers
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(sales.getCustomerId().getId());
            customerDTO.setFirstName(sales.getCustomerId().getFirstName());
            customerDTO.setLastName(sales.getCustomerId().getLastName());
            customerDTO.setEmail(sales.getCustomerId().getEmail());
            customerDTO.setPhNo(sales.getCustomerId().getPhNo());
            customerDTO.setAddress(sales.getCustomerId().getAddress());

            sDTO.setCustomer(customerDTO);

            //items
            ItemsDTO itemsDTO = new ItemsDTO();
            itemsDTO.setId(sales.getItemId().getId());
            itemsDTO.setItemName(sales.getItemId().getItemName());
            itemsDTO.setCompanyName(sales.getItemId().getCompanyName());
            itemsDTO.setModelNo(sales.getItemId().getModelNo());
            itemsDTO.setManfacturedNo(sales.getItemId().getManfacturedNo());
            itemsDTO.setPrice(sales.getItemId().getPrice());

            sDTO.setItems(itemsDTO);

            salesDTO.add(sDTO);

        }
        return salesDTO;
    }

    @Override
    public SalesDTO insert(SalesDTO salesDTO) {
        Sales sales = new Sales();
        sales.setSaleDate(salesDTO.getSaleDate());
        sales.setWarranty(salesDTO.getWarranty());
        sales.setSellingPrice(salesDTO.getSellingPrice());

        Items items = new Items(salesDTO.getItems().getId());
        Customers Customers = new Customers(salesDTO.getCustomer().getId());
        sales.setCustomerId(Customers);
        sales.setItemId(items);

        salesDAO.insert(sales);

        return salesDTO;
    }

    @Override
    public void delete(int id) {
        salesDAO.delete(id);

    }

    @Override
    public void update(SalesDTO salesDTO) {
        Sales sales = salesDAO.getById(salesDTO.getId());
        sales.setSaleDate(salesDTO.getSaleDate());
        sales.setWarranty(salesDTO.getWarranty());
        sales.setSellingPrice(salesDTO.getSellingPrice());
        sales.setModifiedDate(new Date());

        Items items = new Items(salesDTO.getItems().getId());
        Customers Customers = new Customers(salesDTO.getCustomer().getId());

        sales.setCustomerId(Customers);
        sales.setItemId(items);

        salesDAO.update(sales);

    }

    @Override
    public SalesDTO getById(int id) {
        Sales sales = salesDAO.getById(id);
        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setId(sales.getId());
        salesDTO.setSaleDate(sales.getSaleDate());
        salesDTO.setWarranty(sales.getWarranty());
        salesDTO.setSellingPrice(sales.getSellingPrice());
        salesDTO.setCreatedDate(sales.getCreatedDate());
        salesDTO.setModifiedDate(sales.getModifiedDate());

        Items items = new Items(salesDTO.getItems().getId());
        Customers Customers = new Customers(salesDTO.getCustomer().getId());
        sales.setItemId(items);
        sales.setCustomerId(Customers);

        return salesDTO;
    }

}
