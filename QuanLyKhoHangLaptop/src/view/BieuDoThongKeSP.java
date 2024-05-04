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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.PhieuNhapDao;
import dao.PhieuXuatDao;

public class BieuDoThongKeSP extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset dataset2;
	private DefaultCategoryDataset dataset1;

	public BieuDoThongKeSP() {
		// Tạo bộ dữ liệu mẫu cho biểu đồ
		dataset1 = new DefaultCategoryDataset();
		dataset2 = new DefaultCategoryDataset();

		// Tạo biểu đồ đường từ bộ dữ liệu
		JFreeChart chart = createChart(dataset1, dataset2);
		setLayout(new GridLayout(1, 1, 0, 0));

		// Tạo một panel chứa biểu đồ
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setMaximumDrawWidth(2050);
		chartPanel.setMaximumDrawHeight(1600);
		chartPanel.setPreferredSize(new java.awt.Dimension(900, 700)); // Đặt kích thước của biểu đồ
		add(chartPanel); // Thêm biểu đồ vào panel
	}

	public JFreeChart createChart(DefaultCategoryDataset dataset1, DefaultCategoryDataset dataset2) {
	    JFreeChart chart = ChartFactory.createLineChart("Số lượng và Tổng giá trị", // Tiêu đề biểu đồ
	            "Thời gian", // Nhãn trục x
	            "Giá Trị (triệu)", // Nhãn trục y
	            dataset2, // Bộ dữ liệu cho đường biểu đồ số lượng
	            PlotOrientation.VERTICAL, // Hướng của biểu đồ
	            true, // Hiển thị chú thích
	            true, // Hiển thị tiêu đề
	            false // Không hiển thị URL
	    );

	    // Lấy plot của biểu đồ
	    CategoryPlot plot = (CategoryPlot) chart.getPlot();

	    // Tạo trục y cho dữ liệu "Giá trị"
	    NumberAxis yAxis1 = (NumberAxis) plot.getRangeAxis();
	    
	    // Tăng kích thước chữ cho nhãn và dấu gạch trên trục
	    Font font = new Font("Arial", Font.BOLD, 20); // Thay đổi kích thước và kiểu chữ tại đây
	    yAxis1.setTickLabelFont(font);
	    yAxis1.setLabelFont(font);

	    // Tạo trục y thứ hai cho dữ liệu "Tổng số lượng"
	    NumberAxis yAxis2 = new NumberAxis("Tổng số lượng");
	    yAxis2.setTickLabelFont(font);
	    yAxis2.setLabelFont(font);

	    // Đặt trục y thứ hai vào biểu đồ
	    plot.setRangeAxis(1, yAxis2);

	    // Tạo renderer cho dữ liệu "Tổng số lượng"
	    LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
	    renderer2.setSeriesPaint(0, Color.BLUE); // Màu đỏ cho đường biểu đồ tổng số lượng

	    // Đặt dataset và renderer cho đường biểu đồ tổng số lượng
	    plot.setDataset(1, dataset1); // Bộ dữ liệu cho đường biểu đồ tổng số lượng
	    plot.mapDatasetToRangeAxis(1, 1); // Ánh xạ đường biểu đồ tổng số lượng với trục Y phụ
	    plot.setRenderer(1, renderer2); // Ánh xạ renderer2 với đường biểu đồ tổng số lượng

	    // Chỉnh sửa chú thích
	    plot.getRenderer().setSeriesVisibleInLegend(1, true); // Hiển thị chú thích cho đường biểu đồ tổng số lượng

	    return chart;
	}



	public static DefaultCategoryDataset setData(String CongViec, String type,String loai, ArrayList<String> day, String dateFormatStr)
            throws ParseException {

        ArrayList<Integer> TongSoLuong = new ArrayList<>();
        ArrayList<Double> TongGiaTien = new ArrayList<>();
        String loai1="";
        String loai2="";
        switch (loai) {
		case "Sản Phẩm": 
			loai1="NgayNhap";
        	loai2="NgayXuat";
        	break;
		case "Cửa Hàng": 
			loai1="";
        	loai2="MaCuaHang";
        	break;
		case "Nhà Cung Cấp": 
			loai1="MaNhaCungCap";
        	loai2="";
        	break;
		default:

		}
	
        if (CongViec.equals("Nhập Hàng")&&!loai1.isEmpty()) {
            for (String ngay : day) {
                int tongSoLuong = PhieuNhapDao.getInstance().getTotalSoLuong(loai1, ngay);
                Double tongGiaTien = PhieuNhapDao.getInstance().getTotalTongTien(loai1, ngay);
                TongSoLuong.add(tongSoLuong);
                TongGiaTien.add(tongGiaTien);
            }
        } else if (CongViec.equals("Xuất Hàng")&&!loai2.isEmpty()) {
            for (String ngay : day) {
                int tongSoLuong = PhieuXuatDao.getInstance().getTotalSoLuong(loai2, ngay);
                Double tongGiaTien = PhieuXuatDao.getInstance().getTotalTongTien(loai2, ngay);
                TongSoLuong.add(tongSoLuong);
                TongGiaTien.add(tongGiaTien);
            }
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < day.size(); i++) {
            String ngay = day.get(i);
            if (type.equals("Số lượng")) {
                dataset.addValue(TongSoLuong.get(i), type, ngay);
            } else if (type.equals("Giá trị")) {
                dataset.addValue(TongGiaTien.get(i), type, ngay);
            }
        }

        return dataset;
    }

    public void Update(String CongViec,String loai, ArrayList<String> day, String dateFormatStr) {
        try {
            dataset1 = setData(CongViec, "Số lượng",loai, day, dateFormatStr);
            dataset2 = setData(CongViec, "Giá trị",loai, day, dateFormatStr);
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
