package CompatibilityChecker.Parts;

public class Cooler extends Part {

    private String type;
    private double fanSizemm;

    public Cooler(String name, String brand, double wattage,String type, double fanSize) {
        super(name,brand,wattage);
        this.type = type;
        this.fanSizemm = fanSize;
    }
}
