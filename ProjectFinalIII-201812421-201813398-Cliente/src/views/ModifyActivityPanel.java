package views;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.Event;

public class ModifyActivityPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> activity;
	private JComboBox<String> days;
	private JSpinner init, end;
	private JTextArea annotation, name;
	private ButtonObj modifyHomework, acceptModify;
	private JPanel containerModify, containerSchedule, schedule;

	public ModifyActivityPanel(ActionListener actionListener) {
		setLayout(new GridLayout(3, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 1.4), (int) (ConstantsGUI.HEIGHT / 1.2)));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		initSearchComponents(actionListener);
		initModifyComponents(actionListener);
	}

	private void initSearchComponents(ActionListener actionListener) {
		JPanel containerBox = new JPanel(new GridLayout(2, 1));
		containerBox.setBackground(Color.WHITE);
		createActivitiesComboBox(actionListener, containerBox);
		createConfirmSearchBtn(actionListener, containerBox);
		add(containerBox);
	}

	private void createActivitiesComboBox(ActionListener actionListener, JPanel containerBox) {
		activity = new JComboBox<String>();
		activity.addActionListener(actionListener);
		activity.setActionCommand(Event.RESET_MODIFY_ACTIVITY.toString());
		activity.setBackground(Color.WHITE);
		activity.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"ACTIVIDADES", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		activity.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		activity.setForeground(Color.BLACK);
		activity.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(activity);
	}

	private void createConfirmSearchBtn(ActionListener actionListener, JPanel containerBox) {
		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);
		modifyHomework = new ButtonObj("Confirmar", actionListener, Event.MODIFY_ACTIVITY.toString(),
				ConstantsGUI.DARK_BLUE);
		containerButton.add(modifyHomework);
		containerBox.add(containerButton);
	}

	private void initModifyComponents(ActionListener actionListener) {
		containerModify = new JPanel(new GridLayout(2, 2, 20, 20));
		containerModify.setBackground(Color.WHITE);
		createNameActivityTextField();
		createAnnotationActivityTextField();
		add(containerModify);

		createContainerScheduler(actionListener);
	}

	private void createNameActivityTextField() {
		name = new JTextArea();
		name.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"NOMBRE DE LA ACTIVIDAD", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		name.setFont(ConstantsGUI.DEFAULT_FONT_ITALIC_MAX);
		name.setForeground(ConstantsGUI.DARK_BLUE);
		name.setBackground(Color.WHITE);
		name.setLineWrap(true);
		containerModify.add(name);
	}

	private void createAnnotationActivityTextField() {
		annotation = new JTextArea();
		annotation.setLineWrap(true);
		annotation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"ANOTACIONES", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		annotation.setFont(ConstantsGUI.DEFAULT_FONT);
		annotation.setForeground(Color.BLACK);
		containerModify.add(annotation);
	}

	private void createContainerScheduler(ActionListener actionListener) {
		schedule = new JPanel(new GridLayout(1, 2));
		schedule.setBackground(Color.WHITE);

		containerSchedule = new JPanel(new GridLayout(2, 1, 20, 0));
		containerSchedule.setBackground(Color.WHITE);
		containerSchedule.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1), "HORARIO DE LA ACTIVIDAD", TitledBorder.LEFT,
				TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		createDaysComboBox();
		createContainerHours();
		schedule.add(containerSchedule);

		JPanel containerButton = new JPanel();
		containerButton.setBackground(Color.WHITE);
		containerButton.setBorder(BorderFactory.createEmptyBorder(ConstantsGUI.HEIGHT / 20, ConstantsGUI.WIDTH / 20, 0,
				ConstantsGUI.WIDTH / 20));
		acceptModify = new ButtonObj("Aceptar", actionListener, Event.SEND_ACTIVITY.toString(), ConstantsGUI.DARK_YELLOW);
		containerButton.add(acceptModify);
		schedule.add(containerButton);

		add(schedule);
	}

	private void createDaysComboBox() {
		days = new JComboBox<String>();
		days.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		days.setBackground(Color.WHITE);
		days.setForeground(Color.BLACK);
		days.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"DIA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		for (int i = 1; i < ConstantsGUI.DAYS.length; i++) {
			days.addItem(ConstantsGUI.DAYS[i]);
		}
		containerSchedule.add(days);
	}

	private void createContainerHours() {
		JPanel containerHours = new JPanel(new GridLayout(1, 2));
		containerHours.setBackground(Color.WHITE);
		createInitHourSpinner(containerHours);
		createEndHourSpinner(containerHours);
		init.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				end.setValue((int) init.getValue() + 1);
			}
		});
		containerSchedule.add(containerHours);
	}

	private void createInitHourSpinner(JPanel containerHours) {
		SpinnerModel modelInit = new SpinnerNumberModel(10, 6, 20, 1);
		init = new JSpinner(modelInit);
		init.setBackground(Color.WHITE);
		((DefaultEditor) init.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) init.getEditor()).getTextField().setBackground(Color.WHITE);
		init.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"HORA INICIO", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		init.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		init.setForeground(Color.GRAY);
		containerHours.add(init);
	}

	private void createEndHourSpinner(JPanel containerHours) {
		SpinnerModel modelEnd = new SpinnerNumberModel(11, 7, 21, 1);
		end = new JSpinner(modelEnd);
		end.setBackground(Color.WHITE);
		((DefaultEditor) end.getEditor()).getTextField().setEditable(false);
		((DefaultEditor) end.getEditor()).getTextField().setBackground(Color.WHITE);
		end.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1), "HORA FIN",
						TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		end.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		end.setForeground(Color.GRAY);
		containerHours.add(end);
	}

	public void setVisibleModifyActivity(boolean isVisible) {
		containerModify.setVisible(isVisible);
		schedule.setVisible(isVisible);
	}

	public void resetModifyPanel() {
		activity.removeAllItems();
		activity.addItem("AGREGAR ACTIVIDAD");
		annotation.setText("");
		name.setText("");
		setVisibleModifyActivity(false);
	}

	public void setEditableNameActivity(boolean isEditable) {
		name.setEditable(isEditable);
	}

	public String getModActString() {
		if (!name.getText().equalsIgnoreCase("") && (int) end.getValue() > (int) init.getValue()) {
			return name.getText() + ";;;" + annotation.getText() + ";;;" + days.getSelectedItem().toString() + "#"
					+ init.getValue() + "#" + end.getValue();
		} else if ((int) end.getValue() <= (int) init.getValue()) {
			return "errorEnd";
		} else {
			return "emptyData";
		}

	}

	public void setComboBoxActivities(String activities) {
		String[] activitiesVector = activities.split(";;;");
		for (String activityVector : activitiesVector) {
			if (!activityVector.equalsIgnoreCase("")) {
				activity.addItem(activityVector);
			}
		}
	}

	public String getComboBoxActivity() {
		return activity.getSelectedItem().toString();
	}

	public void setEnableModifyActivity(boolean isEditable) {
		if (isEditable) {
			name.setEditable(isEditable);
			name.setText("");
			annotation.setText("");
		} else {
			name.setEditable(isEditable);
		}
	}

	public boolean getEnableModifyActivity() {
		return name.isEditable();
	}

	public void setComboBoxActivity(String infoActivity) {
		String[] activityVector = infoActivity.split("&");
		name.setText(activityVector[0]);
		annotation.setText(activityVector[1]);
		String[] schedule = activityVector[2].split("#");
		for (int i = 0; i < days.getItemCount(); i++) {
			if (schedule[0].equalsIgnoreCase(days.getItemAt(i).toString())) {
				days.setSelectedIndex(i);
			}
		}
	}
}