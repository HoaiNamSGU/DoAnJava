package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Laptop;

import javax.swing.SwingConstants;

public class SuaSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField jtextField_masanpham;
	public JTextField jtextField_tensanpham;
	public JTextField jtextField_CPU;
	public JTextField jtextField_GPU;
	public JTextField jtextField_manhinh;
	public JTextField jtextField_Hang;
	public JTextField jtextField_hedieuhanh;
	public JTextField jtextField_soluong;
	public JTextField jtextField_gia;
	public JButton jbutton_xacnhan;
	public JButton jbutton_huybo;
	public JComboBox comboBox_Rom;
	public JComboBox comboBox_Ram;
	public JComboBox comboBox_Nam;
	public JButton button_left;
	public JButton button_right;

	
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
		this.setTitle("Sửa sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 835, 539);
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
		
		JLabel lblNewLabel = new JLabel("Sửa sản phẩm mới");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
		jlabel_CPU.setBounds(331, 74, 106, 24);
		contentPane.add(jlabel_CPU);
		
		jtextField_CPU = new JTextField();
		jtextField_CPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_CPU.setColumns(10);
		jtextField_CPU.setBounds(331, 99, 178, 30);
		contentPane.add(jtextField_CPU);
		
		JLabel jlabel_GPU = new JLabel("GPU");
		jlabel_GPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_GPU.setBounds(331, 159, 106, 24);
		contentPane.add(jlabel_GPU);
		
		jtextField_GPU = new JTextField();
		jtextField_GPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_GPU.setColumns(10);
		jtextField_GPU.setBounds(331, 184, 178, 30);
		contentPane.add(jtextField_GPU);
		
		JLabel jlabel_Ram = new JLabel("Ram");
		jlabel_Ram.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_Ram.setBounds(639, 74, 53, 24);
		contentPane.add(jlabel_Ram);
		
		jtextField_manhinh = new JTextField();
		jtextField_manhinh.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_manhinh.setColumns(10);
		jtextField_manhinh.setBounds(37, 374, 178, 30);
		contentPane.add(jtextField_manhinh);
		
		jtextField_Hang = new JTextField();
		jtextField_Hang.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_Hang.setColumns(10);
		jtextField_Hang.setBounds(331, 275, 178, 30);
		contentPane.add(jtextField_Hang);
		
		jtextField_hedieuhanh = new JTextField();
		jtextField_hedieuhanh.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_hedieuhanh.setColumns(10);
		jtextField_hedieuhanh.setBounds(37, 275, 178, 30);
		contentPane.add(jtextField_hedieuhanh);
		
		jtextField_soluong = new JTextField();
		jtextField_soluong.setText("0");
		jtextField_soluong.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_soluong.setColumns(10);
		jtextField_soluong.setBounds(681, 374, 47, 30);
		contentPane.add(jtextField_soluong);
		
		jtextField_gia = new JTextField();
		jtextField_gia.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_gia.setText("0");
		jtextField_gia.setColumns(10);
		jtextField_gia.setBounds(331, 374, 178, 30);
		contentPane.add(jtextField_gia);
		
		JLabel jlabel_Rom = new JLabel("Rom");
		jlabel_Rom.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_Rom.setBounds(639, 159, 106, 24);
		contentPane.add(jlabel_Rom);
		
		JLabel jlabel_manhinh = new JLabel("Màn hình");
		jlabel_manhinh.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_manhinh.setBounds(37, 345, 106, 24);
		contentPane.add(jlabel_manhinh);
		
		JLabel jlabel_hang = new JLabel("Hãng");
		jlabel_hang.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_hang.setBounds(331, 247, 106, 24);
		contentPane.add(jlabel_hang);
		
		JLabel jlabel_hedieuhanh = new JLabel("Hệ điều hành");
		jlabel_hedieuhanh.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_hedieuhanh.setBounds(37, 247, 106, 24);
		contentPane.add(jlabel_hedieuhanh);
		
		JLabel jlabel_namsanxuat = new JLabel("Năm sản xuất");
		jlabel_namsanxuat.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_namsanxuat.setBounds(639, 247, 106, 24);
		contentPane.add(jlabel_namsanxuat);
		
		JLabel jlabel_soluong = new JLabel("Số lượng");
		jlabel_soluong.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_soluong.setBounds(639, 345, 106, 24);
		contentPane.add(jlabel_soluong);
		
		JLabel jlabel_gia = new JLabel("Giá");
		jlabel_gia.setFont(new Font("Arial", Font.PLAIN, 16));
		jlabel_gia.setBounds(331, 345, 106, 24);
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
		
		String Ram[] = {"4 GB", "8 GB", "16 GB","32 GB","64 GB", "128 GB", "256 GB"};
		comboBox_Ram = new JComboBox(Ram);
		comboBox_Ram.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_Ram.setBounds(639, 98, 130, 30);
		comboBox_Ram.setBackground(Color.WHITE);
		contentPane.add(comboBox_Ram);
		
		String Rom [] = {"64 GB","128 GB","256 GB","512 GB","1 TB","2 TB", "4 TB"};
		comboBox_Rom = new JComboBox(Rom);
		comboBox_Rom.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_Rom.setBounds(639, 183, 130, 30);
		comboBox_Rom.setBackground(Color.WHITE);
		contentPane.add(comboBox_Rom);
		
		String Nam[] = {"2024","2023","2022","2021","2020","2019","2018"};
		comboBox_Nam = new JComboBox(Nam);
		comboBox_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_Nam.setBounds(639, 272, 130, 30);
		comboBox_Nam.setBackground(Color.WHITE);
		contentPane.add(comboBox_Nam);
		
		button_left = new JButton("");
		button_left.setIcon(new ImageIcon("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\minus.png"));
		button_left.setBounds(639, 374, 36, 30);
		contentPane.add(button_left);
		
		button_right = new JButton();
		ImageIcon icon_right = new ImageIcon("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\dau_cong.png");
		button_right.setIcon(icon_right);
		button_right.setBounds(733, 374, 36, 30);
		contentPane.add(button_right);
		
		
		
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public String getText(JTextField textfield)
	{
		return textfield.getText();
	}
	
	public void setJtextField(Laptop lt)
	{
		jtextField_tensanpham.setText(lt.getTenLaptop());
		jtextField_masanpham.setText(lt.getMaLaptop());
		jtextField_CPU.setText(lt.getCPU());
		jtextField_GPU.setText(lt.getGPU());
		jtextField_Hang.setText(lt.getHang());
		jtextField_hedieuhanh.setText(lt.getHeDieuHanh());
		jtextField_manhinh.setText(lt.getManHinh());
		jtextField_soluong.setText(lt.getSoLuong()+"");
		DecimalFormat df = new DecimalFormat("#");
	    String formattedNumber = df.format(lt.getGia());
		jtextField_gia.setText(formattedNumber);
		comboBox_Ram.setSelectedItem(lt.getRam());
		comboBox_Rom.setSelectedItem(lt.getRom());
		comboBox_Nam.setSelectedItem(lt.getNamSanXuat()+"");
	}
}
