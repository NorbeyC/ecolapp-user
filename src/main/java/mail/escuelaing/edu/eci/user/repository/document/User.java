package mail.escuelaing.edu.eci.user.repository.document;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Document
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    private String name;

    private String lastName;

    @Indexed( unique = true )
    private String email;

    private final Date createdAt;

    List<RoleEnum> roles;

    private String passwordHash;


    public User( UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
        roles = new ArrayList<>( Collections.singleton( RoleEnum.USER ) );
        // passwordHash = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLastName()
    {
        return lastName;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public List<RoleEnum> getRoles()
    {
        return roles;
    }

    public void update( UserDto userDto )
    {
        this.name = userDto.getName();
        this.lastName = userDto.getLastName();
        this.email = userDto.getEmail();
        /*if ( userDto.getPassword() != null )
        {
            this.passwordHash = BCrypt.hashpw( userDto.getPassword(), BCrypt.gensalt() );
        }*/
    }
}
