package mail.escuelaing.edu.eci.user.service;


import mail.escuelaing.edu.eci.user.repository.document.User;
import mail.escuelaing.edu.eci.user.repository.document.UserDto;

import java.util.Optional;

public interface UserService
{
    User save(User user );

    Optional<User> findById(String id );

    User update( UserDto userDto, String id );
}
