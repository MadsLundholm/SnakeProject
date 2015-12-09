package SDK;

import SDK.dto.Game;
import SDK.dto.Score;
import SDK.dto.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mads Lundholm 23/11 2015
 */
public class SDKController {

    //Objects that are used in the methods below
    ServerConnection serverConnection = new ServerConnection();
    Gson gson = new Gson();
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = new JSONObject();

    //Method is the Login-function
    //Receives data in currentUser from Controller, which is submitted to the server through post
    //Returns message to determine where ether user has permission to login
    public String login(User currentUser) {
        String dataLogin = serverConnection.post(gson.toJson(currentUser), "login/");

        jsonObject = null;
        try {
            Object object = parser.parse(dataLogin);
            jsonObject = (JSONObject) object;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {
            if (jsonObject.get("userid") != null) currentUser.setId((int) (long) jsonObject.get("userid"));

            return (String) jsonObject.get("message");
        }

        return "";
    }

    //Method creates game and currentUsers/host controls and challenge opponent
    //Receives createGame from controller and makes use of post (submitting data) to the server
    //Returns message from server to the Controller to determine what to happen next
    public Object createGame(Game createGame) {
        //Sending and converting object to JSON with Gson
        String dataCreateGame = gson.toJson(createGame);
        String message = serverConnection.post(dataCreateGame, "games/");

        //Receiving message from JSON
        HashMap hashMap = gson.fromJson(message, HashMap.class);
        return hashMap.get("message");
    }

    //Method enables opponent to take up the challenge
    //Receives joinGame from Controller and put (update) the server
    //Returns message to the client to determinate what to happen next
    public Object joinGame(Game joinGame) {
        String data = serverConnection.put(gson.toJson(joinGame), "games/join");
        HashMap hashMap = gson.fromJson(data, HashMap.class);

        return hashMap.get("message");
    }

    //Method determines winner
    //Receives joinGame from Controller and put (update) the server
    //Returns a winner to the Controller
    public Object executeGame(Game joinGame) {
        String data = serverConnection.put(gson.toJson(joinGame), "games/start");
        HashMap hashMap = gson.fromJson(data, HashMap.class);

        if (hashMap.get("message") != null)
            return hashMap.get("message");
        else {
            Game g = gson.fromJson(data, Game.class);
            joinGame.setWinner(g.getWinner());
            return joinGame.getWinner().getId() + "";
        }
    }

    //Method delete Games
    //Receives data from deleteGame and make use of HTTP method delete in serverConnection
    //Returns message to method DeleteGameActionListener in Controller
    public Object deleteGame(int deleteGame) {
        String data = serverConnection.delete("games/" + deleteGame);
        HashMap hashMap = gson.fromJson(data, HashMap.class);

        return hashMap.get("message");
    }

    //ArrayList containing users
    public ArrayList<User> getUsers() {
        String data = serverConnection.get("users/");
        return gson.fromJson(data, new TypeToken<ArrayList<User>>() {
        }.getType());
    }

    //ArrayList containing scores
    public ArrayList<Score> getHighScores() {
        String data = serverConnection.get("highscores/");
        return gson.fromJson(data, new TypeToken<ArrayList<Score>>() {
        }.getType());
    }

    //ArrayList containing games
    //Receives userID
    //Used in joinGame to see pending games for currentUser
    public ArrayList<Game> getGames(int userID) {
        String data = serverConnection.get("games/pending/" + userID);
        return gson.fromJson(data, new TypeToken<ArrayList<Game>>() {
        }.getType());
    }

}