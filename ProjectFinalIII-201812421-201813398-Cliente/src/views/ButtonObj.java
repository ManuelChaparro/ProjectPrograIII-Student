package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonObj extends JButton {

	private static final long serialVersionUID = 1L;

	public ButtonObj(String name, ActionListener actionListener, String event) {
		setText(name);
		setFont(Constants.DEFAULT_FONT_ITALIC_MAX);
		setForeground(Color.WHITE);
		setBackground(Constants.DARK_BLUE);
		setFocusable(false);
		setVisible(true);
		addActionListener(actionListener);
		setActionCommand(event);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public ButtonObj(String name, ActionListener actionListener, String event, String pathImg) {
		setText(name);
		setFont(Constants.DEFAULT_FONT_ITALIC_MAX);
		setForeground(Color.WHITE);
		setBackground(Constants.DARK_BLUE);
		setFocusable(false);
		setVisible(true);
		setBorder(null);
		addActionListener(actionListener);
		setActionCommand(event);
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource(pathImg)).getImage()
				.getScaledInstance(Constants.WIDTH / 40, Constants.WIDTH / 40, Image.SCALE_SMOOTH));
		setIcon(img);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}