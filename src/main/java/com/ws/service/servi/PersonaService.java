/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.PersonaRepository;
import com.ws.service.dto.Persona;
import com.ws.service.dto.Status;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    
    @Autowired
    PersonaRepository dao;
     

    public Persona save(Persona persona){
        return dao.saveAndFlush(persona);
    }
    public List<Persona> FindAll(){
        return dao.findAll();
    }
    public List<Persona> FindByName(String name){
        return dao.getPersonaByName(name);
    }
    public Persona FindById(Integer id){
        return dao.findById(id).get();
    }
    public Persona FindByDNI(Integer dni){
        return dao.getPersonaByDNI(dni);
    }

      public void DeleteRolById(Integer id){
        dao.deleteById(id);
    }
}
