package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Repositorio.UsuarioRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.UsuarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.UsuarioDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {


    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepositorio usuarioRepositorio;
    private final ModelMapper modelMapper;

    public UsuarioServicioImpl(PasswordEncoder passwordEncoder ,UsuarioRepositorio usuarioRepositorio, ModelMapper modelMapper) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        List<Usuario> listarUsuarios = usuarioRepositorio.findAll();
        return listarUsuarios.stream().map(u -> modelMapper.map(u, UsuarioDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO getUsuarioById(Long id){
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado" + id) );
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
    @Override
    public boolean createUsuario(UsuarioDTO usuariosDTO) {
        Usuario usuario = modelMapper.map(usuariosDTO, Usuario.class);
        usuario.setPassword(passwordEncoder.encode(usuariosDTO.getPassword()));
        usuarioRepositorio.save(usuario);
        return true;
    }
    @Override
    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuariosDTO) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado" + id) );
        modelMapper.map(usuariosDTO, usuario);

        Usuario usuarios = usuarioRepositorio.save(usuario);

        return  modelMapper.map(usuarios, UsuarioDTO.class);
    }
    @Override
    public boolean deleteUsuario(Long id) {
        if(!usuarioRepositorio.existsById(id)){
            throw new RuntimeException("Usuario no encontrado" + id);}
        usuarioRepositorio.deleteById(id);
        return true;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        return usuarioRepositorio.findByEmail(email);
    }


}
