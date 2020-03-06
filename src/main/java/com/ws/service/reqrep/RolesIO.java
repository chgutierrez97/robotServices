/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.reqrep;

import java.io.Serializable;


public class RolesIO implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Integer id;

    private String descripcion;
    
    private String label;
    
  
   
    public RolesIO() {
    }

    public RolesIO(Integer id) {
        this.id = id;
    }

    public RolesIO(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RolesIO)) {
            return false;
        }
        RolesIO other = (RolesIO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RolesIO{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
}
