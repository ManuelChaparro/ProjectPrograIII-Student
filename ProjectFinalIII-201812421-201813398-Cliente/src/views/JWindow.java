package views;

import java.awt.Dimension;
import java.awt.Menu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String TITLE_WINDOW = "Aplicacion Usuario";
	
	private JCardsPanel cards;
	private LoginPanel login;
	private MenuPanel menu;
	
	public JWindow() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(TITLE_WINDOW);
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(new ImageIcon(getClass().getResource(Constants.APP_ICON)).getImage());
		setVisible(true);
		setResizable(false);
		setMinimumSize(new Dimension(Constants.WIDTH/2, Constants.HEIGHT/2));
		initWindow();
	}

	private void initWindow() {
		cards = new JCardsPanel();
		add(cards);
		
		login = new LoginPanel();
		cards.add(login, "Login");
		
		menu = new MenuPanel();
		cards.add(menu, "Menu");
	}
	
	public void changeCard(String nameCard) {
		cards.changeCardLayout(nameCard);
	}
}
