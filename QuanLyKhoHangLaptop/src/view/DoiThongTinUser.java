package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class DoiThongTinUser extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public DoiThongTinUser() {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenu XemThonTin = new JMenu("Xem thông tin");
		menuBar.add(XemThonTin);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nhân viên");
		XemThonTin.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Tài khoản");
		XemThonTin.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Sửa thông tin");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Nhân viên");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Tài khoản");
		mnNewMenu.add(mntmNewMenuItem_3);
		
	}

}
