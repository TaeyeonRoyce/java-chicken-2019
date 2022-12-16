package domain.table;

public class Table {
    private final int number;
    private TableStatus tableStatus = TableStatus.READY;

    public Table(final int number) {
        this.number = number;
    }

    public boolean matchNumber(int tableNumber) {
        return this.number == tableNumber;
    }

    public String topLine() {
        return TableOutputFormat.TOP_LINE.getFormat();
    }

    public String tableFormat() {
        String middleLineFormat = TableOutputFormat.TABLE_FORMAT.getFormat();
        return String.format(middleLineFormat, number);
    }

    public String bottomLine() {
        if (tableStatus == TableStatus.READY) {
            return TableOutputFormat.BOTTOM_LINE.getFormat();
        }

        return TableOutputFormat.BOTTOM_LINE_ORDERED.getFormat();
    }
}
