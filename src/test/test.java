package test;

import javax.swing.UIManager;

import view.mainView;

public class test {
	public static mainView mv;
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			mv=new mainView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}