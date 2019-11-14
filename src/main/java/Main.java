import CompatibilityChecker.Case;
import CompatibilityChecker.Cpu;
import ui.controller.WelcomeFrameController;
import ui.view.LoginFrame;
import ui.view.RegisterFrame;
import ui.view.WelcomeFrame;

import javax.swing.*;

public class Main  {

    public static void main(String[] args)

    {
        WelcomeFrame welcomeFrame = new WelcomeFrame();
        welcomeFrame.pack();
        welcomeFrame.setVisible(true);

        RegisterFrame registerFrame = new RegisterFrame();
        registerFrame.pack();
        registerFrame.setVisible(true);

        LoginFrame loginFrame = new LoginFrame();
        loginFrame.pack();
        loginFrame.setVisible(true);


        Case caseObj = new Case("Case");

        caseObj.add(new Cpu("cpu"));

        System.out.println("test run");
        System.out.println("testing my git again");
    }
}
