package CompatibilityChecker.Parts;

public abstract class Part implements IConfigDetails, Cloneable {

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

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
