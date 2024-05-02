package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.NguoiDungDAO;
import model.NguoiDung;
import view.TaiKhoanView;

public class TaiKhoanActionListener implements ActionListener{

	private TaiKhoanView view ;
	public TaiKhoanActionListener(TaiKhoanView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String src = e.getActionCommand();
		
		if(e.getSource()==view.button_refesh1)
		{
			view.textField_timkiem.setText("");
		}
		else if(e.getSource()==view.button_search1)
		{

			String tmp = view.textField_timkiem.getText();
			System.out.println(tmp);
			/*ArrayList<NguoiDung> arr = NguoiDungDAO.getintance().select_search(tmp);
			for (NguoiDung nguoiDung : arr) {
				System.out.println(nguoiDung.toString());
			}*/
		}
	}

}
