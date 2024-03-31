package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SuaSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtextField_masanpham;
	private JTextField jtextField_tensanpham;
	private JTextField jtextField_CPU;
	private JTextField jtextField_GPU;
	private JTextField jtextField_Ram;
	private JTextField jtextField_Rom;
	private JTextField jtextField_manhinh;
	private JTextField jtextField_Hãng;
	private JTextField jtextField_hedieuhanh;
	private JTextField textField_8;
	private JTextField jtextField_soluong;
	private JTextField jtextField_gia;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuaSanPham frame = new SuaSanPham();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SuaSanPham() {
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
		
		JLabel lblNewLabel = new JLabel("Sửa sản phẩm");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(339, 10, 159, 30);
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
		
		jtextField_Hãng = new JTextField();
		jtextField_Hãng.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_Hãng.setColumns(10);
		jtextField_Hãng.setBounds(331, 374, 178, 30);
		contentPane.add(jtextField_Hãng);
		
		jtextField_hedieuhanh = new JTextField();
		jtextField_hedieuhanh.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_hedieuhanh.setColumns(10);
		jtextField_hedieuhanh.setBounds(639, 99, 178, 30);
		contentPane.add(jtextField_hedieuhanh);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBounds(639, 184, 178, 30);
		contentPane.add(textField_8);
		
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
		
		JButton jbutton_xacnhan = new JButton("Xác nhận");
		jbutton_xacnhan.setForeground(new Color(255, 255, 255));
		jbutton_xacnhan.setBackground(new Color(0, 128, 192));
		jbutton_xacnhan.setFont(new Font("Arial", Font.PLAIN, 16));
		jbutton_xacnhan.setBounds(219, 437, 165, 41);
		contentPane.add(jbutton_xacnhan);
		
		JButton jbutton_huybo = new JButton("Hủy bỏ");
		jbutton_huybo.setForeground(Color.WHITE);
		jbutton_huybo.setFont(new Font("Arial", Font.PLAIN, 16));
		jbutton_huybo.setBackground(new Color(255, 0, 0));
		jbutton_huybo.setBounds(448, 437, 165, 41);
		contentPane.add(jbutton_huybo);
		
		this.setVisible(true);
		
	}
}
