package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import models.User;
import net.Conection;
import views.ConstantsGUI;
import views.DialogInfoSchedule;
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
			actionGetLoginData();
			break;
		case GET_CREATE_DATA:
			actionGetCreateData();
			break;
		case CANCEL_NEW_ACCOUNT:
			window.resetLogin();
			break;
		case SHOW_SCHEDULE:
			actionShowSchedule();
			break;
		case ACTION_SCHEDULER_BTN:
			actionScheduleBtn(e);
			break;
		case ADD_COURSE_ST:
			actionAddCourseSt();
			break;
		case FIND_TEACHERS:
			actionFindTeachers();
			break;
		case FIND_INFO_ADD_COURSE:
			actionFindInfoAddCourse();
			break;
		case VISIBLE_TEACHERS:
			actionVisibleTeachers();
			break;
		case VISIBLE_SCHEDULE:
			window.setVisibleSchedule(false);
			break;
		case INSERT_COURSE:
			actionInsertCourse();
			break;
		case MODIFY_COURSE_ST:
			actionModifyCourseSt();
			break;
		case VISIBLE_HOMEWORK:
			actionVisibleHomework();
			break;
		case VISIBLE_MODIFY:
			window.setVisibleModify(false);
			break;
		case FIND_HOMEWORK:
			actionFindHomework();
			break;
		case FIND_INFO_HOMEWORK:
			actionFindInfoHomework();
			break;
		case ADD_OR_MODIFY_HOMEWORK:
			actionAddOrModHomework();
			break;
		case DELETE_COURSE_OR_HOMEWORK:
			actionDeleteCourseOrHomework();
			break;
		case FIND_HOMEWORK_DELETE:
			actionFindHomeworkDelete();
			break;
		case DELETE_COURSE:
			window.setVisibleDeleteCourse(true);
			break;
		case DELETE_HOMEWORK:
			window.setVisibleDeleteHomework(true);
			break;
		case CONFIRM_DELETE_COURSE:
			actionConfirmDeleteCourse();
			break;
		case CONFIRM_DELETE_HOMEWORK:
			actionConfirmDeleteHomework();
			break;
		case ADD_OR_MOD_ACTIVITY_ST:
			actionAddOrModActivitySt();
			break;
		case MODIFY_ACTIVITY:
			actionModifyActivity();
			break;
		case RESET_MODIFY_ACTIVITY:
			actionResetModifyActivity();
			break;
		case SEND_ACTIVITY:
			actionSendActivity();
			break;
		case DELETE_ACTIVITY_ST:
			actionDeleteActivitySt();
			break;
		case DELETE_ACTIVITY:
			window.setVisibleConfirmDelete(true);
			break;
		case RESET_DELETE_ACTIVITY:
			window.setVisibleConfirmDelete(false);
			break;
		case CONFIRM_DELETE_ACTIVITY:
			actionConfirmDeleteActivity();
			break;
		case AVG_ST:
			actionAvgSt();
			break;
		case CALCULATE_AVG:
			actionCalculateAvg();
			break;
		case VISIBLE_AVG:
			window.setVisibleAVG(false);
			break;		
		}
	}

	private void actionGetLoginData() {
		String data = window.getLoginData();
		if (!data.equalsIgnoreCase(ConstantsCnt.EMPTY_ORDER_TEXT)) {
			if (!window.isCreate()) {
				try {
					String[] dataUser = data.split(ConstantsCnt.COMA);
					String stringUser = ConstantsCnt.EMPTY_STRING;
					try {
						stringUser = new Gson().toJson(new User(ConstantsCnt.EMPTY_STRING, dataUser[0], dataUser[1]))
								.toString();
					} catch (Exception e2) {
						stringUser = new Gson().toJson(new User(ConstantsCnt.EMPTY_STRING, ConstantsCnt.EMPTY_STRING,
								ConstantsCnt.EMPTY_STRING)).toString();
					}
					conection.sendBoolean(true);
					conection.sendUTF(stringUser);
					if (conection.receiveBoolean()) {
						code = dataUser[0];
						conection.sendUTF(code);
						window.setNameUser(conection.receiveUTF());
						window.changeCard(ConstantsCnt.STUDENT_TEXT_CARDLAYOUT);
					} else {
						JOptionPane.showMessageDialog(null, ConstantsCnt.WARNING_MESSAGE_NOT_EXIST_USER,
								ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
							ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, ConstantsCnt.WARNING_MESSAGE_INPUT_CORRECT_DATA,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionGetCreateData() {
		String dataCreateLog = window.getLoginData();
		String[] dataUser = dataCreateLog.split(ConstantsCnt.COMA);
		try {
			String stringUser = new Gson().toJson(new User(dataUser[0], dataUser[1], dataUser[2])).toString();
			conection.sendBoolean(false);
			conection.sendUTF(stringUser);
			if (conection.receiveBoolean()) {
				JOptionPane.showMessageDialog(null, ConstantsCnt.SUCCESS_MESSAGE_USER_CREATED, ConstantsGUI.NAME_APP,
						JOptionPane.INFORMATION_MESSAGE);
				window.resetLogin();
				window.changeCard(ConstantsCnt.LOGIN_TEXT_CARDLAYOUT);
			} else {
				JOptionPane.showMessageDialog(null, ConstantsCnt.WARNING_MESSAGE_USER_ALREADY_EXIST,
						ConstantsGUI.NAME_APP, JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionShowSchedule() {
		try {
			window.changeColorMenuBtn(Event.SHOW_SCHEDULE);
			conection.sendUTF(ConstantsCnt.SHOW_SCHEDULE_TEXT_SUBCOMMAND);
			conection.sendUTF(code);
			window.setScheduleInfo(this, conection.receiveUTF());
		} catch (IOException e2) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
		window.changeCardStudent(ConstantsCnt.SCHEDULE_TEXT_CARDLAYOUT);
	}

	private void actionScheduleBtn(ActionEvent e) {
		DialogInfoSchedule dialog = new DialogInfoSchedule();
		try {
			conection.sendUTF(ConstantsCnt.ACTION_SCHEDULER_BTN_TEXT_SUBCOMMAND);
			conection.sendUTF(code);
			conection.sendUTF(window.getSelectedBtn(e));
			if (conection.receiveBoolean()) {
				dialog.setInfoActivity(conection.receiveUTF());
				dialog.setVisible(true);
			} else {
				dialog.setInfoCourse(conection.receiveUTF());
				dialog.setVisible(true);
			}
		} catch (IOException e2) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionAddCourseSt() {
		try {
			window.changeColorMenuBtn(Event.ADD_COURSE_ST);
			conection.sendUTF(ConstantsCnt.ADD_COURSE_ST_TEXT_SUBCOMMAND);
			window.resertComboBoxCourses();
			window.resetComboBoxTeachers();
			window.setComboBoxCourses(conection.receiveUTF());
			window.changeCardStudent(ConstantsCnt.ADD_COURSE_TEXT_CARDLAYOUT);
		} catch (IOException e3) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionFindTeachers() {
		try {
			conection.sendUTF(ConstantsCnt.FIND_TEACHERS_TEXT_SUBCOMMAND);
			window.setVisibleTeachers(true);
			window.resetComboBoxTeachers();
			conection.sendUTF(window.getComboBoxCoursesValue());
			window.setComboBoxTeachers(conection.receiveUTF());
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionFindInfoAddCourse() {
		try {
			conection.sendUTF(ConstantsCnt.FIND_INFO_ADD_COURSE_TEXT_SUBCOMMAND);
			window.setVisibleSchedule(true);
			conection.sendUTF(window.getComboBoxCoursesValue());
			conection.sendUTF(window.getComboBoxTeachersValue());
			window.setInfoSchedule(conection.receiveUTF());
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionVisibleTeachers() {
		window.setVisibleTeachers(false);
		window.setVisibleSchedule(false);
	}

	private void actionInsertCourse() {
		try {
			conection.sendUTF(ConstantsCnt.INSERT_COURSE_TEXT_SUBCOMMAND);
			conection.sendUTF(code + ConstantsCnt.SEPARATOR_THREE_DOT_AND_COMA + window.getComboBoxCoursesValue()
					+ ConstantsCnt.SEPARATOR_THREE_DOT_AND_COMA + window.getComboBoxTeachersValue());
			if (conection.receiveBoolean()) {
				JOptionPane.showMessageDialog(null, ConstantsCnt.SUCCESS_MESSAGE_COURSE_INSCRIPTION,
						ConstantsCnt.COURSE_TEXT_TITLE, JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_COURSE_INSCRIPTION,
						ConstantsCnt.COURSE_TEXT_TITLE, JOptionPane.WARNING_MESSAGE);
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionModifyCourseSt() {
		try {
			window.changeColorMenuBtn(Event.MODIFY_COURSE_ST);
			actionVisibleHomework();
			window.resetComboModifyHomeCourses();
			conection.sendUTF(ConstantsCnt.MODIFY_COURSE_ST_TEXT_SUBCOMMAND);
			conection.sendUTF(code);
			window.setComboBoxStudentCourses(conection.receiveUTF());
			if (!window.getItemsModifyCourses()) {
				window.setEditBtnModifyCourse(false);
			} else {
				window.setEditBtnModifyCourse(true);
			}
			window.changeCardStudent(ConstantsCnt.MODIFY_COURSE_TEXT_CARDLAYOUT);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionVisibleHomework() {
		window.setVisibleHomework(false);
		window.setVisibleModify(false);
	}

	private void actionFindHomework() {
		try {
			conection.sendUTF(ConstantsCnt.FIND_HOMEWORK_TEXT_SUBCOMMAND);
			conection.sendUTF(code);
			window.resetComboBoxStudentHomework();
			conection.sendUTF(window.getComboModHomeworkCourse());
			window.setComboBoxStudentHomework(conection.receiveUTF());
			window.setVisibleHomework(true);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionFindInfoHomework() {
		try {
			conection.sendUTF(ConstantsCnt.FIND_INFO_HOMEWORK_TEXT_SUBCOMMAND);
			if (!window.getComboModHomework().equalsIgnoreCase(ConstantsCnt.ADD_HOMEWORK_TEXT_SUBCOMMAND)) {
				conection.sendBoolean(false);
				conection.sendUTF(code + ConstantsCnt.SEPARATOR_THREE_DOT_AND_COMA + window.getComboModHomeworkCourse()
						+ ConstantsCnt.SEPARATOR_THREE_DOT_AND_COMA + window.getComboModHomework());
				String[] dataHomework = conection.receiveUTF().split(ConstantsCnt.SPECIAL_Y_SEPARATOR);
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
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionAddOrModHomework() {
		try {
			conection.sendUTF(ConstantsCnt.ADD_OR_MODIFY_HOMEWORK_TEXT_SUBCOMMAND);
			conection.sendBoolean(window.isNewHomework());
			conection.sendUTF(code + ConstantsCnt.SEPARATOR_THREE_DOT_AND_COMA + window.getComboModHomeworkCourse()
					+ ConstantsCnt.SEPARATOR_THREE_DOT_AND_COMA + window.getNameHomework()
					+ ConstantsCnt.SEPARATOR_THREE_DOT_AND_COMA + window.getAnotationHomework()
					+ ConstantsCnt.SEPARATOR_THREE_DOT_AND_COMA + window.getCalificationHomework());
			if (conection.receiveBoolean()) {
				JOptionPane.showMessageDialog(null, ConstantsCnt.SUCCESS_PROCESS_MESSAGE,
						ConstantsCnt.ADD_MODIFY_HOMEWORK_TEXT_TITLE, JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_HAS_OCURRED_ERROR,
						ConstantsCnt.ADD_MODIFY_HOMEWORK_TEXT_TITLE, JOptionPane.WARNING_MESSAGE);
			}
			window.resetNameHomework();
			window.resetAnnotationHomework();
			window.resetCalification();
			actionVisibleHomework();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionDeleteCourseOrHomework() {
		try {
			conection.sendUTF(ConstantsCnt.DELETE_COURSE_OR_HOMEWORK_TEXT_SUBCOMMAND);
			window.changeColorMenuBtn(Event.DELETE_COURSE_OR_HOMEWORK);
			window.setVisibleHomework(false);
			window.setVisibleConfirmDelete(false);
			window.resetComboDeleteHomeCourses();
			window.resetComboDeleteCourses();
			conection.sendUTF(code);
			window.setComboBoxDeleteCourses(conection.receiveUTF().split(ConstantsCnt.SEPARATOR_ONE_DOT_AND_COMA));
			if (!window.getSelectedItemsCourse()) {
				window.setEditBtnDeleteCourse(false);
			} else {
				window.setEditBtnDeleteCourse(true);
			}
			window.changeCardStudent(ConstantsCnt.DELETE_COURSE_TEXT_CARDLAYOUT);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionFindHomeworkDelete() {
		try {
			window.resetFindHomework();
			window.setVisibleHomework(true);
			conection.sendUTF(ConstantsCnt.FIND_HOMEWORK_DELETE_TEXT_SUBCOMMAND);
			conection.sendUTF(code);
			conection.sendUTF(window.getDeleteCourse());
			window.setComboBoxDeleteHomeworks(conection.receiveUTF().split(ConstantsCnt.SEPARATOR_ONE_DOT_AND_COMA));
			if (!window.getItemsDeleteHomework()) {
				window.setEditBtnDeleteHomework(false);
			} else {
				window.setEditBtnDeleteHomework(true);
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionConfirmDeleteCourse() {
		try {
			conection.sendUTF(ConstantsCnt.CONFIRM_DELETE_COURSE_TEXT_SUBCOMMAND);
			conection.sendUTF(code);
			conection.sendUTF(window.getDeleteCourse());
			window.removeSpecificCourse(window.getDeleteCourse());
			if (!window.getSelectedItemsCourse()) {
				window.setEditBtnDeleteCourse(false);
			} else {
				window.setEditBtnDeleteCourse(true);
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionConfirmDeleteHomework() {
		try {
			conection.sendUTF(ConstantsCnt.CONFIRM_DELETE_HOMEWORK_TEXT_SUBCOMMAND);
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
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionAddOrModActivitySt() {
		try {
			conection.sendUTF(ConstantsCnt.ADD_OR_MOD_ACTIVITY_ST_TEXT_SUBCOMMAND);
			window.resetModifyPanel();
			window.changeColorMenuBtn(Event.ADD_OR_MOD_ACTIVITY_ST);
			conection.sendUTF(code);
			window.setComboBoxActivities(conection.receiveUTF());
			window.setVisibleModifyActivity(false);
			window.changeCardStudent(ConstantsCnt.MODIFY_ACTIVITY_TEXT_CARDLAYOUT);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionModifyActivity() {
		window.setVisibleModifyActivity(true);
		if (window.getComboBoxActivity().equalsIgnoreCase(ConstantsCnt.ADD_ACTIVITY_TEXT_SUBCOMMAND)) {
			window.setEnableModifyActivity(true);
		} else {
			try {
				window.setEnableModifyActivity(false);
				conection.sendUTF(ConstantsCnt.FIND_MODIFY_HOMEWORK_TEXT_SUBCOMMAND);
				conection.sendUTF(code);
				conection.sendUTF(window.getComboBoxActivity());
				window.setComboBoxActivity(conection.receiveUTF());
				window.setEditableNameActivity(false);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
						ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void actionResetModifyActivity() {
		window.setEditableNameActivity(false);
		window.setVisibleModifyActivity(false);
	}

	private void actionSendActivity() {
		try {
			String dataActivity = window.getModActString();
			if (!dataActivity.equalsIgnoreCase(ConstantsCnt.EMPTY_DATA_TEXT_CARDLAYOUT)
					&& !dataActivity.equalsIgnoreCase(ConstantsCnt.ERROR_END_TEXT_CARDLAYOUT)) {
				conection.sendUTF(ConstantsCnt.SEND_ACTIVITY_TEXT_SUBCOMMAND);
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
					JOptionPane.showMessageDialog(null, ConstantsCnt.WARNING_MESSAGE_INPUT_BUSY_HOUR,
							ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showInternalMessageDialog(null, ConstantsCnt.SUCCESS_MESSAGE_ACTIVITY,
							ConstantsCnt.ACTIVITY_MINUS_TEXT_TITLE, JOptionPane.INFORMATION_MESSAGE);
				}
				window.setComboBoxActivities(conection.receiveUTF());
				window.setVisibleModifyActivity(false);
			} else if (window.getModActString().equalsIgnoreCase(ConstantsCnt.ERROR_END_TEXT_CARDLAYOUT)) {
				JOptionPane.showMessageDialog(null, ConstantsCnt.WARNING_MESSAGE_SELECT_VALIDATE_HOUR,
						ConstantsCnt.ACTIVITY_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, ConstantsCnt.WARNING_MESSAGE_INPUT_CORRECT_DATA,
						ConstantsCnt.ACTIVITY_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionDeleteActivitySt() {
		try {
			window.changeColorMenuBtn(Event.DELETE_ACTIVITY_ST);
			window.resetDeleteActivity();
			window.setVisibleConfirmDelete(false);
			conection.sendUTF(ConstantsCnt.DELETE_ACTIVITY_ST_TEXT_SUBCOMMAND);
			conection.sendUTF(code);
			window.setComboBoxActivities(conection.receiveUTF());
			if (!window.getSelectedItemsActivity()) {
				window.setEditBtnDeleteAct(false);
			} else {
				window.setEditBtnDeleteAct(true);
			}
			window.changeCardStudent(ConstantsCnt.DELETE_ACTIVITY_TEXT_CARDLAYOUT);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionConfirmDeleteActivity() {
		try {
			conection.sendUTF(ConstantsCnt.CONFIRM_DELETE_ACTIVITY_TEXT_SUBCOMMAND);
			conection.sendUTF(code);
			conection.sendUTF(window.getDeleteActString());
			window.resetDeleteActivity();
			window.setComboBoxActivities(conection.receiveUTF());
			if (!window.getSelectedItemsActivity()) {
				window.setEditBtnDeleteAct(false);
			}
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionAvgSt() {
		try {
			conection.sendUTF(ConstantsCnt.AVG_ST_TEXT_SUBCOMMAND);
			window.resetAvgCourses();
			conection.sendUTF(code);
			window.setComboBoxAvgCourses(conection.receiveUTF());
			window.changeColorMenuBtn(Event.AVG_ST);
			window.setEditBtnAVG();
			window.changeCardStudent(ConstantsCnt.AVERAGE_TEXT_CARDLAYOUT);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}

	private void actionCalculateAvg() {
		try {
			conection.sendUTF(ConstantsCnt.CALCULATE_AVG_TEXT_SUBCOMMAND);
			conection.sendUTF(code);
			conection.sendUTF(window.getSelectedItemCourseAVG());
			window.setAvgCourse(conection.receiveUTF());
			window.setAvgTotal(conection.receiveUTF());
			window.setVisibleAVG(true);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, ConstantsCnt.ERROR_MESSAGE_FAILED_CONNECTION,
					ConstantsCnt.ERROR_TEXT_TITLE, JOptionPane.ERROR_MESSAGE);
		}
	}
}