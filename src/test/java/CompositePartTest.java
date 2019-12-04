import static org.junit.jupiter.api.Assertions.assertEquals;

import CompatibilityChecker.Configuration.*;
import CompatibilityChecker.Parts.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompositePartTest {

    ICompatibilityCheckerFinal compatibilityChecker;

    @BeforeEach
    public void init() {
        compatibilityChecker = new CompatibilityCheckerFinal();
    }


    @Test
    public void ramWrongChannelAmountTest() {
        CompositePart pc = new CompositePart("PC");
        Ram ram = new Ram("Kingston 4gb HYPERX", "Kingston", 0, 2135, 8, 3, "GDDR4");
        Motherboard motherboard = new Motherboard("Asus EX-A320M", "Asus", 0, "AMD A320", 2, "GDDR4", 12);
        pc.add(ram);
        pc.add(motherboard);
        CompatibilityResult compatibilityResult = compatibilityChecker.getCompatibilityOfParts(pc);
        assertEquals(false, compatibilityResult.isCompatible());
    }



    @Test
    public void ramRightChannelAmountTest(){
        CompositePart pc = new CompositePart("PC");
        Ram ram = new Ram("Kingston 4gb HYPERX", "Kingston", 0, 2135,8,3,"GDDR4");
        Motherboard motherboard = new Motherboard("Asus EX-A320M","Asus",0,"AMD A320",4,"GDDR4",12);
        pc.add(ram);
        pc.add(motherboard);
        CompatibilityResult compatibilityResult = compatibilityChecker.getCompatibilityOfParts(pc);
        assertEquals(true, compatibilityResult.isCompatible());
    }

    @Test
    public void ramWrongChannelTypeTest(){
        CompositePart pc = new CompositePart("PC");
        Ram ram = new Ram("Kingston 4gb HYPERX", "Kingston", 0, 2135,8,3,"DDR4");
        Motherboard motherboard = new Motherboard("Asus EX-A320M","Asus",0,"AMD A320",4,"DDR4",12);
        pc.add(ram);
        pc.add(motherboard);
        CompatibilityResult compatibilityResult = compatibilityChecker.getCompatibilityOfParts(pc);
        assertEquals(true, compatibilityResult.isCompatible());
    }
    @Test

    public void ramRightChannelTypeTest(){
        CompositePart pc = new CompositePart("PC");
        Ram ram = new Ram("Kingston 4gb HYPERX", "Kingston", 0, 2135,8,3,"DDR4");
        Motherboard motherboard = new Motherboard("Asus EX-A320M","Asus",0,"AMD A320",4,"DDR3",12);
        pc.add(ram);
        pc.add(motherboard);
        CompatibilityResult compatibilityResult = compatibilityChecker.getCompatibilityOfParts(pc);
        assertEquals(false, compatibilityResult.isCompatible());
    }

    @Test
    public void cpuRightSocketTest(){
        CompositePart pc = new CompositePart("PC");
        Cpu cpu = new Cpu("Intel i5 9500", "intel", 0, "Cannon Point",8,3.6);
        cpu.add(new Socket("1151"));
        cpu.add(new PowerConnector(4));
        Motherboard motherboard = new Motherboard("Asus EX-A320M","Asus",0,"AMD A320",4,"GDDR4",12);
        motherboard.add(new PowerConnector(24));
        motherboard.add(new Socket("1151"));
        pc.add(cpu);
        pc.add(motherboard);
        CompatibilityResult compatibilityResult = compatibilityChecker.getCompatibilityOfParts(pc);
        assertEquals(true, compatibilityResult.isCompatible());
    }

    @Test
    public void cpuWrongSocketTest(){
        CompositePart pc = new CompositePart("PC");
        Cpu cpu = new Cpu("Intel i5 9500", "intel", 0, "Cannon Point",8,3.6);
        cpu.add(new Socket("AM4"));
        cpu.add(new PowerConnector(4));
        Motherboard motherboard = new Motherboard("Asus EX-A320M","Asus",0,"AMD A320",4,"GDDR4",12);
        motherboard.add(new PowerConnector(24));
        motherboard.add(new Socket("1151"));
        pc.add(cpu);
        pc.add(motherboard);
        CompatibilityResult compatibilityResult = compatibilityChecker.getCompatibilityOfParts(pc);
        assertEquals(false, compatibilityResult.isCompatible());
    }

    @Test
    public void wattageWrongTest(){
        CompositePart pc = new CompositePart("PC");
        Cpu cpu = new Cpu("Intel i5 9500", "intel", 50, "Cannon Point",8,3.6);
        cpu.add(new Socket("1151"));
        cpu.add(new PowerConnector(4));
        PowerSupply powerSupply = new PowerSupply("EVGA 500W 80","EVGA",40);
        pc.add(cpu);
        pc.add(powerSupply);
        CompatibilityResult compatibilityResult = compatibilityChecker.getCompatibilityOfParts(pc);
        assertEquals(false, compatibilityResult.isCompatible());
    }

    @Test
    public void wattageRightTest(){
        CompositePart pc = new CompositePart("PC");
        Cpu cpu = new Cpu("Intel i5 9500", "intel", 50, "Cannon Point",8,3.6);
        cpu.add(new Socket("1151"));
        cpu.add(new PowerConnector(4));
        PowerSupply powerSupply = new PowerSupply("EVGA 500W 80","EVGA",80);
        pc.add(cpu);
        pc.add(powerSupply);
        CompatibilityResult compatibilityResult = compatibilityChecker.getCompatibilityOfParts(pc);
        assertEquals(true, compatibilityResult.isCompatible());
    }

}