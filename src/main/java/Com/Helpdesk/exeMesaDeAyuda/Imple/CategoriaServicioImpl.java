package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Servicios.CategoriaServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.CategoriasDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicioImpl  implements CategoriaServicio {

    @Override
    public List<CategoriasDTO> getAllCategorias(){
        return null;
    }
    @Override
    public CategoriasDTO getCategoriaById(Long id){
        return null;
    }
    @Override
    public CategoriasDTO createCategoria(CategoriasDTO categoriasDTO){
        return null;
    }
    @Override
    public CategoriasDTO updateCategoria(CategoriasDTO categoriasDTO){
        return null;
    }
    @Override
    public  boolean deleteCategoria(Long id){
        return false;
    }
}
