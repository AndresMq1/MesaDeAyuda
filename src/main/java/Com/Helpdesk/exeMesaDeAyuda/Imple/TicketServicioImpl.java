package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Exepciones.CustomException;
import Com.Helpdesk.exeMesaDeAyuda.Repositorio.TicketRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Repositorio.UsuarioRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.TicketServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.TicketDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Ticket;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServicioImpl implements TicketServicio {

    @Autowired
    private final TicketRepositorio  ticketRepositorio;
    private final ModelMapper modelMapper;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public TicketServicioImpl(TicketRepositorio ticketRepositorio, ModelMapper modelMapper) {
        this.ticketRepositorio = ticketRepositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TicketDTO> getAllTickets(){
        List<Ticket> ticket = ticketRepositorio.findAll();
        return ticket.stream().map(ticket1 -> modelMapper.map(ticket1, TicketDTO.class)).collect(Collectors.toList());
    }
    @Override
    public TicketDTO getTicketById(Long id){
        Ticket ticket = ticketRepositorio.findById(id).orElseThrow(() -> new CustomException("ticket no encontrado" + id));
        return modelMapper.map(ticket, TicketDTO.class);
    }
    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO,Usuario usuario) {
        Ticket ticket = modelMapper.map(ticketDTO, Ticket.class);

        ticket.setUsuario(usuario);
        ticket.setCreadoEn(LocalDateTime.now());

        ticketRepositorio.save(ticket);

        return modelMapper.map(ticket, TicketDTO.class);
    }
    @Override
    public TicketDTO updateTicket(Long id,TicketDTO ticketDTO) {
        Ticket ticket = ticketRepositorio.findById(id).orElseThrow(() -> new CustomException("ticket no encontrado" + id));
        ticket = modelMapper.map(ticket, Ticket.class);
        Ticket ticketUpdate = ticketRepositorio.save(ticket);

        return modelMapper.map(ticketUpdate, TicketDTO.class);
    }
    @Override
    public  boolean deleteTicket(Long id) {
        if(!ticketRepositorio.existsById(id)){
            throw new CustomException("ticket no encontrado" + id);
        }
        ticketRepositorio.deleteById(id);
        return true;
    }
}
