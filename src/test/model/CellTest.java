package test.model;

import com.aaquib.gameoflife.model.Cell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CellTest {

    @Test
    public void checkRowInitialization() {
        Cell newCell = new Cell(3, 3, Cell.State.DEAD);

        assertEquals(newCell.getRow(), 3);
    }

    @Test
    public void checkColumnInitialization() {
        Cell newCell = new Cell(3, 2, Cell.State.DEAD);

        assertEquals(newCell.getColumn(), 2);
    }

    @Test
    public void checkStateInitialization() {
        Cell newCell = new Cell(3, 2, Cell.State.ALIVE);

        assertTrue(newCell.getState() == Cell.State.ALIVE);
    }
}
