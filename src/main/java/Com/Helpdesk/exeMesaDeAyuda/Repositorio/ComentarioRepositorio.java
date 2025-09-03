package Com.Helpdesk.exeMesaDeAyuda.Repositorio;

import Com.Helpdesk.exeMesaDeAyuda.entidades.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentarios, Long> {
}
