package com.ws.service.api;

import com.ws.service.dto.Cancelaciones;
import com.ws.service.dto.Status;
import com.ws.service.reqrep.CancelacionesDto;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.reqrep.StatusIO;
import com.ws.service.servi.CancelacionesService;
import com.ws.service.servi.StatusService;
import com.ws.service.util.UtilRobotEncrips;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@PropertySource("classpath:application.properties")
public class CancelacionesApi {

    @Autowired
    CancelacionesService cancelacionesService;

    @Autowired
    Mapper mapper;
    
    @Autowired
    UtilRobotEncrips ultilEncrips;

    @Value("${com.scrips.key}")
    private String key;

    @Value("${com.scrips.iv}")
    private String iv;

    @RequestMapping(value = "/saveCancelacion", method = RequestMethod.POST)
    public CancelacionesDto saveStatus(@RequestBody CancelacionesDto cancelacionesDto) {
        // Mapeo request a StatusIOentity

        Cancelaciones Cancelacion = mapper.map(cancelacionesDto, Cancelaciones.class);
        // Invoca lógica de negocio
        System.out.println("si llego");
        Cancelaciones updatedCancelacion = cancelacionesService.save(Cancelacion);
        // Mapeo entity a response
        CancelacionesDto cancelacionesDto2 = mapper.map(updatedCancelacion, CancelacionesDto.class);

        return cancelacionesDto2;
    }

    @RequestMapping(value = "/saveCancelacionGet", method = RequestMethod.GET)
    public CancelacionesDto saveCancelacionGet(@RequestParam Integer flag, @RequestParam String op, @RequestParam String alterna, @RequestParam String proceso) {
        Cancelaciones cancelacion = new Cancelaciones();
        cancelacion.setFlag(flag);
        cancelacion.setOpion(op);
        cancelacion.setFecha(new Date());
        cancelacion.setProceso(proceso);
        String  desencritada ="";
        try {
             desencritada = ultilEncrips.decrypt(key, iv, alterna);
        } catch (Exception e) {
            e.printStackTrace();
        }
        cancelacion.setAlterna(alterna);
        Cancelaciones cancelacionSave = cancelacionesService.save(cancelacion);
        CancelacionesDto cancelacionAux = mapper.map(cancelacionSave, CancelacionesDto.class);
        return cancelacionAux;
    }

 

    @RequestMapping(value = "/findAllCancelacion", method = RequestMethod.GET)
    public ListaMacroIO findAllStatus() {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<Cancelaciones> listCancelaciones = cancelacionesService.FindAll();
        List<CancelacionesDto> cancelacionesList = new ArrayList<>();
        for (Cancelaciones cancelacion : listCancelaciones) {
            CancelacionesDto cancelacionAux = mapper.map(cancelacion, CancelacionesDto.class);
            cancelacionesList.add(cancelacionAux);
        }
        listResponse.setCancelacionesList(cancelacionesList);
        return listResponse;
    }

    @RequestMapping(value = "/findCancelacionById", method = RequestMethod.GET)
    public CancelacionesDto findStatusById(@RequestParam Integer id) {
        Cancelaciones cancelaciones = cancelacionesService.FindById(id);
        CancelacionesDto cancelacionAux = mapper.map(cancelaciones, CancelacionesDto.class);
        return cancelacionAux;
    }

    @RequestMapping(value = "/deleteCancelacionById", method = RequestMethod.GET)
    public boolean deleteCancelacionById(@RequestParam Integer id) {
        boolean flag = true;
        try {
            cancelacionesService.DeleteCancelacionesById(id);
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
