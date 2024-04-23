
package nicoangeletti.bazar.service;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import nicoangeletti.bazar.model.Cliente;
import nicoangeletti.bazar.model.Producto;
import nicoangeletti.bazar.model.Venta;


public interface IVentaService {
    
    
    public void guardarVenta(Venta venta);
    
    public List<Venta> traerVentas();
    
    public Venta traerVenta(Long idVenta);
    
    public void eliminarVenta(Long idVenta);
    
    public void editarVenta(Long codigoVenta , Long codigoNuevo , LocalDate fecha_venta ,Double total , List<Producto> listaProductos , Cliente cliente);
    
    
  
}
