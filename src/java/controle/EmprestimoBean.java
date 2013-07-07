package controle;

import dao.AssociadoDAO;
import dao.EmprestimoDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import model.Associado;
import model.Emprestimo;

@Named(value = "emprestimoBean")
@SessionScoped
public class EmprestimoBean implements Serializable {

    @EJB
    private EmprestimoDAO emprestimoDAO;
    private Emprestimo emprestimo = new Emprestimo();
    private List<Emprestimo> emprestimos;

    public void novo() {
        emprestimo = new Emprestimo();
    }

    public void gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = emprestimoDAO.gravar(emprestimo);

        if (resultado) {
            emprestimo = new Emprestimo();
            context.addMessage(null, new FacesMessage("Emprestimo gravado com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao gravar Emprestimo!"));
        }
    }

    public void selecionar(ActionEvent evento) {
        Long codigo = (Long) evento.getComponent().getAttributes().get("codigo");
        emprestimo = emprestimoDAO.selecionar(codigo);
    }

    public void remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = emprestimoDAO.remover(emprestimo);

        if (resultado) {
            emprestimo = new Emprestimo();
            context.addMessage(null, new FacesMessage("Emprestimo removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover Emprestimo!"));
        }
    }

    public EmprestimoDAO getEmprestimoDAO() {
        return emprestimoDAO;
    }

    public void setEmprestimoDAO(EmprestimoDAO emprestimoDAO) {
        this.emprestimoDAO = emprestimoDAO;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
}
