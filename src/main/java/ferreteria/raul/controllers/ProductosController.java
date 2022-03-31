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
    public Mono<ProductoDTO> getProductByName(@RequestParam("nombre") String nombre){
        return this.productosService.encontrarProductoPorNombre(nombre);
    }

    @GetMapping(path = "/productosPorPrecio/{precio}")
    public Mono<ProductoDTO> getProductByPrice(@RequestParam("nombre") String textPrecio){
        Double precio = new Double(textPrecio);
        return this.productosService.encontrarProductoPorPrecio(precio);
    }

    @PostMapping(path = "/guardarProducto")
    public Mono<ProductoDTO> saveProduct(@RequestBody ProductoDTO producto){
        return this.productosService.guardarProducto(producto.getNombreProducto(),
                producto.getCantidad(), producto.getPrecio());
    }

    @PutMapping(path = "/actualizarCantidad/{cantidad}")
    public Mono<ProductoDTO> updateQuantity(@RequestBody ProductoDTO producto,
                                            @RequestParam("cantidad") String textoCantidad){
        Integer cantidad = Integer.valueOf(textoCantidad);
        return this.productosService.actualizarCantidad(producto.getNombreProducto(), cantidad);
    }

    @PutMapping(path = "/actualizarNombre/{nombreAnterior}")
    public Mono<ProductoDTO> updateName(@RequestParam("nombreAnterior") String nombre,
                                        @RequestBody ProductoDTO producto){
        return this.productosService.actualizarNombre(nombre, producto.getNombreProducto());
    }

    @PutMapping(path = "/actualizarPrecio/{nombre}")
    public Mono<ProductoDTO> updatePrice(@RequestParam("nombre") String nombre,
                                         @RequestBody ProductoDTO producto){
        return this.productosService.actualizarPrecio(nombre, producto.getPrecio());
    }

    @DeleteMapping(path = "/eliminarProducto/{nombre}")
    public void deleteProduct(@RequestParam("nombre") String nombre){
        this.productosService.eliminarProducto(nombre);
    }
}
