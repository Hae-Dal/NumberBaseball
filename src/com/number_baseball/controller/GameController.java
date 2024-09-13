package com.number_baseball.controller;

import com.number_baseball.Exceptions.IllegalInputException;
import com.number_baseball.enumeration.Status;
import com.number_baseball.model.GameModel;
import com.number_baseball.view.GameView;

import java.util.HashMap;
import java.util.Scanner;

import static com.number_baseball.enumeration.Status.*;

public class GameController {
    private final GameView gv;
    private final GameModel gm;

    public GameController() {
        this.gv = new GameView();
        this.gm = new GameModel();
    }

    public void start() {
        HashMap<Status, Integer> status;

        gv.displayGame();

        while (true) {
            gv.displayInputMessage("답을 입력해주세요 :");
            String input = input();

            status = isAnswer(input);

            if (status.get(STRIKE) != 3) {
                gv.displayInputResult(isAnswer(input));
            } else {
                gv.displayEndMessage();
                end();
            }
        }

    }

    public String input() {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        // 세 자리 수 인지 판별
        if (s.length() != 3) {
            throw new IllegalInputException("답은 세자리 수 입니다.");
        }

        // 같은 숫자를 입력했는지 확인
        for (int i = 0; i < s.length(); i++) {
            if (s.replace(String.valueOf(s.charAt(i)), "").length() != 2) {
                throw new IllegalInputException("각각의 숫자는 모두 달라야합니다.");
            }
        }

        // 숫자로만 이루어져 있는지 확인
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalInputException("숫자만 입력해야합니다.");
        }


        return s;
    }

    public HashMap<Status, Integer> isAnswer(String input) {
        HashMap<Status, Integer> status = new HashMap<>();

        status.put(STRIKE, 0);
        status.put(BALL, 0);
        status.put(OUT, 0);

        for (int j = 0; j < input.length(); j++) {
            if (gm.getAnswer().indexOf(input.charAt(j)) == -1) {
                status.put(OUT, status.get(OUT) + 1);
            } else if (gm.getAnswer().indexOf(input.charAt(j)) == j) {
                status.put(STRIKE, status.get(STRIKE) + 1);
            } else if (gm.getAnswer().indexOf(input.charAt(j)) != j) {
                status.put(BALL, status.get(BALL) + 1);
            }
        }

        return status;
    }

    public void end() {
        System.exit(0);
    }
}
