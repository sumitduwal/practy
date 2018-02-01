/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.stock.DTO;

import com.codelabs.items.DTO.ItemsDTO;

/**
 *
 * @author sd14d
 */
public class StockDTO {

    private Integer id;
    private Integer quantity;
    private ItemsDTO item;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ItemsDTO getItem() {
        return item;
    }

    public void setItem(ItemsDTO item) {
        this.item = item;
    }

}
