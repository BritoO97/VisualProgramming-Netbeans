package guiExample;

import java.awt.*;
import javax.swing.*;


public class Runner {
    
    public static void main (String[] args){
        
        JFrame gui = new JFrame();
        gui.setTitle("GUI Program");
        gui.setSize(500,400);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
        MullerIllusion panel = new MullerIllusion(Color.white);
        
        Container pane = gui.getContentPane();
        pane.add(panel);
        
        gui.setVisible(true);
        
    }
    
}
