package dungndrug.fight;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static java.lang.Math.sqrt;

import dungndrug.level.Cell;


public class Bolt implements ImageObserver {
  private String imageFile = "data/image/bolt.png";
  protected boolean isImageUpdate = false;
  protected Image image;
  private int toX;
  private int toY;
  private int realX;
  private int realY;
  private int speed = 10;
  private boolean stillFlying;

  public Bolt(int fromX, int fromY, int toX, int toY) {
    stillFlying = true;
    this.toX = Cell.SIZE * toX;
    this.toY = Cell.SIZE * toY;
    this.realX = Cell.SIZE * fromX;
    this.realY = Cell.SIZE * fromY;

    ImageIcon icon = new ImageIcon(this.imageFile);
    this.image = icon.getImage();
    this.isImageUpdate = true;
  }

  protected void calcPos() {
    int deltaX = toX - realX;
    int deltaY = toY - realY;
    double fullWayLength = sqrt(deltaX * deltaX + deltaY * deltaY);

    if (fullWayLength < speed) {
      stillFlying = false;
      realX = toX;
      realY = toY;
    } else {
      double part = speed / fullWayLength;
      realX += deltaX * part;
      realY += deltaY * part;
    }
  }

  public void render(Graphics g) {
    calcPos();
    g.drawImage(this.image, this.realX, this.realY, this);
  }

  public boolean isStillFlying() {
    return stillFlying;
  }

  @Override
  public boolean imageUpdate (
    Image img, int bFlags, int x, int y,
    int width, int height
  ) {
    return isImageUpdate;
  }
}
