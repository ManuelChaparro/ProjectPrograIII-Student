package views;

import java.awt.Color;
import javax.swing.JButton;
import controller.Controller;

public class ButtonObj extends JButton{

	private static final long serialVersionUID = 1L;

	public ButtonObj(String name, Controller controller, String event) {
		setText(name);
		setFont(Constants.DEFAULT_FONT_ITALIC_MAX);
		setForeground(Color.WHITE);
		setBackground(Constants.DARK_BLUE);
		setFocusable(false);
		setVisible(true);
		setBorder(null);
		addActionListener(controller);
		setActionCommand(event);
	}
}