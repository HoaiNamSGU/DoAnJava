package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BoxLayout;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controllernhaphang;
import dao.IMEIDAO;
import dao.LaptopDAO;
import dao.NhanVienDAO;
import dao.PhieuNhapDao;
import dao.nhacungcapDao;
import model.ChiTietPhieuNhap;
import model.Laptop;
import model.NhaCungCap;
import model.NhanVien;
import model.PhieuNhap;

public class NhapHang extends JFrame {
	ArrayList<Laptop> sanpham = LaptopDAO.getintance().selectAll();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_menu;
	public JTable table;
	private DefaultTableModel model;
	public JTable table1;
	private DefaultTableModel model1;
	private JPanel panel_menu1;
	private JPanel panel_trenn;
	private JPanel panel_duoii;
	private JTextField jl_mapn;
	private JTextField jt_ngaynhap;
	private JTextField jt_masanpham;
	private JTextField jt_tensanpham;
	public JTextField jt_soluong;
	private JTextField jt_thanhtien;
	public JTextField jt_otimkiem;
	private int stt = 0, stt1 = 0;
	private double tongtien = 0;
	public JPanel panel_nhaphang;
	public JButton btn_themsp;
	public JButton btn_suasp;
	public JButton btn_xoasp;
	private JLabel kqtongtiennn;
	private JButton btn_nhapexcel;
	public JButton btn_nhaphang;
	private LocalDate ngay = LocalDate.now();
	private Date date = Date.valueOf(ngay);
	public JButton btn_quaylai;
	public JButton btn_timkiem;
	private int tongsoluongphieu = 0, sua = 0;
	private Laptop lt;
	private JLabel tongsoluog;
	private JLabel kqtongsoluong;
	public JComboBox comboBox_ncc;
	private JLabel Label_nv;

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
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel_menu = new JPanel();
		panel_menu.setBackground(new Color(0, 128, 192));
		contentPane.add(panel_menu, BorderLayout.WEST);
		panel_menu.setForeground(new Color(255, 255, 255));
		panel_menu.setBounds(0, 0, 197, 763);
//		panel_cungcap.setBackground(new Color(192, 192, 192));
//		getContentPane().add(panel_cungcap);
		panel_menu.setLayout(new GridLayout(13, 1, 0, 0));
//		scrollPane.setBounds(0, 0, 1189, 602);

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
		gbl_panel_bentren.columnWidths = new int[] { 113, 113, 0 };
		gbl_panel_bentren.rowHeights = new int[] { 134, 134, 134, 134, 0 };
		gbl_panel_bentren.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_bentren.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_bentren.setLayout(gbl_panel_bentren);
		JLabel mapn = new JLabel("Mã phiếu nhập");
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
		JLabel manhacc = new JLabel("Mã nhà cung cấp");
		manhacc.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_manhacc = new GridBagConstraints();
		gbc_manhacc.fill = GridBagConstraints.BOTH;
		gbc_manhacc.insets = new Insets(50, 0, 50, 5);
		gbc_manhacc.gridx = 0;
		gbc_manhacc.gridy = 1;
		panel_bentren.add(manhacc, gbc_manhacc);

		ArrayList<NhaCungCap> ncc = nhacungcapDao.getInstance().selectAll();
		ArrayList<String> ncc1 = new ArrayList<>(); // Khởi tạo ArrayList<String> ncc1
		ncc1.add("");
		for (NhaCungCap nc : ncc) {
			if (nc.getIsDelete() != 1)
				ncc1.add(nc.getMaNhaCungCap()); // Thêm tên nhà cung cấp vào danh sách ncc1
		}
		comboBox_ncc = new JComboBox<String>(ncc1.toArray(new String[0])); // Chuyển ArrayList thành mảng String và sử
																			// dụng nó cho JComboBox
		GridBagConstraints gbc_comboBox_ncc = new GridBagConstraints();
		gbc_comboBox_ncc.fill = GridBagConstraints.BOTH;
		gbc_comboBox_ncc.insets = new Insets(50, 0, 50, 0);
		gbc_comboBox_ncc.gridx = 1;
		gbc_comboBox_ncc.gridy = 1;
		panel_bentren.add(comboBox_ncc, gbc_comboBox_ncc);
		JLabel ngaynhap = new JLabel("Ngày nhập");
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
		gbc_manhanvien.insets = new Insets(0, 0, 0, 5);
		gbc_manhanvien.gridx = 0;
		gbc_manhanvien.gridy = 3;
		panel_bentren.add(manhanvien, gbc_manhanvien);

		Label_nv = new JLabel(view.mainView.nhanvien.getMaNhanVien());
		Label_nv.setEnabled(false);
		GridBagConstraints gbc_label_nv = new GridBagConstraints();
		gbc_label_nv.insets = new Insets(50, 0, 50, 0);
		gbc_label_nv.gridx = 1;
		gbc_label_nv.gridy = 3;
		panel_bentren.add(Label_nv, gbc_label_nv);

		ArrayList<NhanVien> nv = NhanVienDAO.getintance().selectAll();
		ArrayList<String> nv1 = new ArrayList<>(); // Khởi tạo ArrayList<String> ncc1
		nv1.add("");
		for (NhanVien n : nv) {
			if (n.getIsDelete() != 1)
				nv1.add(n.getMaNhanVien()); // Thêm tên nhà cung cấp vào danh sách ncc1
		}

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

		btn_nhaphang = new JButton("Nhập hàng");
		btn_nhaphang.setFont(new Font("Arial", Font.BOLD, 20));
		panel_benduoi.add(btn_nhaphang);

		btn_quaylai = new JButton("Xem chi tiết");
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

		btn_timkiem = new JButton("Làm mới", new ImageIcon(NhapHang.class.getResource("/img/arrow.png")));
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
		btn_suasp.setIcon(new ImageIcon(NhapHang.class.getResource("/img/pencil.png")));
		btn_suasp.setFont(new Font("Arial", Font.BOLD, 16));
		panelg_phai.add(btn_suasp);

		btn_xoasp = new JButton("Xóa sản phẩm");
		btn_xoasp.setIcon(new ImageIcon(NhapHang.class.getResource("/img/remove.png")));
		btn_xoasp.setFont(new Font("Arial", Font.BOLD, 16));
		panelg_phai.add(btn_xoasp);
		btn_suasp.setBackground(new Color(255, 128, 64));
		btn_xoasp.setBackground(new Color(255, 128, 128));
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
			model.addRow(new Object[] { sp.getMaLaptop(), sp.getTenLaptop(), sp.getSoLuong() });
		}
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);

		JPanel panelg_trai_duoi = new JPanel();
		panelg_trai.add(panelg_trai_duoi, BorderLayout.SOUTH);
		panelg_trai_duoi.setLayout(new GridLayout(1, 2, 0, 0));
		btn_themsp = new JButton("Thêm sản phẩm");
		btn_themsp.setIcon(new ImageIcon(NhapHang.class.getResource("/img/plus.png")));
		btn_themsp.setBackground(new Color(0, 255, 255));
		btn_themsp.setFont(new Font("Arial", Font.BOLD, 16));
		btn_nhapexcel = new JButton("Nhập Excel");
		btn_nhapexcel.setIcon(new ImageIcon(NhapHang.class.getResource("/img/nhapExcel.png")));
		btn_nhapexcel.setBackground(new Color(0, 255, 0));
		btn_nhapexcel.setFont(new Font("Arial", Font.BOLD, 16));
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
		table1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã sản phẩm", "Tên sản phẩm", "CPU",
				"GPU", "Ram", "Rom", "Hệ điều hành", "Màn hình", "Hãng", "Gía", "Số lượng" }));

		model1 = (DefaultTableModel) table1.getModel();
//			for (PhieuNhap sp : sanpham) {
//				
//			    model.addRow(new Object[] {
//			    		stt,sp.getMaPhieuNhap(),PhieuNhapDao.getInstance().laytennhacungcap(sp.getMaNhaCungCap()),PhieuNhapDao.getInstance().laytennhanvien(sp.getMaNhanVien()),sp.getNgayNhap(),sp.getTongTien()
//			    });
//			}
		table1.getTableHeader().setResizingAllowed(false);
		table1.getTableHeader().setReorderingAllowed(false);

		Controllernhaphang.ActionListener(btn_themsp, this);
		Controllernhaphang.addKeyListener(jt_otimkiem, this);
		Controllernhaphang.addKeyListener(jt_soluong, this);
		Controllernhaphang.addMouseListener(table, this);
		Controllernhaphang.addMouseListener(table1, this);
		Controllernhaphang.ActionListener(btn_nhaphang, this);
		Controllernhaphang.ActionListener(btn_quaylai, this);
		Controllernhaphang.ActionListener(btn_timkiem, this);
		Controllernhaphang.ActionListener(btn_xoasp, this);
		Controllernhaphang.ActionListener(btn_suasp, this);
		Controllernhaphang.addActionListener(comboBox_ncc, this);

	}

	public void suasanphamthem() {
		int i = table1.getSelectedRow();
		if (i < 0)
			JOptionPane.showConfirmDialog(null, "Bạn chưa chọn dòng sửa", "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
		else {
			if (sua != 0) {
				model1.setValueAt(jt_soluong.getText(), i, 10);
				model1.setValueAt(jt_thanhtien.getText(), i, 9);
				

			} else {
				jt_masanpham.setText(model1.getValueAt(i, 0) + "");
				jt_tensanpham.setText(model1.getValueAt(i, 1) + "");
				jt_soluong.setText(model1.getValueAt(i, 10) + "");
				jt_thanhtien.setText(model1.getValueAt(i, 9) + "");
				sua++;
			}
			update();
		}
	}

	public void xoasanphamthem() {
		int i = table1.getSelectedRow();
		if (i < 0)
			JOptionPane.showConfirmDialog(null, "Bạn chưa chọn dòng cần xóa", "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
		else {
			int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa nó không ?");
			if (luachon == JOptionPane.YES_OPTION) {
				model1.removeRow(i);
			}
		}
		update();
	}

	public void thanhtimkiem() {
		model.setRowCount(0);
		String textall = jt_otimkiem.getText();
		for (Laptop sp : sanpham) {
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
		String manhacc = comboBox_ncc.getSelectedItem().toString().toUpperCase();
//		String tongtienn = tongtien + "";
		String manhanvi = Label_nv.getText().toString().toUpperCase();
		if (maphieun.isEmpty() || manhacc.isEmpty() || manhanvi.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return;
		}
		ArrayList<PhieuNhap> pn = PhieuNhapDao.getInstance().selectAll();
		for (PhieuNhap p : pn) {
			if (maphieun.equals(p.getMaPhieuNhap())) {
				JOptionPane.showMessageDialog(null, "Mã phiếu nhập đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
				jl_mapn.setText("");
				return;
			}
		}
		// String xoais = 0 + "";
//		DecimalFormat df2 = new DecimalFormat("#");
//		String formattedNumber2 = df2.format(Double.parseDouble(tongtienn));
		PhieuNhap pn1 = new PhieuNhap(maphieun, manhacc, manhanvi, Double.parseDouble(kqtongtiennn.getText()),
				Integer.parseInt(kqtongsoluong.getText()), date, 0);
		PhieuNhapDao.getInstance().insert(pn1);
		for (int i = 0; i < table1.getRowCount(); i++) {
			String masanpham = model1.getValueAt(i, 0) + "";
			String soluongm = model1.getValueAt(i, 10) + "";
			String thanhtienm = model1.getValueAt(i, 9) + "";
//				public ChiTietPhieuNhap(String maPhieuNhap, String maLaptop, int soLuong, Double thanhTien, int isDelete) {

			ChiTietPhieuNhap chitietphieunhap = new ChiTietPhieuNhap(maphieun, masanpham, Integer.parseInt(soluongm),
					Double.parseDouble(thanhtienm), 0);
			System.out.println(chitietphieunhap.getMaPhieuNhap());
			PhieuNhapDao.getInstance().inchitietphieu(chitietphieunhap);
			LaptopDAO.getintance().update1dulieu(masanpham, Integer.parseInt(soluongm));
		}
		comboBox_ncc.setSelectedIndex(0);
		thaydoicomboboxnhac();
		model1.setRowCount(0);
		jl_mapn.setText(null);
		jt_masanpham.setText("");
		jt_tensanpham.setText("");
		jt_soluong.setText("");
		jt_thanhtien.setText("");
		JOptionPane.showConfirmDialog(null, "Nhập hàng thành công", "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
		IMEIDAO.getintance().InsertALL(pn1.getMaPhieuNhap(), pn1.getTongSoLuong());

		update();
	}

	public void clickvaotable1() {
		sua = 0;
//		 btn_xoasp.setBackground(new Color(255, 128, 128));
//		    btn_suasp.setBackground(new Color(255, 128, 64));
//	        btn_themsp.setBackground(new Color(255, 255, 255));
//	        btn_nhapexcel.setBackground(new Color(255, 255, 255));
//	        btn_xoasp.setForeground(new Color(255, 255, 255));
//	        btn_suasp.setForeground(new Color(255, 255, 255));
//	        int rowCount = model1.getRowCount();
//		    if (rowCount > 0) {
//		        int lastRow = rowCount-1;
//		        table1.setRowSelectionInterval(lastRow, lastRow);
//		        table1.changeSelection(lastRow, 0, true, true);
//		    }
		jt_thanhtien.setText("");
		update();
	}

	public void themsanpham() {
		jt_soluong.setText("");
//	    table1.setRowSelectionAllowed(false);
		int i = table.getSelectedRow();
		jt_masanpham.setText(model.getValueAt(i, 0) + "");
		jt_tensanpham.setText(model.getValueAt(i, 1) + "");
		update();
	}

	public void themvaobang() {
//		if(table.getSelectedRow()!=-1) {
//			String tmpma = model.getValueAt(table.getSelectedRow(), 0).toString();
//			Laptop lap = LaptopDAO.getintance().lay1sp(tmpma);
//			String currentNCC=lap.getMaNhaCungCap();
//			comboBox_ncc.setSelectedItem(currentNCC);
//		}
		if (jt_soluong.getText().length() > 0) {
			int j = table1.getRowCount();
			if (j >= 1) {
				int z = table.getSelectedRow();
//				 String mncccheck=model1.getValueAt(0, 1)+"";
				Laptop lt2 = LaptopDAO.getintance().lay1sp(model1.getValueAt(0, 0) + "");
				Laptop lt1 = LaptopDAO.getintance().lay1sp(model.getValueAt(z, 0) + "");
				if (!lt2.getMaNhaCungCap().equals(lt1.getMaNhaCungCap()))
					JOptionPane.showConfirmDialog(null, "Bạn chỉ được nhập 1 nhà cung cấp", "THÔNG BÁO",
							JOptionPane.CLOSED_OPTION);
				else {
					lt = LaptopDAO.getintance().lay1sp(jt_masanpham.getText());
					stt1++;
					tongsoluongphieu += Integer.parseInt(jt_soluong.getText());
					model1.addRow(new Object[] { lt.getMaLaptop(), lt.getTenLaptop(), lt.getCPU(), lt.getGPU(),
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

				}
			} else {

				lt = LaptopDAO.getintance().lay1sp(jt_masanpham.getText());
				// nếu là sản phẩm đầu tiên thì tự động chọn ncc dựa trên sp đó
				String currentNCC = lt.getMaNhaCungCap();
				comboBox_ncc.setSelectedItem(currentNCC);

				model1.addRow(new Object[] { lt.getMaLaptop(), lt.getTenLaptop(), lt.getCPU(), lt.getGPU(), lt.getRam(),
						lt.getRom(), lt.getHeDieuHanh(), lt.getManHinh(), lt.getHang(), jt_thanhtien.getText(),
						jt_soluong.getText()

				});
				int rowCount = model1.getRowCount();
				if (rowCount > 0) {
					int lastRow = rowCount - 1;
					table1.setRowSelectionInterval(lastRow, lastRow);
					table1.changeSelection(lastRow, 0, false, false);
					table1.setRowSelectionAllowed(true);

				}

//		    btn_suasp.setEnabled(true);
//		    btn_xoasp.setEnabled(true);
//		    btn_suasp.setBackground(new Color(255, 128, 64));
//	        btn_xoasp.setBackground(new Color(255, 128, 128));
			}
			jt_masanpham.setText("");
			jt_tensanpham.setText("");
			jt_soluong.setText("");
			jt_thanhtien.setText("");
		} else
			JOptionPane.showConfirmDialog(null, "Bạn chưa nhập số lượng", "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
		update();
	}

	public void hiengiakhithem() {
		String sol = jt_soluong.getText();
		if (sol.length() > 0) {
			int j = table.getSelectedRow();
			String tmpma = model.getValueAt(j, 0) + "";
			Laptop lap = LaptopDAO.getintance().lay1sp(tmpma);
			double giaca = Double.parseDouble(sol) * lap.getGia();
			DecimalFormat df = new DecimalFormat("#");
			String formattedNumber = df.format(giaca);
			jt_thanhtien.setText(formattedNumber);
		} else
			jt_thanhtien.setText("");
		update();

	}

	// cập nhật tổng tiền và tổng số lượng
	public void update() {
		tongsoluongphieu = 0;
		tongtien = 0.0;
		for (int i = 0; i < table1.getRowCount(); i++) {
			tongsoluongphieu += Integer.parseInt(model1.getValueAt(i, 10).toString());
			tongtien += Double.parseDouble(model1.getValueAt(i, 9).toString());
		}
		DecimalFormat df = new DecimalFormat("#");
		String formattedNumber = df.format(tongtien);
		kqtongtiennn.setText(formattedNumber);
		kqtongsoluong.setText(String.valueOf(tongsoluongphieu));
		setEnableComboBoxNcc();
	}

	// cập nhật dữ liệu bả nhỏ comboBox dựa trên combobox ncc
	public void thaydoicomboboxnhac() {
		String str = (String) comboBox_ncc.getSelectedItem();
		if (!str.isEmpty()) {
			model.setRowCount(0);
			ArrayList<Laptop> newSp = LaptopDAO.getintance().Select_search("MaNhaCungCap", str);
			for (Laptop sp : newSp)
				if (sp.getMaNhaCungCap().equals(str))
					model.addRow(new Object[] { sp.getMaLaptop(), sp.getTenLaptop(), sp.getSoLuong() });
			sanpham = newSp;
			return;
		}
		// nếu combobox trống thì trả về toàn bộ sp s
		sanpham = LaptopDAO.getintance().selectAll();
		lammoithanh();
	}

	public void setEnableComboBoxNcc() {
		if (table1.getRowCount() != 0) {
			comboBox_ncc.setEnabled(false);
			return;
		}
		comboBox_ncc.setEnabled(true);
	}
}