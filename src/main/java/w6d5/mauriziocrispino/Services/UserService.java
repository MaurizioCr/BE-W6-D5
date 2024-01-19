package w6d5.mauriziocrispino.Services;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import w6d5.mauriziocrispino.Entities.User;
import w6d5.mauriziocrispino.Repositories.UserDAO;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User save(User body) {
        userDAO.findByEmail(body.getEmail()).ifPresent(user -> {
            try {
                throw new BadRequestException("L'email " + body.getEmail() + " è già stata utilizzata");
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        });
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName().charAt(0) + "+" + body.getSurname().charAt(0));
        return userDAO.save(body);
    }

}
