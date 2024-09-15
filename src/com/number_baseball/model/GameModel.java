package com.number_baseball.model;

import com.number_baseball.enumeration.Difficulty;

import java.util.Random;

import static com.number_baseball.enumeration.Difficulty.EASY;

public class GameModel {
    private String answer;
    private final Difficulty difficulty;;
    private int tryNum;
    
    public GameModel(Difficulty difficulty) {
        this.tryNum = 0;
        this.difficulty = difficulty;
        init();
    }

    // 게임 모델 초기화 함수
    public void init() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(random.nextInt(8) + 1);

        while (sb.length() != this.difficulty.getAnswerLength()){
            int r = random.nextInt(8) + 1;
            if (sb.indexOf(String.valueOf(r)) == -1) {
                sb.append(r);
            }
        }

        this.answer = sb.toString();
    }

    public String getAnswer() {
        return answer;
    }

    public int getTryNum() {
        return tryNum;
    }

    public void addTryNum() {
        this.tryNum += 1;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
