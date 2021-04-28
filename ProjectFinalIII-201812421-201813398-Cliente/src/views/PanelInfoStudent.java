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

	public void setVisibleTeachers(boolean b) {
		addCourse.setVisibleTeachers(b);
	}
	

	public void setVisibleSchedule(boolean b) {
		addCourse.setVisibleSchedule(b);
	}

	public void setVisibleHomework(boolean b) {
		modifyCourse.setVisibleHomework(b);
	}

	public void setVisibleModify(boolean b) {
		modifyCourse.setVisibleModify(b);
	}
}