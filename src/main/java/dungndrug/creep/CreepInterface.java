package dungndrug.creep;

import dungndrug.creep.StrategyInterface;

public interface CreepInterface {
  public int getX();
  public int getY();
  public int getSpeed();
  public StrategyInterface getStrategy();
  public boolean move(int delta_x, int delta_y);
  public void beforeTurn();
}
