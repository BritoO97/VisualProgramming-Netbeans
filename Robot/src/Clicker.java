
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Clicker {
    public static void main(String[] args) throws AWTException
    {
        Robot rob = new Robot();
               
        long startTime = System.currentTimeMillis();
        long elapsed = 0;
        
        rob.mouseMove(500, 500);

        do
        {
            rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            rob.delay(1);
            rob.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            rob.delay(1);

            elapsed = System.currentTimeMillis() - startTime;
            
        }while (elapsed < 65000);
    }
}
