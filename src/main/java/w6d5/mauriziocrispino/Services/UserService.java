package w6d5.mauriziocrispino.Services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import w6d5.mauriziocrispino.Entities.Dispositivo;
import w6d5.mauriziocrispino.Entities.User;
import w6d5.mauriziocrispino.Exception.NotFoundException;
import w6d5.mauriziocrispino.Payloads.NewUserPayload;
import w6d5.mauriziocrispino.Repositories.UserDAO;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    private DispositivoService dispositivoService;

    public User save(NewUserPayload body) {
        userDAO.findByEmail(body.getEmail()).ifPresent(user -> {
            try {
                throw new BadRequestException("L'email " + body.getEmail() + " è già stata utilizzata");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });
        Dispositivo dispositivo = dispositivoService.findById(body.getDispositivoID());
            User newUser = new User();
            newUser.setName(body.getName());
            newUser.setSurname(body.getSurname());
            newUser.setEmail(body.getEmail());
            newUser.setDispositivo(dispositivo);
            newUser.setAvatar(body.getAvatar());
            newUser.setUsername(body.getUsername());
            return userDAO.save(newUser);
    }

    public Page<User> getUsers(int page, int size, String sort) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return userDAO.findAll(pageable);
    }

    public User findById(UUID id) {
        return userDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public User findByIdAndUpdate(UUID id, NewUserPayload body) {
        User found = this.findById(id);

        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setUsername(body.getUsername());
        found.setEmail(body.getEmail());
        found.setAvatar(body.getAvatar());

        if(found.getDispositivo().getId()!= body.getDispositivoID()) {
            Dispositivo newDispositivo = dispositivoService.findById(body.getDispositivoID());
            found.setDispositivo(newDispositivo);
        }

        return userDAO.save(found);
    }

    public void findByIdAndDelete(UUID id) {
        User found = this.findById(id);
        userDAO.delete(found);
    }
}
