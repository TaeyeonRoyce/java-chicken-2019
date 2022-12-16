package view.dto.request;

import java.util.regex.Pattern;

public class MainOptionRequest {
    private int optionRequest;

    private MainOptionRequest(int optionRequest) {

        this.optionRequest = optionRequest;
    }

    public static MainOptionRequest of(String userInput) {
        validate(userInput);

        return new MainOptionRequest(Integer.parseInt(userInput));
    }

    private static void validate(String userInput) {
        String moveCommandRegex = "^([123])$";

        if (!Pattern.matches(moveCommandRegex, userInput)) {
            throw new IllegalArgumentException();
        }
    }
}
