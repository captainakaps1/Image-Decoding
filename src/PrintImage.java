
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.*;

public class PrintImage {
    PrintImage(int[][] imageArray) {

        PrintImage(imageArray);//print the image
    }

    public void PrintImage(int[][] imageArray) {
        int h = imageArray[0].length;
        int w = imageArray[0].length;

        Color x = Color.blue;
        int rgb;
        BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (imageArray[i][j] == 0)
                    x = Color.black;
                else if (imageArray[i][j] == 1)
                    x = Color.green;
                else if (imageArray[i][j] == 3)
                    x = Color.white;
                else if (imageArray[i][j] == 5)
                    x = Color.green;
                else if (imageArray[i][j] == 8)
                    x = Color.orange;
                rgb = x.getRGB();
                image.setRGB(j, i, rgb);
            }
        }

        JLabel lbl = new JLabel();
        lbl.setSize(w, h);
        ImageIcon ico = new ImageIcon(image);
        lbl.setIcon(ico);
        lbl.setVisible(true);
        JFrame frame = new JFrame();
        frame.setSize(w, h);
        frame.add(lbl);
        frame.setVisible(true);

        try { ImageIO.write(image, "png", new File("image.png")); }
        catch (IOException e) { e.printStackTrace(); }

    }
}
