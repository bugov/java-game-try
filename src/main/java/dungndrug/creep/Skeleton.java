package dungndrug.creep;

import javax.swing.ImageIcon;
import java.awt.Graphics;

import dungndrug.level.Block;
import dungndrug.level.Level;


public class Skeleton extends Block {
  static String imageFile = "data/image/skeleton.png";

  // TODO
  static int maxHp = 10;
  static int aliveTries = 3;

  protected int hp;
  protected int speed = 3;
  protected boolean isDead = false;
  protected Level mapLevel;

  public Skeleton(int x, int y, Level level) {
    super(x, y);
    isEmpty = false;
    ImageIcon icon = new ImageIcon(this.imageFile);
    this.image = icon.getImage();
    this.mapLevel = level;
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

  public boolean move(int delta_x, int delta_y) {
    if (! this.mapLevel.isEmpty(this.y + delta_y, this.x + delta_x)) {
      return false;
    }
    this.mapLevel.moveCell(this, this.y + delta_y, this.x + delta_x);

    this.x += delta_x;
    this.y += delta_y;

    return true;
  }
}
