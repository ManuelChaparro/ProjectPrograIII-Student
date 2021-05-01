package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import controller.Controller;
import controller.Event;

public class ModifyCoursePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel containerModify;
	private JComboBox<String> course, homework;
	private ButtonObj findHomework, infoHomework, acceptModify;
	private JTextArea annotation, name;
	private JSpinner calification;

	public ModifyCoursePanel(Controller controller) {
		setLayout(new GridLayout(2, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		initSearchHomework(controller);
		initGetInfoHomework(controller);
		addComponentsSearch();
		JPanel containerButton = initCompModify(controller);
		addComponensThis(containerButton);
	}

	private void addComponensThis(JPanel containerButton) {
		containerModify.add(name);
		containerModify.add(annotation);
		containerModify.add(calification);
		containerModify.add(containerButton);
		add(containerModify);
	}

	private JPanel initCompModify(Controller controller) {
		containerModify = new JPanel(new GridLayout(2, 2, 20, 20));
		containerModify.setBackground(Color.WHITE);

		name = new JTextArea();
		name.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1), "TAREA",
				TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		name.setFont(Constants.DEFAULT_FONT_ITALIC_MAX);
		name.setForeground(Constants.DARK_BLUE);
		name.setBackground(Color.WHITE);
		name.setLineWrap(true);

		annotation = new JTextArea();
		annotation.setLineWrap(true);
		annotation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ANOTACIONES", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		annotation.setFont(Constants.DEFAULT_FONT);
		annotation.setForeground(Color.BLACK);

		SpinnerModel sm = new SpinnerNumberModel(0.0, 0.0, 5.0, 0.1); 
		calification = new JSpinner(sm);
		calification.setBackground(Color.WHITE);
		((DefaultEditor) calification.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) calification.getEditor()).getTextField().setBackground(Color.WHITE);
		calification.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"CALIFICACION", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		calification.setFont(new Font("Segoe UI", Font.BOLD, 120));
		calification.setForeground(Color.GRAY);

		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);
		containerButton.setBorder(
				BorderFactory.createEmptyBorder(Constants.HEIGHT / 20, Constants.WIDTH / 20, 0, Constants.WIDTH / 20));
		acceptModify = new ButtonObj("Aceptar", controller, Event.ADD_OR_MODIFY_HOMEWORK.toString(), Constants.DARK_YELLOW);
		containerButton.add(acceptModify);
		return containerButton;
	}

	private void addComponentsSearch() {
		JPanel containerBox = new JPanel(new GridLayout(4, 1));
		containerBox.setBackground(Color.WHITE);
		containerBox.add(course);
		JPanel containerButtonFH = new JPanel();
		containerButtonFH.add(findHomework);
		containerButtonFH.setBackground(Color.WHITE);
		containerBox.add(containerButtonFH);
		containerBox.add(homework);
		JPanel containerButtonIH = new JPanel();
		containerButtonIH.add(infoHomework);
		containerButtonIH.setBackground(Color.WHITE);
		containerBox.add(containerButtonIH);
		add(containerBox);
	}

	private void initGetInfoHomework(Controller controller) {
		homework = new JComboBox<String>();
		homework.setBackground(Color.WHITE);
		homework.addActionListener(controller);
		homework.setActionCommand(Event.VISIBLE_MODIFY.toString());
		homework.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"TAREA", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		homework.setFont(Constants.DEFAULT_FONT_BOLD);
		homework.setForeground(Color.BLACK);
		homework.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));

		infoHomework = new ButtonObj("Confirmar", controller, Event.FIND_INFO_HOMEWORK.toString(), Constants.DARK_BLUE);
	}

	private void initSearchHomework(Controller controller) {
		course = new JComboBox<String>();
		course.addActionListener(controller);
		course.setActionCommand(Event.VISIBLE_HOMEWORK.toString());
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		course.setFont(Constants.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));

		findHomework = new ButtonObj("Buscar Tareas", controller, Event.FIND_HOMEWORK.toString(), Constants.DARK_BLUE);
	}

	public void setVisibleHomework(boolean isVisible) {
		homework.setVisible(isVisible);
		infoHomework.setVisible(isVisible);
	}

	public void setVisibleModify(boolean isVisible) {
		containerModify.setVisible(isVisible);
	}

	public void setComboBoxStudentCourses(String courses) {
		String[] coursesVector = courses.split(";");
		for (int i = 0; i < coursesVector.length; i++) {
			course.addItem(coursesVector[i]);
		}
	}

	public String getComboBoxStudentCourses() {
		return course.getSelectedItem().toString();
	}

	public void setComboBoxStudentHomework(String homeworks) {
		String[] coursesVector = homeworks.split(";");
		for (int i = 0; i < coursesVector.length; i++) {
			if (!coursesVector[i].equalsIgnoreCase("")) {
				homework.addItem(coursesVector[i]);
			}
		}
	}

	public void resetComboBoxStudentHomework() {
		homework.removeAllItems();
		homework.addItem("ANADIR TAREA");
	}

	public String getComboBoxHomework() {
		return homework.getSelectedItem().toString();
	}

	public void setInfoHomeWork(String[] dataHomework) {
		name.setText(dataHomework[0]);
		annotation.setText(dataHomework[1]);
		calification.setValue(Double.parseDouble(dataHomework[2]));
	}

	public void setEditableNameHomework(boolean isEditable) {
		name.setEditable(isEditable);
	}

	public boolean isNewHomework() {
		return name.isEditable();
	}

	public String getNameHomework() {
		return name.getText();
	}

	public String getAnotationHomework() {
		return annotation.getText();
	}

	public String getCalificationHomework() {
		return calification.getValue().toString();
	}

	public void resetNameHomework() {
		name.setText("");
	}

	public void resetAnnotationHomework() {
		annotation.setText("");
	}

	public void resetCalification() {
		calification.setValue(0);
	}

	public void resetComboModifyHomeCourses() {
		course.removeAllItems();
	}

	public boolean getItemsModifyCourses() {
		for (int i = 0; i < course.getItemCount(); i++) {
			if (course.getItemAt(i).equalsIgnoreCase("")) {
				course.removeItemAt(i);
			}
		}
		
		if (course.getItemCount()!=0) {
			return true;
		}else {
			return false;
		}
	}

	public void setEditBtnModifyCourse(boolean b) {
		findHomework.setEnabled(b);
		course.setVisible(b);
		if (b) {
			findHomework.setText("Buscar Tareas");
		}else {
			findHomework.setText("No hay Asignaturas por modificar");
		}
	}
	
}