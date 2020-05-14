package compatibility_checker.parts;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Part implements IConfigDetails, Cloneable {

    protected String name;
    protected String brand;
    protected double wattage;
    private static final Logger LOGGER = Logger.getLogger(Part.class.getName());

    protected Part(String name, String brand, double wattage){

        this.name = name;
        this.brand = brand;
        this.wattage = wattage;
    }

    protected Part(String name){
        this.name = name;
    }

    public Part(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            LOGGER.log(Level.WARNING, "context", e);
        }

        return clone;
    }
}
