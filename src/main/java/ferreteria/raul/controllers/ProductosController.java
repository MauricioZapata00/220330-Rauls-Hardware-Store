package ferreteria.raul.controllers;

import ferreteria.raul.models.ProductoDTO;
import ferreteria.raul.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/ferreteriaRaul")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping(path = "/productos")
    public Flux<ProductoDTO> getAllProducts(){
        return this.productosService.encontrarTodosLosProductos();
    }

    @GetMapping(path = "/productosPorNombre/{nombre}")
    public Mono<ProductoDTO> getProductByName(@PathVariable("nombre") String nombre){
        return this.productosService.encontrarProductoPorNombre(nombre);
    }

    @GetMapping(path = "/productosPorPrecio/{precio}")
    public Mono<ProductoDTO> getProductByPrice(@PathVariable("precio") String textPrecio){
        Double precio = Double.valueOf(textPrecio);
        return this.productosService.encontrarProductoPorPrecio(precio);
    }

    @PostMapping(path = "/guardarProducto")
    public Mono<ProductoDTO> saveProduct(@RequestBody ProductoDTO producto){
        return this.productosService.guardarProducto(producto.getNombreProducto(),
                producto.getCantidad(), producto.getPrecio());
    }

    @PutMapping(path = "/actualizarProductoCantidad/{cantidad}")
    public Mono<ProductoDTO> updateQuantity(@RequestBody ProductoDTO producto,
                                            @PathVariable("cantidad") String textoCantidad){
        Integer cantidad = Integer.valueOf(textoCantidad);
        return this.productosService.actualizarCantidad(producto.getNombreProducto(), cantidad);
    }

    @PutMapping(path = "/actualizarProductoNombre/{nombreAnterior}")
    public Mono<ProductoDTO> updateName(@PathVariable("nombreAnterior") String nombre,
                                        @RequestBody ProductoDTO producto){
        return this.productosService.actualizarNombre(nombre, producto.getNombreProducto());
    }

    @PutMapping(path = "/actualizarProductoPrecio/{nombre}")
    public Mono<ProductoDTO> updatePrice(@PathVariable("nombre") String nombre,
                                         @RequestBody ProductoDTO producto){
        return this.productosService.actualizarPrecio(nombre, producto.getPrecio());
    }

    @DeleteMapping(path = "/eliminarProducto/{nombre}")
    public void deleteProduct(@PathVariable("nombre") String nombre){
        this.productosService.eliminarProducto(nombre);
    }
}
