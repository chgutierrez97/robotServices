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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "transaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaccion.findAll", query = "SELECT t FROM Transaccion t")
    , @NamedQuery(name = "Transaccion.findById", query = "SELECT t FROM Transaccion t WHERE t.id = :id")
    , @NamedQuery(name = "Transaccion.findByNombre", query = "SELECT t FROM Transaccion t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Transaccion.findByDescripcion", query = "SELECT t FROM Transaccion t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Transaccion.findByAplicativoExternocol", query = "SELECT t FROM Transaccion t WHERE t.aplicativoExternocol = :aplicativoExternocol")
    , @NamedQuery(name = "Transaccion.findByFechaCarga", query = "SELECT t FROM Transaccion t WHERE t.fechaCarga = :fechaCarga")})
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "aplicativo_externocol")
    private String aplicativoExternocol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_carga")
    @Temporal(TemporalType.DATE)
    private Date fechaCarga;
    @Column(name = "tipo_aplicativo")
    private Integer tipoAplicativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo")
    private String tipo;
    @NotNull
    @JoinColumn(name = "usuario_id")
    @ManyToOne(optional = false)
    private Usuario usuario;
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transaccionId")
    private Collection<Pantalla> pantallaCollection;
    
    @Column(name = "transaccion_ini")
    private Integer transaccionIni;


    public Transaccion() {
    }

    public Transaccion(int id) {
        this.id = id;
    }

    public Transaccion(int id, String nombre, String descripcion, String aplicativoExternocol, Date fechaCarga, Usuario usuario, Integer tipoAplicativo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aplicativoExternocol = aplicativoExternocol;
        this.fechaCarga = fechaCarga;
        this.usuario = usuario;
        this.tipoAplicativo = tipoAplicativo;
    }

    public Transaccion(int id, String nombre, String descripcion, String aplicativoExternocol, Date fechaCarga, Integer tipoAplicativo, String tipo, Usuario usuario, Collection<Pantalla> pantallaCollection) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aplicativoExternocol = aplicativoExternocol;
        this.fechaCarga = fechaCarga;
        this.tipoAplicativo = tipoAplicativo;
        this.tipo = tipo;
        this.usuario = usuario;
        this.pantallaCollection = pantallaCollection;
    }

    public Transaccion(int id, String nombre, String descripcion, String aplicativoExternocol, Date fechaCarga, Integer tipoAplicativo, String tipo, Usuario usuario, Collection<Pantalla> pantallaCollection, Integer transaccionIni) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aplicativoExternocol = aplicativoExternocol;
        this.fechaCarga = fechaCarga;
        this.tipoAplicativo = tipoAplicativo;
        this.tipo = tipo;
        this.usuario = usuario;
        this.pantallaCollection = pantallaCollection;
        this.transaccionIni = transaccionIni;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAplicativoExternocol() {
        return aplicativoExternocol;
    }

    public void setAplicativoExternocol(String aplicativoExternocol) {
        this.aplicativoExternocol = aplicativoExternocol;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public Integer getTipoAplicativo() {
        return tipoAplicativo;
    }

    public void setTipoAplicativo(Integer tipoAplicativo) {
        this.tipoAplicativo = tipoAplicativo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Collection<Pantalla> getPantallaCollection() {
        return pantallaCollection;
    }

    public void setPantallaCollection(Collection<Pantalla> pantallaCollection) {
        this.pantallaCollection = pantallaCollection;
    }

    public Integer getTransaccionIni() {
        return transaccionIni;
    }

    public void setTransaccionIni(Integer transaccionIni) {
        this.transaccionIni = transaccionIni;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
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
        final Transaccion other = (Transaccion) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", aplicativoExternocol=" + aplicativoExternocol + ", fechaCarga=" + fechaCarga + ", usuario=" + usuario + '}';
    }

    
}
