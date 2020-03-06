package com.ws.service.dao;

import com.ws.service.dto.Usuario;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE `prorobot`.`usuario` SET `logueado` = ?, `fecha_logueo` = ? WHERE `id` = ? ",nativeQuery = true)
    void updateSessionUsuario(Boolean statusSession, Long fechaStatus,Integer idUsuario);
    
}
