/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Felipe
 */
@Entity
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="Codigo")
    private Long id;
    
    @Column(length = 12, name = "ISBN")
    private String isbn;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
     @Column(name = "Data_Emp")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataRes;
  
    @Column(name = "Codigo_Assoc")
    private int codAssoc;
    
    
    
    @Column(name = "Status")
    private int status;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public int getCodAssoc() {
        return codAssoc;
    }

    public void setCodAssoc(int codAssoc) {
        this.codAssoc = codAssoc;
    }

    public Date getDataRes() {
        return dataRes;
    }

    public void setDataRes(Date dataRes) {
        this.dataRes = dataRes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reserva[ id=" + id + " ]";
    }
    
}
