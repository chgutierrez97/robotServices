/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.InputRepository;
import com.ws.service.dto.Input;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputService {
    
    @Autowired
    InputRepository dao;
     

    public Input save(Input input){
        return dao.saveAndFlush(input);
    }
    public List<Input> FindAll(){
        return dao.findAll();
    }
    public List<Input> FindByIdPantalla(Integer idPantalla){
        return dao.getInputsByIdPantalla(idPantalla);
    }
    public Input FindById(Integer id){
        return dao.findById(id).get();
    }
    public void DeleteRolById(Integer id){
        dao.deleteById(id);
    }
}
