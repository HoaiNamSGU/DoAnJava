package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.mainActionlistener;
import javax.swing.SwingConstants;

public class CuaHang_View extends JPanel {

	public static final long serialVersionUID = 1L;
	public Object[][] data;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scrollPane;
	private JComboBox comboBox_search;
	private JTextField textField;
	private JButton jbutton_Sreach;
	private JButton jbutton_refesh;

	/**
	 * Create the panel.
	 */
	public CuaHang_View() {
		this.setBounds(190, 0, 1200, 770);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 1180, 569);
		this.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		String column[] = { "Mã CH", "Tên Cửa Hàng", "Địa Chỉ", "Điện Thoại"};
		model = new DefaultTableModel(data, column);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(400);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		scrollPane.setViewportView(table);
		JPanel panel_border_chucNang = new JPanel();
		panel_border_chucNang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chức năng",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_chucNang.setBounds(10, 10, 421, 81);
		this.add(panel_border_chucNang);
		panel_border_chucNang.setLayout(null);

		ImageIcon icon_add = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\plus.png");
		JLabel jlabel_them = new JLabel("Thêm", icon_add, JLabel.CENTER);
		jlabel_them.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_them.setBounds(10, 21, 44, 56);
		jlabel_them.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_them.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_them);

		ImageIcon icon_pencil = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\pencil.png");
		JLabel jlabel_sua = new JLabel("Sửa", icon_pencil, JLabel.CENTER);
		jlabel_sua.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_sua.setBounds(109, 21, 59, 56);
		jlabel_sua.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_sua.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_sua);

		ImageIcon icon_remove = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\remove.png");
		JLabel jlabel_xoa = new JLabel("Xóa", icon_remove, JLabel.CENTER);
		jlabel_xoa.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xoa.setBounds(67, 21, 45, 56);
		jlabel_xoa.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xoa.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xoa);

		ImageIcon icon_eye = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\eye.png");
		JLabel jlabel_xemCT = new JLabel("Xem chi tiết", icon_eye, JLabel.CENTER);
		jlabel_xemCT.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xemCT.setBounds(165, 21, 68, 56);
		jlabel_xemCT.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xemCT.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xemCT);

		ImageIcon icon_nhapExcel = new ImageIcon(
				"D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\nhapExcel.png");
		JLabel jlabel_nhapExcel = new JLabel("Nhập Excel", icon_nhapExcel, JLabel.CENTER);
		jlabel_nhapExcel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_nhapExcel.setBounds(265, 21, 68, 56);
		jlabel_nhapExcel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_nhapExcel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_nhapExcel);

		ImageIcon icon_Excel = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\xuatExcel.png");
		JLabel jlabel_Excel = new JLabel("Xuất Excel", icon_Excel, JLabel.CENTER);
		jlabel_Excel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_Excel.setBounds(343, 21, 68, 56);
		jlabel_Excel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_Excel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_Excel);

		JPanel panel_border_timKiem = new JPanel();
		panel_border_timKiem.setLayout(null);
		panel_border_timKiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tìm kiếm",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_timKiem.setBounds(760, 10, 430, 116);
		this.add(panel_border_timKiem);
		
		mainActionlistener ac = new mainActionlistener(this);
		String[] Xa_Phuong = {};
		comboBox_search = new JComboBox(Xa_Phuong);
		comboBox_search.addActionListener(ac);
		comboBox_search.setBackground(new Color(255, 255, 255));
		comboBox_search.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search.setBounds(10, 75, 95, 21);
		panel_border_timKiem.add(comboBox_search);
		
		String[] Quan_Huyen= {"Quận 1", "Quận 12", "Thủ Đức", "Gò Vấp", "Bình Thạnh", "Tân Bình", "Tân Phú", "Phú Nhuận", "Quận 3", "Quận 10", "Quận 11", "Quận 4", "Quận 5", "Quận 6", "Quận 8", "Bình Tân", "Quận 7", "Củ Chi", "Bình Chánh", "Nhà Bè", "Cần Giờ"};
		JComboBox  comboBox_search_1 = new JComboBox(Quan_Huyen);
		comboBox_search_1.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search_1.setBackground(Color.WHITE);
		comboBox_search_1.setBounds(115, 75, 95, 21);
		panel_border_timKiem.add(comboBox_search_1);
		String [] ThanhPho= {"TP HCM"};
		JComboBox comboBox_search_2 = new JComboBox(ThanhPho);
		comboBox_search_2.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search_2.setBackground(Color.WHITE);
		comboBox_search_2.setBounds(220, 75, 95, 21);
		panel_border_timKiem.add(comboBox_search_2);
		
		textField = new JTextField();
		textField.setBounds(10, 31, 305, 33);
		panel_border_timKiem.add(textField);
		textField.setColumns(10);

		jbutton_Sreach = new JButton("Tìm kiếm");
		jbutton_Sreach.setFont(new Font("Arial", Font.PLAIN, 11));
		jbutton_Sreach.addActionListener(ac);
		jbutton_Sreach.setBackground(new Color(255, 255, 255));
		jbutton_Sreach.setBounds(325, 31, 95, 33);
		panel_border_timKiem.add(jbutton_Sreach);

		ImageIcon icon_refresh = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\arrow.png");
		jbutton_refesh = new JButton(icon_refresh);
		jbutton_refesh.setBackground(new Color(255, 255, 255));
		jbutton_refesh.setBounds(325, 75, 30, 21);
		panel_border_timKiem.add(jbutton_refesh);
		
		
		this.setVisible(true);
	}
}
