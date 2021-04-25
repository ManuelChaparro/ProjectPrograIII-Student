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
		case GET_LOGIN_DATA:
			String data = window.getLoginData();
			if (!data.equalsIgnoreCase("confirmAccount")) {
				window.changeCard("Student");
			}
			break;			
		case CANCEL_NEW_ACCOUNT:
			window.resetLogin();
			break;
		case SHOW_SCHEDULE:
			window.showSchedule();
			System.out.println(1);
			break;
		}
	}	
}