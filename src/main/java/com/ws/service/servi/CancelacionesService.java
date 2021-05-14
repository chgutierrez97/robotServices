/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.CancelacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ws.service.dto.Cancelaciones;

@Service
public class CancelacionesService {
    
    @Autowired
    CancelacionesRepository dao;
     

    public Cancelaciones save(Cancelaciones cancelacion){
        return dao.saveAndFlush(cancelacion);
    }
    public Cancelaciones Update(Cancelaciones cancelacion){
        Cancelaciones auxiliar = dao.findById(cancelacion.getId()).get();
        
        if(cancelacion.getProceso()!= "" && cancelacion.getProceso()!=null){
          auxiliar.setProceso(cancelacion.getProceso());
        }
        
        if(cancelacion.getOpion()!= "" && cancelacion.getOpion()!=null){
          auxiliar.setOpion(cancelacion.getOpion());
        }
        
          auxiliar.setFlag(cancelacion.getFlag());
        
        if(cancelacion.getFecha().toString()!= "" && cancelacion.getFecha()!=null){
          auxiliar.setFecha(cancelacion.getFecha());
        }
 
        return dao.saveAndFlush(auxiliar);
    }
    public List<Cancelaciones> FindAll(){
        return dao.findAll();
    }
 
    public Cancelaciones FindById(Integer id){
        return dao.findById(id).get();
    }
    public void DeleteCancelacionesById(Integer id){
        dao.deleteByCancelacionesId(id);
    }
}
