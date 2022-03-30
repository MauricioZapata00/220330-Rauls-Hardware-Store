package ferreteria.raul.repositories;

import ferreteria.raul.models.ProductoDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ProductosRepository extends ReactiveMongoRepository<ProductoDTO, String> {
    Mono<ProductoDTO> findProductoDTOByNombreProducto(String nombre);
    Mono<ProductoDTO> findProductoDTOByPrecio(Double precio);
}
