package w6d5.mauriziocrispino.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import w6d5.mauriziocrispino.Entities.Dispositivo;
import w6d5.mauriziocrispino.Entities.User;
import w6d5.mauriziocrispino.Payloads.NewUserPayload;
import w6d5.mauriziocrispino.Services.DispositivoService;

import java.util.UUID;

@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {
    @Autowired
    DispositivoService dispositivoService;
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dispositivo dispositivoSave(@RequestBody Dispositivo body) throws Exception {
        return dispositivoService.save(body);
    }

    @GetMapping("")
    public Page<Dispositivo> getDispositivi(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return dispositivoService.getDispositivi(page, size, sortBy);
    }

    @GetMapping("/{dispositivoId}")
    public Dispositivo findById(@PathVariable UUID dispositivoId) {
        return dispositivoService.findById(dispositivoId);
    }


    @PutMapping("/{dispositivoId}")
    public Dispositivo findByIdAndUpdate(@PathVariable UUID dispositivoId, Dispositivo body) {
        return dispositivoService.findByIdAndUpdate(dispositivoId, body);
    }

    @DeleteMapping("/{dispositivoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID dispositivoId) {
        dispositivoService.findByIdAndDelete(dispositivoId);
    }

}
