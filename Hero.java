import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Hero extends Block {
  private String imageFile = "data/image/mage.png";
  private Level mapLevel;
  private Bolt bolt;
  private boolean boltFired = false;

  public Hero(int x, int y, Level level) {
    super(x, y);
    isEmpty = false;
    this.mapLevel = level;
    ImageIcon icon = new ImageIcon(this.imageFile);
    this.image = icon.getImage();
  }

  public boolean move(int delta_x, int delta_y) {
    if (! this.mapLevel.isEmpty(x + delta_x, y + delta_y)) {
      return false;
    }

    x += delta_x;
    y += delta_y;

    return true;
  }

  public void hit(int x, int y) {
    bolt = new Bolt(this.x, this.y, x, y);
    boltFired = true;
  }

  @Override
  public void render(Graphics g) {
    g.drawImage(this.image, SIZE * this.x, SIZE * this.y, this);

    if (boltFired) {
      bolt.render(g);
      boltFired = bolt.isStillFlying();
    }
  }
}
