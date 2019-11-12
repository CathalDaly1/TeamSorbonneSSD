import CompatibilityChecker.Case;
import CompatibilityChecker.CompositeEquipment;
import CompatibilityChecker.Cpu;

public class Main {

    public static void main(String[] args){
        Case caseObj2 = new Case("Case2",30);

        Case caseObj = new Case("Case",20);

        caseObj.add(new Cpu("cpu",10));

        caseObj2.add(caseObj);

        CompositeEquipment compositeEquipment = new CompositeEquipment("Compo");

        compositeEquipment.add(caseObj);

        System.out.print(compositeEquipment.getPrice());

    }
}
