package dev.studyAI.User;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //CREATE
    @PostMapping("/create")
    public ResponseEntity<UserDTO> userCreating(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.save(userDTO);
        return ResponseEntity.ok(savedUser);
    }

    //READ
    @GetMapping("/all")
    public ResponseEntity<Set<UserDTO>> usersAll(){
        Set<UserDTO> users = userService.all();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long id){
        UserDTO user = userService.findUser(id);
        return ResponseEntity.ok(user);
    }

    //UPDATE
    @PutMapping("/alter/{id}")
    public ResponseEntity<UserDTO> alterUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        UserDTO updatedUser = userService.alterUser(userDTO, id);
        return ResponseEntity.ok(updatedUser);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}