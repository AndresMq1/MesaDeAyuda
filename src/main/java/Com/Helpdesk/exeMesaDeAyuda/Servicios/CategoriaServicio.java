package Com.Helpdesk.exeMesaDeAyuda.Servicios;

import Com.Helpdesk.exeMesaDeAyuda.dto.CategoriasDTO;

import java.util.List;

public interface CategoriaServicio {
    List<CategoriasDTO> getAllCategorias();
    CategoriasDTO getCategoriaById(Long id);
    CategoriasDTO createCategoria(CategoriasDTO categoriasDTO);
    CategoriasDTO updateCategoria(CategoriasDTO categoriasDTO);
    boolean deleteCategoria(Long id);

}
