package com.number_baseball.service;

import com.number_baseball.enumeration.Difficulty;
import com.number_baseball.model.GameModel;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static GameService gameService;
    private final ArrayList<GameModel> games;
    private int current;

    private GameService() {
        games = new ArrayList<>();
        current = -1;
    }

    public static GameService getInstance() {
        if (gameService == null) {
            gameService = new GameService();
        }
        return gameService;
    }

    public void setNewGame(Difficulty difficulty) {
        games.add(new GameModel(difficulty));
        current++;
    }

    public void removeCurrentGame() {
        games.remove(games.get(current));
        current--;
    }

    public GameModel getCurrentGame() {
        return games.get(current);
    }

    public void addGameTryNum() {
        games.get(current).addTryNum();
    }

    public List<Integer> getGameTryNums() {
        List<Integer> nums = new ArrayList<>();

        for (GameModel g : games) {
            nums.add(g.getTryNum());
        }

        return nums;
    }
}
