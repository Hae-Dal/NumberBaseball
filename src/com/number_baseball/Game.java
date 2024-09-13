package com.number_baseball;

import com.number_baseball.controller.GameController;
import com.number_baseball.view.GameView;

import java.util.Scanner;

import static com.number_baseball.enumeration.InputType.MENU;

public class Game {
    GameController gc;
    GameView gv;

    Game() {
        this.gc = new GameController();
        this.gv = new GameView();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            gv.displayMenu();
            String s = sc.next();
            try {
                if (MENU.isValid(s)) {
                    switch (s) {
                        case "1" : {
                            gc.start();
                            break;
                        }
                        case "3" : {
                            gc.end();
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                gv.displayException(e);
            }
        }
    }
}
