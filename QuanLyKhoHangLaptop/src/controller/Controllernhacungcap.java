package duan;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.nhacungcapDao;
import model.Nhacungcap;
import view.NhaCungCap;

public class Controllernhacungcap {
	static ArrayList<Nhacungcap> dsnhacungcap=nhacungcapDao.getInstance().selectAll();
	private static NhaCungCap ncc;
	public Controllernhacungcap(NhaCungCap nccc) {
		this.ncc=nccc;
	}
	

	public static void addMouseListener(JLabel label,NhaCungCap ncc) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel check = (JLabel) e.getSource();
		        if(check==ncc.jl_nutadd) {
		        	ncc.hienaddnhacungcap();
		        }else if(check==ncc.jl_nutxoa) {
		        	ncc.nhannutxoa();
		        }else if(check==ncc.jl_nutsua) {
		        	ncc.hiensuanhacungcap();
		        }
		        
			}
		});
	}
	
	public static void addKeyListener(JTextField jt,NhaCungCap ncc) {
		jt.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getSource()==ncc.txtx_timkiem) {
				ncc.thanhtimkiem();
			}
		}	
	});
	}
	
	public static void ActionListener(JButton jt,NhaCungCap ncc) {
		jt.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(e.getSource()==ncc.btn_lammoi){
		        	ncc.nutlammoi();
		        }
		 	}
		 });
	}
}
