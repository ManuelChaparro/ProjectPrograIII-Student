package views;

import java.awt.Color;
import javax.swing.JPanel;
import controller.Controller;

public class PanelInfoStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	private SchedulePanel schedule;
	private AddCoursePanel addCourse;
	private ModifyCoursePanel modifyCourse;
	private DeleteCourse deleteCourse;
	private JCardsPanel cards;

	public PanelInfoStudent(Controller controller) {
		setBackground(Color.WHITE);
		cards = new JCardsPanel(controller);
		add(cards);

		schedule = new SchedulePanel();
		cards.add(schedule, "Schedule");

		addCourse = new AddCoursePanel(controller);
		cards.add(addCourse, "AddCourse");

		modifyCourse = new ModifyCoursePanel(controller);
		cards.add(modifyCourse, "ModifyCourse");

		deleteCourse = new DeleteCourse(controller);
		cards.add(deleteCourse, "DeleteCourse");
	}

	public void changeCardStudent(String nameCard) {
		cards.changeCardLayout(nameCard);
	}

	public void setComboBoxCourses(String courses) {
		addCourse.setComboBoxCourses(courses);
	}

	public void resertComboBoxCourses() {
		addCourse.resertComboBoxCourses();
	}

	public String getComboBoxCoursesValue() {
		return addCourse.getComboBoxCoursesValue();
	}

	public void setComboBoxTeachers(String teachers) {
		addCourse.setComboBoxTeachers(teachers);
	}

	public void resetComboBoxTeachers() {
		addCourse.resetComboBoxTeachers();
	}

	public String getComboBoxTeachersValue() {
		return addCourse.getComboBoxTeachersValue();
	}

	public void setInfoSchedule(String infoSchedule) {
		addCourse.setInfoSchedule(infoSchedule);
	}

	public void setVisibleTeachers(boolean isVisible) {
		addCourse.setVisibleTeachers(isVisible);
	}
	

	public void setVisibleSchedule(boolean isVisible) {
		addCourse.setVisibleSchedule(isVisible);
	}

	public void setVisibleHomework(boolean isVisible) {
		modifyCourse.setVisibleHomework(isVisible);
	}

	public void setVisibleModify(boolean isVisible) {
		modifyCourse.setVisibleModify(isVisible);
	}

	public void setComboBoxStudentCourses(String courses) {
		modifyCourse.setComboBoxStudentCourses(courses);		
	}

	public String getComboBoxStudentCourses() {
		return modifyCourse.getComboBoxStudentCourses();
	}

	public void setComboBoxStudentHomework(String homeworks) {
		modifyCourse.setComboBoxStudentHomework(homeworks);		
	}

	public void resetComboBoxStudentHomework() {
		modifyCourse.resetComboBoxStudentHomework();
	}

	public String getComboBoxHomework() {
		return modifyCourse.getComboBoxHomework();
	}

	public void setInfoHomeWork(String[] dataHomework) {
		modifyCourse.setInfoHomeWork(dataHomework);		
	}

	public void setEditableNameHomework(boolean isVisible) {
		modifyCourse.setEditableNameHomework(isVisible);		
	}

	public boolean isNewHomework() {
		return modifyCourse.isNewHomework();
	}

	public String getNameHomework() {
		return modifyCourse.getNameHomework();
	}

	public String getAnotationHomework() {
		return modifyCourse.getAnotationHomework();
	}

	public String getCalificationHomework() {
		return modifyCourse.getCalificationHomework();
	}
	
	public void resetNameHomework() {
		modifyCourse.resetNameHomework();
	}
	
	public void resetAnnotationHomework() {
		modifyCourse.resetAnnotationHomework();
	}
	
	public void resetCalification() {
		modifyCourse.resetCalification();
	}

	public void resetComboModifyHomeCourses() {
		modifyCourse.resetComboModifyHomeCourses();		
	}
}