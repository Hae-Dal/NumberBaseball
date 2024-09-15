package com.number_baseball.enumeration;

import com.number_baseball.Exceptions.IllegalInputException;
import com.number_baseball.service.GameService;

import java.util.Objects;

public enum InputType {
    MENU() {
        @Override
        public void isValid(String s) {
            if (!(Objects.equals(s, "1") || Objects.equals(s,"2") || Objects.equals(s, "3"))) {
                throw new IllegalInputException("1, 2, 3 중에 한가지를 입력해주세요.");
            }
        }
    },

    ANSWER() {
        @Override
        public void isValid(String s) {
            int answerLength = GameService.getInstance().getCurrentGame().getDifficulty().getAnswerLength();
            // 세 자리 수 인지 판별
            if (s.length() != answerLength) {
                throw new IllegalInputException("답은 "+ answerLength +"자리 수 입니다.");
            }

            // 같은 숫자를 입력했는지 확인
            for (int i = 0; i < s.length(); i++) {
                if (s.replace(String.valueOf(s.charAt(i)), "").length() != answerLength - 1) {
                    throw new IllegalInputException("각각의 숫자는 모두 달라야합니다.");
                }
            }

            // 숫자로만 이루어져 있는지 확인
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalInputException("숫자만 입력해야합니다.");
            }

        }
    },
    DIFFICULTY() {
        @Override
        public void isValid(String s) {
            if (!(Objects.equals(s, "3") || Objects.equals(s,"4") || Objects.equals(s, "5"))) {
                throw new IllegalInputException("3, 4, 5 중에 한가지를 입력해주세요.");
            }
        }
    };



    InputType() {
    }

    public abstract void isValid(String s);
}
