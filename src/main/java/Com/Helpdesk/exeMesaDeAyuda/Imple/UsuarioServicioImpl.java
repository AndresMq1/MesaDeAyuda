package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Servicios.UsuarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.UsuariosDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Override
    public List<UsuariosDTO> getAllUsuarios() {
        return null;
    }

    @Override
    public UsuariosDTO getUsuarioById(Long id){
        return null;
    }
    @Override
    public UsuariosDTO createUsuario(UsuariosDTO usuariosDTO) {
        return null;
    }
    @Override
    public UsuariosDTO updateUsuario(UsuariosDTO usuariosDTO) {
        return null;
    }

    @Override
    public boolean deleteUsuario(Long id) {
        return false;
    }
}
