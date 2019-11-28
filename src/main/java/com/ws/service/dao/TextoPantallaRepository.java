/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;

import com.ws.service.dto.TextoPantalla;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author audra.zapata
 */
public interface TextoPantallaRepository extends JpaRepository<TextoPantalla, Integer> {

    @Query(value = "select * from texto_pantalla tp where tp.pantalla_id = ?1", nativeQuery = true)
    List<TextoPantalla> getTextoPantallaByIdPantalla(Integer idPanatalla);

    @Query(value = "select * from texto_pantalla tp where tp.pantalla_id = ?1", nativeQuery = true)
    List<TextoPantalla> getTextoPantallaByIdTransaccion(Integer idPanatalla);
}
