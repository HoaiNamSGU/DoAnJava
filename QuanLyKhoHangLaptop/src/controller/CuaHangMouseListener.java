package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.CuaHangDAO;
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
			ThemCH.comboBox_QuanHuyen.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ThemCH.updateComBoBox_XaPhuong();
				}
			});

			ThemCH.comboBox_TPHO.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

				}
			});
			ThemCH.comboBox_XaPhuong.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

				}
			});
			ThemCH.Button_XacNhan.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String maCH = ThemCH.textField_MaCH.getText();
					String TenCH = ThemCH.textField_TenCH.getText();
					String SDT = ThemCH.textField_SDT.getText();
					String DiaChi = ThemCH.textField_DiaChi.getText() + ", "
							+ ThemCH.comboBox_XaPhuong.getSelectedItem() + ", "
							+ ThemCH.comboBox_QuanHuyen.getSelectedItem() + ", "
							+ ThemCH.comboBox_TPHO.getSelectedItem();
					// TODO Auto-generated method stub
					CuaHang CH = new CuaHang(maCH, TenCH, DiaChi, SDT, 0);
					if (CH != null) {
						CuaHangDAO.getintance().insertCuaHang(CH);
						CuaHangView.CuaHang();
						JOptionPane.showMessageDialog(ThemCH, "Cửa hàng đã được thêm thành công", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
						ThemCH.dispose();
						
					}
				}
			});
		}

	}
	
	/*public static void resetComponent(Component component) {
        if (component instanceof JLabel) {
            JLabel label = (JLabel) component;
            label.setForeground(Color.BLACK);
            label.setBackground(null);
        } else if (component instanceof JButton) {
            JButton button = (JButton) component;
            button.setForeground(Color.BLACK);
            button.setBackground(null);
        } // Có thể thêm các trường hợp khác ở đây nếu cần
    }*/

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
