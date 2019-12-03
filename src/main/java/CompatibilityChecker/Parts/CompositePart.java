package CompatibilityChecker.Parts;

import CompatibilityChecker.Configuration.*;

import java.util.ArrayList;
import java.util.List;

public class CompositePart extends Part implements IComposite{

    private List<Part> equipmentList = new ArrayList<Part>();

    public CompositePart(String name){
        this.setName(name);
    }

    public CompositePart(String name, String brand, double wattage){
        super(name, brand, wattage);
    }

    @Override
    public double getWattage(){
        double total = 0;
        for(Part e: equipmentList){
            total += e.getWattage();
        }
        total = total+ this.wattage;

        return total;
    }

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        for(Part e: equipmentList) {
                configurationDetails = e.getConfiguration(configurationDetails);
        }

        return configurationDetails;
    }

    public CompositePart replacePart(Part p){
        CompositePart temp = this;
        for(Part e: temp.equipmentList){
            if(e.getClass().equals( p.getClass())){
                temp.equipmentList.remove(e);
                temp.equipmentList.add(p);
                break;
            }
        }
        return temp;
    }


    public void add(Part e){
        equipmentList.add(e);
    }

    public void remove(Part e){
        equipmentList.remove(e);
    }


}
