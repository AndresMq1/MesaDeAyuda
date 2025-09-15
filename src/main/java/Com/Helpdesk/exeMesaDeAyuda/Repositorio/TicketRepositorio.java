package Com.Helpdesk.exeMesaDeAyuda.Repositorio;

import Com.Helpdesk.exeMesaDeAyuda.entidades.Ticket;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepositorio extends JpaRepository<Ticket, Long> {
    List<Ticket> findByAgenteAsignadoIsNull();
    List<Ticket> findByAgenteAsignado(Usuario agenteAsignado);

}
