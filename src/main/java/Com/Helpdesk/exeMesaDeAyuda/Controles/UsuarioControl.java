package Com.Helpdesk.exeMesaDeAyuda.Controles;

import Com.Helpdesk.exeMesaDeAyuda.Servicios.TicketServicio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.UsuarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.TicketDTO;
import Com.Helpdesk.exeMesaDeAyuda.dto.UsuarioDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Ticket;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Usuarios")
public class UsuarioControl {

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    TicketServicio ticketServicio;

    @GetMapping("/listar")
    public String listar(Model model){
        List<UsuarioDTO> listarUsuario = usuarioServicio.getAllUsuarios();
        model.addAttribute("users",listarUsuario);
        return "Agente/lista";
    }

    @GetMapping("PrincipalCliente")
    public String principal(Model model, Authentication authentication){
        Usuario usuario = usuarioServicio.buscarPorEmail(authentication.getName());
        model.addAttribute("nombreCliente", usuario.getNombre());

        Usuario usuarip = usuarioServicio.buscarPorEmail(authentication.getName());
        model.addAttribute("listaTicket",usuarip.getTickets());


        return "Cliente/PrincipalCliente";
    }

    @GetMapping("PrincipalAgente")
    public String principalAgente(Model model, Authentication authentication){
        Usuario usuario = usuarioServicio.buscarPorEmail(authentication.getName());
        model.addAttribute("nombreAgente", usuario.getNombre());

        /*lista todos los ticket en la base de datos
        List<TicketDTO> listarTickets = ticketServicio.getAllTickets();
        model.addAttribute("tickets",listarTickets);*/

        List<TicketDTO> listaTictekAsi = ticketServicio.getTicketsAsignados(usuario);
        model.addAttribute("tickesAsignados",listaTictekAsi);

        //lista los ticket que no tiene agente
        List<TicketDTO> listaTicketSinA = ticketServicio.getSinAsignarTickets();
        model.addAttribute("listaTicketSinA",listaTicketSinA);

        return "Agente/PrincipalA";
    }



    /*@GetMapping("/crear")
    public String crear(Model model){
        model.addAttribute("usuario", new UsuariosDTO());
        return "form";
    }*/

    @GetMapping("/editar/{id}")
    public String  editar(@PathVariable Long id, Model model){
        UsuarioDTO usuariosDTO = usuarioServicio.getUsuarioById(id);
        model.addAttribute("usuario", usuariosDTO);
        return "formU";
    }
    @PostMapping("/editar")
    public String actualizar( @ModelAttribute UsuarioDTO usuariosDTO){
        usuarioServicio.updateUsuario(usuariosDTO.getIdUsuario(), usuariosDTO);
        return "redirect:/Usuarios/listar";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        usuarioServicio.deleteUsuario(id);
        return "redirect:/Usuarios/listar";
    }

    /*@GetMapping("/ListaTicketSinA")
    public String listaTicketSinA(Model model){
        List<TicketDTO> listaTicketSinA = ticketServicio.getSinAsignarTickets();
        model.addAttribute("listaTicketSinA",listaTicketSinA);
        return "Agente/PrincipalA";
    }*/

    @PostMapping("/AsignarT")
    public String asignarTicket(@RequestParam("ticketSelection") Long id, Authentication authentication){
        Usuario usuario = usuarioServicio.buscarPorEmail(authentication.getName());
        ticketServicio.asignarTicket(id, usuario);
        return "redirect:/Usuarios/PrincipalAgente";

    }



}