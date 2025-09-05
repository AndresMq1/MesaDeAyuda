package Com.Helpdesk.exeMesaDeAyuda.Servicios;

import Com.Helpdesk.exeMesaDeAyuda.dto.UsuariosDTO;

import java.util.List;

public interface UsuarioServicio {

    List<UsuariosDTO> getAllUsuarios();
    UsuariosDTO getUsuarioById(Long id);
    boolean createUsuario(UsuariosDTO usuariosDTO);
    UsuariosDTO updateUsuario(Long id,UsuariosDTO usuariosDTO);
    boolean deleteUsuario(Long id);

}
