package CompatibilityChecker.Parts;

import CompatibilityChecker.Configuration.ConfigurationDetails;

public class Motherboard extends CompositePart {

    private String chipset;
    private int numberOfRamChannels;
    private String ramProtocol;
    private int fanPins;


    public Motherboard(String name, String brand, double wattage, String chipset, int numberOfRamChannels, String ramProtocol, int fanPins) {
        super(name, brand ,wattage);
        this.chipset = chipset;
        this.numberOfRamChannels = numberOfRamChannels;
        this.ramProtocol = ramProtocol;
        this.fanPins = fanPins;
    }

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        super.getConfiguration(configurationDetails);
        System.out.println("MOBO GetConfig called");
        configurationDetails.addRamType(ramProtocol);
        configurationDetails.setMotherboardRamChannels(numberOfRamChannels);
        configurationDetails.setWattageIn(configurationDetails.getWattageIn()+this.getWattage());
        return configurationDetails;
    }

    public int getFanPins() {
        return fanPins;
    }

    public void setFanPins(int fanPins) {
        this.fanPins = fanPins;
    }

    public String getRamProtocol() {
        return ramProtocol;
    }

    public void setRamProtocol(String ramProtocol) {
        this.ramProtocol = ramProtocol;
    }

    public int getNumberOfRamChannels() {
        return numberOfRamChannels;
    }

    public void setNumberOfRamChannels(int numberOfRamChannels) {
        this.numberOfRamChannels = numberOfRamChannels;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }



}
