
package nicoangeletti.bazar.service;

import java.util.List;
import nicoangeletti.bazar.model.Producto;
import nicoangeletti.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    
    
    @Autowired
    IProductoRepository productoRepo; 

    @Override
    public void guardarProducto(Producto producto) {
        productoRepo.save(producto);
        
    }

    @Override
    public List<Producto> traerProductos() {
    List<Producto> listaProductos = productoRepo.findAll();
   
       return listaProductos;
    }

    @Override
    public Producto traerProducto(Long idProducto) {
        Producto producto = productoRepo.findById(idProducto).orElse(null);
        return producto;
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        productoRepo.deleteById(idProducto);
        
    }

    @Override
    public void editarProducto(Producto producto) {
        this.guardarProducto(producto);
    }
    
    
    
}
