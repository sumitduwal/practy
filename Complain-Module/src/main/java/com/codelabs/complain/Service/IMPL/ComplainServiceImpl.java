/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.complain.Service.IMPL;

import com.codelabs.complain.DAO.ComplainDAO;
import com.codelabs.complain.DTO.ComplainDTO;
import com.codelabs.complain.Service.ComplainService;
import com.codelabs.complaintypes.DTO.ComplainTypesDTO;
import com.codelabs.customers.DTO.CustomerDTO;
import com.codelabs.employees.DTO.EmployeeDTO;
import com.codelabs.entity.ComplaintTypes;
import com.codelabs.entity.Complaints;
import com.codelabs.entity.Customers;
import com.codelabs.entity.Employees;
import com.codelabs.entity.Items;
import com.codelabs.items.DTO.ItemsDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "ComplainService")
public class ComplainServiceImpl implements ComplainService {

    @Autowired
    ComplainDAO complainDAO;

    @Override
    public List<ComplainDTO> getAll() {
        List<ComplainDTO> complainDTO = new ArrayList<>();
        for (Complaints complaints : complainDAO.getAll()) {
            ComplainDTO cdto = new ComplainDTO();
            cdto.setId(complaints.getId());
            cdto.setComplaintDescription(complaints.getComplaintDescription());
            cdto.setComplaintDate(complaints.getComplaintDate());

            //complain types
            ComplainTypesDTO complainTypesDTO = new ComplainTypesDTO();
            complainTypesDTO.setId(complaints.getComplaintTypeId().getId());
            complainTypesDTO.setComplaintType(complaints.getComplaintTypeId().getComplaintType());
            complainTypesDTO.setStatus(complaints.getComplaintTypeId().getStatus());

            cdto.setComplainTypes(complainTypesDTO);

            //customer
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(complaints.getCustomerId().getId());
            customerDTO.setFirstName(complaints.getCustomerId().getFirstName());
            customerDTO.setLastName(complaints.getCustomerId().getLastName());
            customerDTO.setEmail(complaints.getCustomerId().getEmail());
            customerDTO.setPhNo(complaints.getCustomerId().getPhNo());
            customerDTO.setAddress(complaints.getCustomerId().getAddress());

            cdto.setCustomer(customerDTO);

            //Employees
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(complaints.getRegisteredBy().getId());
            employeeDTO.setFirstName(complaints.getRegisteredBy().getFirstName());
            employeeDTO.setLastName(complaints.getRegisteredBy().getLastName());
            employeeDTO.setEmail(complaints.getRegisteredBy().getEmail());
            employeeDTO.setAddress(complaints.getRegisteredBy().getAddress());
            employeeDTO.setPhNo(complaints.getRegisteredBy().getPhNo());

            cdto.setEmployee(employeeDTO);

            //items 
            ItemsDTO itemsDTO = new ItemsDTO();
            itemsDTO.setId(complaints.getItemId().getId());
            itemsDTO.setCompanyName(complaints.getItemId().getCompanyName());
            itemsDTO.setItemName(complaints.getItemId().getItemName());
            itemsDTO.setManfacturedNo(complaints.getItemId().getManfacturedNo());
            itemsDTO.setModelNo(complaints.getItemId().getModelNo());

            cdto.setItems(itemsDTO);

            complainDTO.add(cdto);

        }
        return complainDTO;
    }

    @Override
    public ComplainDTO insert(ComplainDTO complainDTO) {
        Complaints complaints = new Complaints();
        complaints.setComplaintDescription(complainDTO.getComplaintDescription());
        complaints.setComplaintDate(complainDTO.getComplaintDate());

        ComplaintTypes complaintTypes = new ComplaintTypes(complainDTO.getComplainTypes().getId());
        Customers customers = new Customers(complainDTO.getCustomer().getId());
        Employees employees = new Employees(complainDTO.getEmployee().getId());
        Items items = new Items(complainDTO.getItems().getId());

        complaints.setComplaintTypeId(complaintTypes);
        complaints.setCustomerId(customers);
        complaints.setRegisteredBy(employees);
        complaints.setItemId(items);

        complainDAO.insert(complaints);

        return complainDTO;

    }

    @Override
    public void delete(int id) {
        complainDAO.delete(id);
    }

    @Override
    public void update(ComplainDTO complainDTO) {
        Complaints complaints = complainDAO.getById(complainDTO.getId());
        complaints.setComplaintDescription(complainDTO.getComplaintDescription());
        complaints.setModifiedDate(new Date());
        
         ComplaintTypes complaintTypes = new ComplaintTypes(complainDTO.getComplainTypes().getId());
        Customers customers = new Customers(complainDTO.getCustomer().getId());
        Employees employees = new Employees(complainDTO.getEmployee().getId());
        Items items = new Items(complainDTO.getItems().getId());

        complaints.setComplaintTypeId(complaintTypes);
        complaints.setCustomerId(customers);
        complaints.setRegisteredBy(employees);
        complaints.setItemId(items);
        complainDAO.update(complaints);
    }

    @Override
    public ComplainDTO getById(int id) {
        Complaints complaints = complainDAO.getById(id);
        ComplainDTO complainDTO = new ComplainDTO();
        complainDTO.setId(complaints.getId());
        complainDTO.setComplaintDescription(complaints.getComplaintDescription());
        complainDTO.setComplaintDate(complaints.getComplaintDate());
        complainDTO.setCreatedDate(complaints.getCreatedDate());
        complainDTO.setModifiedDate(complaints.getModifiedDate());
        
         ComplaintTypes complaintTypes = new ComplaintTypes(complainDTO.getComplainTypes().getId());
        Customers customers = new Customers(complainDTO.getCustomer().getId());
        Employees employees = new Employees(complainDTO.getEmployee().getId());
        Items items = new Items(complainDTO.getItems().getId());

        complaints.setComplaintTypeId(complaintTypes);
        complaints.setCustomerId(customers);
        complaints.setRegisteredBy(employees);
        complaints.setItemId(items);
        
        return complainDTO;
    }

}
