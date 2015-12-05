package client.SDK;

import client.SDK.model.Game;
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

    // The following two methods: login and createGame makes use of post (submitting data)

    public String login(User currentUser)
    {
        String data = serverConnection.post(new Gson().toJson(currentUser), "login/");

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = null;
        try {
            Object object = parser.parse(data);
            jsonObject = (JSONObject) object;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null)
        {
            if (jsonObject.get("userid") != null) currentUser.setId((int)(long) jsonObject.get("userid"));

            return(String) jsonObject.get("message");
        }

        return "";
    }

    public String createGame(Game game)
    {
        String json = new Gson().toJson(game);
        String message = serverConnection.post(json, "games/");

        HashMap<String, String> hashMap = new Gson().fromJson(message, HashMap.class);
        return hashMap.get("message");
    }

    public String joinGame(Game startGame) {
        String data = serverConnection.put(new Gson().toJson(startGame), "games/join");
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

        return hashMap.get("message");
    }

    public String startGame(Game startGame) {
        String data = serverConnection.put(new Gson().toJson(startGame), "games/start");
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

        if (hashMap.get("message") != null)
            return hashMap.get("message");
        else {
            Game g = new Gson().fromJson(data, Game.class);
            startGame.setWinner(g.getWinner());
            System.out.println(g.getName());
            return startGame.getWinner().getId()+ "";
        }
    }

    public ArrayList<Game> getGames(int userID) {
        String data = serverConnection.get("games/pending/" + userID);
        return new Gson().fromJson(data, new TypeToken<ArrayList<Game>>() {
        }.getType());
    }

    public ArrayList<User> getUsers() {
        String data = serverConnection.get("users/");
        return new Gson().fromJson(data, new TypeToken<ArrayList<User>>() {}.getType());
    }


    public String deleteGame(int deleteGame) {
        String data = serverConnection.delete("games/" + deleteGame);
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

        return hashMap.get("message");
    }
}