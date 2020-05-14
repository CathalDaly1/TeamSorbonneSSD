package compatibility_checker.parts;

import compatibility_checker.configuration.ConfigurationDetails;

public class PartAdapter extends Part {

    private unsupportedPart adaptee;

    public PartAdapter(unsupportedPart adaptee) {
        super(adaptee.name, adaptee.brand, adaptee.wattage);
    }

    @Override
    public double getWattage() {
        return adaptee.returnZeroWattage();
    }

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        return adaptee.getNullConfigDetails(configurationDetails);
    }
}
