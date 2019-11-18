/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.TransaccionRepository;
import com.ws.service.dto.Transaccion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {

    @Autowired
    TransaccionRepository dao;

    public Transaccion save(Transaccion transaccion) {
        return dao.saveAndFlush(transaccion);
    }

    public List<Transaccion> FindAll() {
        return dao.findAll();
    }

    public List<Transaccion> FindByTipoUsuario(Integer tipo , Integer idUsuario) {
        return dao.getTransaccionByTipoUsuario(tipo,idUsuario);
    }
    
    public List<Transaccion> FindByTipo(Integer tipo ) {
        return dao.getTransaccionByTipo(tipo);
    }

    public List<Transaccion> FindByIdUsuario(Integer idUsuario) {
        return dao.getTransaccionByIdUsuario(idUsuario);
    }

    public Transaccion FindById(Integer id) {
        return dao.getTransaccionById(id);
    }

    public void DeleteTransaccionById(Integer id) {
        dao.deleteById(id);
    }
}
