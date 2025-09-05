package Com.Helpdesk.exeMesaDeAyuda.config;

import Com.Helpdesk.exeMesaDeAyuda.Imple.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    UserDetailServiceImpl  userDetailServiceImpl;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(a -> {
                    a.requestMatchers("/Usuarios/registro").permitAll();
                    a.anyRequest().authenticated();
                })
                .formLogin(login -> {
                    login.loginPage("/Usuarios/login").permitAll();
                    login.loginProcessingUrl("/login");
                    login.failureUrl("/Usuarios/login?error=true");
                    login.defaultSuccessUrl("/Usuarios/listar");
                })
                .build();
    }

    @Bean
    public AuthenticationManager authenticationMana(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(userDetailServiceImpl)
                .passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
