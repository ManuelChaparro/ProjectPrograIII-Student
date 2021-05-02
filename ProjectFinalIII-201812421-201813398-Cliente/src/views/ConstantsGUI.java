package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class ConstantsGUI{
	
	//Colors
	public static final Color DARK_BLUE = Color.decode("#2D366F");
	public static final Color DARK_YELLOW = Color.decode("#EC9C11");
	public static final Color DARK_RED = Color.decode("#BB0001");
	public static final Color LIGHT_BLUE = Color.decode("#128DCC");
	public static final Color DARK_PURPLE = Color.decode("#5A277E");
	
	//Panels
	public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	//Paths
	public static final String PATH_APP_ICON = "/img/iconApp.jpg";
	public static final String PATH_EYE_ICON = "/img/eyeIcon.png";
	
	//Fonts
	public static final Font DEFAULT_FONT = new Font("Segoe UI", Font.PLAIN, 20);
	public static final Font DEFAULT_FONT_BOLD = new Font("Segoe UI", Font.BOLD, 20);
	public static final Font DEFAULT_FONT_ITALIC_MAX = new Font("Segoe UI", Font.ITALIC, ConstantsGUI.WIDTH/55);
	public static final Font DEFAULT_FONT_MAX = new Font("Segoe UI", Font.PLAIN, 30);
	public static final Font DEFAULT_FONT_MAX_BOLD = new Font("Segoe UI", Font.BOLD, 30);
	public static final Font DEFAULT_FONT_MIN = new Font("Segoe UI", Font.PLAIN, 15);
	
	//Days
	public static final String[] DAYS = {"HORAS", "LUNES", "MARTES", "MIERCOLES" , "JUEVES" , "VIERNES" , "SABADO" , "DOMINGO"};

	//Constants
	public static final int TOTAL_HOURS = 15;
	public static final int TOTAL_DAYS = 8;
	public static final String NAME_APP = "Xorder";
	public static final String INFO_LOGIN = "INICIO DE SESION";
	public static final String INFO_CREATE = "CREAR NUEVA CUENTA";
	public static final String MSJ_CREATE_ACCOUNT = "�No tienes una cuenta? �Crea una nueva!";
	public static final String MSJ_LOGIN_ACCOUNT = "�Tienes una cuenta? �Inicia Sesion!";
	public static final String BT_CREATE_ACCOUNT = "Crear cuenta";
	public static final String BT_LOGIN_ACCOUNT = "Iniciar sesion";
	public static final String CONFIRM_DATA = "CONFIRMAR DATOS";
	public static final String BT_ADD_COURSE_ST = "Inscribir Asignatura";
	public static final String BT_MODIFY_COURSE_ST = "Agregar/Modificar Tarea";
	public static final String BT_DELETE_COURSE_ST = "Cancelar Tarea/Asignatura";
	public static final String BT_ADD_OR_MOD_ACTIVITY_ST = "Agregar/Modificar Actividad";
	public static final String BT_AVG_ST = "Calcular Promedios";
	public static final String BT_DELETE_ACTIVITY_ST = "Cancelar actividad";
	public static final String BT_SCHEDULE_ST = "Horario";
	public static final String EMPTY_STRING = "";
	public static final String SEPARATOR_DOT_AND_COMA = ";";
	public static final String SEPARATOR_Y_ESPECIAL = "&";
	public static final String SEPARATOR_NUMERAL = "#";
	public static final String SEPARATOR_PERCENT = "%";

	public static final String STUDENT_TEXT_CARDLAYOUT = "Student";
	public static final String LOGIN_TEXT_CARDLAYOUT = "Login";
	public static final String TITLE_WINDOW = "Xorder-Usuario";
	public static final Font DEFAULT_FONT_WELCOME_MESSAGE = new Font("Segoe UI", Font.BOLD, (int) (ConstantsGUI.WIDTH/19.4));
	public static final String WELCOME_MESSAGE = "Bienvenido";
	public static final String AVERAGE_TEXT_CARDLAYOUT = "Average";
	public static final String DELETE_ACTIVITY_CARDLAYOUT = "DeleteActivity";
	public static final String MODIFY_ACTIVITY_CARDLAYOUT = "ModifyActivity";
	public static final String DELETE_COURSE_TEXT_CARDLAYOUT = "DeleteCourse";
	public static final String MODIFY_COURSE_TEXT_CARDLAYOUT = "ModifyCourse";
	public static final String ADD_COURSE_TEXT_CARDLAYOUT = "AddCourse";
	public static final String SCHEDULE_TEXT_CARDLAYOUT = "Schedule";
	public static final Border BORDER_NAME_LABEL_USER_WELCOME = BorderFactory.createEmptyBorder(0, 0, (int) (ConstantsGUI.HEIGHT/7.68), 0);
	public static final Font DEFAULT_FONT_USER_WELCOME = new Font("Segoe UI", Font.BOLD, (int) (ConstantsGUI.WIDTH/25));
}
