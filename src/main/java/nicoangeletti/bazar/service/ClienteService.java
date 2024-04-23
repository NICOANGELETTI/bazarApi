
package nicoangeletti.bazar.service;

import java.util.List;
import nicoangeletti.bazar.model.Cliente;
import nicoangeletti.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService implements IClienteService{

    
    
    @Autowired
    IClienteRepository clienteRepo;
    
    
    @Override
    public void guardarCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> traerClientes() {
        List<Cliente> listaClientes = clienteRepo.findAll();
        return listaClientes;
    }

    @Override
    public Cliente traerCliente(Long idCliente) {
       Cliente cliente = clienteRepo.findById(idCliente).orElse(null);
       return cliente; 
        
    }

    @Override
    public void eliminarCliente(Long idCliente) {
        clienteRepo.deleteById(idCliente);
    }

    @Override
    public void editarCliente(Cliente cliente) {
        this.guardarCliente(cliente);
    }
    
    
    
}
