package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controllerphieuxuat;
import dao.LaptopDAO;
import dao.NhanVienDAO;
import dao.PhieuNhapDao;
import dao.PhieuXuatDao;
import dao.nhacungcapDao;
import img.Source;
import model.Laptop;
import model.NhaCungCap;
import model.PhieuXuat;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Phieuxuat extends JFrame {
	private JTextField textField;
	ArrayList<NhaCungCap> dsnhacungcap=nhacungcapDao.getInstance().selectAll();
	ArrayList<Laptop> sanpham=LaptopDAO.getintance().selectAll();
	ArrayList<PhieuXuat> dspn=PhieuXuatDao.getInstance().selectAll();
	ArrayList<String> dstnv=NhanVienDAO.getintance().Layalltennv();
	public JTextField txtx_timkiem;
	public JLabel jl_nutadd;
	private JTextField tx1;
	private JTextField tx2;
	private JTextField tx4;
	private JTextField tx5;
	private JTextField tx3;
	public JButton btn_them;
	private JButton btn_huy;
	private JPanel panel_conthansp;
	public JTable table;
	public DefaultTableModel model;
	public JLabel jl_nutxoa;
	private JPanel panel_sua;
	private JLabel txt_themmoisanpham;
	public JButton btn_sua;
	public JButton btn_lammoi;
	public JComboBox cbb_timkiem;
	public JLabel jl_nutsua;
	public JPanel panel_cungcap;
	public JPanel panel_menu;
	private JPanel jp_chucnang;
	public Source source =  new Source();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtext_tim;
	private JTextField jt_tn;
	private JTextField jt_dn;
	private JTextField jt_tientu;
	private JTextField jt_tienden;
	private int stt=1;
	public JPanel panel_phieunhap;
	public JComboBox cmb_ncc;
	public JComboBox cmb_nvn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phieuxuat frame = new Phieuxuat();
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
	public Phieuxuat() {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(0, 0, 1400, 800);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(new BorderLayout(0, 0));
	        
			 panel_menu= new JPanel();
			panel_menu.setBackground(new Color(0, 128, 192));
			 contentPane.add(panel_menu, BorderLayout.WEST);
			 panel_menu.setForeground(new Color(255, 255, 255));
		panel_menu.setBounds(0, 0, 197, 763);
//			panel_cungcap.setBackground(new Color(192, 192, 192));
//			getContentPane().add(panel_cungcap);
			panel_menu.setLayout(new GridLayout(13, 1, 0, 0));
//			scrollPane.setBounds(0, 0, 1189, 602);

			
			JLabel lblNewLabel = new JLabel("Hi !");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
			panel_menu.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Admin");
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
			panel_menu.add(lblNewLabel_1);
			
			JLabel jlabel_sanpham = new JLabel("Sản phẩm");
			jlabel_sanpham.setFont(new Font("Arial", Font.PLAIN, 20));
			jlabel_sanpham.setForeground(new Color(255, 255, 255));
			ImageIcon icon_sanpham = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\product.png");
			jlabel_sanpham.setIcon(icon_sanpham);
			panel_menu.add(jlabel_sanpham);
			
			
			
			
			JLabel jlabel_nhacungcap = new JLabel("Nhà cung cấp");
			jlabel_nhacungcap.setForeground(Color.WHITE);
			jlabel_nhacungcap.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_nhaCungCap = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\loadicon.png");
			jlabel_nhacungcap.setIcon(icon_nhaCungCap);
			panel_menu.add(jlabel_nhacungcap);
			
			
			JLabel jlabel_nhaphang = new JLabel("Nhập hàng");
			jlabel_nhaphang.setForeground(Color.WHITE);
			jlabel_nhaphang.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_nhaphang = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\supplier.png");
			jlabel_nhaphang.setIcon(icon_nhaphang);
			panel_menu.add(jlabel_nhaphang);
			
			
			JLabel jlabel_phieunhap = new JLabel("Phiếu nhập");
			jlabel_phieunhap.setForeground(Color.WHITE);
			jlabel_phieunhap.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_phieunhap = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\phieunhap.png");
			jlabel_phieunhap.setIcon(icon_phieunhap);
			panel_menu.add(jlabel_phieunhap);

			
			JLabel jlabel_xuathang = new JLabel("Xuất hàng");
			jlabel_xuathang.setForeground(Color.WHITE);
			jlabel_xuathang.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_xuathang = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\xuathang.png");
			jlabel_xuathang.setIcon(icon_xuathang);
			panel_menu.add(jlabel_xuathang);
			
			
			JLabel jlabel_phieuxuat = new JLabel("Phiếu xuất");
			jlabel_phieuxuat.setForeground(Color.WHITE);
			jlabel_phieuxuat.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_phieuxuat = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\phieuxuat.png");
			jlabel_phieuxuat.setIcon(icon_phieuxuat);
			panel_menu.add(jlabel_phieuxuat);
			
			
			JLabel jlabel_cuahang = new JLabel("Cửa hàng");
			jlabel_cuahang.setForeground(Color.WHITE);
			jlabel_cuahang.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_cuahang = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\store.png");
			jlabel_cuahang.setIcon(icon_cuahang);
			panel_menu.add(jlabel_cuahang);
			
			
			JLabel jlabel_taikhoan = new JLabel("Tài khoản");
			jlabel_taikhoan.setForeground(Color.WHITE);
			jlabel_taikhoan.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_taikhoan = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\taikhoan.png");
			jlabel_taikhoan.setIcon(icon_taikhoan);
			panel_menu.add(jlabel_taikhoan);
			
			
			
			JLabel jlabel_thongke = new JLabel("Thống kê");
			jlabel_thongke.setForeground(Color.WHITE);
			jlabel_thongke.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_thongke = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\thongke.png");
			jlabel_thongke.setIcon(icon_thongke);
			panel_menu.add(jlabel_thongke);
			
			
			JLabel jlabel_đổiThongtin = new JLabel("Đổi thông tin");
			jlabel_đổiThongtin.setForeground(Color.WHITE);
			jlabel_đổiThongtin.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_doithongtin = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\thongtin.png");
			jlabel_đổiThongtin.setIcon(icon_doithongtin);
			panel_menu.add(jlabel_đổiThongtin);
			
			
			
			JLabel jlabel_dangxuat = new JLabel("Đăng xuất");
			jlabel_dangxuat.setForeground(Color.WHITE);
			jlabel_dangxuat.setFont(new Font("Arial", Font.PLAIN, 20));
			ImageIcon icon_dangxuat = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\dangxuat.png");
			jlabel_dangxuat.setIcon(icon_dangxuat);
			panel_menu.add(jlabel_dangxuat);
	        
	        
	         panel_phieunhap = new JPanel();
			panel_phieunhap.setBounds(197, 0, 1189, 763);
	        contentPane.add(panel_phieunhap, BorderLayout.CENTER);
	        panel_phieunhap.setLayout(new BorderLayout(0, 0));
	        
//	        JPanel panel_tren = new JPanel();
//	        panel_nhaphang.add(panel_tren, BorderLayout.NORTH);
	        
	       

	        
	        
	        jp_chucnang = new JPanel();
			jp_chucnang.setBounds(10, 10, 398, 97);
//			jp_chucnang.setLayout(new FlowLayout());
//			jp_chucnang.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50)); // Thiết lập FlowLayout với khoảng cách giữa các thành phần là 10px
			jp_chucnang.setLayout(new GridLayout(1, 2, 50, 50));
	        panel_phieunhap.add(jp_chucnang, BorderLayout.NORTH);
	        
			JPanel jc_cntrai = new JPanel();
			jc_cntrai.setBounds(10, 10, 398, 97);
			jc_cntrai.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jp_chucnang.add(jc_cntrai);
			jc_cntrai.setLayout(new GridLayout(2, 5, 0, 0));
			
			JPanel jp_timkiem = new JPanel();
			jp_timkiem.setBounds(450, 10, 695, 97);
			jp_timkiem.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jp_chucnang.add(jp_timkiem);
			 GridBagLayout gbl_jp_timkiem = new GridBagLayout();
			 gbl_jp_timkiem.columnWidths = new int[] {195, 195, 195};
			 gbl_jp_timkiem.rowHeights = new int[] {32, 32};
			 gbl_jp_timkiem.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			 gbl_jp_timkiem.rowWeights = new double[]{0.0};
			 jp_timkiem.setLayout(gbl_jp_timkiem);
			 
//				JLabel jlabel_them = new JLabel("Thêm", icon_add, JLabel.CENTER);
			  btn_lammoi = new JButton("Làm mới", source.icon_refresh);
			  btn_lammoi.addMouseListener(new MouseAdapter() {
			  	@Override
			  	public void mouseClicked(MouseEvent e) {
			  	}
			  });
			  
			   cbb_timkiem = new JComboBox();	 
			   cbb_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
			   GridBagConstraints gbc_cbb_timkiem = new GridBagConstraints();
			   gbc_cbb_timkiem.fill = GridBagConstraints.BOTH;
			   gbc_cbb_timkiem.insets = new Insets(0, 0, 0, 5);
			   gbc_cbb_timkiem.gridx = 0;
			   gbc_cbb_timkiem.gridy = 0;
			   jp_timkiem.add(cbb_timkiem, gbc_cbb_timkiem);
			   //				jp_chucnang.setLayout(null);
			   				cbb_timkiem.addItem("Tất cả");
			   				cbb_timkiem.addItem("Mã phiếu");
			   				cbb_timkiem.addItem("Mã cửa hàng");
			   				cbb_timkiem.addItem("Mã nhân viên");
			   				//				cbb_timkiem.addItem("Địa chỉ");
			   				//				cbb_timkiem.addItem("Số điện thoại");
			   				//				cbb_timkiem.addItem("Email");
			   				//				cbb_timkiem.addItem("Tên");
			   				
			   				
			   								cbb_timkiem.setSelectedIndex(0);
			  
			  txtx_timkiem = new JTextField();
			  GridBagConstraints gbc_txtx_timkiem = new GridBagConstraints();
			  gbc_txtx_timkiem.fill = GridBagConstraints.BOTH;
			  gbc_txtx_timkiem.insets = new Insets(0, 0, 0, 5);
			  gbc_txtx_timkiem.gridx = 1;
			  gbc_txtx_timkiem.gridy = 0;
			  jp_timkiem.add(txtx_timkiem, gbc_txtx_timkiem);
			  txtx_timkiem.setColumns(10);
			  
			  Controllerphieuxuat.addKeyListener(txtx_timkiem, this);
			  btn_lammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  GridBagConstraints gbc_btn_lammoi = new GridBagConstraints();
			  gbc_btn_lammoi.fill = GridBagConstraints.BOTH;
			  gbc_btn_lammoi.gridx = 2;
			  gbc_btn_lammoi.gridy = 0;
			  jp_timkiem.add(btn_lammoi, gbc_btn_lammoi);
	        /////////chan///////////////
	      //them

			JLabel jl_chuthem = new JLabel("Thêm");	
			jl_chuthem.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_chuthem.setBounds(15, 63, 45, 21);
			jl_nutadd = new JLabel("");
			jl_nutadd.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_nutadd.setBounds(15, 13, 33, 55);
			jl_nutadd.setIcon(source.icon_add);
			jc_cntrai.add(jl_nutadd);
			JLabel jl_chuxoa = new JLabel("Xóa");
			jl_chuxoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_chuxoa.setBounds(86, 63, 33, 21);
			jl_nutxoa = new JLabel("");
			jl_nutxoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_nutxoa.setBounds(80, 13, 39, 55);
			jl_nutxoa.setIcon(source.icon_remove);
			jc_cntrai.add(jl_nutxoa);
			jl_nutsua = new JLabel("");
			jl_nutsua.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_nutsua.setBounds(142, 13, 39, 55);
			jl_nutsua.setIcon(source.icon_eye);
			JLabel jl_chusua = new JLabel("Xem chi tiết");
			jl_chusua.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_chusua.setBounds(142, 63, 28, 21);
			jc_cntrai.add(jl_nutsua);
			

			
			JLabel jl_nutxuatexcel = new JLabel("");
			jl_nutxuatexcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_nutxuatexcel.setBounds(220, 13, 33, 55);
			jc_cntrai.add(jl_nutxuatexcel);
			JLabel jl_chuxuatexcel = new JLabel("Xuất Excel");
			jl_chuxuatexcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_chuxuatexcel.setBounds(208, 63, 70, 21);
			jl_nutxuatexcel.setIcon(source.icon_Excel);
			
			JLabel jl_nutnhapexcel = new JLabel("");
			jl_nutnhapexcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_nutnhapexcel.setBounds(301, 13, 70, 55);
			jc_cntrai.add(jl_nutnhapexcel);
			JLabel jl_chunhapexcel = new JLabel("Nhập Excel");
			jl_chunhapexcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jl_chunhapexcel.setBounds(300, 63, 88, 21);
			jl_nutnhapexcel.setIcon(source.icon_Excel);
			
			jc_cntrai.add(jl_chuthem);
			jc_cntrai.add(jl_chuxoa);
			jc_cntrai.add(jl_chusua);
			jc_cntrai.add(jl_chuxuatexcel);
			jc_cntrai.add(jl_chunhapexcel);
			
			
			
//			 JPanel panel_trai = new JPanel();
//		        panel_phieunhap.add(panel_trai, BorderLayout.WEST);
//		        panel_trai.setLayout(new GridLayout(12, 1, 0, 0));
//		        
//		        JLabel jl_nhacungcap = new JLabel("Nhà cung cấp");
//		        jl_nhacungcap.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		        panel_trai.add(jl_nhacungcap);
//		         cmb_ncc = new JComboBox();
//		        panel_trai.add(cmb_ncc);
//		        cmb_ncc.addItem("Tất cả");
//		        for(int i=0;i<dsnhacungcap.size();i++) {
//		        	cmb_ncc.addItem(dsnhacungcap.get(i).getTenNhaCungCap());
//				}
//		        
//		        
//
//		        JLabel jl_nhanvien = new JLabel("Nhân viên nhập");
//		        jl_nhanvien.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		        panel_trai.add(jl_nhanvien);
//		         cmb_nvn = new JComboBox();
//		        panel_trai.add(cmb_nvn);
//		        cmb_nvn.addItem("Tất cả");
//		        for(int i=0;i<dstnv.size();i++) {
//		        	cmb_nvn.addItem(dstnv.get(i));
//				}
//		       
//		        
//		        JLabel jl_tungay = new JLabel("Từ ngày");
//		        jl_tungay.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		        panel_trai.add(jl_tungay);
//		        jt_tn = new JTextField();
//		        panel_trai.add(jt_tn);
//		        jt_tn.setColumns(10);
//		        
//		        
//
//		        JLabel jl_denngay = new JLabel("Từ ngày");
//		        jl_denngay.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		        panel_trai.add(jl_denngay);
//		        jt_dn = new JTextField();
//		        panel_trai.add(jt_dn);
//		        jt_dn.setColumns(10);
//		        
//		        
//		        
//		        JLabel jl_tientu = new JLabel("Tiền từ");
//		        jl_tientu.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		        panel_trai.add(jl_tientu);
//		        jt_tientu = new JTextField();
//		        panel_trai.add(jt_tientu);
//		        jt_tientu.setColumns(10);
//		        
//		        
//
//		        JLabel jl_tienden = new JLabel("Từ ngày");
//		        jl_tienden.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		        panel_trai.add(jl_tienden);
//		        jt_tienden= new JTextField();
//		        panel_trai.add(jt_tienden);
//		        jt_tienden.setColumns(10);
		        
		        JPanel panel_phai = new JPanel();
		        panel_phieunhap.add(panel_phai, BorderLayout.CENTER);
		        panel_phai.setLayout(new BorderLayout(0, 0));
		        
		        

			 
			 String column []= {"Mã máy","Tên máy","Số lượng","Đơn giá"};
				Object data [][]= {};
				 panel_phai.setLayout(new BorderLayout(0, 0));
				 table = new JTable(data,column);
				 JScrollPane scrollPane = new JScrollPane(table);
				 scrollPane.setBounds(197, 0, 100, 100);
				 panel_phai.add(scrollPane);
				table.setDefaultEditor(Object.class, null);
				table.setModel(new DefaultTableModel(
					new Object[][] {			
					},
					new String[] {
							"Mã phiếu","Mã cửa hàng","Số lượng","Tổng tiền","Ngày xuất","Mã nhân viên"
//							"Mã phiếu","Tên nhà cung cấp","Tên nhân viên nhập","Thời gian","Số lượng sản phẩm","Tổng tiền"

					}
				));
				
				 model = (DefaultTableModel) table.getModel();
				for (PhieuXuat sp : dspn) {
					DecimalFormat df10 = new DecimalFormat("#");
				     String formattedNumber2 = df10.format(sp.getTongTien());
				
				    model.addRow(new Object[] {
				    		sp.getMaPhieuXuat(),sp.getMaCuaHang(),sp.getTongSoLuong(),formattedNumber2,sp.getNgayXuat(),sp.getMaNhanVien()
				    });
				}
				table.getTableHeader().setResizingAllowed(false);
				table.getTableHeader().setReorderingAllowed(false);
				Controllerphieuxuat.addMouseListener(jl_nutadd, this);
				Controllerphieuxuat.addMouseListener(jl_nutxoa, this);
				Controllerphieuxuat.addMouseListener(jl_nutsua, this);
				

	}

	public void thaydoicombo2() {
		DecimalFormat df11;
		String fom2;
		model.setRowCount(0);
		if(cmb_ncc.getSelectedItem().equals("Tất cả")) {
			for (PhieuXuat sp : dspn) {
				df11 = new DecimalFormat("#");
				fom2  = df11.format(sp.getTongTien());
				model.addRow(new Object[] {
			    		sp.getMaPhieuXuat(),sp.getMaCuaHang(),fom2,sp.getNgayXuat(),sp.getMaNhanVien()
			    });		}
		}else {
		String text=PhieuNhapDao.getInstance().laymanhacungcap(cmb_ncc.getSelectedItem()+"");
		String manvnha=NhanVienDAO.getintance().laymanhanvien(cmb_nvn.getSelectedItem()+"");
		for (PhieuXuat sp : dspn) {
			df11 = new DecimalFormat("#");
			fom2  = df11.format(sp.getTongTien());
			if(sp.getMaCuaHang().equals(text)) {
			DecimalFormat df2 = new DecimalFormat("#");
		     String formattedNumber2 = df2.format(sp.getTongTien());
		     model.addRow(new Object[] {
			    		sp.getMaPhieuXuat(),sp.getMaCuaHang(),fom2,sp.getNgayXuat(),sp.getMaNhanVien()
			    });			}
		}
	}
	}

	public void xemchitietphieu() {
		 int i=table.getSelectedRow();
		String maphieunhap= model.getValueAt(i, 0)+"";
		String macuahang=model.getValueAt(i, 1)+"";
		String ngaynhap=model.getValueAt(i, 4)+"";
		String manhanvien=model.getValueAt(i, 5)+"";
		String tennhanvien=NhanVienDAO.getintance().laytennhanvien(manhanvien);
		Xemchitietxuat xcttpn = new Xemchitietxuat(maphieunhap,macuahang,ngaynhap,tennhanvien);
		xcttpn.setVisible(true);
	}
	
	public void xoaphieu() {
		 int i=table.getSelectedRow();
		 if(i<0) JOptionPane.showConfirmDialog(null, "Bạn chưa chọn dòng cần xóa","THÔNG BÁO",JOptionPane.CLOSED_OPTION);	
		 else {
    	 int luachon=JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa nó không ?");
    	 if(luachon==JOptionPane.YES_OPTION) {
    		 String mp=model.getValueAt(i, 1)+"";
    		 PhieuXuatDao.getInstance().deletetheoma(mp);
    			model.removeRow(i);
    	 }
		 }
	}
	public void moadd() {
//		NhapHang nh = new NhapHang();
//		nh.setVisible(true);
		panel_phieunhap.setVisible(false);
		panel_phieunhap.removeAll();
		XuatHang nhaphang=new XuatHang();
		panel_phieunhap.add(nhaphang.panel_nhaphang);
		panel_phieunhap.setVisible(true);
	}
	
	public void thanhtimkiem() {
		model.setRowCount(0);
		String timitem = cbb_timkiem.getSelectedItem() + "";
		String text = txtx_timkiem.getText();
		if(text.equals("")) {
			for (PhieuXuat sp : dspn) {
				DecimalFormat df10 = new DecimalFormat("#");
			     String formattedNumber2 = df10.format(sp.getTongTien());
					model.addRow(new Object[] {
				    		sp.getMaPhieuXuat(),sp.getMaCuaHang(),sp.getTongSoLuong(),formattedNumber2,sp.getNgayXuat(),sp.getMaNhanVien()
				    });			
					}
		}
		else {
			if (timitem.equals("Tất cả")) {
				for (PhieuXuat sp : dspn) {
					if (sp.getMaPhieuXuat().equals(text) && sp.getMaCuaHang().equals(text) && sp.getNgayXuat().equals(text) && sp.getMaNhanVien().equals(text)){
						DecimalFormat df10 = new DecimalFormat("#");
					     String formattedNumber2 = df10.format(sp.getTongTien());
							model.addRow(new Object[] {
						    		sp.getMaPhieuXuat(),sp.getMaCuaHang(),sp.getTongSoLuong(),formattedNumber2,sp.getNgayXuat(),sp.getMaNhanVien()
						    });		
				}
				}
			}
		else if (timitem.equals("Mã phiếu")) {
			for (PhieuXuat sp : dspn) {
				if (sp.getMaPhieuXuat().equals(text)) {
					DecimalFormat df10 = new DecimalFormat("#");
				     String formattedNumber2 = df10.format(sp.getTongTien());
						model.addRow(new Object[] {
					    		sp.getMaPhieuXuat(),sp.getMaCuaHang(),sp.getTongSoLuong(),formattedNumber2,sp.getNgayXuat(),sp.getMaNhanVien()
					    });		
			}
			}
		}
		else if (timitem.equals("Mã cửa hàng")) {
			for (PhieuXuat sp : dspn) {
				if (sp.getMaCuaHang().equals(text)) {
					DecimalFormat df10 = new DecimalFormat("#");
				     String formattedNumber2 = df10.format(sp.getTongTien());
						model.addRow(new Object[] {
					    		sp.getMaPhieuXuat(),sp.getMaCuaHang(),sp.getTongSoLuong(),formattedNumber2,sp.getNgayXuat(),sp.getMaNhanVien()
					    });						}

			}
		}
		else if (timitem.equals("Mã nhân viên")) {
			for (PhieuXuat sp : dspn) {
				if (sp.getMaNhanVien().equals(text)) {
					DecimalFormat df10 = new DecimalFormat("#");
				     String formattedNumber2 = df10.format(sp.getTongTien());
						model.addRow(new Object[] {
					    		sp.getMaPhieuXuat(),sp.getMaCuaHang(),sp.getTongSoLuong(),formattedNumber2,sp.getNgayXuat(),sp.getMaNhanVien()
					    });						}

			}
		}
	}
	}
	
}
