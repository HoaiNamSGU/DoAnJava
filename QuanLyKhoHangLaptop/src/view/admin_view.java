package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.mainMouseListener;
import dao.CuaHangDAO;
import dao.LaptopDAO;
import model.CuaHang;
import model.Laptop;

public class admin_view extends JFrame {

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
	public JButton jbutton_Sreach;
	public JPanel panel_center;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_view frame = new admin_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public admin_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1400, 800);
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

		//mainMouseListener mouse = new mainMouseListener(this);

		panel_center = new JPanel(new BorderLayout());
		//panel_center.setBounds(197, 0, 1189, 763);
		getContentPane().add(panel_center,BorderLayout.CENTER);


		JPanel panel_menu = new JPanel(new GridLayout(10,1));
		panel_menu.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		getContentPane().add(panel_menu,BorderLayout.WEST);
		//panel_menu.setBounds(0, 0, 197, 763);
		//panel_menu.setSize(197,763);
		panel_menu.setBackground(new Color(0, 128, 192));

		JLabel lblNewLabel = new JLabel("  Hi! Admin");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		//lblNewLabel.setBounds(63, 45, 36, 24);
		panel_menu.add(lblNewLabel);

		

		jlabel_sanpham = new JLabel("Sản phẩm");
		jlabel_sanpham.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_sanpham.setForeground(new Color(255, 255, 255));
		//jlabel_sanpham.setBounds(26, 158, 161, 37);

		jlabel_sanpham.setIcon(icon_sanpham);
		panel_menu.add(jlabel_sanpham);

		jlabel_nhacungcap = new JLabel("Nhà cung cấp");
		jlabel_nhacungcap.setForeground(new Color(0, 0, 0));
		jlabel_nhacungcap.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_nhacungcap.setIcon(icon_nhaCungCap);
		panel_menu.add(jlabel_nhacungcap);

		jlabel_nhaphang = new JLabel("Nhập hàng");
		jlabel_nhaphang.setForeground(new Color(0, 0, 0));
		jlabel_nhaphang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_nhaphang.setIcon(icon_nhaphang);
		panel_menu.add(jlabel_nhaphang);

		jlabel_xuathang = new JLabel("Xuất hàng");
		jlabel_xuathang.setForeground(new Color(0, 0, 0));
		jlabel_xuathang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_xuathang.setIcon(icon_xuathang);
		panel_menu.add(jlabel_xuathang);

		jlabel_cuahang = new JLabel("Cửa hàng");
		jlabel_cuahang.setForeground(new Color(0, 0, 0));
		jlabel_cuahang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_cuahang.setIcon(icon_cuahang);
		panel_menu.add(jlabel_cuahang);

		jlabel_taikhoan = new JLabel("Tài khoản");
		jlabel_taikhoan.setForeground(new Color(0, 0, 0));
		jlabel_taikhoan.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_taikhoan.setIcon(icon_taikhoan);
		panel_menu.add(jlabel_taikhoan);

		jlabel_thongke = new JLabel("Thống kê");
		jlabel_thongke.setForeground(new Color(0, 0, 0));
		jlabel_thongke.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_thongke.setIcon(icon_thongke);
		panel_menu.add(jlabel_thongke);

		jlabel_doiThongtin = new JLabel("Đổi thông tin");
		jlabel_doiThongtin.setForeground(new Color(0, 0, 0));
		jlabel_doiThongtin.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_doiThongtin.setIcon(icon_doithongtin);
		panel_menu.add(jlabel_doiThongtin);

		jlabel_dangxuat = new JLabel("Đăng xuất");
		jlabel_dangxuat.setForeground(new Color(0, 0, 0));
		jlabel_dangxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_dangxuat.setIcon(icon_dangxuat);
		panel_menu.add(jlabel_dangxuat);

		/*jlabel_sanpham.addMouseListener(mouse);
		jlabel_nhacungcap.addMouseListener(mouse);
		jlabel_nhaphang.addMouseListener(mouse);
		jlabel_xuathang.addMouseListener(mouse);
		jlabel_cuahang.addMouseListener(mouse);
		jlabel_taikhoan.addMouseListener(mouse);
		jlabel_thongke.addMouseListener(mouse);
		jlabel_doiThongtin.addMouseListener(mouse);
		jlabel_dangxuat.addMouseListener(mouse);*/

		this.setVisible(true);
		//this.setResizable(false);
	}

	

}
