package com.ws.service.api;

import com.ws.service.dto.TextoPantalla;
import com.ws.service.dto.Transaccion;
import com.ws.service.reqrep.TransaccionIO;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.reqrep.TextoPantallaIO;
import com.ws.service.reqrep.TransaccionOI;
import com.ws.service.servi.TransaccionService;
import com.ws.service.servi.UsuarioService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TransaccionApi {

    @Autowired
    TransaccionService service;
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/saveTransaccion", method = RequestMethod.POST)
    public TransaccionIO saveTransaccion(@RequestBody TransaccionOI transaccionOI) {
        // Mapeo request a entity
             Transaccion transaccion = new Transaccion();
             TransaccionIO transaccionResponse ;
        
        try {
        
        transaccion.setAplicativoExternocol(transaccionOI.getAplicativoExternocol());
        transaccion.setDescripcion(transaccionOI.getDescripcion());
        transaccion.setFechaCarga(new Date());
        transaccion.setNombre(transaccionOI.getNombre());
        transaccion.setTipo(transaccionOI.getTipo());
        transaccion.setTipoAplicativo(transaccionOI.getTipoAplicativo());
        Integer idUser = transaccionOI.getUsuario().getId();
        transaccion.setUsuario(usuarioService.FindById(idUser));
        transaccion.setTransaccionIni(transaccionOI.getTransaccionIni());
        // Invoca lógica de negocio
        Transaccion updatedTransaccion = service.save(transaccion); 
        // Mapeo entity a response
         transaccionResponse = mapper.map(updatedTransaccion, TransaccionIO.class);
         
         return transaccionResponse;
        } catch (Exception e) {
            e.printStackTrace();
            transaccionResponse = new TransaccionIO();
        }
       
        return transaccionResponse;
    }
    @RequestMapping(value = "/updateTransaccion", method = RequestMethod.POST)
    public TransaccionIO updateTransaccion(@RequestBody TransaccionOI transaccionOI) {
        // Mapeo request a entity
             Transaccion transaccion = new Transaccion();
             TransaccionIO transaccionResponse ;
        
        try {       
        transaccion.setAplicativoExternocol(transaccionOI.getAplicativoExternocol());
        transaccion.setId(transaccionOI.getId());
        transaccion.setDescripcion(transaccionOI.getDescripcion());
        transaccion.setFechaCarga(new Date());
        transaccion.setNombre(transaccionOI.getNombre());
        transaccion.setTipo(transaccionOI.getTipo());
        transaccion.setTipoAplicativo(transaccionOI.getTipoAplicativo());
        Integer idUser = transaccionOI.getUsuario().getId();
        transaccion.setUsuario(usuarioService.FindById(idUser));
        Transaccion updatedTransaccion = service.update(transaccion);

         transaccionResponse = mapper.map(updatedTransaccion, TransaccionIO.class);
         
         return transaccionResponse;
        } catch (Exception e) {
            e.printStackTrace();
            transaccionResponse = new TransaccionIO();
        }
       
        return transaccionResponse;
    }

    @GetMapping(value = "/findAllTransaccion", produces = "application/json")
    public ListaMacroIO findAllTransaccion() {

        ListaMacroIO respuesta = new ListaMacroIO();

        List<Transaccion> trans = service.FindAll();
        List<TransaccionIO> TransaccionsList = new ArrayList<>();
        for (Transaccion tran : trans) {
            TransaccionIO aux = mapper.map(tran, TransaccionIO.class);
            TransaccionsList.add(aux);
        }

        respuesta.setTransaccionList(TransaccionsList);
        return respuesta;
    }

    @RequestMapping(value = "/findTransacionByTipoUsuario", method = RequestMethod.GET)
    public ListaMacroIO findTextoPantallaByIdPantalla(@RequestParam Integer idTipo,@RequestParam Integer idUsuario) {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<Transaccion> transacciones = new ArrayList<>();
       if(idTipo==1||idTipo==2){
          transacciones = service.FindByTipoUsuario(idTipo,idUsuario);
       }else if(idTipo==0){
           transacciones = service.FindByIdUsuario(idUsuario);
       }
        
        List<TransaccionIO> transaccionList = new ArrayList<>();
        for (Transaccion transaccion : transacciones) {
            TransaccionIO aux = mapper.map(transaccion, TransaccionIO.class);
            transaccionList.add(aux);
        }
        listResponse.setTransaccionList(transaccionList);
        return listResponse;
    }
    
    @RequestMapping(value = "/findTransacionByTipo", method = RequestMethod.GET)
    public ListaMacroIO findTransacionByTipo(@RequestParam Integer idTipo) {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<Transaccion> transacciones =  transacciones = service.FindByTipo(idTipo);
        List<TransaccionIO> transaccionList = new ArrayList<>();
        for (Transaccion transaccion : transacciones) {
            TransaccionIO aux = mapper.map(transaccion, TransaccionIO.class);
            transaccionList.add(aux);
        }
        listResponse.setTransaccionList(transaccionList);
        return listResponse;
    }

    
    @RequestMapping(value = "/findTransacionByIdUsuario", method = RequestMethod.GET)
    public ListaMacroIO findTransacionByIdUsuario(@RequestParam Integer idUsuario) {
        ListaMacroIO listResponse = new ListaMacroIO();

        List<Transaccion> transacciones = service.FindByIdUsuario(idUsuario);
        List<TransaccionIO> transaccionList = new ArrayList<>();
        for (Transaccion transaccion : transacciones) {
            TransaccionIO aux = mapper.map(transaccion, TransaccionIO.class);
            transaccionList.add(aux);
        }
        listResponse.setTransaccionList(transaccionList);
        return listResponse;
    }

    @RequestMapping(value = "/findTransaccionById", method = RequestMethod.GET)
    public TransaccionIO findTransaccionById(@RequestParam Integer id) {
        Transaccion transac = service.FindById(id);
        TransaccionIO aux = mapper.map(transac, TransaccionIO.class);
        return aux;
    }

    @RequestMapping(value = "/deleteTransaccionById", method = RequestMethod.GET)
    public boolean deleteTransaccionById(@RequestParam Integer id) {
        boolean flag = true;
        try {
            service.DeleteTransaccionById(id);
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