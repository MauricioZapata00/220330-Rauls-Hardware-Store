package ferreteria.raul.services;

import ferreteria.raul.models.ProductoDTO;
import ferreteria.raul.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public Flux<ProductoDTO> encontrarTodosLosProductos(){
        return this.productosRepository.findAll();
    }

    public Flux<ProductoDTO> encontrarProductoPorNombre(String nombre){
        return this.productosRepository.findProductoDTOByNombreProducto(nombre);
    }

    public Flux<ProductoDTO> encontrarProductoPorPrecio(Double precio){
        return this.productosRepository.findProductoDTOByPrecio(precio);
    }

    public Mono<ProductoDTO> guardarProducto(String nombre, Integer cantidad, Double precio){
        ProductoDTO productoAGuardar = new ProductoDTO();
        productoAGuardar.setNombreProducto(nombre);
        productoAGuardar.setCantidad(cantidad);
        productoAGuardar.setPrecio(precio);
        return this.productosRepository.save(productoAGuardar);
    }

    public Mono<ProductoDTO> actualizarCantidad(String id, Integer cantidad){
        Mono<ProductoDTO> productoEncontrado = this.productosRepository.findById(id);
        return productoEncontrado.flatMap(producto -> {
            producto.setCantidad(cantidad);
            return this.productosRepository.save(producto);
        });
    }

    public Mono<ProductoDTO> actualizarNombre(String id, String nombreNuevo){
        Mono<ProductoDTO> productoEncontrado = this.productosRepository.findById(id);
        return productoEncontrado.flatMap(producto -> {
            producto.setNombreProducto(nombreNuevo);
            return this.productosRepository.save(producto);
        });
    }

    public Mono<ProductoDTO> actualizarPrecio(String id, Double precio){
        Mono<ProductoDTO> productoEncontrado = this.productosRepository.findById(id);
        return productoEncontrado.flatMap(producto -> {
            producto.setPrecio(precio);
            return this.productosRepository.save(producto);
        });
    }

    public Mono<ProductoDTO> eliminarProducto(String id){
        Mono<ProductoDTO> productoAEliminar = this.productosRepository.findById(id);
        return productoAEliminar.flatMap(producto -> this.productosRepository.delete(producto).thenReturn(producto));
    }
}
