/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DTD;

import java.util.Date;

/**
 *
 * @author Felipe
 */
public class DTDConsulta {

    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    private Long numero;
    private float preco;
    private Long codigo;
    private int codAssoc;
    private Date dataEmp;
    private Date dataDevol;

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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getCodAssoc() {
        return codAssoc;
    }

    public void setCodAssoc(int codAssoc) {
        this.codAssoc = codAssoc;
    }

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
}
