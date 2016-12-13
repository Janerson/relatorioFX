package br.com.idtech.util;

import br.com.idtech.model.entity.SenhaServico;
import br.com.idtech.model.entity.SenhasUsuario;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by DOM on 19/01/2015.
 */
public class GraficoUtil {


    public static ObservableList<PieChart.Data> getDataServico(List<SenhaServico> list) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (SenhaServico s : list) {
            data.add(new PieChart.Data(s.getServico(), s.getTotal()));
        }
        return data;
    }

    public static ObservableList<PieChart.Data> getDataUser(List<SenhasUsuario> list) {
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        for (SenhasUsuario s : list) {
            data.add(new PieChart.Data(s.getUsuario(), s.getTotal()));
        }
        return data;
    }

    public static ObservableList getXYSeriesServ(List<SenhaServico> s) {
        ObservableList<XYChart.Series> data = FXCollections.observableArrayList();

        s.forEach(se -> {
            XYChart.Series series = new XYChart.Series<>();
                series.getData().add(new XYChart.Data<>(se.getServico(), se.getTotal()));
            data.add(series);
        });

        return data;
    }

    /**
     * Calcula a % de uma <b>fração</> do valor <b>total</b>.
     *
     * @param total
     * @param fracao
     * @return
     */
    private static double percentual(int total, double fracao) {
        String str = new DecimalFormat("0.00").format((fracao / total) * 100);
        return Double.parseDouble(str.replace(",", "."));
    }

    /*BarChart CSS*/
    public static void barChartCSS(BarChart barChart) {
        /**
         * Set Series color
         */
        for (int i = 0; i < barChart.getData().size(); i++)
            for (Node node : barChart.lookupAll(".series" + i)) {
                node.getStyleClass().remove("default-color" + (i));
                node.getStyleClass().add("default-color" + (i));
            }

        /**
         * Set Legend items color
         */
        int i = 0;
        for (Node node : barChart.lookupAll(".chart-legend-item")) {
            if (node instanceof Label && ((Label) node).getGraphic() != null) {
                ((Label) node).getGraphic().getStyleClass().remove("default-color" + i);
                ((Label) node).getGraphic().getStyleClass().add("default-color" + i);
            }
            i++;
        }
    }

    /*LineChart CSS*/
    public static void lineChartCSS(LineChart lineChart) {
        /**
         * Set Series color
         */
        for (int i = 0; i < lineChart.getData().size(); i++)
            for (Node node : lineChart.lookupAll(".series" + i)) {
                node.getStyleClass().remove("default-color" + (i));
                node.getStyleClass().add("default-color" + (i));
            }


    }

    /*PierChart CSS*/
    public static void pierChartCSS(PieChart pieChart) {
        int i = 0;
        for (PieChart.Data data : pieChart.getData()) {
            data.setName(data.getName() + " : " + (int) data.getPieValue());
            data.getNode().getStyleClass().remove("default-color" + i);
            data.getNode().getStyleClass().add("default-color" + i);
            i++;
        }
    }

    public static void pierChartCSSLegendItem(PieChart pieChart) {
        int i = 0;
        for (Node node : pieChart.lookupAll(".chart-legend-item")) {
            if (node instanceof Label && ((Label) node).getGraphic() != null) {
                ((Label) node).getGraphic().getStyleClass().remove("default-color" + i);
                ((Label) node).getGraphic().getStyleClass().add("default-color" + i);
            }
            i++;
        }
    }

    /*Animation PieChart*/
    static class MouseHoverAnimation implements EventHandler<MouseEvent> {
        static final Duration ANIMATION_DURATION = new Duration(500);
        static final double ANIMATION_DISTANCE = 0.15;
        private double cos;
        private double sin;
        private PieChart chart;

        public MouseHoverAnimation(PieChart.Data d, PieChart chart) {
            this.chart = chart;
            double start = 0;
            double angle = calcAngle(d);
            for (PieChart.Data tmp : chart.getData()) {
                if (tmp == d) {
                    break;
                }
                start += calcAngle(tmp);
            }

            cos = Math.cos(Math.toRadians(0 - start - angle / 2));
            sin = Math.sin(Math.toRadians(0 - start - angle / 2));
        }

        @Override
        public void handle(MouseEvent arg0) {
            Node n = (Node) arg0.getSource();

            double minX = Double.MAX_VALUE;
            double maxX = Double.MAX_VALUE * -1;

            for (PieChart.Data d : chart.getData()) {
                minX = Math.min(minX, d.getNode().getBoundsInParent().getMinX());
                maxX = Math.max(maxX, d.getNode().getBoundsInParent().getMaxX());
            }

            double radius = maxX - minX;

            TranslateTransition tt = new TranslateTransition(ANIMATION_DURATION, n);
            tt.setToX((radius * ANIMATION_DISTANCE) * cos);
            tt.setToY((radius * ANIMATION_DISTANCE) * sin);
            tt.play();
        }

        private static double calcAngle(PieChart.Data d) {
            double total = 0;
            for (PieChart.Data tmp : d.getChart().getData()) {
                total += tmp.getPieValue();
            }

            return 360 * (d.getPieValue() / total);
        }
    }

    static class MouseExitAnimation implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {

            TranslateTransition tt = new TranslateTransition(new Duration(500), (Node) event.getSource());
            tt.setToX(0);
            tt.setToY(0);
            tt.play();
        }
    }
}
