package test.model;

import com.aaquib.gameoflife.model.Cell;
import com.aaquib.gameoflife.model.Grid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTest {

    @Test
    public void checkRowsInGridInitialization() {
        Grid grid = new Grid(4, 2);

        assertEquals(grid.getRowsCount(), 4);
    }

    @Test
    public void checkColumnsInGridInitialization() {
        Grid grid = new Grid(4, 2);

        assertEquals(grid.getColumnsCount(), 2);
    }

    @Test
    public void validateCellStateOnceChanged() {
        Grid grid = new Grid(4, 2);
        grid.setCellStateAtCoordinate(2, 1, Cell.State.ALIVE);

        assertEquals(grid.getCellAtCoordinate(2, 1).getState(), Cell.State.ALIVE);
    }

    @Test
    public void checkIfCellIsInBoundary() {
        Grid grid = new Grid(4, 2);

        assertEquals(grid.isCellOutOfBoundary(1, 1), false);
    }

    @Test
    public void checkIfCellIsOutOfBoundary() {
        Grid grid = new Grid(4, 2);

        assertEquals(grid.isCellOutOfBoundary(4, 1), true);
    }

    @Test
    public void checkLiveNeighboursCount() {
        Grid grid = new Grid(4, 2);
        grid.setCellStateAtCoordinate(0, 0, Cell.State.ALIVE);
        grid.setCellStateAtCoordinate(1, 0, Cell.State.ALIVE);
        grid.setCellStateAtCoordinate(1, 1, Cell.State.ALIVE);


        assertEquals(grid.getLiveNeighboursCountForCoordinate(0, 1), 3);
    }
}
