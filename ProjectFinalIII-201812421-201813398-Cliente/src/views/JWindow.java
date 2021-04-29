package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;
import controller.Event;

public class JWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private final String TITLE_WINDOW = "Xorder-Usuario";
	
	private JCardsPanel cards;
	private LoginPanel login;
	private StudentInterface student;
	
	public JWindow(Controller controller) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITLE_WINDOW);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource(Constants.PATH_APP_ICON)).getImage());
		setVisible(true);
		initWindow(controller);
	}

	private void initWindow(Controller controller) {
		cards = new JCardsPanel(controller);
		add(cards);
		
		login = new LoginPanel(controller);
		cards.add(login, "Login");
		
		student = new StudentInterface(controller);
		cards.add(student, "Student");
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
}