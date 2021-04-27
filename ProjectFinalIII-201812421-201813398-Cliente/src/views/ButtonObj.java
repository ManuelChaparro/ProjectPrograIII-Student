package views;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonObj extends JButton{

	private static final long serialVersionUID = 1L;

	public ButtonObj(String name, ActionListener actionListener, String event) {
		setText(name);
		setFont(Constants.DEFAULT_FONT_ITALIC_MAX);
		setForeground(Color.WHITE);
		setBackground(Constants.DARK_BLUE);
		setFocusable(false);
		setVisible(true);
		setBorder(null);
		addActionListener(actionListener);
		setActionCommand(event);
	}
}