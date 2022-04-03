package ferreteria.raul.controllers;

import ferreteria.raul.models.ProductoDTO;
import ferreteria.raul.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/ferreteriaRaul")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping(path = "/productos")
    public Flux<ProductoDTO> getAllProducts(){
        return this.productosService.encontrarTodosLosProductos();
    }

    @GetMapping(path = "/productosPorNombre/{nombre}")
    public Flux<ProductoDTO> getProductByName(@PathVariable("nombre") String nombre){
        return this.productosService.encontrarProductoPorNombre(nombre);
    }

    @GetMapping(path = "/productosPorPrecio/{precio}")
    public Flux<ProductoDTO> getProductByPrice(@PathVariable("precio") String textPrecio){
        Double precio = Double.valueOf(textPrecio);
        return this.productosService.encontrarProductoPorPrecio(precio);
    }

    @PostMapping(path = "/guardarProducto")
    public Mono<ProductoDTO> saveProduct(@RequestBody ProductoDTO producto){
        return this.productosService.guardarProducto(producto.getNombreProducto(),
                producto.getCantidad(), producto.getPrecio());
    }

    @PutMapping(path = "/actualizarProductoCantidad/{id}/{cantidad}")
    public Mono<ProductoDTO> updateQuantity(@PathVariable("id") String id,
                                            @PathVariable("cantidad") String textoCantidad){
        Integer cantidad = Integer.valueOf(textoCantidad);
        return this.productosService.actualizarCantidad(id, cantidad);
    }

    @PutMapping(path = "/actualizarProductoNombre/{id}/{nuevoNombre}")
    public Mono<ProductoDTO> updateName(@PathVariable("id") String id,
                                        @PathVariable("nuevoNombre") String nombreNuevo){
        return this.productosService.actualizarNombre(id, nombreNuevo);
    }

    @PutMapping(path = "/actualizarProductoPrecio/{id}/{precio}")
    public Mono<ProductoDTO> updatePrice(@PathVariable("id") String id,
                                         @PathVariable("precio") Double precio){
        return this.productosService.actualizarPrecio(id, precio);
    }

    @DeleteMapping(path = "/eliminarProducto/{id}")
    public Mono<ProductoDTO> deleteProduct(@PathVariable("id") String id){
        return this.productosService.eliminarProducto(id);
    }
}
