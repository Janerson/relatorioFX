package br.com.idtech.util;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by DOM on 21/10/2016.
 */
public class ImageUtil {

    private static final String PATH = "br/com/idtech/view/img/";

    public static Image getImage(String imgFile) {
        return new Image(PATH + imgFile);
    }

    public static byte[] imageToByte(Image image) {
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "png", s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s.toByteArray();
    }



}
