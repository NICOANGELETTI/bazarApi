
package nicoangeletti.bazar.service;

import java.time.LocalDate;
import java.util.List;
import nicoangeletti.bazar.model.Cliente;
import nicoangeletti.bazar.model.Producto;
import nicoangeletti.bazar.model.Venta;
import nicoangeletti.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VentaService implements IVentaService  {
    
    
    
    @Autowired
    IVentaRepository ventaRepo;

    @Override
    public void guardarVenta(Venta venta) {

        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> traerVentas() {
        List<Venta> listaVentas = ventaRepo.findAll();
        return listaVentas; 
    }

    @Override
    public Venta traerVenta(Long idVenta) {
        Venta venta = ventaRepo.findById(idVenta).orElse(null);
        return venta;
                }

    @Override
    public void eliminarVenta(Long idVenta) {
       ventaRepo.deleteById(idVenta);
    }

    @Override
    public void editarVenta(Long codigoVenta, Long codigoNuevo, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente cliente) {
        Venta venta = this.traerVenta(codigoVenta);
        
        venta.setCodigo_venta(codigoNuevo);
        venta.setFecha_venta(fecha_venta);
        venta.setTotal(total);
        venta.setListaProductos(listaProductos);
        venta.setUnCliente(cliente);
        
        this.guardarVenta(venta);
        
        
        
        
    }


    
    
    
    
}
