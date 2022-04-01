package ferreteria.raul.services;

import ferreteria.raul.models.VendedorDTO;
import ferreteria.raul.repositories.VendedorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendedorsService {

    @Autowired
    private VendedorsRepository vendedorsRepository;

    public Flux<VendedorDTO> encontrarVendedores(){
        return this.vendedorsRepository.findAll();
    }

    public Mono<VendedorDTO> encontrarVendedorPorCedula(String cedula){
        return this.vendedorsRepository.findVendedorDTOByCedulaVendedor(cedula);
    }

    public Flux<VendedorDTO> encontrarVendedorPorNombre(String nombre){
        return this.vendedorsRepository.findVendedorDTOByNombreVendedor(nombre);
    }

    public Mono<VendedorDTO> guardarVendedor(String nombre, String cedula, String celular){
        VendedorDTO vendedorAGuardar = new VendedorDTO();
        vendedorAGuardar.setNombreVendedor(nombre);
        vendedorAGuardar.setCedulaVendedor(cedula);
        vendedorAGuardar.setCelularVendedor(celular);
        return this.vendedorsRepository.save(vendedorAGuardar);
    }

    public Mono<VendedorDTO> actualizarVendedor(String cedula, String nombre, String celular){
        Mono<VendedorDTO> vendedorEncontrado = this.encontrarVendedorPorCedula(cedula);
        return vendedorEncontrado.flatMap(vendedor -> {
            vendedor.setCelularVendedor(celular);
            vendedor.setNombreVendedor(nombre);
            return this.vendedorsRepository.save(vendedor);
        });
    }

    public Mono<VendedorDTO> eliminarVendedor(String cedula){
        Mono<VendedorDTO> vendedorAEliminar = this.encontrarVendedorPorCedula(cedula);
        return vendedorAEliminar.flatMap(vendedor -> this.vendedorsRepository.delete(vendedor).thenReturn(vendedor));
    }
}
