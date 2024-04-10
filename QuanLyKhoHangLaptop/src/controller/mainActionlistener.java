package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.LaptopDAO;
import model.Laptop;
import test.test;
import view.mainView;

public class mainActionlistener implements ActionListener{

	mainView view ;
	public mainActionlistener(mainView view) {
		this.view = view ;
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
			if(view.comboBox_search.getSelectedItem().equals("Windows"))
			{
				ArrayList<Laptop> arr = LaptopDAO.getintance().Select_search("HeDieuHanh", "Windows");
				ArrayList<Laptop> lt = view.select_search_laptop(arr, view.textField.getText());
				view.updateTableData(lt);
			}
			else if(view.comboBox_search.getSelectedItem().equals("MacOS"))
			{
				ArrayList<Laptop> arr = LaptopDAO.getintance().Select_search("HeDieuHanh", "MacOS");
				ArrayList<Laptop> lt = view.select_search_laptop(arr, view.textField.getText());
				view.updateTableData(lt);
			}
			else if(view.comboBox_search.getSelectedItem().equals("Tất cả"))
			{
				ArrayList<Laptop> arr = LaptopDAO.getintance().selectAll();
				ArrayList<Laptop> lt = view.select_search_laptop(arr, view.textField.getText());
				view.updateTableData(lt);
			}
		}
	}

}
