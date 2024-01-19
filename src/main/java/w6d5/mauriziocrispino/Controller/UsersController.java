package w6d5.mauriziocrispino.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import w6d5.mauriziocrispino.Entities.User;
import w6d5.mauriziocrispino.Services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User body) throws Exception {
        return userService.save(body);
    }

}
