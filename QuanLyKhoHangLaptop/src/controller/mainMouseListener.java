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
	private static JLabel lastClickedLabel;
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
        	new ThemSanPham();
        }
        else if(labelText.equals("Xóa"))
        {
        	int selectedRow = view.table.getSelectedRow();
    		if(selectedRow != -1 )
    		{	
    			Laptop lt = new Laptop();
    			Object malaptop = view.table.getValueAt(0, selectedRow);
    			lt.setMaLaptop(malaptop+"");

    			int result = JOptionPane.showConfirmDialog(view ,
                        "Bạn có chắc muốn xóa sản phẩm ?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            	 if(result == JOptionPane.YES_OPTION){
            		 LaptopDAO.getintance().delete(lt);
            		 view.model.removeRow(selectedRow);
            		 count++;
            		 JOptionPane.showMessageDialog(view, "Sản phẩm đã được xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                 }
            	 System.out.println(count);
    		}
    		else
    		{
    			 JOptionPane.showMessageDialog(view ,
                         "Bạn chưa chọn laptop !",
                         "Lỗi",
                         JOptionPane.ERROR_MESSAGE);
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
