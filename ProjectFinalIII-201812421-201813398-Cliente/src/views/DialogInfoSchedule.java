package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class DialogInfoSchedule extends JDialog {

	private static final long serialVersionUID = 1L;

	public DialogInfoSchedule() {
		setMinimumSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 2));
		setLayout(new BorderLayout());
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public void setInfoActivity(String namePanel) {
		GridBagConstraints gb = new GridBagConstraints();
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.WHITE);

		JTextArea name = new JTextArea();
		name.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE), "ACTIVIDAD",
						TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		name.setText(namePanel.split("&")[0]);
		name.setFont(ConstantsGUI.DEFAULT_FONT);
		name.setBackground(Color.WHITE);
		name.setForeground(Color.BLACK);
		name.setEditable(false);
		name.setFont(ConstantsGUI.DEFAULT_FONT);
		GridBagConstrainsForm.gridBagConstrainsForm(gb, 0, 0, 2, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		panel.add(name, gb);

		JTextArea anotation = new JTextArea();
		anotation.setText(namePanel.split("&")[1]);
		anotation.setFont(ConstantsGUI.DEFAULT_FONT);
		anotation.setBackground(Color.WHITE);
		anotation.setForeground(Color.BLACK);
		anotation.setEditable(false);
		anotation.setLineWrap(true);
		anotation.setFont(ConstantsGUI.DEFAULT_FONT);

		JScrollPane scrollAnotation = new JScrollPane(anotation);
		scrollAnotation.setBackground(Color.WHITE);
		scrollAnotation.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE), "DESCRIPCION",
						TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		GridBagConstrainsForm.gridBagConstrainsForm(gb, 0, 1, 2, 2, 1, 2, GridBagConstraints.BOTH);
		panel.add(scrollAnotation, gb);

		JTextArea day = new JTextArea();
		day.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE), "DIA",
				TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		day.setText(namePanel.split("&")[2].split("#")[0]);
		day.setFont(ConstantsGUI.DEFAULT_FONT);
		day.setBackground(Color.WHITE);
		day.setForeground(Color.BLACK);
		day.setEditable(false);
		day.setFont(ConstantsGUI.DEFAULT_FONT);
		GridBagConstrainsForm.gridBagConstrainsForm(gb, 0, 3, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		panel.add(day, gb);

		JTextArea schedule = new JTextArea();
		schedule.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE),
				"HORA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		schedule.setText(namePanel.split("&")[2].split("#")[1] + " - " + namePanel.split("&")[2].split("#")[2]);
		schedule.setFont(ConstantsGUI.DEFAULT_FONT);
		schedule.setBackground(Color.WHITE);
		schedule.setForeground(Color.BLACK);
		schedule.setEditable(false);
		schedule.setFont(ConstantsGUI.DEFAULT_FONT);
		GridBagConstrainsForm.gridBagConstrainsForm(gb, 1, 3, 1, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		panel.add(schedule, gb);

		add(panel);
	}

	public void setInfoCourse(String namePanel) {
		String[] courseVector = namePanel.split("&");

		GridBagConstraints gb = new GridBagConstraints();
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.WHITE);

		JTextArea name = new JTextArea();
		name.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE), "ACTIVIDAD",
						TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		name.setText(courseVector[0]);
		name.setFont(ConstantsGUI.DEFAULT_FONT);
		name.setBackground(Color.WHITE);
		name.setForeground(Color.BLACK);
		name.setEditable(false);
		name.setFont(ConstantsGUI.DEFAULT_FONT);
		GridBagConstrainsForm.gridBagConstrainsForm(gb, 0, 0, 2, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		panel.add(name, gb);

		JTextArea teacher = new JTextArea();
		teacher.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE), "PROFESOR",
						TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		teacher.setText(courseVector[1]);
		teacher.setFont(ConstantsGUI.DEFAULT_FONT);
		teacher.setBackground(Color.WHITE);
		teacher.setForeground(Color.BLACK);
		teacher.setEditable(false);
		teacher.setFont(ConstantsGUI.DEFAULT_FONT);
		GridBagConstrainsForm.gridBagConstrainsForm(gb, 0, 1, 2, 1, 1, 1, GridBagConstraints.HORIZONTAL);
		panel.add(teacher, gb);

		JTextArea anotation = new JTextArea();
		anotation.setText(courseVector[2]);
		anotation.setFont(ConstantsGUI.DEFAULT_FONT);
		anotation.setBackground(Color.WHITE);
		anotation.setForeground(Color.BLACK);
		anotation.setEditable(false);
		anotation.setLineWrap(true);
		anotation.setFont(ConstantsGUI.DEFAULT_FONT);
		
		JScrollPane scrollAnotation = new JScrollPane(anotation);
		scrollAnotation.setBackground(Color.WHITE);
		scrollAnotation.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE), "DESCRIPCION",
						TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		GridBagConstrainsForm.gridBagConstrainsForm(gb, 0, 2, 2, 2, 1, 2, GridBagConstraints.BOTH);
		panel.add(scrollAnotation, gb);

		
		
		
		String[] schedules = courseVector[3].split("%");
		
		JPanel containerDays = new JPanel(new GridLayout(schedules.length-1, 1));
		for (String scheduleInfo : schedules) {
			if (!scheduleInfo.equalsIgnoreCase(";")) {
				JTextArea day = new JTextArea();
				day.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE),
						"DIA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
				day.setText(scheduleInfo.split("#")[0]);
				day.setFont(ConstantsGUI.DEFAULT_FONT);
				day.setBackground(Color.WHITE);
				day.setForeground(Color.BLACK);
				day.setEditable(false);
				day.setFont(ConstantsGUI.DEFAULT_FONT);
				containerDays.add(day);

				JTextArea hour = new JTextArea();
				hour.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE),
						"HORA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN,
						ConstantsGUI.DARK_BLUE));
				hour.setText(scheduleInfo.split("#")[1] + " - " + scheduleInfo.split("#")[2]);
				hour.setFont(ConstantsGUI.DEFAULT_FONT);
				hour.setBackground(Color.WHITE);
				hour.setForeground(Color.BLACK);
				hour.setEditable(false);
				hour.setFont(ConstantsGUI.DEFAULT_FONT);
				containerDays.add(hour);
			}
		}
		JScrollPane scrollShedules = new JScrollPane(containerDays);
		scrollShedules.setBackground(Color.WHITE);
		scrollShedules.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE), "HORARIO",
						TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		
		GridBagConstrainsForm.gridBagConstrainsForm(gb, 0, 4, 2, 2, 1, 2, GridBagConstraints.BOTH);
		panel.add(scrollShedules, gb);
		add(panel);
	}

}
