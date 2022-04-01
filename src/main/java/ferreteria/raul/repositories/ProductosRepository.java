package ferreteria.raul.repositories;

import ferreteria.raul.models.ProductoDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductosRepository extends ReactiveMongoRepository<ProductoDTO, String> {
    Flux<ProductoDTO> findProductoDTOByNombreProducto(String nombre);
    Flux<ProductoDTO> findProductoDTOByPrecio(Double precio);
}
