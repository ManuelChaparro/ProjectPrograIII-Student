package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.Event;

public class StudentInterface extends JPanel {

	private static final long serialVersionUID = 1L;
	private MenuStudent menu;
	private PanelInfoStudent info;

	public StudentInterface(ActionListener actionListener) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		menu = new MenuStudent(actionListener);
		add(menu, BorderLayout.WEST);

		info = new PanelInfoStudent(actionListener);
		add(info, BorderLayout.CENTER);
	}

	public void changeCardStudent(String option) {
		info.changeCardStudent(option);
	}

	public void setComboBoxCourses(String courses) {
		info.setComboBoxCourses(courses);
	}

	public void resertComboBoxCourses() {
		info.resertComboBoxCourses();
	}

	public String getComboBoxCoursesValue() {
		return info.getComboBoxCoursesValue();
	}

	public void setComboBoxTeachers(String teachers) {
		info.setComboBoxTeachers(teachers);
	}

	public void resetComboBoxTeachers() {
		info.resetComboBoxTeachers();
	}

	public String getComboBoxTeachersValue() {
		return info.getComboBoxTeachersValue();
	}

	public void setInfoSchedule(String infoSchedule) {
		info.setInfoSchedule(infoSchedule);
	}

	public void enableAddCourse(boolean isEnable) {
		menu.enableAddCourse(isEnable);
	}

	public void changeColorMenuBtn(Event event) {
		menu.changeColorMenuBtn(event);
	}

	public void setVisibleTeachers(boolean isVisible) {
		info.setVisibleTeachers(isVisible);

	}

	public void setVisibleSchedule(boolean isVisible) {
		info.setVisibleSchedule(isVisible);

	}

	public void setVisibleHomework(boolean isVisible) {
		info.setVisibleHomework(isVisible);

	}

	public void setVisibleModify(boolean isVisible) {
		info.setVisibleModify(isVisible);

	}

	public void setComboBoxStudentCourses(String courses) {
		info.setComboBoxStudentCourses(courses);
	}

	public String getComboBoxStudentCourses() {
		return info.getComboBoxStudentCourses();
	}

	public void setComboBoxStudentHomework(String homeworks) {
		info.setComboBoxStudentHomework(homeworks);
	}

	public void resetComboBoxStudentHomework() {
		info.resetComboBoxStudentHomework();
	}

	public String getComboBoxHomework() {
		return info.getComboBoxHomework();
	}

	public void setInfoHomeWork(String[] dataHomework) {
		info.setInfoHomeWork(dataHomework);
	}

	public void setEditableNameHomework(boolean isEditable) {
		info.setEditableNameHomework(isEditable);
	}

	public boolean isNewHomework() {
		return info.isNewHomework();
	}

	public String getNameHomework() {
		return info.getNameHomework();
	}

	public String getAnotationHomework() {
		return info.getAnotationHomework();
	}

	public String getCalificationHomework() {
		return info.getCalificationHomework();
	}

	public void resetNameHomework() {
		info.resetNameHomework();
	}

	public void resetAnnotationHomework() {
		info.resetAnnotationHomework();
	}

	public void resetCalification() {
		info.resetCalification();
	}

	public void resetComboModifyHomeCourses() {
		info.resetComboModifyHomeCourses();
	}

	public void resetComboDeleteHomeCourses() {
		info.resetComboDeleteHomeCourses();
	}

	public void setVisibleConfirmDelete(boolean isVisible) {
		info.setVisibleConfirmDelete(isVisible);
	}

	public void setVisibleDeleteCourse(boolean isVisible) {
		info.setVisibleDeleteCourse(isVisible);
	}

	public void setVisibleDeleteHomework(boolean isVisible) {
		info.setVisibleDeleteHomework(isVisible);
	}

	public void setVisibleModifyActivity(boolean isVisible) {
		info.setVisibleModifyActivity(isVisible);
	}

	public void resetModifyPanel() {
		info.resetModifyPanel();
	}

	public void setEditableNameActivity(boolean isEditable) {
		info.setEditableNameActivity(isEditable);
	}

	public void resetDeleteActivity() {
		info.resetDeleteActivity();
	}

	public boolean getSelectedItemsActivity() {
		return info.getSelectedItemsActivity();
	}

	public void setEditBtnDeleteAct(boolean isEditable) {
		info.setEditBtnDeleteAct(isEditable);
	}

	public String getDeleteActString() {
		return info.getDeleteActString();
	}

	public String getModActString() {
		return info.getModActString();
	}

	public String getDeleteHomework() {
		return info.getDeleteHomework();
	}

	public String getDeleteCourse() {
		return info.getDeleteCourse();
	}

	public boolean getSelectedItemsCourse() {
		return info.getSelectedItemsCourse();
	}

	public void setEditBtnDeleteCourse(boolean isEditable) {
		info.setEditBtnDeleteCourse(isEditable);
	}

	public void setEditBtnAVG() {
		info.setEditBtnAVG();
	}

	public void resetAvgCourses() {
		info.resetAvgCourses();
	}

	public void setVisibleAVG(boolean isVisible) {
		info.setVisibleAVG(isVisible);
	}

	public void setComboBoxDeleteCourses(String[] split) {
		info.setComboBoxDeleteCourses(split);
	}

	public void setComboBoxDeleteHomeworks(String[] homeworks) {
		info.setComboBoxDeleteHomeworks(homeworks);
	}

	public void resetFindHomework() {
		info.resetFindHomework();
	}

	public void resetComboDeleteCourses() {
		info.resetComboDeleteCourses();
	}

	public void removeSpecificCourse(String deleteCourse) {
		info.removeSpecificCourse(deleteCourse);
	}

	public boolean getItemsModifyCourses() {
		return info.getItemsModifyCourses();
	}

	public void setEditBtnModifyCourse(boolean isEditable) {
		info.setEditBtnModifyCourse(isEditable);
	}

	public void removeSpecificHomework(String deleteHomework) {
		info.removeSpecificHomework(deleteHomework);
	}

	public boolean getItemsDeleteHomework() {
		return info.getItemsDeleteHomework();
	}

	public void setEditBtnDeleteHomework(boolean isEditable) {
		info.setEditBtnDeleteHomework(isEditable);
	}

	public void setComboBoxActivities(String activities) {
		info.setComboBoxActivities(activities);
	}

	public String getComboBoxActivity() {
		return info.getComboBoxActivity();
	}

	public void setEnableModifyActivity(boolean isEnable) {
		info.setEnableModifyActivity(isEnable);
	}

	public boolean getEnableModifyActivity() {
		return info.getEnableModifyActivity();
	}

	public void setComboBoxActivity(String infoActivity) {
		info.setComboBoxActivity(infoActivity);
	}

	public String getSelectedItemCourseAVG() {
		return info.getSelectedItemCourseAVG();
	}

	public void setComboBoxAvgCourses(String courses) {
		info.setComboBoxAvgCourses(courses);
	}

	public void setAvgCourse(String avgCourse) {
		info.setAvgCourse(avgCourse);
	}

	public void setAvgTotal(String avgTotal) {
		info.setAvgTotal(avgTotal);
	}

	public void setScheduleInfo(ActionListener actionListener, String schedule) {
		info.setScheduleInfo(actionListener, schedule);
	}

	public String getSelectedBtn(ActionEvent e) {
		return info.getSelectedBtn(e);
	}

	public void setNameUser(String name) {
		info.setNameUser(name);
	}
}
