package com.number_baseball.view;

import java.util.List;

public class GameView {
    public void displayGame() {
        System.out.println("""
                < 게임 시작 >
                """);
    }

    public void displayInputResult(List<Integer> status) {
        System.out.println(status.get(0) + " 스트라이크, " + status.get(1) + " 볼" + status.get(2) + " 아웃");
    }

    public void displayException(Exception e) {
        System.out.println(e.getMessage());
    }
}
