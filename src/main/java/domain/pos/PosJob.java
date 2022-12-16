package domain.pos;

import java.util.Arrays;

public enum PosJob {
    ENROLL(1, "주문등록"),
    PAY(2, "결제하기"),
    TERMINATE(3, "프로그램 종료");

    private int optionNumber;
    private String message;

    PosJob(int optionNumber, String message) {
        this.optionNumber = optionNumber;
        this.message = message;
    }

    public static PosJob fromOptionNumber(int optionNumber) {
        return Arrays.stream(PosJob.values())
                .filter(options -> options.optionNumber == optionNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String outputFormat() {
        return optionNumber + " - " + message;
    }
}
