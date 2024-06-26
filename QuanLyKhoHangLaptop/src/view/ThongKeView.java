package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.ThongKeActionListener;
import controller.ThongKeMouseListener;
import dao.PhieuNhapDao;
import dao.PhieuXuatDao;
import img.Source;
import model.PhieuNhap;
import model.PhieuXuat;

public class ThongKeView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private Source source = new Source();
	public JComboBox<Object> comboBox_ThoiGian;
	public JComboBox<Object> comboBox_NgayBD;
	public JComboBox<Object> comboBox_NgayKT;
	public String[] dateFormat = { "dd/MM/yyyy", "MM/yyyy", "yyyy" };
	public JComboBox<Object> comboBox_CongViec;
	public JPanel panel_Center;
	public BieuDoDuong_Duong bdsp = new BieuDoDuong_Duong();
	public BieuDoCot_Duong bdch = new BieuDoCot_Duong();
	public String loai = "Sản Phẩm";

	public ThongKeView() {
		setLayout(new BorderLayout(0, 0));
		this.setBounds(0, 0, 1200, 770);
		JPanel panel_ChucNang = new JPanel();
		add(panel_ChucNang, BorderLayout.NORTH);
		GridBagLayout gbl_panel_ChucNang = new GridBagLayout();
		gbl_panel_ChucNang.columnWidths = new int[] { 100, 296, 100, 296, 0, 0 };
		gbl_panel_ChucNang.rowHeights = new int[] { 30, 30 };
		gbl_panel_ChucNang.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_ChucNang.rowWeights = new double[] { 0.0, 0.0 };
		panel_ChucNang.setLayout(gbl_panel_ChucNang);

		JLabel Label_ThoiGian = new JLabel("Thời gian");
		Label_ThoiGian.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ThoiGian = new GridBagConstraints();
		gbc_Label_ThoiGian.fill = GridBagConstraints.BOTH;
		gbc_Label_ThoiGian.insets = new Insets(5, 0, 5, 5);
		gbc_Label_ThoiGian.gridx = 0;
		gbc_Label_ThoiGian.gridy = 0;
		panel_ChucNang.add(Label_ThoiGian, gbc_Label_ThoiGian);
		String[] ThoiGian = { "Thống kê theo ngày", "Thống kê theo tháng", "Thống kê theo năm" };
		comboBox_ThoiGian = new JComboBox<Object>(ThoiGian);
		comboBox_ThoiGian.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_comboBox_ThoiGian = new GridBagConstraints();
		gbc_comboBox_ThoiGian.fill = GridBagConstraints.BOTH;
		gbc_comboBox_ThoiGian.insets = new Insets(5, 0, 5, 85);
		gbc_comboBox_ThoiGian.gridx = 1;
		gbc_comboBox_ThoiGian.gridy = 0;
		panel_ChucNang.add(comboBox_ThoiGian, gbc_comboBox_ThoiGian);

		JLabel Label_NgayBD = new JLabel("Ngày bắt đầu");
		Label_NgayBD.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_NgayBD = new GridBagConstraints();
		gbc_Label_NgayBD.fill = GridBagConstraints.BOTH;
		gbc_Label_NgayBD.insets = new Insets(5, 30, 5, 50);
		gbc_Label_NgayBD.gridx = 2;
		gbc_Label_NgayBD.gridy = 0;
		panel_ChucNang.add(Label_NgayBD, gbc_Label_NgayBD);

		comboBox_NgayBD = new JComboBox<Object>();
		comboBox_NgayBD.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_comboBox_NgayBD = new GridBagConstraints();
		gbc_comboBox_NgayBD.fill = GridBagConstraints.BOTH;
		gbc_comboBox_NgayBD.insets = new Insets(5, 0, 5, 85);
		gbc_comboBox_NgayBD.gridx = 3;
		gbc_comboBox_NgayBD.gridy = 0;
		panel_ChucNang.add(comboBox_NgayBD, gbc_comboBox_NgayBD);

		JLabel Label_CongViec = new JLabel("Công việc");
		Label_CongViec.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_CongViec = new GridBagConstraints();
		gbc_Label_CongViec.fill = GridBagConstraints.BOTH;
		gbc_Label_CongViec.insets = new Insets(5, 0, 5, 50);
		gbc_Label_CongViec.gridx = 0;
		gbc_Label_CongViec.gridy = 1;
		panel_ChucNang.add(Label_CongViec, gbc_Label_CongViec);

		String[] CongViec = { "Nhập Hàng", "Xuất Hàng" };
		comboBox_CongViec = new JComboBox<Object>(CongViec);
		comboBox_CongViec.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_comboBox_CongViec = new GridBagConstraints();
		gbc_comboBox_CongViec.fill = GridBagConstraints.BOTH;
		gbc_comboBox_CongViec.insets = new Insets(5, 0, 5, 85);
		gbc_comboBox_CongViec.gridx = 1;
		gbc_comboBox_CongViec.gridy = 1;
		panel_ChucNang.add(comboBox_CongViec, gbc_comboBox_CongViec);

		JLabel Label_NgayKT = new JLabel("Ngày kết thúc");
		Label_NgayKT.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_NgayKT = new GridBagConstraints();
		gbc_Label_NgayKT.fill = GridBagConstraints.BOTH;
		gbc_Label_NgayKT.insets = new Insets(5, 30, 5, 50);
		gbc_Label_NgayKT.gridx = 2;
		gbc_Label_NgayKT.gridy = 1;
		panel_ChucNang.add(Label_NgayKT, gbc_Label_NgayKT);

		comboBox_NgayKT = new JComboBox<Object>();
		comboBox_NgayKT.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_comboBox_NgayKT = new GridBagConstraints();
		gbc_comboBox_NgayKT.fill = GridBagConstraints.BOTH;
		gbc_comboBox_NgayKT.insets = new Insets(5, 0, 5, 85);
		gbc_comboBox_NgayKT.gridx = 3;
		gbc_comboBox_NgayKT.gridy = 1;
		panel_ChucNang.add(comboBox_NgayKT, gbc_comboBox_NgayKT);

		panel_Center = new JPanel();
		panel_Center.add(bdsp);
		add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel_Menu = new JPanel();
		add(panel_Menu, BorderLayout.EAST);
		panel_Menu.setLayout(new GridLayout(0, 1, 0, 50));

		JLabel Label_SanPham = new JLabel("Sản Phẩm");
		Label_SanPham.setFont(new Font("Arial", Font.BOLD, 16));
		Label_SanPham.setIcon(source.icon_sanpham);
		Label_SanPham.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Menu.add(Label_SanPham);

		JLabel Label_CuaHang = new JLabel("Cửa Hàng");
		Label_CuaHang.setFont(new Font("Arial", Font.BOLD, 16));
		Label_CuaHang.setIcon(source.icon_cuahang);
		Label_CuaHang.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Menu.add(Label_CuaHang);

		JLabel Label_NhaCC = new JLabel("Nhà Cung Cấp");
		Label_NhaCC.setFont(new Font("Arial", Font.BOLD, 16));
		Label_NhaCC.setIcon(source.icon_nhaCungCap);
		Label_NhaCC.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Menu.add(Label_NhaCC);
		ThongKeActionListener ac = new ThongKeActionListener(this);
		ThongKeMouseListener mouse = new ThongKeMouseListener(this);
		Label_SanPham.addMouseListener(mouse);
		Label_CuaHang.addMouseListener(mouse);
		Label_NhaCC.addMouseListener(mouse);
		comboBox_ThoiGian.addActionListener(ac);
		comboBox_CongViec.addActionListener(ac);
		comboBox_NgayBD.addActionListener(ac);
		comboBox_NgayKT.addActionListener(ac);

		updateDateFormats();
		setVisible(true);
	}
	public void updateComboBox() {
		int StartDate = comboBox_NgayBD.getSelectedIndex();
		int EndDate = comboBox_NgayKT.getSelectedIndex();
		
		if (StartDate>0&&StartDate > EndDate)
			comboBox_NgayBD.setSelectedIndex(EndDate);
		updateData(loai);
		
	}
	public void updateDateFormats() {
		String selectedFormat = dateFormat[comboBox_ThoiGian.getSelectedIndex()];

		comboBox_NgayBD.removeAllItems();
		comboBox_NgayKT.removeAllItems();

		ArrayList<String> startDayString = new ArrayList<String>();

		// lấy dữ liệu ngày/tháng/năm mới dựa trên công việc đã chọn
		if (comboBox_CongViec.getSelectedItem().toString() == "Nhập Hàng")
			startDayString = PhieuNhapDao.getInstance().selectDay();
		else
			startDayString = PhieuXuatDao.getInstance().selectDay();

		// định dạng ngày
		ArrayList<String> dates = getDateFormats(startDayString, selectedFormat);

		// cập nhật dữ liệu
		for (String date : dates) {
			comboBox_NgayBD.addItem(date);
			comboBox_NgayKT.addItem(date);
		}
		updateData(loai);
	}

	private ArrayList<String> getDateFormats(ArrayList<String> dateList, String dateFormat) {
		ArrayList<String> formattedDates = new ArrayList<String>();
		HashSet<String> uniqueDates = new HashSet<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (String dateString : dateList) {
			LocalDate date = LocalDate.parse(dateString, formatter);
			switch (dateFormat) {
			case "dd/MM/yyyy":
				uniqueDates.add(String.format("%02d", date.getDayOfMonth()) + "/"
						+ String.format("%02d", date.getMonthValue()) + "/" + date.getYear());
				break;
			case "MM/yyyy":
				uniqueDates.add(String.format("%02d", date.getMonthValue()) + "/" + date.getYear());
				break;
			case "yyyy":
				uniqueDates.add(String.valueOf(date.getYear()));
				break;
			default:
				break;
			}
		}
		formattedDates.addAll(uniqueDates);
		formattedDates.sort(null);
		return formattedDates;
	}

	public void updateData(String loaiThongKe) {
		panel_Center.removeAll();
		String congViec = comboBox_CongViec.getSelectedItem().toString();
		int StartDay = comboBox_NgayBD.getSelectedIndex();
		int EndDay = comboBox_NgayKT.getSelectedIndex();

		ArrayList<String> Result = new ArrayList<String>();
		ArrayList<PhieuXuat> CH = PhieuXuatDao.getInstance().selectAll();
		ArrayList<PhieuNhap> NCC = PhieuNhapDao.getInstance().selectAll();

		String DateFomart = dateFormat[comboBox_ThoiGian.getSelectedIndex()];
		switch (loaiThongKe) {
		
			case "Sản Phẩm":
				for (int i = StartDay; i <= EndDay; i++)
					if (comboBox_NgayBD.getItemAt(i) != null)
						Result.add(comboBox_NgayBD.getItemAt(i).toString());
				
				bdsp.Update(congViec, loaiThongKe, Result, DateFomart);
				panel_Center.add(bdsp);
				break;
				
			case "Cửa Hàng":
				//lấy danh sách không bị trùng
				Set<String> uniqueMaCH = new HashSet<>();
				for (PhieuXuat px : CH) 
					uniqueMaCH.add(px.getMaCuaHang());
				
				Result.addAll(uniqueMaCH);
				bdch.Update("Xuất Hàng", loaiThongKe, Result, DateFomart);
				panel_Center.add(bdch);
				break;
				
			case "Nhà Cung Cấp":
				Set<String> uniqueMaNCC = new HashSet<>();
				for (PhieuNhap pn : NCC) 
					uniqueMaNCC.add(pn.getMaNhaCungCap());
	
				Result.addAll(uniqueMaNCC);
				bdch.Update("Nhập Hàng", loaiThongKe, Result, DateFomart);
				panel_Center.add(bdch);
				break;
			default:
				break;
			
		}
		
		revalidate(); // cập nhật layout
	    repaint();
	}
	public void setEnableComboBox(Boolean type) {
		comboBox_NgayBD.setEnabled(type);
		comboBox_NgayKT.setEnabled(type);
		comboBox_CongViec.setEnabled(type);
		comboBox_ThoiGian.setEnabled(type);
	}

}
