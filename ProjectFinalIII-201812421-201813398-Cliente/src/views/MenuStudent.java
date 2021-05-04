package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Event;

public class MenuStudent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel menuSchedule, menuAddCourse, menuModifyCourse, menuDeleteCourse, menuAddOrModActivity, menuAVG,
			menuDeleteActivity;
	private ButtonObj addCourseBtn, modifyCourseBtn, deleteCourseBtn, addOrModActivityBtn, avgBtn, deleteAcitivityBtn,
			showScheduleBtn;

	public MenuStudent(ActionListener actionListener) {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT));
		initApp(actionListener);
	}

	private void initApp(ActionListener actionListener) {
		initLogoApp();
		initSchedule(actionListener);
		initAddCourse(actionListener);
		initModifyCourse(actionListener);
		initDeleteCourse(actionListener);
		initAddActivity(actionListener);
		initDeleteActivity(actionListener);
		initCalculateAVG(actionListener);
	}

	private void initLogoApp() {
		createLogoImg();
		createNameApp();
	}

	private void createLogoImg() {
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(ConstantsGUI.DARK_BLUE);
		JLabel logoApp = new JLabel();
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_APP_ICON)).getImage()
				.getScaledInstance(ConstantsGUI.WIDTH / 7, ConstantsGUI.WIDTH / 7, Image.SCALE_SMOOTH));
		logoApp.setIcon(img);
		panelLogo.add(logoApp);
		add(panelLogo);
	}

	private void createNameApp() {
		JPanel panelName = new JPanel();
		panelName.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.WHITE));
		panelName.setBackground(Color.WHITE);
		JLabel nameApp = new JLabel(ConstantsGUI.NAME_APP);
		nameApp.setFont(new Font("Segoe UI", Font.BOLD, ConstantsGUI.WIDTH / 40));
		nameApp.setForeground(ConstantsGUI.DARK_BLUE);
		panelName.add(nameApp);
		add(panelName);
	}

	private void initSchedule(ActionListener actionListener) {
		menuSchedule = new JPanel();
		menuSchedule.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 200, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.BLACK));
		menuSchedule.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuSchedule.setBackground(ConstantsGUI.DARK_BLUE);
		showScheduleBtn = new ButtonObj(ConstantsGUI.BT_SCHEDULE_ST, actionListener, Event.SHOW_SCHEDULE.toString());
		showScheduleBtn.setBackground(ConstantsGUI.DARK_BLUE);
		showScheduleBtn.setBorder(null);
		menuSchedule.add(showScheduleBtn);
		add(menuSchedule);
	}

	private void initAddCourse(ActionListener actionListener) {
		menuAddCourse = new JPanel();
		menuAddCourse.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.BLACK));
		menuAddCourse.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn = new ButtonObj(ConstantsGUI.BT_ADD_COURSE_ST, actionListener, Event.ADD_COURSE_ST.toString());
		addCourseBtn.setBorder(null);
		menuAddCourse.add(addCourseBtn);
		add(menuAddCourse);
	}

	private void initModifyCourse(ActionListener actionListener) {
		menuModifyCourse = new JPanel();
		menuModifyCourse.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.BLACK));
		menuModifyCourse.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn = new ButtonObj(ConstantsGUI.BT_MODIFY_COURSE_ST, actionListener,
				Event.MODIFY_COURSE_ST.toString());
		modifyCourseBtn.setBorder(null);
		menuModifyCourse.add(modifyCourseBtn);
		add(menuModifyCourse);
	}

	private void initDeleteCourse(ActionListener actionListener) {
		menuDeleteCourse = new JPanel();
		menuDeleteCourse.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.BLACK));
		menuDeleteCourse.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn = new ButtonObj(ConstantsGUI.BT_DELETE_COURSE_ST, actionListener,
				Event.DELETE_COURSE_OR_HOMEWORK.toString());
		deleteCourseBtn.setBorder(null);
		menuDeleteCourse.add(deleteCourseBtn);

		add(menuDeleteCourse);
	}

	private void initAddActivity(ActionListener actionListener) {
		menuAddOrModActivity = new JPanel();
		menuAddOrModActivity.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400,
				ConstantsGUI.WIDTH / 137, ConstantsGUI.HEIGHT / 400, 0, Color.BLACK));
		menuAddOrModActivity.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuAddOrModActivity.setBackground(ConstantsGUI.DARK_BLUE);
		addOrModActivityBtn = new ButtonObj(ConstantsGUI.BT_ADD_OR_MOD_ACTIVITY_ST, actionListener,
				Event.ADD_OR_MOD_ACTIVITY_ST.toString());
		addOrModActivityBtn.setBorder(null);
		menuAddOrModActivity.add(addOrModActivityBtn);
		add(menuAddOrModActivity);
	}

	private void initDeleteActivity(ActionListener actionListener) {
		menuDeleteActivity = new JPanel();
		menuDeleteActivity.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400,
				ConstantsGUI.WIDTH / 137, ConstantsGUI.HEIGHT / 200, 0, Color.BLACK));
		menuDeleteActivity.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuDeleteActivity.setBackground(ConstantsGUI.DARK_BLUE);
		deleteAcitivityBtn = new ButtonObj(ConstantsGUI.BT_DELETE_ACTIVITY_ST, actionListener,
				Event.DELETE_ACTIVITY_ST.toString());
		deleteAcitivityBtn.setBorder(null);
		menuDeleteActivity.add(deleteAcitivityBtn);
		add(menuDeleteActivity);
	}

	private void initCalculateAVG(ActionListener actionListener) {
		menuAVG = new JPanel();
		menuAVG.setBorder(BorderFactory.createMatteBorder(ConstantsGUI.HEIGHT / 400, ConstantsGUI.WIDTH / 137,
				ConstantsGUI.HEIGHT / 400, 0, Color.BLACK));
		menuAVG.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 20));
		menuAVG.setBackground(ConstantsGUI.DARK_BLUE);
		avgBtn = new ButtonObj(ConstantsGUI.BT_AVG_ST, actionListener, Event.AVG_ST.toString());
		avgBtn.setBorder(null);
		menuAVG.add(avgBtn);
		add(menuAVG);
	}

	public void enableAddCourse(boolean isEnable) {
		addCourseBtn.setEnabled(isEnable);
	}

	public void changeColorMenuBtn(Event event) {
		switch (event) {
		case SHOW_SCHEDULE:
			changeColorShowSchedulerBtn();
			break;
		case ADD_COURSE_ST:
			changeColorAddCourseBtn();
			break;
		case MODIFY_COURSE_ST:
			changeColorModifyCourseBtn();
			break;
		case DELETE_COURSE_OR_HOMEWORK:
			changeColorDeleteCourseBtn();
			break;
		case ADD_OR_MOD_ACTIVITY_ST:
			changeColorAddActivityBtn();
			break;
		case AVG_ST:
			changeColorModifyActivityBtn();
			break;
		case DELETE_ACTIVITY_ST:
			changeColorDeleteActivityBtn();
			break;
		default:
			break;
		}
	}

	private void changeColorShowSchedulerBtn() {
		menuSchedule.setBackground(ConstantsGUI.DARK_YELLOW);
		showScheduleBtn.setBackground(ConstantsGUI.DARK_YELLOW);
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddOrModActivity.setBackground(ConstantsGUI.DARK_BLUE);
		addOrModActivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteActivity.setBackground(ConstantsGUI.DARK_BLUE);
		deleteAcitivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAVG.setBackground(ConstantsGUI.DARK_BLUE);
		avgBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorDeleteActivityBtn() {
		menuSchedule.setBackground(ConstantsGUI.DARK_BLUE);
		showScheduleBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddOrModActivity.setBackground(ConstantsGUI.DARK_BLUE);
		addOrModActivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteActivity.setBackground(ConstantsGUI.DARK_YELLOW);
		deleteAcitivityBtn.setBackground(ConstantsGUI.DARK_YELLOW);
		menuAVG.setBackground(ConstantsGUI.DARK_BLUE);
		avgBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorModifyActivityBtn() {
		menuSchedule.setBackground(ConstantsGUI.DARK_BLUE);
		showScheduleBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddOrModActivity.setBackground(ConstantsGUI.DARK_BLUE);
		addOrModActivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteActivity.setBackground(ConstantsGUI.DARK_BLUE);
		deleteAcitivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAVG.setBackground(ConstantsGUI.DARK_YELLOW);
		avgBtn.setBackground(ConstantsGUI.DARK_YELLOW);
	}

	private void changeColorAddActivityBtn() {
		menuSchedule.setBackground(ConstantsGUI.DARK_BLUE);
		showScheduleBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddOrModActivity.setBackground(ConstantsGUI.DARK_YELLOW);
		addOrModActivityBtn.setBackground(ConstantsGUI.DARK_YELLOW);
		menuDeleteActivity.setBackground(ConstantsGUI.DARK_BLUE);
		deleteAcitivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAVG.setBackground(ConstantsGUI.DARK_BLUE);
		avgBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorDeleteCourseBtn() {
		menuSchedule.setBackground(ConstantsGUI.DARK_BLUE);
		showScheduleBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_YELLOW);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_YELLOW);
		menuAddOrModActivity.setBackground(ConstantsGUI.DARK_BLUE);
		addOrModActivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteActivity.setBackground(ConstantsGUI.DARK_BLUE);
		deleteAcitivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAVG.setBackground(ConstantsGUI.DARK_BLUE);
		avgBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorModifyCourseBtn() {
		menuSchedule.setBackground(ConstantsGUI.DARK_BLUE);
		showScheduleBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddCourse.setBackground(ConstantsGUI.DARK_BLUE);
		addCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_YELLOW);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_YELLOW);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddOrModActivity.setBackground(ConstantsGUI.DARK_BLUE);
		addOrModActivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteActivity.setBackground(ConstantsGUI.DARK_BLUE);
		deleteAcitivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAVG.setBackground(ConstantsGUI.DARK_BLUE);
		avgBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}

	private void changeColorAddCourseBtn() {
		menuSchedule.setBackground(ConstantsGUI.DARK_BLUE);
		showScheduleBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddCourse.setBackground(ConstantsGUI.DARK_YELLOW);
		addCourseBtn.setBackground(ConstantsGUI.DARK_YELLOW);
		menuModifyCourse.setBackground(ConstantsGUI.DARK_BLUE);
		modifyCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteCourse.setBackground(ConstantsGUI.DARK_BLUE);
		deleteCourseBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAddOrModActivity.setBackground(ConstantsGUI.DARK_BLUE);
		addOrModActivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuDeleteActivity.setBackground(ConstantsGUI.DARK_BLUE);
		deleteAcitivityBtn.setBackground(ConstantsGUI.DARK_BLUE);
		menuAVG.setBackground(ConstantsGUI.DARK_BLUE);
		avgBtn.setBackground(ConstantsGUI.DARK_BLUE);
	}
}