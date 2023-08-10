package spring.user;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
    ResponseEntity<User> createUser(@RequestBody User user){
        if (users.containsKey(user.getName())){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        users.put(user.getName(), user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
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
    @GetMapping("/http")
    ResponseEntity<String> http() throws IOException {
        URL url = new URL("https://api.readhub.cn/stock_file/search_key/recommend/list?type=100&web=true");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

//读取响应
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String inputLine = in.readLine();

        in.close();
        if (inputLine != null){
            return new ResponseEntity<>(inputLine, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
