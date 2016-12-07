package br.com.idtech.controller;

import br.com.idtech.model.entity.SenhaServico;
import br.com.idtech.model.entity.SenhasUsuario;
import br.com.idtech.model.vo.SenhasServicoVO;
import br.com.idtech.model.vo.SenhasUsuarioVO;
import br.com.idtech.util.AppUtil;
import br.com.idtech.util.GraficoUtil;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Lab on 06/12/2016.
 */
public class AppChartController implements Initializable {

    @FXML
    private StackPane chartContent;
    @FXML
    private DatePicker dtIni, dtFim;
    @FXML
    private VBox rootLayout;
    @FXML
    private HBox hbox;
    @FXML
    private ComboBox cbFiltro;
    @FXML
    private Region region;
    @FXML
    GridPane gridPane;
    @FXML
    private Separator sep;

    private static BarChart barChart;
    private static LineChart lineChart;
    private PieChart pieChart;


    private ObservableList<SenhaServico> senhaServicos = FXCollections.observableArrayList();
    private ObservableList<SenhasUsuario> senhasUsuarios = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adjustLayout();
        initiControl();
    }
    void initiControl(){
        cbFiltro.getItems().setAll("Serviços" , "Usuários");
        cbFiltro.valueProperty().addListener((observable, oldValue, newValue) -> getDataBetween(newValue.toString()));

    }

    private void adjustLayout() {
        hbox.prefWidthProperty().bind(rootLayout.widthProperty());
        chartContent.prefWidthProperty().bind(rootLayout.widthProperty());
        chartContent.prefHeightProperty().bind(rootLayout.heightProperty().subtract(hbox.heightProperty()));
        region.prefWidthProperty().bind(rootLayout.heightProperty());
        sep.prefWidthProperty().bind(rootLayout.widthProperty());
    }

    private ObservableList<PieChart.Data> getDataServico(List<SenhaServico> list) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (SenhaServico s : list) {
            data.add(new PieChart.Data(s.getServico(), s.getTotal()));
        }
        return data;
    }

    private ObservableList<PieChart.Data> getDataUser(List<SenhasUsuario> list) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (SenhasUsuario s : list) {
            data.add(new PieChart.Data(s.getUsuario(), s.getTotal()));
        }
        return data;
    }


    private PieChart createPieChart(String title) {
        PieChart p = new PieChart();
        p.setAnimated(true);
        p.setClockwise(false);
        p.setTitle(title);
        p.setLegendSide(Side.RIGHT);
        GraficoUtil.pierChartCSS(p);
        GraficoUtil.pierChartCSSLegendItem(p);
        return p;
    }

    private void setChart(Node chart , ObservableList l){
        if(l!=null){
            if(chart instanceof PieChart ){
                chartContent.getChildren().setAll(chart);
            }else if( chart instanceof BarChart){

            }else if(chart instanceof LineChart){

            }
        }else{
            chartContent.getChildren().setAll(new Text("Não há dados a serem exibidos"));
        }
    }


    private void getDataBetween(String filtro) {
        if (validateField()) {

            String ini = dtIni.getValue().format(DateTimeFormatter.ISO_DATE);
            String fim = dtFim.getValue().format(DateTimeFormatter.ISO_DATE);
            switch (filtro) {
                case "Serviços":
                    senhaServicos.setAll(new SenhasServicoVO(ini, fim).list());
                    pieChart = createPieChart("Senhas x Serviços");
                    setChart(pieChart,senhaServicos);
                    pieChart.setData(getDataServico(senhaServicos));
                    break;
                case "Usuários":
                    senhasUsuarios.setAll(new SenhasUsuarioVO(ini, fim).list());
                    pieChart = createPieChart("Senhas x Usuarios");
                    setChart(pieChart,senhasUsuarios);
                    pieChart.setData(getDataUser(senhasUsuarios));
                    break;
            }
        }
    }

    private boolean validateField() {
        return AppUtil.fieldInputNotNull(dtIni)
                & AppUtil.fieldInputNotNull(dtFim);
    }

    @FXML
    private void saveAsImage() {

        WritableImage image = chartContent.snapshot(new SnapshotParameters(), null);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("IMAGE files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(null);

        try {
            if (file != null) {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            }
        } catch (IOException e) {

        }
    }



}

