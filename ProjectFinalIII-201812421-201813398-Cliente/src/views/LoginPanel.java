package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.rmi.activation.ActivationGroupID;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String NAME_APP = "NAME_APP";
	private JPanel info, login;
	
	public LoginPanel() {
		setLayout(new BorderLayout(0, Constants.HEIGHT/10));
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH/5, 0, Constants.WIDTH/5));
		info = new JPanel(new BorderLayout(Constants.WIDTH/5, 0));
		login = new JPanel(new BorderLayout(Constants.WIDTH/10, 0));
		initLoginPanel();		
	}

	private void initLoginPanel() {
		initInfo();
		initLogin();
	}

	private void initLogin() {
		
		login.setBackground(Color.WHITE);
		login.setBorder(BorderFactory.createEmptyBorder(0, Constants.WIDTH/10, Constants.HEIGHT/10, Constants.WIDTH/10));
		
		JLabel infoData = new JLabel(Constants.INFO_LOGIN);
		infoData.setFont(Constants.DEFAULT_FONT_BOLD_MAX);
		infoData.setForeground(Color.GRAY);
		infoData.setAlignmentX(CENTER_ALIGNMENT);
		login.add(infoData, BorderLayout.NORTH);

		JPanel containerLogin = new JPanel(new GridBagLayout());
		JTextField user = new JTextField();
		JTextField password = new JTextField();
		JLabel infoNewUser = new JLabel("No tienes una cuenta? Crea una nueva!");
		JButton accept = new JButton("Aceptar");
		JButton createAccount = new JButton("Crear cuenta");
		
		user.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Usuario", TitledBorder.LEFT , TitledBorder.TOP, Constants.DEFAULT_FONT_MIN, Constants.DARK_BLUE));
		user.setPreferredSize(new Dimension(Constants.WIDTH/3, Constants.HEIGHT/10));
		user.setFont(Constants.DEFAULT_FONT);
		user.setForeground(Color.BLACK);
		
		password.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Constants.DARK_BLUE), "Contraseña", TitledBorder.LEFT , TitledBorder.TOP, Constants.DEFAULT_FONT_MIN, Constants.DARK_BLUE));
		password.setPreferredSize(new Dimension(Constants.WIDTH/3, Constants.HEIGHT/10));
		password.setFont(Constants.DEFAULT_FONT);
		password.setForeground(Color.BLACK);
		
		infoNewUser.setFont(Constants.DEFAULT_FONT);
		infoNewUser.setForeground(Color.GRAY);
		
		accept.setFont(Constants.DEFAULT_FONT);
		accept.setForeground(Color.WHITE);
		accept.setBackground(Constants.DARK_BLUE);
		accept.setFocusable(false);
		
		createAccount.setFont(Constants.DEFAULT_FONT);
		createAccount.setForeground(Constants.DARK_BLUE);
		createAccount.setBackground(Color.WHITE);
		createAccount.setFocusable(false);

		
		containerLogin.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		containerLogin.setBackground(Color.WHITE);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		containerLogin.add(user, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		containerLogin.add(password, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 3;
		constraints.gridheight = 2;
		containerLogin.add(infoNewUser, constraints);
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		containerLogin.add(createAccount, constraints);
		constraints.gridx = 2;
		constraints.gridy = 4;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		accept.setAlignmentX(RIGHT_ALIGNMENT);
		containerLogin.add(accept, constraints);

		login.add(containerLogin, BorderLayout.CENTER);
		
		add(login, BorderLayout.CENTER);
	}

	private void initInfo() {
		info.setBackground(Constants.DARK_BLUE);
		info.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT/5));
		add(info, BorderLayout.NORTH);
	}

}
