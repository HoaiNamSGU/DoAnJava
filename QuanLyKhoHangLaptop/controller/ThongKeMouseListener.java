package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import view.ThongKeView;

public class ThongKeMouseListener implements MouseListener {
	private ThongKeView thongKeView;
	public static JLabel lastClickedLabel;
	public ThongKeMouseListener(ThongKeView tk) {
		this.thongKeView = tk;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel clickedLabel = (JLabel) e.getSource();
		if (lastClickedLabel != null) {
            lastClickedLabel.setForeground(Color.BLACK);
        }
		clickedLabel.setForeground(Color.BLUE);
		String labelText = clickedLabel.getText();
		if (labelText.equals("Sản Phẩm")) {
			thongKeView.loai=labelText;
			thongKeView.panel_Center.setVisible(false);
			thongKeView.panel_Center.removeAll();
			thongKeView.panel_Center.add(thongKeView.bdsp);
			thongKeView.comboBox_NgayBD.setSelectedIndex(0);
			thongKeView.comboBox_NgayKT.setSelectedIndex(0);
			thongKeView.comboBox_CongViec.setSelectedIndex(0);
			thongKeView.comboBox_ThoiGian.setSelectedIndex(0);
			thongKeView.comboBox_NgayBD.setEnabled(true);
			thongKeView.comboBox_NgayKT.setEnabled(true);
			thongKeView.comboBox_CongViec.setEnabled(true);
			thongKeView.comboBox_ThoiGian.setEnabled(true);
			thongKeView.panel_Center.setVisible(true);
		}
		if (labelText.equals("Cửa Hàng")) {
			thongKeView.loai=labelText;
			thongKeView.panel_Center.setVisible(false);
			thongKeView.panel_Center.removeAll();
			thongKeView.comboBox_CongViec.setSelectedIndex(1);
			thongKeView.comboBox_NgayBD.setEnabled(false);
			thongKeView.comboBox_NgayKT.setEnabled(false);
			thongKeView.comboBox_CongViec.setEnabled(false);
			thongKeView.comboBox_ThoiGian.setEnabled(false);
			thongKeView.panel_Center.add(thongKeView.bdch);
			
			
			thongKeView.panel_Center.setVisible(true);
		}
		if (labelText.equals("Nhà Cung Cấp")) {
			thongKeView.loai=labelText;
			thongKeView.panel_Center.setVisible(false);
			thongKeView.panel_Center.removeAll();
			thongKeView.comboBox_CongViec.setSelectedIndex(1);
			thongKeView.comboBox_NgayBD.setEnabled(false);
			thongKeView.comboBox_NgayKT.setEnabled(false);
			thongKeView.comboBox_CongViec.setEnabled(false);
			thongKeView.comboBox_ThoiGian.setEnabled(false);
			thongKeView.panel_Center.add(thongKeView.bdch);
			
			
			thongKeView.panel_Center.setVisible(true);
		}
		lastClickedLabel = clickedLabel;
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
