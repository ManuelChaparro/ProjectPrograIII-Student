package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import controller.Controller;

public class JCardsPanel extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	
	public JCardsPanel(ActionListener controller) {
		setLayout(new CardLayout());
		setBackground(Color.WHITE);
	}
	
	public void changeCardLayout(String string) {
		CardLayout cardLayout = (CardLayout) getLayout();
		cardLayout.show(this, string);
	}
}