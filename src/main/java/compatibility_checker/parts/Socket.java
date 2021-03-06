package compatibility_checker.parts;

import compatibility_checker.configuration.ConfigurationDetails;

public abstract class Socket extends Part {

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
        configurationDetails.addSocket(socketType);
        return configurationDetails;
    }
}
