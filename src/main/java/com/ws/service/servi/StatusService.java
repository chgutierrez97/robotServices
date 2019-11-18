/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.StatusRepository;
import com.ws.service.dto.Status;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    
    @Autowired
    StatusRepository dao;
     

    public Status save(Status utatus){
        return dao.saveAndFlush(utatus);
    }
    public List<Status> FindAll(){
        return dao.findAll();
    }
    public Status FindById(Integer id){
        return dao.findById(id).get();
    }
    public void DeleteRolById(Integer id){
        dao.deleteById(id);
    }
}
