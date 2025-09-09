package Com.Helpdesk.exeMesaDeAyuda.Imple;

import Com.Helpdesk.exeMesaDeAyuda.Repositorio.CategoriaRepositorio;
import Com.Helpdesk.exeMesaDeAyuda.Servicios.CategoriaServicio;
import Com.Helpdesk.exeMesaDeAyuda.dto.CategoriaDTO;
import Com.Helpdesk.exeMesaDeAyuda.entidades.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServicioImpl  implements CategoriaServicio {

    private final CategoriaRepositorio categoriaRepositorio;
    private final ModelMapper  modelMapper;

    public CategoriaServicioImpl(CategoriaRepositorio categoriaRepositorio, ModelMapper modelMapper) {
        this.categoriaRepositorio = categoriaRepositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CategoriaDTO> getAllCategorias(){
        List<Categoria>  listaCategorias = categoriaRepositorio.findAll();
        return listaCategorias.stream().map(categoria -> modelMapper.map(categoria, CategoriaDTO.class)).collect(Collectors.toList());
    }
    @Override
    public CategoriaDTO getCategoriaById(Long id){
        Categoria categoria = categoriaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada" + id));
        return modelMapper.map(categoria, CategoriaDTO.class);
    }
    @Override
    public CategoriaDTO createCategoria(CategoriaDTO categoriasDTO){
        Categoria categoria = modelMapper.map(categoriasDTO, Categoria.class);
        categoriaRepositorio.save(categoria);
        return modelMapper.map(categoria, CategoriaDTO.class);
    }
    @Override
    public CategoriaDTO updateCategoria(Long id, CategoriaDTO categoriasDTO){
        Categoria categorias = categoriaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada" + id));
        modelMapper.map(categoriasDTO, categorias);
        Categoria categoriaUp = categoriaRepositorio.save(categorias);

        return modelMapper.map(categoriaUp, CategoriaDTO.class);
    }
    @Override
    public  boolean deleteCategoria(Long id){
       if(!categoriaRepositorio.existsById(id)){
           throw new RuntimeException("Categoria no encontrada" + id);
       }
       categoriaRepositorio.deleteById(id);
       return true;
    }
}
