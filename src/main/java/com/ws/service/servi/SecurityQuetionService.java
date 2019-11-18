/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.SecurityQuetionRepository;
import com.ws.service.dto.SecurityQuetion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityQuetionService {
    
    @Autowired
    SecurityQuetionRepository dao;
     

    public SecurityQuetion save(SecurityQuetion securityQuetion){
        return dao.saveAndFlush(securityQuetion);
    }
    public List<SecurityQuetion> FindAll(){
        return dao.findAll();
    }
    public SecurityQuetion FindById(Integer id){
        return dao.findById(id).get();
    }
    public void DeletesecurityQuetionServiceById(Integer id){
        dao.deleteById(id);
    }
}
