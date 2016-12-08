package br.com.idtech.util;

import javafx.concurrent.Service;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Effect;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by Lab on 20/10/2016.
 */
public class StageUtil {

    public static void setMinWH(double width, double height, Stage stage) {
        stage.setMinHeight(height);
        stage.setMinWidth(width);
    }

    public static void setMaXWH(double width, double height, Stage stage) {
        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
    }

}
