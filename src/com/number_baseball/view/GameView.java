package com.number_baseball.view;

import com.number_baseball.enumeration.Status;

import java.util.HashMap;

import static com.number_baseball.enumeration.Status.*;

public class GameView {
    public void displayGame() {
        System.out.println("""
                < 게임 시작 >
                """);
    }

    public void displayInputResult(HashMap<Status, Integer> status) {
        System.out.println(status.get(STRIKE) + " 스트라이크 || " + status.get(BALL) + " 볼 || " + status.get(OUT) + " 아웃");
    }

    public void displayException(Exception e) {
        System.out.println(e.getMessage());
    }

    public void displayInputMessage(String message) {
        System.out.print(message);
    }

    public void displayEndMessage() {
        System.out.println("정답입니다. 축하합니다!");
    }
}
