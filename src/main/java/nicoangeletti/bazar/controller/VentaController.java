
package nicoangeletti.bazar.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import nicoangeletti.bazar.dto.ClaseDTO;
import nicoangeletti.bazar.model.Cliente;
import nicoangeletti.bazar.model.Producto;
import nicoangeletti.bazar.model.Venta;
import nicoangeletti.bazar.service.IClienteService;
import nicoangeletti.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Endpoint;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    
    
    
    @Autowired
    IVentaService ventaServ;
    
    @Autowired
    IClienteService clienteService;
    
    
  

@PostMapping("/ventas/crear")
public String guardarVenta(@RequestBody Venta venta) {
    // Guardar el cliente primero
    Cliente cliente = venta.getUnCliente();
    clienteService.guardarCliente(cliente);

    // Ahora guarda la venta que hace referencia a ese cliente
    ventaServ.guardarVenta(venta);

    return "Venta creada exitosamente";
}

    
@GetMapping("/ventas")
public List<Venta> traerVentas(){
    List<Venta> listaVentas = ventaServ.traerVentas();
    return listaVentas;
}

@GetMapping("/ventas/{codigo_venta}")
public Venta traerVenta(@PathVariable Long codigo_venta){
    Venta venta = ventaServ.traerVenta(codigo_venta);
    return venta;
    
}

@DeleteMapping("/clientes/ventas/eliminar/{codigo_venta}")
public String eliminarVenta(@PathVariable Long codigo_venta){
    ventaServ.eliminarVenta(codigo_venta);
    return "Se ha eliminado con exito";
}

@PutMapping("/clientes/ventas/editar/{codigo_venta}")
public String editarVenta(@PathVariable Long codigo_venta ,
                          @RequestParam Long codigoNuevo,
                          @RequestParam LocalDate fecha_venta,
                           @RequestParam Double total,
                           @RequestParam List<Producto> listaProductos,
                           @RequestParam Cliente cliente){
    
    
    ventaServ.editarVenta(codigo_venta, codigoNuevo, fecha_venta, total, listaProductos, cliente);
    
   
    
    return "Se ha editado con exito";
    
    
}

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> traerProductosVenta(@PathVariable Long codigo_venta){
        List<Venta> listaVentas = this.traerVentas();
        List<Producto> listaProductos = new ArrayList<Producto>();
        
        for(Venta venta : listaVentas){
            if(venta.getCodigo_venta() == codigo_venta){
                listaProductos = venta.getListaProductos();
            }
        }
        return listaProductos;
    }
        
        
    

@GetMapping("/ventas/traerDatos/{fecha_venta}")
public String obtenerDatosVenta(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha_venta){
    List<Venta> listaVentas = this.traerVentas(); 
    
    Double montoTotal = 0.0 ; 
    int ventasTotal = 0;
    
    for(Venta venta : listaVentas){
        if(venta.getFecha_venta().equals(fecha_venta)){
            montoTotal += venta.getTotal();
            ventasTotal ++;
        }
        
    }
    
    return "Datos de las ventas del " + fecha_venta + " : Monto total =  " + montoTotal + " Ventas Totales= " + ventasTotal; 
}


@GetMapping("/ventas/mayor_venta")
public ClaseDTO traerDatosMayorVenta(){
    List<Venta> listaVentas = this.traerVentas();
    Double montoMayor = 0.00;
    ClaseDTO mayorVenta = null;
    
    for(Venta venta : listaVentas){
        if(venta.getTotal() > montoMayor){
            montoMayor = venta.getTotal(); 
            
            mayorVenta = new ClaseDTO();
            mayorVenta.setCodigo_venta(venta.getCodigo_venta());
            mayorVenta.setCantidad_productos(venta.getListaProductos().size());
            mayorVenta.setNombre_cliente(venta.getUnCliente().getNombre());
            mayorVenta.setApellido_cliente(venta.getUnCliente().getApellido());
            mayorVenta.setTotal(montoMayor);
                    
                          }
    }
    
    return mayorVenta;
}

  
  
  
}
