package CompatibilityChecker.Parts;

import CompatibilityChecker.Configuration.CompatibilityChecker;
import CompatibilityChecker.Configuration.ICompatibilityChecker;
import CompatibilityChecker.Configuration.WattageCompatiblityCheckerDecorator;

import java.util.ArrayList;
import java.util.List;

public class CompositeEquipment extends Equipment implements IComposite {

    private List<Equipment> equipmentList = new ArrayList<Equipment>();

    public CompositeEquipment(String name){
        this.setName(name);
    }

    public CompositeEquipment(String name, String brand, double wattage){
        super(name, brand, wattage);
    }

    @Override
    public double getWattage(){
        double total = 0;
        for(Equipment e: equipmentList){
            total += e.getWattage();
        }
        total+=this.wattage;

        return total;
    }

    public ICompatibilityChecker getCompatibility(){
        double wattageIn = 0;
        double wattageOut = 0;

        ICompatibilityChecker compatibilityChecker = new CompatibilityChecker();


        for(Equipment e: equipmentList) {
            wattageIn += e.getWattage();
            if(e instanceof PowerSupply){
                wattageOut = ((PowerSupply) e).getWattageOutput();
            }
        }

        System.out.println("Watt in: " + wattageIn);
        System.out.println("Watt out: " + wattageOut);

        WattageCompatiblityCheckerDecorator wattageCompatiblityCheckerDecorator = new WattageCompatiblityCheckerDecorator(
            compatibilityChecker,wattageIn,wattageOut);


        ICompatibilityChecker compatibilityCheckerFinal = wattageCompatiblityCheckerDecorator;

        return compatibilityCheckerFinal;
    }


    public void add(Equipment e){
        equipmentList.add(e);
    }

    public void remove(Equipment e){
        equipmentList.remove(e);
    }

}
