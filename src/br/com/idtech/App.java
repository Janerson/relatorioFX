package br.com.idtech;

import br.com.idtech.util.FXMLUtil;
import br.com.idtech.util.ImageUtil;
import br.com.idtech.util.StageUtil;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Lab on 02/12/2016.
 */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
       Image ICO_IMAGE = ImageUtil.getImage("report.png");
        Parent root = FXMLUtil.getFXML("app_base");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass()
                .getResource("view/css/root_chart_style.css")
                .toExternalForm());
        StageUtil.setMinWH(1017,600,primaryStage);
        primaryStage.getIcons().addAll(ICO_IMAGE);
        primaryStage.initStyle(StageStyle.DECORATED);
     //   ScenicView.show(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest( w -> System.exit(0));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
