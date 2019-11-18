/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.reqrep;

import com.ws.service.dto.Persona;
import com.ws.service.dto.Roles;
import com.ws.service.dto.SecurityQuetion;
import com.ws.service.dto.Status;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;


public class UsuarioIO implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Integer id;

    private String usuario;
    private String clave;
    private Date fechaCarga;
    private Collection<SecurityQuetionIO> listSecurityQuetionIO;
    
    private PersonaIO persona;
    private RolesIO roles;
    private StatusIO status;
  
   
    public UsuarioIO() {
    }

    public UsuarioIO(Integer id, String usuario, String clave, Date fechaCarga, Collection<SecurityQuetion> securityQuetionCollection, PersonaIO persona, RolesIO roles, StatusIO status) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.fechaCarga = fechaCarga;
        
        this.persona = persona;
        this.roles = roles;
        this.status = status;
    }
    

    public UsuarioIO(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Collection<SecurityQuetionIO> getListSecurityQuetion() {
        return listSecurityQuetionIO;
    }

    public void setListSecurityQuetion(Collection<SecurityQuetionIO> listSecurityQuetionIO) {
        this.listSecurityQuetionIO = listSecurityQuetionIO;
    }

    

    public PersonaIO getPersona() {
        return persona;
    }

    public void setPersona(PersonaIO persona) {
        this.persona = persona;
    }

    public RolesIO getRoles() {
        return roles;
    }

    public void setRoles(RolesIO roles) {
        this.roles = roles;
    }

    public StatusIO getStatus() {
        return status;
    }

    public void setStatus(StatusIO status) {
        this.status = status;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioIO)) {
            return false;
        }
        UsuarioIO other = (UsuarioIO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.ar.ser.model.Roles[ id=" + id + " ]";
//    }

//    @Override
//    public String toString() {
//        return "UsuarioIO{" + "id=" + id + ", usuario=" + usuario + ", clave=" + clave + ", fechaCarga=" + fechaCarga + ", persona=" + persona + ", roles=" + roles + ", status=" + status + '}';
//    }

    @Override
    public String toString() {
        return "UsuarioIO{" + "id=" + id + ", usuario=" + usuario + ", clave=" + clave + ", fechaCarga=" + fechaCarga + ", roles=" + roles + ", status=" + status + '}';
    }

   

    
   
}
