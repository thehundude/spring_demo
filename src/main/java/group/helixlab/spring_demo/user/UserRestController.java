package group.helixlab.spring_demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Iterable<User> getUsers () {
        return userService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    User getUserById (@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    User createUser (@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    User updateUser(@PathVariable("id") int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteUser(@PathVariable("id") int id){
        userService.deleteUserById(id);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    String loginUser(@RequestParam("username") String username, @RequestParam("password") String password){
        return userService.loginUser(username, password);
    }
}
