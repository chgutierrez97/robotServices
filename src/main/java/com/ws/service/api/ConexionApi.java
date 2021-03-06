package com.ws.service.api;

import com.ws.service.dto.Conexion;
import com.ws.service.reqrep.ConexionAsDto;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.servi.ConexionService;
import com.ws.service.servi.InputService;
import com.ws.service.servi.PantallaService;
import com.ws.service.servi.TextoPantallaService;
import com.ws.service.servi.TransaccionService;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api")
public class ConexionApi {
     Logger LOGGER = LoggerFactory.getLogger(ConexionApi.class);

    @Autowired
    PantallaService service;

    @Autowired
    TransaccionService transaccionService;

    @Autowired
    ConexionService conexionService;

    @Autowired
    InputService inputService;
    @Autowired
    TextoPantallaService textoPantallaService;

    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/saveConexion", method = RequestMethod.POST)
    public ConexionAsDto saveConexion(@RequestBody ConexionAsDto conexionAsDto) {
        // Mapeo request a entity
        Conexion conexion = mapper.map(conexionAsDto, Conexion.class);
        conexion = conexionService.save(conexion);
        // Mapeo entity a response
        ConexionAsDto conexionAsDto2 = mapper.map(conexion, ConexionAsDto.class);
        return conexionAsDto2;
    }

    @RequestMapping(value = "/findAllConexion", method = RequestMethod.GET)
    public ListaMacroIO findAllPantalla() {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<Conexion> listConexion = conexionService.FindAll();
        List<ConexionAsDto> conexionList = new ArrayList<>();
        for (Conexion conexion : listConexion) {
            ConexionAsDto cAux = mapper.map(conexion, ConexionAsDto.class);
            conexionList.add(cAux);
        }
        listResponse.setConexionList(conexionList);
        return listResponse;
    }


    @RequestMapping(value = "/findConexionById", method = RequestMethod.GET)
    public ConexionAsDto findConexionById(@RequestParam Integer id) {
        Conexion conec = conexionService.FindById(id);
        
        
        LOGGER.debug("Request {}", id);
		
		LOGGER.info("Response {}", "en esta va lo que vas a mostrar ");
                 LOGGER.debug("This is a debug message");
    LOGGER.info("This is an info message");
    LOGGER.warn("This is a warn message");
    LOGGER.error("This is an error message");
        
        if (conec != null) {
            ConexionAsDto cAux = mapper.map(conec, ConexionAsDto.class);
            return cAux;
        } else {
            ConexionAsDto cAux = new ConexionAsDto();
            return cAux;
        }
    }


}
