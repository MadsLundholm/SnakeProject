package client.presentation.panels;

import client.SDK.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateGame extends JPanel  {
	private static final long serialVersionUID = -6560824147938225127L;
	private JLabel lblBackground;
	private ImageIcon imageBackground;
	private JButton btnBack;
	private JButton btnCreateGame;
	private JTextField txtGameName;
	private JLabel lblGameName;
	private JLabel lblControls;
	private JTextField txtControls;
	private JComboBox comboBoxMapSize;
	private JComboBox comboBoxChooseOpponent;
	private JLabel lblMapSize;
	private JLabel lblOpponentId;

	public CreateGame() {
		setSize(700, 440);
		setLayout(null);

		txtGameName = new JTextField();
		txtGameName.setColumns(10);
		txtGameName.setBounds(278, 156, 211, 34);
		add(txtGameName);

		btnBack = new JButton("BACK");
		btnBack.setBounds(10, 332, 83, 23);
		add(btnBack);

		btnCreateGame = new JButton("CREATE GAME");
		btnCreateGame.setBounds(365, 332, 125, 23);
		add(btnCreateGame);

		txtControls = new JTextField();
		txtControls.setColumns(10);
		txtControls.setBounds(278, 246, 211, 34);
		add(txtControls);

		lblControls = new JLabel("CONTROLS");
		lblControls.setFont(new Font("Calibri", Font.BOLD, 15));
		lblControls.setForeground(Color.LIGHT_GRAY);
		lblControls.setBounds(158, 253, 95, 20);
		add(lblControls);

		lblMapSize = new JLabel("MAPSIZE");
		lblMapSize.setFont(new Font("Calibri", Font.BOLD, 15));
		lblMapSize.setBounds(158, 208, 95, 20);
		lblMapSize.setForeground(Color.LIGHT_GRAY);
		add(lblMapSize);

		Integer [] mapSize = {10, 15, 20, 25};
		comboBoxMapSize = new JComboBox(mapSize);
		comboBoxMapSize.setSelectedIndex(3);
		comboBoxMapSize.setBounds(278, 201, 211, 34);
		add(comboBoxMapSize);

		lblGameName = new JLabel("GAMENAME");
		lblGameName.setFont(new Font("Calibri", Font.BOLD, 15));
		lblGameName.setBounds(158, 166, 95, 20);
		lblGameName.setForeground(Color.LIGHT_GRAY);
		add(lblGameName);

		imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/createGame.jpg"));

		lblOpponentId = new JLabel("OPPONENT NAME");
		lblOpponentId.setFont(new Font("Calibri", Font.BOLD, 15));
		lblOpponentId.setForeground(Color.LIGHT_GRAY);
		lblOpponentId.setBounds(158, 298, 95, 20);
		add(lblOpponentId);

		comboBoxChooseOpponent = new JComboBox();
		comboBoxChooseOpponent.setBounds(278, 291, 211, 34);
		add(comboBoxChooseOpponent);

		lblBackground = new JLabel(imageBackground);
		lblBackground.setBounds(0, 0, 684, 402);
		add(lblBackground);

	}

	public void addActionListener(ActionListener l) {
		btnBack.addActionListener(l);
		btnCreateGame.addActionListener(l);
	}

	public void setUserInComboBox(ArrayList<User> users)
	{
		comboBoxChooseOpponent.removeAllItems();
		for (User u: users)
		{
			comboBoxChooseOpponent.addItem(u.getUsername());
		}
	}

	public String getSelectedUser(){
		return (String) comboBoxChooseOpponent.getSelectedItem();
	}


	public JComboBox getComboBoxMapSize() {return comboBoxMapSize;}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnCreateGame() {
		return btnCreateGame;
	}

	public JTextField getTxtGameName() {
		return txtGameName;
	}

	public JTextField getTxtControls() {return txtControls;}
}