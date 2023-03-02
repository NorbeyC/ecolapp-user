package mail.escuelaing.edu.eci.user.controller;

import mail.escuelaing.edu.eci.user.exception.UserNotFoundException;
import mail.escuelaing.edu.eci.user.persistence.User;
import mail.escuelaing.edu.eci.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users/")
public class UserController {
    private final UserService usersService;

    public UserController(@Autowired UserService userService) {
        this.usersService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        //TODO implement this method
        return ResponseEntity.ok(usersService.all());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        //TODO implement this method
        try {
            return new ResponseEntity<User>(usersService.findById(id).get(), HttpStatus.OK);
        }catch (Exception e){
            throw new UserNotFoundException(id);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        //TODO implement this method
        Optional<User> usuaroExistente = usersService.findById(id);
        if (!usuaroExistente.isEmpty()){
            usersService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new UserNotFoundException(id);
    }
}
