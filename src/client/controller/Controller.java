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
		screen.getInstructions().addActionListener(new InstructionsActionListener());
		screen.getGameMenu().addActionListener(new GameMenuActionListener());
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
					screen.show(Screen.GAMEMENU);
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
			if (e.getSource() == screen.getUserMenu().getBtnPlay()) {
				screen.show(Screen.GAMEMENU);
			} else if (e.getSource() == screen.getUserMenu().getBtnDeleteGame()) {
				screen.show(Screen.DELETEGAME);
			} else if (e.getSource() == screen.getUserMenu().getBtnHighscore()) {
				screen.show(Screen.HIGHSCORE);
			} else if (e.getSource() == screen.getUserMenu().getBtnInstructions()) {
				screen.show(Screen.INSTRUCTIONS);
			} else if (e.getSource() == screen.getUserMenu().getBtnLogOff()) {
				//TODO: husk at tilføje "" for alle textfields
				//Resetting textfields
				screen.getCreateGame().getTxtMapSize().setText("");
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
			if (e.getSource() == screen.getDeleteGame().getBtnBack()) {


				/*game.setGameId((Integer) screen.getDeleteGame().getTableDeleteGame().getValueAt(screen.getDeleteGame().getTableDeleteGame().getSelectedRow(), 0));
				game.setWinner((Gamer) screen.getDeleteGame().getTableDeleteGame().getValueAt(screen.getDeleteGame().getTableDeleteGame().getSelectedRow(), 1));
				game.setName((String) screen.getDeleteGame().getTableDeleteGame().getValueAt(screen.getDeleteGame().getTableDeleteGame().getSelectedRow(), 2));
				game.setHost((Gamer) screen.getDeleteGame().getTableDeleteGame().getValueAt(screen.getDeleteGame().getTableDeleteGame().getSelectedRow(), 3));
				game.setOpponent((Gamer) screen.getDeleteGame().getTableDeleteGame().getValueAt(screen.getDeleteGame().getTableDeleteGame().getSelectedRow(), 4));
				game.setStatus((String) screen.getDeleteGame().getTableDeleteGame().getValueAt(screen.getDeleteGame().getTableDeleteGame().getSelectedRow(), 5));
				game.setCreated((Date) screen.getDeleteGame().getTableDeleteGame().getValueAt(screen.getDeleteGame().getTableDeleteGame().getSelectedRow(), 6));
				game.setMapSize((Integer) screen.getDeleteGame().getTableDeleteGame().getValueAt(screen.getDeleteGame().getTableDeleteGame().getSelectedRow(), 7));
*/
				/*String message = sdkController.deleteGame(game);
				JOptionPane.showMessageDialog(screen, message, "DELETE GAME", JOptionPane.INFORMATION_MESSAGE);*/

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

	private class InstructionsActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getInstructions().getBtnBack()) {
				screen.show(Screen.USERMENU);
			}
		}
	}

	private class GameMenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == screen.getGameMenu().getBtnCreateGame())
			{
/*				users = sdkController.getUsers();
				screen.getCreateGame().setUserInComboBox(users);*/
				screen.show(Screen.CREATEGAME);
			}

			else if (e.getSource() == screen.getGameMenu().getBtnJoinGame())
			{
				games = sdkController.getGames(currentUser.getId());
				screen.getJoinGame().setGamesInComboBox(games);
				screen.show(Screen.JOINGAME);
			}

			else if (e.getSource() == screen.getGameMenu().getBtnBack())
			{
				screen.show(Screen.USERMENU);
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
					System.out.println(startGameMessage);
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


					/*Gamer opponent = new Gamer();
					opponent.setId(currentUser.getId());
					opponent.setControls(screen.getJoinGame().getTxtControl().getText());

					Game game = new Game();
					game.setGameId(Integer.parseInt(screen.getJoinGame().getTxtGameId().getText()));
					game.setOpponent(opponent);

					String joinGameMessage = sdkController.joinGame(game);
					String startGameMessage = sdkController.startGame(game);

					System.out.println(startGameMessage);

					String winnerName = null;
					for (User user: users)
					{
						if (user.getId() == Integer.parseInt(startGameMessage))
						{
							winnerName = user.getUsername();
						}
					}
					JOptionPane.showMessageDialog(screen, joinGameMessage + "and the winner is....." + winnerName, "Information", JOptionPane.INFORMATION_MESSAGE);
					screen.show(Screen.GAMEMENU);
				}

			}
		}
	}
}
*/
