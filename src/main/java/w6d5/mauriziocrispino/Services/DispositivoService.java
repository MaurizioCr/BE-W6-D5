package w6d5.mauriziocrispino.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import w6d5.mauriziocrispino.Entities.Dispositivo;
import w6d5.mauriziocrispino.Exception.NotFoundException;
import w6d5.mauriziocrispino.Repositories.DispositivoDAO;

import java.util.UUID;

@Service
public class DispositivoService {
    @Autowired
    DispositivoDAO dispositivoDAO;

    public Dispositivo save(Dispositivo body) {
        return dispositivoDAO.save(body);
    }

    public Page<Dispositivo> getDispositivi(int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return dispositivoDAO.findAll(pageable);
    }

    public Dispositivo findById(UUID id) {
        return dispositivoDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Dispositivo findByIdAndUpdate(UUID id, Dispositivo body) {

        Dispositivo found = this.findById(id);
        found.setStato(body.getStato());
        return dispositivoDAO.save(found);
    }

    public void findByIdAndDelete(UUID id) {
        Dispositivo found = this.findById(id);
        dispositivoDAO.delete(found);
    }
}
