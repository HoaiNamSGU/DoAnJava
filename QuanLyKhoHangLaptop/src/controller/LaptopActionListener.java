package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.LaptopDAO;
import model.Laptop;
import view.LaptopView;

public class LaptopActionListener implements ActionListener {
	
	private LaptopView laptopview ;
	public LaptopActionListener(LaptopView laptopview) {
		this.laptopview = laptopview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(e.getSource() == laptopview.jbutton_refesh)
		{
			laptopview.textField.setText("");
		}
		
		if(e.getSource() == laptopview.comboBox_search)
		{
			if(laptopview.comboBox_search.getSelectedItem().equals("Windows"))
			{
				ArrayList<Laptop> laptop = LaptopDAO.getintance().Select_search("HeDieuHanh","Windows");
				laptopview.updateTableData(laptop);
			}
			else if(laptopview.comboBox_search.getSelectedItem().equals("MacOS"))
			{
				ArrayList<Laptop> laptop = LaptopDAO.getintance().Select_search("HeDieuHanh","macOS");
				laptopview.updateTableData(laptop);
			}
			else if(laptopview.comboBox_search.getSelectedItem().equals("Tất cả"))
			{
				ArrayList<Laptop> laptop = LaptopDAO.getintance().selectAll();
				laptopview.updateTableData(laptop);
			}
		}
		else if(e.getSource() == laptopview.jbutton_Sreach)
		{
			if(laptopview.comboBox_search.getSelectedItem().equals("Windows"))
			{
				ArrayList<Laptop> arr = LaptopDAO.getintance().Select_search("HeDieuHanh", "Windows");
				ArrayList<Laptop> lt = laptopview.select_search_laptop(arr, laptopview.textField.getText());
				laptopview.updateTableData(lt);
			}
			else if(laptopview.comboBox_search.getSelectedItem().equals("MacOS"))
			{
				ArrayList<Laptop> arr = LaptopDAO.getintance().Select_search("HeDieuHanh", "MacOS");
				ArrayList<Laptop> lt = laptopview.select_search_laptop(arr, laptopview.textField.getText());
				laptopview.updateTableData(lt);
			}
			else if(laptopview.comboBox_search.getSelectedItem().equals("Tất cả"))
			{
				ArrayList<Laptop> arr = LaptopDAO.getintance().selectAll();
				ArrayList<Laptop> lt = laptopview.select_search_laptop(arr, laptopview.textField.getText());
				laptopview.updateTableData(lt);
			}
		}
	}

}
