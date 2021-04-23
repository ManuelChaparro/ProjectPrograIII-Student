package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.JWindow;

public class Controller implements ActionListener{
	
	private JWindow window;
	
	public Controller() {
		window = new JWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Event.valueOf(e.getActionCommand())) {
		case HIDE_PASSWORD:
			window.hidePassword();
			break;	
		case LOGIN_ACCOUNT:
			window.loginAccount();
			break;
			
		}
	}
	
	
}
