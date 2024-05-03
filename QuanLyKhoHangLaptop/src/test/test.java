package test;

import javax.swing.JFrame;

import view.ThongKeView;
import view.login;

public class test {
	public static void main(String[] args) {	
		new login();
		ThongKeView tKeView= new ThongKeView();
		JFrame ccFrame = new JFrame();
		ccFrame.add(tKeView);
		ccFrame.setVisible(true);
	}
}

