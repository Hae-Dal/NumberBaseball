package com.number_baseball.controller;

import com.number_baseball.enumeration.Status;
import com.number_baseball.service.GameService;
import com.number_baseball.view.GameView;

import java.util.HashMap;
import java.util.Scanner;

import static com.number_baseball.enumeration.InputType.ANSWER;
import static com.number_baseball.enumeration.Status.*;

public class GameController {
    private final GameView gv;
    private final GameService gs;

    public GameController() {
        this.gv = new GameView();
        this.gs = GameService.getInstance();
    }

    public void start() {
        HashMap<Status, Integer> status;

        gv.displayGame();
        gs.setNewGame();

        while (true) {
            gv.displayInputMessage("숫자를 입력하세요. ");
            String input = input();

            if (input == null) {
                continue;
            }

            status = isAnswer(input);

            if (status.get(STRIKE) != 3) {
                gv.displayInputResult(isAnswer(input));
                gs.addGameTryNum();
            } else {
                gv.displayEndMessage();
                break;
            }
        }

    }

    public String input() {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        try {
            if (ANSWER.isValid(s)) {
                return s;
            }
        } catch (Exception e) {
            gv.displayException(e);
        }
        return null;
    }

    public HashMap<Status, Integer> isAnswer(String input) {
        HashMap<Status, Integer> status = new HashMap<>();

        status.put(STRIKE, 0);
        status.put(BALL, 0);
        status.put(OUT, 0);

        for (int j = 0; j < input.length(); j++) {
            if (gs.getCurrentGame().getAnswer().indexOf(input.charAt(j)) == -1) {
                status.put(OUT, status.get(OUT) + 1);
            } else if (gs.getCurrentGame().getAnswer().indexOf(input.charAt(j)) == j) {
                status.put(STRIKE, status.get(STRIKE) + 1);
            } else if (gs.getCurrentGame().getAnswer().indexOf(input.charAt(j)) != j) {
                status.put(BALL, status.get(BALL) + 1);
            }
        }

        return status;
    }

    public void showGameLog() {
        gv.displayGameLog(gs.getGameTryNums());
    }

    public void end() {
        gv.displayGameExit();
        System.exit(0);
    }
}
