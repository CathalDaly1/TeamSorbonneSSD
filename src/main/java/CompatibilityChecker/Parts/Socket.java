package CompatibilityChecker.Parts;

public class Socket extends Part {

    private String socketType;

    public Socket(String socketType) {
        this.socketType = socketType;
    }

    public String getSocketType() {
        return socketType;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }
}
