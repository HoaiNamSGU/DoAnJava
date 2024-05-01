package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controllernhaphang;
import dao.LaptopDAO;
import dao.nhacungcapDao;
import img.Source;
import model.Laptop;
import model.NhaCungCap;

public class NhapHang extends JFrame{
	ArrayList<NhaCungCap> dsnhacungcap=nhacungcapDao.getInstance().selectAll();
	private JPanel contentPane;
	ArrayList<Laptop> sanpham=LaptopDAO.getintance().selectAll();
	public JTextField jtext_tim;
	public JButton btn_lammoi;
	private JTextField txt_mpn;
	private JTextField txt_ntp;
	private JTable table;
	private DefaultTableModel model;
	private JTable table1;
	private DefaultTableModel model1;
	private JTextField txt_soluong;
	public JButton btn_them;
	public JButton btn_xoasp;
	private JLabel jl_tongtien;
	private long tongtien=0,sohang=0;
	public JButton btn_nhaphang;
	public JButton btn_suasoluong;
	public JPanel panel_nhaphang;
	public Source source = new Source();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhapHang frame = new NhapHang();
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
	public NhapHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1121, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setTitle("màn hình chính");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//
		getContentPane().setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1430,800);
		this.setLocationRelativeTo(null);
		this.setTitle("màn hình chính");
		getContentPane().setLayout(null);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBounds(0, 0, 197, 763);
		panel_menu.setBackground(new Color(0, 128, 192));
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
		 panel_nhaphang = new JPanel();
		panel_nhaphang.setBounds(0, 0, 1219, 764);
		panel_nhaphang.setLayout(null);		
		contentPane.add(panel_nhaphang);
		
		JLabel lblNewLabel = new JLabel("Hi !");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(63, 45, 36, 24);
		panel_menu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(52, 79, 68, 24);
		panel_menu.add(lblNewLabel_1);
		
		JLabel jlabel_sanpham = new JLabel("Sản phẩm");
		jlabel_sanpham.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_sanpham.setForeground(new Color(255, 255, 255));
		jlabel_sanpham.setBounds(26, 158, 148, 37);
		jlabel_sanpham.setIcon(source.icon_sanpham);
		panel_menu.add(jlabel_sanpham);
		
		
		
		
		JLabel jlabel_nhacungcap = new JLabel("Nhà cung cấp");
		jlabel_nhacungcap.setForeground(Color.WHITE);
		jlabel_nhacungcap.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_nhacungcap.setBounds(26, 205, 161, 37);
		jlabel_nhacungcap.setIcon(source.icon_nhaCungCap);
		panel_menu.add(jlabel_nhacungcap);
		
		
		JLabel jlabel_nhaphang = new JLabel("Nhập hàng");
		jlabel_nhaphang.setForeground(Color.WHITE);
		jlabel_nhaphang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_nhaphang.setBounds(26, 252, 148, 37);
		jlabel_nhaphang.setIcon(source.icon_nhaphang);
		panel_menu.add(jlabel_nhaphang);
		
		
		JLabel jlabel_phieunhap = new JLabel("Phiếu nhập");
		jlabel_phieunhap.setForeground(Color.WHITE);
		jlabel_phieunhap.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_phieunhap.setBounds(26, 299, 148, 37);
		jlabel_phieunhap.setIcon(source.icon_phieunhap);
		panel_menu.add(jlabel_phieunhap);

		
		JLabel jlabel_xuathang = new JLabel("Xuất hàng");
		jlabel_xuathang.setForeground(Color.WHITE);
		jlabel_xuathang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_xuathang.setBounds(26, 346, 148, 37);
		jlabel_xuathang.setIcon(source.icon_xuathang);
		panel_menu.add(jlabel_xuathang);
		
		
		JLabel jlabel_phieuxuat = new JLabel("Phiếu xuất");
		jlabel_phieuxuat.setForeground(Color.WHITE);
		jlabel_phieuxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_phieuxuat.setBounds(26, 393, 148, 37);
		jlabel_phieuxuat.setIcon(source.icon_phieuxuat);
		panel_menu.add(jlabel_phieuxuat);
		
		
		JLabel jlabel_cuahang = new JLabel("Cửa hàng");
		jlabel_cuahang.setForeground(Color.WHITE);
		jlabel_cuahang.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_cuahang.setBounds(26, 440, 148, 37);
		jlabel_cuahang.setIcon(source.icon_cuahang);
		panel_menu.add(jlabel_cuahang);
		
		
		JLabel jlabel_taikhoan = new JLabel("Tài khoản");
		jlabel_taikhoan.setForeground(Color.WHITE);
		jlabel_taikhoan.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_taikhoan.setBounds(26, 487, 148, 37);
		jlabel_taikhoan.setIcon(source.icon_taikhoan);
		panel_menu.add(jlabel_taikhoan);
		
		
		
		JLabel jlabel_thongke = new JLabel("Thống kê");
		jlabel_thongke.setForeground(Color.WHITE);
		jlabel_thongke.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_thongke.setBounds(26, 534, 148, 37);
		jlabel_thongke.setIcon(source.icon_thongke);
		panel_menu.add(jlabel_thongke);
		
		
		JLabel jlabel_đổiThongtin = new JLabel("Đổi thông tin");
		jlabel_đổiThongtin.setForeground(Color.WHITE);
		jlabel_đổiThongtin.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_đổiThongtin.setBounds(26, 641, 148, 37);
		jlabel_đổiThongtin.setIcon(source.icon_doithongtin);
		panel_menu.add(jlabel_đổiThongtin);
		
		
		
		JLabel jlabel_dangxuat = new JLabel("Đăng xuất");
		jlabel_dangxuat.setForeground(Color.WHITE);
		jlabel_dangxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_dangxuat.setBounds(26, 688, 148, 37);
		jlabel_dangxuat.setIcon(source.icon_dangxuat);
		panel_menu.add(jlabel_dangxuat);
		panel_nhaphang.setLayout(null);
		//
		JPanel panel = new JPanel();
		panel.setBounds(20, 18, 542, 89);
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_nhaphang.add(panel);
		panel.setLayout(null);
		
		jtext_tim = new JTextField();
		jtext_tim.setBounds(22, 20, 367, 41);
		panel.add(jtext_tim);
		jtext_tim.setColumns(10);
		
		
		 btn_lammoi = new JButton("Làm mới", source.icon_lammoi);
		 btn_lammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btn_lammoi.setBounds(399, 20, 133, 41);
		 panel.add(btn_lammoi);
		
		JLabel jl_mpn = new JLabel("Mã phiếu nhập");
		jl_mpn.setBounds(650, 18, 108, 33);
		jl_mpn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_nhaphang.add(jl_mpn);
		
		txt_mpn = new JTextField();
		txt_mpn.setBounds(760, 10, 399, 41);
		txt_mpn.setColumns(10);
		panel_nhaphang.add(txt_mpn);
		
		JLabel jl_ncc = new JLabel("Nhà cung cấp");
		jl_ncc.setBounds(650, 80, 108, 33);
		jl_ncc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_nhaphang.add(jl_ncc);
		
		JLabel jl_ntp = new JLabel("Người tạo phiếu");
		jl_ntp.setBounds(650, 141, 108, 33);
		jl_ntp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_nhaphang.add(jl_ntp);
		
		txt_ntp = new JTextField();
		txt_ntp.setBounds(760, 133, 399, 41);
		txt_ntp.setColumns(10);
		panel_nhaphang.add(txt_ntp);
		
		JComboBox cmb_ncc = new JComboBox();
		cmb_ncc.setBounds(760, 68, 399, 41);
		for(int i=0;i<dsnhacungcap.size();i++) {
			cmb_ncc.addItem(dsnhacungcap.get(i).getTenNhaCungCap());
		}
		panel_nhaphang.add(cmb_ncc);
		
		String column []= {"Mã máy","Tên máy","Số lượng","Đơn giá"};
		Object data [][]= {};
		 table = new JTable(data,column);
		 JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setBounds(20, 141, 542, 489);
			panel_nhaphang.add(scrollPane);
		table.setDefaultEditor(Object.class, null);
		table.setModel(new DefaultTableModel(
			new Object[][] {			
			},
			new String[] {
					"Mã máy","Tên máy","Số lượng","Đơn giá"
			}
		));
		 model = (DefaultTableModel) table.getModel();
		for (Laptop sp : sanpham) {
		    model.addRow(new Object[] {
		    		sp.getMaLaptop(), sp.getTenLaptop(),sp.getSoLuong(),sp.getGia()
		    });
		}
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		
		
		String column1 []= {"Mã máy","Tên máy","Số lượng","Đơn giá"};
		Object data1 [][]= {};
		 table1 = new JTable(data1,column1);
		 JScrollPane scrollPane1 = new JScrollPane(table1);
		 scrollPane1.setBounds(650, 202, 564, 354);
			panel_nhaphang.add(scrollPane1);
		table1.setDefaultEditor(Object.class, null);
		table1.setModel(new DefaultTableModel(
			new Object[][] {			
			},
			new String[] {
					"Mã máy","Tên máy","Số lượng","Đơn giá"
			}
		));
		
		JLabel lblNewLabel_2 = new JLabel("Số lượng");
		lblNewLabel_2.setBounds(110, 681, 86, 33);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_nhaphang.add(lblNewLabel_2);
		
		txt_soluong = new JTextField();
		txt_soluong.setBounds(200, 680, 61, 44);
		panel_nhaphang.add(txt_soluong);
		txt_soluong.setColumns(10);
		
		ImageIcon icon_them =  new ImageIcon(source+"plus.png");
		 btn_them = new JButton("THÊM",icon_them);
		 btn_them.setBounds(280, 681, 145, 43);
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_nhaphang.add(btn_them);
		
		ImageIcon icon_nhapexcel =  new ImageIcon(source+"xuatExcel.png");
		JButton btn_nhapexcel = new JButton("Nhập excel",icon_nhapexcel);
		btn_nhapexcel.setBounds(650, 597, 167, 49);
		btn_nhapexcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_nhaphang.add(btn_nhapexcel);
		
		ImageIcon icon_suasoluong =  new ImageIcon(source+"pencil.png");
		 btn_suasoluong = new JButton("Sửa số lượng", icon_suasoluong);
		btn_suasoluong.setBounds(820, 597, 195, 49);
		btn_suasoluong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_nhaphang.add(btn_suasoluong);
		
		ImageIcon icon_xoasp =  new ImageIcon(source+"remove.png");
		 btn_xoasp = new JButton("Xóa sản phẩm", icon_xoasp);
		 btn_xoasp.setBounds(1030, 597, 182, 49);
		btn_xoasp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_nhaphang.add(btn_xoasp);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tổng tiền");
		lblNewLabel_2_1.setBounds(650, 681, 86, 33);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_nhaphang.add(lblNewLabel_2_1);
		
		 jl_tongtien = new JLabel("");
		 jl_tongtien.setBounds(750, 681, 280, 33);
		jl_tongtien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_nhaphang.add(jl_tongtien);
		
		btn_nhaphang = new JButton("Nhập hàng");
		btn_nhaphang.setBounds(1075, 675, 135, 45);
		btn_nhaphang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_nhaphang.add(btn_nhaphang);
		
		model1 = (DefaultTableModel) table1.getModel();
		table1.getTableHeader().setResizingAllowed(false);
		table1.getTableHeader().setReorderingAllowed(false);

		 Controllernhaphang.ActionListener(btn_them,this);
		 Controllernhaphang.ActionListener(btn_xoasp, this);
		 Controllernhaphang.addKeyListener(jtext_tim, this);
		 Controllernhaphang.ActionListener(btn_lammoi, this);
		 Controllernhaphang.ActionListener(btn_nhaphang, this);
		 Controllernhaphang.ActionListener(btn_suasoluong, this);

	}
	
	public void themhang() {
			if(txt_soluong.getText().equals(0)) JOptionPane.showMessageDialog(null, "Bạn chưa nhập số lượng cần thêm");
			else {
				sohang++;
//				long sl=Integer.parseInt(txt_soluong.getText());
		  	 int i=table.getSelectedRow();
		  	 String mm=model.getValueAt(i, 0)+"";
			 String tm=model.getValueAt(i, 1)+"";
			 String soluong=txt_soluong.getText();
			 String dongia=model.getValueAt(i, 3)+"";
			 model1.addRow(new Object[] {
			    		mm, tm,soluong,dongia
			    });
			 table1.setModel(model1);
			 tongtien+=Double.parseDouble(dongia)*Double.parseDouble(soluong);
				jl_tongtien.setText(tongtien+"");
				JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công");
				txt_soluong.setText("");
			}
			
	}
	
	public void xoasanpham() {
		sohang--;
		int t=table1.getSelectedRow();
   	 int luachon=JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa nó không ?");
   	if(luachon==JOptionPane.YES_OPTION) {
   		tongtien-=Double.parseDouble(model1.getValueAt(t, 2)+"")*Double.parseDouble(model1.getValueAt(t, 3)+"");
		jl_tongtien.setText(tongtien+"");
		model1.removeRow(t);
 }
   	
	}
	
	public void thanhtimkiem() {
		model.setRowCount(0);
		sanpham=LaptopDAO.getintance().selectAll();
		if(jtext_tim.getText().length()<=0) {
			for (Laptop sp : sanpham) {
			    model.addRow(new Object[] {
			    		sp.getMaLaptop(), sp.getTenLaptop(),sp.getSoLuong(),sp.getGia()
			    });
			}
		}else {
		String text=jtext_tim.getText();
		System.out.println(text);
		for (Laptop sp : sanpham) {
			if(sp.getTenLaptop().toLowerCase().contains(text.toLowerCase())) {
		    model.addRow(new Object[] {
		    		sp.getMaLaptop(), sp.getTenLaptop(),sp.getSoLuong(),sp.getGia()
		    });
			}
		}
		}
	}
	
	public void lammoithanh() {
		model.setRowCount(0);
		sanpham=LaptopDAO.getintance().selectAll();
		for (Laptop sp : sanpham) {
		    model.addRow(new Object[] {
		    		sp.getMaLaptop(), sp.getTenLaptop(),sp.getSoLuong(),sp.getGia()
		    });
			}
	}
	
	public void NhapHang() {
		System.out.println(sohang);
		for(int i=0;i<sohang;i++) {
			 String mm=model1.getValueAt(i, 0)+"";
			 String tm=model1.getValueAt(i, 1)+"";
			 String soluong=model1.getValueAt(i, 2)+"";
			 String dongia=model1.getValueAt(i, 3)+"";
			 LaptopDAO.getintance().update1dulieu(mm, Long.parseLong(soluong));
			 System.out.println(Long.parseLong(soluong));
			 System.out.println(model.getRowCount()+" "+model.getColumnCount());
			 for(int j=0;j<model.getRowCount();j++) {
//				 for(int z=0;z<model.getColumnCount();z++) {
					 if(mm.contains(model.getValueAt(j, 1)+"")) {
						 long soltong= Long.parseLong(model.getValueAt(j,2)+"")+ Long.parseLong(soluong);
						 System.out.println(soltong);
						 model.setValueAt(soltong, j, 2);
					 }
//				 }
			 }
			 
		}
		sohang=0;
		jl_tongtien.setText("");
		   model1.setRowCount(0);
		JOptionPane.showMessageDialog(null, "Nhập hàng thành công","Thông báo",JOptionPane.CLOSED_OPTION);
	}
	
	public void suasl() {
	  	 int i=table1.getSelectedRow();
	  	String g=JOptionPane.showInputDialog("Bạn muốn sửa thêm bao nhiêu hàng");
	  	 model1.setValueAt(Long.parseLong(g), i, 2);
	  	 jl_tongtien.setText(g);
	}
}
