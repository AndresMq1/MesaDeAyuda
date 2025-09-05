package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Repositorio.UsuarioRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.UsuarioServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.UsuariosDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuarios;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<UsuariosDTO> getAllUsuarios() {
        List<Usuarios> listarUsuarios = usuarioRepositorio.findAll();
        return listarUsuarios.stream().map(u -> modelMapper.map(u, UsuariosDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UsuariosDTO getUsuarioById(Long id){
        Usuarios usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado" + id) );
        return modelMapper.map(usuario, UsuariosDTO.class);
    }
    @Override
    public boolean createUsuario(UsuariosDTO usuariosDTO) {
        Usuarios usuario = modelMapper.map(usuariosDTO, Usuarios.class);
        usuario.setPassword(passwordEncoder.encode(usuariosDTO.getPassword()));
        usuarioRepositorio.save(usuario);
        return true;
    }
    @Override
    public UsuariosDTO updateUsuario(Long id,UsuariosDTO usuariosDTO) {
        Usuarios usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado" + id) );
        modelMapper.map(usuariosDTO, usuario);

        Usuarios usuarios = usuarioRepositorio.save(usuario);

        return  modelMapper.map(usuarios, UsuariosDTO.class);
    }

    @Override
    public boolean deleteUsuario(Long id) {
        if(!usuarioRepositorio.existsById(id)){
            throw new RuntimeException("Usuario no encontrado" + id);}
        usuarioRepositorio.deleteById(id);
        return true;
    }


}
