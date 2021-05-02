package views;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Controller;
import controller.Event;

public class AveragePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JComboBox<String> course;
	private ButtonObj calculateAVG;
	private JTextField courseAVG, totalAVG;
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
		courseAVG = new JTextField();
		courseAVG.setHorizontalAlignment(SwingConstants.CENTER);
		courseAVG.setBackground(Color.WHITE);
		courseAVG.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"PROMEDIO DEL CURSO", TitledBorder.CENTER, TitledBorder.TOP, Constants.DEFAULT_FONT_MAX_BOLD, Constants.DARK_BLUE));
		courseAVG.setFont(new Font("Segoe UI", Font.BOLD, 120));
		courseAVG.setForeground(Constants.DARK_BLUE);
		courseAVG.setEditable(false);
		
		totalAVG = new JTextField();
		totalAVG.setHorizontalAlignment(SwingConstants.CENTER);
		totalAVG.setBackground(Color.WHITE);
		totalAVG.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_YELLOW, 1),
				"PROMEDIO TOTAL", TitledBorder.CENTER, TitledBorder.TOP, Constants.DEFAULT_FONT_MAX_BOLD, Constants.DARK_YELLOW));
		totalAVG.setFont(new Font("Segoe UI", Font.BOLD, 120));
		totalAVG.setForeground(Constants.DARK_YELLOW);
		totalAVG.setEditable(false);
	}

	private void initSearchHomework(Controller controller) {
		course = new JComboBox<String>();
		course.addActionListener(controller);
		course.setActionCommand(Event.VISIBLE_AVG.toString());
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		course.setFont(Constants.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));

		calculateAVG = new ButtonObj("PROMEDIAR ASIGNATURA", controller, Event.CALCULATE_AVG.toString(), Constants.DARK_BLUE);
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
		if (course.getItemAt(0) == null || course.getItemAt(0).equalsIgnoreCase("")) {
			return false;
		}else {
			return true;
		}
	}

	public void setEditBtnAVG() {
		boolean isEditable = getSelectedItemsAVG();
		calculateAVG.setEnabled(isEditable);
		course.setVisible(isEditable);
		if (isEditable) {
			calculateAVG.setText("PROMEDIAR ASIGNATURA");
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

	public String getSelectedItemCourseAVG() {
		return course.getSelectedItem().toString();
	}

	public void setComboBoxAvgCourses(String courses) {
		String[] coursesVector = courses.split(";");
		for (String course : coursesVector) {
			this.course.addItem(course);
		}
	}

	public void setAvgCourse(String avgCourse) {
		if (!avgCourse.equalsIgnoreCase("NaN")) {
			courseAVG.setText(avgCourse.substring(0, 3));
		}else {
			courseAVG.setText("X");
		}
	}
	public void setAvgTotal(String avgTotal) {
		if (!avgTotal.equalsIgnoreCase("NaN")) {
			totalAVG.setText(avgTotal.substring(0, 3));
		}else {
			totalAVG.setText("X");
		}
	}
}
