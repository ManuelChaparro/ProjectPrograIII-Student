package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Event;

public class AddCoursePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> course, teacher;
	private JPanel containerSchedule, containerInsert;
	private JLabel infoSchedule;
	private ButtonObj findTeachers, showInfoSchedule, insertCourse;

	public AddCoursePanel(ActionListener actionListener) {
		setLayout(new GridLayout(2, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 1.4), (int) (ConstantsGUI.HEIGHT / 1.2)));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createContainerBox(actionListener);
		createContainerInsert(actionListener);
	}

	private void createContainerBox(ActionListener actionListener) {
		JPanel containerBox = new JPanel(new GridLayout(4, 1));
		containerBox.setBackground(Color.WHITE);
		createCoursesComboBox(actionListener, containerBox);
		createBtnFindTeacher(actionListener, containerBox);
		createTeachersComboBox(actionListener, containerBox);
		createBtnShowInforSchedule(actionListener, containerBox);
		add(containerBox);
	}

	private void createCoursesComboBox(ActionListener actionListener, JPanel containerBox) {
		course = new JComboBox<String>();
		course.addActionListener(actionListener);
		course.setActionCommand(Event.VISIBLE_TEACHERS.toString());
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		course.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(course);
	}

	private void createBtnFindTeacher(ActionListener actionListener, JPanel containerBox) {
		JPanel containerButtonFT = new JPanel();
		containerButtonFT.setBackground(Color.WHITE);

		findTeachers = new ButtonObj("Buscar Profesores", actionListener, Event.FIND_TEACHERS.toString(),
				ConstantsGUI.DARK_BLUE);
		containerButtonFT.add(findTeachers);

		containerBox.add(containerButtonFT);
	}

	private void createTeachersComboBox(ActionListener actionListener, JPanel containerBox) {
		teacher = new JComboBox<String>();
		teacher.setBackground(Color.WHITE);
		teacher.addActionListener(actionListener);
		teacher.setActionCommand(Event.VISIBLE_SCHEDULE.toString());
		teacher.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1), "PROFESOR",
						TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		teacher.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		teacher.setForeground(Color.BLACK);
		teacher.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(teacher);
	}

	private void createBtnShowInforSchedule(ActionListener actionListener, JPanel containerBox) {
		JPanel containerButtonS = new JPanel();
		containerButtonS.setBackground(Color.WHITE);

		showInfoSchedule = new ButtonObj("Mostrar Info", actionListener, Event.FIND_INFO_ADD_COURSE.toString(),
				ConstantsGUI.DARK_BLUE);
		containerSchedule = new JPanel(new GridBagLayout());
		containerSchedule.setBackground(Color.WHITE);
		containerSchedule.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(ConstantsGUI.DARK_YELLOW, 2), "DATOS ASIGNATURA", TitledBorder.LEFT,
				TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_YELLOW));
		containerButtonS.add(showInfoSchedule);

		containerBox.add(containerButtonS);
	}

	private void createContainerInsert(ActionListener actionListener) {
		containerInsert = new JPanel();
		containerInsert.setBorder(BorderFactory.createEmptyBorder(ConstantsGUI.HEIGHT / 15, ConstantsGUI.WIDTH / 10,
				ConstantsGUI.HEIGHT / 15, ConstantsGUI.WIDTH / 10));
		containerInsert.setBackground(Color.WHITE);

		insertCourse = new ButtonObj("Inscribir curso", actionListener, Event.INSERT_COURSE.toString(),
				ConstantsGUI.DARK_BLUE);
		insertCourse.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 5, ConstantsGUI.HEIGHT / 9));
		containerInsert.add(containerSchedule);
		containerInsert.add(insertCourse);

		add(containerInsert);
	}

	public void setComboBoxCourses(String courses) {
		String[] coursesVector = courses.split(";");
		for (int i = 0; i < coursesVector.length; i++) {
			course.addItem(coursesVector[i]);
		}
	}

	public void resertComboBoxCourses() {
		course.removeAllItems();
	}

	public String getComboBoxCoursesValue() {
		return course.getSelectedItem().toString();
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
			infoSchedule.setFont(ConstantsGUI.DEFAULT_FONT);
			infoSchedule.setForeground(Color.BLACK);
			infoSchedule.setText(
					"DIA: " + dataSchedule[0] + ". HORA INICIO: " + dataSchedule[1] + ". HORA FIN: " + dataSchedule[2]);
			GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, i, 1, 1);
			containerSchedule.add(infoSchedule, constraints);
		}
		containerSchedule.revalidate();
		containerSchedule.repaint();
	}

	public void setVisibleTeachers(boolean isVisible) {
		teacher.setVisible(isVisible);
		showInfoSchedule.setVisible(isVisible);
	}

	public void setVisibleSchedule(boolean isVisible) {
		containerInsert.setVisible(isVisible);
	}
}