
package nicoangeletti.bazar.controller;

import java.util.ArrayList;
import java.util.List;
import nicoangeletti.bazar.model.Producto;
import nicoangeletti.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Endpoint;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    
    
      @Autowired
      IProductoService productoServ;
    
      
      @PostMapping("/productos/crear")
      public String crearProducto(@RequestBody Producto producto){
       productoServ.guardarProducto(producto);
       return "Se ha creado el producto con exito";
      }
      
      @GetMapping("/productos")
      public List<Producto> traerProductos(){
          List<Producto> listaProductos = productoServ.traerProductos(); 
          return listaProductos; 
          
      }
      
        @GetMapping("/productos/{codigo_producto}")
      public Producto traerProducto(@PathVariable Long codigo_producto){
        Producto producto = productoServ.traerProducto(codigo_producto);
        return producto;
          
      }
      
      
     @DeleteMapping("/productos/eliminar/{codigo_producto}")
     public String eliminarProducto(@PathVariable Long codigo_producto){
         productoServ.eliminarProducto(codigo_producto);
         return "Se ha eliminado con exito" ;
        
     }
     
  
     
     
     @PutMapping("/productos/editar/{id_producto}")
public String editarProducto(@PathVariable Long id_producto,
                            @RequestParam Long idNuevo,
                            @RequestParam String nombre ,
                            @RequestParam String marca,
                            @RequestParam Double costo,
                            @RequestParam Double cantidad_disponible)
                                    {
   
                    
    productoServ.editarProducto(id_producto, idNuevo, nombre, marca, costo, cantidad_disponible);
        

    return "Se ha editado con exito";
    
}



  @GetMapping("/productos/falta_stock")
public List<Producto> traerProductosEnFalta() {
    List<Producto> listaProductosEnFalta = new ArrayList<>();
    List<Producto> listaProductos = this.traerProductos(); // Obtener la lista de productos

    for (Producto producto : listaProductos) {
        if (producto.getCantidad_disponible() < 4) { // Condición para determinar si un producto está en falta de stock
            listaProductosEnFalta.add(producto); // Agregar el producto a la lista de productos en falta
        }
    }

    return listaProductosEnFalta; // Devolver la lista de productos en falta de stock
}
 
     
     
     
     
     
}


