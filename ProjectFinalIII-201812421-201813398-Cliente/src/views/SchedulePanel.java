package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SchedulePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GridBagConstraints constraints;

	public SchedulePanel() {
		setLayout(new GridLayout(7, 5));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.13)));
		constraints = new GridBagConstraints();
		initComponents();
	}

	private void initComponents() {
		initGrid();
//		initDays();
//		initHours();
	}

	private void initGrid() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				JPanel panel = new JPanel();
				panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				panel.setPreferredSize(new Dimension(Constants.WIDTH / 10, Constants.HEIGHT / 50));
				panel.setBackground(Constants.DARK_YELLLOW);

				JButton day = new JButton("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				day.setFont(Constants.DEFAULT_FONT_BOLD);
				day.setForeground(Color.WHITE);
				day.setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH / 100, 0, Constants.WIDTH / 100));

				panel.add(day);
				add(panel);

//				constraints.gridx = j;
//				constraints.gridy = i;
//				constraints.gridwidth = 1;
//				constraints.gridheight = 1;
//				add(panel, constraints);
			}
		}
	}

	private void initHours() {
		int initHour = 6;
		for (int i = 1; i < 17; i++) {
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			panel.setPreferredSize(new Dimension(Constants.WIDTH / 5, Constants.HEIGHT / 20));
			panel.setBackground(Constants.DARK_YELLLOW);

			JLabel day = new JLabel();
			day.setFont(Constants.DEFAULT_FONT_BOLD);
			day.setForeground(Color.WHITE);
			day.setText(String.valueOf(initHour));
			day.setAlignmentX(RIGHT_ALIGNMENT);
			initHour++;
//			day.setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH / 100, 0, Constants.WIDTH / 100));

			panel.add(day);

			constraints.gridx = 0;
			constraints.gridy = i;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			add(panel, constraints);
		}
	}

	private void initDays() {
		
		
		for (int i = 1; i < 8; i++) {
			
			JPanel panel = new JPanel();
			panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			panel.setPreferredSize(new Dimension(Constants.WIDTH / 10, Constants.HEIGHT / 20));
			panel.setBackground(Constants.DARK_YELLLOW);

			JButton day = new JButton();
			day.setFont(Constants.DEFAULT_FONT_BOLD);
			day.setForeground(Color.WHITE);
			day.setText(Constants.DAYS[i - 1]);
			day.setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH / 100, 0, Constants.WIDTH / 100));

			panel.add(day);

			constraints.gridx = i;
			constraints.gridy = 0;
			constraints.gridwidth = 1;
			constraints.gridheight = 1;
			add(panel, constraints);
		}
		
		repaint();
	}

}
