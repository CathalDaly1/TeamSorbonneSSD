package CompatibilityChecker.Parts;

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
}
