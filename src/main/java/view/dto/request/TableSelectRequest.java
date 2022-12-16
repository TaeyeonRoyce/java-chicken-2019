package view.dto.request;

public class TableSelectRequest {
    private int tableNumber;

    private TableSelectRequest(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public static TableSelectRequest of(String userInput) {
        validate(userInput);

        return new TableSelectRequest(Integer.parseInt(userInput));
    }

    private static void validate(String userInput) {
        try {
            validatePositive(Integer.parseInt(userInput));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void validatePositive(int tableNumber) {
        if (tableNumber < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getTableNumber() {
        return tableNumber;
    }
}
