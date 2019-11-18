/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.RolRepository;
import com.ws.service.dto.Roles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    
    @Autowired
    RolRepository dao;
     

    public Roles save(Roles rol){
        return dao.saveAndFlush(rol);
    }
    public List<Roles> FindAll(){
        return dao.findAll();
    }
    public Roles FindById(Integer id){
        return dao.findById(id).get();
    }
    public void DeleteRolById(Integer id){
        dao.deleteById(id);
    }
}
