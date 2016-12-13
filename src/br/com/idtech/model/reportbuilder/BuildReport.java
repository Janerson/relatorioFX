package br.com.idtech.model.reportbuilder;

import br.com.idtech.util.ImageUtil;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by DOM on 06/02/2015.
 * Email - douglas.janerson@gmail.com
 */
public class BuildReport {

    private static final Image ICO_IMAGE = ImageUtil.getImage("report.png");
    private InputStream is;
    private Map<String, Object> param;
    private JRBeanCollectionDataSource dataSource;
    private Connection connection;
    private JasperPrint jasperPrint;

    public BuildReport() {
    }

    /**
     * Tipo de Relatório
     *
     * @param report
     * @return this
     */
    public BuildReport withReport(FileInputStream report) {
        this.is = report;
        return this;
    }

    public BuildReport withReport(InputStream report) {
        this.is = report;

        return this;
    }

    public BuildReport withReport(String report) {
        try {
            this.is = new FileInputStream(report);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }

    public BuildReport withReport(File report) {
        try {
            this.is = new FileInputStream(report);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }

    /***
     * Define os Parametros
     * @param param
     * @return this
     */
    public BuildReport withParam(Map<String, Object> param) {
        this.param = param;
        return this;
    }

    /**
     * Fonte dados do Relatório
     * Caso não precise de uma Connection
     *
     * @param data
     * @return this
     */
    public BuildReport withDataSource(List data) {
        dataSource = new JRBeanCollectionDataSource(data);
        return this;
    }

    /**
     * Use se nao houver uma fonte de dados(Datasource) para o Relatório.
     * Usado quando os dados são preenchido com consultas SQL´s
     *
     * @param connection
     * @return this
     */
    public BuildReport withConnection(Connection connection) {
        this.connection = connection;
        return this;
    }

    /**
     * Cria o Relatório para ser impresso.
     *
     * @return this
     */
    public BuildReport buildReport() {
        Optional<JRBeanCollectionDataSource> dataSourceOptional = Optional.ofNullable(dataSource);
        Optional<Connection> connectionOptional = Optional.ofNullable(connection);

        Task t = new Task() {
            @Override
            protected Object call() throws Exception {
                try {
                    if (dataSourceOptional.isPresent()) {
                        jasperPrint = JasperFillManager.fillReport(is, param, dataSource);
                    } else if (connectionOptional.isPresent()) {
                        jasperPrint = JasperFillManager.fillReport(is, param, connection);
                    }
                } catch (JRException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        new Thread(t).start();


        return this;
    }


    /**
     * Imprime o Relatório na tela para o usuário
     */
    public void print() {
        Stage stage = new Stage();
        JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(createSwingNode(jasperViewer));
        Scene scene = new Scene(borderPane, 930, 700);
        stage.setScene(scene);
        stage.getIcons().addAll(ICO_IMAGE);
        stage.setTitle("Visualizar Impressão");
        stage.setResizable(false);
        stage.show();

      /*  Task worker = new Task() {
            @Override
            protected Object call() throws Exception {
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

        worker.setOnSucceeded(w -> stage.show());
        Thread th = new Thread(worker);
        th.setDaemon(true);
        th.start();
*/
    }

    /**
     * Encapsula o JasperViewer dentro do SwingNode, para que o mesmo possa ser utilizado
     * dentro de aplicações JavaFX.
     *
     * @param jasperViewer
     * @return SwingNode
     */
    private SwingNode createSwingNode(JasperViewer jasperViewer) {
        SwingNode swingNode = new SwingNode();
        SwingUtilities.invokeLater(() -> swingNode.setContent((JComponent) jasperViewer.getContentPane()));
        return swingNode;
    }

}

