import Auctions.Advert;
import CompatibilityChecker.Configuration.CompatibilityChecker;
import CompatibilityChecker.Configuration.CompatibilityResult;
import CompatibilityChecker.Configuration.ConfigurationDetails;
import CompatibilityChecker.Configuration.ICompatibilityChecker;
import CompatibilityChecker.Parts.*;
import RestAPIHandlers.GetHandler;
import RestAPIHandlers.PostHandler;
import Users.UserFactory;
import org.restlet.resource.Get;

import java.util.List;

public class OldPatsTestDriverDontTouch {
    public static void main(String[] args){
        CompositePart pc = new CompositePart("PC");
        Cpu cpu = new Cpu("Intel i5 9500", "intel", 50, "Cannon Point",8,3.6);
        cpu.add(new Socket("1151"));
        cpu.add(new PowerConnector(4));

        Gpu gpu = new Gpu("Nvidia gtx 1080 ti", "Nvidia", 20,1670,11,"GDDR5X",3584);
        gpu.add(new PowerConnector(8));

        Ram ram = new Ram("Kingston 4gb HYPERX", "Kingston", 2, 2135,8,3,"GDDR4");

        Hardrive hardrive = new Hardrive("Seagate Barracuda","Seagate",5,"Hardrive",1000,500,450);

        Cooler cooler = new Cooler("Corsair H45","Corsair",0,"Water",120);

        Motherboard motherboard = new Motherboard("Asus EX-A320M","Asus",0,"AMD A320",4,"GDDR4",12);
        motherboard.add(new PowerConnector(24));
        motherboard.add(new Socket("1151"));

        PowerSupply powerSupply = new PowerSupply("EVGA 500W 80","EVGA",80);
        powerSupply.add(new PowerConnector(6));
        powerSupply.add(new PowerConnector(6));
        powerSupply.add(new PowerConnector(8));

        pc.add(cpu);
        pc.add(gpu);
        pc.add(ram);
        pc.add(hardrive);
        pc.add(cooler);
        pc.add(motherboard);
        pc.add(powerSupply);

        CompatibilityResult compatibilityResult = new CompatibilityResult();
        ConfigurationDetails configurationDetails = new ConfigurationDetails();

//        ICompatibilityChecker compatibilityChecker = pc.getCompat(configurationDetails);
//        compatibilityResult = compatibilityChecker.isCompatible(compatibilityResult);
//        System.out.println(compatibilityResult.getMessage());
//        System.out.println(compatibilityResult.isCompatible());

        GetHandler getHandler = new GetHandler();

        PostHandler postHandler = new PostHandler();

        UserFactory userFactory = new UserFactory();
    }
}
