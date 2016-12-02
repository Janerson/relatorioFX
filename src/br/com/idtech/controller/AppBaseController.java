package br.com.idtech.controller;

import br.com.idtech.util.ImageUtil;
import br.com.idtech.view.animations.ImageEditor;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Lab on 02/12/2016.
 */
public class AppBaseController implements Initializable {

    @FXML
    private ImageView top, imgLogout, imgReport, imgHome;

    @FXML
    private BorderPane content;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adjustLayout();

    }

    private void adjustLayout(){
        top.fitWidthProperty().bind(content.widthProperty());
    }

    @FXML
    private void mouseIn(Event event) {
        switch (((HBox) event.getSource()).getId()) {
            case "home":
                ImageEditor.setImageOn(imgHome, ImageUtil.getImage("Home-hover.png"));
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
                ImageEditor.setImageOn(imgHome, ImageUtil.getImage("Home-50.png"));
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
    private void onMouseClick(Event event){
        switch (((HBox) event.getSource()).getId()) {
            case "home":
                System.out.println("Click on home");
                break;
            case "report":
                System.out.println("Click on report");
                break;
            case "logout":
                System.exit(0);
                break;
        }
    }
}
