package optionpanes;

import javax.swing.JOptionPane;


/**
 *
 * @author bruno
 */
public class OptionPanes {
    public static void main (String[] args)
    {
        /*String number;
        number = JOptionPane.showInputDialog("Enter A Number");
        
        int num = Integer.parseInt(number);
        
        JOptionPane.showMessageDialog(null, "The answer is " + (num + num));
*/
        
        String fName = JOptionPane.showInputDialog("What is your first name?");
        
        String mName = JOptionPane.showInputDialog("What is your middle name?");
        
        String lName = JOptionPane.showInputDialog("What is your last name?");
        
        JOptionPane.showMessageDialog(null, "Hello " + fName + " " + mName + " " + lName);
        
        System.exit(0);
    }
}
