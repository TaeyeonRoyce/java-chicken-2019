package view.dto.request;

import domain.MainOption;

public class MainOptionRequest {
    private int optionRequest;

    private MainOptionRequest(int optionRequest) {
        this.optionRequest = optionRequest;
    }

    public static MainOptionRequest of(String userInput) {
        validate(userInput);

        return new MainOptionRequest(Integer.parseInt(userInput));
    }
}
