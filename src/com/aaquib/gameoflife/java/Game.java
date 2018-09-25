package com.aaquib.gameoflife.java;

import com.aaquib.gameoflife.model.Cell;
import com.aaquib.gameoflife.model.Grid;

public class Game {

    private Grid gridToPlay;

    public Game() {
        this.gridToPlay = new Grid();
    }

    public Game(final int rows, final int columns) {
        this.gridToPlay = new Grid(rows, columns);
    }

    public void applyOneTick() {
        for (int rows = 0; rows < gridToPlay.getRowsCount(); rows++) {
            for (int columns = 0; columns < gridToPlay.getColumnsCount(); columns++) {
                gridToPlay.setCellAtCoordinate(rows, columns, getNextGenerationCell(rows, columns));
            }
        }
    }

    public Grid getGridToPlay() {
        return gridToPlay;
    }

    private Cell getNextGenerationCell(final int x, final int y) {
        Cell cellAtCoordinate = this.gridToPlay.getCellAtCoordinate(x, y);
        int liveNeighbours = this.gridToPlay.getLiveNeighboursCountForCoordinate(x, y);
        Cell.State nextState;

        switch (liveNeighbours) {
            case 2:
                nextState = Cell.State.ALIVE;
                break;
            case 3:
                nextState = Cell.State.ALIVE;
                break;
            default:
                nextState = Cell.State.DEAD;
                break;
        }
        cellAtCoordinate.setState(nextState);

        return cellAtCoordinate;
    }
}
