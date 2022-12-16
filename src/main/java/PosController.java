import domain.pos.Pos;
import domain.pos.PosJob;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;
import view.dto.request.PosJobRequest;
import view.dto.request.TableSelectRequest;

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

        Table tableSelection = requestTableSelection();
    }

    private PosJob requestPosJob() {
        PosJob[] posJobs = PosJob.values();
        outputView.mainView(posJobs);

        PosJobRequest posJobRequest = inputView.getMainOptionRequest();

        PosJob posJob = posJobRequest.toPosJob();
        pos.updateByPosJob(posJob);
        return posJob;
    }

    private Table requestTableSelection() {
        outputView.printTables(TableRepository.tables());
        TableSelectRequest tableSelectionRequest = inputView.getTableSelection();

        return TableRepository.findByTableNumber(tableSelectionRequest.getTableNumber());
    }

    public boolean isProgramRunnable() {
        return pos.isPosRunnable();
    }


}
