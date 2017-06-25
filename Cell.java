import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Cell implements ImageObserver {
  public static final int SIZE = 32;
  private String imageFile = "data/image/floor.png";
  protected Image image;

  protected boolean isImageUpdate = false;
  protected int x, y;

  public Cell(int x, int y) {
    ImageIcon icon = new ImageIcon(this.imageFile);
    this.image = icon.getImage();
    this.isImageUpdate = true;
    this.x = x;
    this.y = y;
  }

  public void render(Graphics g) {
    g.drawImage(this.image, SIZE * this.x, SIZE * this.y, this);
  }

  @Override
  public boolean imageUpdate (
    Image img, int bFlags, int x, int y,
    int width, int height
  ) {
    return isImageUpdate;
  }
}
