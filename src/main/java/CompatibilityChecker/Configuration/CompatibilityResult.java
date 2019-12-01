package CompatibilityChecker.Configuration;

public class CompatibilityResult {

    private boolean isCompatible = true;
    private String message = "";

    public boolean isCompatible() {
        return isCompatible;
    }

    public void setCompatible(boolean compatible) {
        isCompatible = compatible;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
