package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
import javax.swing.table.JTableHeader;

import controller.LaptopActionListener;
import controller.LaptopMouseListener;
import dao.LaptopDAO;
import model.Laptop;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Laptop_view extends JPanel {

	public static final long serialVersionUID = 1L;
	public JButton jbutton_refesh;
	public Object data[][];
	public JTable table;
	public DefaultTableModel model;
	public JScrollPane scrollPane;
	public JComboBox<String> comboBox_search;
	public JButton jbutton_Sreach;
	public JComboBox<String> comboBox_Gia;
	public JComboBox<String> comboBox_Rom;
	public JComboBox<String> comboBox_Ram;
	public JComboBox<String> comboBox_CPU;
	public JComboBox<String> comboBox_Hang;
	public JTextField textField;
	
	
	public Laptop_view() {
		this.setBounds(0, 0, 1189, 763);
		this.setLayout(null);
		
		LaptopActionListener ac = new LaptopActionListener(this);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 1169, 593);
		this.add(scrollPane);
		
		table = new JTable();
		table = SanPham();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 14));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		setKhoangCachTable();
		scrollPane.setViewportView(table);
		
		
		
		JPanel panel_border_chucNang = new JPanel();
		panel_border_chucNang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chức năng",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_chucNang.setBounds(10, 10, 421, 81);
		this.add(panel_border_chucNang);
		panel_border_chucNang.setLayout(null);

		ImageIcon icon_add = new ImageIcon(getClass().getResource("/img/plus.png"));
		JLabel jlabel_them = new JLabel("Thêm", icon_add, JLabel.CENTER);
		jlabel_them.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_them.setBounds(10, 21, 44, 56);
		jlabel_them.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_them.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_them);

		ImageIcon icon_pencil = new ImageIcon(getClass().getResource("/img/pencil.png"));
		JLabel jlabel_sua = new JLabel("Sửa", icon_pencil, JLabel.CENTER);
		jlabel_sua.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_sua.setBounds(109, 21, 59, 56);
		jlabel_sua.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_sua.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_sua);

		ImageIcon icon_remove = new ImageIcon(getClass().getResource("/img/remove.png"));
		JLabel jlabel_xoa = new JLabel("Xóa", icon_remove, JLabel.CENTER);
		jlabel_xoa.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xoa.setBounds(67, 21, 45, 56);
		jlabel_xoa.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xoa.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xoa);

		ImageIcon icon_eye = new ImageIcon(getClass().getResource("/img/eye.png"));
		JLabel jlabel_xemCT = new JLabel("Xem chi tiết", icon_eye, JLabel.CENTER);
		jlabel_xemCT.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xemCT.setBounds(165, 21, 68, 56);
		jlabel_xemCT.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xemCT.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xemCT);

		ImageIcon icon_nhapExcel = new ImageIcon(
				getClass().getResource("/img/nhapExcel.png"));
		JLabel jlabel_nhapExcel = new JLabel("Nhập Excel", icon_nhapExcel, JLabel.CENTER);
		jlabel_nhapExcel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_nhapExcel.setBounds(265, 21, 68, 56);
		jlabel_nhapExcel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_nhapExcel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_nhapExcel);

		ImageIcon icon_Excel = new ImageIcon(getClass().getResource("/img/xuatExcel.png"));
		JLabel jlabel_Excel = new JLabel("Xuất Excel", icon_Excel, JLabel.CENTER);
		jlabel_Excel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_Excel.setBounds(343, 21, 68, 56);
		jlabel_Excel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_Excel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_Excel);

		JPanel panel_border_timKiem = new JPanel();
		panel_border_timKiem.setLayout(null);
		panel_border_timKiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tìm kiếm",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_timKiem.setBounds(489, 10, 690, 137);
		this.add(panel_border_timKiem);
		
		
		
		
		String[] combo = { "Tất cả", "Windows", "MacOS"};
		comboBox_search = new JComboBox<String>(combo);
		comboBox_search.addActionListener(ac);
		comboBox_search.setBackground(new Color(255, 255, 255));
		comboBox_search.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search.setBounds(10, 36, 95, 21);
		comboBox_search.addActionListener(ac);
		panel_border_timKiem.add(comboBox_search);
				
		textField = new JTextField();
		textField.setBounds(131, 31, 343, 33);
		panel_border_timKiem.add(textField);
		textField.setColumns(10);

		jbutton_Sreach = new JButton("Tìm kiếm");
		jbutton_Sreach.addActionListener(ac);
		jbutton_Sreach.setBackground(new Color(255, 255, 255));
		jbutton_Sreach.setBounds(573, 31, 107, 33);
		panel_border_timKiem.add(jbutton_Sreach);

		ImageIcon icon_refresh = new ImageIcon(getClass().getResource("/img/arrow.png"));
		jbutton_refesh = new JButton(icon_refresh);
		jbutton_refesh.addActionListener(ac);
		jbutton_refesh.setBackground(new Color(255, 255, 255));
		jbutton_refesh.setBounds(484, 31, 75, 33);
		panel_border_timKiem.add(jbutton_refesh);
				
				
		comboBox_Hang = new JComboBox<String>();
		comboBox_Hang = addItem("Hang");
		comboBox_Hang.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_Hang.setBackground(Color.WHITE);
		comboBox_Hang.setBounds(10, 100, 95, 21);
		comboBox_Hang.addActionListener(ac);
		panel_border_timKiem.add(comboBox_Hang);
				
		comboBox_CPU = new JComboBox<String>();
		comboBox_CPU = addItem("CPU");
		comboBox_CPU.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_CPU.setBackground(Color.WHITE);
		comboBox_CPU.setBounds(130, 100, 245, 21);
		comboBox_CPU.addActionListener(ac);
		panel_border_timKiem.add(comboBox_CPU);
				
		String ram[] = {"Tất cả","4 GB","8 GB","16 GB","32 GB","64 GB","128 GB"};
		comboBox_Ram = new JComboBox<String>(ram);
		comboBox_Ram.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_Ram.setBackground(Color.WHITE);
		comboBox_Ram.setBounds(393, 100, 81, 21);
		comboBox_Ram.addActionListener(ac);
		panel_border_timKiem.add(comboBox_Ram);
				
				
		String rom[] = {"Tất cả","256 GB","512 GB","1 TB","2 TB","4 TB"};
		comboBox_Rom = new JComboBox<String>(rom);
		comboBox_Rom.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_Rom.setBackground(Color.WHITE);
		comboBox_Rom.setBounds(484, 100, 75, 21);
		comboBox_Rom.addActionListener(ac);
		panel_border_timKiem.add(comboBox_Rom);
				
				
		String s[] = {"Tất cả","Dưới 10 triệu","10-15 triệu","15-20 triệu","20-30 triệu","30-50 triệu","Hơn 50 triệu"};
		comboBox_Gia = new JComboBox<String>(s);
		comboBox_Gia.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_Gia.setBackground(Color.WHITE);
		comboBox_Gia.setBounds(573, 100, 105, 21);
		comboBox_Gia.addActionListener(ac);
		panel_border_timKiem.add(comboBox_Gia);
		
		JLabel lblNewLabel = new JLabel("CPU");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(131, 74, 45, 26);
		panel_border_timKiem.add(lblNewLabel);
		
		JLabel lblRam = new JLabel("Ram");
		lblRam.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRam.setBounds(393, 74, 45, 27);
		panel_border_timKiem.add(lblRam);
		
		JLabel lblBNh = new JLabel("Bộ nhớ");
		lblBNh.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBNh.setBounds(484, 79, 64, 21);
		panel_border_timKiem.add(lblBNh);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGi.setBounds(575, 74, 45, 27);
		panel_border_timKiem.add(lblGi);
		
		JLabel lblHng = new JLabel("Hãng");
		lblHng.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHng.setBounds(10, 67, 95, 34);
		panel_border_timKiem.add(lblHng);
		
		LaptopMouseListener mouse = new LaptopMouseListener(this);
		jlabel_them.addMouseListener(mouse);
		jlabel_Excel.addMouseListener(mouse);
		jlabel_sua.addMouseListener(mouse);
		jlabel_nhapExcel.addMouseListener(mouse);
		jlabel_xoa.addMouseListener(mouse);
		jlabel_xemCT.addMouseListener(mouse);
		
		this.setVisible(true);
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
		String column[] = { "Id", "Tên laptop", "Số lượng", "Giá", "CPU", "Ram", "Bộ nhớ", "Hệ điều hành", "Mã nhà cung cấp"};
		model = new DefaultTableModel(data, column);
		table = new JTable(model);
		
		setKhoangCachTable();
		return table;
	}
	
	

	
	public void updateTableData( ArrayList<Laptop> listLaptop) {
	  
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
	    String column[] = { "Id", "Tên laptop", "Số lượng", "Giá", "CPU", "Ram", "Bộ nhớ", "Hệ điều hành","Mã nhà cung cấp" };
	    // Cập nhật mô hình của bảng
	    model.setDataVector(newData, column);
	    setKhoangCachTable();
	    // Cập nhật lại giao diện
	    this.revalidate();
	    this.repaint();
	}
	
	
	
	
	public void setKhoangCachTable()
	{
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
	
	public ArrayList<Laptop> select_search_laptop(ArrayList<Laptop> list,String s)
	{
		s=s.toUpperCase();
		ArrayList<Laptop> arr = new ArrayList<Laptop>();
		for (Laptop laptop : list) {
			String tmp = laptop.getMaLaptop()+" "+laptop.getTenLaptop()+" "+laptop.getCPU()+" "+laptop.getGPU()+" "+laptop.getRam()+" "
			    +laptop.getRom()+" "+laptop.getManHinh()+" "+laptop.getHeDieuHanh()+" "+laptop.getHang()+" "+laptop.getNamSanXuat()
			    +" "+laptop.getSoLuong()+" "+laptop.getGia();
			tmp=tmp.toUpperCase();
			if(tmp.indexOf(s)!=-1)
			{
				arr.add(laptop);
			}
		}
		return arr;
	}
	
	
	public JComboBox<String> addItem(String s)
	{
		ArrayList<String> arr = LaptopDAO.getintance().getColumn(s);
		JComboBox<String> tmp = new JComboBox<String>();
		tmp.addItem("Tất cả");
		for (String string : arr) {
			tmp.addItem(string);
		}
		return tmp;
	}
	
	
	public void update_form_comboBoxGia()
	{
		ArrayList<Laptop> laptop = LaptopDAO.getintance().selectAll();
		ArrayList<Laptop> lt = new ArrayList<Laptop>();
		if(comboBox_Gia.getSelectedIndex()==0)
		{
			updateTableData(laptop);
			lt = select_search_laptop(laptop, textField.getText());
			updateTableData(lt);
		}
		else if(comboBox_Gia.getSelectedIndex()==1)
		{
			
			for (Laptop laptop2 : laptop) {
				if(laptop2.getGia()<10000000)
				{
					System.out.println(laptop2.toString());
					lt.add(laptop2);
				}
			}
			updateTableData(lt);
			ArrayList<Laptop> lt3 = select_search_laptop(lt, textField.getText());
			updateTableData(lt3);
		}
		else if(comboBox_Gia.getSelectedIndex()==2)
		{
			for (Laptop laptop2 : laptop) {
				if(laptop2.getGia()<15000000 && laptop2.getGia()>=10000000)
				{
					lt.add(laptop2);
				}
			}
			updateTableData(lt);
			ArrayList<Laptop> lt3 = select_search_laptop(lt, textField.getText());
			updateTableData(lt3);
		}
		else if(comboBox_Gia.getSelectedIndex()==3)
		{
			for (Laptop laptop2 : laptop) {
				if(laptop2.getGia()<20000000 && laptop2.getGia()>=15000000)
				{
					lt.add(laptop2);
				}
			}
			updateTableData(lt);
			ArrayList<Laptop> lt3 = select_search_laptop(lt, textField.getText());
			updateTableData(lt3);
		}
		else if(comboBox_Gia.getSelectedIndex()==4)
		{
			for (Laptop laptop2 : laptop) {
				if(laptop2.getGia()>=20000000 && laptop2.getGia()<30000000)
				{
					lt.add(laptop2);
				}
			}
			updateTableData(lt);
			ArrayList<Laptop> lt3 = select_search_laptop(lt, textField.getText());
			updateTableData(lt3);
		}
		else if(comboBox_Gia.getSelectedIndex()==5)
		{
			for (Laptop laptop2 : laptop) {
				if(laptop2.getGia()>=30000000 && laptop2.getGia()<50000000)
				{
					lt.add(laptop2);
				}
			}
			updateTableData(lt);
			ArrayList<Laptop> lt3 = select_search_laptop(lt, textField.getText());
			updateTableData(lt3);
		}
		else if(comboBox_Gia.getSelectedIndex()==6)
		{
			for (Laptop laptop2 : laptop) {
				if(laptop2.getGia()>=50000000)
				{
					lt.add(laptop2);
				}
			}
			updateTableData(lt);
			ArrayList<Laptop> lt3 = select_search_laptop(lt, textField.getText());
			updateTableData(lt3);
		}
	}
	 
	
	public static void main(String[] args) {
		ArrayList<Laptop> arr = LaptopDAO.getintance().selectAll();
		for (Laptop string : arr) {
			System.out.println(string.toString());
		}
	}
}
