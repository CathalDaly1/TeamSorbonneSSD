package ui.model;

public class ValidationOfCredentials {

    public boolean validateEmail(String email) {

        return email.matches("^(.+)@(.+)$");
    }

    public boolean validatePassword(String password) {

        return password.matches(".{2,32}");
    }

    public boolean validateName(String name) {

        return name.matches("^[\\p{L}\\s.’\\-,]+$");
    }

}
