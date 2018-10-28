package dungndrug.user;

import org.junit.Test;
import static org.junit.Assert.*;

import dungndrug.level.Level;
import dungndrug.user.Hero;

public class HeroTest {
  @Test
  public void testCreate() {
    Level level = new Level("./data/level/1.txt");
    Hero hero = level.getHero();
    assertEquals(2, hero.getX());
    assertEquals(2, hero.getY());

    Hero hero1 = new Hero(3, 4, level);
    assertEquals(3, hero1.getX());
    assertEquals(4, hero1.getY());
  }

  @Test
  public void testMove() {
    Level level = new Level("./data/level/1.txt");
    Hero hero = level.getHero();

    hero.move(0, -1);
    assertEquals(2, hero.getX());
    assertEquals(1, hero.getY());

    hero.beforeTurn();
    hero.move(1, 0);
    assertEquals(3, hero.getX());
    assertEquals(1, hero.getY());

    for (int i = 0; i < 10; ++i) {
      hero.beforeTurn();
      hero.move(1, 0);
    }
    assertEquals(4, hero.getX());  // Wall
    assertEquals(1, hero.getY());

    for (int i = 0; i < 10; ++i) {
      hero.beforeTurn();
      hero.move(0, 1);
    }
    assertEquals(4, hero.getX());
    assertEquals(8, hero.getY());  // Wall
  }
}
