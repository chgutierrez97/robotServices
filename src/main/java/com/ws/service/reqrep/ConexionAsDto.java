package com.ws.service.reqrep;

;

import java.util.Date;


public class ConexionAsDto {

	private Long id;
	private String conexionName;
	private String servidor;
	private String usuario;
	private String clave;
        private Date fechaCreacion;
      

    public ConexionAsDto() {
    }

    public ConexionAsDto(Long id, String conexionName, String servidor, String usuario, String clave, Date fechaCreacion) {
        this.id = id;
        this.conexionName = conexionName;
        this.servidor = servidor;
        this.usuario = usuario;
        this.clave = clave;
        this.fechaCreacion = fechaCreacion;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getConexionName() {
        return conexionName;
    }

    public void setConexionName(String conexionName) {
        this.conexionName = conexionName;
    }

    @Override
    public String toString() {
        return "ConexionAsDto{" + "id=" + id + ", conexionName=" + conexionName + ", servidor=" + servidor + ", usuario=" + usuario + ", clave=" + clave + ", fechaCreacion=" + fechaCreacion + '}';
    }
}
