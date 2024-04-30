package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
//import java.sql.Date;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.LaptopDAO;
import dao.NguoiDungDAO;
import dao.NhanVienDAO;
import model.Laptop;
import model.NguoiDung;
import model.NhanVien;
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
        	tk.addWindowListener(new WindowAdapter() {
    		    @Override
    		    public void windowClosing(WindowEvent e) {
    		        clickedLabel.setForeground(Color.BLACK);
    		        clickedLabel.setBackground(null);
    		    }
    		});
        	
        	NhanVien nv = new NhanVien();
        	NguoiDung nd = new NguoiDung();
            
            tk.button_xacnhan.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Xác nhận"))
					{
						
						ArrayList<String> arrMaNguoiDung = new ArrayList<String>();
			        	while(true)
			        	{
			        		arrMaNguoiDung = NguoiDungDAO.getintance().getColumn("MaNguoiDung");
			        		for (String string : arrMaNguoiDung) {
								if(tk.textField_MaND.getText().equals(string))
								{
									JOptionPane.showMessageDialog(tk, "Mã người dùng bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
									do
									{
										int count = 0;
										String input = JOptionPane.showInputDialog(tk, "Nhập lại mã người dùng:");
										
								       	if (input != null && !input.isEmpty()) {
								       		for (String string2 : arrMaNguoiDung) {
												if(string2.equals(input))
												{
													JOptionPane.showMessageDialog(tk, "Mã người dùng trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
													count=1;
													break;
												}
											}
								        } else {
								            JOptionPane.showMessageDialog(tk, "Bạn không nhập giá trị!");
								            count = 1;
								        }
								       	if(count==0)
								       	{
								       		tk.textField_MaND.setText(input);
								       		break;
								       	}
								       	
									}
									while(true);
								}
								else if(tk.textField_MaND.getText().equals(""))
								{
									JOptionPane.showMessageDialog(tk, "Mã người dùng bị bỏ trống !\n Vui lòng nhập mã người dùng","Lỗi",JOptionPane.ERROR_MESSAGE);
								
									do
									{
										int count = 0;
										String input = JOptionPane.showInputDialog(tk, "Nhập lại mã người dùng:");
										
								       	if (input != null && !input.isEmpty()) {
								       		for (String string2 : arrMaNguoiDung) {
												if(string2.equals(input))
												{
													JOptionPane.showMessageDialog(tk, "Mã người bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
													count=1;
													break;
												}
											}
								        } else {
								            JOptionPane.showMessageDialog(tk, "Bạn không nhập giá trị!");
								            count = 1;
								        }
								       	if(count==0)
								       	{
								       		tk.textField_MaND.setText(input);
								       		break;
								       	}
									}
									while(true);
								}
							}
			        		break;
			        	}
						nd.setMaNguoiDung(tk.textField_MaND.getText());
						
						
						
						if(tk.radioButton1.isSelected())
						{
							nv.setGioiTinh(1);
						}
						else if(tk.radioButton2.isSelected())
						{
							nv.setGioiTinh(0);
						}
						int year = (int) tk.yearModel.getValue();
			            int month = (int) tk.monthModel.getValue();
			            int day = (int) tk.dayModel.getValue();
			            if (isValidDate(year, month, day)==false) {
			            	 JOptionPane.showMessageDialog(tk, "Ngày không hợp lệ!");
			            	 tk.setYMD_now();
			            	 year = (int) tk.yearModel.getValue();
					         month = (int) tk.monthModel.getValue();
					         day = (int) tk.dayModel.getValue();
			            } 
						nv.setTenNhanVien(tk.textField_HoTen.getText());
			        	nv.setSDT(tk.textField_SDT.getText());
			        	nv.setNgaySinh(day, month, year);
			        	
			        	ArrayList<String> arrMaNhanVien = new ArrayList<String>();
			        	while(true)
			        	{
			        		arrMaNhanVien = NhanVienDAO.getintance().getColumn("MaNhanVien");
			        		for (String string : arrMaNhanVien) {
								if(tk.textField_MaNV.getText().equals(string))
								{
									JOptionPane.showMessageDialog(tk, "Mã nhân viên bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
									do
									{
										int count = 0;
										String input = JOptionPane.showInputDialog(tk, "Nhập lại mã nhân viên:");
										
								       	if (input != null && !input.isEmpty()) {
								       		for (String string2 : arrMaNhanVien) {
												if(string2.equals(input))
												{
													JOptionPane.showMessageDialog(tk, "Mã nhân viên bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
													count=1;
													break;
												}
											}
								        } else {
								            JOptionPane.showMessageDialog(tk, "Bạn không nhập giá trị!");
								            count = 1;
								        }
								       	if(count==0)
								       	{
								       		tk.textField_MaNV.setText(input);
								       		break;
								       	}
								       	
									}
									while(true);
								}
								else if(tk.textField_MaNV.getText().equals(""))
								{
									JOptionPane.showMessageDialog(tk, "Mã nhân viên bị bỏ trống !\n Vui lòng nhập mã nhân viên","Lỗi",JOptionPane.ERROR_MESSAGE);
								
									do
									{
										int count = 0;
										String input = JOptionPane.showInputDialog(tk, "Nhập lại mã nhân viên:");
										
								       	if (input != null && !input.isEmpty()) {
								       		for (String string2 : arrMaNhanVien) {
												if(string2.equals(input))
												{
													JOptionPane.showMessageDialog(tk, "Mã nhân viên bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
													count=1;
													break;
												}
											}
								        } else {
								            JOptionPane.showMessageDialog(tk, "Bạn không nhập giá trị!");
								            count = 1;
								        }
								       	if(count==0)
								       	{
								       		tk.textField_MaNV.setText(input);
								       		break;
								       	}
								       	
									}
									while(true);
								}
							}
			        		break;
			        	}
			        	nv.setMaNhanVien(tk.textField_MaNV.getText());
			        	
			        	nv.setMaNguoiDung(nd.getMaNguoiDung());
			        	if(tk.textField_TaiKhoan.getText().equals("")||tk.textField_MatKhau.getText().equals("")||tk.textField_TaiKhoan.getText().equals("")&&tk.textField_MatKhau.getText().equals(""))
			        	{
			        		nd.setTaiKhoan(nv.getMaNguoiDung());
			        		nd.setMatKhau("12345");
			        	}
			        	else
			        	{
			        		nd.setTaiKhoan(tk.textField_TaiKhoan.getText());
			        		nd.setMatKhau(tk.textField_MatKhau.getText());
			        	}
			        	
			        	int result = JOptionPane.showConfirmDialog(tk, "Bạn có chắc muốn thêm tài khoản ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			        	if(result == JOptionPane.YES_OPTION)
			        	{
							int check1 = NguoiDungDAO.getintance().insert(nd);
							int check2 = NhanVienDAO.getintance().insert(nv);
							
							if(check1 == 1 && check2 ==1)
							{
								JOptionPane.showMessageDialog(tk, "Tài khoản đã được thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
								taikhoanview.updateTableData();
							}
							else
							{
								JOptionPane.showMessageDialog(tk, "Tài khoản thêm thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
							}
			        	}
			        	
					}
				}
			});
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

	
	private static boolean isValidDate(int year, int month, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(year + "/" + month + "/" + day);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    

}

