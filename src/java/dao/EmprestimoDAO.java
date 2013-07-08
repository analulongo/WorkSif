/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Emprestimo;

@Stateless
public class EmprestimoDAO {

    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public boolean gravar(Emprestimo emprestimo) {
        boolean sucesso = false;
        try {
            em.merge(emprestimo);
            sucesso = true;
        } catch (Exception e) {
        }

        return sucesso;
    }

    public Emprestimo selecionar(Long codigo) {
        Emprestimo emprestimo = null;
        try {
            emprestimo = em.find(Emprestimo.class, codigo);
        } catch (Exception e) {
        }

        return emprestimo;
    }

    public boolean remover(Emprestimo emprestimo) {
        boolean sucesso = false;
        try {
            emprestimo = em.find(Emprestimo.class, emprestimo.getCodigo());
            em.remove(emprestimo);
            sucesso = true;
        } catch (Exception e) {
        }

        return sucesso;
    }

    public List<Emprestimo> listar() {
        List<Emprestimo> emprestimos = null;
        try {
            Query query = em.createQuery("Select c from emprestimo c");
            emprestimos = query.getResultList();
        } catch (Exception e) {
        }

        return emprestimos;
    }
}