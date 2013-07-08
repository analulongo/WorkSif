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
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "reserva")
@NamedQueries({
    @NamedQuery(name = "Reserva.Ativa", query = "SELECT c FROM Reserva c WHERE c.publicacao.isbn=:isbn")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private Long codigo;
   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ISBN", nullable = false, referencedColumnName = "ISBN")
    private Publicacao publicacao;

    @Column(name = "DataR")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataRes;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Codigo_Assoc", referencedColumnName = "Codigo")
    private Associado associado;

    @Column(name = "Status")
    private int status;

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
      public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }
    
        public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
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
