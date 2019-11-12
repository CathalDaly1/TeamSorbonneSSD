package CompatibilityChecker;

import java.util.ArrayList;

public abstract class CompositeEquipment extends Equipment {
    private ArrayList<Equipment> equipment = new ArrayList<Equipment>();

    protected CompositeEquipment(String name){
        this.setName(name);
    }

    //getConfigurationDetails

    @Override
    public double getPrice(){
        return 20;
    }
}
