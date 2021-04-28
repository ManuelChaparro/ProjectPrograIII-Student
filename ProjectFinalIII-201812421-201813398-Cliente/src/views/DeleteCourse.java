package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import controller.Controller;

public class DeleteCourse extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public DeleteCourse(Controller controller) {
		setLayout(new GridLayout(2, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		// TODO Auto-generated method stub
		
	}
}
