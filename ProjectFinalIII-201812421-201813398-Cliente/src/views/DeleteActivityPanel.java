package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.Controller;
import controller.Event;

public class DeleteActivityPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> activity;
	private JPanel optionsDeleteContainer, containerConfirmButtons, confirmDeleteContainer;
	private ButtonObj deleteActivity, confirmDeleteActivity;

	public DeleteActivityPanel(Controller controller) {
		setLayout(new GridLayout(3, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		initDeleteCourse(controller);
		addComponentsSearch();
		initWarningDelete(controller);
	}

	private void initWarningDelete(Controller controller) {
		confirmDeleteContainer = new JPanel(new GridLayout(2, 1));
		confirmDeleteContainer.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_RED, 2),
				"CONFIRMAR SELECCION", TitledBorder.CENTER, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_RED));
		confirmDeleteContainer.setBackground(Color.WHITE);
		add(confirmDeleteContainer);
		
		JLabel warningDelete = new JLabel("Estas seguro? Recuerda que este es un proceso irreversible.");
		warningDelete.setBorder(BorderFactory.createEmptyBorder(0, (int) (Constants.WIDTH/18.3), 0, 0));
		warningDelete.setFont(Constants.DEFAULT_FONT_MAX_BOLD);
		warningDelete.setForeground(Constants.DARK_RED);
		
		confirmDeleteActivity = new ButtonObj("ELIMINAR ACTIVIDAD DEFINITIVAMENTE", controller, Event.CONFIRM_DELETE_ACTIVITY.toString(), Constants.DARK_RED);
		
		containerConfirmButtons = new JPanel();
		containerConfirmButtons.setBorder(null);
		containerConfirmButtons.setBackground(Color.WHITE);
		containerConfirmButtons.add(confirmDeleteActivity, BorderLayout.CENTER);
		
		confirmDeleteContainer.add(warningDelete);
		confirmDeleteContainer.add(containerConfirmButtons);
	}

	private void initDeleteCourse(Controller controller) {
		activity = new JComboBox<String>();
		activity.addActionListener(controller);
		activity.setActionCommand(Event.RESET_DELETE_ACTIVITY.toString());
		activity.setBackground(Color.WHITE);
		activity.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ACTIVIDADES", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		activity.setFont(Constants.DEFAULT_FONT_BOLD);
		activity.setForeground(Color.BLACK);
		activity.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));

		optionsDeleteContainer = new JPanel(new GridLayout(1, 2, (int) (Constants.WIDTH/6.89), 10));
		optionsDeleteContainer.setBackground(Color.WHITE);
		deleteActivity = new ButtonObj("ELIMINAR ACTIVIDAD", controller, Event.DELETE_ACTIVITY.toString(), Constants.DARK_RED);

		JPanel containerButtonFH = new JPanel();
		containerButtonFH.add(deleteActivity);
		containerButtonFH.setBackground(Color.WHITE);
		optionsDeleteContainer.add(containerButtonFH);
	}
	
	private void addComponentsSearch() {
		JPanel containerBox = new JPanel(new GridLayout(2, 1));
		containerBox.setBackground(Color.WHITE);
		containerBox.add(activity);
		containerBox.add(optionsDeleteContainer);
		
		add(containerBox);
	}

	public void setVisibleConfirmDelete(boolean b) {
		confirmDeleteContainer.setVisible(b);		
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
		}else {
			return false;
		}
	}

	public void setEditBtnDeleteAct(boolean b) {
		deleteActivity.setEnabled(b);
		activity.setVisible(b);
		if (b) {
			deleteActivity.setText("ELIMINAR ACTIVIDAD");
		}else {
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