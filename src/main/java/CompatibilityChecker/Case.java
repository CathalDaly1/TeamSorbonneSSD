package CompatibilityChecker;

public class Case extends CompositeEquipment{

    public Case(String name) {
        super(name);
    }

    public Case(String name, double price){
        super(name);
        setPrice(price);
    }

}
