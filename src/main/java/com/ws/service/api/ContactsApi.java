package com.ws.service.api;

import com.ws.service.reqrep.ContactRequest;
import com.ws.service.reqrep.ContactResponse;
import com.ws.service.dto.Contact;
import com.ws.service.dto.Persona;
import com.ws.service.reqrep.PersonaIO;
import com.ws.service.servi.ContactService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContactsApi {

    @Autowired
    ContactService contactService;

    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Contact getById() {
        //URL fileLocation = getClass().getClassLoader().getResource(".test.properties");
//
//        Properties p = new Properties();
//      
//        File f = new File("ruta/al/externo.properties");
//        if (f.exists() && f.canRead()) {
//            try (FileInputStream ins = new FileInputStream(f)) {
//                p.load(ins);
//            } catch (IOException ex) {
//                Logger.getLogger(ContactsApi.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        try {
//           getDestiny(); 
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
        return new Contact(1L, "John", "Doe", "+57 311 222 3344", "john@sinbugs.com");
    }

    
    public String getDestiny() throws IOException
    {
        String valor = null;
        Properties archivoPropertie = new Properties();
        FileInputStream archivo;
        String ruta = "./test.properties"; //Se debe guardar en la misma ruta del JAR
        archivo = new FileInputStream(ruta);
        archivoPropertie.load(archivo);
        archivo.close();
        valor = archivoPropertie.getProperty("destiny");
        return valor;
    }
    
    
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List <ContactResponse> findAll() {
        
        List<Contact> listContact = contactService.findAll();
        List<ContactResponse> contactResponseList = new ArrayList<>();
        for (Contact pers : listContact) {
           ContactResponse contracAux= mapper.map(pers, ContactResponse.class);
            contactResponseList.add(contracAux);  
        }
        return contactResponseList;
    }
    
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ContactResponse updateOrSave(@RequestBody ContactRequest contactRequest) {
        // Mapeo request dt
        Contact contact = mapper.map(contactRequest, Contact.class);

        // Invoca lógica de negocio
        Contact updatedContact = contactService.save(contact);

        // Mapeo entity ==&amp;amp;amp;amp;amp;gt; response dto
        ContactResponse contactResponse = mapper.map(updatedContact, ContactResponse.class);

        return contactResponse;
    }

}
