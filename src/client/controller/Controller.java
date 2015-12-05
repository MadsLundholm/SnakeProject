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
					String message = sdkController.login(currentUser);

					if (message.equals("Login successful"))
					{
						screen.show(Screen.USERMENU);
					}
					else
					{
						JOptionPane.showMessageDialog(screen, message, "Invalid input", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(screen, "Missing username and password. Try again", "Missing input", JOptionPane.ERROR_MESSAGE);
				}
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
					Game game = new Game();
					game.setName(screen.getCreateGame().getTxtGameName().getText());
					game.setMapSize((Integer) screen.getCreateGame().getComboBoxMapSize().getSelectedItem());

					Gamer host = new Gamer();
					host.setId(currentUser.getId());
					host.setControls(screen.getCreateGame().getTxtControls().getText());
					game.setHost(host);

					Gamer opponent = new Gamer();
					opponent.setId(Integer.parseInt(screen.getCreateGame().getTxtOpponentId().getText()));

					game.setOpponent(opponent);
					String message = sdkController.createGame(game);

					JOptionPane.showMessageDialog(screen, message, "Game created", JOptionPane.INFORMATION_MESSAGE);
					screen.show(Screen.USERMENU);
				}
			}
			catch (NumberFormatException e2)
			{
				JOptionPane.showMessageDialog(screen, "Controls needs to be W,A,S,D", "Create game failed", JOptionPane.ERROR_MESSAGE);
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
			} else if (e.getSource() == screen.getUserMenu().getBtnDeleteGame())
			{
				screen.show(Screen.DELETEGAME);}

			else if (e.getSource() == screen.getUserMenu().getBtnCreateGame()) {
				users = sdkController.getUsers();
				screen.getCreateGame().setUserInComboBox(users);
				screen.show(Screen.CREATEGAME);}
			else if (e.getSource() == screen.getUserMenu().getBtnHighscore()) {
				screen.show(Screen.HIGHSCORE);
			} else if (e.getSource() == screen.getUserMenu().getBtnLogOff()) {

				//TODO: husk at tilføje "" for alle textfields
				//Resetting textfields
				screen.getLoginMenu().getTxtPassword().setText("");
				screen.getLoginMenu().getTxtUserName().setText("");
				screen.getCreateGame().getTxtGameName().setText("");
				screen.show(Screen.LOGINMENU);
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
				deleteGame.setGameId(Integer.parseInt(screen.getDeleteGame().getTxtDeleteGame().getText()));

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

			else if (e.getSource() == screen.getJoinGame().getBtnJoinGame()) {
				Game startGame = new Game();
				for (Game g: games)
				{
					if (g.getName() == (screen.getJoinGame().getComboBox().getSelectedItem()))
					{
						startGame = g;
					}
				}
				Gamer opponent = new Gamer();
				opponent.setId(currentUser.getId());
				opponent.setControls(screen.getJoinGame().getTxtControl().getText());
				startGame.setOpponent(opponent);
				String joinGameMessage = sdkController.joinGame(startGame);
				String startGameMessage = sdkController.startGame(startGame);
				//System.out.println(startGameMessage);
				String winnerName = "";

				for (User u : users) {
					//TODO exception
					if (u.getId() == Integer.parseInt(startGameMessage)) {
						winnerName = u.getUsername();
					}
				}
				JOptionPane.showMessageDialog(screen, joinGameMessage + ". The winner was:" + winnerName);
			}
		}
	}
}