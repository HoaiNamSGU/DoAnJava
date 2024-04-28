package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.LaptopDAO;
import model.Laptop;
import view.laptopview;

public class LaptopActionListener implements ActionListener 
{
	
	private laptopview laptopview ;
	private ArrayList<Laptop> lt = new ArrayList<Laptop>();
	
	
	public LaptopActionListener(laptopview laptopview) {
		this.laptopview = laptopview;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//String src = e.getActionCommand();
		
		
		if(e.getSource() == laptopview.jbutton_refesh)
		{
			laptopview.textField.setText("");
			
		}
		else if(e.getSource() == laptopview.jbutton_Sreach)
		{
			
		}
		if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().selectAll();
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_HDH(laptopview.comboBox_search.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search("Hang",laptopview.comboBox_Hang.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search("CPU",laptopview.comboBox_CPU.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}	
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search("Ram",laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search("Rom",laptopview.comboBox_Rom.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			laptopview.update_form_comboBoxGia();
		}
		
		
		// 2 column
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "Hang", laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "CPU", laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "Ram", laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "Ram", laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "Gia", laptopview.comboBox_search.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "Gia", laptopview.comboBox_search.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "Gia", laptopview.comboBox_search.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "Gia", laptopview.comboBox_search.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "Gia", laptopview.comboBox_search.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("HeDieuHanh", "Gia", laptopview.comboBox_search.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("CPU", "Hang", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("Hang", "Ram", laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("Hang", "Rom", laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Hang", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Hang", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Hang", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Hang", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Hang", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Hang", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("CPU", "Ram", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("CPU", "Rom", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("CPU", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("CPU", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("CPU", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("CPU", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("CPU", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("CPU", "Gia", laptopview.comboBox_Hang.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_2Column("Ram", "Rom", laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Ram", "Gia", laptopview.comboBox_Ram.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Ram", "Gia", laptopview.comboBox_Ram.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Ram", "Gia", laptopview.comboBox_Ram.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Ram", "Gia", laptopview.comboBox_Ram.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Ram", "Gia", laptopview.comboBox_Ram.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Ram", "Gia", laptopview.comboBox_Ram.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Rom", "Gia", laptopview.comboBox_Rom.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Rom", "Gia", laptopview.comboBox_Rom.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Rom", "Gia", laptopview.comboBox_Rom.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Rom", "Gia", laptopview.comboBox_Rom.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Rom", "Gia", laptopview.comboBox_Rom.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_2Column("Ram", "Gia", laptopview.comboBox_Rom.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		
		// 3 column
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh", "Hang", "CPU", laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh", "Hang", "Ram", laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh", "Hang", "Rom", laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column( "HeDieuHanh", "CPU", "Ram",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column( "HeDieuHanh", "CPU", "Rom",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}


		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column( "HeDieuHanh", "Rom", "Ram",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Ram","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Ram","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Ram","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Ram","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Ram","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Ram","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("HeDieuHanh","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column( "Hang", "CPU", "Ram",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column("CPU", "Hang", "Rom", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column( "Hang", "Rom", "Ram",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Rom","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Rom","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Rom","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Rom","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Rom","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Hang","Rom","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_3Column( "CPU", "Rom", "Ram",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Rom","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Rom","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Rom","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Rom","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Rom","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("CPU","Rom","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Ram","Rom","Gia",laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Ram","Rom","Gia",laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Ram","Rom","Gia",laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Ram","Rom","Gia",laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Ram","Rom","Gia",laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_3Column("Ram","Rom","Gia",laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		
		
		// 4 column
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Hang","CPU","Ram",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem().toString()+"", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Hang","CPU","Rom",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem().toString()+"", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Hang","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Hang","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Hang","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Hang","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Hang","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Hang","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","CPU","Ram","Rom",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem().toString()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Rom","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Rom","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Rom","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Rom","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Rom","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Rom","CPU","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("HeDieuHanh","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_4Column("Hang","CPU","Ram","Rom",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem().toString()+"");
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Ram","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Ram","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Ram","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Ram","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Ram","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Ram","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","CPU","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("Hang","Rom","Ram","Gia",laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("CPU","Rom","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("CPU","Rom","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("CPU","Rom","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("CPU","Rom","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("CPU","Rom","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_4Column("CPU","Rom","Ram","Gia",laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		
		
		// 5 column
		
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()==0)
		{
			lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","Hang","CPU","Ram","Rom",laptopview.comboBox_search.getSelectedItem()+"", laptopview.comboBox_Hang.getSelectedItem()+"", laptopview.comboBox_CPU.getSelectedItem()+"", laptopview.comboBox_Ram.getSelectedItem()+"", laptopview.comboBox_Rom.getSelectedItem()+"");
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()==0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Rom","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()==0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()==0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Rom","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Rom","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Rom","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Rom","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Rom","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","CPU","Rom","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()==0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("HeDieuHanh","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		else if(laptopview.comboBox_search.getSelectedIndex()==0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_5Column("CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}
		
		
		
		// 6 column
		else if(laptopview.comboBox_search.getSelectedIndex()!=0 && laptopview.comboBox_Hang.getSelectedIndex()!=0 && laptopview.comboBox_CPU.getSelectedIndex()!=0 && laptopview.comboBox_Ram.getSelectedIndex()!=0 && laptopview.comboBox_Rom.getSelectedIndex()!=0 && laptopview.comboBox_Gia.getSelectedIndex()!=0)
		{
			lt = new ArrayList<Laptop>();
			if(laptopview.comboBox_Gia.getSelectedIndex()==1)
			{
				lt = LaptopDAO.getintance().Select_search_6Column("HeDieuHanh","CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 0, 10000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==2)
			{
				lt = LaptopDAO.getintance().Select_search_6Column("HeDieuHanh","CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 10000000, 15000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==3)
			{
				lt = LaptopDAO.getintance().Select_search_6Column("HeDieuHanh","CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 15000000, 20000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==4)
			{
				lt = LaptopDAO.getintance().Select_search_6Column("HeDieuHanh","CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 20000000, 30000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==5)
			{
				lt = LaptopDAO.getintance().Select_search_6Column("HeDieuHanh","CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 30000000, 50000000);
			}
			else if(laptopview.comboBox_Gia.getSelectedIndex()==6)
			{
				lt = LaptopDAO.getintance().Select_search_6Column("HeDieuHanh","CPU","Rom","Ram","Hang","Gia",laptopview.comboBox_search.getSelectedItem()+"",laptopview.comboBox_CPU.getSelectedItem()+"",laptopview.comboBox_Rom.getSelectedItem()+"",laptopview.comboBox_Ram.getSelectedItem()+"",laptopview.comboBox_Hang.getSelectedItem()+"", 50000000, 0);
			}
			laptopview.updateTableData(lt);
			ArrayList<Laptop> arr = laptopview.select_search_laptop(lt, laptopview.textField.getText());
			laptopview.updateTableData(arr);
		}

	}

}
