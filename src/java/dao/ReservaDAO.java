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
import model.Reserva;

@Stateless
public class ReservaDAO {

    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public boolean gravar(Reserva reserva) {
        boolean sucesso = false;
        try {
            em.merge(reserva);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public Reserva selecionar(Long codigo) {
        Reserva reserva = null;
        try {
            reserva = em.find(Reserva.class, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reserva;
    }

    public boolean remover(Reserva reserva) {
        boolean sucesso = false;
        try {
            reserva = em.find(Reserva.class, reserva.getCodigo());
            em.remove(reserva);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public List<Reserva> listar() {
        List<Reserva> reservas = null;
        try {
            Query query = em.createQuery("Select c from reserva c");
            reservas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reservas;
    }
    /*
     public List<Reserva> listar(String isbn) {
     List<Reserva> reservas = null;
     try {
     reservas = em.createNamedQuery("Exemplar.AllConsultaISBN")
     .setParameter("isbn", isbn)
     .getResultList();

     } catch (Exception e) {
     e.printStackTrace();
     }

     return reservas;
     }
     */

    //Funçao retorn lisvro com reserva
   
}
