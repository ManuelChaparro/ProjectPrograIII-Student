package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.Controller;

public class JWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private final String TITLE_WINDOW = "Aplicacion Usuario";
	
	private JCardsPanel cards;
	private LoginPanel login;
	private InterfaceStudent student;
	
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
		
		student = new InterfaceStudent(controller);
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

	public boolean isLogin() {
		return login.isLogin();
	}
}
