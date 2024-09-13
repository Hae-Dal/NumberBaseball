package com.number_baseball.view;

import java.util.List;

public class GameView {
    public void displayGame() {
        System.out.println("""
                < 게임 시작 >
                """);
    }

    public void displayInputResult(int[] status) {
        System.out.println(status[0] + " 스트라이크, " + status[1] + " 볼" + status[2] + " 아웃");
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
