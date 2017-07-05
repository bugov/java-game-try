import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JFrame {
  private Board board;

  public Game() {
    board = new Board();
    add(board);

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
      board.setKeyboardEvent(e);
    }
  }
}
