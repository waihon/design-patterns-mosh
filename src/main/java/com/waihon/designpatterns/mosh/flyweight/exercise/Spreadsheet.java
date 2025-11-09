package com.waihon.designpatterns.mosh.flyweight.exercise;

public class Spreadsheet {
    private final int MAX_ROWS = 3;
    private final int MAX_COLS = 3;
    private Cell[][] cells = new Cell[MAX_ROWS][MAX_COLS];
    private CellContextFactory contextFactory;

    public Spreadsheet(CellContextFactory contextFactory) {
        this.contextFactory = contextFactory;

        generateCells();
    }

    public void render() {
        for (var row = 0; row < MAX_ROWS; row++) {
            for (var col = 0; col < MAX_COLS; col++) {
                cells[row][col].render();
            }
        }
    }

    public void setContent(int row, int col, String content) {
        ensureCellExists(row, col);

        cells[row][col].setContent(content);
    }

    public void setFontFamily(int row, int col, String fontFamily) {
        ensureCellExists(row, col);

        var cell = cells[row][col];
        var currentContext = cell.getContext();
        var context = contextFactory.getContext(fontFamily, currentContext.getFontSize(), currentContext.isBold());
        cells[row][col].setContext(context);
    }

    public void setFontSize(int row, int col, int fontSize) {
        ensureCellExists(row, col);

        var cell = cells[row][col];
        var currentContext = cell.getContext();
        var context = contextFactory.getContext(currentContext.getFontFamily(), fontSize, currentContext.isBold());
        cells[row][col].setContext(context);
    }

    public void setBold(int row, int col, boolean bold) {
        ensureCellExists(row, col);

        var cell = cells[row][col];
        var currentContext = cell.getContext();
        var context = contextFactory.getContext(currentContext.getFontFamily(), currentContext.getFontSize(), bold);
        cells[row][col].setContext(context);
    }

    private void ensureCellExists(int row, int col) {
        if (row < 0 || row >= MAX_ROWS) {
            throw new IllegalArgumentException();
        }

        if (col < 0 || col >= MAX_COLS) {
            throw new IllegalArgumentException();
        }
    }


    private void generateCells() {
        for (var row = 0; row < MAX_ROWS; row++) {
            for (var col = 0; col < MAX_COLS; col++) {
                cells[row][col] = new Cell(row, col, getDefaultContext());
            }
        }
    }

    private CellContext getDefaultContext() {
        // In a real app, these values should not be hardcoded here.
        // They should be read from a configuration file.
        return new CellContext("Times New Roman", 12, false);
    }
}
