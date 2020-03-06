package com.ws.service.servi;

import com.ws.service.dao.UsuarioRepository;
import com.ws.service.dto.Usuario;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository dao;
    
    public Usuario save(Usuario usuario) {
        return dao.saveAndFlush(usuario);
    }
    
    public Usuario update(Usuario usuario) {
        Usuario usuar = FindById(usuario.getId());
        
        if (usuario.getFechaLogueo() != null) {
            usuar.setFechaLogueo(usuario.getFechaLogueo());
        }
        if (usuario.getLogueado() != null) {
            usuar.setLogueado(usuario.getLogueado());
        }
        if (usuario.getUsuario() != "" && usuario.getUsuario() != null) {
            usuar.setUsuario(usuario.getUsuario() );
        }
        if (usuario.getClave() != "" && usuario.getClave() != null) {
            usuar.setClave(usuario.getClave() );
        }
        if (usuario.getRoles() != null) {
            usuar.setRoles(usuario.getRoles());
        }
        if (usuario.getPersona() != null) {
            usuar.setPersona(usuario.getPersona());
        }
        if (usuario.getStatus() != null) {
            usuar.setStatus(usuario.getStatus());
        }
        
        return dao.saveAndFlush(usuar);
    }
    
    public List<Usuario> FindAll() {
        return dao.findAll();
    }
    
    public Usuario FindById(Integer id) {
        return dao.findById(id).get();
    }
    
    public Usuario FindUsuarioByLoginAndStatus(String usuario, Integer idStatus) {
            return dao.getUsuarioByLoginAndStatus(usuario, idStatus);
    }
    
    public Usuario FindUsuarioByLogin(String usuario) {
        return dao.getUsuarioByLogin(usuario);
    }
    
    public void DeleteUsuarioById(Integer id) {
        dao.deleteById(id);
    }
    
    public void updateSessionUsuario(Boolean statusSession, Long fechaStatus,Integer idUsuario){
        dao.updateSessionUsuario(statusSession, fechaStatus, idUsuario);
    }
}
