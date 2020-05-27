/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;

import com.ws.service.dto.Conexion;
import com.ws.service.dto.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ConexionRepository extends JpaRepository<Conexion, Integer> {
    
     @Query(value="SELECT * FROM prorobot.conexion where id = ?1",nativeQuery=true)
    Conexion getConexionById(Integer id);
    
}
