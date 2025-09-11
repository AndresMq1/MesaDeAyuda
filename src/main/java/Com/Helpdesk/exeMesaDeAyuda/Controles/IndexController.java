package Com.Helpdesk.exeMesaDeAyuda.Controles;

import Com.Helpdesk.exeMesaDeAyuda.Servicios.UsuarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.UsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    private final UsuarioServicio usuarioServicio;

    public IndexController(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // Carga templates/index.html
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registro")
    public String registro(Model model){
        model.addAttribute("usuario", new UsuarioDTO());
        return "registro";
    }

    @PostMapping("/registro")
    public String crear(@ModelAttribute UsuarioDTO usuariosDTO, Model model){

        if (usuarioServicio.buscarPorEmail(usuariosDTO.getEmail()) != null){
            model.addAttribute("error","Este Correo ya esta rejistrado");
            model.addAttribute("usuario",usuariosDTO);
            return "registro";
        }

        System.out.println(usuariosDTO.getEmail());
        System.out.println(usuariosDTO.getPassword());
        System.out.println(usuariosDTO.getNombre());
        System.out.println(usuariosDTO.getRol());
        usuarioServicio.createUsuario(usuariosDTO);

        return "redirect:/login";
    }
}
