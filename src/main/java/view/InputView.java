package view;

import java.util.Scanner;
import view.dto.request.PosJobRequest;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static InputView getInstance() {
        return new InputView();
    }

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public PosJobRequest getMainOptionRequest() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        String userInput = scanner.nextLine();

        return PosJobRequest.of(userInput);
    }
}
