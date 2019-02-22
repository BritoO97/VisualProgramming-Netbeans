
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Runner {
    public static void main (String[] args) throws AWTException
    {
        /*
        Robot myRobot = new Robot();
        for (int i = 0; i < 540; i++)
        {
            myRobot.mouseMove(i, i);
            //myRobot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            //myRobot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            myRobot.delay(5);
        }
        */
        
        //test();
        
        cookieClicker();
    }
    
    private static void cookieClicker() throws AWTException
    {
        
        
      
                
    }
    
    private static void test() throws AWTException
    {
        Robot rob = new Robot();
        
        // move lower right corner
        rob.mouseMove(5000, 5000);
        
        // click "go to desktop shortcut"
        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        
        // move over discord icon
        rob.mouseMove(500, 650);
        
        // double click
        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        
        rob.delay(1000);
        
        rob.keyPress(KeyEvent.VK_H);
        rob.keyRelease(KeyEvent.VK_H);
        
        rob.keyPress(KeyEvent.VK_E);
        rob.keyRelease(KeyEvent.VK_E);
        
        rob.keyPress(KeyEvent.VK_L);
        rob.keyRelease(KeyEvent.VK_L);
        
        rob.keyPress(KeyEvent.VK_L);
        rob.keyRelease(KeyEvent.VK_L);
        
        rob.keyPress(KeyEvent.VK_O);
        rob.keyRelease(KeyEvent.VK_O);
        
        rob.keyPress(KeyEvent.VK_SPACE);
        rob.keyRelease(KeyEvent.VK_SPACE);
        
        rob.keyPress(KeyEvent.VK_W);
        rob.keyRelease(KeyEvent.VK_W);
        
        rob.keyPress(KeyEvent.VK_O);
        rob.keyRelease(KeyEvent.VK_O);
        
        rob.keyPress(KeyEvent.VK_R);
        rob.keyRelease(KeyEvent.VK_R);
        
        rob.keyPress(KeyEvent.VK_L);
        rob.keyRelease(KeyEvent.VK_L);
        
        rob.keyPress(KeyEvent.VK_D);
        rob.keyRelease(KeyEvent.VK_D);
        
        rob.keyPress(KeyEvent.VK_ENTER);
        rob.keyRelease(KeyEvent.VK_ENTER);
        
    }
}
