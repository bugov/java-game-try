import javax.swing.JFrame;
import java.awt.EventQueue;

public class Game extends JFrame {
	public Game() {
		initUI();
	}

	private void initUI() {
		add(new Board());
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
