package Com.Helpdesk.exeMesaDeAyuda.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String redirectUrl = "/index";
        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            String role = grantedAuthority.getAuthority();

            System.out.println("role: " + role);

            if (role.equals("ROLE_AGENTE")) {
                redirectUrl = "/Usuarios/PrincipalAgente";
                break;
            } else if (role.equals("ROLE_CLIENTE")) {
                redirectUrl = "/Usuarios/PrincipalCliente";
                break;
            }
        }
        response.sendRedirect(redirectUrl);
    }

}
