package presentation.tableModels;

import SDK.DTO.Score;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Mads on 07-12-2015.
 */
public class HighscoreTableModel extends AbstractTableModel {
    public static final int USERNAME = 0;
    public static final int SCORE = 1;
    public static final int GAME_ID = 2;

    private ArrayList<Score> highScore;
    private String[] columns = {"USERNAME", "SCORE", "GAME ID"};
    private int numberOfRows;

    public HighscoreTableModel(ArrayList<Score> highScore) {
        this.highScore = highScore;
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
        numberOfRows = highScore.size();
        return numberOfRows;
    }

    public String getColumnName(int columnIndex) {

        return columns[columnIndex];

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case USERNAME:
                return highScore.get(rowIndex).getGame().getWinner().getUsername();
            case SCORE:
                return highScore.get(rowIndex).getScore();
            case GAME_ID:
                return highScore.get(rowIndex).getGame().getGameId();
        }
        return null;
    }
}