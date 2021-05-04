package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.Event;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameField, passwordField, userField;
	private JPanel info, login;
	private boolean isHidePassword, isCreateAccount, isConfirmAccount;
	private JLabel infoData, msjLogin, userConfirm, passwordConfirm;
	private ButtonObj changeAccount, accept, acceptAccount, cancelAccount, showPass;

	public LoginPanel(ActionListener actionListener) {
		setLayout(new BorderLayout(0, ConstantsGUI.HEIGHT / 10));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder(0, ConstantsGUI.WIDTH / 5, 0, ConstantsGUI.WIDTH / 5));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		createInfoPanel();
		createLoginPanel(actionListener);
		initBooleans();
	}

	private void createInfoPanel() {
		info = new JPanel(new BorderLayout(0, 0));
		info.setBackground(ConstantsGUI.DARK_BLUE);
		info.setPreferredSize(new Dimension(ConstantsGUI.WIDTH, ConstantsGUI.HEIGHT / 5));
		initInfo();
		add(info, BorderLayout.NORTH);
	}

	private void initInfo() {
		JLabel iconApp = new JLabel();
		ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource(ConstantsGUI.PATH_APP_ICON)).getImage()
				.getScaledInstance(ConstantsGUI.WIDTH / 10, ConstantsGUI.WIDTH / 10, Image.SCALE_SMOOTH));
		iconApp.setIcon(img);
		info.add(iconApp, BorderLayout.WEST);

		JLabel nameApp = new JLabel(ConstantsGUI.NAME_APP);
		nameApp.setFont(new Font("Segoe UI", Font.PLAIN, 50));
		nameApp.setForeground(Color.WHITE);
		nameApp.setAlignmentX(LEFT_ALIGNMENT);
		info.add(nameApp, BorderLayout.CENTER);
	}

	private void createLoginPanel(ActionListener actionListener) {
		login = new JPanel(new BorderLayout(ConstantsGUI.WIDTH / 10, 0));
		login.setBackground(Color.WHITE);
		login.setBorder(
				BorderFactory.createEmptyBorder(0, ConstantsGUI.WIDTH / 10, ConstantsGUI.HEIGHT / 10, ConstantsGUI.WIDTH / 10));

		initLogin(actionListener);

		add(login, BorderLayout.CENTER);
	}

	private void initLogin(ActionListener actionListener) {
		infoData = new JLabel(ConstantsGUI.INFO_LOGIN);
		infoData.setFont(ConstantsGUI.DEFAULT_FONT_ITALIC_MAX);
		infoData.setForeground(Color.GRAY);
		infoData.setAlignmentX(CENTER_ALIGNMENT);
		login.add(infoData, BorderLayout.NORTH);

		JPanel containerLogin = new JPanel(new GridBagLayout());
		containerLogin.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		containerLogin.setBackground(Color.WHITE);
		GridBagConstraints constraints = new GridBagConstraints();
		
		nameField = new JTextField();
		nameField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE),
				"Nombre", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		nameField.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 10));
		nameField.setFont(ConstantsGUI.DEFAULT_FONT);
		nameField.setForeground(Color.BLACK);
		nameField.setVisible(false);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 0, 1, 1);
		containerLogin.add(nameField, constraints);

		userField = new JTextField();
		userField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE),
				"Usuario", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		userField.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 10));
		userField.setFont(ConstantsGUI.DEFAULT_FONT);
		userField.setForeground(Color.BLACK);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 1, 1, 1);
		containerLogin.add(userField, constraints);

		passwordField = new JTextField();
		passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(ConstantsGUI.DARK_BLUE),
				"Contraseña", TitledBorder.LEFT, TitledBorder.TOP, ConstantsGUI.DEFAULT_FONT_MIN, ConstantsGUI.DARK_BLUE));
		passwordField.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 4, ConstantsGUI.HEIGHT / 10));
		passwordField.setFont(ConstantsGUI.DEFAULT_FONT);
		passwordField.setForeground(Color.BLACK);
		passwordField.setSelectionColor(ConstantsGUI.DARK_BLUE);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 2, 1, 1);
		containerLogin.add(passwordField, constraints);

		showPass = new ButtonObj("", actionListener, Event.HIDE_PASSWORD.toString(), ConstantsGUI.PATH_EYE_ICON);
		showPass.setPreferredSize(new Dimension(ConstantsGUI.WIDTH / 40, ConstantsGUI.WIDTH / 40));
		showPass.setBackground(Color.WHITE);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 2, 2, 1, 1);
		containerLogin.add(showPass, constraints);

		accept = new ButtonObj("Aceptar", actionListener, Event.GET_LOGIN_DATA.toString(), ConstantsGUI.DARK_BLUE);
		accept.setFont(ConstantsGUI.DEFAULT_FONT);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 3, 1, 1);
		containerLogin.add(accept, constraints);

		msjLogin = new JLabel(ConstantsGUI.MSJ_LOGIN_ACCOUNT);
		msjLogin.setFont(ConstantsGUI.DEFAULT_FONT);
		msjLogin.setForeground(Color.GRAY);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 4, 2, 1);
		containerLogin.add(msjLogin, constraints);

		changeAccount = new ButtonObj(ConstantsGUI.BT_CREATE_ACCOUNT, actionListener, Event.LOGIN_ACCOUNT.toString(), ConstantsGUI.DARK_BLUE);
		changeAccount.setFont(ConstantsGUI.DEFAULT_FONT);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 5, 1, 1);
		containerLogin.add(changeAccount, constraints);

		userConfirm = new JLabel();
		userConfirm.setFont(ConstantsGUI.DEFAULT_FONT);
		userConfirm.setForeground(Color.GRAY);
		userConfirm.setVisible(false);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 6, 1, 1);
		containerLogin.add(userConfirm, constraints);

		passwordConfirm = new JLabel();
		passwordConfirm.setFont(ConstantsGUI.DEFAULT_FONT);
		passwordConfirm.setForeground(Color.GRAY);
		passwordConfirm.setVisible(false);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 7, 1, 1);
		containerLogin.add(passwordConfirm, constraints);

		acceptAccount = new ButtonObj("Crear", actionListener, Event.GET_CREATE_DATA.toString(), ConstantsGUI.DARK_BLUE);
		acceptAccount.setFont(ConstantsGUI.DEFAULT_FONT);
		acceptAccount.setVisible(false);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 0, 3, 1, 1);
		containerLogin.add(acceptAccount, constraints);

		cancelAccount = new ButtonObj("Cancelar", actionListener, Event.CANCEL_NEW_ACCOUNT.toString(), ConstantsGUI.DARK_BLUE);
		cancelAccount.setFont(ConstantsGUI.DEFAULT_FONT);
		cancelAccount.setVisible(false);
		GridBagConstrainsForm.gridBagConstrainsForm(constraints, 1, 3, 1, 1);
		containerLogin.add(cancelAccount, constraints);

		login.add(containerLogin, BorderLayout.CENTER);
	}

	private void initBooleans() {
		isHidePassword = false;
		isCreateAccount = false;
		isConfirmAccount = false;
	}

	public void hidePassword() {
		if (!isHidePassword) {
			isHidePassword = true;
			passwordField.setForeground(Color.WHITE);
			passwordField.setSelectedTextColor(ConstantsGUI.DARK_BLUE);
			passwordField.setSelectionColor(ConstantsGUI.DARK_BLUE);
		} else {
			isHidePassword = false;
			passwordField.setForeground(Color.BLACK);
			passwordField.setSelectedTextColor(Color.WHITE);
			passwordField.setSelectionColor(ConstantsGUI.DARK_BLUE);
		}
	}
	

	public void loginAccount() {
		if (!isCreateAccount) {
			isCreateAccount = true;
			showPass.setVisible(false);
			nameField.setVisible(true);
			passwordField.setForeground(Color.BLACK);
			passwordField.setText("");
			infoData.setText(ConstantsGUI.INFO_CREATE);
			msjLogin.setText(ConstantsGUI.MSJ_LOGIN_ACCOUNT);
			changeAccount.setText(ConstantsGUI.BT_LOGIN_ACCOUNT);
		} else {
			isCreateAccount = false;
			showPass.setVisible(true);
			nameField.setVisible(false);
			infoData.setText(ConstantsGUI.INFO_LOGIN);
			msjLogin.setText(ConstantsGUI.MSJ_CREATE_ACCOUNT);
			changeAccount.setText(ConstantsGUI.BT_CREATE_ACCOUNT);
		}
	}

	public String getLoginData() {
		if (!isCreateAccount) {
			return userField.getText() + "," + passwordField.getText();
		} else {
			msjLogin.setText("�Estas seguro?");
			passwordField.setEditable(false);
			userField.setEditable(false);
			nameField.setEditable(false);
			infoData.setText(ConstantsGUI.CONFIRM_DATA);
			changeAccount.setVisible(false);
			userConfirm.setText("Usuario:" + userField.getText());
			userConfirm.setVisible(true);
			passwordConfirm.setText("Contrasena: " + passwordField.getText());
			accept.setVisible(false);
			passwordConfirm.setVisible(true);
			acceptAccount.setVisible(true);
			cancelAccount.setVisible(true);
			if (isConfirmAccount) {
				if (nameField.getText().equalsIgnoreCase("") || userField.getText().equalsIgnoreCase("") ||
						passwordField.getText().equalsIgnoreCase("")) {
					return "vacio";
				}else {
					return nameField.getText()+","+userField.getText() + "," + passwordField.getText();
				}
			} else {
				isConfirmAccount = true;
				if (nameField.getText().equalsIgnoreCase("") || userField.getText().equalsIgnoreCase("") ||
						passwordField.getText().equalsIgnoreCase("")) {
					resetLogin();
					return "vacio";
				}else {
					return "confirmAccount";
				}
			}
		}
	}

	public void resetLogin() {
		nameField.setVisible(false);
		nameField.setEditable(true);
		nameField.setText("");
		userField.setText("");
		passwordField.setText("");
		showPass.setVisible(true);
		msjLogin.setText(ConstantsGUI.MSJ_LOGIN_ACCOUNT);
		accept.setActionCommand(Event.GET_LOGIN_DATA.toString());
		isCreateAccount = false;
		userField.setEditable(true);
		passwordField.setEditable(true);
		infoData.setText(ConstantsGUI.INFO_LOGIN);
		changeAccount.setVisible(true);
		changeAccount.setText(ConstantsGUI.BT_CREATE_ACCOUNT);
		userConfirm.setText("");
		userConfirm.setVisible(false);
		passwordConfirm.setText("");
		accept.setVisible(true);
		passwordConfirm.setVisible(false);
		acceptAccount.setVisible(false);
		cancelAccount.setVisible(false);
		isConfirmAccount = false;
	}

	public boolean isCreate() {
		return isCreateAccount;
	}
}