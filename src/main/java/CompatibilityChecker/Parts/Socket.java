package CompatibilityChecker.Parts;

import CompatibilityChecker.Configuration.ConfigurationDetails;

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

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        System.out.println("Sockets GetConfig called");
        configurationDetails.addSocket(socketType);
        return configurationDetails;
    }
}
