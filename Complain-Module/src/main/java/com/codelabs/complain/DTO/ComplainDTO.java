/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.complain.DTO;

import com.codelabs.complaintypes.DTO.ComplainTypesDTO;
import com.codelabs.customers.DTO.CustomerDTO;
import com.codelabs.employees.DTO.EmployeeDTO;
import com.codelabs.items.DTO.ItemsDTO;
import java.util.Date;

/**
 *
 * @author sd14d
 */
public class ComplainDTO {

    private Integer id;
    private String complaintDescription;
    private Date complaintDate;
    private Date createdDate;
    private Date modifiedDate;
    private ComplainTypesDTO complainTypes;
    private CustomerDTO customer;
    private EmployeeDTO employee;
    private ItemsDTO items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public ComplainTypesDTO getComplainTypes() {
        return complainTypes;
    }

    public void setComplainTypes(ComplainTypesDTO complainTypes) {
        this.complainTypes = complainTypes;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public ItemsDTO getItems() {
        return items;
    }

    public void setItems(ItemsDTO items) {
        this.items = items;
    }
    
    

}
