package swing;

import javax.swing.*;

/**
 * Created by tvist on 07.11.16.
 */
public class Base {
    private JFrame mainFrame;
    public Base(){
        prepareGUI();
    }

    public static void main(String[] args){
        Base mainBase = new Base();
        mainBase.showEventDemo();

    }


    private void prepareGUI() {
        mainFrame = new JFrame("BaseDemo");
        mainFrame.setSize(600,600);
    }

    private void showEventDemo() {
        mainFrame.setVisible(true);
    }
}
