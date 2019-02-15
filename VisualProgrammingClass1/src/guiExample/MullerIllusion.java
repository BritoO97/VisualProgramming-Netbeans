package guiExample;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author bruno
 */
public class MullerIllusion extends JPanel{
    
    public MullerIllusion(Color c)
    {
        setBackground(c);
    }
    
    public void paintComponent(Graphics g)
    {
        int featherSize = 10;
        
        int horizDistance = 200;
        int vertDistance = 100;
        
        int startX = 100;
        int startY = 100;
        
        g.drawLine(startX, startY, startX + horizDistance, startY);
        drawLessThan(g, startX, startY, featherSize);
        drawGreaterThan(g, startX + horizDistance, startY, featherSize);
        
        g.drawLine(startX, startY + vertDistance, startX + horizDistance, startY + vertDistance);
        drawGreaterThan(g, startX, startY + vertDistance, featherSize);
        drawLessThan(g, startX + horizDistance, startY + vertDistance, featherSize);
        
    }
    
    private void drawLessThan(Graphics g, int x, int y, int size)
    {
        g.drawLine(x, y, x + size, y + size);
        g.drawLine(x, y, x + size, y - size);
    }
    
    private void drawGreaterThan(Graphics g, int x, int y, int size)
    {
        g.drawLine(x, y, x - size, y + size);
        g.drawLine(x, y, x - size, y - size);
    }
    
}
