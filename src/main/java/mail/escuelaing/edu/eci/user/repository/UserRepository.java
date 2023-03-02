package mail.escuelaing.edu.eci.user.repository;

import mail.escuelaing.edu.eci.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
