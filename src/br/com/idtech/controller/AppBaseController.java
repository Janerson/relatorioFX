package br.com.idtech.controller;

import br.com.idtech.util.FXMLUtil;
import br.com.idtech.util.ImageUtil;
import br.com.idtech.view.animations.ImageEditor;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Lab on 02/12/2016.
 */
public class AppBaseController implements Initializable {

    public static AppBaseController base;

    @FXML
    private ImageView top, imgLogout, imgReport, imgHome;

    @FXML
    StackPane nodeRoot , content;

  /*  @FXML
    private AnchorPane content;*/

    @FXML
    private VBox menuRoot;

    @FXML
    private HBox home;

    @FXML
    private HBox report;

    @FXML
    private HBox logout;

    @FXML
    private Region veil;


    Parent parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adjustLayout();
        base = this;
        try {
            parent = FXMLUtil.getFXML("app_chart");
        } catch (IOException e) {
            e.printStackTrace();
        }
        content.getChildren().setAll(parent);
    }

    private void adjustLayout(){
        top.fitWidthProperty().bind(nodeRoot.widthProperty());
    }



    @FXML
    private void mouseIn(Event event) {
        switch (((HBox) event.getSource()).getId()) {
            case "home":
                ImageEditor.setImageOn(imgHome, ImageUtil.getImage("Pie Chart Filled-50.png"));
                break;
            case "report":
                ImageEditor.setImageOn(imgReport, ImageUtil.getImage("Ratings-hover.png"));
                break;
            case "logout":
                ImageEditor.setImageOn(imgLogout, ImageUtil.getImage("Exit-hover.png"));
                break;
        }
    }

    @FXML
    private void mouseOut(Event event) {
        switch (((HBox) event.getSource()).getId()) {
            case "home":
                ImageEditor.setImageOn(imgHome, ImageUtil.getImage("Pie Chart-50.png"));
                break;
            case "report":
                ImageEditor.setImageOn(imgReport, ImageUtil.getImage("Ratings-50.png"));
                break;
            case "logout":
                ImageEditor.setImageOn(imgLogout, ImageUtil.getImage("Exit-50.png"));
                break;
        }
    }

    //TODO - Criar evento para o click nos botoes.
    @FXML
    private void onMouseClick(Event event) throws IOException {
        switch (((HBox) event.getSource()).getId()) {
            case "home":
                parent = FXMLUtil.getFXML("app_chart");
                content.getChildren().setAll(parent);
                break;
            case "report":
                parent = FXMLUtil.getFXML("app_table");
                content.getChildren().setAll(parent);
                break;
            case "logout":
                System.exit(0);
                break;
        }
    }

    public Region getRegionOverlayEffect(){
        return veil;
    }
}
