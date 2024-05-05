package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controllerxuathang;
import dao.CuaHangDAO;
import dao.LaptopDAO;
import dao.NhanVienDAO;
import dao.PhieuNhapDao;
import dao.PhieuXuatDao;
import dao.nhacungcapDao;
import img.Source;
import model.ChiTietPhieuXuat;
import model.CuaHang;
import model.Laptop;
import model.NhaCungCap;
import model.NhanVien;
import model.PhieuNhap;
import model.PhieuXuat;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class XuatHang extends JFrame {
	public int thu;
	ArrayList<Laptop> sanpham = LaptopDAO.getintance().selectAll();
	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPanel panel_menu;
	public JTable table;
	public DefaultTableModel model;
	public JTable table1;
	public DefaultTableModel model1;
	public JPanel panel_menu1;
	public JPanel panel_trenn;
	public JPanel panel_duoii;
	public JTextField jl_mapn;
	public JTextField jt_ngaynhap;
	public JTextField jt_masanpham;
	public JTextField jt_tensanpham;
	public JTextField jt_soluong;
	public JTextField jt_thanhtien;
	public JTextField jt_otimkiem;
	public int stt = 0, stt1 = 0;
	public double tongtien = 0;
	public JPanel panel_nhaphang;
	public JButton btn_themsp;
	public JButton btn_suasp;
	public JButton btn_xoasp;
	public JLabel kqtongtiennn;
	public JButton btn_nhapexcel;
	public JButton btn_nhaphang;
	public LocalDate ngay = LocalDate.now();
	public Date date = Date.valueOf(ngay);
	public JButton btn_quaylai;
	public JButton btn_timkiem;
	private Source source = new Source();
	private JLabel kqtongsoluong;
	private JLabel tongsoluog;
	private int tongsoluongphieu = 0, sua = 0;
	private JComboBox comboBox_ch;
	private JComboBox comboBox_nv;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XuatHang frame = new XuatHang();
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
	public XuatHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_nhaphang = new JPanel();
		panel_nhaphang.setBounds(197, 0, 1189, 763);
		contentPane.add(panel_nhaphang, BorderLayout.CENTER);
		panel_nhaphang.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_nhaphang.add(panel, BorderLayout.EAST);
		panel.setBounds(0, 0, 197, 763);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_bentren = new JPanel();
		panel.add(panel_bentren, BorderLayout.CENTER);
		panel.setBounds(0, 0, 197, 763);
		GridBagLayout gbl_panel_bentren = new GridBagLayout();
		gbl_panel_bentren.columnWidths = new int[]{110, 110, 0};
		gbl_panel_bentren.rowHeights = new int[]{135, 135, 135, 135, 0};
		gbl_panel_bentren.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_bentren.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_bentren.setLayout(gbl_panel_bentren);
		JLabel mapn = new JLabel("Mã phiếu xuất");
		mapn.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_mapn = new GridBagConstraints();
		gbc_mapn.fill = GridBagConstraints.BOTH;
		gbc_mapn.insets = new Insets(50, 0, 50, 5);
		gbc_mapn.gridx = 0;
		gbc_mapn.gridy = 0;
		panel_bentren.add(mapn, gbc_mapn);
		jl_mapn = new JTextField();
		GridBagConstraints gbc_jl_mapn = new GridBagConstraints();
		gbc_jl_mapn.fill = GridBagConstraints.BOTH;
		gbc_jl_mapn.insets = new Insets(50, 0, 50, 0);
		gbc_jl_mapn.gridx = 1;
		gbc_jl_mapn.gridy = 0;
		panel_bentren.add(jl_mapn, gbc_jl_mapn);
		jl_mapn.setColumns(10);
		JLabel manhacc = new JLabel("Mã cửa hàng");
		manhacc.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_manhacc = new GridBagConstraints();
		gbc_manhacc.fill = GridBagConstraints.BOTH;
		gbc_manhacc.insets = new Insets(50, 0, 50, 5);
		gbc_manhacc.gridx = 0;
		gbc_manhacc.gridy = 1;
		panel_bentren.add(manhacc, gbc_manhacc);
		
		ArrayList<CuaHang> ch = CuaHangDAO.getintance().selectAll();
		ArrayList<String> ch1 = new ArrayList<>(); // Khởi tạo ArrayList<String> ncc1
		ch1.add("");
		for (CuaHang nc : ch) {
		    ch1.add(nc.getMaCH()); // Thêm tên nhà cung cấp vào danh sách ncc1
		}
		comboBox_ch = new JComboBox<String>(ch1.toArray(new String[0]));
		GridBagConstraints gbc_comboBox_ch = new GridBagConstraints();
		gbc_comboBox_ch.fill = GridBagConstraints.BOTH;
		gbc_comboBox_ch.insets = new Insets(50, 0, 50, 0);
		gbc_comboBox_ch.gridx = 1;
		gbc_comboBox_ch.gridy = 1;
		panel_bentren.add(comboBox_ch, gbc_comboBox_ch);
		JLabel ngaynhap = new JLabel("Ngày xuất");
		ngaynhap.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_ngaynhap = new GridBagConstraints();
		gbc_ngaynhap.fill = GridBagConstraints.BOTH;
		gbc_ngaynhap.insets = new Insets(50, 0, 50, 5);
		gbc_ngaynhap.gridx = 0;
		gbc_ngaynhap.gridy = 2;
		panel_bentren.add(ngaynhap, gbc_ngaynhap);
		jt_ngaynhap = new JTextField();
		jt_ngaynhap.setText(date + "");
		jt_ngaynhap.setEnabled(false);
		GridBagConstraints gbc_jt_ngaynhap = new GridBagConstraints();
		gbc_jt_ngaynhap.fill = GridBagConstraints.BOTH;
		gbc_jt_ngaynhap.insets = new Insets(50, 0, 50, 0);
		gbc_jt_ngaynhap.gridx = 1;
		gbc_jt_ngaynhap.gridy = 2;
		panel_bentren.add(jt_ngaynhap, gbc_jt_ngaynhap);
		jt_ngaynhap.setColumns(1);
		JLabel manhanvien = new JLabel("Mã nhân viên");
		manhanvien.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_manhanvien = new GridBagConstraints();
		gbc_manhanvien.fill = GridBagConstraints.BOTH;
		gbc_manhanvien.insets = new Insets(50, 0, 50, 5);
		gbc_manhanvien.gridx = 0;
		gbc_manhanvien.gridy = 3;
		panel_bentren.add(manhanvien, gbc_manhanvien);
		
		ArrayList<NhanVien>nv=NhanVienDAO.getintance().selectAll();
		ArrayList<String> nv1 = new ArrayList<>(); // Khởi tạo ArrayList<String> ncc1
		nv1.add("");
		for (NhanVien n : nv) {
		    nv1.add(n.getMaNhanVien()); // Thêm tên nhà cung cấp vào danh sách ncc1
		}
		comboBox_nv = new JComboBox<String>(nv1.toArray(new String[0]));
		GridBagConstraints gbc_comboBox_nv = new GridBagConstraints();
		gbc_comboBox_nv.insets = new Insets(50, 0, 50, 0);
		gbc_comboBox_nv.fill = GridBagConstraints.BOTH;
		gbc_comboBox_nv.gridx = 1;
		gbc_comboBox_nv.gridy = 3;
		panel_bentren.add(comboBox_nv, gbc_comboBox_nv);

		JPanel panel_benduoi = new JPanel();
		panel_benduoi.setLayout(new GridLayout(3, 1, 0, 0));
		panel.add(panel_benduoi, BorderLayout.SOUTH);
		panel.setBounds(0, 0, 197, 763);

		JPanel panel_conduoi = new JPanel();
		panel_conduoi.setLayout(new GridLayout(2, 1, 0, 0));
		panel_benduoi.add(panel_conduoi);
		JLabel tongtiennn = new JLabel("Tổng tiền : ");
		tongtiennn.setHorizontalAlignment(SwingConstants.CENTER);
		tongtiennn.setFont(new Font("Arial", Font.BOLD, 15));
		panel_conduoi.add(tongtiennn);
		kqtongtiennn = new JLabel("0đ");
		kqtongtiennn.setHorizontalAlignment(SwingConstants.CENTER);
		kqtongtiennn.setFont(new Font("Arial", Font.BOLD, 15));
		panel_conduoi.add(kqtongtiennn);
		tongsoluog = new JLabel("Tổng số lượng:");
		tongsoluog.setHorizontalAlignment(SwingConstants.CENTER);
		tongsoluog.setFont(new Font("Arial", Font.BOLD, 15));
		panel_conduoi.add(tongsoluog);
		
		kqtongsoluong = new JLabel("0");
		kqtongsoluong.setHorizontalAlignment(SwingConstants.CENTER);
		kqtongsoluong.setFont(new Font("Arial", Font.BOLD, 15));
		panel_conduoi.add(kqtongsoluong);
		btn_nhaphang = new JButton("Xuất hàng");
		btn_nhaphang.setFont(new Font("Arial", Font.BOLD, 20));
		panel_benduoi.add(btn_nhaphang);

		btn_quaylai = new JButton("Quay lại");
		btn_quaylai.setFont(new Font("Arial", Font.BOLD, 20));
		panel_benduoi.add(btn_quaylai);

//        panel.setBounds(0, 0, 197, 763);
//        JLabel manhanvien = new JLabel("Mã nhân viên");
//        manhanvien.setFont(new Font("Arial", Font.BOLD, 15));
//        panel_bentren.add(manhanvien);
//	        jtmanhanvien = new JTextField();
//	        panel_bentren.add(jtmanhanvien);
//	        jtmanhanvien.setColumns(1);
//        

		JPanel panel_1 = new JPanel();
		panel_nhaphang.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);

		JPanel panel_giua = new JPanel();
//	        panel_nhaphang.add(panel_giua, BorderLayout.CENTER);
		panel_giua.setLayout(new GridLayout(1, 2, 0, 0));
		panel_1.add(panel_giua, BorderLayout.CENTER);

		JPanel panelg_trai = new JPanel();
		panel_giua.add(panelg_trai);
		JPanel panelg_phai = new JPanel();
		panel_giua.add(panelg_phai);
		panelg_phai.setLayout(new GridLayout(5, 2, 0, 0));
		panelg_trai.setLayout(new BorderLayout(0, 0));

		JPanel panelg_trai_tren = new JPanel();
		panelg_trai.add(panelg_trai_tren, BorderLayout.NORTH);
		panelg_trai_tren.setLayout(new BoxLayout(panelg_trai_tren, BoxLayout.X_AXIS));
		jt_otimkiem = new JTextField();
		panelg_trai_tren.add(jt_otimkiem);

		btn_timkiem = new JButton("Làm mới", source.icon_refresh);
		btn_timkiem.setBackground(new Color(255, 255, 255));
		btn_timkiem.setFont(new Font("Arial", Font.BOLD, 20));
		panelg_trai_tren.add(btn_timkiem);

		JLabel jl_masanpham = new JLabel("Mã sản phẩm");
		jl_masanpham.setHorizontalAlignment(SwingConstants.CENTER);
		jl_masanpham.setFont(new Font("Arial", Font.BOLD, 15));
		panelg_phai.add(jl_masanpham);

		jt_masanpham = new JTextField();
		jt_masanpham.setEnabled(false);
		jt_masanpham.setToolTipText("");
		panelg_phai.add(jt_masanpham);
		jt_masanpham.setColumns(1);
		JLabel jl_tensanpham = new JLabel("Tên sản phẩm");
		jl_tensanpham.setHorizontalAlignment(SwingConstants.CENTER);
		jl_tensanpham.setFont(new Font("Arial", Font.BOLD, 15));
		panelg_phai.add(jl_tensanpham);
		jt_tensanpham = new JTextField();
		jt_tensanpham.setEnabled(false);
		panelg_phai.add(jt_tensanpham);
		jt_tensanpham.setColumns(1);
		JLabel jl_soluong = new JLabel("Số lượng");
		jl_soluong.setHorizontalAlignment(SwingConstants.CENTER);
		jl_soluong.setFont(new Font("Arial", Font.BOLD, 15));
		panelg_phai.add(jl_soluong);
		jt_soluong = new JTextField();
		panelg_phai.add(jt_soluong);
		jt_soluong.setColumns(1);

		JLabel jl_thanhtien = new JLabel("Thành tiền");
		jl_thanhtien.setHorizontalAlignment(SwingConstants.CENTER);
		jl_thanhtien.setFont(new Font("Arial", Font.BOLD, 15));
		panelg_phai.add(jl_thanhtien);
		jt_thanhtien = new JTextField();
		jt_thanhtien.setEnabled(false);
		panelg_phai.add(jt_thanhtien);
		jt_thanhtien.setColumns(1);

		btn_suasp = new JButton("Sửa sản phẩm");
		btn_suasp.setIcon(new ImageIcon(XuatHang.class.getResource("/img/pencil.png")));
		btn_suasp.setBackground(new Color(255, 128, 64));
		btn_suasp.setEnabled(false);
		btn_suasp.setFont(new Font("Arial", Font.BOLD, 20));
		panelg_phai.add(btn_suasp);

		btn_xoasp = new JButton("Xóa sản phẩm");
		btn_xoasp.setIcon(new ImageIcon(XuatHang.class.getResource("/img/remove.png")));
		btn_xoasp.setBackground(new Color(255, 128, 128));
		btn_xoasp.setEnabled(false);
		btn_xoasp.setFont(new Font("Arial", Font.BOLD, 20));
		panelg_phai.add(btn_xoasp);
//	        JLabel jl_masanpham = new JLabel("Mã sản phẩm");
//	        jl_masanpham.setFont(new Font("Arial", Font.BOLD, 15));
//	        panelg_phai.add(jl_masanpham);
//	        JLabel jl_tensanpham = new JLabel("Tên sản phẩm");
//	        jl_tensanpham.setFont(new Font("Arial", Font.BOLD, 15));
//	        panelg_phai.add(jl_tensanpham);
//	        jt_masanpham = new JTextField();
//	        panelg_phai.add(jt_masanpham);
//	        jt_masanpham.setColumns(1);   
//	        jt_tensanpham = new JTextField();
//	        panelg_phai.add(jt_tensanpham);
//	        jt_tensanpham.setColumns(1);  

		String column[] = { "Mã máy", "Tên máy", "Số lượng" };
		Object data[][] = {};
//			 panel_phai.setLayout(new BorderLayout(0, 0));
		table = new JTable(data, column);
//			 table.addKeyListener(new KeyAdapter() {
//			 	@Override
//			 	public void keyPressed(KeyEvent e) {
//			 	}
//			 });
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(197, 0, 100, 100);
		panelg_trai.add(scrollPane, BorderLayout.CENTER);
		table.setDefaultEditor(Object.class, null);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã máy", "Tên máy", "Số lượng" }));

		model = (DefaultTableModel) table.getModel();
		for (Laptop sp : sanpham) {
			stt = 0;
			model.addRow(new Object[] { sp.getMaLaptop(), sp.getTenLaptop(), sp.getSoLuong() });
		}
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);

		JPanel panelg_trai_duoi = new JPanel();
		panelg_trai.add(panelg_trai_duoi, BorderLayout.SOUTH);
		panelg_trai_duoi.setLayout(new GridLayout(1, 2, 0, 0));
		btn_themsp = new JButton("Thêm sản phẩm");
		btn_themsp.setIcon(new ImageIcon(XuatHang.class.getResource("/img/plus.png")));
		btn_themsp.setBackground(new Color(0, 255, 255));
		btn_themsp.setFont(new Font("Arial", Font.BOLD, 20));
		btn_nhapexcel = new JButton("Nhập Excel");
		btn_nhapexcel.setIcon(new ImageIcon(XuatHang.class.getResource("/img/nhapExcel.png")));
		btn_nhapexcel.setBackground(new Color(0, 255, 0));
		btn_nhapexcel.setFont(new Font("Arial", Font.BOLD, 20));
		panelg_trai_duoi.add(btn_themsp);
		panelg_trai_duoi.add(btn_nhapexcel);

		String column1[] = { "Mã máy", "Tên máy", "Số lượng", "Đơn giá" };
		Object data1[][] = {};
		panel_3.setLayout(new BorderLayout(0, 0));
//			 panel_phai.setLayout(new BorderLayout(0, 0));
		table1 = new JTable(data1, column1);
		JScrollPane scrollPane1 = new JScrollPane(table1);
		scrollPane1.setBounds(197, 0, 100, 100);
		panel_3.add(scrollPane1);
		table1.setDefaultEditor(Object.class, null);
		table1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "Mã nhà cung cấp", "Mã sản phẩm",
				"Tên sản phẩm", "CPU", "GPU", "Ram", "Rom", "Hệ điều hành", "Màn hình", "Hãng", "Gía", "Số lượng" }));

		model1 = (DefaultTableModel) table1.getModel();
//			for (PhieuNhap sp : sanpham) {
//				
//			    model.addRow(new Object[] {
//			    		stt,sp.getMaPhieuNhap(),PhieuNhapDao.getInstance().laytennhacungcap(sp.getMaNhaCungCap()),PhieuNhapDao.getInstance().laytennhanvien(sp.getMaNhanVien()),sp.getNgayNhap(),sp.getTongTien()
//			    });
//			}
		table1.getTableHeader().setResizingAllowed(false);
		table1.getTableHeader().setReorderingAllowed(false);

			Controllerxuathang.ActionListener(btn_themsp, this);
			Controllerxuathang.addKeyListener(jt_otimkiem, this);
			Controllerxuathang.addKeyListener(jt_soluong, this);
			Controllerxuathang.addMouseListener(table, this);
//			Controllerxuathang.addMouseListener(table1, this);
			Controllerxuathang.ActionListener(btn_nhaphang, this);
			Controllerxuathang.ActionListener(btn_quaylai, this);
			Controllerxuathang.ActionListener(btn_timkiem, this);
			Controllerxuathang.ActionListener(btn_suasp, this);
			Controllerxuathang.ActionListener(btn_xoasp, this);

	}
	public void suasanphamthem() {
		int i = table1.getSelectedRow();
		System.out.println(i);
		jt_masanpham.setText(model1.getValueAt(i, 2) + "");
		jt_tensanpham.setText(model1.getValueAt(i, 3) + "");
		jt_soluong.setText(model1.getValueAt(i, 12) + "");
		jt_thanhtien.setText(model1.getValueAt(i, 11) + "");
		update();
	}

	public void xoasanphamthem() {
		int i = table1.getSelectedRow();
		if (i < 0)
			JOptionPane.showConfirmDialog(null, "Bạn chưa chọn dòng cần xóa", "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
		else {
			int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa nó không ?");
			if (luachon == JOptionPane.YES_OPTION) {
				String mp = model1.getValueAt(i, 1) + "";
//    		 PhieuNhapDao.getInstance().deletetheoma(mp);
				model1.removeRow(i);
			}
		}
		update();
	}
	public void thanhtimkiem() {
		stt = 0;
		model.setRowCount(0);
		String textall = jt_otimkiem.getText();
		for (Laptop sp : sanpham) {
			stt = 0;
			if (sp.getMaLaptop().contains(textall) || sp.getTenLaptop().contains(textall)) {
				model.addRow(new Object[] { sp.getMaLaptop(), sp.getTenLaptop(), sp.getSoLuong() });
			}
		}
		update();

	}

	public void lammoithanh() {
		model.setRowCount(0);
		jt_otimkiem.setText("");
		for (Laptop sp : sanpham) {
			stt = 0;
			model.addRow(new Object[] { sp.getMaLaptop(), sp.getTenLaptop(), sp.getSoLuong() });
		}
		update();
	}

	public void nutquaylai() {
		panel_nhaphang.setVisible(false);
		panel_nhaphang.removeAll();
		Phieunhap pn = new Phieunhap();
		panel_nhaphang.add(pn.panel_phieunhap);
		panel_nhaphang.setVisible(true);
		update();
	}

	public void nhaphang() {
		String maphieun = jl_mapn.getText().toUpperCase();
		String manhacc = comboBox_ch.getSelectedItem().toString().toUpperCase();
//		String tongtienn = tongtien + "";
		String manhanvi = comboBox_nv.getSelectedItem().toString().toUpperCase();
		
		if(maphieun.isEmpty()||manhacc.isEmpty()||manhanvi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		ArrayList<PhieuXuat> pn=PhieuXuatDao.getInstance().selectAll();
		for(PhieuXuat p:pn) {
			if(maphieun.equals(p.getMaPhieuXuat())){
				JOptionPane.showMessageDialog(null, "Mã phiếu xuất đã tồn tại", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				jl_mapn.setText("");
				return;
			}
		}
			
		
//		String xoais = 0 + "
		
//		System.out.println(maphieun);
//		DecimalFormat df2 = new DecimalFormat("#");
//		String formattedNumber2 = df2.format(Double.parseDouble(tongtienn));
//	 	public PhieuXuat(String maPhieuXuat, String maCuaHang, String maNhanVien, Date ngayXuat, double tongTien, int isDelete) {
		PhieuXuat pn1 = new PhieuXuat(maphieun, manhacc, manhanvi, date, Double.parseDouble(kqtongtiennn.getText()),Integer.parseInt(kqtongsoluong.getText()), 0);
		PhieuXuatDao.getInstance().insert(pn1);
		for (int i = 0; i < table1.getRowCount(); i++) {
			String masanpham = model1.getValueAt(i, 2) + "";
			int soluongm = Integer.parseInt(String.valueOf(model1.getValueAt(i, 12)));

			String thanhtienm = model1.getValueAt(i, 11) + "";
//				public ChiTietPhieuXuat(String maPhieuXuat, String maLaptop, int soLuong, Double thanhTien, int isDelete) {
			ChiTietPhieuXuat ctpn = new ChiTietPhieuXuat(maphieun, masanpham, soluongm, Double.parseDouble(thanhtienm),0);
			PhieuXuatDao.getInstance().inchitietphieu(ctpn);
			LaptopDAO.getintance().update1dulieu(masanpham, 0-soluongm);
		}
		model.setRowCount(0);
		model1.setRowCount(0);
		jl_mapn.setText("");
		comboBox_ch.setSelectedIndex(0);
		comboBox_nv.setSelectedIndex(0);
		sanpham = LaptopDAO.getintance().selectAll();
		for (Laptop sp : sanpham) {
			stt = 0;
			model.addRow(new Object[] { sp.getMaLaptop(), sp.getTenLaptop(), sp.getSoLuong() });
		}
		update();
		JOptionPane.showConfirmDialog(null, "Nhập hàng thành công", "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
	}

	public void clickvaotable1() {
		btn_xoasp.setBackground(new Color(255, 128, 128));
		btn_suasp.setBackground(new Color(255, 128, 64));
		btn_themsp.setBackground(new Color(255, 255, 255));
		btn_nhapexcel.setBackground(new Color(255, 255, 255));
		btn_xoasp.setForeground(new Color(255, 255, 255));
		btn_suasp.setForeground(new Color(255, 255, 255));
		int rowCount = model1.getRowCount();
		if (rowCount > 0) {
			int lastRow = rowCount - 1;
			table1.setRowSelectionInterval(lastRow, lastRow);
			table1.changeSelection(lastRow, 0, true, true);
		}
		update();
	}

	public void themsanpham() {
		thu = 0;
		jt_soluong.setText("");
		btn_suasp.setBackground(new Color(255, 255, 255));
		btn_xoasp.setBackground(new Color(255, 255, 255));
		table1.setRowSelectionAllowed(false);
		btn_suasp.setEnabled(false);
		btn_xoasp.setEnabled(false);
		int i = table.getSelectedRow();
		jt_masanpham.setText(model.getValueAt(i, 0) + "");
		jt_tensanpham.setText(model.getValueAt(i, 1) + "");
		thu = i;
		update();
	}

	public void themvaobang() {
		if (jt_soluong.getText().length() > 0) {
			if (Long.parseLong(jt_soluong.getText()) <= Long.parseLong(model.getValueAt(thu, 2) + "")) {
				stt1++;
				Laptop lt = LaptopDAO.getintance().selectById(jt_masanpham.getText());
				model1.addRow(new Object[] {
//					"STT","Mã sản phẩm","Tên sản phẩm","CPU","GPU","Ram","Rom","Hệ điều hành","Màn hình","Hãng","Gía","Số lượng"
						stt1, lt.getMaNhaCungCap(), lt.getMaLaptop(), lt.getTenLaptop(), lt.getCPU(), lt.getGPU(),
						lt.getRam(), lt.getRom(), lt.getHeDieuHanh(), lt.getManHinh(), lt.getHang(),
						jt_thanhtien.getText(), jt_soluong.getText()

				});
				int rowCount = model1.getRowCount();
				if (rowCount > 0) {
					int lastRow = rowCount - 1;
					table1.setRowSelectionInterval(lastRow, lastRow);
					table1.changeSelection(lastRow, 0, false, false);
					table1.setRowSelectionAllowed(true);

				}
				update();
				jt_masanpham.setText("");
				jt_tensanpham.setText("");
				jt_soluong.setText("");
				jt_thanhtien.setText("");
				btn_suasp.setEnabled(true);
				btn_xoasp.setEnabled(true);
				btn_suasp.setBackground(new Color(255, 128, 64));
				btn_xoasp.setBackground(new Color(255, 128, 128));
			} else
				JOptionPane.showConfirmDialog(null, "Số lượng bạn xuất lớn hơn số lượng đang có ở hiện tại",
						"THÔNG BÁO", JOptionPane.CLOSED_OPTION);
		} else
			JOptionPane.showConfirmDialog(null, "Bạn chưa nhập số lượng", "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
	}

	public void hiengiakhithem() {
		String sol = jt_soluong.getText();
		if (sol.length() > 0) {
			int j = table.getSelectedRow();
			String tmpma = model.getValueAt(j, 0) + "";
			Laptop lap = LaptopDAO.getintance().selectById(tmpma);
			double giaca = Double.parseDouble(sol) * lap.getGia();
			DecimalFormat df = new DecimalFormat("#");
			String formattedNumber = df.format(giaca);
			jt_thanhtien.setText(formattedNumber);
		}
	}
	public void update() {
		tongsoluongphieu=0;
		tongtien=0.0;
		for(int i=0;i<table1.getRowCount();i++) {
			tongsoluongphieu+=Integer.parseInt(model1.getValueAt(i, 12).toString());
			tongtien += Double.parseDouble(model1.getValueAt(i, 11).toString());
		}
		kqtongtiennn.setText(String.valueOf(tongtien));
		kqtongsoluong.setText(String.valueOf(tongsoluongphieu));
	}
}