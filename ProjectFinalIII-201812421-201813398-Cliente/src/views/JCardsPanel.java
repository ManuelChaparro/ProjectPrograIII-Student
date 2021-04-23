package views;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class JCardsPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public JCardsPanel() {
		setLayout(new CardLayout());
		setBackground(Color.WHITE);
	}
	
	public void changeCardLayout(String string) {
		CardLayout cardLayout = (CardLayout) getLayout();
		cardLayout.show(this, string);
	}
}