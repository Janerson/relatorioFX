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


    private Stage stage;
    private Stage owner;
    private Stage back;
    private Parent url;
    private Effect effect;
    private StageStyle stageStyle;
    private double positionX, positionY;
    private Service service;

    public StageUtil() {
        this.effect = null;
        this.owner = null;
        this.stage = new Stage();
        this.stageStyle = StageStyle.UNDECORATED;
        this.url = null;
    }

    public StageUtil withtStage(Stage stage) {
        this.stage = stage;
        return this;
    }

    public StageUtil withOwner(Stage owner) {
        this.owner = owner;
        return this;
    }

    public StageUtil setBack(Stage back) {
        this.back = back;
        return this;
    }

    public StageUtil withUrl(Parent url) {
        this.url = url;
        return this;
    }

    public StageUtil withEffect(Effect effect) {
        this.effect = effect;
        return this;
    }

    public StageUtil withStageStyle(StageStyle stageStyle) {
        this.stageStyle = stageStyle;
        return this;
    }

    public StageUtil withService(Service<?> service) {
        this.service = service;
        return this;
    }


    public void show() throws IOException {
        Parent root = null;
        if (url != null) {
            root = url;
        }
        Scene scene = new Scene(root);
        if (stageStyle != null) {
            stage.initStyle(stageStyle);
            scene.setFill(null);
        } else {
            stage.initStyle(stageStyle);
        }
        if (owner != null) {
            owner.getScene().getRoot().setEffect(effect);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(owner);
            stage.setOnCloseRequest(r -> owner.getScene().getRoot().setEffect(null));
        }

        //Mapped Key Event set
       // scene.setOnKeyPressed(new MappedKeyEvent());
        stage.setScene(scene);


        if (service != null) {
            service.setOnSucceeded(w -> stage.close());
        }

      /*  root.setOnMousePressed(m -> {
            positionX = m.getSceneX();
            positionY = m.getSceneY();
        });

        root.setOnMouseDragged(m -> {
            stage.setX(m.getScreenX() - positionX);
            stage.setY(m.getScreenY() - positionY);
        });*/
        if (back != null) back.close();
        stage.show();

    }

    public Stage getStage() {
        return stage;
    }


    public static void setMinWH(double width, double height, Stage stage) {
        stage.setMinHeight(height);
        stage.setMinWidth(width);
    }

    public static void setMaXWH(double width, double height, Stage stage) {
        stage.setMaxHeight(height);
        stage.setMaxWidth(width);
    }

}
