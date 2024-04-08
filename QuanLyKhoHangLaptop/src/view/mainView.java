package view;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.mainActionlistener;
import controller.mainMouseListener;
import dao.CuaHangDAO;
import dao.LaptopDAO;
import model.CuaHang;
import model.Laptop;

public class mainView extends JFrame {

	public JTextField textField;
	public JLabel jlabel_sanpham;
	public JLabel jlabel_nhacungcap;
	public JLabel jlabel_nhaphang;
	public JLabel jlabel_phieunhap;
	public JLabel jlabel_xuathang;
	public JLabel jlabel_phieuxuat;
	public JLabel jlabel_cuahang;
	public JLabel jlabel_taikhoan;
	public JLabel jlabel_thongke;
	public JLabel jlabel_doiThongtin;
	public JLabel jlabel_dangxuat;
	public JButton jbutton_refesh;
	public Object data[][];
	public JTable table;
	public DefaultTableModel model;
	private JScrollPane scrollPane;

	public mainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400, 800);
		this.setLocationRelativeTo(null);
		this.setTitle("màn hình chính");
		getContentPane().setLayout(null);

		JPanel panel_menu = new JPanel();
		panel_menu.setBounds(0, 0, 197, 763);
		panel_menu.setBackground(new Color(0, 128, 192));
		getContentPane().add(panel_menu);
		panel_menu.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hi !");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(63, 45, 36, 24);
		panel_menu.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(52, 79, 68, 24);
		panel_menu.add(lblNewLabel_1);

		jlabel_sanpham = new JLabel("Sản phẩm");
		jlabel_sanpham.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_sanpham.setForeground(new Color(0, 0, 0));
		jlabel_sanpham.setBounds(26, 158, 148, 37);
		ImageIcon icon_sanpham = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\product.png");
		jlabel_sanpham.setIcon(icon_sanpham);
		panel_menu.add(jlabel_sanpham);

		jlabel_nhacungcap = new JLabel("Nhà cung cấp");
		jlabel_nhacungcap.setForeground(new Color(0, 0, 0));
		jlabel_nhacungcap.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_nhacungcap.setBounds(26, 205, 161, 37);
		ImageIcon icon_nhaCungCap = new ImageIcon(
				"D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\supplier.png");
		jlabel_nhacungcap.setIcon(icon_nhaCungCap);
		panel_menu.add(jlabel_nhacungcap);

		jlabel_nhaphang = new JLabel("Nhập hàng");
		jlabel_nhaphang.setForeground(new Color(0, 0, 0));
		jlabel_nhaphang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_nhaphang.setBounds(26, 252, 148, 37);
		ImageIcon icon_nhaphang = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\nhaphang.png");
		jlabel_nhaphang.setIcon(icon_nhaphang);
		panel_menu.add(jlabel_nhaphang);

		jlabel_phieunhap = new JLabel("Phiếu nhập");
		jlabel_phieunhap.setForeground(new Color(0, 0, 0));
		jlabel_phieunhap.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_phieunhap.setBounds(26, 299, 148, 37);
		ImageIcon icon_phieunhap = new ImageIcon(
				"D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\phieunhap.png");
		jlabel_phieunhap.setIcon(icon_phieunhap);
		panel_menu.add(jlabel_phieunhap);

		jlabel_xuathang = new JLabel("Xuất hàng");
		jlabel_xuathang.setForeground(new Color(0, 0, 0));
		jlabel_xuathang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_xuathang.setBounds(26, 346, 148, 37);
		ImageIcon icon_xuathang = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\xuathang.png");
		jlabel_xuathang.setIcon(icon_xuathang);
		panel_menu.add(jlabel_xuathang);

		jlabel_phieuxuat = new JLabel("Phiếu xuất");
		jlabel_phieuxuat.setForeground(new Color(0, 0, 0));
		jlabel_phieuxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_phieuxuat.setBounds(26, 393, 148, 37);
		ImageIcon icon_phieuxuat = new ImageIcon(
				"D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\phieuxuat.png");
		jlabel_phieuxuat.setIcon(icon_phieuxuat);
		panel_menu.add(jlabel_phieuxuat);

		jlabel_cuahang = new JLabel("Cửa hàng");
		jlabel_cuahang.setForeground(new Color(0, 0, 0));
		jlabel_cuahang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_cuahang.setBounds(26, 440, 148, 37);
		ImageIcon icon_cuahang = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\store.png");
		jlabel_cuahang.setIcon(icon_cuahang);
		panel_menu.add(jlabel_cuahang);

		jlabel_taikhoan = new JLabel("Tài khoản");
		jlabel_taikhoan.setForeground(new Color(0, 0, 0));
		jlabel_taikhoan.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_taikhoan.setBounds(26, 487, 148, 37);
		ImageIcon icon_taikhoan = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\taikhoan.png");
		jlabel_taikhoan.setIcon(icon_taikhoan);
		panel_menu.add(jlabel_taikhoan);

		jlabel_thongke = new JLabel("Thống kê");
		jlabel_thongke.setForeground(new Color(0, 0, 0));
		jlabel_thongke.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_thongke.setBounds(26, 534, 148, 37);
		ImageIcon icon_thongke = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\thongke.png");
		jlabel_thongke.setIcon(icon_thongke);
		panel_menu.add(jlabel_thongke);

		jlabel_doiThongtin = new JLabel("Đổi thông tin");
		jlabel_doiThongtin.setForeground(new Color(0, 0, 0));
		jlabel_doiThongtin.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_doiThongtin.setBounds(26, 641, 148, 37);
		ImageIcon icon_doithongtin = new ImageIcon(
				"D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\thongtin.png");
		jlabel_doiThongtin.setIcon(icon_doithongtin);
		panel_menu.add(jlabel_doiThongtin);

		jlabel_dangxuat = new JLabel("Đăng xuất");
		jlabel_dangxuat.setForeground(new Color(0, 0, 0));
		jlabel_dangxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_dangxuat.setBounds(26, 688, 148, 37);
		ImageIcon icon_dangxuat = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\dangxuat.png");
		jlabel_dangxuat.setIcon(icon_dangxuat);
		panel_menu.add(jlabel_dangxuat);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 161, 1189, 602);
		getContentPane().add(scrollPane);

		/*
		 * Laptop tmp = new Laptop(); tmp.setMaLaptop("MSGB15"); Laptop lt =
		 * LaptopDAO.getintance().selectById(tmp);
		 * 
		 * String column[] = { "Id", "Tên laptop", "Số lượng", "Giá", "CPU", "Ram",
		 * "Bộ nhớ", "Hệ điều hành" }; Object data[][] = {}; JTable table = new
		 * JTable(data, column); table.setModel(new DefaultTableModel( new Object[][] {
		 * {lt.getMaLaptop(),lt.getTenLaptop(),lt.getSoLuong(),lt.getGia(),lt.getCPU(),
		 * lt.getRam(),lt.getRom(),lt.getHeDieuHanh()} }, new String[] { "Id",
		 * "Tên laptop", "Số lượng", "Giá", "CPU", "Ram", "Bộ nhớ", "Hệ điều hành" } ));
		 */
		table=SanPham();
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 14));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		JPanel panel_border_chucNang = new JPanel();
		panel_border_chucNang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chức năng",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_chucNang.setBounds(207, 10, 421, 81);
		getContentPane().add(panel_border_chucNang);
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
		jlabel_xoa.setBounds(67, 21, 45, 50);
		jlabel_xoa.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xoa.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xoa);

		ImageIcon icon_eye = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\eye.png");
		JLabel jlabel_xemCT = new JLabel("Xem chi tiết", icon_eye, JLabel.CENTER);
		jlabel_xemCT.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xemCT.setBounds(165, 21, 68, 50);
		jlabel_xemCT.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xemCT.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xemCT);

		ImageIcon icon_nhapExcel = new ImageIcon(
				"D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\nhapExcel.png");
		JLabel jlabel_nhapExcel = new JLabel("Nhập Excel", icon_nhapExcel, JLabel.CENTER);
		jlabel_nhapExcel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_nhapExcel.setBounds(265, 21, 68, 50);
		jlabel_nhapExcel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_nhapExcel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_nhapExcel);

		ImageIcon icon_Excel = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\xuatExcel.png");
		JLabel jlabel_Excel = new JLabel("Xuất Excel", icon_Excel, JLabel.CENTER);
		jlabel_Excel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_Excel.setBounds(343, 21, 68, 50);
		jlabel_Excel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_Excel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_Excel);

		JPanel panel_border_timKiem = new JPanel();
		panel_border_timKiem.setLayout(null);
		panel_border_timKiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tìm kiếm",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_timKiem.setBounds(766, 10, 620, 81);
		getContentPane().add(panel_border_timKiem);

		String[] combo = { "Tất cả", "Windows", "MacOS" };
		JComboBox comboBox_search = new JComboBox(combo);
		comboBox_search.setBackground(new Color(255, 255, 255));
		comboBox_search.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search.setBounds(10, 36, 95, 21);
		panel_border_timKiem.add(comboBox_search);

		textField = new JTextField();
		textField.setBounds(131, 31, 286, 33);
		panel_border_timKiem.add(textField);
		textField.setColumns(10);

		JButton jbutton_Sreach = new JButton("Tìm kiếm");

		jbutton_Sreach.setBackground(new Color(255, 255, 255));
		jbutton_Sreach.setBounds(502, 31, 95, 33);
		panel_border_timKiem.add(jbutton_Sreach);

		ImageIcon icon_refresh = new ImageIcon("D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\arrow.png");
		jbutton_refesh = new JButton(icon_refresh);
		jbutton_refesh.setBackground(new Color(255, 255, 255));
		jbutton_refesh.setBounds(427, 31, 42, 33);
		panel_border_timKiem.add(jbutton_refesh);

		mainActionlistener ac = new mainActionlistener(this);
		jbutton_refesh.addActionListener(ac);

		mainMouseListener mouse = new mainMouseListener(this);
		jlabel_sanpham.addMouseListener(mouse);
		jlabel_nhacungcap.addMouseListener(mouse);
		jlabel_nhaphang.addMouseListener(mouse);
		jlabel_phieunhap.addMouseListener(mouse);
		jlabel_xuathang.addMouseListener(mouse);
		jlabel_phieuxuat.addMouseListener(mouse);
		jlabel_cuahang.addMouseListener(mouse);
		jlabel_taikhoan.addMouseListener(mouse);
		jlabel_thongke.addMouseListener(mouse);
		jlabel_doiThongtin.addMouseListener(mouse);
		jlabel_dangxuat.addMouseListener(mouse);
		jlabel_them.addMouseListener(mouse);
		jlabel_Excel.addMouseListener(mouse);
		jlabel_sua.addMouseListener(mouse);
		jlabel_nhapExcel.addMouseListener(mouse);
		jlabel_xoa.addMouseListener(mouse);
		jlabel_xemCT.addMouseListener(mouse);
		this.setVisible(true);
		this.setResizable(false);
	}

	public JTable SanPham() {
		ArrayList<Laptop> listLaptop = LaptopDAO.getintance().selectAll();

		data = new Object[listLaptop.size()][8];
		for (int i = 0; i < listLaptop.size(); i++) {
			Laptop t = listLaptop.get(i);
			data[i][0] = t.getMaLaptop();
			data[i][1] = t.getTenLaptop();
			data[i][2] = t.getSoLuong();
			DecimalFormat df = new DecimalFormat("#");
		    String formattedNumber = df.format(t.getGia());
			data[i][3] = formattedNumber;
			data[i][4] = t.getCPU();
			data[i][5] = t.getRam();
			data[i][6] = t.getRom();
			data[i][7] = t.getHeDieuHanh();
		}
		String column[] = { "Id", "Tên laptop", "Số lượng", "Giá", "CPU", "Ram", "Bộ nhớ", "Hệ điều hành" };
		model = new DefaultTableModel(data, column);
		table = new JTable(model);

		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(1).setMinWidth(21);
		table.getColumnModel().getColumn(2).setPreferredWidth(61);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(93);
		table.getColumnModel().getColumn(5).setPreferredWidth(35);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(73);
		return table;
	}

	public JTable CuaHang() {
		ArrayList<CuaHang> ListCuaHang=CuaHangDAO.getintance().selectAll();
		data=new Object[ListCuaHang.size()][4];
		for (int i=0;i<ListCuaHang.size();i++) {
			CuaHang CH=ListCuaHang.get(i);
			data[i][0]=CH.getMaCH();
			data[i][1]=CH.getTenCH();
			data[i][2]=CH.getDiaChi();
			data[i][3]=CH.getSDT();
			
		}
		String column[] = { "Mã CH", "Tên Cửa Hàng", "Địa Chỉ", "Điện Thoại"};
		model = new DefaultTableModel(data, column);
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(400);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		return table;
	}

	public void updateTable(JTable newTable) {
		getContentPane().remove(scrollPane);
		scrollPane.setBounds(207, 161, 1189, 602);
		getContentPane().add(scrollPane);
		JTableHeader header = newTable.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 14));
		newTable.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(newTable);
		// Cập nhật lại giao diện
		this.revalidate();
		this.repaint();
	}
	
	public void updateTableData() {
	    // Lấy dữ liệu mới từ cơ sở dữ liệu
	    // Ví dụ: nếu bạn muốn cập nhật bảng sản phẩm
	    ArrayList<Laptop> listLaptop = LaptopDAO.getintance().selectAll();
	    
	    // Tạo lại mảng dữ liệu và cập nhật bảng
	    Object newData[][] = new Object[listLaptop.size()][8];
	    for (int i = 0; i < listLaptop.size(); i++) {
	        Laptop t = listLaptop.get(i);
	        newData[i][0] = t.getMaLaptop();
	        newData[i][1] = t.getTenLaptop();
	        newData[i][2] = t.getSoLuong();
	        DecimalFormat df = new DecimalFormat("#");
	        String formattedNumber = df.format(t.getGia());
	        newData[i][3] = formattedNumber;
	        newData[i][4] = t.getCPU();
	        newData[i][5] = t.getRam();
	        newData[i][6] = t.getRom();
	        newData[i][7] = t.getHeDieuHanh();
	    }
	    String column[] = { "Id", "Tên laptop", "Số lượng", "Giá", "CPU", "Ram", "Bộ nhớ", "Hệ điều hành" };
	    // Cập nhật mô hình của bảng
	    model.setDataVector(newData, column);
	    
	    // Cập nhật lại giao diện
	    this.revalidate();
	    this.repaint();
	}
	
	
}
