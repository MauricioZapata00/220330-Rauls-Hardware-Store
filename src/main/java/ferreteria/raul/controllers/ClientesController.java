package ferreteria.raul.controllers;

import ferreteria.raul.models.ClientesDTO;
import ferreteria.raul.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/ferreteriaRaul")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping(path = "/clientes")
    public Flux<ClientesDTO> getAllClients(){
        return this.clientesService.encontrarClientes();
    }

    @PostMapping(path = "/guardarCliente")
    public Mono<ClientesDTO> saveClient(@RequestBody ClientesDTO cliente){
        return this.clientesService.guardarCliente(cliente.getCedulaCliente(),
                cliente.getNombreCliente(),
                cliente.getCelularCliente());
    }
}
