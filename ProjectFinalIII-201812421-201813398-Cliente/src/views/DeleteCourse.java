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

public class DeleteCourse extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel optionsDeleteContainer, confirmDeleteContainer, containerConfirmButtons;
	private JComboBox<String> course, homework;
	private ButtonObj findHomework, deleteHomework, deleteCourse, confirmDeleteCourse, confirmDeleteHomework;

	public DeleteCourse(ActionListener actionListener) {
		setLayout(new GridLayout(2, 1, 50, 10));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension((int) (ConstantsGUI.WIDTH / 1.4), (int) (ConstantsGUI.HEIGHT / 1.2)));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		initSearchComponents(actionListener);
		initConfirmDelete(actionListener);
	}

	private void initSearchComponents(ActionListener actionListener) {
		JPanel containerBox = new JPanel(new GridLayout(4, 1));
		containerBox.setBackground(Color.WHITE);

		createCoursesComboBox(actionListener, containerBox);
		createDeleteBtns(actionListener, containerBox);
		createHomeworksComboBox(actionListener, containerBox);
		createDeleteHomeworkBtn(actionListener, containerBox);

		add(containerBox);
	}

	private void createCoursesComboBox(ActionListener actionListener, JPanel containerBox) {
		course = new JComboBox<String>();
		course.addActionListener(actionListener);
		course.setActionCommand(Event.VISIBLE_HOMEWORK.toString());
		course.setBackground(Color.WHITE);
		course.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"ASIGNATURA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD,
				ConstantsGUI.DARK_BLUE));
		course.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		course.setForeground(Color.BLACK);
		course.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(course);
	}

	private void createDeleteBtns(ActionListener actionListener, JPanel containerBox) {
		optionsDeleteContainer = new JPanel(new GridLayout(1, 2, (int) (ConstantsGUI.WIDTH / 6.89), 10));
		optionsDeleteContainer.setBackground(Color.WHITE);

		JPanel containerButtonFH = new JPanel();
		containerButtonFH.setBackground(Color.WHITE);
		findHomework = new ButtonObj("Buscar Tareas", actionListener, Event.FIND_HOMEWORK_DELETE.toString(),
				ConstantsGUI.DARK_BLUE);
		containerButtonFH.add(findHomework);
		optionsDeleteContainer.add(containerButtonFH);

		JPanel containerButtonDC = new JPanel();
		containerButtonDC.setBackground(Color.WHITE);
		deleteCourse = new ButtonObj("ELIMINAR ASIGNATURA", actionListener, Event.DELETE_COURSE.toString(),
				ConstantsGUI.DARK_RED);
		containerButtonDC.add(deleteCourse);

		optionsDeleteContainer.add(containerButtonDC);
		containerBox.add(optionsDeleteContainer);
	}

	private void createHomeworksComboBox(ActionListener actionListener, JPanel containerBox) {
		homework = new JComboBox<String>();
		homework.setBackground(Color.WHITE);
		homework.addActionListener(actionListener);
		homework.setActionCommand(Event.VISIBLE_MODIFY.toString());
		homework.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE, 1),
				"TAREA", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_BLUE));
		homework.setFont(ConstantsGUI.DEFAULT_FONT_BOLD);
		homework.setForeground(Color.BLACK);
		homework.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 2, ConstantsGUI.HEIGHT / 12));
		containerBox.add(homework);
	}

	private void createDeleteHomeworkBtn(ActionListener actionListener, JPanel containerBox) {
		JPanel containerButtonDH = new JPanel();
		containerButtonDH.setBackground(Color.WHITE);
		deleteHomework = new ButtonObj("ELIMINAR TAREA", actionListener, Event.DELETE_HOMEWORK.toString(),
				ConstantsGUI.DARK_RED);
		containerButtonDH.add(deleteHomework);
		containerBox.add(containerButtonDH);
	}

	private void initConfirmDelete(ActionListener actionListener) {
		confirmDeleteContainer = new JPanel(new GridLayout(2, 1));
		confirmDeleteContainer.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(ConstantsGUI.DARK_RED, 2), "CONFIRMAR SELECCION", TitledBorder.CENTER,
				TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_BOLD, ConstantsGUI.DARK_RED));
		confirmDeleteContainer.setBackground(Color.WHITE);

		createSecureDeleteQuestion(confirmDeleteContainer);
		createConfirmDeleteBtns(actionListener, confirmDeleteContainer);

		add(confirmDeleteContainer);
	}

	private void createSecureDeleteQuestion(JPanel confirmDeleteContainer) {
		JLabel warningDelete = new JLabel("Estas seguro? Recuerda que este es un proceso irreversible.");
		warningDelete.setBorder(BorderFactory.createEmptyBorder(0, (int) (ConstantsGUI.WIDTH / 18.3), 0, 0));
		warningDelete.setFont(ConstantsGUI.DEFAULT_FONT_MAX_BOLD);
		warningDelete.setForeground(ConstantsGUI.DARK_RED);
		confirmDeleteContainer.add(warningDelete);
	}

	private void createConfirmDeleteBtns(ActionListener actionListener, JPanel confirmDeleteContainer) {
		containerConfirmButtons = new JPanel();
		containerConfirmButtons.setBorder(null);
		containerConfirmButtons.setBackground(Color.WHITE);

		confirmDeleteCourse = new ButtonObj("ELIMINAR ASIGNATURA", actionListener, Event.CONFIRM_DELETE_COURSE.toString(),
				ConstantsGUI.DARK_RED);
		containerConfirmButtons.add(confirmDeleteCourse, BorderLayout.CENTER);

		confirmDeleteHomework = new ButtonObj("ELIMINAR TAREA", actionListener, Event.CONFIRM_DELETE_HOMEWORK.toString(),
				ConstantsGUI.DARK_RED);
		containerConfirmButtons.add(confirmDeleteHomework, BorderLayout.CENTER);

		confirmDeleteContainer.add(containerConfirmButtons);
	}

	public void setVisibleHomework(boolean isVisible) {
		homework.setVisible(isVisible);
		deleteHomework.setVisible(isVisible);
		confirmDeleteContainer.setVisible(false);
	}

	public void resetComboDeleteHomeCourses() {
		homework.removeAllItems();
	}

	public void setVisibleConfirmDelete(boolean isVisible) {
		confirmDeleteContainer.setVisible(isVisible);
		confirmDeleteCourse.setVisible(isVisible);
		confirmDeleteHomework.setVisible(isVisible);
	}

	public void setVisibleDeleteCourse(boolean isVisible) {
		confirmDeleteContainer.setVisible(isVisible);
		confirmDeleteCourse.setVisible(isVisible);
		confirmDeleteHomework.setVisible(!isVisible);
	}

	public void setVisibleDeleteHomework(boolean isVisible) {
		confirmDeleteContainer.setVisible(isVisible);
		confirmDeleteHomework.setVisible(isVisible);
		confirmDeleteCourse.setVisible(!isVisible);
	}

	public String getDeleteHomework() {
		return homework.getSelectedItem().toString();
	}

	public String getDeleteCourse() {
		return course.getSelectedItem().toString();
	}

	public boolean getSelectedItemsCourse() {
		if (course.getItemCount() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setEditBtnDeleteCourse(boolean isBoolean) {
		deleteCourse.setEnabled(isBoolean);
		course.setVisible(isBoolean);
		findHomework.setVisible(isBoolean);
		if (isBoolean) {
			deleteCourse.setText("ELIMINAR ASIGNATURA");
		} else {
			deleteCourse.setText("No hay Asignaturas por eliminar");
		}
	}

	public void setComboBoxDeleteCourses(String[] courses) {
		for (int i = 0; i < courses.length; i++) {
			if (!courses[i].equalsIgnoreCase("")) {
				course.addItem(courses[i]);
			}
		}
	}

	public void setComboBoxDeleteHomeworks(String[] homeworks) {
		for (String homework : homeworks) {
			if (!homework.equalsIgnoreCase("")) {
				this.homework.addItem(homework);
			}
		}
	}

	public void resetFindHomework() {
		homework.removeAllItems();
		confirmDeleteContainer.setVisible(false);
	}

	public void resetComboDeleteCourses() {
		course.removeAllItems();
	}

	public void removeSpecificCourse(String deleteCourse) {
		for (int i = 0; i < course.getItemCount(); i++) {
			if (course.getItemAt(i).toString().equalsIgnoreCase(deleteCourse)) {
				course.removeItemAt(i);
			}
		}
	}

	public void removeSpecificHomework(String deleteHomework2) {
		for (int i = 0; i < homework.getItemCount(); i++) {
			if (homework.getItemAt(i).toString().equalsIgnoreCase(deleteHomework2)) {
				homework.removeItemAt(i);
			}
		}
	}

	public boolean getItemsDeleteHomework() {
		if (homework.getItemCount() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setEditBtnDeleteHomework(boolean isBoolean) {
		homework.setVisible(isBoolean);
		deleteHomework.setVisible(true);
		deleteHomework.setEnabled(isBoolean);
		if (isBoolean) {
			deleteHomework.setText("ELIMINAR TAREA");
		} else {
			deleteHomework.setText("No hay Tareas por eliminar");
		}
	}
}