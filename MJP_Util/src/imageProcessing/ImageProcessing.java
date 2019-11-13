package imageprocessing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageProcessing {

   BufferedImage  image;
   
   int width;
   int height;
   
   public ImageProcessing() {
   
      try {
         File input = new File("C:\\Users\\pallerma_sd2082\\Downloads\\flower..jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         
         for(int i=0; i<height; i++) {
         
            for(int j=0; j<width; j++) {
            
               Color c = new Color(image.getRGB(j, i));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
//               Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
              
               Color newColor = new Color(0,0,0);
               image.setRGB(j,i,newColor.getRGB());
            }
         }
         
         File ouptut = new File("C:\\Users\\pallerma_sd2082\\Downloads\\black.jpg");
         ImageIO.write(image, "jpg", ouptut);
         
      } catch (Exception e) {}
   }
   
   static public void main(String args[]) throws Exception {
      ImageProcessing obj = new ImageProcessing();
   }
}
    

