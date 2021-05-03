package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelInfoStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel welcome;
	private JPanel welcomePanel, containerWelcome;
	private SchedulePanel schedule;
	private AddCoursePanel addCourse;
	private ModifyCoursePanel modifyCourse;
	private DeleteCourse deleteCourse;
	private ModifyActivityPanel modifyActivity;
	private DeleteActivityPanel deleteActivity;
	private AveragePanel average;
	private JCardsPanel cards;

	public PanelInfoStudent(ActionListener actionListener) {
		setBackground(Color.WHITE);
		cards = new JCardsPanel(actionListener);
		initWelcomePanel();
		initCards(actionListener);
	}

	private void initCards(ActionListener actionListener) {
		schedule = new SchedulePanel();
		cards.add(schedule, ConstantsGUI.SCHEDULE_TEXT_CARDLAYOUT);

		addCourse = new AddCoursePanel(actionListener);
		cards.add(addCourse, ConstantsGUI.ADD_COURSE_TEXT_CARDLAYOUT);

		modifyCourse = new ModifyCoursePanel(actionListener);
		cards.add(modifyCourse, ConstantsGUI.MODIFY_COURSE_TEXT_CARDLAYOUT);

		deleteCourse = new DeleteCourse(actionListener);
		cards.add(deleteCourse, ConstantsGUI.DELETE_COURSE_TEXT_CARDLAYOUT);

		modifyActivity = new ModifyActivityPanel(actionListener);
		cards.add(modifyActivity, ConstantsGUI.MODIFY_ACTIVITY_CARDLAYOUT);

		deleteActivity = new DeleteActivityPanel(actionListener);
		cards.add(deleteActivity, ConstantsGUI.DELETE_ACTIVITY_CARDLAYOUT);

		average = new AveragePanel(actionListener);
		cards.add(average, ConstantsGUI.AVERAGE_TEXT_CARDLAYOUT);

		add(cards);
	}

	private void initWelcomePanel() {
		containerWelcome = new JPanel(new BorderLayout());
		containerWelcome.setBackground(ConstantsGUI.DARK_BLUE);

		welcomePanel = new JPanel(new GridLayout(1, 2));
		welcomePanel.setBackground(ConstantsGUI.DARK_BLUE);
		JLabel img = new JLabel(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_APP_ICON)));
		welcomePanel.add(img);

		welcome = new JLabel(ConstantsGUI.WELCOME_MESSAGE);
		welcome.setFont(ConstantsGUI.DEFAULT_FONT_WELCOME_MESSAGE);
		welcome.setForeground(Color.WHITE);
		welcomePanel.add(welcome);

		containerWelcome.add(welcomePanel, BorderLayout.CENTER);
		cards.add(containerWelcome);
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

	public void setEditableNameHomework(boolean isEditable) {
		modifyCourse.setEditableNameHomework(isEditable);
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

	public void setVisibleConfirmDelete(boolean isVisible) {
		deleteCourse.setVisibleConfirmDelete(isVisible);
		deleteActivity.setVisibleConfirmDelete(isVisible);
	}

	public void setVisibleDeleteCourse(boolean isVisible) {
		deleteCourse.setVisibleDeleteCourse(isVisible);
	}

	public void setVisibleDeleteHomework(boolean isVisible) {
		deleteCourse.setVisibleDeleteHomework(isVisible);
	}

	public void setVisibleModifyActivity(boolean isVisible) {
		modifyActivity.setVisibleModifyActivity(isVisible);
	}

	public void resetModifyPanel() {
		modifyActivity.resetModifyPanel();
	}

	public void setEditableNameActivity(boolean isEditable) {
		modifyActivity.setEditableNameActivity(isEditable);
	}

	public void resetDeleteActivity() {
		deleteActivity.resetDeleteActivity();
	}

	public boolean getSelectedItemsActivity() {
		return deleteActivity.getSelectedItemsActivity();
	}

	public void setEditBtnDeleteAct(boolean isEditable) {
		deleteActivity.setEditBtnDeleteAct(isEditable);
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

	public void setEditBtnDeleteCourse(boolean isEditable) {
		deleteCourse.setEditBtnDeleteCourse(isEditable);
	}

	public void setEditBtnAVG() {
		average.setEditBtnAVG();
	}

	public void resetAvgCourses() {
		average.resetAvgCourses();
	}

	public void setVisibleAVG(boolean isVisible) {
		average.setVisibleAVG(isVisible);
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

	public void removeSpecificCourse(String deleteCourses) {
		deleteCourse.removeSpecificCourse(deleteCourses);
	}

	public boolean getItemsModifyCourses() {
		return modifyCourse.getItemsModifyCourses();
	}

	public void setEditBtnModifyCourse(boolean isEditable) {
		modifyCourse.setEditBtnModifyCourse(isEditable);
	}

	public void removeSpecificHomework(String deleteHomework) {
		deleteCourse.removeSpecificHomework(deleteHomework);
	}

	public boolean getItemsDeleteHomework() {
		return deleteCourse.getItemsDeleteHomework();
	}

	public void setEditBtnDeleteHomework(boolean isEditable) {
		deleteCourse.setEditBtnDeleteHomework(isEditable);
	}

	public void setComboBoxActivities(String activities) {
		modifyActivity.setComboBoxActivities(activities);
		deleteActivity.setComboBoxActivities(activities);
	}

	public String getComboBoxActivity() {
		return modifyActivity.getComboBoxActivity();
	}

	public void setEnableModifyActivity(boolean isEnable) {
		modifyActivity.setEnableModifyActivity(isEnable);
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

	public void setScheduleInfo(ActionListener actionListener, String scheduler) {
		schedule.setScheduleInfo(actionListener, scheduler);
	}

	public String getSelectedBtn(ActionEvent e) {
		return schedule.getSelectedBtn(e);
	}

	public void setNameUser(String name) {
		JLabel nameLabel = new JLabel(name);
		nameLabel.setFont(ConstantsGUI.DEFAULT_FONT_USER_WELCOME);
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBorder(ConstantsGUI.BORDER_NAME_LABEL_USER_WELCOME);
		containerWelcome.add(nameLabel, BorderLayout.SOUTH);
	}
}