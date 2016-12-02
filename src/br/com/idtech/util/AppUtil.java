package br.com.idtech.util;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by DOM on 27/10/2016.
 */
public class AppUtil {

    public static boolean fieldInputNotNull(final TextField field) {
        registerTypeEvent(field);
        if (field.getText().length() <= 0) {
            field.setStyle("-fx-border-color:red;");
            return false;
        } else {
            return true;
        }
    }

    public static void TextFieldToUpperCase(final TextField txt) {
        txt.textProperty().addListener((observableValue, s, t1) -> txt.setText(t1.toUpperCase()));
    }

    private static void registerTypeEvent(final TextField field) {
        field.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() > 0) {
                field.setStyle(null);
            }
        });
    }

    /********************************************
     *                                          *
     *                Alertas                   *
     * @param msg =  mensagem do alerta         *
     * @param header = titulo do alerta         *
     ********************************************/
    public static void showAlertInformation(String msg, Object header) {
        alert(Alert.AlertType.INFORMATION, msg, header).show();
    }

    public static void showAlertWarning(String erro, Object title) {
        alert(Alert.AlertType.WARNING, erro, title).show();
    }

    private static Alert alert(Alert.AlertType type, String msg, Object header) {
        Alert alert = new Alert(type, msg);
        alert.setHeaderText(header.toString());
        return alert;
    }

    public static String getBundleMessage(String key , String bundle) {
        ResourceBundle i18nBundle = ResourceBundle.getBundle(bundle, Locale.getDefault());
        return i18nBundle.getString(key);

    }

  /*  public static void showStageOwner(Stage stage , Parent parent, EventHandler<WindowEvent> eventHandler){
        stage.setScene(new Scene(parent));
        stage.initModality(Modality.WINDOW_MODAL);
        AppBaseController.base.getRegionOverlayEffect()
                .visibleProperty().bind(stage.showingProperty());
        stage.initOwner(AppBaseController.base.getRegionOverlayEffect().getScene().getWindow());
        stage.show();
        stage.setResizable(false);
       stage.setOnCloseRequest(eventHandler);
    }*/

}
