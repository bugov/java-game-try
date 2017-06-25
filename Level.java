import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;


public class Level {
  public final int X_BLOCKS = 20;
  public final int Y_BLOCKS = 15;
  public Cell[][] cells = new Cell[X_BLOCKS][Y_BLOCKS];

  public Level(String filePath) {
    Cell cell;
    int y = 0;

    try {
      for (String line : Files.readAllLines(Paths.get(filePath))) {
        line = line.trim();
        for (int x = 0; x < line.length(); ++x) {
          switch (line.charAt(x)) {
            case '#':
              cell = new Block(x, y);
              break;
            case '@':
              cell = new Hero(x, y);
              break;
            default:
              cell = new Cell(x, y);
          }
          this.cells[x][y] = cell;
        }
        ++y;
      }
    } catch(IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
