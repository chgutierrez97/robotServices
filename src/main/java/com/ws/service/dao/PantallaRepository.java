/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;

import com.ws.service.dto.Pantalla;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author audra.zapata
 */
public interface PantallaRepository extends JpaRepository<Pantalla, Integer> {

    @Query(value = "select * from pantalla pa where pa.transaccion_id = ?1", nativeQuery = true)
    List<Pantalla> getPantallaByIdTrasaccion(Integer idTransaccion);

}
