/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ExemplarDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import model.Exemplar;



@Named(value = "exemplarBean")
@SessionScoped
public class ExemplarBean implements Serializable {
 
    @EJB
    private ExemplarDAO exDAO;
    private Exemplar ex = new Exemplar();
    private List<Exemplar> listExemplar;
 
    public void novo(){
        ex = new Exemplar();
    }
 
    public void gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = exDAO.gravar(ex);
 
        if (resultado) {
            ex = new Exemplar();
            context.addMessage(null, new FacesMessage("Exemplar gravado com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao gravar Exemplar!"));
        }
    }
 
    public void selecionar(ActionEvent evento) {
        Long numero = (Long) evento.getComponent().getAttributes().get("numero");
        ex = exDAO.selecionar(numero);
    }
 
    public void remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = exDAO.remover(ex);
 
        if (resultado) {
            ex = new Exemplar();
            context.addMessage(null, new FacesMessage("Exemplar removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover Exemplar!"));
        }
    }

    public Exemplar getEx() {
        return ex;
    }

    public void setEx(Exemplar ex) {
        this.ex = ex;
    }

    public ExemplarDAO getExDAO() {
        return exDAO;
    }

    public void setExDAO(ExemplarDAO exDAO) {
        this.exDAO = exDAO;
    }

    public List<Exemplar> getListExemplar() {
        return listExemplar;
    }

    public void setListExemplar(List<Exemplar> listExemplar) {
        this.listExemplar = listExemplar;
    }

   
}