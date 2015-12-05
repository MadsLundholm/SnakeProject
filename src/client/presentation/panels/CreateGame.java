package client.presentation.panels;

import client.SDK.model.User;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateGame extends JPanel  {
	private static final long serialVersionUID = -6560824147938225127L;
	private JLabel lblBackground;
	private ImageIcon imageBackground;
	private JButton btnBack;
	private JButton btnCreateGame;
	private JTextField txtGameName;
	private JTextField txtMapSize;
	private JLabel lblGameName;
	private JLabel lblControls;
	private JTextField txtControls;
	private JTextField txtOpponentId;
	private JComboBox comboBoxMapSize;
	private JComboBox comboBoxChooseOpponent;

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
		lblControls.setBounds(158, 253, 95, 20);
		add(lblControls);

		JLabel lblMapSize = new JLabel("MAPSIZE");
		lblMapSize.setBounds(158, 208, 95, 20);
		add(lblMapSize);

		Integer [] mapSize = {10, 15, 20, 25};
		comboBoxMapSize = new JComboBox(mapSize);
		comboBoxMapSize.setSelectedIndex(3);
		comboBoxMapSize.setBounds(278, 201, 211, 34);
		add(comboBoxMapSize);

		lblGameName = new JLabel("GAMENAME");
		lblGameName.setBounds(158, 166, 95, 20);
		add(lblGameName);

		imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/createGame.jpg"));

		JLabel lblOpponentId = new JLabel("OPPONENT ID");
		lblOpponentId.setBounds(158, 298, 95, 20);
		add(lblOpponentId);

		txtOpponentId = new JTextField();
		txtOpponentId.setBounds(278, 291, 211, 34);
		add(txtOpponentId);

		/*comboBoxChooseOpponent = new JComboBox();
		comboBoxChooseOpponent.setBounds(278, 291, 211, 34);
		add(comboBoxChooseOpponent);*/

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

	public String getSelectedUSer(){
		return (String) comboBoxChooseOpponent.getSelectedItem();
	}

	public JComboBox getComboBoxMapSize() {
		return comboBoxMapSize;
	}

	public JComboBox getComboBoxChooseOpponent() {
		return comboBoxChooseOpponent;
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnCreateGame() {
		return btnCreateGame;
	}

	public JTextField getTxtGameName() {
		return txtGameName;
	}

	public JTextField getTxtOpponentId() {
		return txtOpponentId;
	}

	public JTextField getTxtMapSize() {return txtMapSize;}

	public JTextField getTxtControls() {return txtControls;}
}