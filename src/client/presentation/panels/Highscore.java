package client.presentation.panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;

public class Highscore extends JPanel
{

	private static final long serialVersionUID = -6560824147938225127L;
	private JLabel lblBackground;
	private ImageIcon imageBackground;
	private JButton btnBack;
	private JTable tableShowHighscore;
	private JScrollPane showTableScrollpane;
	private JTableHeader tableHeader;

	public Highscore()
	{
		setSize(700, 440);
		setLayout(null);

		String dat[][] = new String[1][5];
		dat[0][0] = "overskrives";
		dat[0][1] = "overskrives";
		tableShowHighscore = new JTable(new DefaultTableModel(dat, new String[]
						{ "UserID", "TotalScore"}))
		{
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int coloumn)
			{
				return false;
			}
		};
		showTableScrollpane = new JScrollPane(tableShowHighscore);
		showTableScrollpane
		.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		showTableScrollpane.setBounds(10, 133, 663, 188);
		add(showTableScrollpane);

		tableHeader = tableShowHighscore.getTableHeader();
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setBackground(Color.BLACK);

		btnBack = new JButton("BACK");
		btnBack.setBounds(10, 332, 83, 23);
		add(btnBack);

		imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/highscore.jpg"));
		lblBackground = new JLabel(imageBackground);
		lblBackground.setBounds(0, 0, 684, 402);
		add(lblBackground);
	}

	public void addActionListener(ActionListener l)
	{
		btnBack.addActionListener(l);
	}

	public JButton getBtnBack()
	{
		return btnBack;
	}

	public JTable getTableShowHighscore()
	{
		return tableShowHighscore;
	}
}
