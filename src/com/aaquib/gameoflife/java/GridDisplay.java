package com.aaquib.gameoflife.java;

import com.aaquib.gameoflife.model.Cell;
import com.aaquib.gameoflife.model.Grid;

public class GridDisplay {

    private Grid gridToDisplay;

    public void displayGrid() {
        for (int row = 0; row < gridToDisplay.getRowsCount(); row++) {
            for (int column = 0; column < gridToDisplay.getColumnsCount(); column++) {
                System.out.print(getDisplayCharacter(gridToDisplay.getCellAtCoordinate(row, column).getState()));
            }
            System.out.println();
        }
    }

    public void setGridToDisplay(Grid gridToDisplay) {
        this.gridToDisplay = gridToDisplay;
    }

    private String getDisplayCharacter(Cell.State state) {
        return state.equals(Cell.State.ALIVE) ? "X" : ".";
    }
}
