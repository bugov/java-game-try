package dungndrug.level;

import java.util.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

import dungndrug.user.Hero;
import dungndrug.level.Cell;
import dungndrug.creep.Skeleton;

public class Level {
  public List<List<List<Cell>>> cells = new ArrayList<List<List<Cell>>>();
  public List<Skeleton> creeps = new ArrayList<Skeleton>();
  private Hero hero;

  public Level(String filePath) {
    Cell cell;
    int y = 0;

    try {
      for (String line : Files.readAllLines(Paths.get(filePath))) {
        line = line.trim();
        List<List<Cell>> lineCells = new ArrayList<List<Cell>>();
        cells.add(lineCells);

        for (int x = 0; x < line.length(); ++x) {
          List<Cell> cellStack = new ArrayList<Cell>();
          lineCells.add(cellStack);
          cellStack.add(new Cell(x, y));

          switch (line.charAt(x)) {
            case '#':
              cellStack.add(new Block(x, y));
              break;
            case 's':
              Skeleton skel = new Skeleton(x, y, this);
              cellStack.add(skel);
              creeps.add(skel);
              break;
            case '@':
              this.hero = new Hero(x, y, this);
              cellStack.add(this.hero);
              break;
            default:
              break;
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
    boolean isEmpty = true;

    for (int i = 0; i < this.cells.get(x).get(y).size(); ++i) {
      if (! this.cells.get(x).get(y).get(i).isEmpty) {
        isEmpty = false;
      }
    }

    return isEmpty;
  }

  public Hero getHero() {
    return hero;
  }

  public void moveCell(Cell cell, int toX, int toY) {
    List fromCell = this.cells.get(cell.getY()).get(cell.getX());

    for (int i = 0; i < fromCell.size(); ++i) {
      if (fromCell.get(i) == cell) {
        fromCell.remove(i);
        break;
      }
    }

    this.cells.get(toX).get(toY).add(cell);
  }
}
