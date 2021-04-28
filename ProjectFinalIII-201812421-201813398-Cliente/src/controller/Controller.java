package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import models.User;
import net.Conection;
import views.Constants;
import views.JWindow;

public class Controller implements ActionListener {

	private JWindow window;
	private Conection conection;
	private String code;

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
						code = dataUser[0];
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
			try {
				conection.sendUTF("SHOW_SCHEDULE");
				System.out.println(conection.receiveUTF());
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			window.changeCardStudent("Schedule");
			break;
		case ADD_COURSE_ST:
			try {
				conection.sendUTF("ADD_COURSE_ST");
				window.resertComboBoxCourses();
				window.resetComboBoxTeachers();
				window.setComboBoxCourses(conection.receiveUTF());
				window.changeCardStudent("AddCourse");
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			break;
		case FIND_TEACHERS:
			try {
				conection.sendUTF("FIND_TEACHERS");
				window.setVisibleTeachers(true);
				window.resetComboBoxTeachers();
				conection.sendUTF(window.getComboBoxCoursesValue());
				window.setComboBoxTeachers(conection.receiveUTF());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case FIND_INFO_ADD_COURSE:
			try {
				conection.sendUTF("FIND_INFO_ADD_COURSE");
				window.setVisibleSchedule(true);
				conection.sendUTF(window.getComboBoxCoursesValue());
				conection.sendUTF(window.getComboBoxTeachersValue());
				window.setInfoSchedule(conection.receiveUTF());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case VISIBLE_TEACHERS:
			window.setVisibleTeachers(false);
			window.setVisibleSchedule(false);
			break;
		case VISIBLE_SCHEDULE:
			window.setVisibleSchedule(false);
			break;
		case INSERT_COURSE:
			try {
				conection.sendUTF("INSERT_COURSE");
				conection.sendUTF(
						code + ";;;" + window.getComboBoxCoursesValue() + ";;;" + window.getComboBoxTeachersValue());
				if (conection.receiveBoolean()) {
					JOptionPane.showMessageDialog(null, "Inscrito exitosamente", "ASIGNATURA", JOptionPane.YES_OPTION);
				}else {
					JOptionPane.showMessageDialog(null, "Error al inscribir", "ASIGNATURA", JOptionPane.NO_OPTION);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		default:
			break;
		}
	}
}