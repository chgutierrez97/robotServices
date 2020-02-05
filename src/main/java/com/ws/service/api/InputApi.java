package com.ws.service.api;

import com.ws.service.dto.Input;
import com.ws.service.reqrep.InputIO;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.servi.InputService;
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
public class InputApi {

    @Autowired
    InputService service;

    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/saveInput", method = RequestMethod.POST)
    public InputIO saveInput(@RequestBody InputIO inputIO) {
        // Mapeo request a entity
        Input input = mapper.map(inputIO, Input.class);
        // Invoca lógica de negocio
        Input updatedInput = service.save(input);
        // Mapeo entity a response
        InputIO inputResponse = mapper.map(updatedInput, InputIO.class);
        return inputResponse;
    }
    
    @RequestMapping(value = "/updateInput", method = RequestMethod.POST)
    public InputIO updateInput(@RequestBody InputIO inputIO) {
        // Mapeo request a entity
        Input input = mapper.map(inputIO, Input.class);
        // Invoca lógica de negocio
        Input updatedInput = service.Update(input);
        // Mapeo entity a response
        InputIO inputResponse = mapper.map(updatedInput, InputIO.class);
        return inputResponse;
    }

    @RequestMapping(value = "/findAllInput", method = RequestMethod.GET)
    public ListaMacroIO findAllInput() {
        ListaMacroIO listResponse = new ListaMacroIO();

        List<Input> inputs = service.FindAll();
        List<InputIO> inputList = new ArrayList<>();
        for (Input input : inputs) {
            InputIO aux = mapper.map(input, InputIO.class);
            inputList.add(aux);
        }
        listResponse.setInputList(inputList);
        return listResponse;
    }

    @RequestMapping(value = "/findInputByIdPantalla", method = RequestMethod.GET)
    public ListaMacroIO findInputByIdPantalla(@RequestParam Integer idPantalla) {
        ListaMacroIO listResponse = new ListaMacroIO();

        List<Input> inputs = service.FindByIdPantalla(idPantalla);
        List<InputIO> inputList = new ArrayList<>();
        for (Input input : inputs) {
            InputIO aux = mapper.map(input, InputIO.class);
            inputList.add(aux);
        }
        listResponse.setInputList(inputList);
        return listResponse;
    }

    @RequestMapping(value = "/findInputById", method = RequestMethod.POST)
    public InputIO findInputById(@RequestBody Integer id) {
        Input input = service.FindById(id);
        InputIO aux = mapper.map(input, InputIO.class);
        return aux;
    }

    @RequestMapping(value = "/deleteInputById", method = RequestMethod.GET)
    public boolean deleteInputById(@RequestParam Integer id) {
        boolean flag = true;
        try {
            service.DeleteRolById(id);
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
