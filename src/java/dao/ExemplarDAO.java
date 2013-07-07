/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Rosiani
 */
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Exemplar;

@Stateless
public class ExemplarDAO {

    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public boolean gravar(Exemplar exemplar) {
        boolean sucesso = false;
        try {
            em.merge(exemplar);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public Exemplar selecionar(Long codigo) {
        Exemplar exemplar = null;
        try {
            exemplar = em.find(Exemplar.class, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exemplar;
    }

    public boolean remover(Exemplar exemplar) {
        boolean sucesso = false;
        try {
            exemplar = em.find(Exemplar.class, exemplar.getNumero());
            em.remove(exemplar);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public List<Exemplar> listar() {
        List<Exemplar> exemplar = null;
        try {
            Query query = em.createQuery("Select c from exemplar c");
            exemplar = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return exemplar;
    }
    public List<Exemplar>Consulta(String isbn){
        List<Exemplar> exemplar = null;
        try {
              exemplar = em.createNamedQuery("Exemplar.AllConsultaISBN")
                    .setParameter("isbn", isbn)
                    .getResultList();
          } catch (Exception e) {
            e.printStackTrace();
        }

        return exemplar; 
    }

}

