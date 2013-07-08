/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rosiani
 */
@Entity
@Table(name = "exemplar")
@NamedQueries({
    @NamedQuery(name = "Exemplar.AllConsultaISBN", query = "Select e FROM Exemplar e WHERE e.publicacao.isbn=:isbn or e.publicacao.titulo=:titulo")})
public class Exemplar implements Serializable {

    @Id
    @Column(name = "Numero")
    private Long numero;

    @Column(name = "Preco")
    private Double preco;
    
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ISBN", referencedColumnName = "isbn")
    private Publicacao publicacao;

        @OneToMany(mappedBy = "exemplar", fetch = FetchType.EAGER)
    private List<Emprestimo> emprestimoList;

    
    
    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
    
      public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Emprestimo> getEmprestimoList() {
        return emprestimoList;
    }

    public void setEmprestimoList(List<Emprestimo> emprestimoList) {
        this.emprestimoList = emprestimoList;
    }
        @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicacao != null ? publicacao.hashCode() : 0);
        return hash;
    }
    
  @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exemplar)) {
            return false;
        }
        Exemplar other = (Exemplar) object;
        if ((this.publicacao== null && other.publicacao!= null) || (this.publicacao != null && !this.publicacao.equals(other.publicacao))) {
            return false;
        }
        return true;
    }

}
