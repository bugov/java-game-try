package dungndrug.user;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

import dungndrug.level.Level;
import dungndrug.fight.Bolt;
import dungndrug.creep.Skeleton;

public class Hero extends Skeleton {
  private String imageFile = "data/image/mage.png";
  private Bolt bolt;
  private boolean boltFired = false;

  public Hero(int x, int y, Level level) {
    super(x, y, level);
    isEmpty = false;
    ImageIcon icon = new ImageIcon(this.imageFile);
    this.image = icon.getImage();
  }

  @Override
  public void render(Graphics g) {
    g.drawImage(this.image, SIZE * this.x, SIZE * this.y, this);

    if (boltFired) {
      bolt.render(g);
      boltFired = bolt.isStillFlying();
    }
  }

  public void hit(int x, int y) {
    bolt = new Bolt(this.x, this.y, x, y);
    boltFired = true;
  }
}
