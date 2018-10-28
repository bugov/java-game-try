package dungndrug.creep;

import javax.swing.ImageIcon;
import java.awt.Graphics;

import dungndrug.level.Block;
import dungndrug.level.Level;
import dungndrug.creep.RandomStrategy;
import dungndrug.creep.StrategyInterface;


public class Skeleton extends Block implements CreepInterface {
  static String imageFile = "data/image/skeleton.png";

  // TODO
  static int maxHp = 10;
  static int maxSpeed = 3;
  static int aliveTries = 3;

  protected int hp;
  protected int speed = 3;
  protected boolean isDead = false;
  protected Level mapLevel;
  protected StrategyInterface strategy;

  public Skeleton(int x, int y, Level level) {
    super(x, y);
    isEmpty = false;
    ImageIcon icon = new ImageIcon(this.imageFile);
    this.image = icon.getImage();
    this.mapLevel = level;
    this.strategy = new RandomStrategy(this, level);
  }

  public StrategyInterface getStrategy() {
    return this.strategy;
  }

  public int getSpeed() {
    return this.speed;
  }

  public void gotHit(int hp) {
    this.hp -= hp;

    if (this.hp < -this.maxHp) {
      this.isDead = true;
    }
  }

  @Override
  public void render(Graphics g) {
    g.drawImage(this.image, SIZE * this.x, SIZE * this.y, this);
  }

  public boolean move(int deltaX, int deltaY) {
    System.out.println("Move " + this.getClass().getSimpleName() + " " + this.getX() + ";" + this.getY());
    if (this.speed <= 0) {
      return false;
    }
    if (! this.mapLevel.isEmpty(this.y + deltaY, this.x + deltaX)) {
      return false;
    }
    this.mapLevel.moveCell(this, this.y + deltaY, this.x + deltaX);

    this.x += deltaX;
    this.y += deltaY;
    this.speed -= 1;

    return true;
  }

  public void beforeTurn() {
    this.speed = maxSpeed;
  }
}
