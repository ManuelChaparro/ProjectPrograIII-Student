package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import controller.Controller;

public class ButtonObj extends JButton implements MouseListener {

	/**
	 * 
	 */
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

	@Override
	public void mouseClicked(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
}
