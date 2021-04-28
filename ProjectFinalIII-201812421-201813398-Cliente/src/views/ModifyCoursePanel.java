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
	private JTextArea anotation;
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
		containerModify.add(anotation);
		containerModify.add(calification);
		containerModify.add(containerButton);
		add(containerModify);
	}

	private JPanel initCompModify(Controller controller) {
		containerModify = new JPanel(new GridLayout(1, 2, 20, 20));
		containerModify.setBackground(Color.WHITE);	

		anotation = new JTextArea();
		anotation.setLineWrap(true);
		anotation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ANOTACIONES", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		anotation.setFont(Constants.DEFAULT_FONT);
		anotation.setForeground(Color.BLACK);

		SpinnerModel sm = new SpinnerNumberModel(3.0, 0.0, 5.0, 0.1); // default value,lower bound,upper bound,increment by
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
		containerButton.setBorder(BorderFactory.createEmptyBorder(Constants.HEIGHT/6, Constants.WIDTH/15, 100, Constants.WIDTH/15));
		acceptModify = new ButtonObj("Aceptar cambios", controller, Event.MODIFY_HOMEWORK.toString());
		acceptModify.setBackground(Constants.DARK_YELLLOW);
		containerButton.add(acceptModify);
		return containerButton;
	}

	private void addComponentsSearch() {
		JPanel containerBox = new JPanel(new GridLayout(4, 1));
		containerBox.setBackground(Color.WHITE);
		containerBox.add(course);
		containerBox.add(findHomework);
		containerBox.add(homework);
		containerBox.add(infoHomework);
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

		infoHomework = new ButtonObj("Mostrar Info", controller, Event.FIND_INFO_HOMEWORK.toString());
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

		findHomework = new ButtonObj("Buscar Tareas", controller, Event.FIND_HOMEWORK.toString());
	}

	public void setVisibleHomework(boolean b) {
		homework.setVisible(b);
		infoHomework.setVisible(b);
	}

	public void setVisibleModify(boolean b) {
		containerModify.setVisible(b);		
	}
}