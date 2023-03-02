package mail.escuelaing.edu.eci.user.repository;

import mail.escuelaing.edu.eci.user.repository.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
