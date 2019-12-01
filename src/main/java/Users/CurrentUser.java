package Users;

import CompatibilityChecker.Parts.CompositePart;
import RestAPIHandlers.GetHandler;
import org.restlet.resource.Get;

import java.util.List;

public class CurrentUser extends User {

    // static variable single_instance of type Singleton
    private static CurrentUser single_instance = null;
    private CompositePart pc;
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

    public void updatePc() {
        List<String> pids = getHandler.getPartsOwnedByUser(String.valueOf(this.getuId()));

//        CompositePart pc = getHandler.getPartDetailsWithId()

        for(int i = 0;i<pids.size();i++){
            System.out.println(pids.get(i));
        }

//        getHandler.
        //get all pids for that user
        //create objects that align with those parts based on type of part
        //fac
    }
}
