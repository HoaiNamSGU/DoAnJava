package view;

import java.awt.Color;
import java.awt.FlowLayout;
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

import model.XaPhuong;

public class SuaCuaHang extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField_MaCH;
	public JTextField textField_TenCH;
	public JTextField textField_SDT;
	public JTextField textField_DiaChi;
	public JComboBox<Object> comboBox_QuanHuyen;
	public JButton Button_HuyBo;
	public JButton Button_XacNhan;
	public JComboBox<Object> comboBox_XaPhuong;
	public JPanel panel_Button;
	public JComboBox<Object> comboBox_TPHO;
	public JLabel Label_DiaChi;
	public JPanel panel_Title_DiaChi;
	public JLabel lblSinThoii;
	public JPanel panel_Title_SDT;
	public JLabel Label_TenCh;
	public JPanel panel_Title_TenCH;
	public JLabel Label_MaCH;
	public JPanel panel_Title_SuaCH;
	public JLabel Label_SuaCH;
	public JPanel panel_Title_MaCH;
	public String[]ThanhPho = { "TP HCM" };
	
	public String[] Quan_Huyen = { "Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8",
			"Quận 9", "Quận 10", "Quận 11", "Quận 12", "Quận Thủ Đức", "Quận Gò Vấp", "Quận Bình Thạnh",
			"Quận Tân Bình", "Quận Tân Phú", "Quận Phú Nhuận", "Quận Bình Tân", "Huyện Củ Chi", "Huyện Bình Chánh",
			"Huyện Nhà Bè", "Huyện Cần Giờ" };
	
	public String[] Xa_Phuong= {};
	
	public SuaCuaHang() {
		super("Thêm Cửa Hàng");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 460);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_Title_SuaCH = new JPanel();
		panel_Title_SuaCH.setBounds(5, 5, 401, 43);
		panel_Title_SuaCH.setBackground(new Color(0, 128, 192));
		contentPane.add(panel_Title_SuaCH);
		panel_Title_SuaCH.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Label_SuaCH = new JLabel("Thêm Cửa Hàng");
		Label_SuaCH.setHorizontalAlignment(SwingConstants.CENTER);
		Label_SuaCH.setForeground(Color.WHITE);
		Label_SuaCH.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_Title_SuaCH.add(Label_SuaCH);

		panel_Title_MaCH = new JPanel();
		panel_Title_MaCH.setBounds(5, 53, 401, 71);
		contentPane.add(panel_Title_MaCH);
		panel_Title_MaCH.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		Label_MaCH = new JLabel("Mã Cửa Hàng");
		Label_MaCH.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_MaCH.setHorizontalAlignment(SwingConstants.LEFT);
		Label_MaCH.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Title_MaCH.add(Label_MaCH);

		textField_MaCH = new JTextField();
		textField_MaCH.setHorizontalAlignment(SwingConstants.LEFT);
		textField_MaCH.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Title_MaCH.add(textField_MaCH);
		textField_MaCH.setColumns(18);

		panel_Title_TenCH = new JPanel();
		panel_Title_TenCH.setBounds(5, 129, 401, 62);
		contentPane.add(panel_Title_TenCH);
		panel_Title_TenCH.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Label_TenCh = new JLabel("Tên Cửa Hàng");
		Label_TenCh.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_TenCh.setHorizontalAlignment(SwingConstants.LEFT);
		Label_TenCh.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Title_TenCH.add(Label_TenCh);

		textField_TenCH = new JTextField();
		textField_TenCH.setHorizontalAlignment(SwingConstants.LEFT);
		textField_TenCH.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_TenCH.setColumns(18);
		panel_Title_TenCH.add(textField_TenCH);

		panel_Title_SDT = new JPanel();
		panel_Title_SDT.setBounds(5, 196, 401, 62);
		contentPane.add(panel_Title_SDT);
		panel_Title_SDT.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblSinThoii = new JLabel("Số Điện Thoại ");
		lblSinThoii.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSinThoii.setHorizontalAlignment(SwingConstants.LEFT);
		lblSinThoii.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Title_SDT.add(lblSinThoii);

		textField_SDT = new JTextField();
		textField_SDT.setHorizontalAlignment(SwingConstants.LEFT);
		textField_SDT.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_SDT.setColumns(18);
		panel_Title_SDT.add(textField_SDT);

		panel_Title_DiaChi = new JPanel();
		panel_Title_DiaChi.setBounds(5, 263, 401, 106);
		contentPane.add(panel_Title_DiaChi);
		panel_Title_DiaChi.setLayout(null);

		Label_DiaChi = new JLabel("Địa Chỉ");
		Label_DiaChi.setBounds(10, 5, 121, 22);
		Label_DiaChi.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_DiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		Label_DiaChi.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Title_DiaChi.add(Label_DiaChi);

		textField_DiaChi = new JTextField();
		textField_DiaChi.setBounds(134, 2, 257, 28);
		textField_DiaChi.setToolTipText("");
		textField_DiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		textField_DiaChi.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_DiaChi.setColumns(18);
		panel_Title_DiaChi.add(textField_DiaChi);

		
		comboBox_TPHO = new JComboBox<Object>(ThanhPho);
		comboBox_TPHO.setBounds(240, 74, 151, 28);
		comboBox_TPHO.setBackground(new Color(255, 255, 255));
		comboBox_TPHO.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Title_DiaChi.add(comboBox_TPHO);

		comboBox_QuanHuyen = new JComboBox<Object>(Quan_Huyen);
		comboBox_QuanHuyen.setBounds(10, 74, 220, 28);
		comboBox_QuanHuyen.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Title_DiaChi.add(comboBox_QuanHuyen);
		//?????
		Xa_Phuong=ChangeXaPhuong();
		comboBox_XaPhuong = new JComboBox<Object>(Xa_Phuong);
		comboBox_XaPhuong.setBounds(10, 38, 381, 30);
		comboBox_XaPhuong.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Title_DiaChi.add(comboBox_XaPhuong);

		panel_Button = new JPanel();
		panel_Button.setBounds(5, 380, 401, 48);
		contentPane.add(panel_Button);

		Button_XacNhan = new JButton("Xác Nhận");
		Button_XacNhan.setBackground(new Color(0, 128, 192));
		Button_XacNhan.setForeground(new Color(255, 255, 255));
		Button_XacNhan.setFont(new Font("Arial", Font.PLAIN, 18));
		Button_XacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_Button.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_Button.add(Button_XacNhan);

		Button_HuyBo = new JButton("Hủy Bỏ");
		Button_HuyBo.setForeground(new Color(255, 255, 255));
		Button_HuyBo.setBackground(new Color(255, 0, 0));
		Button_HuyBo.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Button.add(Button_HuyBo);

		this.setVisible(true);
		this.setResizable(false);
	}

	public String[] ChangeXaPhuong() {
		try {
			XaPhuong XaPhuong = new XaPhuong();
			String quan = (String) comboBox_QuanHuyen.getSelectedItem();
			String[] Xa_Phuong = XaPhuong.getxaPhuongMap().get(CuaHangView.chuyenTenQuanHuyenThanhTenBien(quan));

			return Xa_Phuong;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void updateComBoBox_XaPhuong() {
		panel_Title_DiaChi.remove(comboBox_XaPhuong);

		// Tạo lại comboBox_XaPhuong và cập nhật dữ liệu mới
		comboBox_XaPhuong = new JComboBox<Object>(ChangeXaPhuong());
		comboBox_XaPhuong.setBounds(10, 38, 381, 30);
		comboBox_XaPhuong.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Title_DiaChi.add(comboBox_XaPhuong);

		// Yêu cầu panel_Title_DiaChi cập nhật lại giao diện
		panel_Title_DiaChi.revalidate();
		panel_Title_DiaChi.repaint(); // Có thể cần repaint() để hiển thị ngay lập tức
	}

}
