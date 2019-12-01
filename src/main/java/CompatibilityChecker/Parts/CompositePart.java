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

    public ICompatibilityChecker getCompat(ConfigurationDetails configurationDetails){
        ICompatibilityChecker compatibilityChecker = new CompatibilityChecker();
        configurationDetails = this.getConfiguration(configurationDetails);

        WattageCompatiblityCheckerDecorator wattageCompatiblityCheckerDecorator = new WattageCompatiblityCheckerDecorator(
                compatibilityChecker,configurationDetails);

        SocketCompatibilityCheckerDecorator socketCompatibilityCheckerDecorator = new SocketCompatibilityCheckerDecorator(
                wattageCompatiblityCheckerDecorator,configurationDetails);

        RamChannelCompatibilityDecorator ramChannelCompatibilityDecorator = new RamChannelCompatibilityDecorator(
                socketCompatibilityCheckerDecorator,configurationDetails);

        ICompatibilityChecker compatibilityCheckerFinal = ramChannelCompatibilityDecorator;

        return compatibilityCheckerFinal;
    }

    public ICompatibilityChecker getCompatibility(ConfigurationDetails configurationDetails){

        ICompatibilityChecker compatibilityChecker = new CompatibilityChecker();
        configurationDetails = this.getConfiguration(configurationDetails);

        for(Part e: equipmentList) {
            if(e instanceof  CompositePart) {
                ((CompositePart) e).getCompatibility(configurationDetails);
            }
            configurationDetails = e.getConfiguration(configurationDetails);
        }


        WattageCompatiblityCheckerDecorator wattageCompatiblityCheckerDecorator = new WattageCompatiblityCheckerDecorator(
            compatibilityChecker,configurationDetails);

        SocketCompatibilityCheckerDecorator socketCompatibilityCheckerDecorator = new SocketCompatibilityCheckerDecorator(
                wattageCompatiblityCheckerDecorator,configurationDetails);


        RamChannelCompatibilityDecorator ramChannelCompatibilityDecorator = new RamChannelCompatibilityDecorator(
                socketCompatibilityCheckerDecorator,configurationDetails);

        ICompatibilityChecker compatibilityCheckerFinal = ramChannelCompatibilityDecorator;

        return compatibilityCheckerFinal;
    }

    public void add(Part e){
        equipmentList.add(e);
    }

    public void remove(Part e){
        equipmentList.remove(e);
    }


}
