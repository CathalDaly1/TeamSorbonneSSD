package CompatibilityChecker;

public abstract class Equipment {

    private String name;
    private double wattage;
    private double price;

    protected Equipment(String name){
        this.name = name;
    }

    public Equipment(){
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void add(Equipment e){};

    public void remove(Equipment e){};

    public Iterable<Equipment> createIterator(){
        return null;
    };
}
