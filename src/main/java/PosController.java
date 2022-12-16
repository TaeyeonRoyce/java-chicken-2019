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
    private PosJob posJob;

    public PosController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        updatePosJob();
        if (posJob == PosJob.TERMINATE) {
            return;
        }

        Table tableSelection = requestTableSelection();
    }

    private void updatePosJob() {
        PosJob[] posJobs = PosJob.values();
        outputView.mainView(posJobs);

        PosJobRequest posJobRequest = inputView.getMainOptionRequest();

        this.posJob = posJobRequest.toPosJob();
    }

    private Table requestTableSelection() {
        outputView.printTables(TableRepository.tables());
        TableSelectRequest tableSelectionRequest = inputView.getTableSelection();

        return TableRepository.findByTableNumber(tableSelectionRequest.getTableNumber());
    }

    public boolean isProgramRunnable() {
        return posJob == PosJob.TERMINATE;
    }


}
