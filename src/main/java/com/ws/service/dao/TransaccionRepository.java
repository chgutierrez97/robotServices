/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;


import com.ws.service.dto.Transaccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TransaccionRepository extends JpaRepository<Transaccion, Integer> {
    
    @Query(value="select * from transaccion ts  where ts.tipo =  ?1 and ts.usuario_id = ?2",nativeQuery=true)
    List<Transaccion> getTransaccionByTipoUsuario(Integer tipo,Integer idUsuario);
    
    @Query(value="select * from transaccion ts  where ts.tipo =  ?1 ",nativeQuery=true)
    List<Transaccion> getTransaccionByTipo(Integer tipo);

    
    @Query(value="select * from transaccion ts  where ts.usuario_id = ?1",nativeQuery=true)
    List<Transaccion> getTransaccionByIdUsuario(Integer idUsuario);
    
    @Query(value="select * from transaccion ts  where ts.id = ?1",nativeQuery=true)
    Transaccion getTransaccionById(Integer idUsuario);
    
    }
