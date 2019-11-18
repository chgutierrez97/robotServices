package com.ws.service.reqrep;

import com.ws.service.dto.*;
import java.io.Serializable;
import java.util.Date;

public class TransaccionIO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String nombre;

    private String descripcion;

    private String aplicativoExternocol;

    private Date fechaCarga;
    
    private Integer tipoAplicativo;

    private String tipo;
    
    private Integer transaccionIni;
    
    

//    private Usuario usuario;
    public TransaccionIO() {
    }

    public TransaccionIO(int id) {
        this.id = id;
    }

    public TransaccionIO(int id, String nombre, String descripcion, String aplicativoExternocol, Date fechaCarga, Integer tipoAplicativo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aplicativoExternocol = aplicativoExternocol;
        this.fechaCarga = fechaCarga;
        this.tipoAplicativo = tipoAplicativo;
        //this.usuario = usuario;
    }

    public TransaccionIO(int id, String nombre, String descripcion, String aplicativoExternocol, Date fechaCarga, Integer tipoAplicativo, String tipo, Integer transaccionIni) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aplicativoExternocol = aplicativoExternocol;
        this.fechaCarga = fechaCarga;
        this.tipoAplicativo = tipoAplicativo;
        this.tipo = tipo;
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

    public Integer getTransaccionIni() {
        return transaccionIni;
    }

    public void setTransaccionIni(Integer transaccionIni) {
        this.transaccionIni = transaccionIni;
    }
    
    

//    public Usuario getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(Usuario usuario) {
//        this.usuario = usuario;
//    }
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
        final TransaccionIO other = (TransaccionIO) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TransaccionIO{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", aplicativoExternocol=" + aplicativoExternocol + ", fechaCarga=" + fechaCarga + ", tipoAplicativo=" + tipoAplicativo + ", tipo=" + tipo + '}';
    }

}
