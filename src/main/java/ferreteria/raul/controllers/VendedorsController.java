package ferreteria.raul.controllers;

import ferreteria.raul.models.VendedorDTO;
import ferreteria.raul.services.VendedorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/ferreteriaRaul")
public class VendedorsController {

    @Autowired
    private VendedorsService vendedorsService;

    @GetMapping(path = "/vendedores")
    public Flux<VendedorDTO> getAllEmployees(){
        return this.vendedorsService.encontrarVendedores();
    }

    @GetMapping(path = "/vendedoresPorCedula/{cedula}")
    public Mono<VendedorDTO> getEmployeesByIdentification(@PathVariable("cedula") String cedula){
        return this.vendedorsService.encontrarVendedorPorCedula(cedula);
    }

    @GetMapping(path = "/vendedoresPorNombre/{nombre}")
    public Mono<VendedorDTO> getEmployeesByName(@PathVariable("nombre") String nombre){
        return this.vendedorsService.encontrarVendedorPorNombre(nombre);
    }

    @PostMapping(path = "/guardarVendedor")
    public Mono<VendedorDTO> saveEmployee(@RequestBody VendedorDTO vendedor){
        return this.vendedorsService.guardarVendedor(vendedor.getNombreVendedor(),
                vendedor.getCedulaVendedor(), vendedor.getCelularVendedor());
    }

    @PutMapping(path = "/modificarVendedor")
    public Mono<VendedorDTO> updateEmployee(@RequestBody VendedorDTO vendedor){
        return this.vendedorsService.actualizarVendedor(vendedor.getCedulaVendedor(),
                vendedor.getNombreVendedor(), vendedor.getCelularVendedor());
    }

    @DeleteMapping(path = "/eliminarVendedor/{cedula}")
    public void deleteEmployee(@PathVariable("cedula") String cedula){
        this.vendedorsService.eliminarVendedor(cedula);
    }
}
