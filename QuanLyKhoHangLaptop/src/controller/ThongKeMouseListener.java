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
		thongKeView.loai=labelText;
		thongKeView.panel_Center.removeAll();
		thongKeView.updateData(labelText);
		if (labelText.equals("Sản Phẩm")) {
			thongKeView.panel_Center.add(thongKeView.bdsp);
			thongKeView.setEnableComboBox(true);
			
		}
		if (labelText.equals("Cửa Hàng")||labelText.equals("Nhà Cung Cấp")) {
			
			thongKeView.panel_Center.add(thongKeView.bdch);
			thongKeView.setEnableComboBox(false);
			if(labelText.equals("Cửa Hàng"))
				thongKeView.comboBox_CongViec.setSelectedIndex(1);
			else 
				thongKeView.comboBox_CongViec.setSelectedIndex(0);
			
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
