/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.ContactRepository;
import com.ws.service.dto.Contact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    
    @Autowired
    ContactRepository dao;
     
    public Contact save(Contact contact){
        return dao.saveAndFlush(contact);
    }
    public List findAll(){
        return dao.findAll();
    }
}
