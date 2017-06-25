import javax.swing.ImageIcon;
import java.awt.Image;

public class Hero extends Block {
  private String imageFile = "data/image/mage.png";

  public Hero(int x, int y) {
    super(x, y);
    ImageIcon icon = new ImageIcon(this.imageFile);
    this.image = icon.getImage();
  }
}
