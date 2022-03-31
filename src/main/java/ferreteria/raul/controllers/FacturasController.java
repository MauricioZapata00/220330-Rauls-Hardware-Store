package ferreteria.raul.controllers;

import ferreteria.raul.models.FacturaDTO;
import ferreteria.raul.services.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/ferreteriaRaul")
public class FacturasController {

    @Autowired
    private FacturasService facturasService;

    @GetMapping(path = "/facturas")
    public Flux<FacturaDTO> getAllBills(){
        return this.facturasService.encontrarFacturas();
    }

    @GetMapping(path = "/facturasPorNombre/{nombre}")
    public Flux<FacturaDTO> getBillsByName(@RequestParam("nombre") String nombre){
        return this.facturasService.encontrarFacturasPorNombre(nombre);
    }

    @GetMapping(path = "/facturasPorFecha/{fecha}")
    public Flux<FacturaDTO> getBillsByDate(@RequestParam("fecha") String fecha){
        return this.facturasService.encontrarFacturasPorFecha(fecha);
    }

    @PostMapping(path = "/guardarFactura")
    public Mono<FacturaDTO> saveBill(@RequestBody FacturaDTO factura){
        return this.facturasService.guardarFactura(factura.getProductos(),
                factura.getNombreVendedor(), factura.getNombreCliente(),
                factura.getTotalAPagar());
    }

    @DeleteMapping(path = "/eliminarFactura/{incrementable}")
    public void deleteBill(@RequestParam("incrementable") Long incrementable){
        this.facturasService.eliminarFactura(incrementable);
    }
}
