package com.number_baseball.view;

import com.number_baseball.enumeration.Status;

import java.util.HashMap;
import java.util.List;

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

    public void displayGameLog(List<Integer> logs) {
        System.out.print("""
                < 게임 기록 보기 >""");
        for (int i = 0; i < logs.size(); i++) {
            System.out.println(i+1 + "번째 게임 : 시도 횟수 - " + logs.get(i));
        }
    }

    public void displayException(Exception e) {
        System.out.println(e.getMessage());
    }

    public void displayInputMessage(String message) {
        System.out.print(message);
    }

    public void displayGameExit() {System.out.println("< 게임을 종료합니다. >");}

    public void displayEndMessage() {
        System.out.println("정답입니다. 축하합니다!\n");
    }
}
