package view;

import java.util.Scanner;
import view.dto.request.PosJobRequest;
import view.dto.request.TableSelectRequest;

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
        System.out.println("## 원하는 기능을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();

        return PosJobRequest.of(userInput);
    }

    public TableSelectRequest getTableSelection() {
        System.out.println("## 테이블을 선택하세요.");
        String userInput = scanner.nextLine();
        System.out.println();

        return TableSelectRequest.of(userInput);
    }
}
