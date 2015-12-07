package presentation.frame;

import presentation.panels.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Screen extends JFrame {
    //Constants for each panel
    public static final String JOINGAME = "_join_game";
    public static final String CREATEGAME = "_create_Game";
    public static final String DELETEGAME = "_delete_Game";
    public static final String HIGHSCORE = "_highscore";
    public static final String LOGINMENU = "_login_Menu";
    public static final String USERMENU = "_user_Menu";

    //Declaration
    private JPanel contentPane;
    private LoginMenu loginMenu;
    private UserMenu userMenu;
    private CreateGame createGame;
    private DeleteGame deleteGame;
    private Highscore highscore;
    private JoinGame joinGame;

    private CardLayout c;

    public Screen() {
        super("SNAKE");
        //Default settings for all panels
        setSize(700, 440);
        setResizable(false);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        joinGame = new JoinGame();
        contentPane.add(joinGame, JOINGAME);

        loginMenu = new LoginMenu();
        contentPane.add(loginMenu, LOGINMENU);

        userMenu = new UserMenu();
        contentPane.add(userMenu, USERMENU);

        createGame = new CreateGame();
        contentPane.add(createGame, CREATEGAME);

        deleteGame = new DeleteGame();
        contentPane.add(deleteGame, DELETEGAME);

        highscore = new Highscore();
        contentPane.add(highscore, HIGHSCORE);

        c = (CardLayout) getContentPane().getLayout();
    }

    //Getters
    public LoginMenu getLoginMenu() {
        return loginMenu;
    }

    public UserMenu getUserMenu() {
        return userMenu;
    }

    public CreateGame getCreateGame() {
        return createGame;
    }

    public DeleteGame getDeleteGame() {
        return deleteGame;
    }

    public Highscore getHighscore() {
        return highscore;
    }

    public JoinGame getJoinGame() {
        return joinGame;
    }

    public void show(String card) {
        c.show(this.getContentPane(), card);
    }
}
