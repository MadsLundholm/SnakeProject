package client.presentation.panels;

import client.SDK.model.Score;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
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

        imageBackground = new ImageIcon(getClass().getResource("/client/presentation/imgSrc/highscore.jpg"));
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

    public void setTableShowHighscore(ArrayList<Score> scores) {
        HighscoreTableModel highscoreTableModel = new HighscoreTableModel(scores);
        tableShowHighscore.setModel(highscoreTableModel);
    }

    private class HighscoreTableModel extends AbstractTableModel {
        private static final long serialVersionUID = 1L;
        public static final int USERNAME = 0;
        public static final int SCORE = 1;
        public static final int GAME_ID = 2;

        private ArrayList<Score> highscores;
        private String[] columns = {"USERNAME", "SCORE", "GAME ID"};
        private int numberOfRows;

        public HighscoreTableModel(ArrayList<Score> highscores) {
            this.highscores = highscores;
            fireTableStructureChanged();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() {
            numberOfRows = highscores.size();
            return numberOfRows;
        }

        public String getColumnName(int columnIndex) {

            return columns[columnIndex];

        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {

                case USERNAME:
                    return highscores.get(rowIndex).getGame().getWinner().getUsername();
                case SCORE:
                    return highscores.get(rowIndex).getScore();
                case GAME_ID:
                    return highscores.get(rowIndex).getGame().getGameId();

            }
            return null;
        }

    }
}
