package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Controller;
import controller.Event;

public class MenuStudent extends JPanel{

	private static final long serialVersionUID = 1L;
	private ButtonObj addCourse, modifyCourse, deleteCourse,
					addActivity, modifyActivity, deleteAcitivity,
					showSchedule;
	
	public MenuStudent(Controller controller) {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT));
		initApp(controller);
	}

	private void initApp(Controller controller) {
		initLogoApp();
		initSchedule(controller);
		initAddCourse(controller);
		initModifyCourse(controller);
		initDeleteCourse(controller);
		initAddActivity(controller);
		initModifyActivity(controller);
		initDeleteActivity(controller);
	}

	private void initDeleteActivity(Controller controller) {
		JPanel menuDeleteActivity = new JPanel();
		menuDeleteActivity.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT/400, Constants.WIDTH/137, Constants.HEIGHT/200, 0, Color.BLACK));
		menuDeleteActivity.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/20));
		menuDeleteActivity.setBackground(Constants.DARK_BLUE);
		deleteAcitivity = new ButtonObj(Constants.BT_DELETE_ACTIVITY_ST, controller, Event.DELETE_COURSE_ST.toString());
		menuDeleteActivity.add(deleteAcitivity);
		add(menuDeleteActivity);
	}

	private void initModifyActivity(Controller controller) {
		JPanel menuModifyActivity = new JPanel();
		menuModifyActivity.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT/400, Constants.WIDTH/137, Constants.HEIGHT/400, 0, Color.BLACK));
		menuModifyActivity.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/20));
		menuModifyActivity.setBackground(Constants.DARK_BLUE);
		modifyActivity = new ButtonObj(Constants.BT_MODIFY_ACTIVITY_ST, controller, Event.MODIFY_ACTIVITY_ST.toString());
		menuModifyActivity.add(modifyActivity);
		add(menuModifyActivity);
	}

	private void initAddActivity(Controller controller) {
		JPanel menuAddActivity = new JPanel();
		menuAddActivity.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT/400, Constants.WIDTH/137, Constants.HEIGHT/400, 0, Color.BLACK));
		menuAddActivity.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/20));
		menuAddActivity.setBackground(Constants.DARK_BLUE);
		addActivity = new ButtonObj(Constants.BT_ADD_ACTIVITY_ST, controller, Event.ADD_ACTIVITY_ST.toString());
		menuAddActivity.add(addActivity);
		add(menuAddActivity);
	}

	private void initDeleteCourse(Controller controller) {
		JPanel menuDeleteCourse = new JPanel();
		menuDeleteCourse.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT/400, Constants.WIDTH/137, Constants.HEIGHT/400, 0, Color.BLACK));
		menuDeleteCourse.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/20));
		menuDeleteCourse.setBackground(Constants.DARK_BLUE);
		deleteCourse = new ButtonObj(Constants.BT_DELETE_COURSE_ST, controller, Event.DELETE_COURSE_ST.toString());
		menuDeleteCourse.add(deleteCourse);
		add(menuDeleteCourse);
	}

	private void initModifyCourse(Controller controller) {
		JPanel menuModifyCourse = new JPanel();
		menuModifyCourse.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT/400, Constants.WIDTH/137, Constants.HEIGHT/400, 0, Color.BLACK));
		menuModifyCourse.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/20));
		menuModifyCourse.setBackground(Constants.DARK_BLUE);
		modifyCourse = new ButtonObj(Constants.BT_MODIFY_COURSE_ST, controller, Event.MODIFY_COURSE_ST.toString());
		menuModifyCourse.add(modifyCourse);
		add(menuModifyCourse);
	}

	private void initAddCourse(Controller controller) {
		JPanel menuAddCourse = new JPanel();
		menuAddCourse.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT/400, Constants.WIDTH/137, Constants.HEIGHT/400, 0, Color.BLACK));
		menuAddCourse.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/20));
		menuAddCourse.setBackground(Constants.DARK_BLUE);
		addCourse = new ButtonObj(Constants.BT_ADD_COURSE_ST, controller, Event.ADD_COURSE_ST.toString());
		menuAddCourse.add(addCourse);
		add(menuAddCourse);
	}

	private void initSchedule(Controller controller) {
		JPanel menuSchedule = new JPanel();
		menuSchedule.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT/200, Constants.WIDTH/137, Constants.HEIGHT/400, 0, Color.BLACK));
		menuSchedule.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/20));
		menuSchedule.setBackground(Constants.DARK_BLUE);
		showSchedule = new ButtonObj(Constants.BT_SCHEDULE_ST, controller, Event.SHOW_SCHEDULE.toString());
		menuSchedule.add(showSchedule);
		add(menuSchedule);
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
		panelName.setBorder(BorderFactory.createMatteBorder(Constants.HEIGHT/400, Constants.WIDTH/137, Constants.HEIGHT/400, 0, Color.WHITE));
		panelName.setBackground(Color.WHITE);
		JLabel nameApp = new JLabel(Constants.NAME_APP);
		nameApp.setFont(new Font("Segoe UI", Font.BOLD, Constants.WIDTH/40));
		nameApp.setForeground(Constants.DARK_BLUE);
		return nameApp;
	}

	private JLabel initLogo(JPanel panelLogo) {
		panelLogo.setBackground(Constants.DARK_BLUE);
		JLabel logoApp = new JLabel();
		ImageIcon img= new ImageIcon(new ImageIcon(getClass().getResource(
				Constants.PATH_APP_ICON)).getImage().getScaledInstance(
						Constants.WIDTH/7, Constants.WIDTH/7, Image.SCALE_SMOOTH));
		logoApp.setIcon(img);
		return logoApp;
	}
}