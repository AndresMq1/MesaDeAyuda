package Com.Helpdesk.exeMesaDeAyuda.Controles;

import Com.Helpdesk.exeMesaDeAyuda.Repositorio.TicketRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.CategoriaServicio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.TicketServicio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.UsuarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.CategoriaDTO;
import Com.Helpdesk.exeMesaDeAyuda.dto.TicketDTO;
import Com.Helpdesk.exeMesaDeAyuda.dto.UsuarioDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Ticket;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Ticket")
public class TicketController {

    @Autowired
    TicketServicio ticketServicio;

    @Autowired
    TicketRepositorio ticketRepositorio;

    @Autowired
    CategoriaServicio categoriaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ModelMapper modelMapper;





    @GetMapping("/RegistrarTik")
    public String registrarTik(Model model,  Authentication authentication){
        model.addAttribute("ticketR",new TicketDTO());

        List<CategoriaDTO> list = categoriaServicio.getAllCategorias();
        model.addAttribute("listaCate",list);

        return "Cliente/CreacionTicket";
    }

   @PostMapping("/RegistrarTik")
    public String registrarTik2(@ModelAttribute TicketDTO ticketDTO , Authentication  authentication){
        Usuario usuario = usuarioServicio.buscarPorEmail(authentication.getName());
        ticketServicio.createTicket(ticketDTO ,usuario);
        return "redirect:/Usuarios/PrincipalCliente";
   }

   @GetMapping("/MisTicket")
    public String misTicket(Model model,  Authentication authentication){
        return ("Cliente/Mistickes");
   }


   @GetMapping("/DetalleTicketA/{id}")
    public String detalleTicketA(@PathVariable Long id ,Model model){
       Ticket ticket = ticketRepositorio.findById(id).orElseThrow();

       TicketDTO dto = modelMapper.map(ticket, TicketDTO.class);

       // Aquí agregas el DTO del cliente que creó el ticket
       UsuarioDTO clienteDTO = modelMapper.map(ticket.getUsuario(), UsuarioDTO.class);
       dto.setCliente(clienteDTO);

       model.addAttribute("ticket", dto);
        return ("Agente/DetalleTicketAgente");
   }


}
