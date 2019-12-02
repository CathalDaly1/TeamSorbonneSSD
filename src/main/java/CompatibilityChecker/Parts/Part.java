package CompatibilityChecker.Parts;

public abstract class Part implements IConfigDetails {

    protected String name;
    protected String brand;
    protected double wattage;

    protected Part(String name, String brand, double wattage){
        this.name = name;
        this.brand = brand;
        this.wattage = wattage;
    }

    protected Part(String name){
        this.name = name;
    }

    public Part(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
