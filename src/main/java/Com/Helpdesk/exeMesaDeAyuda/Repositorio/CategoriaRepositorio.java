package Com.Helpdesk.exeMesaDeAyuda.Repositorio;

import Com.Helpdesk.exeMesaDeAyuda.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
