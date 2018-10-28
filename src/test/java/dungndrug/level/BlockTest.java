package dungndrug.level;

import org.junit.Test;
import static org.junit.Assert.*;

import dungndrug.level.Block;

public class BlockTest {
  @Test
  public void testCreate() {
    Block block = new Block(1, 1);

    assertEquals(1, block.getX());
    assertEquals(1, block.getY());
    assertEquals(false, block.isEmpty);
  }
}
