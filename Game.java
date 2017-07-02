import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame {
  private Board board;

  public Game() {
    this.board = new Board();
    initUI();
  }

  private void initUI() {
    add(this.board);
    setSize(640, 480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    addKeyListener(new KeyPressAdapter());
  }

  public static void main(String[] args) {
    EventQueue.invokeLater(
      new Runnable() {
        @Override
        public void run() {
          Game game = new Game();
          game.setVisible(true);
        }
      }
    );
  }

  private class KeyPressAdapter extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
      switch(e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
          board.level.hero.move(-1, 0);
          break;
        case KeyEvent.VK_RIGHT:
          board.level.hero.move(1, 0);
          break;
        case KeyEvent.VK_UP:
          board.level.hero.move(0, -1);
          break;
        case KeyEvent.VK_DOWN:
          board.level.hero.move(0, 1);
          break;
      }
    }
  }
}
