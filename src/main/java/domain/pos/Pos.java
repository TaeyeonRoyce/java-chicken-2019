package domain.pos;

import domain.MainOption;
import view.InputView;
import view.OutputView;
import view.dto.request.MainOptionRequest;

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

        MainOptionRequest mainOptionRequest = inputView.getMainOptionRequest();

        workBySelectedOption(mainOptionRequest.toMainOption());
    }

    private void workBySelectedOption(MainOption option) {
        if (option == MainOption.ENROLL) {
//            enroll();
            return;
        }

        if (option == MainOption.PAY) {
//            pay();
            return;
        }
    }

    public PosStatus status() {
        return posStatus;
    }
}
