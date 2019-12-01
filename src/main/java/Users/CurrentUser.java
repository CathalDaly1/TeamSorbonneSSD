package Users;

import CompatibilityChecker.Parts.CompositePart;
import RestAPIHandlers.GetHandler;
import org.restlet.resource.Get;

public class CurrentUser extends User {

    // static variable single_instance of type Singleton
    private static CurrentUser single_instance = null;
    private CompositePart pc;

    private CurrentUser(){

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
    }

    public CompositePart getPc() {
        return pc;
    }

    public void setPc(CompositePart pc) {
        this.pc = pc;
    }

    public void updatePc() {
//        getHandler.

        //get all pids for that user
        //create objects that align with those parts based on type of part
        // fac
    }
}
