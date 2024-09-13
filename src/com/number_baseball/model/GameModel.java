package com.number_baseball.model;

import java.util.Random;

public class GameModel {
    private String answer;
    
    public GameModel() {
        init();
    }

    // 게임 모델 초기화 함수
    public void init() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append(random.nextInt(8) + 1);

        while (sb.length() != 3){
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
}
