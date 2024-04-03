package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.LaptopDAO;
import view.mainView;
import view.PhieuXuat;
import view.SuaSanPham;
import view.ThemSanPham;
import model.Laptop;


public class mainMouseListener implements MouseListener {
	
	public mainView view ;	
	public static JLabel lastClickedLabel;
    private static PhieuXuat PhieuXuat;
    
	public mainMouseListener(mainView view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel clickedLabel = (JLabel) e.getSource();
        
        // Nếu có JLabel được nhấn trước đó, đặt lại màu sắc bình thường
        if (lastClickedLabel != null) {
            lastClickedLabel.setForeground(Color.BLACK);
            lastClickedLabel.setBackground(null);
        }
        
        // Đặt màu sắc mới cho JLabel vừa được nhấn
        clickedLabel.setForeground(Color.WHITE);
        clickedLabel.setBackground(Color.GRAY);
        
        // Xử lý các thao tác với JLabel dựa trên nội dung của nó
        String labelText = clickedLabel.getText();
        int count = 0;
        if (labelText.equals("Phiếu nhập")) {
            PhieuXuat = new PhieuXuat();
            PhieuXuat.ChangeInformationToPhieuNhap();
            PhieuXuat.setVisible(true);
        } 
        else if (labelText.equals("Phiếu xuất")) {
            PhieuXuat = new PhieuXuat();
            PhieuXuat.ChangeInformationToPhieuXuat();
            PhieuXuat.setVisible(true);
        }
        else if(labelText.equals("Thêm"))
        {
        	ThemSanPham add = new ThemSanPham();
        	Laptop lt = new Laptop();
        	String defaultSelected_Ram = (String) add.comboBox_Ram.getSelectedItem();
        	String defaultSelected_Rom = (String) add.comboBox_Rom.getSelectedItem();
        	String defaultSelected_Nam = (String) add.comboBox_Nam.getSelectedItem();
        	lt.setRam(defaultSelected_Ram);
        	lt.setRom(defaultSelected_Rom);
        	lt.setNamSanXuat(Integer.parseInt(defaultSelected_Nam));
        	
        	
        	add.comboBox_Ram.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String selected_Ram = (String) add.comboBox_Ram.getSelectedItem();
					lt.setRam(selected_Ram);
					
				}
			});
        	
        	
			add.comboBox_Rom.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String selected_Rom = (String) add.comboBox_Rom.getSelectedItem();
					lt.setRom(selected_Rom);
				}
			});
			
			
			add.comboBox_Nam.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String selected_nam = (String) add.comboBox_Nam.getSelectedItem();
					lt.setNamSanXuat(Integer.parseInt(selected_nam));
				}
			});
			
			
			add.button_right.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==add.button_right)
					{
						int soluong;
						try {
							soluong = Integer.parseInt(add.getText(add.jtextField_soluong));
							soluong++;
							add.jtextField_soluong.setText(soluong+"");
							lt.setSoLuong(soluong);
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(add ,"Số lượng không hợp lệ !","Lỗi",JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
						
					}
				}
			});
			
			
			add.button_left.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==add.button_left)
					{
						try {
							int soluong = Integer.parseInt(add.getText(add.jtextField_soluong));
							soluong--;
							add.jtextField_soluong.setText(soluong+"");
							lt.setSoLuong(soluong);
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(add,"Số lượng không hợp lệ !","Lỗi",JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				}
			});
			
			
			
			
			
        	add.jbutton_xacnhan.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
		        	lt.setTenLaptop(add.getText(add.jtextField_tensanpham));
		        	lt.setCPU(add.getText(add.jtextField_CPU));
		        	lt.setGPU(add.getText(add.jtextField_GPU));
		        	lt.setHeDieuHanh(add.getText(add.jtextField_hedieuhanh));
		        	lt.setManHinh(add.getText(add.jtextField_manhinh));
		        	lt.setHang(add.getText(add.jtextField_Hang));
		        	ArrayList<String> arrMaLaptop = new ArrayList<String>();
		        	while(true)
		        	{
		        		arrMaLaptop = LaptopDAO.getintance().getColumn_0();
		        		for (String string : arrMaLaptop) {
							if(add.jtextField_masanpham.getText().equals(string))
							{
								JOptionPane.showMessageDialog(add, "Mã Laptop bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
								do
								{
									int count = 0;
									String input = JOptionPane.showInputDialog(add, "Nhập lại mã laptop:");
									
							       	if (input != null && !input.isEmpty()) {
							       		for (String string2 : arrMaLaptop) {
											if(string2.equals(input))
											{
												JOptionPane.showMessageDialog(add, "Mã Laptop bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
												count=1;
												break;
											}
										}
							        } else {
							            JOptionPane.showMessageDialog(add, "Bạn không nhập giá trị!");
							            count = 1;
							        }
							       	if(count==0)
							       	{
							       		add.jtextField_masanpham.setText(input);
							       		break;
							       	}
							       	
								}
								while(true);
							}
							else if(add.jtextField_masanpham.getText().equals(""))
							{
								JOptionPane.showMessageDialog(add, "Mã Laptop bị bỏ trống !\n Vui lòng nhập mã laptop","Lỗi",JOptionPane.ERROR_MESSAGE);
							
								do
								{
									int count = 0;
									String input = JOptionPane.showInputDialog(add, "Nhập lại mã laptop:");
									
							       	if (input != null && !input.isEmpty()) {
							       		for (String string2 : arrMaLaptop) {
											if(string2.equals(input))
											{
												JOptionPane.showMessageDialog(add, "Mã Laptop bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
												count=1;
												break;
											}
										}
							        } else {
							            JOptionPane.showMessageDialog(add, "Bạn không nhập giá trị!");
							            count = 1;
							        }
							       	if(count==0)
							       	{
							       		add.jtextField_masanpham.setText(input);
							       		break;
							       	}
							       	
								}
								while(true);
							}
						}
		        		break;
		        	}
					lt.setMaLaptop(add.getText(add.jtextField_masanpham));
		        	try {
						lt.setSoLuong(Integer.parseInt(add.getText(add.jtextField_soluong)));
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(add,"Số lượng không hợp lệ !","Lỗi",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
		        	try {
						lt.setGia(Double.parseDouble(add.getText(add.jtextField_gia)));
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(add,"Giá không hợp lệ !","Lỗi",JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
		        	String src = e.getActionCommand();
					if(src.equals("Xác nhận"))
					{
			        	int result = JOptionPane.showConfirmDialog(add, "Bạn có chắc muốn thêm sản phẩm ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			        	if(result == JOptionPane.YES_OPTION)
			        	{
							LaptopDAO.getintance().insert(lt);
							JOptionPane.showMessageDialog(add, "Sản phẩm đã được thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							
			        	}
					}
				}
			});
        	
        	
        	add.jbutton_huybo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String src = e.getActionCommand();
					if(src.equals("Hủy bỏ"))
					{
						add.dispose();
						clickedLabel.setForeground(Color.BLACK);
	            	    clickedLabel.setBackground(null);
					}
				}
			});
        	
        }
        else if(labelText.equals("Xóa"))
        {
        	int selectedRow = view.table.getSelectedRow();
    		if(selectedRow != -1 )
    		{	
    			Laptop lt = new Laptop();
    			Object malaptop = view.table.getValueAt(selectedRow, 0);
    			lt.setMaLaptop(malaptop+"");
    			int result = JOptionPane.showConfirmDialog(view ,
                        "Bạn có chắc muốn xóa sản phẩm ?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            	 if(result == JOptionPane.YES_OPTION){
            		 LaptopDAO.getintance().delete(lt);
            		 view.model.removeRow(selectedRow);
            		 clickedLabel.setForeground(Color.BLACK);
            	     clickedLabel.setBackground(null);
            		 JOptionPane.showMessageDialog(view, "Sản phẩm đã được xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                 }
            	 else
            	 {
            		 clickedLabel.setForeground(Color.BLACK);
            	     clickedLabel.setBackground(null);
            	 }
            	 
    		}
    		else {
    			 JOptionPane.showMessageDialog(view ,
                         "Bạn chưa chọn laptop !",
                         "Lỗi",
                         JOptionPane.ERROR_MESSAGE);
    			 clickedLabel.setForeground(Color.BLACK);
        	     clickedLabel.setBackground(null);
    		}
        	
        }
        else if(labelText.equals("Sửa"))
        {
        	new SuaSanPham();
        }
        // Cập nhật lastClickedLabel
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
