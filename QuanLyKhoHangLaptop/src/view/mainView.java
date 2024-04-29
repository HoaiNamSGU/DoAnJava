package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.mainMouseListener;
import dao.CuaHangDAO;
import dao.LaptopDAO;
import model.CuaHang;
import model.Laptop;
import model.NguoiDung;
import model.NhanVien;

import javax.swing.border.Border;

public class mainView extends JFrame {

	public JTextField textField;
	public JLabel jlabel_sanpham;
	public JLabel jlabel_nhacungcap;
	public JLabel jlabel_nhaphang;
	public JLabel jlabel_xuathang;
	public JLabel jlabel_cuahang;
	public JLabel jlabel_taikhoan;
	public JLabel jlabel_thongke;
	public JLabel jlabel_doiThongtin;
	public JLabel jlabel_dangxuat;
	public JButton jbutton_refesh;
	public Object data[][];
	public JTable table;
	public DefaultTableModel model;
	public JScrollPane scrollPane;
	public JComboBox<String> comboBox_search;
	public JButton jbutton_Sreach;
	public JPanel panel_center;
	public JComboBox<String> comboBox_Gia;
	public JComboBox<String> comboBox_Rom;
	public JComboBox<String> comboBox_Ram;
	public JComboBox<String> comboBox_CPU;
	public JComboBox<String> comboBox_Hang;
	public JLabel lblNewLabel;
	
	public laptopview laptopview = new laptopview();
	public CuaHangView cuahangview = new CuaHangView();
	public static NguoiDung nguoidung = new NguoiDung();
	public static NhanVien nhanvien = new NhanVien();
	public DoiThongTinUser user = new DoiThongTinUser();
	public JPanel panel_menu;
	public JPanel panel_west;
	
	public mainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1300, 800);
		this.setLocationRelativeTo(null);
		this.setTitle("màn hình chính");
		getContentPane().setLayout(new BorderLayout());
		ImageIcon icon_sanpham = new ImageIcon(getClass().getResource("/img/product.png"));
		ImageIcon icon_nhaCungCap = new ImageIcon(getClass().getResource("/img/supplier.png"));
		ImageIcon icon_nhaphang = new ImageIcon(getClass().getResource("/img/nhaphang.png"));
		ImageIcon icon_xuathang = new ImageIcon(getClass().getResource("/img/xuathang.png"));
		ImageIcon icon_cuahang = new ImageIcon(getClass().getResource("/img/store.png"));
		ImageIcon icon_taikhoan = new ImageIcon(getClass().getResource("/img/taikhoan.png"));
		ImageIcon icon_thongke = new ImageIcon(getClass().getResource("/img/thongke.png"));
		ImageIcon icon_doithongtin = new ImageIcon(getClass().getResource("/img/thongtin.png"));
		ImageIcon icon_dangxuat = new ImageIcon(getClass().getResource("/img/dangxuat.png"));

		mainMouseListener mouse = new mainMouseListener(this);

		panel_center = new JPanel(new BorderLayout());
		//panel_center.setBounds(197, 0, 1189, 763);
		
		Border border = BorderFactory.createEmptyBorder(0, 10, 0, 10);
        panel_center.setBorder(border);
        
		getContentPane().add(panel_center,BorderLayout.CENTER);

		laptopview.table.getColumnModel().getColumn(0).setPreferredWidth(52);
		laptopview.table.getColumnModel().getColumn(1).setPreferredWidth(200);
		laptopview.table.getColumnModel().getColumn(2).setPreferredWidth(30);
		laptopview.table.getColumnModel().getColumn(3).setPreferredWidth(40);
		laptopview.table.getColumnModel().getColumn(4).setPreferredWidth(93);
		laptopview.table.getColumnModel().getColumn(5).setPreferredWidth(35);
		laptopview.table.getColumnModel().getColumn(6).setPreferredWidth(45);
		laptopview.table.getColumnModel().getColumn(7).setPreferredWidth(73);
		panel_center.add(laptopview);
		
		panel_west = new JPanel();
		panel_west.setLayout(new BorderLayout());
		getContentPane().add(panel_west,BorderLayout.WEST);
		panel_menu = new JPanel(new GridLayout(9,1));
		panel_menu.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		//getContentPane().add(panel_menu,BorderLayout.WEST);
		//panel_menu.setBounds(0, 0, 197, 763);
		//panel_menu.setSize(197,763);
		panel_menu.setBackground(new Color(0, 128, 192));

		lblNewLabel = new JLabel("  Hi! User");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		//lblNewLabel.setBounds(63, 45, 36, 24);
		panel_menu.add(lblNewLabel);

		/*JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(52, 79, 68, 24);
		panel_menu.add(lblNewLabel_1);*/

		jlabel_sanpham = new JLabel("Sản phẩm");
		jlabel_sanpham.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_sanpham.setForeground(new Color(255, 255, 255));
		//jlabel_sanpham.setBounds(26, 158, 161, 37);

		jlabel_sanpham.setIcon(icon_sanpham);
		panel_menu.add(jlabel_sanpham);

		jlabel_nhacungcap = new JLabel("Nhà cung cấp");
		jlabel_nhacungcap.setForeground(new Color(0, 0, 0));
		jlabel_nhacungcap.setFont(new Font("Arial", Font.PLAIN, 20));
		//jlabel_nhacungcap.setBounds(26, 205, 161, 37);

		jlabel_nhacungcap.setIcon(icon_nhaCungCap);
		panel_menu.add(jlabel_nhacungcap);

		jlabel_nhaphang = new JLabel("Nhập hàng");
		jlabel_nhaphang.setForeground(new Color(0, 0, 0));
		jlabel_nhaphang.setFont(new Font("Arial", Font.PLAIN, 20));

		//jlabel_nhaphang.setBounds(26, 252, 161, 37);
		jlabel_nhaphang.setIcon(icon_nhaphang);
		panel_menu.add(jlabel_nhaphang);

		jlabel_xuathang = new JLabel("Xuất hàng");
		jlabel_xuathang.setForeground(new Color(0, 0, 0));
		jlabel_xuathang.setFont(new Font("Arial", Font.PLAIN, 20));
		//jlabel_xuathang.setBounds(26, 299, 161, 37);

		jlabel_xuathang.setIcon(icon_xuathang);
		panel_menu.add(jlabel_xuathang);

		jlabel_cuahang = new JLabel("Cửa hàng");
		jlabel_cuahang.setForeground(new Color(0, 0, 0));
		jlabel_cuahang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_cuahang.setIcon(icon_cuahang);
		//jlabel_cuahang.setBounds(26, 346, 161, 37);
		panel_menu.add(jlabel_cuahang);

		jlabel_taikhoan = new JLabel("Tài khoản");
		jlabel_taikhoan.setForeground(new Color(0, 0, 0));
		jlabel_taikhoan.setFont(new Font("Arial", Font.PLAIN, 20));
		//jlabel_taikhoan.setBounds(26, 440, 161, 37);
		jlabel_taikhoan.setIcon(icon_taikhoan);
		//panel_menu.add(jlabel_taikhoan);

		jlabel_thongke = new JLabel("Thống kê");
		jlabel_thongke.setForeground(new Color(0, 0, 0));
		jlabel_thongke.setFont(new Font("Arial", Font.PLAIN, 20));
		//jlabel_thongke.setBounds(26, 393, 161, 37);
		jlabel_thongke.setIcon(icon_thongke);
		panel_menu.add(jlabel_thongke);
		
		jlabel_doiThongtin = new JLabel("Thông tin tài khoản");
		jlabel_doiThongtin.setForeground(new Color(0, 0, 0));
		jlabel_doiThongtin.setFont(new Font("Arial", Font.PLAIN, 20));
		//jlabel_doiThongtin.setBounds(26, 641, 161, 37);
		jlabel_doiThongtin.setIcon(icon_doithongtin);
		panel_menu.add(jlabel_doiThongtin);

		jlabel_dangxuat = new JLabel("Đăng xuất");
		jlabel_dangxuat.setForeground(new Color(0, 0, 0));
		jlabel_dangxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		//jlabel_dangxuat.setBounds(26, 688, 161, 37);
		jlabel_dangxuat.setIcon(icon_dangxuat);
		panel_menu.add(jlabel_dangxuat);

		jlabel_sanpham.addMouseListener(mouse);
		jlabel_nhacungcap.addMouseListener(mouse);
		jlabel_nhaphang.addMouseListener(mouse);
		jlabel_xuathang.addMouseListener(mouse);
		jlabel_cuahang.addMouseListener(mouse);
		jlabel_taikhoan.addMouseListener(mouse);
		jlabel_thongke.addMouseListener(mouse);
		jlabel_doiThongtin.addMouseListener(mouse);
		jlabel_dangxuat.addMouseListener(mouse);
		
		panel_west.add(panel_menu,BorderLayout.CENTER);
		this.setVisible(true);
		//this.setResizable(false);
	}

	public JTable SanPham() {
		ArrayList<Laptop> listLaptop = LaptopDAO.getintance().selectAll();

		data = new Object[listLaptop.size()][9];
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
			data[i][8] = t.getMaNhaCungCap();
		}
		String column[] = { "Id", "Tên laptop", "Số lượng", "Giá", "CPU", "Ram", "Bộ nhớ", "Hệ điều hành",
				"Mã nhà cung cấp" };
		model = new DefaultTableModel(data, column);
		table = new JTable(model);

		setKhoangCachTable();
		return table;
	}

	public JTable CuaHang() {
		ArrayList<CuaHang> ListCuaHang = CuaHangDAO.getintance().selectAll();
		data = new Object[ListCuaHang.size()][4];
		for (int i = 0; i < ListCuaHang.size(); i++) {
			CuaHang CH = ListCuaHang.get(i);
			data[i][0] = CH.getMaCH();
			data[i][1] = CH.getTenCH();
			data[i][2] = CH.getDiaChi();
			data[i][3] = CH.getSDT();

		}
		String column[] = { "Mã CH", "Tên Cửa Hàng", "Địa Chỉ", "Điện Thoại" };
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

	public void updateTableData(ArrayList<Laptop> listLaptop) {

		// Tạo lại mảng dữ liệu và cập nhật bảng
		Object newData[][] = new Object[listLaptop.size()][9];
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
			newData[i][8] = t.getMaNhaCungCap();
		}
		String column[] = { "Id", "Tên laptop", "Số lượng", "Giá", "CPU", "Ram", "Bộ nhớ", "Hệ điều hành",
				"Mã nhà cung cấp" };
		// Cập nhật mô hình của bảng
		model.setDataVector(newData, column);
		setKhoangCachTable();
		// Cập nhật lại giao diện
		this.revalidate();
		this.repaint();
	}

	public void setKhoangCachTable() {
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setMinWidth(15);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(93);
		table.getColumnModel().getColumn(5).setPreferredWidth(35);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
	}

	public ArrayList<Laptop> select_search_laptop(ArrayList<Laptop> list, String s) {
		s = s.toUpperCase();
		ArrayList<Laptop> arr = new ArrayList<Laptop>();
		for (Laptop laptop : list) {
			String tmp = laptop.getMaLaptop() + " " + laptop.getTenLaptop() + " " + laptop.getCPU() + " "
					+ laptop.getGPU() + " " + laptop.getRam() + " " + laptop.getRom() + " " + laptop.getManHinh() + " "
					+ laptop.getHeDieuHanh() + " " + laptop.getHang() + " " + laptop.getNamSanXuat() + " "
					+ laptop.getSoLuong() + " " + laptop.getGia();
			tmp = tmp.toUpperCase();
			if (tmp.indexOf(s) != -1) {
				arr.add(laptop);
			}
		}
		return arr;
	}

	public JComboBox<String> addItem(String s) {
		ArrayList<String> arr = LaptopDAO.getintance().getColumn(s);
		JComboBox<String> tmp = new JComboBox<String>();
		for (String string : arr) {
			tmp.addItem(string);
		}
		return tmp;
	}
	
	public void addLabel()
	{
		panel_menu.setLayout(new GridLayout(10,1));
		panel_menu.add(lblNewLabel);
		panel_menu.add(jlabel_sanpham);
		panel_menu.add(jlabel_nhacungcap);
		panel_menu.add(jlabel_nhaphang);
		panel_menu.add(jlabel_cuahang);
		panel_menu.add(jlabel_xuathang);
		panel_menu.add(jlabel_taikhoan);
		panel_menu.add(jlabel_thongke);
		panel_menu.add(jlabel_doiThongtin);
		panel_menu.add(jlabel_dangxuat);
		
	}
}
