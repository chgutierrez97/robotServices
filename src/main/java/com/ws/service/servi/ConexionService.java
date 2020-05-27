/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.servi;

import com.ws.service.dao.ConexionRepository;
import com.ws.service.dao.PantallaRepository;
import com.ws.service.dto.Conexion;
import com.ws.service.dto.Pantalla;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConexionService {

    @Autowired
    ConexionRepository dao;

    public Conexion save(Conexion conexion) {
        return dao.saveAndFlush(conexion);
    }

    public List<Conexion> FindAll() {
        return dao.findAll();
    }

    public Conexion FindById(Integer id) {
        return dao.getConexionById(id);
    }

    public void DeleteConexionById(Integer id) {
        dao.deleteById(id);
    }
    
//    public void updateScripPantalla(String scrips,Integer pantallaId) {
//        dao.updateScripPantalla(scrips, pantallaId);
//    }
//    public Integer DeletePantallaByTransaccionId(Integer id) {
//       return dao.deleteByTransaccionId(id);
//    }
}
