/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;

import com.ws.service.dto.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author audra.zapata
 */
public interface PersonaRepository  extends JpaRepository<Persona, Integer> {
    
    @Query(value="SELECT * from persona p where p.nombre =?1",nativeQuery=true)
    List<Persona> getPersonaByName(String name);
    
    
}