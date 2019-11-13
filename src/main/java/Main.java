import CompatibilityChecker.Case;
import CompatibilityChecker.Cpu;
import ui.view.WelcomeFrame;

import javax.swing.*;

public class Main extends WelcomeFrame {

    public static void main(String[] args){

        WelcomeFrame welcomeFrame = new WelcomeFrame();
        welcomeFrame.pack();
        welcomeFrame.setVisible(true);

        Case caseObj = new Case("Case");

        caseObj.add(new Cpu("cpu"));

        System.out.println("test run");
    }
}
