package client.SDK;

import client.SDK.model.Game;
import client.SDK.model.Score;
import client.SDK.model.User;
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

    ServerConnection serverConnection = new ServerConnection();

    //login Receives data in currentUser from Controller
    //Login makes use of post, where you submit data
    public String login(User currentUser) {
        String data = serverConnection.post(new Gson().toJson(currentUser), "login/");

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = null;
        try {
            Object object = parser.parse(data);
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

    public String createGame(Game game) {
        String json = new Gson().toJson(game);
        String message = serverConnection.post(json, "games/");

        HashMap<String, String> hashMap = new Gson().fromJson(message, HashMap.class);
        return hashMap.get("message");
    }

    public String joinGame(Game joinGame) {
        String data = serverConnection.put(new Gson().toJson(joinGame), "games/join");
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

        return hashMap.get("message");
    }

    public String executeGame(Game joinGame) {
        String data = serverConnection.put(new Gson().toJson(joinGame), "games/start");
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

        if (hashMap.get("message") != null)
            return hashMap.get("message");
        else {
            Game g = new Gson().fromJson(data, Game.class);
            joinGame.setWinner(g.getWinner());
            return joinGame.getWinner().getId()+ "";
        }
    }

    public String deleteGame(int deleteGame) {
        String data = serverConnection.delete("games/" + deleteGame);
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

        return hashMap.get("message");
    }

    public ArrayList<User> getUsers() {
        String data = serverConnection.get("users/");
        return new Gson().fromJson(data, new TypeToken<ArrayList<User>>() {
        }.getType());
    }

    public ArrayList<Score> getHighScores() {

        String data = serverConnection.get("highscores/");
        return new Gson().fromJson(data, new TypeToken<ArrayList<Score>>() {
        }.getType());
    }

    public ArrayList<Game> getGames(int userID) {
        String data = serverConnection.get("games/pending/" + userID);
        return new Gson().fromJson(data, new TypeToken<ArrayList<Game>>() {
        }.getType());
    }

}