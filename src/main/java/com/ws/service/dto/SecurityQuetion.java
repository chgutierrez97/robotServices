/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author audra.zapata
 */
@Entity
@Table(name = "security_quetion")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "SecurityQuetion.findAll", query = "SELECT s FROM SecurityQuetion s")
//    , @NamedQuery(name = "SecurityQuetion.findById", query = "SELECT s FROM SecurityQuetion s WHERE s.securityQuetionPK.id = :id")
//    , @NamedQuery(name = "SecurityQuetion.findByPreguta", query = "SELECT s FROM SecurityQuetion s WHERE s.preguta = :preguta")
//    , @NamedQuery(name = "SecurityQuetion.findByRespuesta", query = "SELECT s FROM SecurityQuetion s WHERE s.respuesta = :respuesta")
//    , @NamedQuery(name = "SecurityQuetion.findByUsuarioId", query = "SELECT s FROM SecurityQuetion s WHERE s.securityQuetionPK.usuarioId = :usuarioId")
//    , @NamedQuery(name = "SecurityQuetion.findByUsuarioPersonaId", query = "SELECT s FROM SecurityQuetion s WHERE s.usuarioPersonaId = :usuarioPersonaId")
//    , @NamedQuery(name = "SecurityQuetion.findByUsuarioRolesId", query = "SELECT s FROM SecurityQuetion s WHERE s.usuarioRolesId = :usuarioRolesId")
//    , @NamedQuery(name = "SecurityQuetion.findByUsuarioStatusId", query = "SELECT s FROM SecurityQuetion s WHERE s.usuarioStatusId = :usuarioStatusId")})
public class SecurityQuetion implements Serializable {

    private static final long serialVersionUID = 1L;
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "preguta")
    private String preguta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "respuesta")
    private String respuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_persona_id")
    private int usuarioPersonaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_roles_id")
    private int usuarioRolesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_status_id")
    private int usuarioStatusId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public SecurityQuetion() {
    }



    public SecurityQuetion(int id) {
        this.id = id;
    }

    public SecurityQuetion(int id, String preguta, String respuesta, int usuarioPersonaId, int usuarioRolesId, int usuarioStatusId, Usuario usuario) {
        this.id = id;
        this.preguta = preguta;
        this.respuesta = respuesta;
        this.usuarioPersonaId = usuarioPersonaId;
        this.usuarioRolesId = usuarioRolesId;
        this.usuarioStatusId = usuarioStatusId;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getPreguta() {
        return preguta;
    }

    public void setPreguta(String preguta) {
        this.preguta = preguta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getUsuarioPersonaId() {
        return usuarioPersonaId;
    }

    public void setUsuarioPersonaId(int usuarioPersonaId) {
        this.usuarioPersonaId = usuarioPersonaId;
    }

    public int getUsuarioRolesId() {
        return usuarioRolesId;
    }

    public void setUsuarioRolesId(int usuarioRolesId) {
        this.usuarioRolesId = usuarioRolesId;
    }

    public int getUsuarioStatusId() {
        return usuarioStatusId;
    }

    public void setUsuarioStatusId(int usuarioStatusId) {
        this.usuarioStatusId = usuarioStatusId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    @Override
    public int hashCode() {
        int hash = 7;
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
        final SecurityQuetion other = (SecurityQuetion) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SecurityQuetion{" + "id=" + id + ", preguta=" + preguta + ", respuesta=" + respuesta + ", usuarioPersonaId=" + usuarioPersonaId + ", usuarioRolesId=" + usuarioRolesId + ", usuarioStatusId=" + usuarioStatusId + ", usuario=" + usuario + '}';
    }
    
    
}
