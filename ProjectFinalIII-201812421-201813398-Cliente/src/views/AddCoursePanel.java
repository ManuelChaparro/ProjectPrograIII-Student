package views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Controller;
import controller.Event;
import models.Course;

public class AddCoursePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> course, teacher;
	private JPanel containerSchedule;
	private JLabel infoSchedule;

	public AddCoursePanel(Controller controller) {
		setLayout(new GridLayout(2, 1, 50, 50));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		JPanel containerBox = new JPanel(new GridLayout(2, 1));
		containerBox.setBackground(Color.WHITE);
		containerBox.setBorder(BorderFactory.createEmptyBorder(Constants.HEIGHT / 10, 0, Constants.HEIGHT / 10, 0));
		course = new JComboBox<String>();
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		course.addActionListener(controller);
		course.setActionCommand(Event.ADD_COMBOBOX_COURSE.toString());
		course.setFont(Constants.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));

		teacher = new JComboBox<String>();
		teacher.setBackground(Color.WHITE);
		teacher.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"PROFESOR", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		teacher.addActionListener(controller);
		teacher.setActionCommand(Event.ADD_COMBOBOX_TEACHER.toString());
		teacher.setFont(Constants.DEFAULT_FONT_BOLD);
		teacher.setForeground(Color.BLACK);
		teacher.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));

		containerBox.add(course);
		containerBox.add(teacher);

		add(containerBox);

		containerSchedule = new JPanel(new GridBagLayout());
		containerSchedule.setBackground(Color.WHITE);
		containerSchedule.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Constants.DARK_YELLLOW, 2), "DATOS ASIGNATURA", TitledBorder.LEFT,
				TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_YELLLOW));
		add(containerSchedule);
	}

	public void setComboBoxCourses(String courses) {
		String[] coursesVector = courses.split(";");
		for (int i = 0; i < coursesVector.length; i++) {
			System.out.println(coursesVector[i]);
			course.addItem(coursesVector[i]);
		}
	}

	public void resertComboBoxCourses() {
		course.removeAllItems();
	}

	public String getComboBoxCoursesValue() {
		if (course.getSelectedItem()!=null) {
			return course.getSelectedItem().toString();
		}else {
			return "";
		}
	}

	public void setComboBoxTeachers(String teachers) {
		String[] teachersVector = teachers.split(";");
		for (int i = 0; i < teachersVector.length; i++) {
			teacher.addItem(teachersVector[i]);
		}
	}

	public void resetComboBoxTeachers() {
		teacher.removeAllItems();
	}

	public String getComboBoxTeachersValue() {
		return teacher.getSelectedItem().toString();
	}

	public void setInfoSchedule(String schedule) {
		GridBagConstraints constraints = new GridBagConstraints();
		String[] schedules = schedule.split("%");
		for (int i = 0; i < schedules.length; i++) {
			String[] dataSchedule = schedules[i].split("#");
			infoSchedule = new JLabel();
			infoSchedule.setFont(Constants.DEFAULT_FONT);
			infoSchedule.setForeground(Color.BLACK);
			infoSchedule.setText(
					"DIA: " + dataSchedule[0] + ". HORA INICIO: " + dataSchedule[1] + ". HORA FIN: " + dataSchedule[2]);
			GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, i, 1, 1);
			containerSchedule.add(infoSchedule, constraints);
		}
	}
}