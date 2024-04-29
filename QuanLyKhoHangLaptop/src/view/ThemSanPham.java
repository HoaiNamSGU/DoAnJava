
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dao.LaptopDAO;
import model.Laptop;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;


public class ThemSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField jtextField_masanpham;
	public JTextField jtextField_tensanpham;
	public JTextField jtextField_CPU;
	public JTextField jtextField_GPU;
	public JTextField jtextField_manhinh;
	public JTextField jtextField_Hang;
	public JTextField jtextField_hedieuhanh;
	public JTextField jtextField_gia;
	public JButton jbutton_xacnhan;
	public JButton jbutton_huybo;
	public JComboBox<String> comboBox_Rom;
	public JComboBox<String> comboBox_Ram;
	public JComboBox<String> comboBox_Nam;
	public JComboBox<String> comboBox_MaNCC;
	public JLabel lblNewLabel;
	private JPanel panel_center;
	private JPanel panel_South;
	private JPanel panel_MaLaptop;
	private JPanel panel_CPU;
	private JPanel panel_Ram;
	private JPanel panel_TenLap;
	private JPanel panel_GPU;
	private JPanel panel_Rom;
	private JPanel panel_HDH;
	private JPanel panel_Hang;
	private JPanel panel_NamSX;
	private JPanel panel_ManHinh;
	private JPanel panel_Gia;
	private JPanel panel_MaNCC;

	public ThemSanPham() {
		this.setTitle("Thêm sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 835, 539);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel jpanel_title = new JPanel();
		jpanel_title.setBackground(new Color(0, 128, 192));
		contentPane.add(jpanel_title,BorderLayout.NORTH);
		jpanel_title.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Thêm sản phẩm mới");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		jpanel_title.add(lblNewLabel);
	
		
		JLabel jlabel_masanpham = new JLabel("Mã sản phẩm");
		jlabel_masanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_masanpham);
		
		jtextField_masanpham = new JTextField();
		jtextField_masanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jtextField_masanpham);
		jtextField_masanpham.setColumns(10);
		
		JLabel jlabel_tensanpham = new JLabel("Tên sản phẩm");
		jlabel_tensanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_tensanpham);
		
		jtextField_tensanpham = new JTextField();
		jtextField_tensanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_tensanpham.setColumns(10);
		//contentPane.add(jtextField_tensanpham);
		
		JLabel jlabel_CPU = new JLabel("CPU");
		jlabel_CPU.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_CPU);
		
		jtextField_CPU = new JTextField();
		jtextField_CPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_CPU.setColumns(10);
		//contentPane.add(jtextField_CPU);
		
		JLabel jlabel_GPU = new JLabel("GPU");
		jlabel_GPU.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_GPU);
		
		jtextField_GPU = new JTextField();
		jtextField_GPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_GPU.setColumns(10);
		//contentPane.add(jtextField_GPU);
		
		JLabel jlabel_Ram = new JLabel("Ram");
		jlabel_Ram.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_Ram);
		
		jtextField_manhinh = new JTextField();
		jtextField_manhinh.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_manhinh.setColumns(10);
		//contentPane.add(jtextField_manhinh);
		
		jtextField_Hang = new JTextField();
		jtextField_Hang.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_Hang.setColumns(10);
		//contentPane.add(jtextField_Hang);
		
		jtextField_hedieuhanh = new JTextField();
		jtextField_hedieuhanh.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_hedieuhanh.setColumns(10);
		//contentPane.add(jtextField_hedieuhanh);
		
		jtextField_gia = new JTextField();
		jtextField_gia.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_gia.setText("0");
		jtextField_gia.setColumns(10);
		//contentPane.add(jtextField_gia);
		
		JLabel jlabel_Rom = new JLabel("Rom");
		jlabel_Rom.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_Rom);
		
		JLabel jlabel_manhinh = new JLabel("Màn hình");
		jlabel_manhinh.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_manhinh);
		
		JLabel jlabel_hang = new JLabel("Hãng");
		jlabel_hang.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_hang);
		
		JLabel jlabel_hedieuhanh = new JLabel("Hệ điều hành");
		jlabel_hedieuhanh.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_hedieuhanh);
		
		JLabel jlabel_namsanxuat = new JLabel("Năm sản xuất");
		jlabel_namsanxuat.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_namsanxuat);
		
		JLabel jlabel_gia = new JLabel("Giá");
		jlabel_gia.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_gia);
		
		jbutton_xacnhan = new JButton("Xác nhận");
		jbutton_xacnhan.setForeground(new Color(255, 255, 255));
		jbutton_xacnhan.setBackground(new Color(0, 128, 192));
		jbutton_xacnhan.setFont(new Font("Arial", Font.PLAIN, 18));
		//contentPane.add(jbutton_xacnhan);
		
		jbutton_huybo = new JButton("Hủy bỏ");
		jbutton_huybo.setForeground(Color.WHITE);
		jbutton_huybo.setFont(new Font("Arial", Font.PLAIN, 18));
		jbutton_huybo.setBackground(Color.RED);
		//contentPane.add(jbutton_huybo);
		
		String Ram[] = {"4 GB", "8 GB", "16 GB","32 GB","64 GB", "128 GB", "256 GB"};
		comboBox_Ram = new JComboBox<String>(Ram);
		comboBox_Ram.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_Ram.setBackground(Color.WHITE);
		//contentPane.add(comboBox_Ram);
		
		String Rom [] = {"64 GB","128 GB","256 GB","512 GB","1 TB","2 TB", "4 TB"};
		comboBox_Rom = new JComboBox<String>(Rom);
		comboBox_Rom.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_Rom.setBackground(Color.WHITE);
		//contentPane.add(comboBox_Rom);
		
		String Nam[] = {"2024","2023","2022","2021","2020","2019","2018"};
		comboBox_Nam = new JComboBox<String>(Nam);
		comboBox_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_Nam.setBackground(Color.WHITE);
		//contentPane.add(comboBox_Nam);
		
		JLabel jlabel_gia_1 = new JLabel("Mã nhà cung cấp");
		jlabel_gia_1.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jlabel_gia_1);
		
		
		comboBox_MaNCC = new JComboBox<String>();
		comboBox_MaNCC = addItem("MaNhaCungCap");
		comboBox_MaNCC.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_MaNCC.setBackground(Color.WHITE);
		//contentPane.add(comboBox_MaNCC);
		
		panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(4, 3, 20, 20));
		
		panel_MaLaptop = new JPanel();
		panel_MaLaptop.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_MaLaptop);
		panel_MaLaptop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_MaLaptop.add(jlabel_masanpham);
		panel_MaLaptop.add(jtextField_masanpham);
		
		
		panel_CPU = new JPanel();
		panel_CPU.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_CPU);
		panel_CPU.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_CPU.add(jlabel_CPU);
		panel_CPU.add(jtextField_CPU);
		
		
		panel_Ram = new JPanel();
		panel_Ram.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_Ram);
		panel_Ram.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_Ram.add(jlabel_Ram);
		panel_Ram.add(comboBox_Ram);
		
		
		panel_TenLap = new JPanel();
		panel_TenLap.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_TenLap);
		panel_TenLap.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_TenLap.add(jlabel_tensanpham);
		panel_TenLap.add(jtextField_tensanpham);
		
		
		panel_GPU = new JPanel();
		panel_GPU.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_GPU);
		panel_GPU.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_GPU.add(jlabel_GPU);
		panel_GPU.add(jtextField_GPU);
		
		panel_Rom = new JPanel();
		panel_Rom.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_Rom);
		panel_Rom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_Rom.add(jlabel_Rom);
		panel_Rom.add(comboBox_Rom);
		
		panel_HDH = new JPanel();
		panel_HDH.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_HDH);
		panel_HDH.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_HDH.add(jlabel_hedieuhanh);
		panel_HDH.add(jtextField_hedieuhanh);
		
		panel_Hang = new JPanel();
		panel_Hang.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_Hang);
		panel_Hang.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_Hang.add(jlabel_hang);
		panel_Hang.add(jtextField_Hang);
		
		
		panel_NamSX = new JPanel();
		panel_NamSX.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_NamSX);
		panel_NamSX.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_NamSX.add(jlabel_namsanxuat);
		panel_NamSX.add(comboBox_Nam);
		
		panel_ManHinh = new JPanel();
		panel_ManHinh.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_ManHinh);
		panel_ManHinh.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_ManHinh.add(jlabel_manhinh);
		panel_ManHinh.add(jtextField_manhinh);
		
		panel_Gia = new JPanel();
		panel_Gia.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_Gia);
		panel_Gia.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_Gia.add(jlabel_gia);
		panel_Gia.add(jtextField_gia);
		
		panel_MaNCC = new JPanel();
		panel_MaNCC.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_MaNCC);
		panel_MaNCC.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_MaNCC.add(jlabel_gia_1);
		panel_MaNCC.add(comboBox_MaNCC);
		
		panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		panel_South.add(jbutton_xacnhan);
		panel_South.add(jbutton_huybo);
		
		this.setVisible(true);
		//this.setResizable(false);
	}
	
	public String getText(JTextField textfield)
	{
		return textfield.getText();
	}
	
	public JComboBox<String> addItem(String s)
	{
		ArrayList<String> arr = LaptopDAO.getintance().getColumn(s);
		JComboBox<String> tmp = new JComboBox<String>();
		for (String string : arr) {
			tmp.addItem(string);
		}
		return tmp;
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
		DecimalFormat df = new DecimalFormat("#");
	    String formattedNumber = df.format(lt.getGia());
		jtextField_gia.setText(formattedNumber);
		comboBox_Ram.setSelectedItem(lt.getRam());
		comboBox_Rom.setSelectedItem(lt.getRom());
		comboBox_Nam.setSelectedItem(lt.getNamSanXuat()+"");
		comboBox_MaNCC.setSelectedItem(lt.getMaNhaCungCap());
	}
}




