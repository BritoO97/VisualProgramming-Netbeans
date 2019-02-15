import image.*;
import java.util.Scanner;

public class Runner {
    
    public static void main (String[] args)
    {
        APImage original = new APImage("asphalt-auto-automobile-170811.jpg");
        APImage img = new APImage("asphalt-auto-automobile-170811.jpg");

        original.draw();
        
        invert(img);
        expand(img);

        img.draw();
    }
    
    private static void expand(APImage img)
    {
        int width = img.getWidth();
        int height = img.getHeight();
        
        Pixel[][] oldPix = new Pixel[width][height];
        
        for (int r = 0; r < width; r++)
        {
            for (int c = 0; c < height; c++)
            {
                oldPix[r][c] = img.getPixel(r, c);
            }
        }
        
        for (int r = 0; r < width; r++)
        {
            for (int c = 0; c < height; c++)
            {
                Pixel p = oldPix[r/2][c/2];
                
                img.setPixel(r, c, p);
            }
        }
    }
   
    private static void invert(APImage img)
    {
        int width = img.getWidth();
        int height = img.getHeight();
           
        for ( int r = 0; r< width; r++)
        {
            for (int c = 0; c< height; c++)
            {
                Pixel p = img.getPixel(r, c);
                int red = p.getRed();
                int blue = p.getBlue();
                int green = p.getGreen();

                //int avg = (red + green + blue) / 3;
                //System.out.println(avg);

                p.setBlue(255 -blue);
                p.setGreen(255 - green);
                p.setRed(255 - red);

            }
        }
    }
}
