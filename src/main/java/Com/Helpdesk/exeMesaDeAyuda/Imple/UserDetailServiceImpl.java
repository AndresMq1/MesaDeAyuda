package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Repositorio.UsuarioRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuario;
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
        Usuario usuarios = usuarioRepositorio.findByEmail(email);

        if (usuarios == null) {
            throw new UsernameNotFoundException("No se encontró el usuario con email: " + email);
        }

        return User.builder()
                .username(usuarios.getEmail())
                .password(usuarios.getPassword())
                .authorities("ROLE_" + usuarios.getRol().toUpperCase())
                .build();
    }
}
