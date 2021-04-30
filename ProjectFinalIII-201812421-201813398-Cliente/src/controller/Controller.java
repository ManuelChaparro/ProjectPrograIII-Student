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
			if (!data.equalsIgnoreCase("vacio")) {
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
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese los datos solicitados", "Error creacion",
						JOptionPane.ERROR_MESSAGE);
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
		case DELETE_COURSE_OR_HOMEWORK:
			window.changeColorMenuBtn(Event.DELETE_COURSE_OR_HOMEWORK);
			window.setVisibleHomework(false);
			window.setVisibleConfirmDelete(false);
			window.resetComboDeleteHomeCourses();
			
			
			
			//Despues de setear info en combobox
			if (!window.getSelectedItemsCourse()) {
				window.setEditBtnDeleteCourse(false);
			}
			window.changeCardStudent("DeleteCourse");
			break;
		case FIND_HOMEWORK_DELETE:
			window.setVisibleHomework(true);
			break;
		case DELETE_COURSE:
			window.setVisibleDeleteCourse(true);
			break;
		case DELETE_HOMEWORK:
			window.setVisibleDeleteHomework(true);
			break;
		case CONFIRM_DELETE_COURSE:
			String course = window.getDeleteCourse();
			//Enviar datos de borrado curso
			break;
		case CONFIRM_DELETE_HOMEWORK:
			String homework = window.getDeleteHomework();
			//Enviar datos de borrado asignatura
			break;
		case ADD_OR_MOD_ACTIVITY_ST:
			window.changeColorMenuBtn(Event.ADD_OR_MOD_ACTIVITY_ST);
			window.resetModifyPanel();
			window.setVisibleModifyActivity(false);
			window.changeCardStudent("ModifyActivity");
			break;
		case FIND_MODIFY_HOMEWORK:
			window.setVisibleModifyActivity(true);
			if (window.getOptionModifyAct().equalsIgnoreCase("AÑADIR ACTIVIDAD")) {
				window.setEditableNameActivity(true);
			}else {
				window.setEditableNameActivity(false);
			}
			break;
		case ADD_OR_MODIFY_ACTIVITY:
			String modActivity = window.getModActString();
			//Enviar datos de actividad modificada/creada
			
			window.resetModifyPanel();
			break;
		case DELETE_ACTIVITY_ST:
			window.changeColorMenuBtn(Event.DELETE_ACTIVITY_ST);
			window.resetDeleteActivity();
			window.setVisibleConfirmDelete(false);
			
			//despues de setear la info en el combobox
			if (!window.getSelectedItemsActivity()) {
				window.setEditBtnDeleteAct(false);
			}
			window.changeCardStudent("DeleteActivity");
			break;
		case DELETE_ACTIVITY:
			window.setVisibleConfirmDelete(true);
			break;
		case CONFIRM_DELETE_ACTIVITY:
			String activity = window.getDeleteActString();
			//Enviar datos de actividad a borrar
			
			window.resetDeleteActivity();
			break;
		case AVG_ST:
			window.changeColorMenuBtn(Event.AVG_ST);
			window.resetAvgCourses();
//			window.setVisibleConfirmDelete(false);
			
			//despues de setear la info en el combobox
			if (!window.getSelectedItemsAVG()) {
				window.setEditBtnAVG(false);
			}
			window.changeCardStudent("Average");
			break;
		case CALCULATE_AVG:
			window.setVisibleAVG(true);
			break;
		default:
			break;
		}
	}
}