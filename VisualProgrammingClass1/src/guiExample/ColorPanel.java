package guiExample;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author bruno
 */
public class ColorPanel extends JPanel{
    
    public ColorPanel(Color c)
    {
        setBackground(c);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawRect(10, 5, 120, 20);
        g.fillOval(40, 40, 50, 70);
        g.drawLine(100, 100, 150, 50);
        
        // head and body
        g.drawOval(225, 50, 50, 50);
        g.drawRect(230, 100, 40, 65);
        
        // legs
        g.drawLine(235, 165, 220, 250);
        g.drawLine(265, 165, 280, 250);
        
        // arms
        g.drawLine(230, 105, 175, 140);
        g.drawLine(270, 105, 325, 140);
        
        // face
        g.drawOval(235, 65, 10, 10);
        g.drawOval(255, 65, 10, 10);
        g.drawLine(250, 75, 245, 85);
        g.drawLine(245, 85, 255, 85);
        g.drawArc(242, 88, 16, 5, 195, 165);
        
    }
    
}
