package spring.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<User> getUser(@PathVariable String name){
        User result = users.get(name);
        if (users.containsKey(name)) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/user")
    User createUser(@RequestBody User user){
        users.put(user.getName(), user);
        return user;
    }
    @DeleteMapping("/user/{name}")
    ResponseEntity<Void> deleteUser(@PathVariable String name){
        if (users.containsKey(name)){
            users.remove(name);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/user")
    ResponseEntity<User> updateUser(@RequestBody User user){
        if (users.containsKey(user.getName())){
            User result = users.get(user.getName());
            result.setContact(user.getContact());
            return new ResponseEntity<>(users.get(user.getName()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
