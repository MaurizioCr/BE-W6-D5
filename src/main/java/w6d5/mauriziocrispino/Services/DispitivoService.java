package w6d5.mauriziocrispino.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import w6d5.mauriziocrispino.Repositories.DispositivoDAO;

@Service
public class DispitivoService {
    @Autowired
    DispositivoDAO dispositivoDAO;
}
