
package Finder;

import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @author Bruno Brito
 */
public class Finder {
    
    private static Robot r;
    
    // the height in pixels of the navigation bar of the web browser that the invisble cow is on (this would be tab listings, address bars, bookmarks etc)
    // default is 150
    private static int TOPBAR_HEIGHT = 150;
    
    // height of the OS taskbar at the bottom of the screen
    // Default is 50
    private static int TASKBAR_HEIGHT = 50;
    
    // milisecond delay during the click loop.
    // Default is 1 ms, though the value can be adjusted to better the the mouse movement
    private static int DELAY = 1;
    
    public static void main (String[] args) throws AWTException
    {
        /*
            The ideal way of deploying this is to have the cow game maximized with netbeans ready to run.
            ALT+TAB from chrome to neatbeans and then run the program
            The Robot will us ALT+TAB to move back and then do its scan
        
        */
        
        // create the robot
        r = new Robot();
        Cursor c = Cursor.getDefaultCursor();
        
        // get screen size
        // my screen size during testing was 2560x1440
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        
        /*  loop over the screen positions from top left to bot right
            The x starts at 20 because tere is no point of checking the very left edge of the screen.
            The y starts at 150 because that avoids most of the google chrome nav bar (tab bar, address bar, bookmarks, etc) and only hits the actual game space
            The y ends at height - 105 because that avoids the Windows 10 taskbar and misses the link on the bottom right of the game area
        */
        
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_TAB);
        
        r.keyRelease(KeyEvent.VK_TAB);
        r.keyRelease(KeyEvent.VK_ALT);
        
        r.delay(200);
        
        for (int x = 20; x < width; x += 50)
        {
            for (int y = TOPBAR_HEIGHT; y < height - (TASKBAR_HEIGHT + 55); y += 50)
            {
                moveMouse(x, y);
                r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                r.delay(DELAY);
            }
        }
        
        // do one final pass over the bottom of the page
        for (int x = 20; x < width - 20; x += 50)
        {
            moveMouse(x, height - (TASKBAR_HEIGHT + 55));
            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            r.delay(DELAY);
        }
        
        // do one final pass over the right side of the page
        for (int y = height - (TASKBAR_HEIGHT + 55); y > TOPBAR_HEIGHT; y -= 50)
        {
            moveMouse(width - 20, y);
            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            r.delay(DELAY);
        }
    }
    
    // helper method due to a bug with Robot.mouseMove() not placing the mouse at the correct position
    // known work-around is to call the method with the same parameters a few times in a row, which is what this does.
    private static void moveMouse(int x, int y)
    {
        for (int i = 0; i<3; i++)
            r.mouseMove(x, y);
    }
}
