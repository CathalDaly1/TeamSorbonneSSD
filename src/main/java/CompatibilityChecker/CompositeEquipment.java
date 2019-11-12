package CompatibilityChecker;

import java.util.ArrayList;
import java.util.List;

public class CompositeEquipment extends Equipment {
    private List<Equipment> equipmentList = new ArrayList<Equipment>();

    public CompositeEquipment(String name){
        this.setName(name);
    }

    //getConfigurationDetails

    @Override
    public double getPrice(){
        double total = 0;
        for(Equipment e: equipmentList){
            System.out.println(e.getName());
            System.out.println(e.getPrice());
            total += e.getPrice();
        }
        total+=this.price;

        return total;
    }


    public void add(Equipment e){
        equipmentList.add(e);
    }

    public void remove(Equipment e){
        equipmentList.remove(e);
    }

}
