package dungndrug.level;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;

import java.awt.Graphics;
import java.awt.Image;

import dungndrug.level.Level;
import dungndrug.user.Hero;
import dungndrug.creep.CreepInterface;


public class Board extends JPanel implements ActionListener {
  private final int TICK = 25;
  private Timer timer;
  private int tickCounter = 0;
  private KeyEvent keyboardEvent;
  private boolean keyPressed = false;

  private Level level;
  private Hero hero;

  public Board() {
    level = new Level("./data/level/1.txt");
    hero = level.getHero();
    addMouseListener(new MouseActionAdapter());
    timer = new Timer(TICK, this);
    timer.start();
  }

  public void setKeyboardEvent(KeyEvent e) {
    keyboardEvent = e;
    keyPressed = true;
  }

  @Override
  public void actionPerformed(ActionEvent event) {
    tickCounter += 1;
    keyPressAction(keyboardEvent);
    repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (int x = 0; x < level.cells.size(); ++x) {
      for (int y = 0; y < level.cells.get(x).size(); ++y) {
        for (int i = 0; i < level.cells.get(x).get(y).size(); ++i) {
          level.cells.get(x).get(y).get(i).render(g);
        }
      }
    }
  }

  class MouseActionAdapter extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        int xDot = e.getX();
        int yDot = e.getY();

        int x = xDot / Cell.SIZE;
        int y = yDot / Cell.SIZE;

        hero.hit(x, y);
    }
  }

  private void keyPressAction(KeyEvent e) {
    if (! keyPressed) {
      return;
    }

    keyPressed = false;
    int keyCode = e.getKeyCode();

    if (keyCode == KeyEvent.VK_SPACE) {
      System.out.println("Next turn");
      this.creepTurn();
      this.beforeTurn();
    }

    if (hero.getSpeed() > 0) {
      switch(keyCode) {
        case KeyEvent.VK_LEFT:
          hero.move(-1, 0);
          break;
        case KeyEvent.VK_RIGHT:
          hero.move(1, 0);
          break;
        case KeyEvent.VK_UP:
          hero.move(0, -1);
          break;
        case KeyEvent.VK_DOWN:
          hero.move(0, 1);
          break;
      }
    }

    // Debug
    System.out.println("Pos: " + hero.getX() + ":" + hero.getY());
    for (int x = 0; x < level.cells.size(); ++x) {
      for (int y = 0; y < level.cells.get(x).size(); ++y) {
        if (! level.isEmpty(x, y)) {
          System.out.print("X");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println("");
    }
  }

  public void creepTurn() {
    for (CreepInterface creep : level.creeps) {
      creep.getStrategy().turn();
    }
  }

  public void beforeTurn() {
    hero.beforeTurn();
    for (CreepInterface creep : level.creeps) {
      creep.beforeTurn();
    }
  }
}
