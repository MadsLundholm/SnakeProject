package client.presentation;

import client.presentation.panels.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Screen extends JFrame {
	private static final long serialVersionUID = -1471205449918699667L;
	public static final String JOINGAME = "_join_game";
	public static final String GAMEMENU = "_game_menu";
	public static final String CREATEGAME = "_create_Game";
	public static final String DELETEGAME = "_delete_Game";
	public static final String HIGHSCORE = "_highscore";
	public static final String LOGINMENU = "_login_Menu";
	public static final String USERMENU = "_user_Menu";
	public static final String INSTRUCTIONS = "_instructions";
	public static final String STARTGAME = "_start_game";

	private JPanel contentPane;
	private GameMenu gameMenu;
	private LoginMenu loginMenu;
	private UserMenu userMenu;
	private CreateGame createGame;
	private DeleteGame deleteGame;
	private Highscore highscore;
	private JoinGame joinGame;
	private Instructions instructions;
	private StartGame startGame;

	private CardLayout c;

	public Screen() 
	{
		super("SNAKE");
		setSize(700, 440);
		setResizable(false);
		getContentPane().setLayout(null);
		setVisible(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		gameMenu = new GameMenu();
		contentPane.add(gameMenu, GAMEMENU);

		instructions = new Instructions();
		contentPane.add(instructions,INSTRUCTIONS);

		startGame = new StartGame();
		contentPane.add(startGame, STARTGAME);

		joinGame = new JoinGame();
		contentPane.add(joinGame,JOINGAME);

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

	public Highscore getHighscore() {return highscore;}

	public GameMenu getGameMenu() { return gameMenu; }

	public JoinGame getJoinGame () { return joinGame; }

	public StartGame getStartGame() {return startGame;}

	public Instructions getInstructions () { return instructions; }

	public void show(String card) {
		c.show(this.getContentPane(), card);
	}
}
