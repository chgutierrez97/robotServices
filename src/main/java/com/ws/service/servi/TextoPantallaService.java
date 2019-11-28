/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.TextoPantallaRepository;
import com.ws.service.dto.TextoPantalla;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextoPantallaService {
    
   @Autowired
   TextoPantallaRepository dao;
     

    public TextoPantalla save(TextoPantalla textoPantalla){
        return dao.saveAndFlush(textoPantalla);
    }
    public List<TextoPantalla> FindAll(){
        return dao.findAll();
    }   
    public List<TextoPantalla> FindByIdPantalla(Integer idPantalla){
        return dao.getTextoPantallaByIdPantalla(idPantalla);
    }
    public TextoPantalla FindById(Integer id){
        return dao.findById(id).get();
    }
    public void DeleteById(Integer id){
        dao.deleteById(id);
    }
}
