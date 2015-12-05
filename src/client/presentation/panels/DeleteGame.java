package client.presentation.panels;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionListener;

public class DeleteGame extends JPanel
{
	private static final long serialVersionUID = 1496674849914571382L;
	private JLabel lblBackground;
	private ImageIcon imageBackground;
	private JButton btnDeleteGame;
	private JButton btnBack;
	private JTableHeader tableHeader;
	private JScrollPane showTableScrollpane;
	private JTable tableDeleteGame;
	private JTextField txtDeleteGame;
	private JLabel lblDeleteGame;

	public DeleteGame ()
	{
		setSize(700, 440);
		setLayout(null);

		/*String dat[][] = new String[1][8];
		dat[0][0] = "";
		dat[0][1] = "";
		dat[0][2] = "";
		dat[0][3] = "";
		dat[0][4] = "";
		dat[0][5] = "";
		dat[0][6] = "";
		dat[0][7] = "";

		tableDeleteGame = new JTable(new DefaultTableModel(dat, new String[]
				{ "GameId", "Winner", "Name", "Host", "Opponent", "Status", "Created", "MapSize"}))
		{
			public boolean isCellEditable(int row, int coloumn)
			{
				return false;
			}
		};
		showTableScrollpane = new JScrollPane(tableDeleteGame);
		showTableScrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		showTableScrollpane.setBounds(10, 133, 663, 188);
		add(showTableScrollpane);*/

		btnBack = new JButton("BACK");
		btnBack.setBounds(10, 332, 83, 23);
		add(btnBack);

		/*tableHeader = tableDeleteGame.getTableHeader();
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setBackground(Color.BLACK);*/

		btnDeleteGame = new JButton("DELETE SELECTED GAME");
		btnDeleteGame.setBounds(464, 332, 210, 23);
		add(btnDeleteGame);

		txtDeleteGame = new JTextField();
		txtDeleteGame.setColumns(10);
		txtDeleteGame.setBounds(310, 333, 161, 34);
		add(txtDeleteGame);

		lblDeleteGame = new JLabel("DELETE GAME");
		lblDeleteGame.setBounds(231, 342, 69, 14);
		add(lblDeleteGame);

		imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/deleteGame.jpg"));
		lblBackground = new JLabel(imageBackground);
		lblBackground.setBounds(0, 0, 684, 402);
		add(lblBackground);
	}

	public void addActionListener(ActionListener l)
	{
		btnBack.addActionListener(l);
		btnDeleteGame.addActionListener(l);
	}

	public JButton getBtnDeleteGame()
	{
		return btnDeleteGame;
	}

	public JButton getBtnBack()
	{
		return btnBack;
	}

	public JTable getTableDeleteGame()
	{
		return tableDeleteGame;
	}

	public JTextField getTxtDeleteGame() {
		return txtDeleteGame;
	}
}
