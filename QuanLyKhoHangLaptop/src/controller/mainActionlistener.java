package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.mainView;

public class mainActionlistener implements ActionListener{

	mainView view ;
	public mainActionlistener(mainView view) {
		this.view = view ;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == view.jbutton_refesh)
		{
			view.textField.setText("");
		}
		
	}

}
