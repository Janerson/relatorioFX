package br.com.idtech.controller;

import br.com.idtech.model.entity.SenhaServico;
import br.com.idtech.model.entity.SenhasUsuario;
import br.com.idtech.model.reportbuilder.BuildReport;
import br.com.idtech.model.reportbuilder.Report;
import br.com.idtech.model.vo.SenhasServicoVO;
import br.com.idtech.model.vo.SenhasUsuarioVO;
import br.com.idtech.util.AppUtil;
import br.com.idtech.util.ExportExcel;
import br.com.idtech.util.HibernateUtil;
import br.com.idtech.util.ReadProps;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import org.controlsfx.dialog.ProgressDialog;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
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
    private Region region, left, right;


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

    @FXML
    private void print() throws FileNotFoundException {
        if (validateField()) {
            String ini = dtIni.getValue().format(DateTimeFormatter.ISO_DATE);
            String fim = dtFim.getValue().format(DateTimeFormatter.ISO_DATE);

            Map<String, Object> param = new HashMap<>();

            param.put("data_ini", ini);
            param.put("data_fim", fim);
            param.put("top_image", new Report("topo.png").getRelJasper());

            final BuildReport b = new BuildReport();
            showReport(b,param);
        }
    }

    @FXML
    private void toExcel(){
        if (validateField()) {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("EXCEL file (*.xls)", "*.xls");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(bordePane.getScene().getWindow());
            AppBaseController.base.getRegionOverlayEffect().setVisible(true);
            Task worker = new Task() {
                @Override
                protected Object call() throws Exception {
                    new ExportExcel()
                            .withFileOutput(file)
                            .withSheet("Serviços", "Usuários")
                            .withDataServ(senhaServicos, 0)
                            .withDataUser(senhasUsuarios, 1)
                            .export();

                    updateMessage("Aguarde...");
                    for (int i = 1; i <= 100; i++) {
                        updateProgress(i, 100);
                        Thread.sleep(50);
                    }
                    return null;
                }
            };
            ProgressDialog dlg = new ProgressDialog(worker);
            dlg.setTitle("RELATÓRIO");
            dlg.setHeaderText("POR FAVOR AGUARDE...");
            dlg.initStyle(StageStyle.UTILITY);
            dlg.show();

            worker.setOnSucceeded(w -> AppBaseController.base.getRegionOverlayEffect().setVisible(false));
            Thread th = new Thread(worker);
            th.setDaemon(true);
            th.start();
        }
    }
    private void showReport(final BuildReport b, Map m ){
        Task worker = new Task() {
            @Override
            protected Object call() throws Exception {
                AppBaseController.base.getRegionOverlayEffect().setVisible(true);
                b.withReport(new Report("report_between.jasper").getRelJasper())
                        .withParam(m)
                        .withConnection(HibernateUtil.getConnection())
                        .buildReport();

                updateMessage("Aguarde...");
                for (int i = 1; i <= 100; i++) {
                    updateProgress(i, 100);
                    Thread.sleep(50);
                }
                return null;
            }
        };

        ProgressDialog dlg = new ProgressDialog(worker);
        dlg.setTitle("RELATÓRIO");
        dlg.setHeaderText("POR FAVOR AGUARDE...");
        dlg.initStyle(StageStyle.UTILITY);
        dlg.show();

        worker.setOnSucceeded(w -> {
            b.print();
            AppBaseController.base.getRegionOverlayEffect().setVisible(false);
        });

        Thread th = new Thread(worker);
        th.setDaemon(true);
        th.start();
    }


    private boolean validateField() {
        return AppUtil.fieldInputNotNull(dtIni)
                & AppUtil.fieldInputNotNull(dtFim);
    }

}
