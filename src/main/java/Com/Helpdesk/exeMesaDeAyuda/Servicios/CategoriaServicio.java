package Com.Helpdesk.exeMesaDeAyuda.Servicios;

import Com.Helpdesk.exeMesaDeAyuda.dto.CategoriaDTO;

import java.util.List;

public interface CategoriaServicio {
    List<CategoriaDTO> getAllCategorias();
    CategoriaDTO getCategoriaById(Long id);
    CategoriaDTO createCategoria(CategoriaDTO categoriasDTO);
    CategoriaDTO updateCategoria(Long id, CategoriaDTO categoriasDTO);
    boolean deleteCategoria(Long id);

}
