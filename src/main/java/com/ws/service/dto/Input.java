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
@Table(name = "input")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Input.findAll", query = "SELECT i FROM Input i")
    , @NamedQuery(name = "Input.findById", query = "SELECT i FROM Input i WHERE i.id = :id")
    , @NamedQuery(name = "Input.findByInputType", query = "SELECT i FROM Input i WHERE i.inputType = :inputType")
    , @NamedQuery(name = "Input.findByInputId", query = "SELECT i FROM Input i WHERE i.inputId = :inputId")
    , @NamedQuery(name = "Input.findByInputName", query = "SELECT i FROM Input i WHERE i.inputName = :inputName")
    , @NamedQuery(name = "Input.findByInputLabel", query = "SELECT i FROM Input i WHERE i.inputLabel = :inputLabel")
    , @NamedQuery(name = "Input.findByInputRequired", query = "SELECT i FROM Input i WHERE i.inputRequired = :inputRequired")
    , @NamedQuery(name = "Input.findByInputValue", query = "SELECT i FROM Input i WHERE i.inputValue = :inputValue")
    , @NamedQuery(name = "Input.findByPantallaId", query = "SELECT i FROM Input i WHERE i.pantalla.id = :pantallaId")})
public class Input implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size( max = 45)
    @Column(name = "input_type")
    private String inputType;
    @Basic(optional = false)
    @NotNull
    @Size( max = 45)
    @Column(name = "input_id")
    private String inputId;
    @Basic(optional = false)
    @NotNull
    @Size( max = 70)
    @Column(name = "input_name")
    private String inputName;
    @Basic(optional = false)
    @Size( max = 200)
    @Column(name = "input_label")
    private String inputLabel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "input_required")
    private boolean inputRequired;
    @Size(max = 500)
    @Column(name = "input_value")
    private String inputValue;
 
 
    
    @NotNull
    @JoinColumn(name = "pantalla_id")
    @ManyToOne(optional = false)
    private Pantalla pantalla;

    public Input() {
    }

    public Input(Integer id) {
        this.id = id;
    }


    public Input(Integer id, String inputType, String inputId, String inputName, String inputLabel, boolean inputRequired) {
        this.id = id;
        this.inputType = inputType;
        this.inputId = inputId;
        this.inputName = inputName;
        this.inputLabel = inputLabel;
        this.inputRequired = inputRequired;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getInputId() {
        return inputId;
    }

    public void setInputId(String inputId) {
        this.inputId = inputId;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputLabel() {
        return inputLabel;
    }

    public void setInputLabel(String inputLabel) {
        this.inputLabel = inputLabel;
    }

    public boolean getInputRequired() {
        return inputRequired;
    }

    public void setInputRequired(boolean inputRequired) {
        this.inputRequired = inputRequired;
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
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
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Input other = (Input) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Input{" + "id=" + id + '}';
    }


    
}
