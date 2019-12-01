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
        total+=this.wattage;

        return total;
    }

    public ICompatibilityChecker getCompatibility(){

        ICompatibilityChecker compatibilityChecker = new CompatibilityChecker();

        ConfigurationDetails configurationDetails = new ConfigurationDetails();


        for(Part e: equipmentList) {
            configurationDetails = e.getConfiguration(configurationDetails);
        }

        WattageCompatiblityCheckerDecorator wattageCompatiblityCheckerDecorator = new WattageCompatiblityCheckerDecorator(
            compatibilityChecker,configurationDetails);

        SocketCompatibilityCheckerDecorator socketCompatibilityCheckerDecorator = new SocketCompatibilityCheckerDecorator(
                wattageCompatiblityCheckerDecorator,configurationDetails
        );

        ICompatibilityChecker compatibilityCheckerFinal = socketCompatibilityCheckerDecorator;

        return compatibilityCheckerFinal;
    }


    public void add(Part e){
        equipmentList.add(e);
    }

    public void remove(Part e){
        equipmentList.remove(e);
    }


    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        return configurationDetails;
    }
}
