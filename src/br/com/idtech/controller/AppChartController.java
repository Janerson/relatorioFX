package br.com.idtech.controller;

import br.com.idtech.model.entity.SenhaServico;
import br.com.idtech.model.entity.SenhasUsuario;
import br.com.idtech.model.vo.SenhasServicoVO;
import br.com.idtech.model.vo.SenhasUsuarioVO;
import br.com.idtech.util.AppUtil;
import br.com.idtech.util.GraficoUtil;
import br.com.idtech.util.ReadProps;
import com.sun.javafx.tk.Toolkit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.*;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Separator;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static br.com.idtech.util.GraficoUtil.getDataServico;
import static br.com.idtech.util.GraficoUtil.getDataUser;
import static br.com.idtech.util.GraficoUtil.getXYSeriesServ;

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
    @FXML
    private ButtonBar btnbar;

    private PieChart pieChart;
    private static BarChart barChart;


    private ObservableList<SenhaServico> senhaServicos = FXCollections.observableArrayList();
    private ObservableList<SenhasUsuario> senhasUsuarios = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        adjustLayout();
        initiControl();
    }

    void initiControl() {
        cbFiltro.getItems().setAll("Serviços", "Usuários");
        cbFiltro.valueProperty().addListener((observable, oldValue, newValue) -> getDataBetween(newValue.toString()));

    }

    private void adjustLayout() {
        hbox.prefWidthProperty().bind(rootLayout.widthProperty());
        chartContent.prefWidthProperty().bind(rootLayout.widthProperty());
        chartContent.prefHeightProperty().bind(rootLayout.heightProperty().subtract(hbox.heightProperty()));
        region.prefWidthProperty().bind(rootLayout.widthProperty().subtract(398).subtract(100));
        sep.prefWidthProperty().bind(rootLayout.widthProperty());
    }


    private PieChart createPieChart(String title) {
        PieChart p = new PieChart();
        p.setAnimated(true);
        p.setClockwise(false);
        p.setTitle(title);
        p.setLegendVisible(false);
        p.setLegendSide(Side.RIGHT);
        return p;
    }

    private BarChart createBarChart(String title){
        BarChart b= new BarChart(new CategoryAxis() , new NumberAxis());
        b.setTitle(title);
        b.setAnimated(true);
        return b;
    }

    private void setChart(Node chart, ObservableList l) {
        if (l != null) {
            if (chart instanceof PieChart) {
                chartContent.getChildren().setAll(chart);
            } else if (chart instanceof BarChart) {
                    chartContent.getChildren().setAll(barChart);
            } else if (chart instanceof LineChart) {

            }
        } else {
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
                    //pieChart = createPieChart(ReadProps.lerProperties("pie_chart_senhas_servico"));
                    barChart = createBarChart(ReadProps.lerProperties("pie_chart_senhas_servico"));
                    //setChart(pieChart,senhaServicos);
                    setChart(barChart,senhaServicos);
                    //pieChart.setData(getDataServico(senhaServicos));
                    barChart.setData(getXYSeriesServ(senhaServicos));
                    //GraficoUtil.pierChartCSS(pieChart);
                    //GraficoUtil.pierChartCSSLegendItem(pieChart);
                    break;
                case "Usuários":
                    senhasUsuarios.setAll(new SenhasUsuarioVO(ini, fim).list());
                    pieChart.setTitle(ReadProps.lerProperties("pie_chart_senhas_usuario"));
                    pieChart.setData(getDataUser(senhasUsuarios));
                    GraficoUtil.pierChartCSS(pieChart);
                    GraficoUtil.pierChartCSSLegendItem(pieChart);
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
        File file = fileChooser.showSaveDialog(chartContent.getScene().getWindow());

        try {
            if (file != null) {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            }
        } catch (IOException e) {

        }
    }


}

