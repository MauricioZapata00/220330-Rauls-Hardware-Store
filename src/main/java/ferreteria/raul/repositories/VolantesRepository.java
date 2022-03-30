package ferreteria.raul.repositories;

import ferreteria.raul.models.VolanteDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface VolantesRepository extends ReactiveMongoRepository<VolanteDTO, String> {
    Flux<VolanteDTO> findVolanteDTOByFecha(String fecha);
    Flux<VolanteDTO> findVolanteDTOByNITProveedor(String NIT);
}
