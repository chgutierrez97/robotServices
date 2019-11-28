/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dao;

import com.ws.service.dto.Transaccion;
import com.ws.service.dto.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author audra.zapata
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    @Query(value="select * from usuario u where u.usuario =  ?1  and u.status_id =  ?2",nativeQuery=true)
    Usuario getUsuarioByLoginAndStatus(String login,Integer idStatus);
            
    @Query(value="select * from usuario u where u.usuario =  ?1 ",nativeQuery=true)
    Usuario getUsuarioByLogin(String login);
    
}
