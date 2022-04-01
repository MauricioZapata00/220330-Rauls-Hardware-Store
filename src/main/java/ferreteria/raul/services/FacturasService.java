package ferreteria.raul.services;

import ferreteria.raul.models.FacturaDTO;
import ferreteria.raul.repositories.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

@Service
public class FacturasService {

    @Autowired
    private FacturasRepository facturasRepository;

    public Flux<FacturaDTO> encontrarFacturas(){
        return this.facturasRepository.findAll();
    }

    public Flux<FacturaDTO> encontrarFacturasPorFecha(String fecha){
        return this.facturasRepository.findFacturaDTOByFecha(fecha);
    }

    public Flux<FacturaDTO> encontrarFacturasPorNombre(String nombre){
        return this.facturasRepository.findFacturaDTOByNombreCliente(nombre);
    }

    public Mono<FacturaDTO> guardarFactura(HashMap<String, Integer> productos,
                                           String nombreVendedor, String nombreCliente,
                                           Double totalAPagar){
        FacturaDTO facturaAGuardar = new FacturaDTO();
        Random aleatorio = new SecureRandom();
        Long incrementable = aleatorio.nextLong();
        facturaAGuardar.setIncrementable(incrementable);
        facturaAGuardar.setFecha(LocalDateTime.now().toString());
        facturaAGuardar.setProductos(productos);
        facturaAGuardar.setNombreCliente(nombreCliente);
        facturaAGuardar.setNombreVendedor(nombreVendedor);
        facturaAGuardar.setTotalAPagar(totalAPagar);
        return this.facturasRepository.save(facturaAGuardar);
    }

    public Mono<FacturaDTO> eliminarFactura(String id){
        Mono<FacturaDTO> factura = this.facturasRepository.findById(id);
        return factura.flatMap(facturaDTO -> this.facturasRepository.delete(facturaDTO).thenReturn(facturaDTO));
    }
}
