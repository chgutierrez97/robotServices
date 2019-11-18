
package com.ws.service.servi;

import com.ws.service.dao.UsuarioRepository;
import com.ws.service.dto.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository dao;
     
    public Usuario save(Usuario usuario){
        return dao.saveAndFlush(usuario);
    }
    public List<Usuario> FindAll(){
        return dao.findAll();
    }
    public Usuario FindById(Integer id){
        return dao.findById(id).get();
    }
    public Usuario FindUsuarioByLoginAndStatus(String usuario,Integer idStatus){
        return dao.getUsuarioByLoginAndStatus(usuario, idStatus);
    }
    public Usuario FindUsuarioByLogin(String usuario){
        return dao.getUsuarioByLogin(usuario);
    }
    public void DeleteUsuarioById(Integer id){
        dao.deleteById(id);
    }
}
