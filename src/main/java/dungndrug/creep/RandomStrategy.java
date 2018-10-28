package dungndrug.creep;

import java.util.*;
import dungndrug.creep.StrategyInterface;
import dungndrug.level.Level;
import dungndrug.level.Cell;
import dungndrug.user.Hero;

class RandomStrategy implements StrategyInterface {
  protected CreepInterface creep;
  protected Level level;

  public RandomStrategy(CreepInterface creep, Level level) {
    this.creep = creep;
    this.level = level;
  }

  public void walk(int depth) {
    Random r = new Random();

    for (; depth > 0; --depth) {
      int variant = r.nextInt(4);

      switch (variant) {
        case 0: this.creep.move(1, 0); break;
        case 1: this.creep.move(0, -1); break;
        case 2: this.creep.move(-1, 0); break;
        case 3: this.creep.move(0, 1); break;
      }
    }
  }

  public boolean shouldHit() {
    return false;
  }

  public void turn() {
    if (! this.shouldHit()) {
      this.walk(creep.getSpeed());
    }
  }

  protected double getDelta(CreepInterface hero, CreepInterface creep) {
    return Math.pow(
      Math.pow(hero.getX() - creep.getX(), 2)
      + Math.pow(hero.getY() - creep.getY(), 2),
      0.5
    );
  }
}
