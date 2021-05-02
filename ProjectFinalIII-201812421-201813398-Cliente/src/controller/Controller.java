package controller;

import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.google.gson.Gson;
import models.User;
import net.Conection;
import views.ButtonObj;
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
				conection.sendUTF(code);
				window.setScheduleInfo(conection.receiveUTF());
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			window.changeCardStudent("Schedule");
			break;
		case ACTION_SCHEDULER_BTN:
			try {
				conection.sendUTF("ACTION_SCHEDULER_BTN");
				conection.sendUTF(code);
				conection.sendUTF(window.getSelectedBtn(e));
				if (conection.receiveBoolean()) {
					JOptionPane.showMessageDialog(null, window.createPanelActivity(conection.receiveUTF()), "INFORMACION ACTIVIDAD", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, window.createPanelCourse(conection.receiveUTF()), "INFORMACION ACTIVIDAD", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
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
				if (!window.getItemsModifyCourses()) {
					window.setEditBtnModifyCourse(false);
				} else {
					window.setEditBtnModifyCourse(true);
				}
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
			try {
				conection.sendUTF("DELETE_COURSE_OR_HOMEWORK");
				window.changeColorMenuBtn(Event.DELETE_COURSE_OR_HOMEWORK);
				window.setVisibleHomework(false);
				window.setVisibleConfirmDelete(false);
				window.resetComboDeleteHomeCourses();
				window.resetComboDeleteCourses();
				conection.sendUTF(code);
				window.setComboBoxDeleteCourses(conection.receiveUTF().split(";"));
				if (!window.getSelectedItemsCourse()) {
					window.setEditBtnDeleteCourse(false);
				} else {
					window.setEditBtnDeleteCourse(true);
				}
				window.changeCardStudent("DeleteCourse");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case FIND_HOMEWORK_DELETE:
			try {
				window.resetFindHomework();
				window.setVisibleHomework(true);
				conection.sendUTF("FIND_HOMEWORK_DELETE");
				conection.sendUTF(code);
				conection.sendUTF(window.getDeleteCourse());
				window.setComboBoxDeleteHomeworks(conection.receiveUTF().split(";"));
				if (!window.getItemsDeleteHomework()) {
					window.setEditBtnDeleteHomework(false);
				} else {
					window.setEditBtnDeleteHomework(true);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case DELETE_COURSE:
			window.setVisibleDeleteCourse(true);
			break;
		case DELETE_HOMEWORK:
			window.setVisibleDeleteHomework(true);
			break;
		case CONFIRM_DELETE_COURSE:
			try {
				conection.sendUTF("CONFIRM_DELETE_COURSE");
				conection.sendUTF(code);
				conection.sendUTF(window.getDeleteCourse());
				window.removeSpecificCourse(window.getDeleteCourse());
				if (!window.getSelectedItemsCourse()) {
					window.setEditBtnDeleteCourse(false);
				} else {
					window.setEditBtnDeleteCourse(true);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case CONFIRM_DELETE_HOMEWORK:
			try {
				conection.sendUTF("CONFIRM_DELETE_HOMEWORK");
				conection.sendUTF(code);
				conection.sendUTF(window.getDeleteCourse());
				conection.sendUTF(window.getDeleteHomework());
				window.removeSpecificHomework(window.getDeleteHomework());
				if (!window.getItemsDeleteHomework()) {
					window.setEditBtnDeleteHomework(false);
				} else {
					window.setEditBtnDeleteHomework(true);
				}
				window.setVisibleConfirmDelete(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case ADD_OR_MOD_ACTIVITY_ST:
			try {
				conection.sendUTF("ADD_OR_MOD_ACTIVITY_ST");
				window.resetModifyPanel();
				window.changeColorMenuBtn(Event.ADD_OR_MOD_ACTIVITY_ST);
				conection.sendUTF(code);
				window.setComboBoxActivities(conection.receiveUTF());
				window.setVisibleModifyActivity(false);
				window.changeCardStudent("ModifyActivity");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case MODIFY_ACTIVITY:
			window.setVisibleModifyActivity(true);
			if (window.getComboBoxActivity().equalsIgnoreCase("AÑADIR ACTIVIDAD")) {
				window.setEnableModifyActivity(true);
			} else {
				try {
					window.setEnableModifyActivity(false);
					conection.sendUTF("FIND_MODIFY_HOMEWORK");
					conection.sendUTF(code);
					conection.sendUTF(window.getComboBoxActivity());
					window.setComboBoxActivity(conection.receiveUTF());
					window.setEditableNameActivity(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			break;
		case RESET_MODIFY_ACTIVITY:
			window.setEditableNameActivity(false);
			window.setVisibleModifyActivity(false);
			break;
		case SEND_ACTIVITY:
			try {
				String dataActivity = window.getModActString();
				if (!dataActivity.equalsIgnoreCase("emptyData") && !dataActivity.equalsIgnoreCase("errorEnd")) {
					conection.sendUTF("SEND_ACTIVITY");
					if (window.getEnableModifyActivity()) {
						conection.sendBoolean(true);
						conection.sendUTF(code);
						conection.sendUTF(window.getModActString());
					} else {
						conection.sendBoolean(false);
						conection.sendUTF(code);
						conection.sendUTF(window.getModActString());
					}
					window.resetModifyPanel();
					if (!conection.receiveBoolean()) {
						JOptionPane.showMessageDialog(null, "Ya hay una actividad para la hora ingresada", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					window.setComboBoxActivities(conection.receiveUTF());
					window.setVisibleModifyActivity(false);
				} else if(window.getModActString().equalsIgnoreCase("errorEnd")){
					JOptionPane.showMessageDialog(null, "Seleccione una hora valida", "ACTIVIDAD",
							JOptionPane.ERROR_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Ingrese los datos obligatorios", "ACTIVIDAD",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			break;
		case DELETE_ACTIVITY_ST:
			try {
				window.changeColorMenuBtn(Event.DELETE_ACTIVITY_ST);
				window.resetDeleteActivity();
				window.setVisibleConfirmDelete(false);
				conection.sendUTF("DELETE_ACTIVITY_ST");
				conection.sendUTF(code);
				window.setComboBoxActivities(conection.receiveUTF());
				if (!window.getSelectedItemsActivity()) {
					window.setEditBtnDeleteAct(false);
				} else {
					window.setEditBtnDeleteAct(true);
				}
				window.changeCardStudent("DeleteActivity");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case DELETE_ACTIVITY:
			window.setVisibleConfirmDelete(true);
			break;
		case RESET_DELETE_ACTIVITY:
			window.setVisibleConfirmDelete(false);
			break;
		case CONFIRM_DELETE_ACTIVITY:
			try {
				conection.sendUTF("CONFIRM_DELETE_ACTIVITY");
				conection.sendUTF(code);
				conection.sendUTF(window.getDeleteActString());
				window.resetDeleteActivity();
				window.setComboBoxActivities(conection.receiveUTF());
				if (!window.getSelectedItemsActivity()) {
					window.setEditBtnDeleteAct(false);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case AVG_ST:
			try {
				conection.sendUTF("AVG_ST");
				window.resetAvgCourses();
				conection.sendUTF(code);
				window.setComboBoxAvgCourses(conection.receiveUTF());
				window.changeColorMenuBtn(Event.AVG_ST);
				window.setEditBtnAVG();
				window.changeCardStudent("Average");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case CALCULATE_AVG:
			try {
				conection.sendUTF("CALCULATE_AVG");
				conection.sendUTF(code);
				conection.sendUTF(window.getSelectedItemCourseAVG());
				window.setAvgCourse(conection.receiveUTF());
				window.setAvgTotal(conection.receiveUTF());
				window.setVisibleAVG(true);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case VISIBLE_AVG:
			window.setVisibleAVG(false);
			break;
		default:
			break;
		}
	}
}