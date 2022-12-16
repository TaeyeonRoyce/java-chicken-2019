import domain.pos.Pos;
import domain.pos.PosJob;
import domain.table.TableRepository;
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
        PosJob posJob = requestPosJob();
        if (!isProgramRunnable()) {
            return;
        }

        int tableSelection = requestTableSelection();
    }

    private PosJob requestPosJob() {
        PosJob[] posJobs = PosJob.values();
        outputView.mainView(posJobs);

        PosJobRequest posJobRequest = inputView.getMainOptionRequest();

        PosJob posJob = posJobRequest.toPosJob();
        pos.updateByPosJob(posJob);
        return posJob;
    }

    private int requestTableSelection() {
        outputView.printTables(TableRepository.tables());
        inputView.getTableSelection();

        return 0;
    }

    public boolean isProgramRunnable() {
        return pos.isPosRunnable();
    }


}
