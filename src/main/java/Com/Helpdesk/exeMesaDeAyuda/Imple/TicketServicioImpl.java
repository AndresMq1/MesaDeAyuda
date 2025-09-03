package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Servicios.TicketServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.TicketDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServicioImpl implements TicketServicio {

    @Override
    public List<TicketDTO> getAllTickets(){
        return null;
    }
    @Override
    public TicketDTO getTicketById(Long id){
        return null;
    }
    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        return null;
    }
    @Override
    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        return null;
    }
    @Override
    public  boolean deleteTicket(Long id) {
        return false;
    }
}
