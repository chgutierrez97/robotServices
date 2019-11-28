package com.ws.service.api;


import com.ws.service.dto.Roles;
import com.ws.service.dto.Status;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.reqrep.RolesIO;
import com.ws.service.reqrep.StatusIO;
import com.ws.service.servi.RolService;
import com.ws.service.servi.StatusService;
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
public class StatusApi {

    @Autowired
    StatusService statusService;

    @Autowired
    Mapper mapper;
    @RequestMapping(value = "/saveStatus", method = RequestMethod.POST)
    public StatusIO saveStatus(@RequestBody StatusIO statusIO) {
        // Mapeo request a StatusIOentity
        Status status = mapper.map(statusIO, Status.class);
        // Invoca lógica de negocio
        Status updatedStattus = statusService.save(status);
        // Mapeo entity a response
        StatusIO statusResponse = mapper.map(updatedStattus, StatusIO.class);

        return statusResponse;
    }
    
    @RequestMapping(value = "/findAllStatus", method = RequestMethod.GET)
    public ListaMacroIO findAllStatus() {
         ListaMacroIO listResponse = new ListaMacroIO();
        List<Status> listStatus = statusService.FindAll();
        List<StatusIO> statusList = new ArrayList<>();
        for (Status status : listStatus) {
           StatusIO rolAux= mapper.map(status, StatusIO.class);
            statusList.add(rolAux);  
        }
        listResponse.setStatusList(statusList);
        return listResponse;
    }
    
    @RequestMapping(value = "/findStatusById", method = RequestMethod.POST)
    public StatusIO findStatusById(@RequestBody Integer id) {       
        Status status = statusService.FindById(id);        
           StatusIO statusAux = mapper.map(status, StatusIO.class);
        return statusAux;
    }
    

    @RequestMapping(value = "/deleteStatusById", method = RequestMethod.GET)
    public boolean deleteStatusById(@RequestParam Integer id) {
        boolean flag = true;
        try {
             statusService.DeleteRolById(id);
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
