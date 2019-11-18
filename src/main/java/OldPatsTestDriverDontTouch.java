import CompatibilityChecker.Parts.*;

public class OldPatsTestDriverDontTouch {
    public static void main(String[] args){
        CompositeEquipment pc = new CompositeEquipment("PC");
        Cpu cpu = new Cpu("Intel i5 9500", "intel", 10, "Cannon Point",8,3.6);
        cpu.add(new Socket("LGA 1151"));
        cpu.add(new PowerConnector(4));

        Gpu gpu = new Gpu("Nvidia gtx 1080 ti", "Nvidia", 20,1670,11,"GDDR5X",3584);
        gpu.add(new PowerConnector(8));

        Ram ram = new Ram("Kingston 4gb HYPERX", "Kingston", 2, 2135,8,3,"GDDR4");

        Hardrive hardrive = new Hardrive("Seagate Barracuda","Seagate",5,"Hardrive",1000,500,450);

        Cooler cooler = new Cooler("Corsair H45","Corsair",0,"Water",120);

        Motherboard motherboard = new Motherboard("Asus EX-A320M","Asus",0,"AMD A320",2,"DDR4",12);
        motherboard.add(new PowerConnector(24));
        motherboard.add(new Socket("AM4"));

        PowerSupply powerSupply = new PowerSupply("EVGA 500W 80","EVGA",0);


        pc.add(cpu);
        pc.add(gpu);
        pc.add(ram);
        pc.add(hardrive);
        pc.add(cooler);
        pc.add(motherboard);
        pc.add(powerSupply);

        System.out.println(pc.getWattage());
        pc.getCompatibility().isCompatible();
    }
}
