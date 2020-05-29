/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;

import com.ws.service.dto.Pantalla;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author audra.zapata
 */
public interface PantallaRepository extends JpaRepository<Pantalla, Integer> {

    @Query(value = "select * from pantalla pa where pa.transaccion_id = ?1", nativeQuery = true)
    List<Pantalla> getPantallaByIdTrasaccion(Integer idTransaccion);

    @Query(value = "select  * from  pantalla  where transaccion_id in ( ?1 , (select t1.transaccion_ini from transaccion t1 where t1.id=?1)) ", nativeQuery = true)
    List<Pantalla> getPantallaByIdTrasaccionEmulacion(Integer idTransaccion);

    @Transactional
    @Modifying
    int deleteByTransaccionId(Integer transaccionId);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE prorobot.pantalla SET pantalla_scrips= ?1  WHERE id =?2",nativeQuery = true)
    void updateScripPantalla(String newScrip, Integer pantallaId);
}
