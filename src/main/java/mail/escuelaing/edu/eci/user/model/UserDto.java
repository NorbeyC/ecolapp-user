package mail.escuelaing.edu.eci.user.model;

public class UserDto {
    private final String name;
    private final String lastName;
    private final String email;
    private final String password;

    public UserDto() {
        this.name = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
    }

    public String getName() {

        return name;
    }

    public String getLastName() {

        return lastName;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }
}
