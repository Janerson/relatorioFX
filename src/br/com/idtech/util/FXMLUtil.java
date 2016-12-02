package br.com.idtech.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Lab on 13/10/2016.
 */
public class FXMLUtil {

    public static URL getFXMLS(String fxmlName) {
        String fxml = fxmlName.endsWith(".fxml") ? fxmlName : fxmlName.concat(".fxml");
        return FXMLUtil.class.getResource("../view/fxml/" + fxml);
    }

    /**
     * Load fxml com default ResourceBundle(ResourceBundle = info) e default Locale
     * @param fxml
     * @return
     * @throws IOException
     */
    public static Parent getFXML(String fxml) throws IOException {

        return getFXML(fxml,null);


    }

    /**
     *
     * @param fxml
     * @param resourceBundle
     * @return
     * @throws IOException
     */
    public static Parent getFXML(String fxml , ResourceBundle resourceBundle) throws IOException {



        return FXMLLoader.load(getFXMLS(fxml), resourceBundle);
    }

}
