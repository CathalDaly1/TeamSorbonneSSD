package CompatibilityChecker.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationDetails {

    private double wattageIn;
    private double wattageOut;

    private List<String> sockets = new ArrayList<>();



    public double getWattageIn() {
        return wattageIn;
    }

    public void setWattageIn(double wattageIn) {
        this.wattageIn = wattageIn;
    }

    public double getWattageOut() {
        return wattageOut;
    }

    public void setWattageOut(double wattageOut) {
        this.wattageOut = wattageOut;
    }

    public void addSocket(String socketType){
        sockets.add(socketType);
    }

    public List<String> getSockets(){
        return this.sockets;
    }

}
