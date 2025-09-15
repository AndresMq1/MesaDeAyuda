package Com.Helpdesk.exeMesaDeAyuda.Servicios;

import Com.Helpdesk.exeMesaDeAyuda.dto.TicketDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuario;

import java.util.List;

public interface TicketServicio {
    List<TicketDTO> getAllTickets();
    List<TicketDTO> getSinAsignarTickets();
    List<TicketDTO> getTicketsAsignados(Usuario agenteAsignado);
    TicketDTO getTicketById(Long id);
    TicketDTO createTicket(TicketDTO ticketDTO, Usuario usuario);
    TicketDTO updateTicket(Long id, TicketDTO ticketDTO);
    boolean deleteTicket(Long id);
    boolean asignarTicket(Long id,  Usuario usuario);
}
