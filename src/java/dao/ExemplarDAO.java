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
       // int valor= Integer.parseInt(numeroMax(exemplar.getPublicacao().getIsbn().toString()));
       // exemplar.setNumero();
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
     public int numeroMax(String isbn) {
        try {
            int valor;
            valor= Integer.parseInt(em.createQuery("select max(u.numero) from Exemplar u WHERE u.publicacao.isbn='"+isbn+"'").getSingleResult().toString());
        return valor;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
   
      
    }
    
      
    
}
