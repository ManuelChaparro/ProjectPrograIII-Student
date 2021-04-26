package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
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
	private JTextField passwordField, userField;
	private JPanel info, login;
	private boolean isHidePassword, isCreateAccount, isConfirmAccount;
	private JLabel infoData, msjLogin, userConfirm, passwordConfirm;
	private JButton changeAccount, accept, acceptAccount, cancelAccount, showPass;
	
	public LoginPanel(Controller controller) {
		setLayout(new BorderLayout(0, Constants.HEIGHT/10));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH/5, 0, Constants.WIDTH/5));
		
		info = new JPanel(new BorderLayout(0, 0));
		login = new JPanel(new BorderLayout(Constants.WIDTH/10, 0));
		
		msjLogin = new JLabel(Constants.MSJ_LOGIN_ACCOUNT);
		userConfirm = new JLabel();
		passwordConfirm = new JLabel();
		infoData = new JLabel(Constants.INFO_LOGIN);
		
		accept = new JButton("Aceptar");
		acceptAccount = new JButton("Aceptar");
		cancelAccount = new JButton("Cancelar");
		changeAccount = new JButton(Constants.BT_CREATE_ACCOUNT);
		showPass = new JButton();
		
		userField = new JTextField();
		passwordField = new JTextField();
		
		initBooleans();
		initLoginPanel(controller);		
	}

	private void initBooleans() {
		isHidePassword = false;
		isCreateAccount = false;
		isConfirmAccount = false;
	}

	private void initLoginPanel(Controller controller) {
		initInfo();
		initLogin(controller);
	}

	private void initLogin(Controller controller) {
		login.setBackground(Color.WHITE);
		login.setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH/10, Constants.HEIGHT/10, Constants.WIDTH/10));
		
		
		infoData.setFont(Constants.DEFAULT_FONT_ITALIC_MAX);
		infoData.setForeground(Color.GRAY);
		infoData.setAlignmentX(CENTER_ALIGNMENT);
		login.add(infoData, BorderLayout.NORTH);

		JPanel containerLogin = new JPanel(new GridBagLayout());



		showPass.setPreferredSize(new Dimension(Constants.WIDTH/40, Constants.WIDTH/40));
		showPass.setBackground(Color.WHITE);
		showPass.addActionListener(controller);
		showPass.setActionCommand(Event.HIDE_PASSWORD.toString());
		
		ImageIcon img= new ImageIcon(new ImageIcon(getClass().getResource(
				Constants.PATH_EYE_ICON)).getImage().getScaledInstance(
						Constants.WIDTH/40, Constants.WIDTH/40, Image.SCALE_SMOOTH));
		showPass.setIcon(img);
		
		userField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Usuario", TitledBorder.LEFT , TitledBorder.TOP, Constants.DEFAULT_FONT_MIN, Constants.DARK_BLUE));
		userField.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/10));
		userField.setFont(Constants.DEFAULT_FONT);
		userField.setForeground(Color.BLACK);
		
		passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Contraseña", TitledBorder.LEFT , TitledBorder.TOP, Constants.DEFAULT_FONT_MIN, Constants.DARK_BLUE));
		passwordField.setPreferredSize(new Dimension(Constants.WIDTH/4, Constants.HEIGHT/10));
		passwordField.setFont(Constants.DEFAULT_FONT);
		passwordField.setForeground(Color.BLACK);
		passwordField.setSelectionColor(Constants.DARK_BLUE);
		
		msjLogin.setFont(Constants.DEFAULT_FONT);
		msjLogin.setForeground(Color.GRAY);
		
		accept.setFont(Constants.DEFAULT_FONT);
		accept.setForeground(Color.WHITE);
		accept.setBackground(Constants.DARK_BLUE);
		accept.setFocusable(false);
		accept.addActionListener(controller);
		accept.setActionCommand(Event.GET_LOGIN_DATA.toString());
		
		changeAccount.setFont(Constants.DEFAULT_FONT);
		changeAccount.setForeground(Constants.DARK_BLUE);
		changeAccount.setBackground(Color.WHITE);
		changeAccount.setFocusable(false);
		changeAccount.setActionCommand(Event.LOGIN_ACCOUNT.toString());
		changeAccount.addActionListener(controller);
		
		userConfirm.setFont(Constants.DEFAULT_FONT);
		userConfirm.setForeground(Color.GRAY);
		userConfirm.setVisible(false);
		
		passwordConfirm.setFont(Constants.DEFAULT_FONT);
		passwordConfirm.setForeground(Color.GRAY);
		passwordConfirm.setVisible(false);
		
		acceptAccount.setFont(Constants.DEFAULT_FONT);
		acceptAccount.setForeground(Color.WHITE);
		acceptAccount.setBackground(Constants.DARK_BLUE);
		acceptAccount.setFocusable(false);
		acceptAccount.setVisible(false);
		acceptAccount.addActionListener(controller);
		acceptAccount.setActionCommand(Event.GET_LOGIN_DATA.toString());
		
		cancelAccount.setFont(Constants.DEFAULT_FONT);
		cancelAccount.setForeground(Color.WHITE);
		cancelAccount.setBackground(Constants.DARK_BLUE);
		cancelAccount.setFocusable(false);
		cancelAccount.setVisible(false);
		cancelAccount.addActionListener(controller);
		cancelAccount.setActionCommand(Event.CANCEL_NEW_ACCOUNT.toString());
		
		containerLogin.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		containerLogin.setBackground(Color.WHITE);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(userField, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(passwordField, constraints);
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
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(userConfirm, constraints);
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(passwordConfirm, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(acceptAccount, constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(cancelAccount, constraints);


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
		
		JLabel nameApp = new JLabel(Constants.NAME_APP);
		nameApp.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		nameApp.setForeground(Color.WHITE);
		nameApp.setAlignmentX(LEFT_ALIGNMENT);
		info.add(nameApp, BorderLayout.CENTER);
	}

	public void hidePassword() {
		if (!isHidePassword) {
			isHidePassword = true;
			passwordField.setForeground(Color.WHITE);
			passwordField.setSelectedTextColor(Constants.DARK_BLUE);
			passwordField.setSelectionColor(Constants.DARK_BLUE);
		}else {
			isHidePassword = false;
			passwordField.setForeground(Color.BLACK);
			passwordField.setSelectedTextColor(Color.WHITE);
			passwordField.setSelectionColor(Constants.DARK_BLUE);
		}
	}

	public void loginAccount() {
		if (!isCreateAccount) {
			isCreateAccount = true;
			showPass.setVisible(false);
			passwordField.setForeground(Color.BLACK);
			passwordField.setText("");
			infoData.setText(Constants.INFO_CREATE);
			msjLogin.setText(Constants.MSJ_LOGIN_ACCOUNT);
			changeAccount.setText(Constants.BT_LOGIN_ACCOUNT);
		}else {
			isCreateAccount = false;
			showPass.setVisible(true);
			infoData.setText(Constants.INFO_LOGIN);
			msjLogin.setText(Constants.MSJ_CREATE_ACCOUNT);
			changeAccount.setText(Constants.BT_CREATE_ACCOUNT);
		}
	}

	public String getLoginData() {
		if (!isCreateAccount) {
			return "iniciosesion: "+userField.getText()+","+passwordField.getText();
		}else {
			msjLogin.setText("¿Estas seguro?");
			passwordField.setEditable(false);
			userField.setEditable(false);
			infoData.setText(Constants.CONFIRM_DATA);
			changeAccount.setVisible(false);
			userConfirm.setText("Usuario:" +userField.getText());
			userConfirm.setVisible(true);
			passwordConfirm.setText("Contraseña: " + passwordField.getText());
			accept.setVisible(false);
			passwordConfirm.setVisible(true);
			acceptAccount.setVisible(true);
			cancelAccount.setVisible(true);
			if (isConfirmAccount) {
				return "crearcuenta: "+userField.getText()+","+passwordField.getText();
			}else {
				isConfirmAccount = true;
				return "confirmAccount";
			}
		}
	}

	public void resetLogin() {
		showPass.setVisible(true);
		msjLogin.setText(Constants.MSJ_LOGIN_ACCOUNT);
		accept.setActionCommand(Event.GET_LOGIN_DATA.toString());
		isCreateAccount = false;
		userField.setEditable(true);
		passwordField.setEditable(true);
		infoData.setText(Constants.INFO_LOGIN);
		changeAccount.setVisible(true);
		userConfirm.setText("");
		userConfirm.setVisible(false);
		passwordConfirm.setText("");
		accept.setVisible(true);
		passwordConfirm.setVisible(false);
		acceptAccount.setVisible(false);
		cancelAccount.setVisible(false);
		isConfirmAccount = false;
		changeAccount.setText(Constants.BT_LOGIN_ACCOUNT);
	}
}
