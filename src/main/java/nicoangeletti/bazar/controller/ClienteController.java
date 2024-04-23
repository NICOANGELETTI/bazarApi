
package nicoangeletti.bazar.controller;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import nicoangeletti.bazar.model.Cliente;
import nicoangeletti.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClienteController {
    
    
    
    @Autowired
    IClienteService clienteServ;
    
    




@PostMapping("/clientes/crear")
public String guardarCliente(@RequestBody Cliente cliente){
    clienteServ.guardarCliente(cliente);
    return "Se ha creado el cliente con exito";
}
 

@GetMapping("/clientes")
public List<Cliente> traerClientes(){
    List<Cliente> listaClientes = clienteServ.traerClientes();
    return listaClientes; 
    
}

    
@GetMapping("/clientes/{id_cliente}")
public Cliente traerCliente(@PathVariable Long id_cliente){
    Cliente cliente = clienteServ.traerCliente(id_cliente);
    return cliente; 
}
    

@DeleteMapping("/clientes/eliminar/{id_cliente}")
public String eliminarCliente(@PathVariable Long id_cliente){
    clienteServ.eliminarCliente(id_cliente);
    return "Se ha eliminado con exito al cliente"; 
}

 

@PutMapping("/clientes/editar/{id_cliente}")
public String editarCliente(@PathVariable Long id_cliente,
                            @RequestParam Long id_nuevo, 
                            @RequestParam String nombre ,
                            @RequestParam String apellido,
                            @RequestParam int dni){
  
    clienteServ.editarCliente(id_cliente, id_nuevo, nombre, apellido, dni);
    return "Cliente editado con exito";
}


         
}
