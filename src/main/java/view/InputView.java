package view;

import java.util.Scanner;
import view.dto.request.SelectRequest;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static InputView getInstance() {
        return new InputView();
    }

    public SelectRequest getMainOptionRequest() {
        String message = "## 원하는 기능을 선택하세요.";
        return getSelectRequest(message);
    }

    public SelectRequest getTableSelection() {
        String message = "## 테이블을 선택하세요.";
        return getSelectRequest(message);
    }

    public SelectRequest getMenu() {
        String message = "## 등록할 메뉴를 선택하세요.";
        return getSelectRequest(message);
    }

    private SelectRequest getSelectRequest(String message) {
        System.out.println(message);
        String userInput = scanner.nextLine();
        System.out.println();

        return SelectRequest.of(userInput);
    }
}
