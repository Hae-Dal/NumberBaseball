package com.number_baseball.enumeration;

import com.number_baseball.service.GameService;
import java.util.Arrays;

public enum Difficulty {
    EASY(3),
    NORMAL(4),
    HARD(5);

    private final int answerLength;

    Difficulty(int d) {
        this.answerLength = d;
    }

    public static Difficulty valueOf(int answerLength) {
        return Arrays.stream(values())
                .filter(val -> answerLength == val.answerLength)
                .findFirst()
                .orElse(null);
    }

    public void gameInit() {
        GameService.getInstance().setNewGame(this);
    };

    public int getAnswerLength() {
        return answerLength;
    }
}
