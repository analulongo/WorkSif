/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
 
import dao.FuncionarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import model.Funcionario;



@Named(value = "funcionarioBean")
@SessionScoped
public class FuncionarioBean implements Serializable {
 
    @EJB
    private FuncionarioDAO funcionarioDAO;
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> listFuncionario;
 
    public void novo(){
        funcionario = new Funcionario();
    }
 
    public void gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = funcionarioDAO.gravar(funcionario);
 
        if (resultado) {
            funcionario = new Funcionario();
            context.addMessage(null, new FacesMessage("Funcionario gravado com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao gravar Funcionario!"));
        }
    }
 
    public void selecionar(ActionEvent evento) {
        Long codigo = (Long) evento.getComponent().getAttributes().get("codigo");
        funcionario = funcionarioDAO.selecionar(codigo);
    }
 
    public void remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = funcionarioDAO.remover(funcionario);
 
        if (resultado) {
            funcionario = new Funcionario();
            context.addMessage(null, new FacesMessage("Funcionario removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover Funcionario!"));
        }
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

    public List<Funcionario> getListFuncionario() {
        return listFuncionario;
    }

    public void setListFuncionario(List<Funcionario> listFuncionario) {
        this.listFuncionario = listFuncionario;
    }

    
}

