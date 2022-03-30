package ferreteria.raul.repositories;

import ferreteria.raul.models.VendedorDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface VendedorsRepository extends ReactiveMongoRepository<VendedorDTO, String>{
    Mono<VendedorDTO> findVendedorDTOByCedulaVendedor(String cedula);
    Mono<VendedorDTO> findVendedorDTOByNombreVendedor(String nombre);
}
