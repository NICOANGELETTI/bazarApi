
package nicoangeletti.bazar.service;

import java.util.List;
import nicoangeletti.bazar.model.Producto;


public interface IProductoService {
    
    
    
    public void guardarProducto(Producto producto);
    
    public List<Producto> traerProductos();
    
    public Producto traerProducto(Long idProducto);
    
    public void eliminarProducto(Long idProducto);
    
    public void editarProducto(Long codigoOriginal , Long codigoNuevo , String nombre, String Marca , Double costo , Double cantidad_disponible);
     
    
}
