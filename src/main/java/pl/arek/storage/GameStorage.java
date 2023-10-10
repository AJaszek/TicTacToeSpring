/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.arek.storage;

import java.util.HashMap;
import java.util.Map;
import pl.arek.model.Game;

/**
 *
 * @author Arek
 */
public class GameStorage {

    private Map<String, Game> games;
    private static GameStorage instance;

    private GameStorage() {
        games = new HashMap();
    }

    public static synchronized GameStorage getInstance() {
        if (instance == null) {
            instance = new GameStorage();
        }

        return instance;
    }

    public Map<String, Game> getGames() {
        return games;
    }

    public void setGame(Game game) {
        games.put(game.getGameId(), game);
    }
}
