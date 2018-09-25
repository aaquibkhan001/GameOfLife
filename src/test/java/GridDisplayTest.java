package test.java;

import com.aaquib.gameoflife.java.GridDisplay;
import com.aaquib.gameoflife.model.Grid;
import org.junit.Test;

public class GridDisplayTest {

    @Test
    public void validateCellStateOnceChanged() {
        Grid grid = new Grid(4, 2);

        GridDisplay display = new GridDisplay();
        display.setGridToDisplay(grid);

        display.displayGrid();
    }
}
