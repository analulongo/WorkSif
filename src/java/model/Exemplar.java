/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Rosiani
 */
@Entity
@Table(name = "exemplar")
@NamedQueries({
 @NamedQuery(name = "Exemplar.AllConsultaISBN", query = "Select e from Exemplar e where e.isbn=:isbn")})
public class Exemplar implements Serializable {

    @Id
    @Column(name = "Numero")
    private Long numero;
   @Column(length = 12, name = "ISBN")
   private String isbn;
    @Column(name = "Preco")
    private float preco;
    
    @ManyToOne
    @JoinColumn(name = "publicacao")
    private Publicacao publicacao;

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }
    
     public String getIsbn() {
     return isbn;
     }

     public void setIsbn(String isbn) {
     this.isbn = isbn;
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
