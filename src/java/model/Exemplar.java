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
    @NamedQuery(name = "Exemplar.AllConsultaISBN", query = "Select e FROM Exemplar e join e.publicacao p WHERE p.isbn=:isbn or p.titulo=:titulo and p=e.publicacao")})
public class Exemplar implements Serializable {

    @Id
    @Column(name = "Numero")
    private Long numero;
    /*
     @Column(name = "ISBN")
     private String isbn;

     public String getIsbn2() {
     return isbn;
     }

     public void setIsbn2(String isbn) {
     this.isbn = isbn;
     }*/
    @Column(name = "Preco")
    private float preco;
    /*
    @OneToMany(mappedBy = "emprestimo", fetch = FetchType.LAZY)
    private List< Emprestimo> EmprestimoList;
    */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ISBN", referencedColumnName = "isbn")
    private Publicacao publicacao;

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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }


}
