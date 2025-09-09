package Com.Helpdesk.exeMesaDeAyuda.Servicios;

import Com.Helpdesk.exeMesaDeAyuda.dto.TicketDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuario;

import java.util.List;

public interface TicketServicio {
    List<TicketDTO> getAllTickets();
    TicketDTO getTicketById(Long id);
    TicketDTO createTicket(TicketDTO ticketDTO, Usuario usuario);
    TicketDTO updateTicket(Long id, TicketDTO ticketDTO);
    boolean deleteTicket(Long id);
}
