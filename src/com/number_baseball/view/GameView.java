package com.number_baseball.view;

import com.number_baseball.enumeration.Status;

import java.util.HashMap;

import static com.number_baseball.enumeration.Status.*;

public class GameView {

    public void displayMenu() {
        System.out.print("""
                환영합니다! 원하시는 번호를 입력해주세요
                1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기
                """);
    }

    public void displayGame() {
        System.out.println("""
               < 게임을 시작합니다 >
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
        System.out.println("정답입니다. 축하합니다!\n");
    }
}
