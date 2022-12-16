package domain;

import java.util.Arrays;

public enum MainOption {
    ENROLL(1, "주문등록"),
    PAY(2, "결제하기"),
    EXIT(3, "프로그램 종료");

    private int optionNumber;
    private String message;

    MainOption(int optionNumber, String message) {
        this.optionNumber = optionNumber;
        this.message = message;
    }

    public static MainOption fromOptionNumber(int optionNumber) {
        return Arrays.stream(MainOption.values())
                .filter(options -> options.optionNumber == optionNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String outputFormat() {
        return optionNumber + " - " + message;
    }
}
