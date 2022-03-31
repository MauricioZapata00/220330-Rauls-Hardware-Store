package ferreteria.raul.controllers;

import ferreteria.raul.models.ProveedorDTO;
import ferreteria.raul.services.ProveedorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/ferreteriaRaul")
public class ProveedorsController {

    @Autowired
    private ProveedorsService proveedorsService;

    @GetMapping(path = "/proveedores")
    public Flux<ProveedorDTO> getSuppliers(){
        return this.proveedorsService.encontrarTodosLosProveedores();
    }

    @GetMapping(path = "/proveedorPorNIT/{NIT}")
    public Mono<ProveedorDTO> getSupplierByNIT(@PathVariable("NIT") String NIT){
        return this.proveedorsService.encontrarProveedorPorNIT(NIT);
    }

    @GetMapping(path = "/proveedorPorNombre/{nombre}")
    public Mono<ProveedorDTO> getSupplierByName(@PathVariable("nombre") String nombre){
        return this.proveedorsService.encontrarProveedorPorNombre(nombre);
    }

    @PostMapping(path = "/guardarProveedor")
    public Mono<ProveedorDTO> saveSupplier(@RequestBody ProveedorDTO proveedor){
        return this.proveedorsService.guardarProveedor(proveedor.getNombreProveedor(),
                proveedor.getCelularProveedor(), proveedor.getNIT());
    }

    @PutMapping(path = "/actualizarProveedorNombre/{nombreAnterior}")
    public Mono<ProveedorDTO> updateSupplierName(@PathVariable("nombreAnterior") String nombre,
                                                 @RequestBody ProveedorDTO proveedor){
        return this.proveedorsService.actualizarNombre(proveedor.getNIT(), nombre);
    }

    @PutMapping(path = "/actualizarProveedorCelular/{celular}")
    public Mono<ProveedorDTO> updateSupplierTelephone(@PathVariable("celular") String celular,
                                                      @RequestBody ProveedorDTO proveedor){
        return this.proveedorsService.actualizarCelular(proveedor.getNIT(), celular);
    }

    @DeleteMapping(path = "/eliminarProveedor/{NIT}")
    public void deleteSupplier(@PathVariable("NIT") String NIT){
        this.proveedorsService.eliminarProveedor(NIT);
    }
}
