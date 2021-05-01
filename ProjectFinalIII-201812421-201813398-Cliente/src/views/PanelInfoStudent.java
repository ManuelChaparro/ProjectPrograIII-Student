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
	private ModifyActivityPanel modifyActivity;
	private DeleteActivityPanel deleteActivity;
	private AveragePanel average;
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

		modifyActivity = new ModifyActivityPanel(controller);
		cards.add(modifyActivity, "ModifyActivity");

		deleteActivity = new DeleteActivityPanel(controller);
		cards.add(deleteActivity, "DeleteActivity");

		average = new AveragePanel(controller);
		cards.add(average, "Average");

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
		deleteCourse.setVisibleHomework(isVisible);
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

	public void resetComboDeleteHomeCourses() {
		deleteCourse.resetComboDeleteHomeCourses();
	}

	public void setVisibleConfirmDelete(boolean b) {
		deleteCourse.setVisibleConfirmDelete(b);
		deleteActivity.setVisibleConfirmDelete(b);
	}

	public void setVisibleDeleteCourse(boolean b) {
		deleteCourse.setVisibleDeleteCourse(b);
	}

	public void setVisibleDeleteHomework(boolean b) {
		deleteCourse.setVisibleDeleteHomework(b);
	}

	public void setVisibleModifyActivity(boolean b) {
		modifyActivity.setVisibleModifyActivity(b);
	}

	public void resetModifyPanel() {
		modifyActivity.resetModifyPanel();
	}

	public void setEditableNameActivity(boolean b) {
		modifyActivity.setEditableNameActivity(b);
	}

	public void resetDeleteActivity() {
		deleteActivity.resetDeleteActivity();
	}

	public boolean getSelectedItemsActivity() {
		return deleteActivity.getSelectedItemsActivity();
	}

	public void setEditBtnDeleteAct(boolean b) {
		deleteActivity.setEditBtnDeleteAct(b);
	}

	public String getDeleteActString() {
		return deleteActivity.getDeleteActString();
	}

	public String getModActString() {
		return modifyActivity.getModActString();
			}

	public String getDeleteHomework() {
		return deleteCourse.getDeleteHomework();
	}

	public String getDeleteCourse() {
		return deleteCourse.getDeleteCourse();
	}

	public boolean getSelectedItemsCourse() {
		return deleteCourse.getSelectedItemsCourse();
	}

	public void setEditBtnDeleteCourse(boolean b) {
		deleteCourse.setEditBtnDeleteCourse(b);
	}

	public boolean getSelectedItemsAVG() {
		return average.getSelectedItemsAVG();
	}

	public void setEditBtnAVG(boolean b) {
		average.setEditBtnAVG(b);
	}

	public void resetAvgCourses() {
		average.resetAvgCourses();
	}

	public void setVisibleAVG(boolean b) {
		average.setVisibleAVG(b);
	}

	
	public void setComboBoxDeleteCourses(String[] split) {
		deleteCourse.setComboBoxDeleteCourses(split);
	}

	public void setComboBoxDeleteHomeworks(String[] homeworks) {
		deleteCourse.setComboBoxDeleteHomeworks(homeworks);
	}

	public void resetFindHomework() {
		deleteCourse.resetFindHomework();
	}

	public void resetComboDeleteCourses() {
		deleteCourse.resetComboDeleteCourses();		
	}

	public void removeSpecificCourse(String deleteCourse2) {
		deleteCourse.removeSpecificCourse(deleteCourse2);
	}

	public boolean getItemsModifyCourses() {
		return modifyCourse.getItemsModifyCourses();
	}

	public void setEditBtnModifyCourse(boolean b) {
		modifyCourse.setEditBtnModifyCourse(b);
	}

	public void removeSpecificHomework(String deleteHomework) {
		deleteCourse.removeSpecificHomework(deleteHomework);
	}

	public boolean getItemsDeleteHomework() {
		return deleteCourse.getItemsDeleteHomework();
	}

	public void setEditBtnDeleteHomework(boolean b) {
		deleteCourse.setEditBtnDeleteHomework(b);
	}

	public void setComboBoxActivities(String activities) {
		modifyActivity.setComboBoxActivities(activities);
		deleteActivity.setComboBoxActivities(activities);
	}

	public String getComboBoxActivity() {
		return modifyActivity.getComboBoxActivity();
	}

	public void setEnableModifyActivity(boolean b) {
		modifyActivity.setEnableModifyActivity(b);
	}

	public boolean getEnableModifyActivity() {
		return modifyActivity.getEnableModifyActivity();
	}

	public void setComboBoxActivity(String infoActivity) {
		modifyActivity.setComboBoxActivity(infoActivity);
	}

	public String getSelectedItemCourseAVG() {
		return average.getSelectedItemCourseAVG();
	}

	public void setComboBoxAvgCourses(String courses) {
		average.setComboBoxAvgCourses(courses);
	}

	public void setAvgCourse(String avgCourse) {
		average.setAvgCourse(avgCourse);
	}

	public void setAvgTotal(String avgTotal) {
		average.setAvgTotal(avgTotal);
	}
}