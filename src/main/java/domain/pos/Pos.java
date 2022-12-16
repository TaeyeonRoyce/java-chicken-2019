package domain.pos;

import domain.MainOption;
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
        MainOption[] mainOptions = MainOption.values();
        outputView.mainView(mainOptions);

        inputView.getMainOptionRequest();
    }

    public PosStatus status() {
        return posStatus;
    }
}
