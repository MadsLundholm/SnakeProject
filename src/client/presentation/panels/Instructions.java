package client.presentation.panels;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Instructions extends JPanel
{

	private static final long serialVersionUID = -6560824147938225127L;
	private JLabel lblBackground;
	private ImageIcon imageBackground;
	private JButton btnBack;

	public Instructions()
	{
		setSize(700, 440);
		setLayout(null);

		btnBack = new JButton("BACK");
		btnBack.setBounds(10, 332, 83, 23);
		add(btnBack);

		//TODO: lav instructions-baggrund
		imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/highscore.jpg"));
		lblBackground = new JLabel(imageBackground);
		lblBackground.setBounds(0, 0, 684, 402);
		add(lblBackground);
	}

	public void addActionListener(ActionListener l)
	{
		btnBack.addActionListener(l);
	}

	public JButton getBtnBack() {return btnBack;}
}
