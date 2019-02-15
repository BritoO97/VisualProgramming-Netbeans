
package imgManipulation;

import image.*;
import java.util.Scanner;

public class Runner {
    
    public static void main (String[] args)
    {
        APImage img = new APImage("asphalt-auto-automobile-170811.jpg");

        //greyscale(img);
        //mirrorVertical(img);
        //testBW();
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
    
    private static void testBW()
    {
        Scanner reader = new Scanner(System.in);
        APImage image = new APImage("asphalt-auto-automobile-170811.jpg");
        image.draw();
        for (Pixel p: image){
            int red = p.getRed();
            int green = p.getGreen();
            int blue = p.getBlue();
            int average = (red + green + blue) / 3;
            if (average > 127){
                p.setRed(255);
                p.setGreen(255);
                p.setBlue(255);
            }
            else{
                p.setRed(255);
                p.setGreen(0);
                p.setBlue(0);
            }                
        }
        System.out.print("Press return to continue:");
        reader.nextLine();
        image.draw();
    }
    
    private static void testBlank()
    {
        Scanner reader = new Scanner(System.in);
        APImage image = new APImage(150, 150);
        image.draw();
        int y = image.getHeight() / 2;
        for (int x = 0; x <= image.getWidth(); x++)
         image.setPixel(x, y, new Pixel(255, 0, 0));
        System.out.print("Press return to continue:");
        reader.nextLine();
        image.draw();
    }
    
    private static void mirrorVertical(APImage img)
    {
        int width = img.getWidth();
        int height = img.getHeight();
           
        for (int r = 0; r < (width / 2); r++)
        {
            for (int c = 0; c < height; c++)
            {
                Pixel p = img.getPixel(r, c);
                int red1 = p.getRed();
                int blue1 = p.getBlue();
                int green1 = p.getGreen();
                
                Pixel newP = img.getPixel(width - r - 1, c);
                int red2 = newP.getRed();
                int blue2 = newP.getBlue();
                int green2 = newP.getGreen();
                
                p.setRed(red2);
                p.setGreen(green2);
                p.setBlue(blue2);
                
                newP.setRed(red1);
                newP.setGreen(green1);
                newP.setBlue(blue1);
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
    
    private static void greyscale(APImage img)
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

                int avg = (red + green + blue) / 3;
                //System.out.println(avg);

                p.setBlue(avg);
                p.setGreen(avg);
                p.setRed(avg);

            }
        }
    }
}
