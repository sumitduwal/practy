/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codelabs.complaintypes.SERVICE.IMPL;

import com.codelabs.complaintypes.DAO.ComplainTypeDAO;
import com.codelabs.complaintypes.DAO.IMPL.ComplainTypesDAOImpl;
import com.codelabs.complaintypes.DTO.ComplainTypesDTO;
import com.codelabs.complaintypes.SERVICE.ComplainTypeService;
import com.codelabs.entity.ComplaintTypes;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sd14d
 */
@Service(value = "ComplainTypeService")
public class ComplainTypesServiceImpl implements ComplainTypeService{
@Autowired
ComplainTypeDAO complainTypesDAO;
    @Override
    public List<ComplainTypesDTO> getAll() {
             List <ComplainTypesDTO> complainTypesDTO = new ArrayList<>();
             for(ComplaintTypes complaintTypes :complainTypesDAO.getAll()){
                 ComplainTypesDTO ctdto = new ComplainTypesDTO();
                 ctdto.setId(complaintTypes.getId());
                 ctdto.setComplaintType(complaintTypes.getComplaintType());
                 ctdto.setStatus(complaintTypes.getStatus());
                 
                 complainTypesDTO.add(ctdto);
             }
             return  complainTypesDTO;
    }

    @Override
    public ComplainTypesDTO insert(ComplainTypesDTO complainTypesDTO) {
        ComplaintTypes complaintTypes = new ComplaintTypes();
        complaintTypes.setId(complainTypesDTO.getId());
        complaintTypes.setComplaintType(complainTypesDTO.getComplaintType());
        complaintTypes.setStatus(complainTypesDTO.getStatus());
        
       complainTypesDAO.insert(complaintTypes);
       return  complainTypesDTO;
         
    }

    @Override
    public void delete(int id) {
      complainTypesDAO.delete(id);
    }

    @Override
    public void update(ComplainTypesDTO complainTypesDTO) {
        ComplaintTypes complaintTypes  = complainTypesDAO.getById(complainTypesDTO.getId());
        complaintTypes.setComplaintType(complainTypesDTO.getComplaintType());
        complaintTypes.setStatus(complainTypesDTO.getStatus());
        
        complainTypesDAO.update(complaintTypes);
    }

    @Override
    public ComplainTypesDTO getById(int id) {
        ComplaintTypes complaintTypes = complainTypesDAO.getById(id);
        ComplainTypesDTO complainTypesDTO = new ComplainTypesDTO();
        complainTypesDTO.setId(complaintTypes.getId());
        complainTypesDTO.setComplaintType(complaintTypes.getComplaintType());
        complainTypesDTO.setStatus(complaintTypes.getStatus());
        return complainTypesDTO;
    }
    
}
