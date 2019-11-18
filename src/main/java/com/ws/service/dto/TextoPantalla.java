/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "texto_pantalla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TextoPantalla.findAll", query = "SELECT t FROM TextoPantalla t")
    , @NamedQuery(name = "TextoPantalla.findByTexto", query = "SELECT t FROM TextoPantalla t WHERE t.texto = :texto")})
public class TextoPantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Size(min = 1, max = 80)
    @Column(name = "texto")
    private String texto;
    @JoinColumn(name = "pantalla_id", referencedColumnName="id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pantalla pantalla;

    public TextoPantalla() {
    }

    public TextoPantalla(Integer id, String texto, Pantalla pantalla) {
        this.id = id;
        this.texto = texto;
        this.pantalla = pantalla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Pantalla getPantalla() {
        return pantalla;
    }

    public void setPantalla(Pantalla pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final TextoPantalla other = (TextoPantalla) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TextoPantalla{" + "id=" + id + ", texto=" + texto + '}';
    }
    
}
