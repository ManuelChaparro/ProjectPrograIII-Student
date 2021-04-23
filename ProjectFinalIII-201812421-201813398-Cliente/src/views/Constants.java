package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Constants {
	
	//Colors
	public static final Color DARK_BLUE = Color.decode("#2D366F");
	
	//Panels
	public static final int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	//Paths
	public static final String APP_ICON = "/img/iconApp.jpg";
	
	//Fonts
	public static final Font DEFAULT_FONT = new Font("Segoe UI", Font.PLAIN, 20);
	public static final Font DEFAULT_FONT_BOLD = new Font("Segoe UI", Font.BOLD, 20);
	public static final Font DEFAULT_FONT_BOLD_MAX = new Font("Segoe UI", Font.BOLD, 30);
	public static final Font DEFAULT_FONT_MAX = new Font("Segoe UI", Font.PLAIN, 30);
	public static final Font DEFAULT_FONT_MIN = new Font("Segoe UI", Font.PLAIN, 15);

	//Constants
	public static final String INFO_LOGIN = "INICIO DE SESION";

}
