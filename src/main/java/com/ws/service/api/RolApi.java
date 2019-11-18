package com.ws.service.api;


import com.ws.service.dto.Roles;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.reqrep.RolesIO;
import com.ws.service.servi.RolService;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RolApi {

    @Autowired
    RolService rolService;

    @Autowired
    Mapper mapper;
    @RequestMapping(value = "/saveRol", method = RequestMethod.POST)
    public RolesIO saveRol(@RequestBody RolesIO rolesIO) {
        // Mapeo request a entity
        Roles rol = mapper.map(rolesIO, Roles.class);

        // Invoca lógica de negocio
        Roles updatedRol = rolService.save(rol);

        // Mapeo entity a response
        RolesIO contactResponse = mapper.map(updatedRol, RolesIO.class);

        return contactResponse;
    }
    
    @RequestMapping(value = "/findAllRol", method = RequestMethod.GET)
    public ListaMacroIO findAllRol() {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<Roles> roles = rolService.FindAll();
        List<RolesIO> rolesList = new ArrayList<>();
        for (Roles role : roles) {
           RolesIO rolAux= mapper.map(role, RolesIO.class);
            rolesList.add(rolAux);  
        }
        listResponse.setRolesList(rolesList);
        return listResponse;
    }
    
    @RequestMapping(value = "/findRolById", method = RequestMethod.POST)
    public RolesIO findRolById(@RequestBody Integer id) {       
        Roles role = rolService.FindById(id);        
           RolesIO rolAux= mapper.map(role, RolesIO.class);
        return rolAux;
    }
    

    @RequestMapping(value = "/deleteRolById", method = RequestMethod.GET)
    public boolean deleteRolById(@RequestParam Integer id) {
        boolean flag = true;
        try {
             rolService.DeleteRolById(id);
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
