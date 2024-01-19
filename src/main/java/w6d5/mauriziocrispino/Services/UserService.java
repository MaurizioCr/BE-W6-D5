package w6d5.mauriziocrispino.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import w6d5.mauriziocrispino.Repositories.UserDAO;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
}
