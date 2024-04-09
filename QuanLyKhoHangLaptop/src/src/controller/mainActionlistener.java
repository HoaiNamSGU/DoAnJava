package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.LaptopDAO;
import model.Laptop;
import view.CuaHang_View;
import view.mainView;

public class mainActionlistener implements ActionListener{

	mainView view ;
	CuaHang_View CuaHang_View;
	public mainActionlistener(mainView view) {
		this.view = view ;
	}

	
	public mainActionlistener(CuaHang_View CuaHang_View) {
		this.CuaHang_View=CuaHang_View;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(e.getSource() == view.jbutton_refesh)
		{
			view.textField.setText("");
		}
		
		if(e.getSource() == view.comboBox_search)
		{
			if(view.comboBox_search.getSelectedItem().equals("Windows"))
			{
				ArrayList<Laptop> laptop = LaptopDAO.getintance().Select_search("HeDieuHanh","Windows");
				view.updateTableData(laptop); 
			}
			else if(view.comboBox_search.getSelectedItem().equals("MacOS"))
			{
				ArrayList<Laptop> laptop = LaptopDAO.getintance().Select_search("HeDieuHanh","macOS");
				view.updateTableData(laptop);
			}
			else if(view.comboBox_search.getSelectedItem().equals("Tất cả"))
			{
				ArrayList<Laptop> laptop = LaptopDAO.getintance().selectAll();
				view.updateTableData(laptop);
			}
		}
		else if(e.getSource() == view.jbutton_Sreach)
		{
			String tmp = view.textField.getText();
			ArrayList<Laptop> lt = view.select_search_laptop(tmp);
			for (Laptop laptop : lt) {
				System.out.println(laptop.toString());
			}
			view.updateTableData(lt);
		}
	}

}
