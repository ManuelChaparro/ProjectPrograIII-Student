package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import controller.Event;

public class SchedulePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel[][] matrix;
	private JPanel north, center;
	private Controller controller;

	public SchedulePanel(Controller controller) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.controller = controller;
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
		north.setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 16)));
		north.setLayout(new GridLayout(1, Constants.TOTAL_DAYS, 20, 10));
		north.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, Constants.WIDTH / 81));
		north.setBackground(Color.WHITE);
		add(north);
	}

	private void initCenter() {
		center = new JPanel();
		JScrollPane scroll = new JScrollPane(center);
		scroll.setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		center.setLayout(new GridLayout(Constants.TOTAL_HOURS, Constants.TOTAL_DAYS, 20, 10));
		center.setBackground(Color.WHITE);
		center.setPreferredSize(new Dimension((int) (Constants.WIDTH / 2), (int) (Constants.HEIGHT * 2)));
		add(scroll);
	}

	private void initMatrix() {
		matrix = new JPanel[Constants.TOTAL_HOURS][Constants.TOTAL_DAYS];
		for (int i = 0; i < Constants.TOTAL_HOURS; i++) {
			for (int j = 0; j < Constants.TOTAL_DAYS; j++) {
				initMatrix(i, j);
			}
		}
	}

	private void initMatrix(int i, int j) {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		panel.setPreferredSize(new Dimension(Constants.WIDTH / 10, Constants.HEIGHT / 50));
		panel.setBackground(Color.WHITE);

		JButton day = new JButton("");
		day.setFont(Constants.DEFAULT_FONT_BOLD);
		day.setForeground(Color.WHITE);
		day.setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH / 100, 0, Constants.WIDTH / 100));
		panel.add(day);
		matrix[i][j] = panel;
	}

	private void initDays() {
		for (int i = 0; i < Constants.TOTAL_DAYS; i++) {
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			panel.setPreferredSize(new Dimension(Constants.WIDTH / 10, Constants.HEIGHT / 20));
			panel.setBackground(Constants.DARK_BLUE);

			JLabel day = new JLabel();
			day.setFont(Constants.DEFAULT_FONT_BOLD);
			day.setForeground(Color.WHITE);
			day.setText(Constants.DAYS[i]);
			if (Constants.DAYS[i].equalsIgnoreCase("HORAS")) {
				panel.setBackground(Constants.DARK_YELLOW);
			}
			day.setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH / 100, 0, Constants.WIDTH / 100));
			panel.add(day);
			north.add(panel);
		}
	}

	private void initHours() {
		int count = 0;
		for (int i = 6; i < 21; i++) {
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			panel.setPreferredSize(new Dimension(Constants.WIDTH / 5, Constants.HEIGHT / 20));
			panel.setBackground(Constants.DARK_YELLOW);
			doHoursColumn(i, panel, count);
			count++;
		}
	}

	private void initGrid() {
		center.removeAll();
		for (int i = 0; i < Constants.TOTAL_HOURS; i++) {
			for (int j = 0; j < Constants.TOTAL_DAYS; j++) {
				center.add(matrix[i][j]);
			}
		}
	}

	private void doHoursColumn(int i, JPanel panel, int count) {
		JLabel day = new JLabel();
		day.setFont(Constants.DEFAULT_FONT_MIN);
		day.setForeground(Color.WHITE);
		day.setText(i + ":00 - " + (i + 1) + ":00");
		day.setAlignmentX(RIGHT_ALIGNMENT);
		panel.add(day);
		matrix[count][0] = panel;
	}

	public void setScheduleInfo(String courses) {
		if (!courses.equalsIgnoreCase("")) {
			initMatrix();
			initHours();
			String[] vector = courses.split("/////");
			for (int i = 0; i < vector.length; i++) {
				initGridMatrix(vector[i], i);
			}
			initGrid();
			
		}
	}

	private void initGridMatrix(String vector, int color) {
		String[] courses = vector.split(";");
		for (String course : courses) {
			String[] courseInfo = course.split("&")[2].split("%");
			for (int i = 0; i < courseInfo.length; i++) {
				switch (courseInfo[i].split("#")[0]) {
				case "LUNES":
					setSchedulePanel(courseInfo[i], 0, course, color);
					break;
				case "MARTES":
					setSchedulePanel(courseInfo[i], 1, course, color);
					break;
				case "MIERCOLES":
					setSchedulePanel(courseInfo[i], 2, course, color);
					break;
				case "JUEVES":
					setSchedulePanel(courseInfo[i], 3, course, color);
					break;
				case "VIERNES":
					setSchedulePanel(courseInfo[i], 4, course, color);
					break;
				case "SABADO":
					setSchedulePanel(courseInfo[i], 5, course, color);
					break;
				case "DOMINGO":
					setSchedulePanel(courseInfo[i], 6, course, color);
					break;
				default:
					break;
				}
			}
		}
	}

	private void setSchedulePanel(String schedule, int i, String courseString, int color) {
		String name = courseString.split("&")[0];
		int init = Integer.parseInt(schedule.split("#")[1]);
		int end = Integer.parseInt(schedule.split("#")[2]);
		for (int j = 0; j < end - init; j++) {
			matrix[(init + j) - 6][i+1].removeAll();
			JPanel panel = new JPanel(new BorderLayout());
			ButtonObj btn = new ButtonObj(name, controller, Event.ACTION_SCHEDULER_BTN.toString());
			btn.setForeground(Color.WHITE);
			btn.setBorder(null);
			btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
			if (color==0) {
				panel.setBackground(Constants.DARK_BLUE);
				btn.setBackground(Constants.DARK_BLUE);
			}else {
				panel.setBackground(Constants.DARK_PURPLE);
				btn.setBackground(Constants.DARK_PURPLE);
			}
			panel.add(btn, BorderLayout.CENTER);
			matrix[(init + j) - 6][i+1] = panel;
			matrix[(init + j) - 6][i+1].repaint();
			matrix[(init + j) - 6][i+1].revalidate();
		}
	}
	
	public String getSelectedBtn(ActionEvent e) {
		ButtonObj btn = (ButtonObj) e.getSource();
		return btn.getText();
	}

	public JPanel createPanelActivity(String namePanel) {
		JLabel name = new JLabel("ACTIVIDAD: " + namePanel.split("&")[0]);
		JLabel anotation = new JLabel("DESCRIPCION: " + namePanel.split("&")[1]);
		JLabel day = new JLabel("DIA: " + namePanel.split("&")[2].split("#")[0]);
		JLabel schedule = new JLabel("HORA: " + namePanel.split("&")[2].split("#")[1] + " - " + namePanel.split("&")[2].split("#")[2]);
		
		JPanel panel = new JPanel(new GridLayout(5, 1));
		
		name.setFont(Constants.DEFAULT_FONT);
		anotation.setFont(Constants.DEFAULT_FONT);
		day.setFont(Constants.DEFAULT_FONT);
		schedule.setFont(Constants.DEFAULT_FONT);
		
		panel.add(name);
		panel.add(anotation);
		panel.add(day);
		panel.add(schedule);
		
		return panel;
	}

	public JPanel createPanelCourse(String namePanel) {
		String[] courseVector = namePanel.split("&");
		
		JPanel panel = new JPanel(new GridLayout(5, 1));
		JLabel name = new JLabel("ACTIVIDAD: " + courseVector[0]);
		JLabel teacher = new JLabel("PROFESOR: " + courseVector[1]);
		JLabel anotation = new JLabel("DESCRIPCION: " + courseVector[2]);
		
		name.setFont(Constants.DEFAULT_FONT);
		teacher.setFont(Constants.DEFAULT_FONT);
		anotation.setFont(Constants.DEFAULT_FONT);
		
		panel.add(name);
		panel.add(teacher);
		panel.add(anotation);
		
		String[] schedules = courseVector[3].split("%");
		for (String schedule : schedules) {
			JLabel day = new JLabel("DIA: " + schedule.split("#")[0] + "  HORA: " + schedule.split("#")[1] + " - " + schedule.split("#")[2].split(";")[0]);
			day.setFont(Constants.DEFAULT_FONT);
			panel.add(day);
		}
		
		return panel;
	}
}