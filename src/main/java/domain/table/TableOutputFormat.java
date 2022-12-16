package domain.table;

public enum TableOutputFormat {
    TOP_LINE("┌ ─ ┐"),
    TABLE_FORMAT("| %s |"),
    BOTTOM_LINE("└ ─ ┘"),
    BOTTOM_LINE_ORDERED("└ # ┘");

    private String format;

    TableOutputFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
