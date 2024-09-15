package com.number_baseball;

import com.number_baseball.controller.GameController;
import com.number_baseball.enumeration.Difficulty;
import com.number_baseball.view.GameView;

import static com.number_baseball.enumeration.InputType.DIFFICULTY;
import static com.number_baseball.enumeration.InputType.MENU;

public class Game {
    GameController gc;
    GameView gv;

    Game() {
        this.gc = new GameController();
        this.gv = new GameView();
    }

    public void start() {
        while (true) {
            try {
                gv.displayMenu();
                String s = gc.input(MENU);

                switch (s) {
                    case "1" : {
                        gv.displayDifficultySetting();
                        Difficulty difficulty = Difficulty.valueOf(Integer.parseInt(gc.input(DIFFICULTY)));
                        difficulty.gameInit();
                        gc.start();
                        break;
                    }
                    case "2" : {
                        gc.showGameLog();
                        break;
                    }
                    case "3" : {
                        gc.end();
                        break;
                    }
                }
            } catch (Exception e) {
                gv.displayException(e);
            }
        }

    }
}
