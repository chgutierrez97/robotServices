package com.ws.service.api;


import com.ws.service.dto.Persona;
import com.ws.service.dto.Roles;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.reqrep.PersonaIO;
import com.ws.service.reqrep.RolesIO;
import com.ws.service.servi.PersonaService;
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
public class PersonaApi {

    @Autowired
    PersonaService rolService;

    @Autowired
    Mapper mapper;
    @RequestMapping(value = "/savePersona", method = RequestMethod.POST)
    public PersonaIO savePersona(@RequestBody PersonaIO personaIO) {
        // Mapeo request a entity
        Persona pers = mapper.map(personaIO, Persona.class);

        // Invoca lógica de negocio
        Persona updatedPersona = rolService.save(pers);

        // Mapeo entity a response
        PersonaIO personaResponse = mapper.map(updatedPersona, PersonaIO.class);

        return personaResponse;
    }
    
    @RequestMapping(value = "/findAllPersona", method = RequestMethod.GET)
    public ListaMacroIO findAllPersona() {
         ListaMacroIO listResponse = new ListaMacroIO();
        List<Persona> listPersona = rolService.FindAll();
      //List<Persona> listPersona2 = rolService.FindByName("Joses");
        List<PersonaIO> personaList = new ArrayList<>();
        for (Persona pers : listPersona) {
           PersonaIO personaAux= mapper.map(pers, PersonaIO.class);
            personaList.add(personaAux);  
        }
        
        listResponse.setPersonaList(personaList);
        return listResponse;
    }
    
    @RequestMapping(value = "/findPersonaById", method = RequestMethod.POST)
    public PersonaIO findPersonaById(@RequestBody Integer id) {       
        Persona pers = rolService.FindById(id);        
           PersonaIO personaAux= mapper.map(pers, PersonaIO.class);
        return personaAux;
    }
    

    @RequestMapping(value = "/deletePersonaById", method = RequestMethod.GET)
    public boolean deletePersonaById(@RequestParam Integer id) {
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
