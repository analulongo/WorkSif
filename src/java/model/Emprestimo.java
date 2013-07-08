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
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private Long codigo;
    @Column(name = "Nro_Exemplar")
    private int nroExemplar;
    @Column(length = 45, name = "ISBN")
    private String isbn;
    @Column(name = "Codigo_Assoc")
    private int codAssoc;
    /*@ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "Codigo_Assoc", nullable = false, referencedColumnName = "codigo")
     private Associado associado;

     public Associado getAssociado() {
     return associado;
     }

     public void setAssociado(Associado associado) {
     this.associado = associado;
     }
     
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ISBN", referencedColumnName = "isbn")
    private Publicacao publicacao;
    */
    
    @Column(name = "Data_Emp")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmp;
    @Column(name = "Data_Devol")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDevol;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getNroExemplar() {
        return nroExemplar;
    }

    public void setNroExemplar(int nroExemplar) {
        this.nroExemplar = nroExemplar;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /*
     public int getCodAssoc() {
     return codAssoc;
     }

     public void setCodAssoc(int codAssoc) {
     this.codAssoc = codAssoc;
     }
     */

    public Date getDataEmp() {
        return dataEmp;
    }

    public void setDataEmp(Date dataEmp) {
        this.dataEmp = dataEmp;
    }

    public Date getDataDevol() {
        return dataDevol;
    }

    public void setDataDevol(Date dataDevol) {
        this.dataDevol = dataDevol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }
}
