package com.ws.service.api;

import com.ws.service.dto.TextoPantalla;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.reqrep.TextoPantallaIO;
import com.ws.service.servi.TextoPantallaService;
import java.util.ArrayList;
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
public class TextoPantallaApi {

    @Autowired
    TextoPantallaService Service;

    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/saveTextoPantalla", method = RequestMethod.POST)
    public TextoPantallaIO saveTextoPantalla(@RequestBody TextoPantallaIO textoPantallaIO) {
        // Mapeo request a entity
        TextoPantalla textoPantalla = mapper.map(textoPantallaIO, TextoPantalla.class);
        // Invoca lógica de negocio
        TextoPantalla updated = Service.save(textoPantalla);
        // Mapeo entity a response
        TextoPantallaIO textoPantallaResponse = mapper.map(updated, TextoPantallaIO.class);
        return textoPantallaResponse;
    }

    @RequestMapping(value = "/findAllTextoPantalla", method = RequestMethod.GET)
    public ListaMacroIO findAllTextoPantalla() {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<TextoPantalla> roles = Service.FindAll();
        List<TextoPantallaIO> rolesList = new ArrayList<>();
        for (TextoPantalla role : roles) {
            TextoPantallaIO rolAux = mapper.map(role, TextoPantallaIO.class);
            rolesList.add(rolAux);
        }
        listResponse.setTextoPantallaList(rolesList);
        return listResponse;
    }

    @RequestMapping(value = "/findTextoPantallaByIdPantalla", method = RequestMethod.GET)
    public ListaMacroIO findTextoPantallaByIdPantalla(@RequestParam Integer idPantalla) {
        ListaMacroIO listResponse = new ListaMacroIO();

        List<TextoPantalla> textos = Service.FindByIdPantalla(idPantalla);
        List<TextoPantallaIO> textoList = new ArrayList<>();
        for (TextoPantalla text : textos) {
            TextoPantallaIO aux = mapper.map(text, TextoPantallaIO.class);
            textoList.add(aux);
        }
        listResponse.setTextoPantallaList(textoList);
        return listResponse;
    }

    @RequestMapping(value = "/findTextoPantallaById", method = RequestMethod.POST)
    public TextoPantallaIO findTextoPantallaById(@RequestBody Integer id) {
        TextoPantalla role = Service.FindById(id);
        TextoPantallaIO aux = mapper.map(role, TextoPantallaIO.class);
        return aux;
    }

    @RequestMapping(value = "/deleteTextoPantallaById", method = RequestMethod.GET)
    public boolean deleteRolById(@RequestParam Integer id) {
        boolean flag = true;
        try {
            Service.DeleteById(id);
        } catch (EmptyResultDataAccessException e) {
            flag = false;
            e.printStackTrace();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

}
