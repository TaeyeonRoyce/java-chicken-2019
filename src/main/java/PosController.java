import domain.Menu;
import domain.MenuRepository;
import domain.pos.PosJob;
import domain.pos.PosStatus;
import domain.table.Table;
import domain.table.TableRepository;
import view.InputView;
import view.OutputView;
import view.dto.request.SelectRequest;

public class PosController {
    private final InputView inputView;
    private final OutputView outputView;

    public PosController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public PosStatus run() {
        PosJob posJob = requestPosJob();
        if (posJob == PosJob.TERMINATE) {
            return PosStatus.TERMINATED;
        }
        workByPosJob(posJob);
        return PosStatus.RUN;
    }

    private PosJob requestPosJob() {
        PosJob[] posJobs = PosJob.values();
        outputView.mainView(posJobs);

        SelectRequest posJobRequest = inputView.getMainOptionRequest();

        return PosJob.fromOptionNumber(posJobRequest.getNumber());
    }

    private void workByPosJob(PosJob posJob) {
        Table selectedTable = requestTableSelection();
        if (posJob == PosJob.ENROLL) {
            enrollOrder(selectedTable);
            return;
        }
//        pay(selectedTable);
    }

    private Table requestTableSelection() {
        outputView.printTables(TableRepository.tables());
        SelectRequest tableSelectionRequest = inputView.getTableSelection();

        return TableRepository.findByTableNumber(tableSelectionRequest.getNumber());
    }

    private void enrollOrder(Table table) {
        outputView.printMenus(MenuRepository.menus());
        SelectRequest menuRequest = inputView.getMenu();
        SelectRequest quantityRequest = inputView.getQuantity();
        Menu menu = MenuRepository.findByMenuNumber(menuRequest.getNumber());
        try {
            table.enrollOrder(menu, quantityRequest.getNumber());
        } catch (IllegalArgumentException e) {
            outputView.printOverMaxQuantity();
        }
    }


}
