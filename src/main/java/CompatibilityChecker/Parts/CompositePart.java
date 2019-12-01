package CompatibilityChecker.Parts;

import CompatibilityChecker.Configuration.CompatibilityChecker;
import CompatibilityChecker.Configuration.ICompatibilityChecker;
import CompatibilityChecker.Configuration.WattageCompatiblityCheckerDecorator;

import java.util.ArrayList;
import java.util.List;

public class CompositePart extends Part implements IComposite {

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
        total+=this.wattage;

        return total;
    }

    public ICompatibilityChecker getCompatibility(){
        double wattageIn = 0;
        double wattageOut = 0;

        ICompatibilityChecker compatibilityChecker = new CompatibilityChecker();


        for(Part e: equipmentList) {
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


    public void add(Part e){
        equipmentList.add(e);
    }

    public void remove(Part e){
        equipmentList.remove(e);
    }

}
