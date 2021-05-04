package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import controller.Event;

public class ModifyCoursePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel containerModify;
	private JComboBox<String> course, homework;
	private ButtonObj findHomework, infoHomework, acceptModify;
	private JTextArea annotation, name;
	private JSpinner calification;

	public ModifyCoursePanel(ActionListener actionListener) {
		setLayout(new GridLayout(2, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 1.4), (int) (ConstantsGUI.HEIGHT / 1.2)));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		initComponentsSearch(actionListener);
		initComponentsModify(actionListener);
	}

	private void initComponentsSearch(ActionListener actionListener) {
		JPanel containerBox = new JPanel(new GridLayout(4, 1));
		containerBox.setBackground(Color.WHITE);
		initSearchHomework(containerBox, actionListener);

		JPanel containerButtonFH = new JPanel();
		containerButtonFH.setBackground(Color.WHITE);
		findHomework = new ButtonObj("Buscar Tareas", actionListener, Event.FIND_HOMEWORK.toString(),
				ConstantsGUI.DARK_BLUE);
		containerButtonFH.add(findHomework);
		containerBox.add(containerButtonFH);

		initGetInfoHomework(containerBox, actionListener);

		JPanel containerButtonIH = new JPanel();
		containerButtonIH.setBackground(Color.WHITE);
		infoHomework = new ButtonObj("Confirmar", actionListener, Event.FIND_INFO_HOMEWORK.toString(),
				ConstantsGUI.DARK_BLUE);
		containerButtonIH.add(infoHomework);
		containerBox.add(containerButtonIH);

		add(containerBox);
	}

	private void initSearchHomework(JPanel containerBox, ActionListener actionListener) {
		course = new JComboBox<String>();
		course.addActionListener(actionListener);
		course.setActionCommand(Event.VISIBLE_HOMEWORK.toString());
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		course.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(course);
	}

	private void initGetInfoHomework(JPanel containerBox, ActionListener actionListener) {
		homework = new JComboBox<String>();
		homework.setBackground(Color.WHITE);
		homework.addActionListener(actionListener);
		homework.setActionCommand(Event.VISIBLE_MODIFY.toString());
		homework.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"TAREA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		homework.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		homework.setForeground(Color.BLACK);
		homework.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(homework);
	}

	private void initComponentsModify(ActionListener actionListener) {
		containerModify = new JPanel(new GridLayout(2, 2, 20, 20));
		containerModify.setBackground(Color.WHITE);
		createNameTextField();
		createAnnotationTextField();
		createCalificationSpinner();
		createConfirmModifyBtn(actionListener);
		add(containerModify);
	}

	private void createNameTextField() {
		name = new JTextArea();
		name.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"TAREA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		name.setFont(ConstantsGUI.DEFAULT_FONT_ITALIC_MAX);
		name.setForeground(ConstantsGUI.DARK_BLUE);
		name.setBackground(Color.WHITE);
		name.setLineWrap(true);
		containerModify.add(name);
	}

	private void createAnnotationTextField() {
		annotation = new JTextArea();
		annotation.setLineWrap(true);
		annotation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"ANOTACIONES", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		annotation.setFont(ConstantsGUI.DEFAULT_FONT);
		annotation.setForeground(Color.BLACK);
		containerModify.add(annotation);
	}

	private void createCalificationSpinner() {
		SpinnerModel sm = new SpinnerNumberModel(0.0, 0.0, 5.0, 0.1);
		calification = new JSpinner(sm);
		calification.setBackground(Color.WHITE);
		((DefaultEditor) calification.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) calification.getEditor()).getTextField().setBackground(Color.WHITE);
		calification.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1), "CALIFICACION", TitledBorder.LEFT,
				TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		calification.setFont(new Font("Segoe UI", Font.BOLD, 120));
		calification.setForeground(Color.GRAY);
		containerModify.add(calification);
	}

	private void createConfirmModifyBtn(ActionListener actionListener) {
		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);
		containerButton.setBorder(BorderFactory.createEmptyBorder(ConstantsGUI.HEIGHT / 20, ConstantsGUI.WIDTH / 20, 0,
				ConstantsGUI.WIDTH / 20));
		acceptModify = new ButtonObj("Aceptar", actionListener, Event.ADD_OR_MODIFY_HOMEWORK.toString(),
				ConstantsGUI.DARK_YELLOW);
		containerButton.add(acceptModify);
		containerModify.add(containerButton);
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
		homework.addItem("AGREGAR TAREA");
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

		if (course.getItemCount() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setEditBtnModifyCourse(boolean b) {
		findHomework.setEnabled(b);
		course.setVisible(b);
		if (b) {
			findHomework.setText("Buscar Tareas");
		} else {
			findHomework.setText("No hay Asignaturas por modificar");
		}
	}

}