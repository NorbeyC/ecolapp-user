package mail.escuelaing.edu.eci.user.service;

import mail.escuelaing.edu.eci.user.model.User;
import mail.escuelaing.edu.eci.user.model.UserDto;
import mail.escuelaing.edu.eci.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(UserDto userDto, String id) {
        {
            if ( userRepository.findById(Long.valueOf(id)).isPresent() )
            {
                User user = userRepository.findById(Long.valueOf(id)).get();
                user.update( userDto );
                userRepository.save( user );
                return user;
            }
            return null;
        }
    }

    public Optional<User> findById(String id) {
        return null;
    }
}
