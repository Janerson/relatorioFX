package br.com.idtech.controller;

import br.com.idtech.model.entity.SenhaServico;
import br.com.idtech.model.entity.SenhasUsuario;
import br.com.idtech.model.vo.SenhasServicoVO;
import br.com.idtech.model.vo.SenhasUsuarioVO;
import br.com.idtech.util.AppUtil;
import br.com.idtech.util.ReadProps;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * Created by DOM on 08/12/2016.
 */
public class AppTableController implements Initializable {
    @FXML
    private VBox rootContainner;

    @FXML
    private HBox hbox;

    @FXML
    private Text txtServ, txtUser;

    @FXML
    private DatePicker dtIni;

    @FXML
    private DatePicker dtFim;

    @FXML
    private Region region, left,right;


    @FXML
    private BorderPane bordePane;
    @FXML
    private AnchorPane anchor;

    @FXML
    private TableView<SenhaServico> tbServ;
    @FXML
    private TableView<SenhasUsuario> tbUsers;

    @FXML
    private TableColumn<SenhaServico, String> colServ;
    @FXML
    private TableColumn<SenhaServico, Integer> colServQtd;
    @FXML
    private TableColumn<SenhasUsuario, String> colUser;
    @FXML
    private TableColumn<SenhasUsuario, Integer> colUserQtd;


    private ObservableList<SenhaServico> senhaServicos = FXCollections.observableArrayList();
    private ObservableList<SenhasUsuario> senhasUsuarios = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adjustLayout();
        initControl();
    }

    private void initControl() {
        txtServ.setText(ReadProps.lerProperties("pie_chart_senhas_servico"));
        txtUser.setText(ReadProps.lerProperties("pie_chart_senhas_usuario"));

        colServ.setCellValueFactory(s -> s.getValue().servicoProperty());
        colServQtd.setCellValueFactory(new PropertyValueFactory<>("total"));

        colUser.setCellValueFactory(u -> u.getValue().usuarioProperty());
        colUserQtd.setCellValueFactory(new PropertyValueFactory<>("total"));

        tbServ.setItems(senhaServicos);
        tbUsers.setItems(senhasUsuarios);



    }

    private void adjustLayout() {
        hbox.prefWidthProperty().bind(rootContainner.widthProperty());
        bordePane.prefWidthProperty().bind(rootContainner.widthProperty());
        bordePane.prefHeightProperty().bind(rootContainner.heightProperty().subtract(hbox.heightProperty()));
        region.prefWidthProperty().bind(rootContainner.widthProperty().subtract(398).subtract(100));
    }

    @FXML
    private void getDataBetween() {
        if (validateField()) {
            String ini = dtIni.getValue().format(DateTimeFormatter.ISO_DATE);
            String fim = dtFim.getValue().format(DateTimeFormatter.ISO_DATE);
            senhaServicos.addAll(new SenhasServicoVO(ini, fim).list());
            senhasUsuarios.addAll(new SenhasUsuarioVO(ini, fim).list());
        }
    }

    private boolean validateField() {
        return AppUtil.fieldInputNotNull(dtIni)
                & AppUtil.fieldInputNotNull(dtFim);
    }

}
