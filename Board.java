import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Graphics;
import java.awt.Image;


public class Board extends JPanel implements ActionListener {
  private final int TICK = 100;

  private Timer timer;
  private int tickCounter = 0;

  public Level level;

  public Board() {
    this.level = new Level("./data/level/1.txt");
    timer = new Timer(TICK, this);
    timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    this.tickCounter += 1;

    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int x = 0; x < this.level.cells.length; ++x) {
      for (int y = 0; y < this.level.cells[x].length; ++y) {
        if (this.level.cells[x][y] != null) {
          this.level.cells[x][y].render(g);
          this.level.hero.render(g);
        }
      }
    }
  }
}
