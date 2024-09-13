package com.number_baseball.enumeration;

import com.number_baseball.Exceptions.IllegalInputException;

import java.util.Objects;

public enum InputType {
    MENU("menu") {
        @Override
        public boolean isValid(String s) {
            if (!(Objects.equals(s, "1") || Objects.equals(s, "3"))) {
                throw new IllegalArgumentException("1 또는 3을 입력해주세요.");
            }
            return true;
        }
    },

    ANSWER("answer") {
        @Override
        public boolean isValid(String s) {
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

            return true;
        }
    };

    InputType(String type) {
    }

    public abstract boolean isValid(String s);
}
