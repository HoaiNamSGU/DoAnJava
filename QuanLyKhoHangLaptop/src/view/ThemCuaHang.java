package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ThemCuaHang extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField_MaCH;
	public JTextField textField_TenCH;
	public JTextField textField_SDT;
	public JTextField textField_DiaChi;
	public JComboBox comboBox_QuanHuyen;
	public JButton Button_HuyBo;
	public JButton Button_XacNhan;
	public JComboBox comboBox_XaPhuong;
	public JPanel panel_Button;
	public JComboBox comboBox_TPHO;
	public JLabel Label_DiaChi;
	public JPanel panel_Title_DiaChi;
	public JLabel Label_SDT;
	public JPanel panel_Title_SDT;
	public JLabel Label_TenCh;
	public JPanel panel_Title_TenCH;
	public JLabel Label_MaCH;
	public JPanel panel_Title_ThemCH;
	public JLabel Label_ThemCH;
	public JPanel panel_Title_MaCH;

	public ThemCuaHang() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_Title_ThemCH = new JPanel();
		panel_Title_ThemCH.setBackground(new Color(0, 128, 192));
		panel_Title_ThemCH.setBounds(0, 0, 784, 48);
		contentPane.add(panel_Title_ThemCH);
		panel_Title_ThemCH.setLayout(null);
		
		Label_ThemCH = new JLabel("Thêm Cửa Hàng");
		Label_ThemCH.setHorizontalAlignment(SwingConstants.CENTER);
		Label_ThemCH.setForeground(Color.WHITE);
		Label_ThemCH.setFont(new Font("Arial", Font.PLAIN, 20));
		Label_ThemCH.setBounds(0, 0, 385, 48);
		panel_Title_ThemCH.add(Label_ThemCH);
		
		panel_Title_MaCH = new JPanel();
		panel_Title_MaCH.setBounds(0, 40, 384, 67);
		contentPane.add(panel_Title_MaCH);
		panel_Title_MaCH.setLayout(null);
		
		textField_MaCH = new JTextField();
		textField_MaCH.setHorizontalAlignment(SwingConstants.LEFT);
		textField_MaCH.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_MaCH.setBounds(10, 42, 364, 25);
		panel_Title_MaCH.add(textField_MaCH);
		textField_MaCH.setColumns(10);
		
		Label_MaCH = new JLabel("Mã Cửa Hàng");
		Label_MaCH.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_MaCH.setHorizontalAlignment(SwingConstants.LEFT);
		Label_MaCH.setFont(new Font("Arial", Font.PLAIN, 18));
		Label_MaCH.setBounds(10, 11, 364, 27);
		panel_Title_MaCH.add(Label_MaCH);
		
		panel_Title_TenCH = new JPanel();
		panel_Title_TenCH.setLayout(null);
		panel_Title_TenCH.setBounds(0, 100, 384, 67);
		contentPane.add(panel_Title_TenCH);
		
		textField_TenCH = new JTextField();
		textField_TenCH.setHorizontalAlignment(SwingConstants.LEFT);
		textField_TenCH.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_TenCH.setColumns(10);
		textField_TenCH.setBounds(10, 42, 364, 25);
		panel_Title_TenCH.add(textField_TenCH);
		
		Label_TenCh = new JLabel("Tên Cửa Hàng");
		Label_TenCh.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_TenCh.setHorizontalAlignment(SwingConstants.LEFT);
		Label_TenCh.setFont(new Font("Arial", Font.PLAIN, 18));
		Label_TenCh.setBounds(10, 11, 364, 27);
		panel_Title_TenCH.add(Label_TenCh);
		
		panel_Title_SDT = new JPanel();
		panel_Title_SDT.setLayout(null);
		panel_Title_SDT.setBounds(0, 160, 384, 67);
		contentPane.add(panel_Title_SDT);
		
		textField_SDT = new JTextField();
		textField_SDT.setHorizontalAlignment(SwingConstants.LEFT);
		textField_SDT.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(10, 42, 364, 25);
		panel_Title_SDT.add(textField_SDT);
		
		Label_SDT = new JLabel("Số Điện Thoại");
		Label_SDT.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_SDT.setHorizontalAlignment(SwingConstants.LEFT);
		Label_SDT.setFont(new Font("Arial", Font.PLAIN, 18));
		Label_SDT.setBounds(10, 11, 364, 27);
		panel_Title_SDT.add(Label_SDT);
		
		panel_Title_DiaChi = new JPanel();
		panel_Title_DiaChi.setLayout(null);
		panel_Title_DiaChi.setBounds(0, 220, 384, 105);
		contentPane.add(panel_Title_DiaChi);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setToolTipText("");
		textField_DiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		textField_DiaChi.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(10, 42, 364, 25);
		panel_Title_DiaChi.add(textField_DiaChi);
		
		Label_DiaChi = new JLabel("Địa Chỉ");
		Label_DiaChi.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_DiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		Label_DiaChi.setFont(new Font("Arial", Font.PLAIN, 18));
		Label_DiaChi.setBounds(10, 11, 364, 27);
		panel_Title_DiaChi.add(Label_DiaChi);
		
		String[] ThanhPho={"TP HCM"};
		comboBox_TPHO = new JComboBox(ThanhPho);
		comboBox_TPHO.setBackground(new Color(255, 255, 255));
		comboBox_TPHO.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_TPHO.setBounds(10, 72, 120, 22);
		panel_Title_DiaChi.add(comboBox_TPHO);
		
		String[] Quan= {"Quận 1", "Quận 12", "Thủ Đức", "Gò Vấp", "Bình Thạnh", "Tân Bình", "Tân Phú", "Phú Nhuận", "Quận 3", "Quận 10", "Quận 11", "Quận 4", "Quận 5", "Quận 6", "Quận 8", "Bình Tân", "Quận 7", "Củ Chi", "Bình Chánh", "Nhà Bè", "Cần Giờ"};
		comboBox_QuanHuyen = new JComboBox(Quan);
		comboBox_QuanHuyen.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_QuanHuyen.setBounds(132, 72, 120, 22);
		panel_Title_DiaChi.add(comboBox_QuanHuyen);
		
		comboBox_XaPhuong = new JComboBox();
		comboBox_XaPhuong.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_XaPhuong.setBounds(254, 72, 120, 22);
		panel_Title_DiaChi.add(comboBox_XaPhuong);
		
		panel_Button = new JPanel();
		panel_Button.setBounds(0, 352, 384, 48);
		contentPane.add(panel_Button);
		panel_Button.setLayout(null);
		
		Button_XacNhan = new JButton("Xác Nhận");
		Button_XacNhan.setBackground(new Color(0, 128, 192));
		Button_XacNhan.setForeground(new Color(255, 255, 255));
		Button_XacNhan.setFont(new Font("Arial", Font.PLAIN, 18));
		Button_XacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Button_XacNhan.setBounds(10, 0, 172, 48);
		panel_Button.add(Button_XacNhan);
		
		Button_HuyBo = new JButton("Hủy Bỏ");
		Button_HuyBo.setForeground(new Color(255, 255, 255));
		Button_HuyBo.setBackground(new Color(255, 0, 0));
		Button_HuyBo.setFont(new Font("Arial", Font.PLAIN, 18));
		Button_HuyBo.setBounds(202, 0, 172, 48);
		panel_Button.add(Button_HuyBo);
		this.setVisible(true);
		this.setResizable(false);
	}
}
