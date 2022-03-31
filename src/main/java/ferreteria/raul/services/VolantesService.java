package ferreteria.raul.services;

import ferreteria.raul.models.VolanteDTO;
import ferreteria.raul.repositories.VolantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.HashMap;

@Service
public class VolantesService {

    @Autowired
    private VolantesRepository volantesRepository;

    public Flux<VolanteDTO> encontrarVolantes(){
        return this.volantesRepository.findAll();
    }

    public Flux<VolanteDTO> encontrarVolantesPorFecha(String fecha){
        return this.volantesRepository.findVolanteDTOByFecha(fecha);
    }

    public Flux<VolanteDTO> encontrarVolantesPorNIT(String NIT){
        return this.volantesRepository.findVolanteDTOByNITProveedor(NIT);
    }

    public Mono<VolanteDTO> guardarVolante(HashMap<String, Integer> productosAIngresar,
                                           String nombreProveedor, String NITProveedor){
        VolanteDTO volanteAGuardar = new VolanteDTO();
        volanteAGuardar.setFecha(LocalDateTime.now().toString());
        volanteAGuardar.setProductosAIngresar(productosAIngresar);
        volanteAGuardar.setNombreProveedor(nombreProveedor);
        volanteAGuardar.setNITProveedor(NITProveedor);
        return this.volantesRepository.save(volanteAGuardar);
    }

    public void eliminarVolante(String id){
        Mono<VolanteDTO> volanteAEliminar = this.volantesRepository.findById(id);
        volanteAEliminar.flatMap(volante ->this.volantesRepository.delete(volante));
    }
}
