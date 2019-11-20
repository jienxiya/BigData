/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageProcessing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author pallerma_sd2082
 */
public class ImageProcessing1 {

    BufferedImage image;

    int width;
    int height;

    public ImageProcessing1() {

        try {
            File input = new File("C:\\Users\\pallerma_sd2082\\Downloads\\flower..jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            for (int i = 0; i < height; i++) {

               for (int j = 0; j < width; j++) {

                   Color c = new Color(image.getRGB(j, i));

                   Color black = new Color(0, 0, 0);
                   Color newColor =new Color(255,255,255);
                   int white = 15;
                   
                   if(c.getRGB()== black.getRGB() || (c.getBlue()<white && c.getGreen()<white && c.getRed()<white)){
                       
                   }
                   else{
                       image.setRGB(j, i,newColor.getRGB());
                   }
               }
           }

            File ouptut = new File("C:\\Users\\pallerma_sd2082\\Downloads\\white.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {
        }
    }

    static public void main(String args[]) throws Exception {
        ImageProcessing1 obj = new ImageProcessing1();
    }
}
