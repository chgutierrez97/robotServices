package com.ws.service.api;

import com.ws.service.dto.ExpresionesRegulares;
import com.ws.service.dto.Input;
import com.ws.service.reqrep.ExpresionesRegularesIO;
import com.ws.service.reqrep.InputIO;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.servi.ExpresionesAsService;
import com.ws.service.servi.PantallaService;
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
public class ExpresinRegulaApi {

    @Autowired
    ExpresionesAsService service;
    
        @Autowired
    PantallaService servicePantalla;


    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/saveExpresion", method = RequestMethod.POST)
    public ExpresionesRegularesIO saveExpresion(@RequestBody ExpresionesRegularesIO expresionIO) {
      
        // Mapeo entity a rerequest
        ExpresionesRegulares expresiones = mapper.map(expresionIO, ExpresionesRegulares.class);
        //saves
        expresiones = service.save(expresiones);
        // Mapeo entity a response
        ExpresionesRegularesIO expresionResponse = mapper.map(expresiones, ExpresionesRegularesIO.class);
  
      
        return expresionResponse;
    }
    
    @RequestMapping(value = "/updateExpresion", method = RequestMethod.POST)
    public ExpresionesRegulares updateExpresion(@RequestBody ExpresionesRegulares expresion) {        
        // Invoca lógica de negocio
        ExpresionesRegulares updatedExpresion = service.Update(expresion);
        // Mapeo entity a response      
        return updatedExpresion;
    }

    @RequestMapping(value = "/findAllExpresion", method = RequestMethod.GET)
    public ListaMacroIO findAllExpresion() {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<ExpresionesRegulares> expresiones = service.FindAll();
        List<ExpresionesRegularesIO> expresionesList = new ArrayList<>();
        for (ExpresionesRegulares expresion : expresiones) {
             ExpresionesRegularesIO expresionesAux = mapper.map(expresion, ExpresionesRegularesIO.class);
            expresionesList.add(expresionesAux);
        }
        listResponse.setExpresionesList(expresionesList);
        return listResponse;
    }
    



    @RequestMapping(value = "/findExpresionById", method = RequestMethod.GET)
    public ExpresionesRegularesIO findExpresionById(@RequestParam Integer id) {
        ExpresionesRegulares expresion = service.FindById(id); 
        ExpresionesRegularesIO expresionResponse = mapper.map(expresion, ExpresionesRegularesIO.class);
        return expresionResponse;
    }
    

    @RequestMapping(value = "/deleteExpresionById", method = RequestMethod.GET)
    public boolean deleteExpresionById(@RequestParam Integer id) {
        boolean flag = true;
        try {
            if(servicePantalla.getPantallaByIdExpresion(id)){
               service.DeleteRolById(id);
            }else{
                flag = false;
            }
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
