
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


@Entity
@Table(name = "cancelaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancelaciones.findAll", query = "SELECT c FROM Cancelaciones c")
    , @NamedQuery(name = "Cancelaciones.findById", query = "SELECT c FROM Cancelaciones c WHERE c.id = :id")
    , @NamedQuery(name = "Cancelaciones.findByProceso", query = "SELECT c FROM Cancelaciones c WHERE c.proceso = :proceso")
    , @NamedQuery(name = "Cancelaciones.findByFlag", query = "SELECT c FROM Cancelaciones c WHERE c.flag = :flag")
    , @NamedQuery(name = "Cancelaciones.findByFecha", query = "SELECT c FROM Cancelaciones c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Cancelaciones.findByOpion", query = "SELECT c FROM Cancelaciones c WHERE c.opion = :opion")
    , @NamedQuery(name = "Cancelaciones.findByAlterna", query = "SELECT c FROM Cancelaciones c WHERE c.alterna = :alterna")})
public class Cancelaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "proceso")
    private String proceso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag")
    private Integer flag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 2)
    @Column(name = "opion")
    private String opion;
    @Size(max = 1500)
    @Column(name = "alterna")
    private String alterna;

    public Cancelaciones() {
    }

    public Cancelaciones(Integer id) {
        this.id = id;
    }

    public Cancelaciones(Integer id, String proceso, Integer flag, Date fecha, String opion, String alterna) {
        this.id = id;
        this.proceso = proceso;
        this.flag = flag;
        this.fecha = fecha;
        this.opion = opion;
        this.alterna = alterna;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOpion() {
        return opion;
    }

    public void setOpion(String opion) {
        this.opion = opion;
    }

    public String getAlterna() {
        return alterna;
    }

    public void setAlterna(String alterna) {
        this.alterna = alterna;
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
        if (!(object instanceof Cancelaciones)) {
            return false;
        }
        Cancelaciones other = (Cancelaciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ejemplo.demos.Cancelaciones[ id=" + id + " ]";
    }
    
}
