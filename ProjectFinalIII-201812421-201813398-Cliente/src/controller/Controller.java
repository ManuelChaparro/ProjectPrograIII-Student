package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import models.Course;
import models.User;
import net.Conection;
import persistence.GSONFileManager;
import views.Constants;
import views.JWindow;

public class Controller implements ActionListener {

	private JWindow window;
	private Conection conection;

	public Controller() {
		conection = new Conection();
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
			if (!window.isCreate()) {
				String[] dataUser = data.split(",");
				String stringUser = new Gson().toJson(new User("", dataUser[0], dataUser[1])).toString();
				try {
					conection.sendBoolean(true);
					conection.sendUTF(stringUser);
					if(conection.receiveBoolean()) {
						window.changeCard("Student");
					}else {
						JOptionPane.showMessageDialog(null, "El usuario no existe");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			break;
		case GET_CREATE_DATA:
			String dataCreateLog = window.getLoginData();
			String[] dataUser = dataCreateLog.split(",");
			try {
				String stringUser = new Gson().toJson(new User("", dataUser[0], dataUser[1])).toString();
				conection.sendBoolean(false);
				conection.sendUTF(stringUser);
				if(conection.receiveBoolean()) {
					JOptionPane.showMessageDialog(null, "Creado exitosamente.");
					window.changeCard("Login");
				}else {
					JOptionPane.showMessageDialog(null, "El usuario ya existe.");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
//			try {
//				if (conection.receiveBoolean()) {
//					System.out.println("Creado con exito");
//				}else {
//					
//				}
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			break;
		case CANCEL_NEW_ACCOUNT:
			window.resetLogin();
			break;
		case SHOW_SCHEDULE:
			window.changeCardStudent("Schedule");
			break;
		case ADD_COURSE_ST:	
			window.changeCardStudent("AddCourse");
			break;
		case ADD_S_COURSE:

			break;
		default:
			break;
		}
	}
}