import javax.swing.ImageIcon;
import java.awt.Image;

public class Hero extends Block {
  private String imageFile = "data/image/mage.png";
  private Level mapLevel;

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
}
