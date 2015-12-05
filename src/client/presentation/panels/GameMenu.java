package client.presentation.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameMenu extends JPanel {
	private static final long serialVersionUID = 6329565811403487708L;
	private JLabel lblBackground;
	private ImageIcon imageBackground;
	private JButton btnBack;
	private JButton btnCreateGame;
	private JButton btnJoinGame;

	public GameMenu() {
		setSize(700, 440);
		setLayout(null);

		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnBack.setBounds(298, 293, 84, 32);
		add(btnBack);

		btnJoinGame = new JButton("JOIN GAME");
		btnJoinGame.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnJoinGame.setBounds(173, 134, 161, 42);
		add(btnJoinGame);

		btnCreateGame = new JButton("CREATE GAME");
		btnCreateGame.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnCreateGame.setBounds(344, 134, 161, 42);
		add(btnCreateGame);

		imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/play.jpg"));
		lblBackground = new JLabel(imageBackground);
		lblBackground.setBounds(0, 0, 684, 402);
		add(lblBackground);
	}

	public void addActionListener(ActionListener l) 
	{
		btnBack.addActionListener(l);
		btnCreateGame.addActionListener(l);
		btnJoinGame.addActionListener(l);
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnCreateGame() {
		return btnCreateGame;
	}

	public JButton getBtnJoinGame() {
		return btnJoinGame;
	}
}
