package com.ws.service.api;



import com.ws.service.dto.SecurityQuetion;
import com.ws.service.reqrep.ListaMacroIO;
import com.ws.service.reqrep.SecurityQuetionIO;
import com.ws.service.servi.SecurityQuetionService;

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
public class SecurityQuetionApi {

    @Autowired
    SecurityQuetionService securityQuetionService;

    @Autowired
    Mapper mapper;
    @RequestMapping(value = "/saveSecurityQuetionService", method = RequestMethod.POST)
    public SecurityQuetionIO saveSecurityQuetionService(@RequestBody SecurityQuetionIO securityQuetionIO) {
        // Mapeo request a entity
        SecurityQuetion securityQuetion = mapper.map(securityQuetionIO, SecurityQuetion.class);
        // InvocSecurityQuetionIOa lógica de negocio
        SecurityQuetion updatedSecurityQuetion = securityQuetionService.save(securityQuetion);
        // Mapeo enSecurityQuetionIOtity a response
        SecurityQuetionIO  securityQuetionResponse = mapper.map(updatedSecurityQuetion, SecurityQuetionIO.class);

        return securityQuetionResponse; 
    }
    
    @RequestMapping(value = "/findAllSecurityQuetionService", method = RequestMethod.GET)
    public ListaMacroIO findAllSecurityQuetionService() {
        ListaMacroIO listResponse = new ListaMacroIO();
        List<SecurityQuetion> listSecurityQuetion = securityQuetionService.FindAll();
        List<SecurityQuetionIO> securityQuetionIOList = new ArrayList<>();
        for (SecurityQuetion quetion : listSecurityQuetion) {
           SecurityQuetionIO SecurityQuetionAux= mapper.map(quetion, SecurityQuetionIO.class);
            securityQuetionIOList.add(SecurityQuetionAux);  
        }
        listResponse.setSecurityQuetionIOList(securityQuetionIOList);
        return listResponse;
    }
    
    @RequestMapping(value = "/findSecurityQuetionServiceById", method = RequestMethod.POST)
    public SecurityQuetionIO findSecurityQuetionServiceById(@RequestBody Integer id) {       
        SecurityQuetion securityQuetion = securityQuetionService.FindById(id);        
           SecurityQuetionIO securityQuetionIO= mapper.map(securityQuetion, SecurityQuetionIO.class);
        return securityQuetionIO;
    }
    

    @RequestMapping(value = "/deleteSecurityQuetionServiceById", method = RequestMethod.GET)
    public boolean deleteSecurityQuetionServiceById(@RequestParam Integer id) {
        boolean flag = true;
        try {
             securityQuetionService.DeletesecurityQuetionServiceById(id);
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
