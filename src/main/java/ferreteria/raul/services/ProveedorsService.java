package ferreteria.raul.services;

import ferreteria.raul.models.ProveedorDTO;
import ferreteria.raul.repositories.ProveedorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorsService {

    @Autowired
    private ProveedorsRepository proveedorsRepository;

    public Flux<ProveedorDTO> encontrarTodosLosProveedores(){
        return this.proveedorsRepository.findAll();
    }

    public Mono<ProveedorDTO> encontrarProveedorPorNIT(String NIT){
        return this.proveedorsRepository.findProveedorDTOByNIT(NIT);
    }

    public Flux<ProveedorDTO> encontrarProveedorPorNombre(String nombre){
        return this.proveedorsRepository.findProveedorDTOByNombreProveedor(nombre);
    }

    public Mono<ProveedorDTO> guardarProveedor(String nombre, String celular, String NIT){
        ProveedorDTO proveedorAGuardar = new ProveedorDTO();
        proveedorAGuardar.setNIT(NIT);
        proveedorAGuardar.setNombreProveedor(nombre);
        proveedorAGuardar.setCelularProveedor(celular);
        return this.proveedorsRepository.save(proveedorAGuardar);
    }

    public Mono<ProveedorDTO> actualizarNombre(String NIT, String nombre){
        Mono<ProveedorDTO> proveedorEncontrado = this.encontrarProveedorPorNIT(NIT);
        return proveedorEncontrado.flatMap(proveedor -> {
            proveedor.setNombreProveedor(nombre);
            return this.proveedorsRepository.save(proveedor);
        });
    }

    public Mono<ProveedorDTO> actualizarCelular(String NIT, String celular){
        Mono<ProveedorDTO> proveedorEncontrado = this.encontrarProveedorPorNIT(NIT);
        return proveedorEncontrado.flatMap(proveedor -> {
            proveedor.setCelularProveedor(celular);
            return this.proveedorsRepository.save(proveedor);
        });
    }

    public Mono<ProveedorDTO> eliminarProveedor(String NIT){
        Mono<ProveedorDTO> proveedorAEliminar = this.encontrarProveedorPorNIT(NIT);
        return proveedorAEliminar.flatMap(proveedor -> this.proveedorsRepository.delete(proveedor).thenReturn(proveedor));
    }
}
