package views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import controller.Controller;
import controller.Event;
import models.Course;

public class AddCoursePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JComboBox<String> course, teacher;
	private JPanel containerSchedule;
	
	public AddCoursePanel(Controller controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.CYAN);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		course = new JComboBox<String>();
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createEmptyBorder(Constants.HEIGHT/10, Constants.WIDTH/50, Constants.HEIGHT/10, Constants.WIDTH/50));
		course.addActionListener(controller);
		course.setActionCommand(Event.ADD_S_COURSE.toString());
		course.setFont(Constants.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(Constants.WIDTH/2, Constants.HEIGHT/12));
		
		course.addItem("Progra");
		course.addItem("Calculo");
		course.addItem("Ingles");
		course.addItem("TGS");
		add(course);
		
		teacher = new JComboBox<String>();
		teacher.setBackground(Color.WHITE);
		teacher.setBorder(BorderFactory.createEmptyBorder(Constants.HEIGHT/10, Constants.WIDTH/50, Constants.HEIGHT/10, Constants.WIDTH/50));
		teacher.addActionListener(controller);
		teacher.setActionCommand(Event.ADD_S_COURSE.toString());
		teacher.setFont(Constants.DEFAULT_FONT_BOLD);
		teacher.setForeground(Color.BLACK);
		teacher.setPreferredSize(new Dimension(Constants.WIDTH/2, Constants.HEIGHT/12));
		
		teacher.addItem("Omaewa <333");
		teacher.addItem("Hoyitos");
		teacher.addItem("El perro hp del alexander");
		teacher.addItem("valero");
		add(teacher);
		
		containerSchedule = new JPanel();
		containerSchedule.setBackground(Color.YELLOW);
		containerSchedule.setBorder(BorderFactory.createEmptyBorder(Constants.HEIGHT/20, Constants.WIDTH/20, Constants.HEIGHT/20, Constants.WIDTH/20));
		add(containerSchedule);
	}
}