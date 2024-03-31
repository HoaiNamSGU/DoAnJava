package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.LaptopDAO;
import model.Laptop;
import view.ThemSanPham;
import view.mainView;


public class ThemSanPhamActionlistener implements ActionListener{
	ThemSanPham add;
	
	public ThemSanPhamActionlistener(ThemSanPham add) {
		this.add = add;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
		else if(src.equals("Hủy bỏ"))
		{
			add.dispose();
		}
		
	}

	

}
