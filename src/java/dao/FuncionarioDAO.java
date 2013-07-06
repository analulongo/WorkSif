package dao;

 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Funcionario;

 
@Stateless
public class FuncionarioDAO {
 
    @PersistenceContext(unitName="SistemaPU")
    private EntityManager em;
 
    public boolean gravar(Funcionario func){
        boolean sucesso = false;
        try {
            em.merge(func);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
    }
 
    public Funcionario selecionar(Long codigo){
        Funcionario func = null;
        try {
            func = em.find(Funcionario.class, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return func;
    }
 
    public boolean remover(Funcionario func){
        boolean sucesso = false;
        try {
            func = em.find(Funcionario.class, func.getCodigo());
            em.remove(func);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
    }
 
    public List<Funcionario> listar() {
        List<Funcionario> func = null;
        try {
            Query query = em.createQuery("Select c from funcionario c");
            func = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        return func;
    }
}

