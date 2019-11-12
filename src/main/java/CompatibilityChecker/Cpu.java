package CompatibilityChecker;

public class Cpu extends Equipment {

    private String socket;

    public Cpu(String name){
        super(name);
    }

    public Cpu(String name, double price){
        super(name);
        setPrice(price);
    }

    public void add(Equipment e) {

    }

    public void remove(Equipment e) {

    }

    public Iterable<Equipment> createIterator() {
        return null;
    }
}
