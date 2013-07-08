/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "publicacao")
@NamedQueries({
    @NamedQuery(name = "Publicacao.findAllConsulta", query = "SELECT c FROM Publicacao c WHERE c.isbn=:isbn OR c.titulo=:titulo")})
public class Publicacao implements Serializable {

    public static final String findByPublicacao = "Publicacao.findByPublicacao";
    @Id
    @Column(length = 12, name = "isbn")
    private String isbn;
    @Column(length = 40, name = "titulo")
    private String titulo;
    @Column(length = 35, name = "autor")
    private String autor;
    @Column(length = 30, name = "editora")
    private String editora;
    @OneToMany(mappedBy = "publicacao", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Exemplar> exemplares;

    public Collection<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(Collection<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Publicacao)) {
            return false;
        }
        Publicacao other = (Publicacao) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }
}
