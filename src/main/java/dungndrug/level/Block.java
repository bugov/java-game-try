package dungndrug.level;

import javax.swing.ImageIcon;
import java.awt.Image;

public class Block extends Cell {
  String imageFile = "data/image/block.png";

  public Block(int x, int y) {
    super(x, y);
    isEmpty = false;
    ImageIcon icon = new ImageIcon(this.imageFile);
    this.image = icon.getImage();
  }
}
