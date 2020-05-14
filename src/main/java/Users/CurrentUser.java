package Users;

import CompatibilityChecker.Configuration.*;
import CompatibilityChecker.Parts.CompositePart;
import CompatibilityChecker.Parts.Part;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.GetHandlerCommands.GetPartDetailsWithIdCommand;
import RestAPIHandlers.Command.GetHandlerCommands.GetPartIdWithNameCommand;
import RestAPIHandlers.Command.GetHandlerCommands.GetPartsOwnedByUserCommand;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import RestAPIHandlers.GetHandler;
import org.restlet.resource.Get;

import java.util.HashMap;
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


        Command getPartsOwnedByUserCommand = new GetPartsOwnedByUserCommand();
        HashMap<String,Object> map = new HashMap<>();
        map.put("uid",String.valueOf(this.getuId()));
        RestParameters restParameters = new RestParameters(map);
        RestResponse response = getPartsOwnedByUserCommand.execute(restParameters);
        List<String> pids = (List<String>) response.getValueReturned();

        for(int i = 0;i<pids.size();i++){

            Command getPartDetailsWithIdCommand = new GetPartDetailsWithIdCommand();
            map = new HashMap<>();
            map.put("id",pids.get(i));
            restParameters = new RestParameters(map);
            response = getPartDetailsWithIdCommand.execute(restParameters);
            Part part = (Part) response.getValueReturned();
            pc.add(part);

        }

        ICompatibilityCheckerFinal compatibilityCheckerFinal = new CompatibilityCheckerFinal();
        return(compatibilityCheckerFinal.getCompatibilityOfParts(pc));
    }

    public CompatibilityResult insertPart(Part p){
        if(pc==null){
            updatePc();
        }

        tempPc = pc.replacePart(p);

        ICompatibilityCheckerFinal compatibilityCheckerFinal = new CompatibilityCheckerFinal();
        return(compatibilityCheckerFinal.getCompatibilityOfParts(tempPc));
    }
}
