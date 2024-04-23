
package nicoangeletti.bazar.service;

import java.util.List;
import nicoangeletti.bazar.model.Cliente;



public interface IClienteService {
    
    
    public void guardarCliente(Cliente cliente);
    
    public List<Cliente> traerClientes();
    
    public Cliente traerCliente(Long idCliente);
    
    public void eliminarCliente(Long idCliente);
    
    public void editarCliente(Long idOriginal , Long idNuevo ,String nombre, String apellido , int dni);
    
    
}
