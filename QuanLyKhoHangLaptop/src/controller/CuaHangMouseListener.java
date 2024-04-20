package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

import model.CuaHang;
import view.CuaHangView;
import view.ThemCuaHang;

public class CuaHangMouseListener implements MouseListener {
	private CuaHangView CuaHangView;

	public CuaHangMouseListener(CuaHangView cuaHangView) {
		this.CuaHangView = cuaHangView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel clickedLabel = (JLabel) e.getSource();
		String LabelText = clickedLabel.getText();

		if (LabelText.equals("Thêm")) {
			ThemCuaHang ThemCH = new ThemCuaHang();
			ThemCH.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					clickedLabel.setForeground(Color.BLACK);
					clickedLabel.setBackground(null);
				}
			});
			CuaHang CH = new CuaHang();
			ThemCH.comboBox_QuanHuyen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ThemCH.updateComBoBox_XaPhuong();
					System.out.println("dsadas");
				}
			});
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
