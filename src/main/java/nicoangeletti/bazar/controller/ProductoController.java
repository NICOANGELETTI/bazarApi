/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nicoangeletti.bazar.controller;

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
     
     @PutMapping("/productos/editar/{codigo_producto}")
     public String editarProducto(Producto producto){
         productoServ.guardarProducto(producto);
         return "Se ha editado con exito";
     }
      
     
     
     @PutMapping("/productos/editar/{id_producto}")
public String editarProducto(@PathVariable Long id_producto,
                            @RequestParam String nombre ,
                            @RequestParam String marca,
                            @RequestParam Double costo,
                            @RequestParam Double cantidad_disponible)
                                    {
    Producto producto = this.traerProducto(id_producto);

   
    producto.setNombre(nombre);
    producto.setMarca(marca);
    producto.setCosto(costo);
    producto.setCantidad_disponible(cantidad_disponible);
    
        
   
    this.traerProducto(id_producto);
    
    return "Se ha editado con exito";
    
}



        
    @GetMapping("/productos/falta_stock")
    public List<Producto> traerProductosEnFalta(){
        List<Producto> listaProductos = this.traerProductos();
        
        for(Producto producto : listaProductos){
            if(producto.getCantidad_disponible() < 5){
                listaProductos.remove(producto);
            }
        }
        return listaProductos;
    }
    
    
    
 
     
     
     
     
     
}


