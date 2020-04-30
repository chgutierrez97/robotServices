package com.ws.service.api;


import com.ws.service.dto.SecurityQuetion;
import com.ws.service.dto.Usuario;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.reqrep.SecurityQuetionIO;
import com.ws.service.reqrep.UsuarioIO;
import com.ws.service.servi.UsuarioService;
import com.ws.service.util.Encriptar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioApi {
    
    static final  String  TIPO_ENCRIPTACION_CLAVE = "SHA1";

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    Mapper mapper;

    @Autowired
    Encriptar encriptar;
    
    
    @RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
    public UsuarioIO saveRol(@RequestBody UsuarioIO usuarioIO) {
        Usuario updatedUsuario = null;
        Usuario usuario = mapper.map(usuarioIO, Usuario.class);
        usuario.setClave(usuario.getClave()); 
        if(usuario.getId()!=null){
           updatedUsuario = usuarioService.update(usuario); 
        }else{
            usuario.setLogueado(Boolean.FALSE);
           updatedUsuario = usuarioService.save(usuario); 
        }            
        UsuarioIO  uariotResponse = mapper.map(updatedUsuario, UsuarioIO.class);
        return uariotResponse; 
    }
    
    @RequestMapping(value = "/findAllUsuario", method = RequestMethod.GET)
    public ListaMacroIO findAllRol() {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<Usuario> usuarios = usuarioService.FindAll();
        List<UsuarioIO> usuarioIOList = new ArrayList<>();
        for (Usuario users : usuarios) {
           UsuarioIO userAux= mapper.map(users, UsuarioIO.class);
           Collection<SecurityQuetionIO> listSecurityQuetionIO = new ArrayList<>();
            for (SecurityQuetion sq : users.getSecurityQuetionCollection()) {
                SecurityQuetionIO secQuest = new SecurityQuetionIO();
                secQuest.setId(sq.getId());
                secQuest.setPreguta(sq.getPreguta());
                secQuest.setRespuesta(sq.getRespuesta());
                listSecurityQuetionIO.add(secQuest);
            }
              userAux.setListSecurityQuetion(listSecurityQuetionIO);
            usuarioIOList.add(userAux);  
        }
        listResponse.setUsuarioList(usuarioIOList);
        return listResponse;
    }
    
    @RequestMapping(value = "/findUsuarioById", method = RequestMethod.GET)
    public UsuarioIO findUsuarioById(@RequestParam Integer id) {       
        Usuario usuario = usuarioService.FindById(id);        
           UsuarioIO usuarioIO= mapper.map(usuario, UsuarioIO.class);
        return usuarioIO;
    }
    
    @RequestMapping(value = "/findUsuarioByLoginAndStatus", method = RequestMethod.GET)
    public UsuarioIO findUsuarioByLoginAndStatus(@RequestParam String  login, @RequestParam Integer idStatus) {    

        Usuario usuario = usuarioService.FindUsuarioByLoginAndStatus(login, idStatus);  
        UsuarioIO usuarioIO;
        if(usuario!=null){
         usuarioIO= mapper.map(usuario, UsuarioIO.class);
           
           Collection<SecurityQuetionIO> listSecurityQuetionIO = new ArrayList<>();
            for (SecurityQuetion sq : usuario.getSecurityQuetionCollection()) {
                SecurityQuetionIO secQuest = new SecurityQuetionIO();
                secQuest.setId(sq.getId());
                secQuest.setPreguta(sq.getPreguta());
                secQuest.setRespuesta(sq.getRespuesta());
                listSecurityQuetionIO.add(secQuest);
            }
            usuarioIO.setListSecurityQuetion(listSecurityQuetionIO);
        }else{
            usuarioIO = new UsuarioIO(); 
        } 
        return usuarioIO;
    }
    
    
    @RequestMapping(value = "/findUsuarioByLogin", method = RequestMethod.GET)
    public UsuarioIO findUsuarioByLogin(@RequestParam String  login) {    

        Usuario usuario = usuarioService.FindUsuarioByLogin(login);  
        UsuarioIO usuarioIO;
        if(usuario!=null){
         usuarioIO= mapper.map(usuario, UsuarioIO.class);
           
           Collection<SecurityQuetionIO> listSecurityQuetionIO = new ArrayList<>();
            for (SecurityQuetion sq : usuario.getSecurityQuetionCollection()) {
                SecurityQuetionIO secQuest = new SecurityQuetionIO();
                secQuest.setId(sq.getId());
                secQuest.setPreguta(sq.getPreguta());
                secQuest.setRespuesta(sq.getRespuesta());
                listSecurityQuetionIO.add(secQuest);
            }
            usuarioIO.setListSecurityQuetion(listSecurityQuetionIO);
        }else{
            usuarioIO = new UsuarioIO(); 
        } 
        return usuarioIO;
    }

    @RequestMapping(value = "/deleteUsuarioById", method = RequestMethod.GET)
    public boolean deleteUsuarioById(@RequestParam Integer id) {
        boolean flag = true;
        try {
             usuarioService.DeleteUsuarioById(id);
        } catch (EmptyResultDataAccessException e) {
            flag=false;
            e.printStackTrace();
        }catch(Exception e){
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }
    
    @RequestMapping(value = "/marcarSessionUsersById", method = RequestMethod.GET)
    public boolean marcarSessionUsersById(@RequestParam Integer id,@RequestParam Boolean sessionActive) {
        boolean flag = true;
        try {
            if(sessionActive.equals(Boolean.FALSE)){
                usuarioService.updateSessionUsuario(sessionActive, 0L, id);
            }else{
                usuarioService.updateSessionUsuario(sessionActive, new Date().getTime(), id);
            }
                
             
        } catch (EmptyResultDataAccessException e) {
            flag=false;
            e.printStackTrace();
        }catch(Exception e){
            flag=false;
            e.printStackTrace();
        }
        return flag;
    }
   

}
