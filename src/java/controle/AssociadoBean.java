/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

 
import dao.AssociadoDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import model.Associado;



@Named(value = "associadoBean")
@SessionScoped
public class AssociadoBean implements Serializable {
 
    @EJB
    private AssociadoDAO assocDAO;
    private Associado assoc = new Associado();
    private List<Associado> associados;
 
    public void novo(){
        assoc = new Associado();
    }
 
    public void gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = assocDAO.gravar(assoc);
 
        if (resultado) {
            assoc = new Associado();
            context.addMessage(null, new FacesMessage("assoc gravado com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao gravar assoc!"));
        }
    }
 
    public void selecionar(ActionEvent evento) {
        Long codigo = (Long) evento.getComponent().getAttributes().get("codigo");
        assoc = assocDAO.selecionar(codigo);
    }
 
    public void remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = assocDAO.remover(assoc);
 
        if (resultado) {
            assoc = new Associado();
            context.addMessage(null, new FacesMessage("assoc removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover assoc!"));
        }
    }

    public AssociadoDAO getAssocDAO() {
        return assocDAO;
    }

    public void setAssocDAO(AssociadoDAO assocDAO) {
        this.assocDAO = assocDAO;
    }

    public Associado getAssoc() {
        return assoc;
    }

    public void setAssoc(Associado assoc) {
        this.assoc = assoc;
    }

    public List<Associado> getAssociados() {
        return associados;
    }

    public void setAssociados(List<Associado> associados) {
        this.associados = associados;
    }
 

}
