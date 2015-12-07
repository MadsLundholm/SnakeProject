package presentation.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserMenu extends JPanel {
    //Declaration
    private JLabel lblBackground;
    private ImageIcon imageBackground;
    private JButton btnLogOff;
    private JButton btnDeleteGame;
    private JButton btnHighscore;
    private JButton btnJoinGame;
    private JButton btnCreateGame;

    public UserMenu() {
        setSize(700, 400);
        setLayout(null);

        btnLogOff = new JButton("LOG OFF");
        btnLogOff.setFont(new Font("Calibri", Font.PLAIN, 13));
        btnLogOff.setBounds(289, 276, 101, 30);
        add(btnLogOff);

        btnHighscore = new JButton("HIGHSCORE");
        btnHighscore.setFont(new Font("Calibri", Font.PLAIN, 13));
        btnHighscore.setBounds(173, 223, 161, 42);
        add(btnHighscore);

        btnJoinGame = new JButton("JOIN GAME");
        btnJoinGame.setFont(new Font("Calibri", Font.PLAIN, 13));
        btnJoinGame.setBounds(173, 170, 161, 42);
        add(btnJoinGame);

        btnDeleteGame = new JButton("DELETE GAME");
        btnDeleteGame.setBounds(344, 223, 161, 42);
        btnDeleteGame.setFont(new Font("Calibri", Font.PLAIN, 13));
        add(btnDeleteGame);

        imageBackground = new ImageIcon(getClass().getResource("/presentation/imgSrc/userMenu.jpg"));

        btnCreateGame = new JButton("CREATE GAME");
        btnCreateGame.setFont(new Font("Calibri", Font.PLAIN, 13));
        btnCreateGame.setBounds(344, 170, 161, 42);
        add(btnCreateGame);

        lblBackground = new JLabel(imageBackground);
        lblBackground.setBounds(0, 0, 684, 402);
        add(lblBackground);
    }

    public void addActionListener(ActionListener l) {
        btnLogOff.addActionListener(l);
        btnDeleteGame.addActionListener(l);
        btnHighscore.addActionListener(l);
        btnJoinGame.addActionListener(l);
        btnCreateGame.addActionListener(l);
    }

    //Getters
    public JButton getBtnLogOff() {
        return btnLogOff;
    }

    public JButton getBtnDeleteGame() {
        return btnDeleteGame;
    }

    public JButton getBtnHighscore() {
        return btnHighscore;
    }

    public JButton getBtnCreateGame() {
        return btnCreateGame;
    }

    public JButton getBtnJoinGame() {
        return btnJoinGame;
    }
}
