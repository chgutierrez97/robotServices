/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author audra.zapata
 */
@Entity
@Table(name = "conexion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conexion.findAll", query = "SELECT c FROM Conexion c")
    , @NamedQuery(name = "Conexion.findById", query = "SELECT c FROM Conexion c WHERE c.id = :id")
    , @NamedQuery(name = "Conexion.findByConexionName", query = "SELECT c FROM Conexion c WHERE c.conexionName = :conexionName")
    , @NamedQuery(name = "Conexion.findByServidor", query = "SELECT c FROM Conexion c WHERE c.servidor = :servidor")
    , @NamedQuery(name = "Conexion.findByUsuario", query = "SELECT c FROM Conexion c WHERE c.usuario = :usuario")
    , @NamedQuery(name = "Conexion.findByClave", query = "SELECT c FROM Conexion c WHERE c.clave = :clave")
    , @NamedQuery(name = "Conexion.findByFechaCreacion", query = "SELECT c FROM Conexion c WHERE c.fechaCreacion = :fechaCreacion")})
public class Conexion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "conexionName")
    private String conexionName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "servidor")
    private String servidor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    public Conexion() {
    }

    public Conexion(Integer id) {
        this.id = id;
    }

    public Conexion(Integer id, String conexionName, String servidor, String usuario, String clave, Date fechaCreacion) {
        this.id = id;
        this.conexionName = conexionName;
        this.servidor = servidor;
        this.usuario = usuario;
        this.clave = clave;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConexionName() {
        return conexionName;
    }

    public void setConexionName(String conexionName) {
        this.conexionName = conexionName;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
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
        if (!(object instanceof Conexion)) {
            return false;
        }
        Conexion other = (Conexion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ar.acc.proservices.model.Conexion[ id=" + id + " ]";
    }
    
}
