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
import model.Associado;

@Stateless
public class AssociadoDAO {

    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public boolean gravar(Associado assoc) {
        boolean sucesso = false;
        try {
            em.merge(assoc);
            sucesso = true;
        } catch (Exception e) {
        }

        return sucesso;
    }

    public Associado selecionar(Long codigo) {
        Associado assoc = null;
        try {
            assoc = em.find(Associado.class, codigo);
        } catch (Exception e) {
        }

        return assoc;
    }

    public boolean remover(Associado assoc) {
        boolean sucesso = false;
        try {
            assoc = em.find(Associado.class, assoc.getCodigo());
            em.remove(assoc);
            sucesso = true;
        } catch (Exception e) {
        }

        return sucesso;
    }

    public List<Associado> listar() {
        List<Associado> assocs = null;
        try {
            Query query = em.createQuery("Select c from associado c");
            assocs = query.getResultList();
        } catch (Exception e) {
        }

        return assocs;
    }
}
