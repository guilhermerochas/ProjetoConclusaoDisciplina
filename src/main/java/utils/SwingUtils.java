package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingUtils {
    public static void takeScreenshot(String imageName) throws Exception {
        File dbFolder = new File("./imgs/db");

        if (!dbFolder.exists()) {
            dbFolder.mkdir();
        }

        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
        ImageIO.write(capture, "jpg", new File("./imgs/db/" + imageName + ".jpg"));
    }
}
