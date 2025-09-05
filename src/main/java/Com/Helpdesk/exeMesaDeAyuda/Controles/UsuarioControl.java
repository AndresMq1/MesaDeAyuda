package Com.Helpdesk.exeMesaDeAyuda.Controles;

import Com.Helpdesk.exeMesaDeAyuda.Servicios.UsuarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.UsuariosDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Usuarios")
public class UsuarioControl {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/listar")
    public String listar(Model model){
        List<UsuariosDTO> listarUsuario = usuarioServicio.getAllUsuarios();
        model.addAttribute("users",listarUsuario);
        return "lista";
    }

    @GetMapping("/registro")
    public String registro(Model model){
        model.addAttribute("usuario", new UsuariosDTO());
        return "registro";
    }

    @PostMapping("/registro")
    public String crear(@ModelAttribute UsuariosDTO usuariosDTO){
        System.out.println(usuariosDTO.getEmail());
        System.out.println(usuariosDTO.getPassword());
        System.out.println(usuariosDTO.getNombre());
        System.out.println(usuariosDTO.getRol());
        usuarioServicio.createUsuario(usuariosDTO);
        return "redirect:/Usuarios/listar";
    }

    /*@GetMapping("/crear")
    public String crear(Model model){
        model.addAttribute("usuario", new UsuariosDTO());
        return "form";
    }*/

    @GetMapping("/editar/{id}")
    public String  editar(@PathVariable Long id, Model model){
        UsuariosDTO usuariosDTO = usuarioServicio.getUsuarioById(id);
        model.addAttribute("usuario", usuariosDTO);
        return "formU";
    }
    @PostMapping("/editar")
    public String actualizar( @ModelAttribute UsuariosDTO usuariosDTO){
        usuarioServicio.updateUsuario(usuariosDTO.getIdUsuario(), usuariosDTO);
        return "redirect:/Usuarios/listar";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        usuarioServicio.deleteUsuario(id);
        return "redirect:/Usuarios/listar";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}