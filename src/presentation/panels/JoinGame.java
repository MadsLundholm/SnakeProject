package presentation.panels;

import SDK.DTO.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JoinGame extends JPanel {
    //Declaration
    private JLabel lblBackground;
    private ImageIcon imageBackground;
    private JButton btnBack;
    private JButton btnJoinGame;
    private JTextField txtControl;
    private JComboBox comboBoxJoinGame;
    private JLabel lblGameName;
    private JLabel lblControls;

    public JoinGame() {
        setSize(700, 400);
        setLayout(null);

        comboBoxJoinGame = new JComboBox();
        comboBoxJoinGame.setBounds(318, 154, 161, 34);
        add(comboBoxJoinGame);

        btnBack = new JButton("BACK");
        btnBack.setBounds(10, 332, 83, 23);
        add(btnBack);

        btnJoinGame = new JButton("JOIN GAME");
        btnJoinGame.setBounds(318, 244, 161, 24);
        add(btnJoinGame);

        imageBackground = new ImageIcon(getClass().getResource("/rsc/imgSrc/joinGame.jpg"));

        txtControl = new JTextField();
        txtControl.setColumns(10);
        txtControl.setBounds(318, 199, 161, 34);
        add(txtControl);

        lblGameName = new JLabel("GAME NAME");
        lblGameName.setFont(new Font("Calibri", Font.BOLD, 15));
        lblGameName.setForeground(Color.LIGHT_GRAY);
        lblGameName.setBounds(165, 165, 152, 14);
        add(lblGameName);

        lblControls = new JLabel("CONTROLS (W,A,S,D)");
        lblControls.setFont(new Font("Calibri", Font.BOLD, 15));
        lblControls.setForeground(Color.LIGHT_GRAY);
        lblControls.setBounds(165, 210, 152, 14);
        add(lblControls);

        lblBackground = new JLabel(imageBackground);
        lblBackground.setBounds(0, 0, 684, 402);
        add(lblBackground);
    }

    public void addActionListener(ActionListener l) {
        btnBack.addActionListener(l);
        btnJoinGame.addActionListener(l);
    }

    //Adding gameName into JComboBox
    public void AddGamesInComboBox(ArrayList<Game> games) {
        comboBoxJoinGame.removeAllItems();
        for (Game g : games) {
            comboBoxJoinGame.addItem(g.getName());
        }
    }

    //Get chosen Game - returns a String - used in Controller
    public String getChosenGame() {
        return (String) comboBoxJoinGame.getSelectedItem();
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnJoinGame() {
        return btnJoinGame;
    }

    public JTextField getTxtControl() {
        return txtControl;
    }
}