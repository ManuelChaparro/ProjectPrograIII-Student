package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Constants {
	
	//Colors
	public static final Color DARK_BLUE = Color.decode("#2D366F");
	public static final Color DARK_YELLLOW = Color.decode("#EC9C11");
	
	//Panels
	public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	//Paths
	public static final String PATH_APP_ICON = "/img/iconApp.jpg";
	public static final String PATH_EYE_ICON = "/img/eyeIcon.png";
	
	//Fonts
	public static final Font DEFAULT_FONT = new Font("Segoe UI", Font.PLAIN, 20);
	public static final Font DEFAULT_FONT_BOLD = new Font("Segoe UI", Font.BOLD, 20);
	public static final Font DEFAULT_FONT_ITALIC_MAX = new Font("Segoe UI", Font.ITALIC, 30);
	public static final Font DEFAULT_FONT_MAX = new Font("Segoe UI", Font.PLAIN, 30);
	public static final Font DEFAULT_FONT_MIN = new Font("Segoe UI", Font.PLAIN, 15);
	
	//Days
	public static final String[] DAYS = {"HORAS", "LUNES", "MARTES", "MIERCOLES" , "JUEVES" , "VIERNES" , "SABADO" , "DOMINGO"};

	//Constants
	public static final int TOTAL_HOURS = 24;
	public static final int TOTAL_DAYS = 8;
	public static final String NAME_APP = "Xorder";
	public static final String INFO_LOGIN = "INICIO DE SESION";
	public static final String INFO_CREATE = "CREAR NUEVA CUENTA";
	public static final String MSJ_CREATE_ACCOUNT = "¿No tienes una cuenta? ¡Crea una nueva!";
	public static final String MSJ_LOGIN_ACCOUNT = "¿Tienes una cuenta? ¡Inicia Sesion!";
	public static final String BT_CREATE_ACCOUNT = "Crear cuenta";
	public static final String BT_LOGIN_ACCOUNT = "Iniciar sesion";
	public static final String CONFIRM_DATA = "CONFIRMAR DATOS";
	public static final String BT_ADD_COURSE_ST = "Añadir curso";
	public static final String BT_MODIFY_COURSE_ST = "Modificar curso";
	public static final String BT_DELETE_COURSE_ST = "Borrar curso";
	public static final String BT_ADD_ACTIVITY_ST = "Añadir actividad";
	public static final String BT_MODIFY_ACTIVITY_ST = "Modificar actividad";
	public static final String BT_DELETE_ACTIVITY_ST = "Borrar actividad";
	public static final String BT_SCHEDULE_ST = "Horario";

}
