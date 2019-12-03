package Users;

import CompatibilityChecker.Configuration.*;
import CompatibilityChecker.Parts.CompositePart;
import CompatibilityChecker.Parts.Part;
import RestAPIHandlers.GetHandler;
import org.restlet.resource.Get;

import java.util.List;

public class CurrentUser extends User {

    // static variable single_instance of type Singleton
    private static CurrentUser single_instance = null;
    private CompositePart pc;
    private CompositePart tempPc;
    private GetHandler getHandler;

    private CurrentUser(){
        getHandler = new GetHandler();
    }

    public static CurrentUser getInstance()
    {
        if (single_instance == null)
            single_instance = new CurrentUser();

        return single_instance;
    }

    public static CurrentUser getInstance(User u)
    {
        if (single_instance == null)
            single_instance = new CurrentUser(u);

        return single_instance;
    }

    private CurrentUser(User user){
        super(user.getuId(),user.getUsername(),user.getEmail(),user.getPassword(),false);
        getHandler = new GetHandler();
    }

    public CompositePart getPc() {
        return pc;
    }

    public void setPc(CompositePart pc) {
        this.pc = pc;
    }

    public CompatibilityResult updatePc() {
        pc = new CompositePart("PC");
        List<String> pids = getHandler.getPartsOwnedByUser(String.valueOf(this.getuId()));

        for(int i = 0;i<pids.size();i++){
            Part part = getHandler.getPartDetailsWithId(pids.get(i));
            pc.add(part);
        }

        ICompatibilityCheckerFinal compatibilityCheckerFinal = new CompatibilityCheckerFinal();
        return(compatibilityCheckerFinal.getCompatibilityOfPc(pc));
    }

    public CompatibilityResult insertPart(Part p){
        if(pc==null){
            updatePc();
        }

        tempPc = pc.replacePart(p);

        ICompatibilityCheckerFinal compatibilityCheckerFinal = new CompatibilityCheckerFinal();
        return(compatibilityCheckerFinal.getCompatibilityOfPc(tempPc));
    }
}
