package com.aaquib.gameoflife.model;

public class Grid {

    private static final int DEFAULT_ROWS = 2;
    private static final int DEFAULT_COLUMNS = 2;

    private Cell[][] cells;

    public Grid() {
        this.cells = initializeGridWithDeadCells(DEFAULT_ROWS, DEFAULT_COLUMNS);
    }

    public Grid(final int rows, final int columns) {
        this.cells = initializeGridWithDeadCells(rows, columns);
    }

    private Cell[][] initializeGridWithDeadCells(final int rows, final int columns) {
        Cell[][] deadCells = new Cell[rows][columns];
        for (int xAxis = 0; xAxis < rows; xAxis++) {
            for (int yAxis = 0; yAxis < columns; yAxis++) {
                Cell aCell = new Cell(xAxis, yAxis, Cell.State.DEAD);
                deadCells[xAxis][yAxis] = aCell;
            }
        }
        return deadCells;
    }

    public int getLiveNeighboursCountForCoordinate(final int x, final int y) {
        int liveNeighbourCount = 0;
        for (int xAxis = x - 1; xAxis <= x + 1; xAxis++) {
            for (int yAxis = y - 1; yAxis <= y + 1; yAxis++) {
                    liveNeighbourCount += isCellAlive(xAxis, yAxis);
            }
        }
        // Need not count the current cell's state
        liveNeighbourCount -= isCellAlive(x, y);
        return liveNeighbourCount;
    }

    public int isCellAlive(final int x, final int y) {
        if (isCellOutOfBoundary(x, y)) {
            return 0;
        }
        if (cells[x][y].getState() == Cell.State.ALIVE) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean isCellOutOfBoundary(final int x, final int y) {
        return ((y == -1 || y > getColumnsCount() - 1) || (x == -1 || x > getRowsCount() - 1));
    }

    public int getRowsCount() {
        return cells.length;
    }

    public int getColumnsCount() {
        return cells[0].length;
    }

    public void setCellStateAtCoordinate(final int x, final int y, Cell.State state) {
        this.cells[x][y].setState(state);
    }

    public void setCellAtCoordinate(final int x, final int y, Cell cell) {
        this.cells[x][y] = cell;
    }

    public Cell getCellAtCoordinate(final int x, final int y) {
        return this.cells[x][y];
    }
}
