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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author audra.zapata
 */
@Entity
@Table(name = "expresiones_regulares")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExpresionesRegulares.findAll", query = "SELECT e FROM ExpresionesRegulares e")
    , @NamedQuery(name = "ExpresionesRegulares.findById", query = "SELECT e FROM ExpresionesRegulares e WHERE e.id = :id")
    , @NamedQuery(name = "ExpresionesRegulares.findByCodError", query = "SELECT e FROM ExpresionesRegulares e WHERE e.codError = :codError")
    , @NamedQuery(name = "ExpresionesRegulares.findByMensajeError", query = "SELECT e FROM ExpresionesRegulares e WHERE e.mensajeError = :mensajeError")})
public class ExpresionesRegulares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "cod_error")
    private String codError;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "mensaje_error")
    private String mensajeError;
    @Size(max = 30)
    @Column(name = "w_accionar")
    private String wAccionar;

    public ExpresionesRegulares() {
    }

    public ExpresionesRegulares(Integer id) {
        this.id = id;
    }

    public ExpresionesRegulares(Integer id, String codError, String mensajeError) {
        this.id = id;
        this.codError = codError;
        this.mensajeError = mensajeError;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodError() {
        return codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getwAccionar() {
        return wAccionar;
    }

    public void setwAccionar(String wAccionar) {
        this.wAccionar = wAccionar;
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
        if (!(object instanceof ExpresionesRegulares)) {
            return false;
        }
        ExpresionesRegulares other = (ExpresionesRegulares) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.demo.ExpresionesRegulares[ id=" + id + " ]";
    }
    
}
