package client.presentation.panels;

import client.SDK.model.Game;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JoinGame extends JPanel
{
	private static final long serialVersionUID = -6560824147938225127L;
	private JLabel lblBackground;
	private ImageIcon imageBackground;
	private JButton btnBack;
	private JButton btnJoinGame;
	private JTable tableShowJoinGame;
	private JScrollPane showTableScrollpane;
	private JTableHeader tableHeader;
	private JTextField txtControl;
	private JComboBox comboBoxJoinGame;
	private JLabel lblGameName;
	private JLabel lblControls;

	public JoinGame()
	{
		setSize(700, 400);
		setLayout(null);

		String dat[][] = new String[1][6];
		dat[0][0] = "";
		dat[0][1] = "";
		dat[0][2] = "";
		dat[0][3] = "";
		dat[0][4] = "";
		dat[0][5] = "";

		tableShowJoinGame = new JTable(new DefaultTableModel(dat, new String[]
				{ "GameID", "Name", "Host", "Status", "Created", "MapSize"}))
				{
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int coloumn)
			{
				return false;
			}
		};
		showTableScrollpane = new JScrollPane(tableShowJoinGame);
		showTableScrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		showTableScrollpane.setBounds(10, 108, 674, 177);
		add(showTableScrollpane);

		tableHeader = tableShowJoinGame.getTableHeader();
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setBackground(Color.BLACK);

		comboBoxJoinGame = new JComboBox();
		comboBoxJoinGame.setBounds(310, 288, 161, 34);
		add(comboBoxJoinGame);

		btnBack = new JButton("BACK");
		btnBack.setBounds(10, 374, 83, 23);
		add(btnBack);

		btnJoinGame = new JButton("JOIN GAME");
		btnJoinGame.setBounds(310, 373, 161, 24);
		add(btnJoinGame);

		imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/joinGame.jpg"));

		txtControl = new JTextField();
		txtControl.setColumns(10);
		txtControl.setBounds(310, 333, 161, 34);
		add(txtControl);

		lblGameName = new JLabel("GAME NAME");
		lblGameName.setFont(new Font("Calibri", Font.BOLD, 15));
		lblGameName.setForeground(Color.LIGHT_GRAY);
		lblGameName.setBounds(231, 297, 69, 14);
		add(lblGameName);

		lblControls = new JLabel("CONTROLS");
		lblControls.setFont(new Font("Calibri", Font.BOLD, 15));
		lblControls.setForeground(Color.LIGHT_GRAY);
		lblControls.setBounds(231, 342, 69, 14);
		add(lblControls);

		lblBackground = new JLabel(imageBackground);
		lblBackground.setBounds(0, 0, 684, 402);
		add(lblBackground);

	}
	public void addActionListener(ActionListener l) {
		btnBack.addActionListener(l);
		btnJoinGame.addActionListener(l);
	}

	public void setGamesInComboBox(ArrayList<Game> games){
		comboBoxJoinGame.removeAllItems();
		for (Game g: games)
		{
			comboBoxJoinGame.addItem(g.getName());
		}
	}

	public String getSelectedGame(){
		return (String) comboBoxJoinGame.getSelectedItem();
	}

	public JButton getBtnBack() {
		return btnBack;
	}

	public JButton getBtnJoinGame() {return btnJoinGame;}

	public JTextField getTxtControl() {
		return txtControl;
	}

	public JComboBox getComboBoxJoinGame() {
		return comboBoxJoinGame;
	}
}