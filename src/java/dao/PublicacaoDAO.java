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
import model.Publicacao;

@Stateless
public class PublicacaoDAO {

    @PersistenceContext(unitName = "SistemaPU")
    private EntityManager em;

    public boolean gravar(Publicacao pub) {
        boolean sucesso = false;
        try {
            em.merge(pub);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public Publicacao selecionar(String isbn) {
        Publicacao pub = null;
        try {
            pub = em.find(Publicacao.class, isbn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pub;
    }

    public boolean remover(Publicacao pub) {
        boolean sucesso = false;
        try {
            pub = em.find(Publicacao.class, pub.getIsbn());
            em.remove(pub);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    public List<Publicacao> listar() {
        List<Publicacao> pub = null;
        try {
            Query query = em.createQuery("Select c from publicacao c");
            pub = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pub;
    }

    public List<Publicacao> Consulta(String isbn, String titulo) {
        List<Publicacao> publicacaoConsulta = null;

        try {
            publicacaoConsulta = em.createNamedQuery("Publicacao.findAllConsulta")
                    .setParameter("isbn", isbn)
                    .setParameter("titulo", titulo)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicacaoConsulta;
    }

    public List<Exemplar> ConsultaExemplar(String isbn, String titulo) {
        List<Exemplar> exemplar = null;
        try {
            exemplar = em.createNamedQuery("Exemplar.AllConsultaISBN")
                    .setParameter("isbn", isbn)
                    .setParameter("titulo", titulo)
                    .getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exemplar;
    }
}
