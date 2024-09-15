package com.number_baseball.controller;

import com.number_baseball.Exceptions.IllegalInputException;
import com.number_baseball.enumeration.InputType;
import com.number_baseball.enumeration.Status;
import com.number_baseball.service.GameService;
import com.number_baseball.view.GameView;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static com.number_baseball.enumeration.InputType.ANSWER;
import static com.number_baseball.enumeration.InputType.MENU;
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

        while (true) {
            try {
                gv.displayInputMessage("숫자를 입력하세요. ");
                String input = input(ANSWER);

                if (input == null) {
                    continue;
                }

                status = isAnswer(input);

                if (status.get(STRIKE) != gs.getCurrentGame().getDifficulty().getAnswerLength()) {
                    gv.displayInputResult(isAnswer(input));
                    gs.addGameTryNum();
                } else {
                    gv.displayEndMessage();
                    String s = input(MENU);
                    if (Objects.equals(s, "1")) {
                        break;
                    } else if (Objects.equals(s, "2")) {
                        gs.removeCurrentGame();
                    } else if (Objects.equals(s, "3")) {
                        end();
                    }
                }
            } catch (IllegalInputException e) {
                gv.displayException(e);
            }

        }

    }

    public String input(InputType type) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        type.isValid(s);

        return s;
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
