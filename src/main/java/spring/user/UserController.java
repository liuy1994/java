package spring.user;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    private final HashMap<String, User> users = new HashMap<>();
    @GetMapping("/user")
    List<User> getAllUsers(){
        return new ArrayList<>(users.values());
    }
    @GetMapping("/user/{name}")
    User getUser(@PathVariable String name){
        return users.get(name);
    }

    @PostMapping("/user")
    User createUser(@RequestBody User user){
        users.put(user.getName(), user);
        return user;
    }
    @DeleteMapping("/user/{name}")
    void deleteUser(@PathVariable String name){
        users.remove(name);
    }
    @PutMapping("/user")
    User updateUser(@RequestBody User user){
        users.put(user.getName(), user);
        return user;
    }

}
