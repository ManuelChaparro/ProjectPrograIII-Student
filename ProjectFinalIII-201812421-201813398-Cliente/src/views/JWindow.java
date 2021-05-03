package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Event;

public class JWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JCardsPanel cards;
	private LoginPanel login;
	private StudentInterface student;

	public JWindow(ActionListener actionListener) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(ConstantsGUI.TITLE_WINDOW);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_APP_ICON)).getImage());
		setVisible(true);
		initWindow(actionListener);
	}

	private void initWindow(ActionListener actionListener) {
		cards = new JCardsPanel(actionListener);
		add(cards);

		login = new LoginPanel(actionListener);
		cards.add(login, ConstantsGUI.LOGIN_TEXT_CARDLAYOUT);

		student = new StudentInterface(actionListener);
		cards.add(student, ConstantsGUI.STUDENT_TEXT_CARDLAYOUT);
	}

	public void changeCard(String nameCard) {
		cards.changeCardLayout(nameCard);
	}

	public void hidePassword() {
		login.hidePassword();
	}

	public void loginAccount() {
		login.loginAccount();
	}

	public String getLoginData() {
		return login.getLoginData();
	}

	public void resetLogin() {
		login.resetLogin();
	}

	public void changeCardStudent(String option) {
		student.changeCardStudent(option);
	}

	public void resertComboBoxCourses() {
		student.resertComboBoxCourses();
	}

	public boolean isCreate() {
		return login.isCreate();
	}

	public void setComboBoxCourses(String courses) {
		student.setComboBoxCourses(courses);
	}

	public String getComboBoxCoursesValue() {
		return student.getComboBoxCoursesValue();
	}

	public void setComboBoxTeachers(String teachers) {
		student.setComboBoxTeachers(teachers);
	}

	public void resetComboBoxTeachers() {
		student.resetComboBoxTeachers();
	}

	public String getComboBoxTeachersValue() {
		return student.getComboBoxTeachersValue();
	}

	public void setInfoSchedule(String infoSchedule) {
		student.setInfoSchedule(infoSchedule);
	}

	public void enableAddCourse(boolean isEnable) {
		student.enableAddCourse(isEnable);
	}

	public void changeColorMenuBtn(Event event) {
		student.changeColorMenuBtn(event);
	}

	public void setVisibleTeachers(boolean isVisible) {
		student.setVisibleTeachers(isVisible);
	}

	public void setVisibleSchedule(boolean isVisible) {
		student.setVisibleSchedule(isVisible);
	}

	public void setVisibleHomework(boolean isVisible) {
		student.setVisibleHomework(isVisible);

	}

	public void setVisibleModify(boolean isVisible) {
		student.setVisibleModify(isVisible);
	}

	public void setComboBoxStudentCourses(String courses) {
		student.setComboBoxStudentCourses(courses);
	}

	public String getComboModHomeworkCourse() {
		return student.getComboBoxStudentCourses();
	}

	public void setComboBoxStudentHomework(String homeworks) {
		student.setComboBoxStudentHomework(homeworks);
	}

	public void resetComboBoxStudentHomework() {
		student.resetComboBoxStudentHomework();
	}

	public String getComboModHomework() {
		return student.getComboBoxHomework();
	}

	public void setInfoHomeWork(String[] dataHomework) {
		student.setInfoHomeWork(dataHomework);
	}

	public void setEditableNameHomework(boolean isEditable) {
		student.setEditableNameHomework(isEditable);
	}

	public boolean isNewHomework() {
		return student.isNewHomework();
	}

	public String getNameHomework() {
		return student.getNameHomework();
	}

	public String getAnotationHomework() {
		return student.getAnotationHomework();
	}

	public String getCalificationHomework() {
		return student.getCalificationHomework();
	}

	public void resetNameHomework() {
		student.resetNameHomework();
	}

	public void resetAnnotationHomework() {
		student.resetAnnotationHomework();
	}

	public void resetCalification() {
		student.resetCalification();
	}

	public void resetComboModifyHomeCourses() {
		student.resetComboModifyHomeCourses();
	}

	public void resetComboDeleteHomeCourses() {
		student.resetComboDeleteHomeCourses();
	}

	public void setVisibleConfirmDelete(boolean isVisible) {
		student.setVisibleConfirmDelete(isVisible);
	}

	public void setVisibleDeleteCourse(boolean isVisible) {
		student.setVisibleDeleteCourse(isVisible);
	}

	public void setVisibleDeleteHomework(boolean isVisible) {
		student.setVisibleDeleteHomework(isVisible);
	}

	public void setVisibleModifyActivity(boolean isVisible) {
		student.setVisibleModifyActivity(isVisible);
	}

	public void resetModifyPanel() {
		student.resetModifyPanel();
	}

	public void setEditableNameActivity(boolean isEditable) {
		student.setEditableNameActivity(isEditable);
	}

	public void resetDeleteActivity() {
		student.resetDeleteActivity();
	}

	public boolean getSelectedItemsActivity() {
		return student.getSelectedItemsActivity();
	}

	public void setEditBtnDeleteAct(boolean isEditable) {
		student.setEditBtnDeleteAct(isEditable);
	}

	public String getDeleteActString() {
		return student.getDeleteActString();
	}

	public String getModActString() {
		return student.getModActString();
	}

	public String getDeleteHomework() {
		return student.getDeleteHomework();
	}

	public String getDeleteCourse() {
		return student.getDeleteCourse();
	}

	public boolean getSelectedItemsCourse() {
		return student.getSelectedItemsCourse();
	}

	public void setEditBtnDeleteCourse(boolean isEditable) {
		student.setEditBtnDeleteCourse(isEditable);
	}

	public void setEditBtnAVG() {
		student.setEditBtnAVG();
	}

	public void resetAvgCourses() {
		student.resetAvgCourses();
	}

	public void setVisibleAVG(boolean isVisible) {
		student.setVisibleAVG(isVisible);
	}

	public void setComboBoxDeleteCourses(String[] split) {
		student.setComboBoxDeleteCourses(split);
	}

	public void setComboBoxDeleteHomeworks(String[] homeworks) {
		student.setComboBoxDeleteHomeworks(homeworks);
	}

	public void resetFindHomework() {
		student.resetFindHomework();
	}

	public void resetComboDeleteCourses() {
		student.resetComboDeleteCourses();
	}

	public void removeSpecificCourse(String deleteCourse) {
		student.removeSpecificCourse(deleteCourse);
	}

	public boolean getItemsModifyCourses() {
		return student.getItemsModifyCourses();
	}

	public void setEditBtnModifyCourse(boolean isEditable) {
		student.setEditBtnModifyCourse(isEditable);
	}

	public void removeSpecificHomework(String deleteHomework) {
		student.removeSpecificHomework(deleteHomework);
	}

	public boolean getItemsDeleteHomework() {
		return student.getItemsDeleteHomework();
	}

	public void setEditBtnDeleteHomework(boolean isEditable) {
		student.setEditBtnDeleteHomework(isEditable);
	}

	public void setComboBoxActivities(String activities) {
		student.setComboBoxActivities(activities);
	}

	public String getComboBoxActivity() {
		return student.getComboBoxActivity();
	}

	public void setEnableModifyActivity(boolean isEnable) {
		student.setEnableModifyActivity(isEnable);
	}

	public boolean getEnableModifyActivity() {
		return student.getEnableModifyActivity();
	}

	public void setComboBoxActivity(String infoActivity) {
		student.setComboBoxActivity(infoActivity);
	}

	public String getSelectedItemCourseAVG() {
		return student.getSelectedItemCourseAVG();
	}

	public void setComboBoxAvgCourses(String courses) {
		student.setComboBoxAvgCourses(courses);
	}

	public void setAvgCourse(String avgCourse) {
		student.setAvgCourse(avgCourse);
	}

	public void setAvgTotal(String avgTotal) {
		student.setAvgTotal(avgTotal);
	}

	public void setScheduleInfo(ActionListener actionListener, String schedule) {
		student.setScheduleInfo(actionListener, schedule);
	}

	public String getSelectedBtn(ActionEvent e) {
		return student.getSelectedBtn(e);
	}

	public void setNameUser(String name) {
		student.setNameUser(name);
	}
}