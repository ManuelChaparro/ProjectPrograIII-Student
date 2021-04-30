package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import controller.Controller;
import controller.Event;

public class AveragePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JComboBox<String> course;
	private ButtonObj calculateAVG;
	private JTextArea courseAVG, totalAVG;
	private JPanel containerAVG;

	public AveragePanel(Controller controller) {
		setLayout(new GridLayout(2, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		initSearchHomework(controller);
		addComponentsSearch();
		initDataAVG(controller);
		addComponentsAVG();
	}
	
	private void addComponentsAVG() {
		containerAVG = new JPanel(new GridLayout(1, 2));	
		containerAVG.add(courseAVG);
		containerAVG.add(totalAVG);
		add(containerAVG);
	}

	private void initDataAVG(Controller controller) {
		courseAVG = new JTextArea();
		courseAVG.setLineWrap(true);
		courseAVG.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"PROMEDIO DEL CURSO", TitledBorder.CENTER, TitledBorder.TOP, Constants.DEFAULT_FONT_MAX_BOLD, Constants.DARK_BLUE));
		courseAVG.setFont(Constants.DEFAULT_FONT);
		courseAVG.setForeground(Color.BLACK);
		courseAVG.setEditable(false);
		
		totalAVG = new JTextArea();
		totalAVG.setLineWrap(true);
		totalAVG.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_YELLOW, 1),
				"PROMEDIO TOTAL", TitledBorder.CENTER, TitledBorder.TOP, Constants.DEFAULT_FONT_MAX_BOLD, Constants.DARK_YELLOW));
		totalAVG.setFont(Constants.DEFAULT_FONT);
		totalAVG.setForeground(Color.BLACK);
		totalAVG.setEditable(false);
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

		calculateAVG = new ButtonObj("Calcular promedio", controller, Event.CALCULATE_AVG.toString(), Constants.DARK_BLUE);
	}
	
	private void addComponentsSearch() {
		JPanel containerBox = new JPanel(new GridLayout(4, 1));
		containerBox.setBackground(Color.WHITE);
		containerBox.add(course);
		JPanel containerButtonAVG = new JPanel();
		containerButtonAVG.add(calculateAVG);
		containerButtonAVG.setBackground(Color.WHITE);
		containerBox.add(containerButtonAVG);
		add(containerBox);
	}

	public boolean getSelectedItemsAVG() {
		if (course.getItemAt(0) != null) {
			return true;
		}else {
			return false;
		}
	}

	public void setEditBtnAVG(boolean b) {
		calculateAVG.setEnabled(b);
		course.setVisible(b);
		if (b) {
			calculateAVG.setText("ELIMINAR ASIGNATURA");
		}else {
			calculateAVG.setText("No hay Asignaturas para promediar");
		}
	}

	public void resetAvgCourses() {
		course.removeAllItems();
		courseAVG.setVisible(false);
		totalAVG.setVisible(false);
		containerAVG.setVisible(false);
	}

	public void setVisibleAVG(boolean b) {
		courseAVG.setVisible(b);
		totalAVG.setVisible(b);
		containerAVG.setVisible(b);
	}
}
