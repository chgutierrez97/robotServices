package com.ws.service.dto;


import java.io.Serializable;
import java.util.Collection;
						 
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author audra.zapata
 */
@Entity
@Table(name = "pantalla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantalla.findAll", query = "SELECT p FROM Pantalla p")
    , @NamedQuery(name = "Pantalla.findById", query = "SELECT p FROM Pantalla p WHERE p.id = :id")
    , @NamedQuery(name = "Pantalla.findByPantallaNumero", query = "SELECT p FROM Pantalla p WHERE p.pantallaNumero = :pantallaNumero")
    , @NamedQuery(name = "Pantalla.findByPantallaActive", query = "SELECT p FROM Pantalla p WHERE p.pantallaActive = :pantallaActive")
    , @NamedQuery(name = "Pantalla.findByPantallaActivekey", query = "SELECT p FROM Pantalla p WHERE p.pantallaActivekey = :pantallaActivekey")
    , @NamedQuery(name = "Pantalla.findByPantallaAccionTecla", query = "SELECT p FROM Pantalla p WHERE p.pantallaAccionTecla = :pantallaAccionTecla")
    , @NamedQuery(name = "Pantalla.findByPantallaAction", query = "SELECT p FROM Pantalla p WHERE p.pantallaAction = :pantallaAction")
    , @NamedQuery(name = "Pantalla.findByPantallaScrips", query = "SELECT p FROM Pantalla p WHERE p.pantallaScrips = :pantallaScrips")})
																																	  
public class Pantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pantalla_numero")
    private int pantallaNumero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pantalla_active")
    private boolean pantallaActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pantalla_activekey")
    private boolean pantallaActivekey;
							
			
    @Size(max = 30)
    @Column(name = "pantalla_accion_tecla")
    private String pantallaAccionTecla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pantalla_action")
    private String pantallaAction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "pantalla_scrips")
    private String pantallaScrips;
																											
								
									

    @OneToMany(mappedBy = "pantalla")
    private Collection<Input> inputCollection;
    
      
 
  
    @NotNull
    @JoinColumn(name = "transaccion_id")
    @ManyToOne(optional = false)
    private Transaccion transaccionId;
   
    @OneToMany(mappedBy = "pantalla")
    private Collection<TextoPantalla> textoPantallaCollection;

    public Pantalla() {
    }

    public Pantalla(Integer id) {
        this.id = id;
    }

    public Pantalla(Integer id, int pantallaNumero, boolean pantallaActive, boolean pantallaActivekey, String pantallaAction, String pantallaScrips) {
        this.id = id;
        this.pantallaNumero = pantallaNumero;
        this.pantallaActive = pantallaActive;
        this.pantallaActivekey = pantallaActivekey;
													   
        this.pantallaAction = pantallaAction;
        this.pantallaScrips = pantallaScrips;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPantallaNumero() {
        return pantallaNumero;
    }

    public void setPantallaNumero(int pantallaNumero) {
        this.pantallaNumero = pantallaNumero;
    }

    public boolean getPantallaActive() {
        return pantallaActive;
    }

    public void setPantallaActive(boolean pantallaActive) {
        this.pantallaActive = pantallaActive;
    }

    public boolean getPantallaActivekey() {
        return pantallaActivekey;
    }

    public void setPantallaActivekey(boolean pantallaActivekey) {
        this.pantallaActivekey = pantallaActivekey;
    }

    public String getPantallaAccionTecla() {
        return pantallaAccionTecla;
    }

    public void setPantallaAccionTecla(String pantallaAccionTecla) {
        this.pantallaAccionTecla = pantallaAccionTecla;
    }

    public String getPantallaAction() {
        return pantallaAction;
    }

    public void setPantallaAction(String pantallaAction) {
        this.pantallaAction = pantallaAction;
    }

    public String getPantallaScrips() {
        return pantallaScrips;
    }

    public void setPantallaScrips(String pantallaScrips) {
        this.pantallaScrips = pantallaScrips;
    }

										 
						   
	 

														 
									   
	 

    @XmlTransient
    public Collection<Input> getInputCollection() {
        return inputCollection;
    }

    public void setInputCollection(Collection<Input> inputCollection) {
        this.inputCollection = inputCollection;
    }

    public Transaccion getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(Transaccion transaccionId) {
        this.transaccionId = transaccionId;
    }

    @XmlTransient
    public Collection<TextoPantalla> getTextoPantallaCollection() {
        return textoPantallaCollection;
    }

    public void setTextoPantallaCollection(Collection<TextoPantalla> textoPantallaCollection) {
        this.textoPantallaCollection = textoPantallaCollection;
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
        if (!(object instanceof Pantalla)) {
		 
						  
            return false;
        }
        Pantalla other = (Pantalla) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
											  
												 
						 
		 
        return true;
    }

    @Override
    public String toString() {
        return "com.ejemplo.demos.modelNew.Pantalla[ id=" + id + " ]";
    }
    
}
