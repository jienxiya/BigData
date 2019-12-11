package imageprocessing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class ImageProcessing {

    BufferedImage image;
    int width;
    int height;

    public ImageProcessing() {

        try {
            File input = new File("C:\\Users\\pallerma_sd2082\\Downloads\\flower.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            for (int i = 0; i < height; i++) {

                for (int j = 0; j < width; j++) {

                    Color c = new Color(image.getRGB(j, i));

                    if (c.getRed() >= 50 || c.getGreen() >= 50 || c.getBlue() >= 50) {
                        Color newColor = new Color(255, 255, 255);
                        image.setRGB(j, i, newColor.getRGB());
                    }

                }
            }

            File ouptut = new File("C:\\Users\\pallerma_sd2082\\Downloads\\new.jpg");
            ImageIO.write(image, "jpg", ouptut);

        } catch (Exception e) {
        }
    }

    static public void main(String args[]) throws Exception {
    ImageProcessing obj = new ImageProcessing();
    }
}
