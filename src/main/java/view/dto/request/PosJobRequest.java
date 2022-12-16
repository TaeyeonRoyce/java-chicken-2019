package view.dto.request;

import domain.pos.PosJob;
import java.util.regex.Pattern;

public class PosJobRequest {
    private int optionRequest;

    private PosJobRequest(int optionRequest) {

        this.optionRequest = optionRequest;
    }

    public static PosJobRequest of(String userInput) {
        validate(userInput);

        return new PosJobRequest(Integer.parseInt(userInput));
    }

    private static void validate(String userInput) {
        String posJobCommandRegex = "^([123])$";

        if (!Pattern.matches(posJobCommandRegex, userInput)) {
            throw new IllegalArgumentException();
        }
    }

    public PosJob toPosJob() {
        return PosJob.fromOptionNumber(optionRequest);
    }
}
