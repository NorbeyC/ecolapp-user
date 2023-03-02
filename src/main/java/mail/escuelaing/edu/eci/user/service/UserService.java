package mail.escuelaing.edu.eci.user.service;

import mail.escuelaing.edu.eci.user.repository.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public ResponseEntity<?> save(User user) {
        return null;
    }

    public ResponseEntity<?> update(User user) {
        return null;
    }

    public Optional<User> findById(String id) {
        return null;
    }
}
