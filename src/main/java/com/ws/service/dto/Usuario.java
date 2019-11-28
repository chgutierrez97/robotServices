/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author audra.zapata
 */
    @Entity
@Table(name = "usuario")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
//    , @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.id = :id")
//    , @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario")
//    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")
//    , @NamedQuery(name = "Usuario.findByFechaCarga", query = "SELECT u FROM Usuario u WHERE u.fechaCarga = :fechaCarga")
//    , @NamedQuery(name = "Usuario.findByRolesId", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.rolesId = :rolesId")
//    , @NamedQuery(name = "Usuario.findByPersonaid", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.personaid = :personaid")
//    , @NamedQuery(name = "Usuario.findByStatusId", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.statusId = :statusId")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "fecha_carga")
    @Temporal(TemporalType.DATE)
    private Date fechaCarga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<Transaccion> transaccionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Collection<SecurityQuetion> securityQuetionCollection;
    @JoinColumn(name = "Persona_id")
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "roles_id")
    @ManyToOne(optional = false)
    private Roles roles;
    @JoinColumn(name = "status_id")
    @ManyToOne(optional = false)
    private Status status;

    public Usuario() {
    }
    


    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(int id, String usuario, String clave, Date fechaCarga, Persona persona, Roles roles, Status status) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.fechaCarga = fechaCarga;
        this.persona = persona;
        this.roles = roles;
        this.status = status;
    }

    public Usuario(int id, String usuario, String clave, Collection<Transaccion> transaccionCollection, Collection<SecurityQuetion> securityQuetionCollection, Persona persona, Roles roles, Status status) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.transaccionCollection = transaccionCollection;
        this.securityQuetionCollection = securityQuetionCollection;
        this.persona = persona;
        this.roles = roles;
        this.status = status;
    }

    
    
    public int getId() {
        return id;
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
    
    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }


    @XmlTransient
    public Collection<SecurityQuetion> getSecurityQuetionCollection() {
        return securityQuetionCollection;
    }

    public void setSecurityQuetionCollection(Collection<SecurityQuetion> securityQuetionCollection) {
        this.securityQuetionCollection = securityQuetionCollection;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + '}';
    }
    
}
