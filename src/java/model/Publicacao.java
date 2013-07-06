/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publicacao")
public class Publicacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 12, name = "isbn")
    private String isbn;
    @Column(length = 40, name = "titulo")
    private String titulo;
    @Column(length = 35, name = "autor")
    private String autor;
    @Column(length = 30, name = "editora")
    private String editora;

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
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (codigo != null ? codigo.hashCode() : 0);
//        return hash;
//    }
// 
//    @Override
//    public boolean equals(Object object) {
//        if (!(object instanceof Associado)) {
//            return false;
//        }
//        Associado other = (Associado) object;
//        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
//            return false;
//        }
//        return true;
//    }
}
