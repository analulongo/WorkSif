/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "reserva")
@NamedQueries({
   @NamedQuery(name = "Reserva.Ativa", query = "SELECT e FROM Exemplar e WHERE e.publicacao.isbn=:isbn ")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private Long codigo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ISBN", referencedColumnName = "isbn")
    private Publicacao publicacao;

     @Column(name = "DataR")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataR;
     
    @Column(name= "Status")
    private String status;

    public Date getDataR() {
        return dataR;
    }

    public void setDataR(Date dataR) {
        this.dataR = dataR;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

 
  

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }
    

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Codigo_Assoc", referencedColumnName = "Codigo")
    private Associado associado;

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the codigo fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reserva[ id=" + codigo + " ]";
    }
}
