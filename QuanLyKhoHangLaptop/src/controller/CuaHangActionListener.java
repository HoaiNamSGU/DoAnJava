package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CuaHangView;

public class CuaHangActionListener implements ActionListener {
	private CuaHangView CuaHangView;
	public CuaHangActionListener(CuaHangView cuaHangView) {
		this.CuaHangView = cuaHangView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src=e.getSource();
		if( src == CuaHangView.comboBox_search_QuanHuyen) {
			CuaHangView.updateComBoBox_XaPhuong();
			System.out.println("asdasasda");
		}
		
	}

}
