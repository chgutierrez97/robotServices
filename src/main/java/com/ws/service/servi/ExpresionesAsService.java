/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dto.ExpresionesRegulares;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ws.service.dao.ExpresionesAsRepository;

@Service
public class ExpresionesAsService {
    
    @Autowired
    ExpresionesAsRepository dao;
     

    public ExpresionesRegulares save(ExpresionesRegulares expresion){
        return dao.saveAndFlush(expresion);
    }
    public ExpresionesRegulares Update(ExpresionesRegulares expresion){
        ExpresionesRegulares auxiliar = dao.findById(expresion.getId()).get();
        if(expresion.getCodError()!= "" && expresion.getCodError()!=null){
          auxiliar.setCodError(expresion.getCodError());
        }
        if(expresion.getMensajeError()!= "" && expresion.getMensajeError()!=null){
          auxiliar.setMensajeError(expresion.getMensajeError());
        }
 
        return dao.saveAndFlush(auxiliar);
    }
    public List<ExpresionesRegulares> FindAll(){
        return dao.findAll();
    }
 
    public ExpresionesRegulares FindById(Integer id){
        return dao.findById(id).get();
    }
    public void DeleteRolById(Integer id){
        dao.deleteById(id);
    }
}
