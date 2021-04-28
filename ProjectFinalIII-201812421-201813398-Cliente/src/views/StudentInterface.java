package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import controller.Controller;

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

	public void enableAddCourse(boolean b) {
		menu.enableAddCourse(b);
	}
}