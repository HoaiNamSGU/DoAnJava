package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import view.DoiMatKhau;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.NguoiDungDAO;
import model.NguoiDung;
import view.DoiThongTinUser;

public class ThongTinMouseListener implements MouseListener{
	
	private DoiThongTinUser user;
	
	public ThongTinMouseListener(DoiThongTinUser user) {
		this.user = user;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel clickedLabel = (JLabel) e.getSource();
        
        String labelText = clickedLabel.getText();
        if(labelText.equals("Xem thông tin"))
        {
        	user.jlabel_xemCT.setForeground(Color.WHITE);
        	user.jlabel_sua.setForeground(Color.BLACK);
        	
        }
        else if(labelText.equals("Đổi mật khẩu"))
        {
        	user.jlabel_sua.setForeground(Color.WHITE);
        	user.jlabel_xemCT.setForeground(Color.BLACK);
        	DoiMatKhau mk = new DoiMatKhau();
        	mk.btnHuyBo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Hủy bỏ"))
					{
						mk.dispose();
						user.jlabel_sua.setForeground(Color.BLACK);
			        	user.jlabel_xemCT.setForeground(Color.WHITE);
					}
				}
			});
        	mk.btnXacNhan.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Xác nhận"))
					{	
						NguoiDung nd = view.mainView.nguoidung;
						
						if(nd.getMatKhau().equals(mk.passwordField_1.getText()))
						{
							if(mk.passwordField_2.getText().equals(mk.passwordField_3.getText()) && !mk.passwordField_2.getText().equals("") && !mk.passwordField_3.getText().equals(""))
							{
								int result = JOptionPane.showConfirmDialog(mk, "Bạn có chắc chắn đổi mật khẩu","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
								if(result == JOptionPane.YES_NO_OPTION)
								{
									int kq = NguoiDungDAO.getintance().updateByCondition(nd.getMaNguoiDung(),mk.passwordField_1.getText() , mk.passwordField_2.getText());
									if(kq == 1)
									{
										JOptionPane.showMessageDialog(mk,"Đổi mật khẩu thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
										nd.setMatKhau(mk.passwordField_2.getText());
										mk.dispose();
										user.jlabel_xemCT.setForeground(Color.WHITE);
							        	user.jlabel_sua.setForeground(Color.BLACK);
									}
									else
									{
										JOptionPane.showMessageDialog(mk,"Đổi mật khẩu thất bại","Thông báo",JOptionPane.ERROR_MESSAGE);
									}
								}
							
							}
							else
							{
								JOptionPane.showMessageDialog(mk,"Mật khẩu mới không hợp lệ","Thông báo",JOptionPane.ERROR_MESSAGE);
							}
							
						}
						else
						{
							JOptionPane.showMessageDialog(mk,"Mật khẩu không đúng","Thông báo",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
        	
        	mk.addWindowListener(new WindowAdapter() {
    		    @Override
    		    public void windowClosing(WindowEvent e) {
    		    	user.jlabel_xemCT.setForeground(Color.WHITE);
		        	user.jlabel_sua.setForeground(Color.BLACK);
    		    }
    		});
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
