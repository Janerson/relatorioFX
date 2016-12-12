package br.com.idtech.view.fxml;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Created by DOM on 12/12/2016.
 */
public class GetPath {

    public static Parent getFXML(String fxmlName) {
        String fxml = fxmlName.endsWith(".fxml") ? fxmlName : fxmlName.concat(".fxml");
        try {
            return FXMLLoader.load(GetPath.class.getResource(fxml));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
