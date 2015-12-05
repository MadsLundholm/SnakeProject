package client.presentation.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserMenu extends JPanel {
	private static final long serialVersionUID = 6329565811403487708L;
	private JLabel lblBackground;
	private ImageIcon imageBackground; 
	private JButton btnLogOff;
	private JButton btnDeleteGame;
	private JButton btnHighscore;
	private JButton btnInstructions;
	private JButton btnPlay;

	public UserMenu() {
		setSize(700,440);
		setLayout(null);

		btnLogOff = new JButton("LOG OFF");
		btnLogOff.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnLogOff.setBounds(298, 276, 84, 32);
		add(btnLogOff);

		btnHighscore = new JButton("HIGHSCORE");
		btnHighscore.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnHighscore.setBounds(173, 223, 161, 42);
		add(btnHighscore);

		btnInstructions = new JButton("INSTRUCTIONS");
		btnInstructions.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnInstructions.setBounds(344, 223, 161, 42);
		add(btnInstructions);

		btnPlay = new JButton("START GAME");
		btnPlay.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnPlay.setBounds(173, 170, 161, 42);
		add(btnPlay);

		btnDeleteGame = new JButton("DELETE GAME");
		btnDeleteGame.setBounds(344, 170, 161, 42);
		btnDeleteGame.setFont(new Font("Calibri", Font.PLAIN, 13));
		add(btnDeleteGame);

		imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/userMenu.jpg"));
		lblBackground = new JLabel(imageBackground);
		lblBackground.setBounds(0, 0, 684, 402);
		add(lblBackground);
	}

	public void addActionListener(ActionListener l) 
	{
		btnLogOff.addActionListener(l);
		btnPlay.addActionListener(l);
		btnDeleteGame.addActionListener(l);
		btnHighscore.addActionListener(l);
		btnInstructions.addActionListener(l);
	}

	public JButton getBtnLogOff() {
		return btnLogOff;
	}

	public JButton getBtnPlay() {
		return btnPlay;
	}

	public JButton getBtnDeleteGame() {
		return btnDeleteGame;
	}

	public JButton getBtnHighscore() {
		return btnHighscore;
	}

	public JButton getBtnInstructions() {
		return btnInstructions;
	}

}
