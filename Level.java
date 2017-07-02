import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;


public class Level {
  public final int X_BLOCKS = 20;
  public final int Y_BLOCKS = 15;
  public Cell[][] cells = new Cell[X_BLOCKS][Y_BLOCKS];
  public Hero hero;

  public Level(String filePath) {
    Cell cell;
    int y = 0;

    try {
      for (String line : Files.readAllLines(Paths.get(filePath))) {
        line = line.trim();
        for (int x = 0; x < line.length(); ++x) {
          switch (line.charAt(x)) {
            case '#':
              this.cells[x][y] = new Block(x, y);
              break;
            case '@':
              this.cells[x][y] = new Cell(x, y);
              this.hero = new Hero(x, y, this);
              break;
            default:
              this.cells[x][y] = new Cell(x, y);
          }
        }
        ++y;
      }
    } catch(IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  public boolean isEmpty(int x, int y) {
    return this.cells[x][y].isEmpty;
  }
}
