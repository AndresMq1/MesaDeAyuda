package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Repositorio.UsuarioRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.dto.UsuariosDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuarios usuarios = usuarioRepositorio.findByEmail(email);



        return User.builder()
                .username(usuarios.getEmail())
                .password(usuarios.getPassword())
                .authorities(usuarios.getRol()).build();
    }
}
