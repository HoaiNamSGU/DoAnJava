package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.LaptopDAO;
import model.Laptop;
import view.TaiKhoanView;
import view.ThemSanPham;
import view.ThemTaiKhoan;
import view.XemChiTiet;

public class TaiKhoanMouseListener implements MouseListener{

	private TaiKhoanView taikhoanview ;
	
	public TaiKhoanMouseListener(TaiKhoanView taikhoanview) {
		this.taikhoanview = taikhoanview;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel clickedLabel = (JLabel) e.getSource();
     
        // Đặt màu sắc mới cho JLabel vừa được nhấn
        clickedLabel.setForeground(Color.WHITE);
        clickedLabel.setBackground(Color.GRAY);
        
        // Xử lý các thao tác với JLabel dựa trên nội dung của nó
        String labelText = clickedLabel.getText();
       
        if(labelText.equals("Thêm"))
        {
        	ThemTaiKhoan tk = new ThemTaiKhoan();
        	
        }
        else if(labelText.equals("Xóa"))
        {
        	
        }
        else if(labelText.equals("Sửa"))
        {
        	
        }
        else if(labelText.equals("Xem chi tiết"))
        {
        	
        }
		
        else if(labelText.equals("Xuất Excel"))
        {
        	
        }
		
        else if(labelText.equals("Nhập Excel"))
        {
        	
        }
        
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

