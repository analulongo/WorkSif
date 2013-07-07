package controle;

import dao.ReservaDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import model.Reserva;

@Named(value = "reservaBean")
@SessionScoped
public class ReservaBean implements Serializable {

    @EJB
    private ReservaDAO reservaDAO;
    private Reserva reserva = new Reserva();
    private List<Reserva> reservas;

    public void novo() {
        reserva = new Reserva();
    }

    public void gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = reservaDAO.gravar(reserva);

        if (resultado) {
            reserva = new Reserva();
            context.addMessage(null, new FacesMessage("Reserva gravado com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao gravar Reserva!"));
        }
    }

    public void selecionar(ActionEvent evento) {
        Long codigo = (Long) evento.getComponent().getAttributes().get("codigo");
        reserva = reservaDAO.selecionar(codigo);
    }

    public void remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = reservaDAO.remover(reserva);

        if (resultado) {
            reserva = new Reserva();
            context.addMessage(null, new FacesMessage("Reserva removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover Reserva!"));
        }
    }

    public ReservaDAO getReservaDAO() {
        return reservaDAO;
    }

    public void setReservaDAO(ReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setreservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
