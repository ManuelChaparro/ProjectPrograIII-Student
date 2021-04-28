package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;

public class JWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private final String TITLE_WINDOW = "Aplicacion Usuario";
	
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

	public void enableAddCourse(boolean b) {
		student.enableAddCourse(b);
	}

	public void setVisibleTeachers(boolean b) {
		student.setVisibleTeachers(b);		
	}

	public void setVisibleSchedule(boolean b) {
		student.setVisibleSchedule(b);
	}

	public void setVisibleHomework(boolean b) {
		student.setVisibleHomework(b);
		
	}

	public void setVisibleModify(boolean b) {
		student.setVisibleModify(b);
	}
	
}
