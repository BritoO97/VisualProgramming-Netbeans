/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textGame;

import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class GameManager {
    
    // An array holding the data for all the rooms and a var holding a reference to the current room the player is in
    Location[] rooms = new Location[9];
    Location currentRoom;
    
    // The opening message of the game
    String opening = "You wake up on a rickety wooden bridge\nYou do not remember how you got here. Or what you name is...\n"
            + "Or anything really...\nSomehow you know that you need to find something in the building before you...";
    
    // variable refering to if the game should be reset for another go (used when the player types NEW)    
    boolean again = true;
    
    // if the player has found the key and the chest
    boolean foundKey;
    boolean foundTreasure;
        
    // constructur - initialized the room data
    public GameManager()
    {
        createRooms();
    }
    
    // game start - performs new game setup and starts the game loop
    public void start()
    {
        do{
            newGameSetup();
            gameLoop();
        }
        while(again);
        // if the above is true the playyer has requested a NEW game and so all variables should be reset (newPlayerSetup) and the loop restarted
        
    }
    
    // Main Game loop
    private void gameLoop()
    {
        // Opening messages
        JOptionPane.showMessageDialog(null, "Instructions:\nWords in CAPS are sommands that you can use.\nUse QUIT to end the game and NEW to start fresh.");
        JOptionPane.showMessageDialog(null, opening);
        
        // holds the player command
        String answer = "";
        
        // Actual loop. Infitine until manualy broken out from (using QUIT, NEW or finishing the game)
        while(true)
        {
            // show options to player, wait for input
            answer = JOptionPane.showInputDialog(null, currentRoom.printLocation(), currentRoom.getName(), JOptionPane.PLAIN_MESSAGE);
            
            // Debug statement
            //System.out.println(answer);
            
            /*
            
                What follows are a series of if condition to figure out which logic to run based on the player input
            
            */
            
            
            // no answer or cancel buttton - iterate again without changing anything
            if (answer == null)
                continue;
            
            // QUIT - exit game immediately
            if (answer.equals("QUIT"))
                System.exit(0);
            
            // NEW - set the again flag and break out of loop
            else if (answer.equals("NEW"))
            {
                again = true;
                break;
            }
            
            // One fo the direction - check validity and move as appropriate
            
            if (answer.equals("NORTH") && currentRoom.valid(0))
                currentRoom = findRoom(currentRoom.getRoomInDir(0));
            else if (answer.equals("EAST") && currentRoom.valid(1))
                currentRoom = findRoom(currentRoom.getRoomInDir(1));
            else if (answer.equals("SOUTH") && currentRoom.valid(2))
                currentRoom = findRoom(currentRoom.getRoomInDir(2));
            else if (answer.equals("WEST") && currentRoom.valid(3))
                currentRoom = findRoom(currentRoom.getRoomInDir(3));

            // SEARCH options - first time search, subsequest search | also check that you are in the proper room
            if (answer.equals("SEARCH") && currentRoom.getName().equals("Stables") && !foundKey)
            {
                foundKey = true;
                JOptionPane.showMessageDialog(null, "While searching you come accross a mysterious key.");
            }
            else if (answer.equals("SEARCH") && currentRoom.getName().equals("Stables") && foundKey)
            {
                JOptionPane.showMessageDialog(null, "You did not find anything new.");
            }
            
            // OPEN options - first time open, subsequest open | also check that you are in the proper room | checks yyou have the key as well
            if (answer.equals("OPEN") && currentRoom.getName().equals("Staircase") && foundKey && !foundTreasure)
            {
                foundTreasure = true;
                JOptionPane.showMessageDialog(null, "You open the chest.\nInside is an item that is both beautiful and undescribable.\nYou know this is what you came for.");
            }
            else if (answer.equals("OPEN") && currentRoom.getName().equals("Staircase") && !foundKey)
            {
                JOptionPane.showMessageDialog(null, "The chest is locked tight.");
            }
            else if (answer.equals("OPEN") && currentRoom.getName().equals("Staircase") && foundKey && foundTreasure)
            {
                JOptionPane.showMessageDialog(null, "There is nothign else to take.");
            }
            
            
            // LOOK option - single case
            if (answer.equals("LOOK") && currentRoom.getName().equals("Bedroom"))
            {
                JOptionPane.showMessageDialog(null, "As you walk closer to the bed arrows shoot out of the celling.\nMaybe you should leave it alone.");
            }
            
            // Return to start with treasure (which implies also with key)
            if (currentRoom.getName().equals("Bridge") && foundTreasure == true)
                break;
        }
        
        // a last double check if the player has treasure since there is a break statement where he does not (NEW)
        if (foundTreasure)
        {   
            // final message
            JOptionPane.showMessageDialog(null, "As you walk closer to the bridge the item in your pocket grows heavier and heavier.\nYou feel a hit to the back of the head and fall down.\n"
                    + "A voice says:\n\t\"Another one who tought he could take my treasure... I'll take it back\"\nYou feel a hand going through your pockets, grabbing the item and the key.\n"
                    + "Your eyes feel heavy and you once more slip into darkness.\n\n\tTHE END");
        }       
    }
    
    
    // helper function - search array for room given a name
    private Location findRoom(String name)
    {
        for (int i = 0; i < rooms.length; i++)
        {
            if (name.equals(rooms[i].getName()))
                return rooms[i];
        }
        
        return null;
    }
 
    // innitialize variable to correct values, also reset on a NEW game
    private void newGameSetup()
    {
        currentRoom = rooms[0];
        
        again = false;
                
        foundKey = false;
        foundTreasure = false;
    }
    
    // creates all of the room data. There are 9 rooms
    private void createRooms()
    {     
        rooms[0] = new Location("Bridge", 
                                "This is the bridge. In front of you is an open Yard.\nBehind you, nothing but fog.", 
                                false, 
                                false, 
                                false, 
                                new String[] {"Yard", null, null, null}
                                );
        rooms[1] = new Location("Yard", 
                                "The Yard of a once magnificent mansion.\nRefuse is strewn about and decay is everywhere.", 
                                false, 
                                false, 
                                false, 
                                new String[] {"Entrance", "Stables", "Bridge", "Kitchens"}
                                );
        
        rooms[2] = new Location("Stables", 
                                "These Stables once held magnificent animals.\nNow all they hold are piles of dirt.\nYou think you see something in the corner.", 
                                true, 
                                false, 
                                false, 
                                new String[] {null, null, null, "Yard"}
                                );
        rooms[3] = new Location("Kitchens", 
                                "These Kitchens once provided sustenance to the family that lived here.\nNow it provides sustenance to the rats that crowd these halls.", 
                                false, 
                                false, 
                                false, 
                                new String[] {"Dinning Room", "Yard", null, null}
                                );
        rooms[4] = new Location("Entrance", 
                                "The Entrance to the mansion. Nothing remarkable about it.", 
                                false, 
                                false, 
                                false, 
                                new String[] {"Staircase", "Hallway", "Yard", "Dinning Room"}
                                );
        rooms[5] = new Location("Dinning Room", 
                                "The Dinnign Room of the mansion.\nWhile the table is intact, the chairs have long since rotted away.", 
                                false, 
                                false, 
                                false, 
                                new String[] {null, "Entrance", "Kitchens", null}
                                );
        rooms[6] = new Location("Staircase", 
                                "The Staircase is supposed to lead to the upper floors.\nThe debris covering it tell you that such a feat will be impossibble at the moment.\nThere seems to be something under all that rubble", 
                                false, 
                                true, 
                                false, 
                                new String[] {null, null, "Entrance", "Dinning Room"}
                                );
        rooms[7] = new Location("Hallway", 
                                "A rather long hallway. Far too long in fact\nInteresting", 
                                false, 
                                false, 
                                false, 
                                new String[] {"Bedroom", null, null, "Entrance"}
                                );
        rooms[8] = new Location("Bedroom", 
                                "A Bedroom... On the first floor...\nYou see something glinting under the bed.", 
                                false, 
                                false, 
                                true, 
                                new String[] {null, null, "Hallway", null}
                                );
    }
}
