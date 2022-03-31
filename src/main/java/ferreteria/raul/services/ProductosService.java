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

    public Mono<ProductoDTO> encontrarProductoPorNombre(String nombre){
        return this.productosRepository.findProductoDTOByNombreProducto(nombre);
    }

    public Mono<ProductoDTO> encontrarProductoPorPrecio(Double precio){
        return this.productosRepository.findProductoDTOByPrecio(precio);
    }

    public Mono<ProductoDTO> guardarProducto(String nombre, Integer cantidad, Double precio){
        ProductoDTO productoAGuardar = new ProductoDTO();
        productoAGuardar.setNombreProducto(nombre);
        productoAGuardar.setCantidad(cantidad);
        productoAGuardar.setPrecio(precio);
        return this.productosRepository.save(productoAGuardar);
    }

    public Mono<ProductoDTO> actualizarCantidad(String nombre, Integer cantidad){
        Mono<ProductoDTO> productoEncontrado = this.encontrarProductoPorNombre(nombre);
        return productoEncontrado.flatMap(producto -> {
            producto.setCantidad(cantidad);
            return this.productosRepository.save(producto);
        });
    }

    public Mono<ProductoDTO> actualizarNombre(String nombreAnterior, String nombreNuevo){
        Mono<ProductoDTO> productoEncontrado = this.encontrarProductoPorNombre(nombreAnterior);
        return productoEncontrado.flatMap(producto -> {
            producto.setNombreProducto(nombreNuevo);
            return this.productosRepository.save(producto);
        });
    }

    public Mono<ProductoDTO> actualizarPrecio(String nombre, Double precio){
        Mono<ProductoDTO> productoEncontrado = this.encontrarProductoPorNombre(nombre);
        return productoEncontrado.flatMap(producto -> {
            producto.setPrecio(precio);
            return this.productosRepository.save(producto);
        });
    }

    public void eliminarProducto(String nombre){
        Mono<ProductoDTO> productoAEliminar = this.encontrarProductoPorNombre(nombre);
        productoAEliminar.flatMap(producto -> this.productosRepository.delete(producto));
    }
}
