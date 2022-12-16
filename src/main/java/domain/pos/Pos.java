package domain.pos;

import view.InputView;
import view.OutputView;

public class Pos {
    private final InputView inputView;
    private final OutputView outputView;
    private final PosStatus posStatus = PosStatus.RUN;

    public Pos(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.mainView();
        inputView.selectFunction();
    }

    public PosStatus status() {
        return posStatus;
    }
}
