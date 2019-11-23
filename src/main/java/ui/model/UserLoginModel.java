package ui.model;

import java.security.InvalidParameterException;

public class UserLoginModel {
    private ValidationOfCredentials validationOfCredentials;
    private String username;
    private String password;

    public UserLoginModel() {

        validationOfCredentials = new ValidationOfCredentials();
    }

    public void setUsername(String username) throws InvalidParameterException {

        this.username = username;
    }

    public void setPassword(String password) throws InvalidParameterException {
        if(!validationOfCredentials.validatePassword(password)) {
            throw new InvalidParameterException("Passwords must be between 6 and 32 characters in length");
        }
        this.password = password;
    }
}
