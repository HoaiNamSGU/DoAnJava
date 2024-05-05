package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.Controllernhacungcap;
import dao.nhacungcapDao;
import img.Source;
import model.NhaCungCap;

public class Nhacungcap extends JPanel {
	private JTextField textField;
	private NhaCungCap nhacung1;
	ArrayList<NhaCungCap> dsnhacungcap = nhacungcapDao.getInstance().selectAll();
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
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jp_chucnang;
	private Source source = new Source();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nhacungcap frame = new Nhacungcap();
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
	public Nhacungcap() {
		this.setBounds(0, 0, 1200, 770);
		setLayout(new BorderLayout(0, 0));
		panel_cungcap = new JPanel();
		panel_cungcap.setLayout(new BorderLayout(0, 0));
		add(panel_cungcap);

		jp_chucnang = new JPanel();
		jp_chucnang.setBounds(10, 10, 398, 97);
//			jp_chucnang.setLayout(new FlowLayout());
//			jp_chucnang.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50)); // Thiết lập FlowLayout với khoảng cách giữa các thành phần là 10px
		jp_chucnang.setLayout(new GridLayout(1, 2, 50, 20));
		panel_cungcap.add(jp_chucnang, BorderLayout.NORTH);

		JPanel jc_cntrai = new JPanel();
		jc_cntrai.setBounds(10, 10, 398, 97);
		jc_cntrai.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jp_chucnang.add(jc_cntrai);
		jc_cntrai.setLayout(new GridLayout(2, 5, 0, 0));

		JPanel jp_timkiem = new JPanel();
		jp_timkiem.setBounds(450, 10, 695, 97);
		jp_timkiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jp_chucnang.add(jp_timkiem);

		String[] options = { "Tất cả", "Mã cung cấp", "Địa chỉ", "Số điện thoại", "Email", "Tên" };
		GridBagLayout gbl_jp_timkiem = new GridBagLayout();
		gbl_jp_timkiem.columnWidths = new int[] { 187, 187, 187 };
		gbl_jp_timkiem.rowHeights = new int[] { 32, 32 };
		gbl_jp_timkiem.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_jp_timkiem.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		jp_timkiem.setLayout(gbl_jp_timkiem);
		cbb_timkiem = new JComboBox<Object>(options);
		cbb_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_cbb_timkiem = new GridBagConstraints();
		gbc_cbb_timkiem.weighty = 1.0;
		gbc_cbb_timkiem.weightx = 1.0;
		gbc_cbb_timkiem.fill = GridBagConstraints.BOTH;
		gbc_cbb_timkiem.insets = new Insets(0, 0, 0, 5);
		gbc_cbb_timkiem.gridx = 0;
		gbc_cbb_timkiem.gridy = 0;
		jp_timkiem.add(cbb_timkiem, gbc_cbb_timkiem);

		cbb_timkiem.setSelectedIndex(0);

		txtx_timkiem = new JTextField();
		GridBagConstraints gbc_txtx_timkiem = new GridBagConstraints();
		gbc_txtx_timkiem.weighty = 1.0;
		gbc_txtx_timkiem.weightx = 1.0;
		gbc_txtx_timkiem.fill = GridBagConstraints.BOTH;
		gbc_txtx_timkiem.insets = new Insets(0, 0, 0, 5);
		gbc_txtx_timkiem.gridx = 1;
		gbc_txtx_timkiem.gridy = 0;
		jp_timkiem.add(txtx_timkiem, gbc_txtx_timkiem);
		txtx_timkiem.setColumns(50);
		Controllernhacungcap.addKeyListener(txtx_timkiem, this);

		// JLabel jlabel_them = new JLabel("Thêm", icon_add, JLabel.CENTER);
		btn_lammoi = new JButton("Làm mới", source.icon_refresh);
		btn_lammoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_lammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btn_lammoi = new GridBagConstraints();
		gbc_btn_lammoi.insets = new Insets(0, 0, 0, 5);
		gbc_btn_lammoi.weighty = 1.0;
		gbc_btn_lammoi.weightx = 1.0;
		gbc_btn_lammoi.fill = GridBagConstraints.BOTH;
		gbc_btn_lammoi.gridx = 2;
		gbc_btn_lammoi.gridy = 0;
		jp_timkiem.add(btn_lammoi, gbc_btn_lammoi);
		Controllernhacungcap.ActionListener(btn_lammoi, this);
		///////// chan///////////////
		// them
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
		jl_nutsua.setIcon(source.icon_pencil);
		JLabel jl_chusua = new JLabel("Sửa");
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

		JPanel panel_sanpham = new JPanel();
		panel_sanpham.setBounds(0, 0, 1189, 763);
		panel_cungcap.add(panel_sanpham);
		panel_sanpham.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1189, 763);
		panel_sanpham.add(scrollPane);
		String column[] = { "Mã NCC", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email" };
		Object data[][] = {};
		table = new JTable(data, column);
		table.setForeground(new Color(0, 0, 0));
		table.setDefaultEditor(Object.class, null);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã NCC", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		model = (DefaultTableModel) table.getModel();
		for (NhaCungCap nc : dsnhacungcap) {
			model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(), nc.getSDT(),
					nc.getEmail() });
		}
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 14));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		Controllernhacungcap.addMouseListener(jl_nutadd, this);
		Controllernhacungcap.addMouseListener(jl_nutxoa, this);
		Controllernhacungcap.addMouseListener(jl_nutsua, this);
		this.setVisible(true);
	}

	public void hienaddnhacungcap() {
		int i = table.getSelectedRow();
		AddNhaCungCap framee = new AddNhaCungCap(this);
		framee.setVisible(true);
	}

	public void hiensuanhacungcap() {
		int i = table.getSelectedRow();
//			public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String sDT, String email) {
		String mnc = model.getValueAt(i, 0) + "";
		String tnc = model.getValueAt(i, 1) + "";
		String dc = model.getValueAt(i, 2) + "";
		String sdt = model.getValueAt(i, 3) + "";
		String email = model.getValueAt(i, 4) + "";
		nhacung1 = new NhaCungCap(mnc, tnc, dc, sdt, email);
		FixNhaCungCap frame = new FixNhaCungCap(this, 2, nhacung1);
		frame.setVisible(true);
	}

	public void nhannutxoa() {
		int i = table.getSelectedRow();
		if (i < 0)
			JOptionPane.showConfirmDialog(null, "Bạn chưa chọn dòng cần xóa", "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
		else {
			int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa nó không ?");
			if (luachon == JOptionPane.YES_OPTION) {
				String mnc = model.getValueAt(i, 0) + "";
				String tnc = model.getValueAt(i, 1) + "";
				String dc = model.getValueAt(i, 2) + "";
				String sdt = model.getValueAt(i, 3) + "";
				String email = model.getValueAt(i, 4) + "";
				NhaCungCap nc1 = new NhaCungCap(mnc, tnc, dc, sdt, email);
				nhacungcapDao.getInstance().delete1(nc1);
				model.removeRow(i);
			}
		}
	}

	public void nutlammoi() {
		model.setRowCount(0);
		txtx_timkiem.setText("");
		ArrayList<NhaCungCap> dsNhacungcap = nhacungcapDao.getInstance().selectAll();
		for (NhaCungCap nc : dsNhacungcap) {
			model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(), nc.getSDT(),
					nc.getEmail() });
		}
		cbb_timkiem.setSelectedIndex(0);

	}

	public void thanhtimkiem() {
		dsnhacungcap = nhacungcapDao.getInstance().selectAll();
		String text = txtx_timkiem.getText();
		model.setRowCount(0);
		String timitem = cbb_timkiem.getSelectedItem() + "";
		if (timitem.equals("Tất cả")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getMaNhaCungCap().toLowerCase().contains(text.toLowerCase())
						|| nc.getEmail().toLowerCase().contains(text.toLowerCase())
						|| nc.getTenNhaCungCap().toLowerCase().contains(text.toLowerCase())
						|| (nc.getTenNhaCungCap() + "").toLowerCase().contains(text.toLowerCase())
						|| nc.getEmail().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}
		if (timitem.equals("Tên")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getTenNhaCungCap().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		} else if (timitem.equals("Mã cung cấp")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getMaNhaCungCap().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}

		else if (timitem.equals("Địa chỉ")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getDiaChi().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}

		else if (timitem.equals("Số điện thoại")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if ((nc.getSDT() + "").toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}

		else if (timitem.equals("Email")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getEmail().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}
	}
}
