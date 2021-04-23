package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Controller;
import controller.Event;

public class LoginPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final String NAME_APP = "Xorder";
	private JTextField password;
	private JPanel info, login;
	private boolean isHidePassword, isCreateAccount;
	private JLabel infoData, msjLogin;
	private JButton changeAccount;
	
	public LoginPanel(Controller controller) {
		setLayout(new BorderLayout(0, Constants.HEIGHT/10));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH/5, 0, Constants.WIDTH/5));
		info = new JPanel(new BorderLayout(0, 0));
		login = new JPanel(new BorderLayout(Constants.WIDTH/10, 0));
		isHidePassword = false;
		isCreateAccount = false;
		initLoginPanel(controller);		
	}

	private void initLoginPanel(Controller controller) {
		initInfo();
		initLogin(controller);
	}

	private void initLogin(Controller controller) {
		login.setBackground(Color.WHITE);
		login.setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH/10, Constants.HEIGHT/10, Constants.WIDTH/10));
		
		infoData = new JLabel(Constants.INFO_LOGIN);
		infoData.setFont(Constants.DEFAULT_FONT_BOLD_MAX);
		infoData.setForeground(Color.GRAY);
		infoData.setAlignmentX(CENTER_ALIGNMENT);
		login.add(infoData, BorderLayout.NORTH);

		JPanel containerLogin = new JPanel(new GridBagLayout());
		JTextField user = new JTextField();
		password = new JTextField();
		msjLogin = new JLabel(Constants.MSJ_LOGIN_ACCOUNT);
		JButton accept = new JButton("Aceptar");
		changeAccount = new JButton(Constants.BT_CREATE_ACCOUNT);
		JButton showPass = new JButton();
		showPass.setPreferredSize(new Dimension(30, 30));
		showPass.setBackground(Color.WHITE);
		showPass.addActionListener(controller);
		showPass.setActionCommand(Event.HIDE_PASSWORD.toString());
		
		ImageIcon img= new ImageIcon(new ImageIcon(getClass().getResource(
				Constants.PATH_EYE_ICON)).getImage().getScaledInstance(
						Constants.WIDTH/40, Constants.WIDTH/40, Image.SCALE_SMOOTH));
		showPass.setIcon(img);
		
		user.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Usuario", TitledBorder.LEFT , TitledBorder.TOP, Constants.DEFAULT_FONT_MIN, Constants.DARK_BLUE));
		user.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/10));
		user.setFont(Constants.DEFAULT_FONT);
		user.setForeground(Color.BLACK);
		
		password.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Contraseña", TitledBorder.LEFT , TitledBorder.TOP, Constants.DEFAULT_FONT_MIN, Constants.DARK_BLUE));
		password.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/10));
		password.setFont(Constants.DEFAULT_FONT);
		password.setForeground(Color.BLACK);
		password.setSelectionColor(Constants.DARK_BLUE);
		
		msjLogin.setFont(Constants.DEFAULT_FONT);
		msjLogin.setForeground(Color.GRAY);
		
		accept.setFont(Constants.DEFAULT_FONT);
		accept.setForeground(Color.WHITE);
		accept.setBackground(Constants.DARK_BLUE);
		accept.setFocusable(false);
		
		changeAccount.setFont(Constants.DEFAULT_FONT);
		changeAccount.setForeground(Constants.DARK_BLUE);
		changeAccount.setBackground(Color.WHITE);
		changeAccount.setFocusable(false);
		changeAccount.setActionCommand(Event.LOGIN_ACCOUNT.toString());
		changeAccount.addActionListener(controller);
		
		containerLogin.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		containerLogin.setBackground(Color.WHITE);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(user, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(password, constraints);
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(showPass, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(accept, constraints);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		containerLogin.add(msjLogin, constraints);
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(changeAccount, constraints);

		login.add(containerLogin, BorderLayout.CENTER);
		
		add(login, BorderLayout.CENTER);
	}

	private void initInfo() {
		info.setBackground(Constants.DARK_BLUE);
		info.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT/5));
		JLabel iconApp = new JLabel();
		ImageIcon img= new ImageIcon(new ImageIcon(getClass().getResource(
				Constants.PATH_APP_ICON)).getImage().getScaledInstance(
						Constants.WIDTH/10, Constants.WIDTH/10, Image.SCALE_SMOOTH));
		iconApp.setIcon(img);
		info.add(iconApp, BorderLayout.WEST);
		add(info, BorderLayout.NORTH);
		
		JLabel nameApp = new JLabel(NAME_APP);
		nameApp.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		nameApp.setForeground(Color.WHITE);
		nameApp.setAlignmentX(LEFT_ALIGNMENT);
		info.add(nameApp, BorderLayout.CENTER);
	}

	public void hidePassword() {
		if (!isHidePassword) {
			isHidePassword = true;
			password.setForeground(Color.WHITE);
			password.setSelectedTextColor(Constants.DARK_BLUE);
			password.setSelectionColor(Constants.DARK_BLUE);
		}else {
			isHidePassword = false;
			password.setForeground(Color.BLACK);
			password.setSelectedTextColor(Color.WHITE);
			password.setSelectionColor(Constants.DARK_BLUE);
		}
	}

	public void loginAccount() {
		if (!isCreateAccount) {
			isCreateAccount = true;
			infoData.setText(Constants.INFO_CREATE);
			msjLogin.setText(Constants.MSJ_LOGIN_ACCOUNT);
			changeAccount.setText(Constants.BT_LOGIN_ACCOUNT);
		}else {
			isCreateAccount = false;
			infoData.setText(Constants.INFO_LOGIN);
			msjLogin.setText(Constants.MSJ_CREATE_ACCOUNT);
			changeAccount.setText(Constants.BT_CREATE_ACCOUNT);
		}
	}
}
