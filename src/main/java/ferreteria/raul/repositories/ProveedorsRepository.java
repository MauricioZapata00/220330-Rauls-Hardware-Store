package ferreteria.raul.repositories;

import ferreteria.raul.models.ProveedorDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProveedorsRepository extends ReactiveMongoRepository<ProveedorDTO, String> {
    Mono<ProveedorDTO> findProveedorDTOByNIT(String NIT);
    Flux<ProveedorDTO> findProveedorDTOByNombreProveedor(String nombre);
}
