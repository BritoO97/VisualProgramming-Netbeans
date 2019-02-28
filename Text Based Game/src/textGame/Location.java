/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textGame;

/**
 *
 * @author bruno
 */
public class Location {
    
    // room name and string description
    String name;
    String desc;
    
    // Array holding the names of the rooms to the NORTH, EAST, SOUTH and WEST. null for a lack of room
    String[] connections = new String[4];
    
    // if this room contains a key, chest or trap
    boolean hasKey = false;
    boolean hasChest = false;
    boolean hasTrap = false;

    // Contructor
    public Location(String name, String desc, boolean key, boolean chest, boolean trap, String[] connections)
    {
        this.name = name;
        this.desc = desc;
        hasKey = key;
        hasChest = chest;
        hasTrap = trap;
        this.connections = connections;
    }
    
    // get the name of the room
    public String getName()
    {
        return name;
    }
    
    // print description, followed by possible movement option and then special options
    public String printLocation()
    {
        String result = "";
        
        result += desc + "\n\n";
        if (connections[0] != null)
            result += "You can move NORTH to the " + connections[0] + "\n";
        if (connections[1] != null)
            result += "You can move EAST to the " + connections[1] + "\n";
        if (connections[2] != null)
            result += "You can move SOUTH to the " + connections[2] + "\n";
        if (connections[3] != null)
            result += "You can move WEST to the " + connections[3] + "\n";
                
        if (hasKey)
            result += "You can SEARCH this location.\n";
        if (hasChest)
            result += "You can try to OPEN the chest.\n";
        if (hasTrap)
            result += "You can LOOK under the bed.\n";
        
        return result;
    }
    
    // is it valid to move ina  certain direction (is there a room in that direction)
    public boolean valid (int dir)
    {
        return (connections[dir] != null);
    }
    
    // get the name of a room in a given direction
    public String getRoomInDir(int dir)
    {
        return connections[dir];
    }
    
}
