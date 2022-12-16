package domain.pos;

import view.InputView;
import view.OutputView;
import view.dto.request.PosJobRequest;

public class PosController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Pos pos;

    public PosController(InputView inputView, OutputView outputView, Pos pos) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pos = pos;
    }

    public void run() {
        PosJob[] posJobs = PosJob.values();
        outputView.mainView(posJobs);

        PosJobRequest posJobRequest = inputView.getMainOptionRequest();

        pos.updateByPosJob(posJobRequest.toPosJob());
    }

    public boolean isProgramRunnable() {
        return pos.isPosRunnable();
    }
}
