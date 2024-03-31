package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ThemSanPhamActionlistener;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ThemSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField jtextField_masanpham;
	public JTextField jtextField_tensanpham;
	public JTextField jtextField_CPU;
	public JTextField jtextField_GPU;
	public JTextField jtextField_Ram;
	public JTextField jtextField_Rom;
	public JTextField jtextField_manhinh;
	public JTextField jtextField_Hang;
	public JTextField jtextField_hedieuhanh;
	public JTextField textField_NamSX;
	public JTextField jtextField_soluong;
	public JTextField jtextField_gia;
	public JButton jbutton_xacnhan;
	public JButton jbutton_huybo;


	public ThemSanPham() {
		this.setTitle("Thêm sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 889, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
		
		JPanel jpanel_title = new JPanel();
		jpanel_title.setBackground(new Color(0, 128, 192));
		jpanel_title.setBounds(0, 0, 875, 50);
		contentPane.add(jpanel_title);
		jpanel_title.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm sản phẩm mới");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(339, 10, 196, 30);
		jpanel_title.add(lblNewLabel);
		
		JLabel jlabel_masanpham = new JLabel("Mã sản phẩm");
		jlabel_masanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_masanpham.setBounds(37, 74, 106, 24);
		contentPane.add(jlabel_masanpham);
		
		jtextField_masanpham = new JTextField();
		jtextField_masanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_masanpham.setBounds(37, 99, 178, 30);
		contentPane.add(jtextField_masanpham);
		jtextField_masanpham.setColumns(10);
		
		JLabel jlabel_tensanpham = new JLabel("Tên sản phẩm");
		jlabel_tensanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_tensanpham.setBounds(37, 159, 106, 24);
		contentPane.add(jlabel_tensanpham);
		
		jtextField_tensanpham = new JTextField();
		jtextField_tensanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_tensanpham.setColumns(10);
		jtextField_tensanpham.setBounds(37, 184, 178, 30);
		contentPane.add(jtextField_tensanpham);
		
		JLabel jlabel_CPU = new JLabel("CPU");
		jlabel_CPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_CPU.setBounds(37, 247, 106, 24);
		contentPane.add(jlabel_CPU);
		
		jtextField_CPU = new JTextField();
		jtextField_CPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_CPU.setColumns(10);
		jtextField_CPU.setBounds(37, 275, 178, 30);
		contentPane.add(jtextField_CPU);
		
		JLabel jlabel_GPU = new JLabel("GPU");
		jlabel_GPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_GPU.setBounds(37, 345, 106, 24);
		contentPane.add(jlabel_GPU);
		
		jtextField_GPU = new JTextField();
		jtextField_GPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_GPU.setColumns(10);
		jtextField_GPU.setBounds(37, 374, 178, 30);
		contentPane.add(jtextField_GPU);
		
		JLabel jlabel_Ram = new JLabel("Ram");
		jlabel_Ram.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_Ram.setBounds(331, 74, 106, 24);
		contentPane.add(jlabel_Ram);
		
		jtextField_Ram = new JTextField();
		jtextField_Ram.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_Ram.setColumns(10);
		jtextField_Ram.setBounds(331, 99, 178, 30);
		contentPane.add(jtextField_Ram);
		
		jtextField_Rom = new JTextField();
		jtextField_Rom.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_Rom.setColumns(10);
		jtextField_Rom.setBounds(331, 184, 178, 30);
		contentPane.add(jtextField_Rom);
		
		jtextField_manhinh = new JTextField();
		jtextField_manhinh.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_manhinh.setColumns(10);
		jtextField_manhinh.setBounds(331, 275, 178, 30);
		contentPane.add(jtextField_manhinh);
		
		jtextField_Hang = new JTextField();
		jtextField_Hang.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_Hang.setColumns(10);
		jtextField_Hang.setBounds(331, 374, 178, 30);
		contentPane.add(jtextField_Hang);
		
		jtextField_hedieuhanh = new JTextField();
		jtextField_hedieuhanh.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_hedieuhanh.setColumns(10);
		jtextField_hedieuhanh.setBounds(639, 99, 178, 30);
		contentPane.add(jtextField_hedieuhanh);
		
		textField_NamSX = new JTextField();
		textField_NamSX.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_NamSX.setColumns(10);
		textField_NamSX.setBounds(639, 184, 178, 30);
		contentPane.add(textField_NamSX);
		
		jtextField_soluong = new JTextField();
		jtextField_soluong.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_soluong.setColumns(10);
		jtextField_soluong.setBounds(639, 275, 178, 30);
		contentPane.add(jtextField_soluong);
		
		jtextField_gia = new JTextField();
		jtextField_gia.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_gia.setColumns(10);
		jtextField_gia.setBounds(639, 374, 178, 30);
		contentPane.add(jtextField_gia);
		
		JLabel jlabel_Rom = new JLabel("Rom");
		jlabel_Rom.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_Rom.setBounds(331, 159, 106, 24);
		contentPane.add(jlabel_Rom);
		
		JLabel jlabel_manhinh = new JLabel("Màn hình");
		jlabel_manhinh.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_manhinh.setBounds(331, 247, 106, 24);
		contentPane.add(jlabel_manhinh);
		
		JLabel jlabel_hang = new JLabel("Hãng");
		jlabel_hang.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_hang.setBounds(331, 345, 106, 24);
		contentPane.add(jlabel_hang);
		
		JLabel jlabel_hedieuhanh = new JLabel("Hệ điều hành");
		jlabel_hedieuhanh.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_hedieuhanh.setBounds(639, 74, 106, 24);
		contentPane.add(jlabel_hedieuhanh);
		
		JLabel jlabel_namsanxuat = new JLabel("Năm sản xuất");
		jlabel_namsanxuat.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_namsanxuat.setBounds(639, 159, 106, 24);
		contentPane.add(jlabel_namsanxuat);
		
		JLabel jlabel_soluong = new JLabel("Số lượng");
		jlabel_soluong.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_soluong.setBounds(639, 247, 106, 24);
		contentPane.add(jlabel_soluong);
		
		JLabel jlabel_gia = new JLabel("Giá");
		jlabel_gia.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_gia.setBounds(639, 345, 106, 24);
		contentPane.add(jlabel_gia);
		
		jbutton_xacnhan = new JButton("Xác nhận");
		jbutton_xacnhan.setForeground(new Color(255, 255, 255));
		jbutton_xacnhan.setBackground(new Color(0, 128, 192));
		jbutton_xacnhan.setFont(new Font("Arial", Font.PLAIN, 16));
		jbutton_xacnhan.setBounds(219, 437, 165, 41);
		contentPane.add(jbutton_xacnhan);
		
		jbutton_huybo = new JButton("Hủy bỏ");
		jbutton_huybo.setForeground(Color.WHITE);
		jbutton_huybo.setFont(new Font("Arial", Font.PLAIN, 16));
		jbutton_huybo.setBackground(Color.RED);
		jbutton_huybo.setBounds(448, 437, 165, 41);
		contentPane.add(jbutton_huybo);
		
		ActionListener ac = new ThemSanPhamActionlistener(this);
		
		jbutton_xacnhan.addActionListener(ac);
		jbutton_huybo.addActionListener(ac);
		this.setVisible(true);
	}
	
	public String getText(JTextField textfield)
	{
		return textfield.getText();
	}
}
