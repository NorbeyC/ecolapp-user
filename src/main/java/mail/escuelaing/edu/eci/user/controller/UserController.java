package mail.escuelaing.edu.eci.user.controller;

import mail.escuelaing.edu.eci.user.exception.UserNotFoundException;
import mail.escuelaing.edu.eci.user.repository.document.User;
import mail.escuelaing.edu.eci.user.repository.document.UserDto;
import mail.escuelaing.edu.eci.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
@RestController
@RequestMapping("/v1/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        try {
            User user = new User(userDto);
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto, @PathVariable(value = "id") String id){
        //User user = new User(userDto);
        Optional<User> users = userService.findById(id);
        if(users.isPresent()){
            userService.update(userDto, id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw  new UserNotFoundException(id);
        }
    }
}
