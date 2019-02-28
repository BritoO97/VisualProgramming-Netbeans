package textGame;

/**
 *
 * @author bruno
 */
public class Runner {
    
    public static void main (String[] args){
        
        // innitialize the game manager and then start the game
        GameManager gm = new GameManager();
        gm.start();
        
        // if the execution ever reaches here use a System.exit() call to ensure that code stops properly and there are not OptionPanes leaving the program running.
        System.exit(0);
    }
    
}
