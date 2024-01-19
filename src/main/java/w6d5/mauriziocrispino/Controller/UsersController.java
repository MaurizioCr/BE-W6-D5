package w6d5.mauriziocrispino.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import w6d5.mauriziocrispino.Entities.User;
import w6d5.mauriziocrispino.Payloads.NewUserPayload;
import w6d5.mauriziocrispino.Services.UserService;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UserService userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody NewUserPayload body) {
        return userService.save(body);
    }



    @GetMapping("")
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return userService.getUsers(page, size, sortBy);
    }

}
