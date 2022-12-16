package domain.pos;

public class Pos {
    private PosStatus posStatus = PosStatus.RUN;

    private PosJob currentPosJob;

    private Pos() {
    }

    public static Pos getInstance() {
        return new Pos();
    }


    public void updateByPosJob(PosJob posJob) {
        if (posJob == PosJob.EXIT) {
            this.posStatus = PosStatus.TERMINATE;
            return;
        }

        currentPosJob = posJob;
    }

    public boolean isPosRunnable() {
        return this.posStatus == PosStatus.RUN;
    }
}
