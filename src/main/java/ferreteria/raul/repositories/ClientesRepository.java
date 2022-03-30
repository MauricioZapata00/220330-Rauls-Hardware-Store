package ferreteria.raul.repositories;

import ferreteria.raul.models.ClientesDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClientesRepository extends ReactiveMongoRepository<ClientesDTO, String> {
    Mono<ClientesDTO> findClientesDTOByCedula(String cedula);
    Mono<ClientesDTO> findClientesDTOByNombreCliente(String nombre);
}
