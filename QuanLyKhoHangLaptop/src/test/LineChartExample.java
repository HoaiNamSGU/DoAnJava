package test;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class LineChartExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Line Chart Example");

        // Định nghĩa trục x và y cho biểu đồ
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X");
        yAxis.setLabel("Y");

        // Tạo biểu đồ đường
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Line Chart Example");

        // Tạo dữ liệu ngẫu nhiên
        XYChart.Series series = new XYChart.Series();
        series.setName("Random Data");
        for (int i = 0; i < 100; i++) {
            series.getData().add(new XYChart.Data(i, Math.random() * 100));
        }

        // Thêm dữ liệu vào biểu đồ
        lineChart.getData().add(series);

        // Hiển thị biểu đồ trong Scene
        Scene scene = new Scene(lineChart, 800, 600);
        primaryStage.setScene(scene);

        // Hiển thị cửa sổ chính
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
