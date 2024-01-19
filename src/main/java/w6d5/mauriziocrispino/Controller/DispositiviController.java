package w6d5.mauriziocrispino.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import w6d5.mauriziocrispino.Entities.Dispositivo;
import w6d5.mauriziocrispino.Entities.User;
import w6d5.mauriziocrispino.Services.DispitivoService;

@RestController
@RequestMapping("/dispositivi")
public class DispositiviController {
    @Autowired
    DispitivoService dispitivoService;
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dispositivo dispositivoSave(@RequestBody Dispositivo body) throws Exception {
        return dispitivoService.save(body);
    }

    @GetMapping("")
    public Page<Dispositivo> getDispositivi(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return dispitivoService.getDispositivi(page, size, sortBy);
    }
}
