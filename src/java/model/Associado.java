/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilcx-dev-02
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "associado")
public class Associado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Codigo")
    private Long codigo;
    @Column(length = 35, name = "Nome")
    private String nome;
    @Column(length = 45, name = "Endereco")
    private String endereco;
    @Column(length = 20, name = "Email")
    private String email;
    @Column(length = 100, name = "Status")
    private String status;
    
     @OneToMany(mappedBy = "associado", fetch = FetchType.LAZY)
     private List<Emprestimo> empList;

     public List<Emprestimo> getEmpList() {
     return empList;
     }

     public void setEmpList(List<Emprestimo> empList) {
     this.empList = empList;
     }
     
    @OneToMany(mappedBy = "associado", fetch = FetchType.EAGER)
    private List<Reserva> reservaList;

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Associado)) {
            return false;
        }
        Associado other = (Associado) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }
}
