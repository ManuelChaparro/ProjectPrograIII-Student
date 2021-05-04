package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.Event;

public class AveragePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> course;
	private ButtonObj calculateAVG;
	private JTextField courseAVG, totalAVG;
	private JPanel containerAVG;

	public AveragePanel(ActionListener actionListener) {
		setLayout(new GridLayout(2, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 1.4), (int) (ConstantsGUI.HEIGHT / 1.2)));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		initSearchComponents(actionListener);
		initAvgComponents();
	}

	private void initSearchComponents(ActionListener actionListener) {
		JPanel containerBox = new JPanel(new GridLayout(4, 1));
		containerBox.setBackground(Color.WHITE);
		createCourseComboBox(actionListener, containerBox);
		createAVGCourseBtn(actionListener, containerBox);
		add(containerBox);
	}

	private void createCourseComboBox(ActionListener actionListener, JPanel containerBox) {
		course = new JComboBox<String>();
		course.addActionListener(actionListener);
		course.setActionCommand(Event.VISIBLE_AVG.toString());
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		course.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(course);
	}

	private void createAVGCourseBtn(ActionListener actionListener, JPanel containerBox) {
		JPanel containerButtonAVG = new JPanel();
		containerButtonAVG.setBackground(Color.WHITE);
		calculateAVG = new ButtonObj("PROMEDIAR ASIGNATURA", actionListener, Event.CALCULATE_AVG.toString(),
				ConstantsGUI.DARK_BLUE);
		containerButtonAVG.add(calculateAVG);
		containerBox.add(containerButtonAVG);
	}

	private void initAvgComponents() {
		containerAVG = new JPanel(new GridLayout(1, 2));
		createSpaceShowAVGCourse();
		createSpaceShowTotalAVG();
		add(containerAVG);
	}

	private void createSpaceShowAVGCourse() {
		courseAVG = new JTextField();
		courseAVG.setHorizontalAlignment(SwingConstants.CENTER);
		courseAVG.setBackground(Color.WHITE);
		courseAVG.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"PROMEDIO DEL CURSO", TitledBorder.CENTER, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MAX_BOLD,
				ConstantsGUI.DARK_BLUE));
		courseAVG.setFont(new Font("Segoe UI", Font.BOLD, 120));
		courseAVG.setForeground(ConstantsGUI.DARK_BLUE);
		courseAVG.setEditable(false);
		containerAVG.add(courseAVG);
	}
	
	private void createSpaceShowTotalAVG() {
		totalAVG = new JTextField();
		totalAVG.setHorizontalAlignment(SwingConstants.CENTER);
		totalAVG.setBackground(Color.WHITE);
		totalAVG.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_YELLOW, 1),
				"PROMEDIO TOTAL", TitledBorder.CENTER, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MAX_BOLD,
				ConstantsGUI.DARK_YELLOW));
		totalAVG.setFont(new Font("Segoe UI", Font.BOLD, 120));
		totalAVG.setForeground(ConstantsGUI.DARK_YELLOW);
		totalAVG.setEditable(false);
		containerAVG.add(totalAVG);
	}

	public boolean getSelectedItemsAVG() {
		if (course.getItemAt(0) == null || course.getItemAt(0).equalsIgnoreCase("")) {
			return false;
		} else {
			return true;
		}
	}

	public void setEditBtnAVG() {
		boolean isEditable = getSelectedItemsAVG();
		calculateAVG.setEnabled(isEditable);
		course.setVisible(isEditable);
		if (isEditable) {
			calculateAVG.setText("PROMEDIAR ASIGNATURA");
		} else {
			calculateAVG.setText("No hay Asignaturas para promediar");
		}
	}

	public void resetAvgCourses() {
		course.removeAllItems();
		courseAVG.setVisible(false);
		totalAVG.setVisible(false);
		containerAVG.setVisible(false);
	}

	public void setVisibleAVG(boolean isVisible) {
		courseAVG.setVisible(isVisible);
		totalAVG.setVisible(isVisible);
		containerAVG.setVisible(isVisible);
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
		} else {
			courseAVG.setText("X");
		}
	}

	public void setAvgTotal(String avgTotal) {
		if (!avgTotal.equalsIgnoreCase("NaN")) {
			totalAVG.setText(avgTotal.substring(0, 3));
		} else {
			totalAVG.setText("X");
		}
	}
}
