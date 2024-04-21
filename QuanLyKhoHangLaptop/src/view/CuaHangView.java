package view;

import java.awt.Color;
import java.awt.Font;
import java.text.Normalizer;
import java.util.ArrayList;

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

import controller.CuaHangActionListener;
import controller.CuaHangMouseListener;
import controller.mainActionlistener;
import dao.CuaHangDAO;
import img.Source;
import model.CuaHang;
import model.XaPhuong;

public class CuaHangView extends JPanel {

	public static final long serialVersionUID = 1L;
	public Object[][] data;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scrollPane;
	public JComboBox<Object> comboBox_search_XaPhuong;
	public JTextField textField_Search;
	public JButton jbutton_Sreach;
	public JButton jbutton_refesh;
	public JComboBox<Object> comboBox_search_QuanHuyen;
	public JComboBox<Object> comboBox_search_ThanhPho;
	public JPanel panel_border_timKiem;
	private CuaHangActionListener CH_ac;
	private mainActionlistener ac;
	public Source source = new Source();
	/**
	 * Create the panel.
	 */
	public CuaHangView() {
		this.setBounds(0, 0, 1200, 770);
		setLayout(null);
		
		CH_ac = new CuaHangActionListener(this);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 1180, 569);
		this.add(scrollPane);

		table = new JTable();
		table = CuaHang();
		
		scrollPane.setViewportView(table);
		JPanel panel_border_chucNang = new JPanel();
		panel_border_chucNang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chức năng",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_chucNang.setBounds(10, 10, 421, 81);
		this.add(panel_border_chucNang);
		panel_border_chucNang.setLayout(null);

		JLabel jlabel_them = new JLabel("Thêm", source.icon_add, JLabel.CENTER);
		jlabel_them.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_them.setBounds(10, 21, 44, 56);
		jlabel_them.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_them.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_them);

		
		JLabel jlabel_sua = new JLabel("Sửa", source.icon_pencil, JLabel.CENTER);
		jlabel_sua.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_sua.setBounds(109, 21, 59, 56);
		jlabel_sua.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_sua.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_sua);

		
		JLabel jlabel_xoa = new JLabel("Xóa", source.icon_remove, JLabel.CENTER);
		jlabel_xoa.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xoa.setBounds(67, 21, 45, 56);
		jlabel_xoa.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xoa.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xoa);

		
		JLabel jlabel_xemCT = new JLabel("Xem chi tiết", source.icon_eye, JLabel.CENTER);
		jlabel_xemCT.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xemCT.setBounds(165, 21, 68, 56);
		jlabel_xemCT.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xemCT.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xemCT);

		
		JLabel jlabel_nhapExcel = new JLabel("Nhập Excel", source.icon_Excel, JLabel.CENTER);
		jlabel_nhapExcel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_nhapExcel.setBounds(265, 21, 68, 56);
		jlabel_nhapExcel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_nhapExcel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_nhapExcel);

		
		JLabel jlabel_Excel = new JLabel("Xuất Excel", source.icon_Excel, JLabel.CENTER);
		jlabel_Excel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_Excel.setBounds(343, 21, 68, 56);
		jlabel_Excel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_Excel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_Excel);

		panel_border_timKiem = new JPanel();
		panel_border_timKiem.setLayout(null);
		panel_border_timKiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tìm kiếm",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_timKiem.setBounds(566, 10, 624, 116);
		this.add(panel_border_timKiem);

		ac = new mainActionlistener(this);
		
		String[] ThanhPho = { "TP HCM" };
		comboBox_search_ThanhPho = new JComboBox<Object>(ThanhPho);
		comboBox_search_ThanhPho.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search_ThanhPho.setBackground(Color.WHITE);
		comboBox_search_ThanhPho.setBounds(410, 75, 100, 21);
		panel_border_timKiem.add(comboBox_search_ThanhPho);

		String[] Quan_Huyen = { "Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9",
                "Quận 10", "Quận 11", "Quận 12", "Quận Thủ Đức", "Quận Gò Vấp", "Quận Bình Thạnh", "Quận Tân Bình", 
                "Quận Tân Phú", "Quận Phú Nhuận", "Quận Bình Tân", "Huyện Củ Chi", "Huyện Bình Chánh", "Huyện Nhà Bè", 
                "Huyện Cần Giờ" };

		comboBox_search_QuanHuyen = new JComboBox<Object>(Quan_Huyen);
		comboBox_search_QuanHuyen.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search_QuanHuyen.setBackground(Color.WHITE);
		comboBox_search_QuanHuyen.setBounds(250, 75, 150, 21);
		panel_border_timKiem.add(comboBox_search_QuanHuyen);
		
		String[] Xa_Phuong = ChangeXaPhuong();
		comboBox_search_XaPhuong = new JComboBox<Object>(Xa_Phuong);
		comboBox_search_XaPhuong.addActionListener(ac);
		comboBox_search_XaPhuong.setBackground(new Color(255, 255, 255));
		comboBox_search_XaPhuong.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search_XaPhuong.setBounds(10, 75, 230, 21);
		panel_border_timKiem.add(comboBox_search_XaPhuong);
			

		textField_Search = new JTextField();
		textField_Search.setBounds(10, 31, 500, 33);
		panel_border_timKiem.add(textField_Search);
		textField_Search.setColumns(10);

		jbutton_Sreach = new JButton("Tìm kiếm");
		jbutton_Sreach.setFont(new Font("Arial", Font.PLAIN, 11));
		jbutton_Sreach.addActionListener(ac);
		jbutton_Sreach.setBackground(new Color(255, 255, 255));
		jbutton_Sreach.setBounds(519, 31, 95, 33);
		panel_border_timKiem.add(jbutton_Sreach);

		jbutton_refesh = new JButton(source.icon_refresh);
		jbutton_refesh.setBackground(new Color(255, 255, 255));
		jbutton_refesh.setBounds(519, 75, 95, 21);
		panel_border_timKiem.add(jbutton_refesh);

		// Xử lý các sự kiện chuột và phím
		CuaHangMouseListener mouse = new CuaHangMouseListener(this);
		jlabel_them.addMouseListener(mouse);
		comboBox_search_QuanHuyen.addActionListener(CH_ac);
		this.setVisible(true);

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
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(400);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		return table;
	}


	public static String chuyenTenQuanHuyenThanhTenBien(String tenQuanHuyen) {
		// Loại bỏ dấu và chuyển thành chữ viết thường
		String tenKhongDau = removeDiacritics(tenQuanHuyen);

		// Loại bỏ các từ "Quận" và "Huyện"
		tenKhongDau = tenKhongDau.replaceAll("Quan", "quan");
		tenKhongDau = tenKhongDau.replaceAll("Huyen", "huyen");

		// Loại bỏ khoảng trắng và dấu cách
		tenKhongDau = tenKhongDau.trim().replace(" ", "");

		return tenKhongDau;
	}
	
	// Loại bỏ dấu và chuyển thành chữ viết thường
	public static String removeDiacritics(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return str;
	}
	public String[] ChangeXaPhuong() {
	    try {
	        XaPhuong XaPhuong = new XaPhuong();
	        String quan = (String) comboBox_search_QuanHuyen.getSelectedItem();
	        String[] Xa_Phuong = XaPhuong.getxaPhuongMap().get(chuyenTenQuanHuyenThanhTenBien(quan));
	        
	        return Xa_Phuong;
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}
	public void updateComBoBox_XaPhuong() {
		panel_border_timKiem.remove(comboBox_search_XaPhuong);;
        
        // Tạo lại comboBox_XaPhuong và cập nhật dữ liệu mới
		comboBox_search_XaPhuong = new JComboBox<Object>(ChangeXaPhuong());
		comboBox_search_XaPhuong.addActionListener(ac);
		comboBox_search_XaPhuong.setBackground(new Color(255, 255, 255));
		comboBox_search_XaPhuong.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search_XaPhuong.setBounds(10, 75, 200, 21);
        // Thêm comboBox_XaPhuong vào panel_Title_DiaChi
		panel_border_timKiem.add(comboBox_search_XaPhuong);
        
        // Yêu cầu panel_Title_DiaChi cập nhật lại giao diện
        panel_border_timKiem.revalidate();
        panel_border_timKiem.repaint(); // Có thể cần repaint() để hiển thị ngay lập tức
	}


}
