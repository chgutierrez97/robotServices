/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.PantallaRepository;
import com.ws.service.dto.Pantalla;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PantallaService {

    @Autowired
    PantallaRepository dao;

    public Pantalla save(Pantalla pantalla) {
        return dao.saveAndFlush(pantalla);
    }

    public List<Pantalla> FindAll() {
        return dao.findAll();
    }

    public List<Pantalla> getPantallaByIdTrasaccion(Integer idTransaccion) {
        return dao.getPantallaByIdTrasaccion(idTransaccion);
    }

    public Pantalla FindById(Integer id) {
        return dao.findById(id).get();
    }

    public void DeletePantallaById(Integer id) {
        dao.deleteById(id);
    }
}
