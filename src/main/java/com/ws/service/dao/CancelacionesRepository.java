/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;

import com.ws.service.dto.Cancelaciones;
import com.ws.service.dto.Conexion;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface CancelacionesRepository extends JpaRepository<Cancelaciones, Integer> { 
    @Query(value="SELECT * FROM prorobot.cancelaciones where id = ?1",nativeQuery=true)
    Conexion getCancelacionesById(Integer id);
    

     @Transactional
    @Modifying
    @Query(value = "DELETE FROM prorobot.cancelaciones where id = ?1",nativeQuery = true)
    int deleteByCancelacionesId(Integer Id);
    
}
