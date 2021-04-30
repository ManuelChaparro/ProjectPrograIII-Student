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

public class DeleteCourse extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel optionsDeleteContainer, confirmDeleteContainer, containerConfirmButtons;
	private JComboBox<String> course, homework;
	private ButtonObj findHomework, deleteHomework, deleteCourse, confirmDeleteCourse, confirmDeleteHomework;

	public DeleteCourse(Controller controller) {
		setLayout(new GridLayout(2, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (Constants.WIDTH / 1.4), (int) (Constants.HEIGHT / 1.2)));
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		initDeleteCourse(controller);
		initDeleteHomework(controller);
		addComponentsSearch();
		initConfirmDelete(controller);
	}

	private void initConfirmDelete(Controller controller) {
		confirmDeleteContainer = new JPanel(new GridLayout(2, 1));
		confirmDeleteContainer.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_RED, 2),
				"CONFIRMAR SELECCION", TitledBorder.CENTER, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_RED));
		confirmDeleteContainer.setBackground(Color.WHITE);
		add(confirmDeleteContainer);
		
		containerConfirmButtons = new JPanel();
		containerConfirmButtons.setBorder(null);
		containerConfirmButtons.setBackground(Color.WHITE);
		
		JLabel warningDelete = new JLabel("Estas seguro? Recuerda que este es un proceso irreversible.");
		warningDelete.setBorder(BorderFactory.createEmptyBorder(0, (int) (Constants.WIDTH/18.3), 0, 0));
		warningDelete.setFont(Constants.DEFAULT_FONT_MAX_BOLD);
		warningDelete.setForeground(Constants.DARK_RED);
		
		confirmDeleteCourse = new ButtonObj("ELIMINAR ASIGNATURA", controller, Event.CONFIRM_DELETE_COURSE.toString(), Constants.DARK_RED);
		confirmDeleteHomework = new ButtonObj("ELIMINAR TAREA", controller, Event.CONFIRM_DELETE_HOMEWORK.toString(), Constants.DARK_RED);

		containerConfirmButtons.add(confirmDeleteCourse, BorderLayout.CENTER);
		containerConfirmButtons.add(confirmDeleteHomework, BorderLayout.CENTER);
		
		confirmDeleteContainer.add(warningDelete);
		confirmDeleteContainer.add(containerConfirmButtons);
	}

	private void addComponentsSearch() {
		JPanel containerBox = new JPanel(new GridLayout(4, 1));
		containerBox.setBackground(Color.WHITE);
		containerBox.add(course);
		containerBox.add(optionsDeleteContainer);
		containerBox.add(homework);
		JPanel containerButtonDH = new JPanel();
		containerButtonDH.add(deleteHomework);
		containerButtonDH.setBackground(Color.WHITE);
		containerBox.add(containerButtonDH);
		add(containerBox);
	}

	private void initDeleteCourse(Controller controller) {
		course = new JComboBox<String>();
		course.addActionListener(controller);
		course.setActionCommand(Event.VISIBLE_HOMEWORK.toString());
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		course.setFont(Constants.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));

		optionsDeleteContainer = new JPanel(new GridLayout(1, 2, (int) (Constants.WIDTH/6.89), 10));
		optionsDeleteContainer.setBackground(Color.WHITE);
		findHomework = new ButtonObj("Buscar Tareas", controller, Event.FIND_HOMEWORK_DELETE.toString(), Constants.DARK_BLUE);
		deleteCourse = new ButtonObj("ELIMINAR ASIGNATURA", controller, Event.DELETE_COURSE.toString(), Constants.DARK_RED);
		
		JPanel containerButtonFH = new JPanel();
		containerButtonFH.add(findHomework);
		containerButtonFH.setBackground(Color.WHITE);
		optionsDeleteContainer.add(containerButtonFH);
		JPanel containerButtonDC = new JPanel();
		containerButtonDC.add(deleteCourse);
		containerButtonDC.setBackground(Color.WHITE);
		optionsDeleteContainer.add(containerButtonDC);
	}

	private void initDeleteHomework(Controller controller) {
		homework = new JComboBox<String>();
		homework.setBackground(Color.WHITE);
		homework.addActionListener(controller);
		homework.setActionCommand(Event.VISIBLE_MODIFY.toString());
		homework.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE, 1),
				"TAREA", TitledBorder.LEFT, TitledBorder.TOP, Constants.DEFAULT_FONT_BOLD, Constants.DARK_BLUE));
		homework.setFont(Constants.DEFAULT_FONT_BOLD);
		homework.setForeground(Color.BLACK);
		homework.setPreferredSize(new Dimension(Constants.WIDTH / 2, Constants.HEIGHT / 12));

		deleteHomework = new ButtonObj("ELIMINAR TAREA", controller, Event.DELETE_HOMEWORK.toString(), Constants.DARK_RED);
	}

	public void setVisibleHomework(boolean isVisible) {
		homework.setVisible(isVisible);
		deleteHomework.setVisible(isVisible);
	}

	public void resetComboDeleteHomeCourses() {
		homework.removeAllItems();
	}

	public void setVisibleConfirmDelete(boolean b) {
		confirmDeleteContainer.setVisible(b);		
		confirmDeleteCourse.setVisible(b);		
		confirmDeleteHomework.setVisible(b);		
	}

	public void setVisibleDeleteCourse(boolean b) {
		confirmDeleteContainer.setVisible(b);
		confirmDeleteCourse.setVisible(b);	
		confirmDeleteHomework.setVisible(!b);
	}

	public void setVisibleDeleteHomework(boolean b) {
		confirmDeleteContainer.setVisible(b);
		confirmDeleteHomework.setVisible(b);
		confirmDeleteCourse.setVisible(!b);	
	}

	public String getDeleteHomework() {
		return homework.getSelectedItem().toString();
	}

	public String getDeleteCourse() {
		return course.getSelectedItem().toString();
	}

	public boolean getSelectedItemsCourse() {
		if (course.getItemAt(0) != null) {
			return true;
		}else {
			return false;
		}
	}

	public void setEditBtnDeleteCourse(boolean b) {
		deleteCourse.setEnabled(b);
		course.setVisible(b);
		findHomework.setVisible(b);
		if (b) {
			deleteCourse.setText("ELIMINAR ASIGNATURA");
		}else {
			deleteCourse.setText("No hay Asignaturas por eliminar");
		}
	}
}
