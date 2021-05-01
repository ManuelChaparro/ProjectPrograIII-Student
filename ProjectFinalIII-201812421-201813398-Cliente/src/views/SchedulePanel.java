package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SchedulePanel extends JPanel {

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
		for (int i = 0; i < Constants.TOTAL_HOURS; i++) {
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			panel.setPreferredSize(new Dimension(Constants.WIDTH / 5, Constants.HEIGHT / 20));
			panel.setBackground(Constants.DARK_YELLOW);
			doHoursColumn(i, panel);
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

	private void doHoursColumn(int i, JPanel panel) {
		JLabel day = new JLabel();
		day.setFont(Constants.DEFAULT_FONT_MIN);
		day.setForeground(Color.WHITE);
		if (i + 1 != 24) {
			day.setText(i + ":00 - " + (i + 1) + ":00");
		} else {
			day.setText(i + ":00 - " + 0 + ":00");
		}
		day.setAlignmentX(RIGHT_ALIGNMENT);
		panel.add(day);
		matrix[i][0] = panel;
	}
}