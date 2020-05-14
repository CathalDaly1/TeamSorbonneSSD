package compatibility_checker.configuration;

import java.util.ArrayList;
import java.util.List;

public class ConfigurationDetails {

    private double wattageIn;
    private double wattageOut;

    private List<String> sockets = new ArrayList<>();
    private List<String> ramTypes = new ArrayList<>();
    private int motherboardRamChannels;
    private int ramChannels;


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
        return sockets;
    }

    public void addRamType(String ramType){
        ramTypes.add(ramType);
    }

    public List<String> getRamTypes(){
        return ramTypes;
    }

    public int getMotherboardRamChannels(){
        return motherboardRamChannels;
    }

    public void setMotherboardRamChannels(int motherboardRamChannels) {
        this.motherboardRamChannels = motherboardRamChannels;
    }

    public int getRamChannels() {
        return ramChannels;
    }

    public void setRamChannels(int ramChannels) {
        this.ramChannels = ramChannels;
    }
}
