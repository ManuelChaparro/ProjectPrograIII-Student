package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Event;

public class DeleteActivityPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> activity;
	private JPanel optionsDeleteContainer, containerConfirmButtons, confirmDeleteContainer;
	private ButtonObj deleteActivity, confirmDeleteActivity;

	public DeleteActivityPanel(ActionListener actionListener) {
		setLayout(new GridLayout(3, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 1.4), (int) (ConstantsGUI.HEIGHT / 1.2)));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		initSearchComponents(actionListener);
		initWarningDelete(actionListener);
	}

	private void initSearchComponents(ActionListener actionListener) {
		JPanel containerBox = new JPanel(new GridLayout(2, 1));
		containerBox.setBackground(Color.WHITE);
		createActivitiesComboBox(actionListener, containerBox);
		createDeleteActivityBtn(actionListener, containerBox);
		add(containerBox);
	}

	private void createActivitiesComboBox(ActionListener actionListener, JPanel containerBox) {
		activity = new JComboBox<String>();
		activity.addActionListener(actionListener);
		activity.setActionCommand(Event.RESET_DELETE_ACTIVITY.toString());
		activity.setBackground(Color.WHITE);
		activity.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"ACTIVIDADES", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		activity.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		activity.setForeground(Color.BLACK);
		activity.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(activity);
	}

	private void createDeleteActivityBtn(ActionListener actionListener, JPanel containerBox) {
		optionsDeleteContainer = new JPanel(new GridLayout(1, 2, (int) (ConstantsGUI.WIDTH / 6.89), 10));
		optionsDeleteContainer.setBackground(Color.WHITE);
		deleteActivity = new ButtonObj("ELIMINAR ACTIVIDAD", actionListener, Event.DELETE_ACTIVITY.toString(),
				ConstantsGUI.DARK_RED);

		JPanel containerButtonFH = new JPanel();
		containerButtonFH.add(deleteActivity);
		containerButtonFH.setBackground(Color.WHITE);
		optionsDeleteContainer.add(containerButtonFH);
		containerBox.add(optionsDeleteContainer);
	}

	private void initWarningDelete(ActionListener actionListener) {
		confirmDeleteContainer = new JPanel(new GridLayout(2, 1));
		confirmDeleteContainer.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(ConstantsGUI.DARK_RED, 2), "CONFIRMAR SELECCION", TitledBorder.CENTER,
				TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_RED));
		confirmDeleteContainer.setBackground(Color.WHITE);
		createSecureDeleteQuestionLabel();
		createConfirmDeleteActivityBtn(actionListener);
		add(confirmDeleteContainer);
	}

	private void createSecureDeleteQuestionLabel() {
		JLabel warningDelete = new JLabel("Estas seguro? Recuerda que este es un proceso irreversible.");
		warningDelete.setBorder(BorderFactory.createEmptyBorder(0, (int) (ConstantsGUI.WIDTH / 18.3), 0, 0));
		warningDelete.setFont(ConstantsGUI.DEFAULT_FONT_MAX_BOLD);
		warningDelete.setForeground(ConstantsGUI.DARK_RED);
		confirmDeleteContainer.add(warningDelete);
	}

	private void createConfirmDeleteActivityBtn(ActionListener actionListener) {
		confirmDeleteActivity = new ButtonObj("ELIMINAR ACTIVIDAD DEFINITIVAMENTE", actionListener,
				Event.CONFIRM_DELETE_ACTIVITY.toString(), ConstantsGUI.DARK_RED);
		containerConfirmButtons = new JPanel();
		containerConfirmButtons.setBorder(null);
		containerConfirmButtons.setBackground(Color.WHITE);
		containerConfirmButtons.add(confirmDeleteActivity, BorderLayout.CENTER);
		confirmDeleteContainer.add(containerConfirmButtons);
	}

	public void setVisibleConfirmDelete(boolean isVisible) {
		confirmDeleteContainer.setVisible(isVisible);
	}

	public void resetDeleteActivity() {
		activity.removeAllItems();
	}

	public boolean getSelectedItemsActivity() {
		for (int i = 0; i < activity.getItemCount(); i++) {
			if (activity.getItemAt(i).equals("")) {
				activity.removeItemAt(i);
			}
		}

		if (activity.getItemAt(0) != null) {
			return true;
		} else {
			return false;
		}
	}

	public void setEditBtnDeleteAct(boolean isBoolean) {
		deleteActivity.setEnabled(isBoolean);
		activity.setVisible(isBoolean);
		if (isBoolean) {
			deleteActivity.setText("ELIMINAR ACTIVIDAD");
		} else {
			deleteActivity.setText("No hay Actividades por eliminar");
		}
	}

	public String getDeleteActString() {
		return activity.getSelectedItem().toString();
	}

	public void setComboBoxActivities(String activities) {
		String[] activitiesVector = activities.split(";;;");
		for (String activityVector : activitiesVector) {
			activity.addItem(activityVector);
		}
	}
}