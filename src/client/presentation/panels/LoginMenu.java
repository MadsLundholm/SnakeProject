package client.presentation.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginMenu extends JPanel {
	private static final long serialVersionUID = -4224626924544727062L;
	private JLabel lblBackground;
	private ImageIcon imageBackground; 
	private JLabel lblPassword;
	private JLabel lblUserName;
	private JPasswordField password;
	private JTextField email;
	private JButton btnLogin;

	public LoginMenu() {
		setLayout(null);

		lblUserName = new JLabel("USERNAME");
		lblUserName.setFont(new Font("Calibri", Font.BOLD, 13));
		lblUserName.setBounds(224, 148, 126, 75);
		add(lblUserName);

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 13));
		lblPassword.setBounds(224, 190, 126, 75);
		add(lblPassword);

		email = new JTextField();
		email.setBounds(318, 174, 140, 25);
		email.setColumns(10);
		add(email);

		password = new JPasswordField();
		password.setBounds(318, 216, 140, 25);
		add(password);

		btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(345, 252, 113, 23);
		add(btnLogin);
				
		imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/loginMenu.jpg"));
		lblBackground = new JLabel(imageBackground);
		lblBackground.setBounds(0, 0, 684, 402);
		add(lblBackground);
	}
	
	public JTextField getTxtUserName() {
		return email;
	}

	public JTextField getTxtPassword() {return password;}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void addActionListener(ActionListener e) {
		btnLogin.addActionListener(e);	
	}
}
