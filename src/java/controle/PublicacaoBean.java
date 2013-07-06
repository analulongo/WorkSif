/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.PublicacaoDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import model.Publicacao;

@Named(value = "publicacaoBean")
@SessionScoped
public class PublicacaoBean implements Serializable {

    @EJB
    private PublicacaoDAO publicacaoDAO;
    private Publicacao pub = new Publicacao();
    private List<Publicacao> listPublicacao;

    public void novo() {
        pub = new Publicacao();
    }

    public void gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = publicacaoDAO.gravar(pub);

        if (resultado) {
            pub = new Publicacao();
            context.addMessage(null, new FacesMessage("Publicacao gravado com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao gravar Publicacao!"));
        }
    }

    public void selecionar(ActionEvent evento) {
        String isbn = (String) evento.getComponent().getAttributes().get("isbn");
        pub = publicacaoDAO.selecionar(isbn);
    }

    public void remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = publicacaoDAO.remover(pub);

        if (resultado) {
            pub = new Publicacao();
            context.addMessage(null, new FacesMessage("Publicacao removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover Publicacao!"));
        }
    }

    public List<Publicacao> getListPublicacao() {
        return listPublicacao;
    }

    public void setListPublicacao(List<Publicacao> listPublicacao) {
        this.listPublicacao = listPublicacao;
    }

    public Publicacao getPublicacao() {
        return pub;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.pub = publicacao;
    }

    public PublicacaoDAO getPublicacaoDAO() {
        return publicacaoDAO;
    }

    public void setPublicacaoDAO(PublicacaoDAO publicacaoDAO) {
        this.publicacaoDAO = publicacaoDAO;
    }
}