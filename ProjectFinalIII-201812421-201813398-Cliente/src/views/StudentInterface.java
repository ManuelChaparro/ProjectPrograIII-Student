package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import controller.Controller;
import controller.Event;

public class StudentInterface extends JPanel{

	private static final long serialVersionUID = 1L;
	private MenuStudent menu;
	private PanelInfoStudent info;
	
	public StudentInterface(Controller controller) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		menu = new MenuStudent(controller);
		add(menu, BorderLayout.WEST);
		
		info = new PanelInfoStudent(controller);
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
}