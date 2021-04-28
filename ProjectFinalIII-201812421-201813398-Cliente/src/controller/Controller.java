package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import models.Course;
import models.User;
import net.Conection;
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
					if (conection.receiveBoolean()) {
						window.changeCard("Student");
					} else {
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
				String stringUser = new Gson().toJson(new User(dataUser[0], dataUser[1], dataUser[2])).toString();
				conection.sendBoolean(false);
				conection.sendUTF(stringUser);
				if (conection.receiveBoolean()) {
					JOptionPane.showMessageDialog(null, "Creado Exitosamente", Constants.NAME_APP,
							JOptionPane.INFORMATION_MESSAGE);
					window.resetLogin();
					window.changeCard("Login");
				} else {
					JOptionPane.showMessageDialog(null, "El usuario ya existe.", Constants.NAME_APP,
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case CANCEL_NEW_ACCOUNT:
			window.resetLogin();
			break;
		case SHOW_SCHEDULE:
			window.changeCardStudent("Schedule");
			break;
		case ADD_COURSE_ST:
			try {
				conection.sendInt(2);
				window.resertComboBoxCourses();
				window.changeCardStudent("AddCourse");
				window.setComboBoxCourses(conection.receiveUTF());
				window.setInfoSchedule("LUN#6#8%MIE#10#12");
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			break;
		case ADD_COMBOBOX_COURSE:
			try {
				conection.sendInt(3);
				window.resetComboBoxTeachers();
				conection.sendUTF(window.getComboBoxCoursesValue());
				window.setComboBoxTeachers(conection.receiveUTF());
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			break;
		case ADD_COMBOBOX_TEACHER:
			break;
		default:
			break;
		}
	}
}