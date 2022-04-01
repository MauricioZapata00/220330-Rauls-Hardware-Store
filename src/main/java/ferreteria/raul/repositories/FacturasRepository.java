package ferreteria.raul.repositories;

import ferreteria.raul.models.FacturaDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface FacturasRepository extends ReactiveMongoRepository<FacturaDTO, String> {
    Flux<FacturaDTO> findFacturaDTOByFecha(String fecha);
    Mono<FacturaDTO> findFacturaDTOByIncrementable(Long incrementable);
    Flux<FacturaDTO> findFacturaDTOByNombreCliente(String nombre);
    
}
