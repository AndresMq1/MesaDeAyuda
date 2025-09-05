package Com.Helpdesk.exeMesaDeAyuda;

import Com.Helpdesk.exeMesaDeAyuda.Repositorio.UsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MesaDeAyudaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MesaDeAyudaApplication.class, args);
	}


}
