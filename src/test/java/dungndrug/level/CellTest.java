package dungndrug.level;

import org.junit.Test;
import static org.junit.Assert.*;

import dungndrug.level.Cell;

public class CellTest {
  @Test
  public void testCreate() {
    Cell cell = new Cell(1, 1);

    assertEquals(1, cell.getX());
    assertEquals(1, cell.getY());
    assertEquals(true, cell.isEmpty);
  }
}
