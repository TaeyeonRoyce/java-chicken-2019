import domain.pos.Pos;
import domain.pos.PosStatus;
import view.InputView;
import view.OutputView;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {

        Pos pos = new Pos(InputView.getInstance(), OutputView.getInstance());
        do {
            pos.run();
        } while (pos.status() == PosStatus.RUN);
    }
}
