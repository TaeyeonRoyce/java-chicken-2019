import domain.pos.Pos;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        PosController posController =
                new PosController(InputView.getInstance(), OutputView.getInstance(), Pos.getInstance());
        do {
            posController.run();
        } while (posController.isProgramRunnable());
    }
}
