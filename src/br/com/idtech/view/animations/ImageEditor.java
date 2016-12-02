package br.com.idtech.view.animations;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*import org.controlsfx.tools.Borders;
import org.kordamp.ikonli.Ikon;
import org.kordamp.ikonli.javafx.FontIcon;*/

public class ImageEditor {

    public static void setImageOn(ImageView imageView, String path, int fitWidth, int fitHeight) {
        imageView.setImage(new Image(path));
        imageView.setFitWidth(fitWidth);
        imageView.setFitHeight(fitHeight);
    }

    public static void setImageOn(ImageView imageView, Image image) {
        imageView.setImage(image);
    }

    public static void setRectangularClipOf(ImageView imageView, int arcWidth, int arcHeight) {
        Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip.setArcHeight(arcHeight);
        clip.setArcWidth(arcWidth);
        imageView.setClip(clip);
    }

    /**
     * Converte um byte[] em imagem
     *
     * @param img
     * @return Image
     * @throws IOException
     */
    public static Image byteToImage(byte[] img) throws IOException {
        BufferedImage bi = ImageIO.read(new ByteArrayInputStream(img));
        return SwingFXUtils.toFXImage(bi, null);
    }

    /**
     * Converte uma imagem em um array de byte
     *
     * @param image
     * @return byte[]
     */
    public static byte[] imageToByte(Image image) {
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        ByteArrayOutputStream s = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "jpg", s);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return s.toByteArray();
    }

   /*public static Node getIcon(Ikon icon){
       return new FontIcon(icon);
   }*/

}
