package br.com.idtech.util;


import javafx.scene.image.Image;

/**
 * Created by DOM on 21/10/2016.
 */
public class ImageUtil {

    private static final String PATH = "br/com/infoestoq/view/img/";

    public static final String DEFAULT_IMAGE = "avatar/Batman.png";

    public static Image getImage(String imgFile) {
        return new Image(PATH + imgFile);
    }
}
