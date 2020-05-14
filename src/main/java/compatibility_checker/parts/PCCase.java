package compatibility_checker.parts;

import compatibility_checker.configuration.ConfigurationDetails;

public class PCCase extends unsupportedPart {

    private String caseObj;
    private double height;
    private double width;
    private String colour;

    public PCCase(String name, String brand, double wattage, String caseObj, double height, double width, String colour) {
        super(name, brand, wattage);
        this.caseObj = caseObj;
        this.height = height;
        this.width = width;
        this.colour = colour;
    }

    public String getCaseObj() {
        return caseObj;
    }

    public void setCaseObj(String caseObj) {
        this.caseObj = caseObj;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double dataRate) {
        this.width = width;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

     @Override
    public ConfigurationDetails getNullConfigDetails(ConfigurationDetails configurationDetails) {
        System.out.println("Case GetConfig called");
        configurationDetails.setWattageIn(configurationDetails.getWattageIn()+this.getWattage());
        return configurationDetails;
    }

    @Override
    public ConfigurationDetails getConfiguration(ConfigurationDetails configurationDetails) {
        return null;
    }
}
