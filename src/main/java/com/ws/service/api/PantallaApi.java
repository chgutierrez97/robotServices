package com.ws.service.api;

import com.ws.service.dto.Input;
import com.ws.service.dto.Pantalla;
import com.ws.service.dto.TextoPantalla;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.reqrep.PantallaIO;
import com.ws.service.reqrep.TextoPantallaIO;
import com.ws.service.servi.InputService;
import com.ws.service.servi.PantallaService;
import com.ws.service.servi.TextoPantallaService;
import com.ws.service.servi.TransaccionService;
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
public class PantallaApi {

    @Autowired
    PantallaService service;

    @Autowired
    TransaccionService transaccionService;

    @Autowired
    InputService inputService;
    @Autowired
    TextoPantallaService textoPantallaService;

    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/savePantalla", method = RequestMethod.POST)
    public PantallaIO savePantalla(@RequestBody PantallaIO pantallaIO) {
        // Mapeo request a entity
        Pantalla pantalla = mapper.map(pantallaIO, Pantalla.class);
        // Invoca lógica de negocio
        pantalla.setTransaccionId(transaccionService.FindById(pantallaIO.getIdTransaccion()));
        Pantalla updatedPantalla = service.save(pantalla);
        for (Input input : updatedPantalla.getInputCollection()) {
            input.setPantalla(updatedPantalla);
            input.setId(inputService.save(input).getId());
        }

        for (TextoPantalla textoPantalla : updatedPantalla.getTextoPantallaCollection()) {
            textoPantalla.setPantalla(pantalla);
            textoPantalla.setId(textoPantallaService.save(textoPantalla).getId());
        }

        // Mapeo entity a response
        PantallaIO pantallatResponse = mapper.map(updatedPantalla, PantallaIO.class);
        return pantallatResponse;
    }
    @RequestMapping(value = "/savePantalla2", method = RequestMethod.POST)
    public PantallaIO savePantalla2(@RequestBody PantallaIO pantallaIO) {
        // Mapeo request a entity
        Pantalla pantalla = mapper.map(pantallaIO, Pantalla.class);
        // Invoca lógica de negocio
        pantalla.setTransaccionId(transaccionService.FindById(pantallaIO.getIdTransaccion()));
        Pantalla updatedPantalla = service.save(pantalla);
        for (Input input : updatedPantalla.getInputCollection()) {
            input.setPantalla(updatedPantalla);
            input.setId(inputService.save(input).getId());
        }

        for (TextoPantalla textoPantalla : updatedPantalla.getTextoPantallaCollection()) {
            textoPantalla.setPantalla(pantalla);
            textoPantalla.setId(textoPantallaService.save(textoPantalla).getId());
        }

        // Mapeo entity a response
        PantallaIO pantallatResponse = mapper.map(updatedPantalla, PantallaIO.class);
        return pantallatResponse;
    }

    @RequestMapping(value = "/findAllPantalla", method = RequestMethod.GET)
    public ListaMacroIO findAllPantalla() {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<Pantalla> listPantalla = service.FindAll();
        List<PantallaIO> pantallasList = new ArrayList<>();
        for (Pantalla pantalla : listPantalla) {
            PantallaIO pAux = mapper.map(pantalla, PantallaIO.class);
            pantallasList.add(pAux);
        }
        listResponse.setPantallasList(pantallasList);
        return listResponse;
    }

    @RequestMapping(value = "/findPantallaByIdTransaccion", method = RequestMethod.GET)
    public ListaMacroIO findPantallaByIdTransaccion(@RequestParam Integer idTransaccion) {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<Pantalla> textos = service.getPantallaByIdTrasaccion(idTransaccion);
        List<PantallaIO> textoList = new ArrayList<>();
        for (Pantalla text : textos) {
            PantallaIO aux = mapper.map(text, PantallaIO.class);
            textoList.add(aux);
        }
        listResponse.setPantallasList(textoList);
        return listResponse;
    }

    @RequestMapping(value = "/updateScripPantalla", method = RequestMethod.GET)
    public Boolean updateScripPantalla(@RequestParam String scrips, @RequestParam Integer pantallaId) {
        boolean flag = true;
        try {
            service.updateScripPantalla(scrips, pantallaId);
        } catch (EmptyResultDataAccessException e) {
            flag = false;
            e.printStackTrace();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "/findPantallaByIdTrasaccionEmulacion", method = RequestMethod.GET)
    public ListaMacroIO findPantallaByIdTrasaccionEmulacion(@RequestParam Integer idTransaccion) {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<Pantalla> textos = service.getPantallaByIdTrasaccionEmulacion(idTransaccion);
        List<PantallaIO> textoList = new ArrayList<>();
        for (Pantalla text : textos) {
            PantallaIO aux = mapper.map(text, PantallaIO.class);
            textoList.add(aux);
        }
        listResponse.setPantallasList(textoList);
        return listResponse;
    }

    @RequestMapping(value = "/findPantallaById", method = RequestMethod.POST)
    public PantallaIO findPantallaById(@RequestBody Integer id) {
        Pantalla pantalla = service.FindById(id);
        PantallaIO pAux = mapper.map(pantalla, PantallaIO.class);
        return pAux;
    }

    @RequestMapping(value = "/deletePantallaById", method = RequestMethod.GET)
    public boolean deletePantallaById(@RequestParam Integer id) {
        boolean flag = true;
        try {
            service.DeletePantallaById(id);
        } catch (EmptyResultDataAccessException e) {
            flag = false;
            e.printStackTrace();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    @RequestMapping(value = "/deletePantallaByTransaccionId", method = RequestMethod.GET)
    public boolean deletePantallaByTransaccionId(@RequestParam Integer id) {
        boolean flag = true;
        try {
            service.DeletePantallaByTransaccionId(id);
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
