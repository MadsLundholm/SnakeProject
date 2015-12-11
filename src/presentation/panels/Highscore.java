package presentation.panels;

import SDK.DTO.Score;
import presentation.tableModels.HighscoreTableModel;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Highscore extends JPanel {
    //Declaration
    private JLabel lblBackground;
    private ImageIcon imageBackground;
    private JButton btnBack;
    private JTable tableShowHighscore;
    private JScrollPane showTableScrollpane;
    private JTableHeader tableHeader;

    public Highscore() {
        setSize(700, 440);
        setLayout(null);

        tableShowHighscore = new JTable();

        showTableScrollpane = new JScrollPane(tableShowHighscore);
        showTableScrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        showTableScrollpane.setBounds(10, 133, 663, 188);
        add(showTableScrollpane);

        tableHeader = tableShowHighscore.getTableHeader();
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setBackground(Color.BLACK);

        btnBack = new JButton("BACK");
        btnBack.setBounds(10, 332, 83, 23);
        add(btnBack);

        imageBackground = new ImageIcon(getClass().getResource("/rsc/imgSrc/highscore.jpg"));
        lblBackground = new JLabel(imageBackground);
        lblBackground.setBounds(0, 0, 684, 402);
        add(lblBackground);
    }

    public void addActionListener(ActionListener l) {
        btnBack.addActionListener(l);
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    //Setting scores into JTable
    public void setTableShowHighscore(ArrayList<Score> scores) {
        HighscoreTableModel highscoreTableModel = new HighscoreTableModel(scores);
        tableShowHighscore.setModel(highscoreTableModel);
    }
}
