package ui.model;
import java.security.InvalidParameterException;

public class UserRegistrationModel {

    private String username;
    private String email;
    private String password;

    public UserRegistrationModel() {
        //validation of registration credentials
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password, String confirmPassword) throws InvalidParameterException {
        if(!password.equals(confirmPassword)) {
            throw new InvalidParameterException("Passwords do not match");
        }
       this.password = password;
    }

    public void createUser() {
        System.out.println(username);
        System.out.println(email);
    }
}
