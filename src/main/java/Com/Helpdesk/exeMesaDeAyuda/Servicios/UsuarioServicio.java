package Com.Helpdesk.exeMesaDeAyuda.Servicios;

import Com.Helpdesk.exeMesaDeAyuda.dto.UsuarioDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    List<UsuarioDTO> getAllUsuarios();
    UsuarioDTO getUsuarioById(Long id);
    boolean createUsuario(UsuarioDTO usuariosDTO);
    UsuarioDTO updateUsuario(Long id, UsuarioDTO usuariosDTO);
    boolean deleteUsuario(Long id);
    Usuario buscarPorEmail(String email);
}
