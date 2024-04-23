
package nicoangeletti.bazar.service;

import java.util.List;
import nicoangeletti.bazar.model.Producto;
import nicoangeletti.bazar.model.Venta;


public interface IVentaService {
    
    
    public void guardarVenta(Venta venta);
    
    public List<Venta> traerVentas();
    
    public Venta traerVenta(Long idVenta);
    
    public void eliminarVenta(Long idVenta);
    
    public void editarVenta(Venta venta);
    
    
    
}
