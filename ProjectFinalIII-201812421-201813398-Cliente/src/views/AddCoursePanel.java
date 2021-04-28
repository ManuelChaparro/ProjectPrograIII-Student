package views;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import controller.Controller;
import controller.Event;

public class AddCoursePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> course, teacher;
	private JPanel containerSchedule, containerInsert;
	private JLabel infoSchedule;
	private ButtonObj findTeachers, showInfoSchedule, insertCourse;

	public AddCoursePanel(Controller controller) {
		setLayout(new GridLayout(2, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		JPanel containerBox = new JPanel(new GridLayout(4, 1));
		containerBox.setBackground(Color.WHITE);
		course = new JComboBox<String>();
		course.addActionListener(controller);
		course.setActionCommand(Event.VISIBLE_TEACHERS.toString());
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		course.setFont(Constants.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));
		
		findTeachers = new ButtonObj("Buscar Profesores", controller, Event.FIND_TEACHERS.toString());
		

		teacher = new JComboBox<String>();
		teacher.setBackground(Color.WHITE);
		teacher.addActionListener(controller);
		teacher.setActionCommand(Event.VISIBLE_SCHEDULE.toString());
		teacher.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"PROFESOR", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		teacher.setFont(Constants.DEFAULT_FONT_BOLD);
		teacher.setForeground(Color.BLACK);
		teacher.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));
		
		showInfoSchedule = new ButtonObj("Mostrar Info", controller, Event.FIND_INFO_ADD_COURSE.toString());
		containerSchedule = new JPanel(new GridBagLayout());
		containerSchedule.setBackground(Color.WHITE);
		containerSchedule.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Constants.DARK_YELLLOW, 2), "DATOS ASIGNATURA", TitledBorder.LEFT,
				TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_YELLLOW));

		containerBox.add(course);
		containerBox.add(findTeachers);
		containerBox.add(teacher);
		containerBox.add(showInfoSchedule);
		
		containerInsert = new JPanel();
		containerInsert.setBorder(BorderFactory.createEmptyBorder(Constants.HEIGHT/15, Constants.WIDTH/10, Constants.HEIGHT/15, Constants.WIDTH/10));
		containerInsert.setBackground(Color.WHITE);

		insertCourse = new ButtonObj("Inscribir curso", controller, Event.INSERT_COURSE.toString());
		insertCourse.setPreferredSize(new Dimension(Constants.WIDTH/5, Constants.HEIGHT/9));
		containerInsert.add(containerSchedule);
		containerInsert.add(insertCourse);

		add(containerBox);
		add(containerInsert);
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
		containerSchedule.removeAll();
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
		containerSchedule.revalidate();
		containerSchedule.repaint();
	}

	public void setVisibleTeachers(boolean b) {
		teacher.setVisible(b);
		showInfoSchedule.setVisible(b);
	}

	public void setVisibleSchedule(boolean b) {
		containerInsert.setVisible(b);
	}
}