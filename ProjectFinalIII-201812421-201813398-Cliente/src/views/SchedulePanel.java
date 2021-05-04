package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import controller.Event;

public class SchedulePanel extends JPanel {

	private static final Border BORDER_NORTH_SCHEDULE_PANEL = BorderFactory.createEmptyBorder(0, 0, 0, ConstantsGUI.WIDTH / 81);
	private static final long serialVersionUID = 1L;
	private JPanel[][] matrix;
	private JPanel north, center;

	public SchedulePanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents();
	}

	private void initComponents() {
		initNorth();
		initCenter();
		initMatrix();
		initDays();
		initHours();
		initGrid();
	}

	private void initNorth() {
		north = new JPanel();
		north.setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 1.4), (int) (ConstantsGUI.HEIGHT / 20)));
		north.setLayout(new GridLayout(1, ConstantsGUI.TOTAL_DAYS, 20, 10));
		north.setBorder(BORDER_NORTH_SCHEDULE_PANEL);
		north.setBackground(Color.WHITE);
		add(north);
	}

	private void initCenter() {
		center = new JPanel();
		JScrollPane scroll = new JScrollPane(center);
		scroll.setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 1.4), (int) (ConstantsGUI.HEIGHT / 1.2)));
		center.setLayout(new GridLayout(ConstantsGUI.TOTAL_HOURS, ConstantsGUI.TOTAL_DAYS, 20, 10));
		center.setBackground(Color.WHITE);
		center.setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 2), ConstantsGUI.HEIGHT ));
		add(scroll);
	}

	private void initMatrix() {
		matrix = new JPanel[ConstantsGUI.TOTAL_HOURS][ConstantsGUI.TOTAL_DAYS];
		for (int i = 0; i < ConstantsGUI.TOTAL_HOURS; i++) {
			for (int j = 0; j < ConstantsGUI.TOTAL_DAYS; j++) {
				initMatrix(i, j);
			}
		}
	}

	private void initMatrix(int i, int j) {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 10, ConstantsGUI.HEIGHT / 50));
		panel.setBackground(Color.WHITE);

		JButton day = new JButton(ConstantsGUI.EMPTY_STRING);
		day.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		day.setForeground(Color.WHITE);
		day.setBorder(BorderFactory.createEmptyBorder(0, ConstantsGUI.WIDTH / 100, 0, ConstantsGUI.WIDTH / 100));
		panel.add(day);
		matrix[i][j] = panel;
	}

	private void initDays() {
		for (int i = 0; i < ConstantsGUI.TOTAL_DAYS; i++) {
			JPanel panel = new JPanel();
			panel.setBorder(null);
			panel.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 10, ConstantsGUI.HEIGHT / 20));
			panel.setBackground(Color.WHITE);

			JLabel day = new JLabel();
			day.setFont(new Font("Segoe UI", Font.BOLD, 17));
			day.setForeground(ConstantsGUI.DARK_BLUE);
			day.setText(ConstantsGUI.DAYS[i]);
			if (ConstantsGUI.DAYS[i].equalsIgnoreCase("HORAS")) {
				day.setForeground(ConstantsGUI.DARK_YELLOW);
			}
			day.setBorder(BorderFactory.createEmptyBorder(0, ConstantsGUI.WIDTH / 100, 0, ConstantsGUI.WIDTH / 100));
			panel.add(day);
			north.add(panel);
		}
	}

	private void initHours() {
		int count = 0;
		for (int i = 6; i < 21; i++) {
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 5, ConstantsGUI.DARK_YELLOW));
			panel.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 5, ConstantsGUI.HEIGHT / 20));
			panel.setBackground(Color.WHITE);
			doHoursColumn(i, panel, count);
			count++;
		}
	}

	private void initGrid() {
		center.removeAll();
		for (int i = 0; i < ConstantsGUI.TOTAL_HOURS; i++) {
			for (int j = 0; j < ConstantsGUI.TOTAL_DAYS; j++) {
				center.add(matrix[i][j]);
			}
		}
	}

	private void doHoursColumn(int i, JPanel panel, int count) {
		JLabel day = new JLabel();
		day.setFont(ConstantsGUI.DEFAULT_FONT_MIN_BOLD);
		day.setForeground(ConstantsGUI.DARK_YELLOW);
		day.setText(i + ":00 - " + (i + 1) + ":00");
		day.setAlignmentX(RIGHT_ALIGNMENT);
		panel.add(day);
		matrix[count][0] = panel;
	}

	public void setScheduleInfo(ActionListener actionListener, String courses) {
		if (!courses.equalsIgnoreCase("")) {
			initMatrix();
			initHours();
			String[] vector = courses.split("/////");
			for (int i = 0; i < vector.length; i++) {
				initGridMatrix(actionListener, vector[i], i);
			}
			initGrid();

		}
	}

	private void initGridMatrix(ActionListener actionListener, String vector, int color) {
		String[] courses = vector.split(";");
		for (String course : courses) {
			if (!course.equalsIgnoreCase("")) {
				String[] courseInfo = course.split("&")[2].split("%");
				for (int i = 0; i < courseInfo.length; i++) {
					switch (courseInfo[i].split("#")[0]) {
					case "LUNES":
						setSchedulePanel(actionListener, courseInfo[i], 0, course, color);
						break;
					case "MARTES":
						setSchedulePanel(actionListener, courseInfo[i], 1, course, color);
						break;
					case "MIERCOLES":
						setSchedulePanel(actionListener, courseInfo[i], 2, course, color);
						break;
					case "JUEVES":
						setSchedulePanel(actionListener, courseInfo[i], 3, course, color);
						break;
					case "VIERNES":
						setSchedulePanel(actionListener, courseInfo[i], 4, course, color);
						break;
					case "SABADO":
						setSchedulePanel(actionListener, courseInfo[i], 5, course, color);
						break;
					case "DOMINGO":
						setSchedulePanel(actionListener, courseInfo[i], 6, course, color);
						break;
					default:
						break;
					}
				}
			}
		}
	}

	private void setSchedulePanel(ActionListener actionListener, String schedule, int i, String courseString,
			int color) {
		String name = courseString.split("&")[0];
		int init = Integer.parseInt(schedule.split("#")[1]);
		int end = Integer.parseInt(schedule.split("#")[2]);
		for (int j = 0; j < end - init; j++) {
			matrix[(init + j) - 6][i + 1].removeAll();
			JPanel panel = new JPanel(new BorderLayout());
			ButtonObj btn = new ButtonObj(name, actionListener, Event.ACTION_SCHEDULER_BTN.toString());
			btn.setForeground(Color.WHITE);
			btn.setBorder(null);
			btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
			if (color == 0) {
				panel.setBackground(ConstantsGUI.DARK_BLUE);
				btn.setBackground(ConstantsGUI.DARK_BLUE);
			} else {
				panel.setBackground(ConstantsGUI.DARK_PURPLE);
				btn.setBackground(ConstantsGUI.DARK_PURPLE);
			}
			panel.add(btn, BorderLayout.CENTER);
			matrix[(init + j) - 6][i + 1] = panel;
			matrix[(init + j) - 6][i + 1].repaint();
			matrix[(init + j) - 6][i + 1].revalidate();
		}
	}

	public String getSelectedBtn(ActionEvent e) {
		ButtonObj btn = (ButtonObj) e.getSource();
		return btn.getText();
	}
}