package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BieuDoCot_Duong extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset dataset1;
	private DefaultCategoryDataset dataset2;

	public BieuDoCot_Duong() {
		dataset1 = new DefaultCategoryDataset();
		dataset2 = new DefaultCategoryDataset();

		JFreeChart chart = createChart(dataset1, dataset2);
		setLayout(new GridLayout(1, 1, 0, 0));

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(900, 700));
		add(chartPanel);
	}

	public JFreeChart createChart(DefaultCategoryDataset dataset1, DefaultCategoryDataset dataset2) {
		// Tạo biểu đồ cột
		JFreeChart chart = ChartFactory.createBarChart("Số lượng và Tổng giá trị", // Tiêu đề biểu đồ
				"Tên CH", 
				"Giá trị (triệu)",
				dataset2, // Dataset cho biểu đồ cột
				PlotOrientation.VERTICAL, 
				true, //  chú thích
				true, // tiêu đề
				false // Không hiển thị URL
		);

		// Lấy plot từ biểu đồ
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		

		plot.setBackgroundPaint(Color.WHITE);
		// Thiết lập màu của các đường grid trên trục x là màu đen
		plot.setDomainGridlinePaint(Color.BLACK);
		// Thiết lập màu của các đường grid trên trục y là màu đen
		plot.setRangeGridlinePaint(Color.BLACK);


		CategoryAxis domainAxis = plot.getDomainAxis();
		// Thiết lập vị trí của nhãn trên trục x là 45 độ
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		// Thiết lập font cho nhãn trên trục x
		domainAxis.setTickLabelFont(new Font("Arial", Font.BOLD, 20));

		// Lấy trục y từ plot
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		// Thiết lập font cho các nhãn trên trục y
		rangeAxis.setTickLabelFont(new Font("Arial", Font.BOLD, 20));
		// Thiết lập font cho nhãn của trục y
		rangeAxis.setLabelFont(new Font("Arial", Font.BOLD, 20));

		BarRenderer renderer2 = new BarRenderer();

		renderer2.setSeriesPaint(0, Color.RED); // Màu xanh cho cột số lượng
		renderer2.setMaximumBarWidth(0.1);
		plot.setRenderer(1, renderer2);

		// Ánh xạ dataset2 vào trục y thứ hai và cập nhật biểu đồ đường
		plot.setDataset(1, dataset1);
		plot.mapDatasetToRangeAxis(1, 1);

		// Thêm trục y thứ hai
		// Tạo trục y thứ hai
		NumberAxis yAxis2 = new NumberAxis("Tổng số lượng (chiếc)");

		// Tăng kích thước chữ cho nhãn và dấu gạch trên trục
		Font font = new Font("Arial", Font.BOLD, 20); // Thay đổi kích thước và kiểu chữ tại đây
		yAxis2.setTickLabelFont(font);
		yAxis2.setLabelFont(font);

		// Đặt trục y thứ hai vào biểu đồ
		plot.setRangeAxis(1, yAxis2);

		
		// Tạo renderer cho biểu đồ đường
		LineAndShapeRenderer lineRenderer = new LineAndShapeRenderer();
		lineRenderer.setSeriesPaint(0, Color.BLUE); // Màu xanh lá cho đường
		// Hiển thị hình dạng của các điểm trên đường
		lineRenderer.setSeriesShapesVisible(0, true); // Thay đổi giá trị boolean thành true hoặc false để ẩn hoặc hiện
		lineRenderer.setSeriesLinesVisible(0, true); // Hiển thị đường
		plot.setRenderer(0, lineRenderer);

		// Trả về biểu đồ đã tạo
		return chart;
	}

	

	public void Update(String CongViec, String loai, ArrayList<String> day, String dateFormatStr) {
		try {
			dataset1 = view.BieuDoDuong_Duong.setData(CongViec, "Số lượng", loai, day, dateFormatStr);
			dataset2 = view.BieuDoDuong_Duong.setData(CongViec, "Giá trị", loai, day, dateFormatStr);
			removeAll();
			JFreeChart chart = createChart(dataset1, dataset2);
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new java.awt.Dimension(900, 700));
			add(chartPanel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
