package ferreteria.raul.services;

import ferreteria.raul.models.ClientesDTO;
import ferreteria.raul.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Flux<ClientesDTO> encontrarClientes(){
        return this.clientesRepository.findAll();
    }

    public Mono<ClientesDTO> guardarCliente(String cedula, String nombre, String celular){
        ClientesDTO clienteAGuardar = new ClientesDTO();
        clienteAGuardar.setCelularCliente(celular);
        clienteAGuardar.setNombreCliente(nombre);
        clienteAGuardar.setCedulaCliente(cedula);
        return this.clientesRepository.save(clienteAGuardar);
    }

    public Mono<ClientesDTO> actualizarCliente(ClientesDTO cliente){
        return this.clientesRepository.save(cliente);
    }

    public Mono<ClientesDTO> eliminarCliente(String id){
        Mono<ClientesDTO> cliente = this.clientesRepository.findById(id);
        return cliente.flatMap(clientesDTO -> this.clientesRepository.delete(clientesDTO).thenReturn(clientesDTO));
    }
}
