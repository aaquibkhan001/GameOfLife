package test.java;

import com.aaquib.gameoflife.java.Game;
import com.aaquib.gameoflife.model.Cell;
import com.aaquib.gameoflife.model.Grid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void checkGridCellsStateAfterTick() {
        Game game = new Game();

        Grid expectedGridAfterTick = new Grid();

        game.applyOneTick();
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,0).getState(), expectedGridAfterTick.getCellAtCoordinate(0,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,1).getState(), expectedGridAfterTick.getCellAtCoordinate(0,1).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,0).getState(), expectedGridAfterTick.getCellAtCoordinate(1,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,1).getState(), expectedGridAfterTick.getCellAtCoordinate(1,1).getState());
    }

    @Test
    public void checkCellStateWith2LiveNeighbours() {
        Game game = new Game(4, 4);

        // setting two live neighbours in Seed data
        game.getGridToPlay().setCellStateAtCoordinate(0, 1, Cell.State.ALIVE);
        game.getGridToPlay().setCellStateAtCoordinate(1, 0, Cell.State.ALIVE);

        Grid expectedGridAfterTick = new Grid(2, 2);
        expectedGridAfterTick.setCellStateAtCoordinate(0, 0, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(0, 1, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(1, 0, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(1, 1, Cell.State.ALIVE);

        game.applyOneTick();
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,0).getState(), expectedGridAfterTick.getCellAtCoordinate(0,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,1).getState(), expectedGridAfterTick.getCellAtCoordinate(0,1).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,0).getState(), expectedGridAfterTick.getCellAtCoordinate(1,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,1).getState(), expectedGridAfterTick.getCellAtCoordinate(1,1).getState());
    }

    @Test
    public void checkCellStateWith3LiveNeighbours() {
        Game game = new Game(3, 3);

        game.getGridToPlay().setCellStateAtCoordinate(1, 1, Cell.State.ALIVE);
        game.getGridToPlay().setCellStateAtCoordinate(2, 1, Cell.State.ALIVE);


        Grid expectedGridAfterTick = new Grid(3, 3);
        expectedGridAfterTick.setCellStateAtCoordinate(2, 0, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(2, 2, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(1, 0, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(1, 1, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(1, 2, Cell.State.ALIVE);

        game.applyOneTick();
        // row 1 assertions
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,0).getState(), expectedGridAfterTick.getCellAtCoordinate(0,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,1).getState(), expectedGridAfterTick.getCellAtCoordinate(0,1).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,2).getState(), expectedGridAfterTick.getCellAtCoordinate(0,2).getState());
        // row 2 assertions
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,0).getState(), expectedGridAfterTick.getCellAtCoordinate(1,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,1).getState(), expectedGridAfterTick.getCellAtCoordinate(1,1).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,2).getState(), expectedGridAfterTick.getCellAtCoordinate(1,2).getState());
        // row 3 assertions
        assertEquals(game.getGridToPlay().getCellAtCoordinate(2,0).getState(), expectedGridAfterTick.getCellAtCoordinate(2,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(2,1).getState(), expectedGridAfterTick.getCellAtCoordinate(2,1).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(2,2).getState(), expectedGridAfterTick.getCellAtCoordinate(2,2).getState());

    }

    @Test
    public void checkGridColumnSizeAfterTick() {
        Game game = new Game(3, 3);

        Grid expectedGridAfterTick = new Grid(3, 2);

        game.applyOneTick();
        assertFalse(game.getGridToPlay().getColumnsCount() == expectedGridAfterTick.getColumnsCount());
    }

    @Test
    public void checkGridRowSizeAfterTick() {
        Game game = new Game(3, 3);

        Grid expectedGridAfterTick = new Grid(2, 3);

        game.applyOneTick();
        assertFalse(game.getGridToPlay().getRowsCount() == expectedGridAfterTick.getRowsCount());
    }

    @Test
    public void checkGridSizeAfterTick() {
        Game game = new Game(3, 3);

        Grid expectedGridAfterTick = new Grid(3, 3);

        game.applyOneTick();
        assertTrue(game.getGridToPlay().getRowsCount() == expectedGridAfterTick.getRowsCount());
        assertTrue(game.getGridToPlay().getColumnsCount() == expectedGridAfterTick.getColumnsCount());
    }

    @Test
    public void checkCellStateWithOneLiveNeighbour() {
        Game game = new Game(2, 2);

        game.getGridToPlay().setCellStateAtCoordinate(0, 1, Cell.State.ALIVE);

        Grid expectedGridAfterTick = new Grid(2, 2);

        game.applyOneTick();
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,0).getState(), expectedGridAfterTick.getCellAtCoordinate(0,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,1).getState(), expectedGridAfterTick.getCellAtCoordinate(0,1).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,0).getState(), expectedGridAfterTick.getCellAtCoordinate(1,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,1).getState(), expectedGridAfterTick.getCellAtCoordinate(1,1).getState());
    }

    @Test
    public void checkSimultaneousStateUpdate() {
        Game game = new Game(3, 3);

        game.getGridToPlay().setCellStateAtCoordinate(0, 1, Cell.State.ALIVE);
        game.getGridToPlay().setCellStateAtCoordinate(1, 0, Cell.State.ALIVE);

        Grid expectedGridAfterTick = new Grid(2, 2);
        expectedGridAfterTick.setCellStateAtCoordinate(0, 0, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(0, 1, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(1, 0, Cell.State.ALIVE);
        expectedGridAfterTick.setCellStateAtCoordinate(1, 1, Cell.State.ALIVE);

        game.applyOneTick();
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,0).getState(), expectedGridAfterTick.getCellAtCoordinate(0,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(0,1).getState(), expectedGridAfterTick.getCellAtCoordinate(0,1).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,0).getState(), expectedGridAfterTick.getCellAtCoordinate(1,0).getState());
        assertEquals(game.getGridToPlay().getCellAtCoordinate(1,1).getState(), expectedGridAfterTick.getCellAtCoordinate(1,1).getState());
    }
}
