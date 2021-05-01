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
	private ButtonObj addCourseBtn, modifyCourseBtn, deleteCourseBtn, addOrModActivityBtn, avgBtn,
			deleteAcitivityBtn, showScheduleBtn;

	public MenuStudent(ActionListener actionListener) {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT));
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
		JPanel panelLogo = new JPanel();
		JLabel logoApp = initLogo(panelLogo);

		JPanel panelName = new JPanel();
		JLabel nameApp = initName(panelName);

		panelName.add(nameApp);
		panelLogo.add(logoApp);

		add(panelLogo);
		add(panelName);
	}

	private JLabel initName(JPanel panelName) {
		panelName.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT / 400, Constants.WIDTH / 137,
				Constants.HEIGHT / 400, 0, Color.WHITE));
		panelName.setBackground(Color.WHITE);
		JLabel nameApp = new JLabel(Constants.NAME_APP);
		nameApp.setFont(new Font("Segoe UI", Font.BOLD, Constants.WIDTH / 40));
		nameApp.setForeground(Constants.DARK_BLUE);
		return nameApp;
	}

	private JLabel initLogo(JPanel panelLogo) {
		panelLogo.setBackground(Constants.DARK_BLUE);
		JLabel logoApp = new JLabel();
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource(Constants.PATH_APP_ICON)).getImage()
				.getScaledInstance(Constants.WIDTH / 7, Constants.WIDTH / 7, Image.SCALE_SMOOTH));
		logoApp.setIcon(img);
		return logoApp;
	}

	private void initSchedule(ActionListener actionListener) {
		menuSchedule = new JPanel();
		menuSchedule.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT / 200, Constants.WIDTH / 137,
				Constants.HEIGHT / 400, 0, Color.BLACK));
		menuSchedule.setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT / 20));
		menuSchedule.setBackground(Constants.DARK_YELLOW);
		showScheduleBtn = new ButtonObj(Constants.BT_SCHEDULE_ST, actionListener, Event.SHOW_SCHEDULE.toString());
		showScheduleBtn.setBackground(Constants.DARK_YELLOW);
		showScheduleBtn.setBorder(null);
		menuSchedule.add(showScheduleBtn);
		add(menuSchedule);
	}

	private void initAddCourse(ActionListener actionListener) {
		menuAddCourse = new JPanel();
		menuAddCourse.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT / 400, Constants.WIDTH / 137,
				Constants.HEIGHT / 400, 0, Color.BLACK));
		menuAddCourse.setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT / 20));
		menuAddCourse.setBackground(Constants.DARK_BLUE);
		addCourseBtn = new ButtonObj(Constants.BT_ADD_COURSE_ST, actionListener, Event.ADD_COURSE_ST.toString());
		addCourseBtn.setBorder(null);
		menuAddCourse.add(addCourseBtn);
		add(menuAddCourse);
	}

	private void initModifyCourse(ActionListener actionListener) {
		menuModifyCourse = new JPanel();
		menuModifyCourse.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT / 400, Constants.WIDTH / 137,
				Constants.HEIGHT / 400, 0, Color.BLACK));
		menuModifyCourse.setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT / 20));
		menuModifyCourse.setBackground(Constants.DARK_BLUE);
		modifyCourseBtn = new ButtonObj(Constants.BT_MODIFY_COURSE_ST, actionListener,
				Event.MODIFY_COURSE_ST.toString());
		modifyCourseBtn.setBorder(null);
		menuModifyCourse.add(modifyCourseBtn);
		add(menuModifyCourse);
	}

	private void initDeleteCourse(ActionListener actionListener) {
		menuDeleteCourse = new JPanel();
		menuDeleteCourse.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT / 400, Constants.WIDTH / 137,
				Constants.HEIGHT / 400, 0, Color.BLACK));
		menuDeleteCourse.setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT / 20));
		menuDeleteCourse.setBackground(Constants.DARK_BLUE);
		deleteCourseBtn = new ButtonObj(Constants.BT_DELETE_COURSE_ST, actionListener,
				Event.DELETE_COURSE_OR_HOMEWORK.toString());
		deleteCourseBtn.setBorder(null);
		menuDeleteCourse.add(deleteCourseBtn);
		
		add(menuDeleteCourse);
	}

	private void initAddActivity(ActionListener actionListener) {
		menuAddOrModActivity = new JPanel();
		menuAddOrModActivity.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT / 400, Constants.WIDTH / 137,
				Constants.HEIGHT / 400, 0, Color.BLACK));
		menuAddOrModActivity.setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT / 20));
		menuAddOrModActivity.setBackground(Constants.DARK_BLUE);
		addOrModActivityBtn = new ButtonObj(Constants.BT_ADD_OR_MOD_ACTIVITY_ST, actionListener, Event.ADD_OR_MOD_ACTIVITY_ST.toString());
		addOrModActivityBtn.setBorder(null);
		menuAddOrModActivity.add(addOrModActivityBtn);
		add(menuAddOrModActivity);
	}

	private void initDeleteActivity(ActionListener actionListener) {
		menuDeleteActivity = new JPanel();
		menuDeleteActivity.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT / 400, Constants.WIDTH / 137,
				Constants.HEIGHT / 200, 0, Color.BLACK));
		menuDeleteActivity.setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT / 20));
		menuDeleteActivity.setBackground(Constants.DARK_BLUE);
		deleteAcitivityBtn = new ButtonObj(Constants.BT_DELETE_ACTIVITY_ST, actionListener,
				Event.DELETE_ACTIVITY_ST.toString());
		deleteAcitivityBtn.setBorder(null);
		menuDeleteActivity.add(deleteAcitivityBtn);
		add(menuDeleteActivity);
	}
	
	private void initCalculateAVG(ActionListener actionListener) {
		menuAVG = new JPanel();
		menuAVG.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT / 400, Constants.WIDTH / 137,
				Constants.HEIGHT / 400, 0, Color.BLACK));
		menuAVG.setPreferredSize(new Dimension(Constants.WIDTH / 4, Constants.HEIGHT / 20));
		menuAVG.setBackground(Constants.DARK_BLUE);
		avgBtn = new ButtonObj(Constants.BT_AVG_ST, actionListener,
				Event.AVG_ST.toString());
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
		menuSchedule.setBackground(Constants.DARK_YELLOW);
		showScheduleBtn.setBackground(Constants.DARK_YELLOW);
		menuAddCourse.setBackground(Constants.DARK_BLUE);
		addCourseBtn.setBackground(Constants.DARK_BLUE);
		menuModifyCourse.setBackground(Constants.DARK_BLUE);
		modifyCourseBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteCourse.setBackground(Constants.DARK_BLUE);
		deleteCourseBtn.setBackground(Constants.DARK_BLUE);
		menuAddOrModActivity.setBackground(Constants.DARK_BLUE);
		addOrModActivityBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteActivity.setBackground(Constants.DARK_BLUE);
		deleteAcitivityBtn.setBackground(Constants.DARK_BLUE);
		menuAVG.setBackground(Constants.DARK_BLUE);
		avgBtn.setBackground(Constants.DARK_BLUE);
	}

	private void changeColorDeleteActivityBtn() {
		menuSchedule.setBackground(Constants.DARK_BLUE);
		showScheduleBtn.setBackground(Constants.DARK_BLUE);
		menuAddCourse.setBackground(Constants.DARK_BLUE);
		addCourseBtn.setBackground(Constants.DARK_BLUE);
		menuModifyCourse.setBackground(Constants.DARK_BLUE);
		modifyCourseBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteCourse.setBackground(Constants.DARK_BLUE);
		deleteCourseBtn.setBackground(Constants.DARK_BLUE);
		menuAddOrModActivity.setBackground(Constants.DARK_BLUE);
		addOrModActivityBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteActivity.setBackground(Constants.DARK_YELLOW);
		deleteAcitivityBtn.setBackground(Constants.DARK_YELLOW);
		menuAVG.setBackground(Constants.DARK_BLUE);
		avgBtn.setBackground(Constants.DARK_BLUE);
	}

	private void changeColorModifyActivityBtn() {
		menuSchedule.setBackground(Constants.DARK_BLUE);
		showScheduleBtn.setBackground(Constants.DARK_BLUE);
		menuAddCourse.setBackground(Constants.DARK_BLUE);
		addCourseBtn.setBackground(Constants.DARK_BLUE);
		menuModifyCourse.setBackground(Constants.DARK_BLUE);
		modifyCourseBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteCourse.setBackground(Constants.DARK_BLUE);
		deleteCourseBtn.setBackground(Constants.DARK_BLUE);
		menuAddOrModActivity.setBackground(Constants.DARK_BLUE);
		addOrModActivityBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteActivity.setBackground(Constants.DARK_BLUE);
		deleteAcitivityBtn.setBackground(Constants.DARK_BLUE);
		menuAVG.setBackground(Constants.DARK_YELLOW);
		avgBtn.setBackground(Constants.DARK_YELLOW);
	}

	private void changeColorAddActivityBtn() {
		menuSchedule.setBackground(Constants.DARK_BLUE);
		showScheduleBtn.setBackground(Constants.DARK_BLUE);
		menuAddCourse.setBackground(Constants.DARK_BLUE);
		addCourseBtn.setBackground(Constants.DARK_BLUE);
		menuModifyCourse.setBackground(Constants.DARK_BLUE);
		modifyCourseBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteCourse.setBackground(Constants.DARK_BLUE);
		deleteCourseBtn.setBackground(Constants.DARK_BLUE);
		menuAddOrModActivity.setBackground(Constants.DARK_YELLOW);
		addOrModActivityBtn.setBackground(Constants.DARK_YELLOW);
		menuDeleteActivity.setBackground(Constants.DARK_BLUE);
		deleteAcitivityBtn.setBackground(Constants.DARK_BLUE);
		menuAVG.setBackground(Constants.DARK_BLUE);
		avgBtn.setBackground(Constants.DARK_BLUE);
	}

	private void changeColorDeleteCourseBtn() {
		menuSchedule.setBackground(Constants.DARK_BLUE);
		showScheduleBtn.setBackground(Constants.DARK_BLUE);
		menuAddCourse.setBackground(Constants.DARK_BLUE);
		addCourseBtn.setBackground(Constants.DARK_BLUE);
		menuModifyCourse.setBackground(Constants.DARK_BLUE);
		modifyCourseBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteCourse.setBackground(Constants.DARK_YELLOW);
		deleteCourseBtn.setBackground(Constants.DARK_YELLOW);
		menuAddOrModActivity.setBackground(Constants.DARK_BLUE);
		addOrModActivityBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteActivity.setBackground(Constants.DARK_BLUE);
		deleteAcitivityBtn.setBackground(Constants.DARK_BLUE);
		menuAVG.setBackground(Constants.DARK_BLUE);
		avgBtn.setBackground(Constants.DARK_BLUE);
	}

	private void changeColorModifyCourseBtn() {
		menuSchedule.setBackground(Constants.DARK_BLUE);
		showScheduleBtn.setBackground(Constants.DARK_BLUE);
		menuAddCourse.setBackground(Constants.DARK_BLUE);
		addCourseBtn.setBackground(Constants.DARK_BLUE);
		menuModifyCourse.setBackground(Constants.DARK_YELLOW);
		modifyCourseBtn.setBackground(Constants.DARK_YELLOW);
		menuDeleteCourse.setBackground(Constants.DARK_BLUE);
		deleteCourseBtn.setBackground(Constants.DARK_BLUE);
		menuAddOrModActivity.setBackground(Constants.DARK_BLUE);
		addOrModActivityBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteActivity.setBackground(Constants.DARK_BLUE);
		deleteAcitivityBtn.setBackground(Constants.DARK_BLUE);
		menuAVG.setBackground(Constants.DARK_BLUE);
		avgBtn.setBackground(Constants.DARK_BLUE);
	}

	private void changeColorAddCourseBtn() {
		menuSchedule.setBackground(Constants.DARK_BLUE);
		showScheduleBtn.setBackground(Constants.DARK_BLUE);
		menuAddCourse.setBackground(Constants.DARK_YELLOW);
		addCourseBtn.setBackground(Constants.DARK_YELLOW);
		menuModifyCourse.setBackground(Constants.DARK_BLUE);
		modifyCourseBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteCourse.setBackground(Constants.DARK_BLUE);
		deleteCourseBtn.setBackground(Constants.DARK_BLUE);
		menuAddOrModActivity.setBackground(Constants.DARK_BLUE);
		addOrModActivityBtn.setBackground(Constants.DARK_BLUE);
		menuDeleteActivity.setBackground(Constants.DARK_BLUE);
		deleteAcitivityBtn.setBackground(Constants.DARK_BLUE);
		menuAVG.setBackground(Constants.DARK_BLUE);
		avgBtn.setBackground(Constants.DARK_BLUE);
	}
}