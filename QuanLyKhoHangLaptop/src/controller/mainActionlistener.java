package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.LaptopDAO;
import model.Laptop;
import test.test;
import view.CuaHangView;
import view.mainView;

public class mainActionlistener implements ActionListener{

	mainView view ;
	CuaHangView CuaHangView;
	public mainActionlistener(mainView view) {
		this.view = view ;
	}

	
	public mainActionlistener(CuaHangView CuaHangView) {
		this.CuaHangView=CuaHangView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
