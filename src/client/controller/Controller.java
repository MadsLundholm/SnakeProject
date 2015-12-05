package client.controller;


import client.SDK.SDKController;
import client.SDK.model.Game;
import client.SDK.model.Gamer;
import client.SDK.model.User;
import client.presentation.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
	private Screen screen;
	private SDKController sdkController;
	private User currentUser;
	private ArrayList<User> users;
	private ArrayList<Game> games;

	public Controller() {
		screen = new Screen();
		screen.setVisible(true);

		sdkController = new SDKController();
		currentUser = new User();
	}

	public void run() {
		screen.show(Screen.LOGINMENU);
		screen.getLoginMenu().addActionListener(new LoginActionListener());
		screen.getCreateGame().addActionListener(new CreateGameActionListener());
		screen.getDeleteGame().addActionListener(new DeleteGameActionListener());
		screen.getHighscore().addActionListener(new HighscoreActionListener());
		screen.getUserMenu().addActionListener(new UserMenuActionListener());
		screen.getJoinGame().addActionListener(new JoinGameActionListener());
	}

	private class LoginActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getLoginMenu().getBtnLogin()) {

				try {
					currentUser.setUsername(screen.getLoginMenu().getTxtUserName().getText());
					currentUser.setPassword(screen.getLoginMenu().getTxtPassword().getText());
					String loginMessage = sdkController.login(currentUser);

					if (loginMessage.equals("Login successful"))
					{
						screen.show(Screen.USERMENU);
					}
					else
					{
						JOptionPane.showMessageDialog(screen, loginMessage, "Invalid input", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(screen, "Missing username and password. Try again", "Missing input", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private class UserMenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getUserMenu().getBtnJoinGame())
			{
				games = sdkController.getGames(currentUser.getId());
				screen.getJoinGame().setGamesInComboBox(games);
				screen.show(Screen.JOINGAME);
			}
			else if (e.getSource() == screen.getUserMenu().getBtnDeleteGame())
			{
				games = sdkController.getGames(currentUser.getId());
				screen.getDeleteGame().setGamesInComboBox(games);
				screen.show(Screen.DELETEGAME);
			}

			else if (e.getSource() == screen.getUserMenu().getBtnCreateGame())
			{
				users = sdkController.getUsers();
				screen.getCreateGame().setUserInComboBox(users);
				screen.show(Screen.CREATEGAME);
			}
			else if (e.getSource() == screen.getUserMenu().getBtnHighscore())
			{
				screen.show(Screen.HIGHSCORE);
			}
			else if (e.getSource() == screen.getUserMenu().getBtnLogOff())
			{
				//TODO: husk at tilføje "" for alle textfields
				//Resetting textfields
				screen.getLoginMenu().getTxtPassword().setText("");
				screen.getLoginMenu().getTxtUserName().setText("");
				screen.getCreateGame().getTxtGameName().setText("");
				screen.show(Screen.LOGINMENU);
			}
		}
	}

	private class CreateGameActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (e.getSource() == screen.getCreateGame().getBtnBack())
				{
					screen.show((Screen.USERMENU));
				}

				else if (e.getSource() == screen.getCreateGame().getBtnCreateGame()) {
					Game createGame = new Game();
					createGame.setName(screen.getCreateGame().getTxtGameName().getText());
					createGame.setMapSize((Integer) screen.getCreateGame().getComboBoxMapSize().getSelectedItem());
					createGame.setName(screen.getCreateGame().getSelectedUSer());

					Gamer opponent = new Gamer();
					for (User u: users)
					{
						if (u.getUsername() == screen.getCreateGame().getSelectedUSer())
						{
							opponent.setId(u.getId());
						}
					}
					createGame.setOpponent(opponent);

					Gamer host = new Gamer();
					host.setId(currentUser.getId());
					host.setControls(screen.getCreateGame().getTxtControls().getText());
					createGame.setHost(host);

					String createGameMessage = sdkController.createGame(createGame);

					JOptionPane.showMessageDialog(screen, createGameMessage, "Game created", JOptionPane.INFORMATION_MESSAGE);
					screen.show(Screen.USERMENU);
				}
			}
			catch (NumberFormatException e2)
			{
				JOptionPane.showMessageDialog(screen, "Controls needs to be W,A,S,D", "Create game failed", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private class HighscoreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getHighscore().getBtnBack())
			{
				screen.show(Screen.USERMENU);
			}
		}
	}

	private class DeleteGameActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getDeleteGame().getBtnBack())
			{
				screen.show((Screen.USERMENU));
			}

			else if (e.getSource() == screen.getDeleteGame().getBtnDeleteGame())
			{
				Game deleteGame = new Game();
				deleteGame.setName(screen.getDeleteGame().getSelectedGame());
				for (Game game: games)
				{
					if (game.getName() == screen.getDeleteGame().getSelectedGame())
					{
						deleteGame = game;
					}
				}
				String message = sdkController.deleteGame(deleteGame.getGameId());
				JOptionPane.showMessageDialog(screen, message);
			}

		}
	}

	private class JoinGameActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == screen.getJoinGame().getBtnBack())
			{
				screen.show(Screen.USERMENU);
			}

			else if (e.getSource() == screen.getJoinGame().getBtnJoinGame())
			{
				String winnerName = "";
				Game joinGame = new Game();
				for (Game game: games)
				{
					if (game.getName() == (screen.getJoinGame().getSelectedGame()))
					{
						joinGame = game;
					}
				}

				Gamer opponent = new Gamer();
				opponent.setId(currentUser.getId());
				opponent.setControls(screen.getJoinGame().getTxtControl().getText());
				joinGame.setOpponent(opponent);

				String joinGameMessage = sdkController.joinGame(joinGame);
				String startGameMessage = sdkController.startGame(joinGame);

				for (User u : users) {
					if (u.getId() == Integer.parseInt(startGameMessage)) {
						winnerName = u.getUsername();
					}
				}
				JOptionPane.showMessageDialog(screen, joinGameMessage + ". The winner was:" + winnerName);
			}
		}
	}
}