package ferreteria.raul.controllers;

import ferreteria.raul.models.VolanteDTO;
import ferreteria.raul.services.VolantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/ferreteriaRaul")
public class VolantesController {

    @Autowired
    private VolantesService volantesService;

    @GetMapping(path = "/volantes")
    public Flux<VolanteDTO> getAllBalances(){
        return this.volantesService.encontrarVolantes();
    }

    @GetMapping(path = "/volantesPorFecha/{fecha}")
    public Flux<VolanteDTO> getTicketsByDate(@PathVariable("fecha") String fecha){
        return this.volantesService.encontrarVolantesPorFecha(fecha);
    }

    @GetMapping(path = "/volantesPorNIT/{NIT}")
    public Flux<VolanteDTO> getTicketsByNIT(@PathVariable("NIT") String NIT){
        return this.volantesService.encontrarVolantesPorNIT(NIT);
    }

    @PostMapping(path = "/guardarVolante")
    public Mono<VolanteDTO> saveTickets(@RequestBody VolanteDTO volante){
        return this.volantesService.guardarVolante(volante.getProductosAIngresar(),
                volante.getNombreProveedor(), volante.getNITProveedor());
    }

    @DeleteMapping(path = "/eliminarVolante/{id}")
    public void deleteTicket(@PathVariable("id") String id){
        this.volantesService.eliminarVolante(id);
    }
}
