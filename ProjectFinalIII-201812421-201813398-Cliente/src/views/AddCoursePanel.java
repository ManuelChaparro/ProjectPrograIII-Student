package views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

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
		course.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEmptyBorder(Constants.HEIGHT/10, Constants.WIDTH/50,
						Constants.HEIGHT/10, Constants.WIDTH/50),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, 
				Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		course.addActionListener(controller);
		course.setActionCommand(Event.ADD_S_COURSE.toString());
		course.setFont(Constants.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(Constants.WIDTH/2, Constants.HEIGHT/12));

		add(course);
		
		teacher = new JComboBox<String>();
		teacher.setBackground(Color.WHITE);
		teacher.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEmptyBorder(Constants.HEIGHT/10, Constants.WIDTH/50,
						Constants.HEIGHT/10, Constants.WIDTH/50),
				"PROFESOR", TitledBorder.LEFT, TitledBorder.TOP, 
				Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		teacher.addActionListener(controller);
		teacher.setActionCommand(Event.ADD_S_COURSE.toString());
		teacher.setFont(Constants.DEFAULT_FONT_BOLD);
		teacher.setForeground(Color.BLACK);
		teacher.setPreferredSize(new Dimension(Constants.WIDTH/2, Constants.HEIGHT/12));
		add(teacher);
		
		containerSchedule = new JPanel();
		containerSchedule.setBackground(Color.YELLOW);
		containerSchedule.setBorder(BorderFactory.createEmptyBorder(Constants.HEIGHT/20, Constants.WIDTH/20, Constants.HEIGHT/20, Constants.WIDTH/20));
		add(containerSchedule);
	}

	public void setComboBoxCourses(String courses) {
		String repet = "";
		String[] coursesVector = courses.split(";");
		String[] dataCourses = courses.split("&");
		for (int i = 0; i < coursesVector.length; i++) {
			if (!repet.contentEquals(coursesVector[i])) {
				repet+=coursesVector[i];
				course.addItem(coursesVector[i]);
			}	
		}
		
	}
}