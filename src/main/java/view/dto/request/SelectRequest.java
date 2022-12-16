package view.dto.request;

public class SelectRequest {
    private String selectNumber;

    private SelectRequest(String userInput) {
        validate(userInput);
        this.selectNumber = userInput;
    }

    public static SelectRequest of(String userInput) {
        return new SelectRequest(userInput);
    }

    private void validate(String userInput) {
        try {
            validatePositive(Integer.parseInt(userInput));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositive(int tableNumber) {
        if (tableNumber < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getTableNumber() {
        return Integer.parseInt(selectNumber);
    }
}
