import domain.pos.PosStatus;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        PosController posController =
                new PosController(InputView.getInstance(), OutputView.getInstance());

        PosStatus posStatus;
        do {
            posStatus = posController.run();
        } while (posStatus == PosStatus.RUN);
    }
}
