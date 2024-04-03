package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        	add.jbutton_xacnhan.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String src = e.getActionCommand();
					if(src.equals("Xác nhận"))
					{
						Laptop lt = new Laptop();
			        	lt.setMaLaptop(add.getText(add.jtextField_masanpham));
			        	lt.setTenLaptop(add.getText(add.jtextField_tensanpham));
			        	lt.setCPU(add.getText(add.jtextField_CPU));
			        	lt.setGPU(add.getText(add.jtextField_GPU));
			        	lt.setRam(add.getText(add.jtextField_Ram));
			        	lt.setRom(add.getText(add.jtextField_Rom));
			        	lt.setHeDieuHanh(add.getText(add.jtextField_hedieuhanh));
			        	lt.setManHinh(add.getText(add.jtextField_manhinh));
			        	lt.setHang(add.getText(add.jtextField_Hang));
			        	String nam = add.getText(add.textField_NamSX);
			        	lt.setNamSanXuat(Integer.parseInt(nam));
			        	lt.setSoLuong(Integer.parseInt(add.getText(add.jtextField_soluong)));
			        	lt.setGia(Double.parseDouble(add.getText(add.jtextField_gia)));
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
    		else
    		{
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
