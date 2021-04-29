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
				try {
					String[] dataUser = data.split(",");
					String stringUser = "";
					try {
						stringUser = new Gson().toJson(new User("", dataUser[0], dataUser[1])).toString();
					} catch (Exception e2) {
						stringUser = new Gson().toJson(new User("", "", "")).toString();
					}
					conection.sendBoolean(true);
					conection.sendUTF(stringUser);
					if (conection.receiveBoolean()) {
						code = dataUser[0];
						window.changeCard("Student");
					} else {
						JOptionPane.showMessageDialog(null, "El usuario no existe");
					}
				} catch (IOException e1) {
					System.out.println(e1);
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
				window.changeColorMenuBtn(Event.SHOW_SCHEDULE);
				conection.sendUTF("SHOW_SCHEDULE");
				System.out.println(conection.receiveUTF());
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			window.changeCardStudent("Schedule");
			break;
		case ADD_COURSE_ST:
			try {
				window.changeColorMenuBtn(Event.ADD_COURSE_ST);
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
					JOptionPane.showMessageDialog(null, "Inscrito exitosamente", "ASIGNATURA",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error al inscribir", "ASIGNATURA",
							JOptionPane.WARNING_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case MODIFY_COURSE_ST:
			try {
				window.changeColorMenuBtn(Event.MODIFY_COURSE_ST);
				window.setVisibleHomework(false);
				window.setVisibleModify(false);
				window.resetComboModifyHomeCourses();
				conection.sendUTF("MODIFY_COURSE_ST");
				conection.sendUTF(code);
				window.setComboBoxStudentCourses(conection.receiveUTF());
				window.changeCardStudent("ModifyCourse");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case VISIBLE_HOMEWORK:
			window.setVisibleHomework(false);
			window.setVisibleModify(false);
			break;
		case VISIBLE_MODIFY:
			window.setVisibleModify(false);
			break;
		case FIND_HOMEWORK:
			try {
				conection.sendUTF("FIND_HOMEWORK");
				conection.sendUTF(code);
				window.resetComboBoxStudentHomework();
				conection.sendUTF(window.getComboModHomeworkCourse());
				window.setComboBoxStudentHomework(conection.receiveUTF());
				window.setVisibleHomework(true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case FIND_INFO_HOMEWORK:
			try {
				conection.sendUTF("FIND_INFO_HOMEWORK");
				if (!window.getComboModHomework().equalsIgnoreCase("ANADIR TAREA")) {
					conection.sendBoolean(false);
					conection.sendUTF(
							code + ";;;" + window.getComboModHomeworkCourse() + ";;;" + window.getComboModHomework());
					String[] dataHomework = conection.receiveUTF().split("&");
					window.setEditableNameHomework(false);
					window.setInfoHomeWork(dataHomework);
					window.setVisibleModify(true);
				} else {
					conection.sendBoolean(true);
					window.resetNameHomework();
					window.resetAnnotationHomework();
					window.resetCalification();
					window.setEditableNameHomework(true);
					window.setVisibleModify(true);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case ADD_OR_MODIFY_HOMEWORK:
			try {
				conection.sendUTF("ADD_OR_MODIFY_HOMEWORK");
				conection.sendBoolean(window.isNewHomework());
				conection.sendUTF(code + ";;;" + window.getComboModHomeworkCourse() + ";;;" + window.getNameHomework()
						+ ";;;" + window.getAnotationHomework() + ";;;" + window.getCalificationHomework());
				if (conection.receiveBoolean()) {
					JOptionPane.showMessageDialog(null, "Proceso exitoso.", "ANADIR/MODIFICAR TAREA",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "A ocurrido un error.", "ANADIR/MODIFICAR TAREA",
							JOptionPane.WARNING_MESSAGE);
				}
				window.resetNameHomework();
				window.resetAnnotationHomework();
				window.resetCalification();
				window.setVisibleHomework(false);
				window.setVisibleModify(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	private boolean isUserValid(String[] dataUser) {
		if (dataUser.length == 0) {
			return false;
		} else {
			for (int i = 0; i < dataUser.length; i++) {
				if (dataUser[i].equals("") || dataUser[i] == null) {
					System.out.println("Usuario invalido");
					return false;
				}
			}
			System.out.println("usuario valido");
			return true;
		}
	}
}