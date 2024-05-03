package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ThongKeView;

public class ThongKeActionListener implements ActionListener {
	private ThongKeView ThongKeView;

	public ThongKeActionListener(ThongKeView tk) {
		this.ThongKeView = tk;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ThongKeView.comboBox_ThoiGian)
				|| e.getSource().equals(ThongKeView.comboBox_CongViec)) {
			// Cập nhật định dạng cho combobox Ngày bắt đầu và Ngày kết thúc
			ThongKeView.updateDateFormats();
		}
		if (e.getSource().equals(ThongKeView.comboBox_NgayBD)) {
			int StartDate = ThongKeView.comboBox_NgayBD.getSelectedIndex();
			int EndDate = ThongKeView.comboBox_NgayKT.getSelectedIndex();
			if (StartDate > 0 && StartDate > EndDate) {
				ThongKeView.comboBox_NgayBD.setSelectedIndex(EndDate);
				
			}

		}
		if (e.getSource().equals(ThongKeView.comboBox_NgayKT)) {
			int StartDate = ThongKeView.comboBox_NgayBD.getSelectedIndex();
			int EndDate = ThongKeView.comboBox_NgayKT.getSelectedIndex();
			if (StartDate > 0 && StartDate > EndDate) {
				ThongKeView.comboBox_NgayKT.setSelectedIndex(StartDate);
				System.out.println("why not?" +EndDate);
			}

		}
	}

}
