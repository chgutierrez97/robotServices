/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;


import com.ws.service.dto.Input;
import com.ws.service.dto.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author audra.zapata
 */
public interface InputRepository  extends JpaRepository<Input, Integer> {
    
     @Query(value="SELECT * from  input p where  p.pantalla_id = ?1",nativeQuery=true)
    List<Input> getInputsByIdPantalla(Integer idPanatalla);
    
    
}
