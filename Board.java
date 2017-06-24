import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Board extends JPanel implements ActionListener {
	private final int TICK = 100;
	private Timer timer;
	private int tick_counter = 0;

	public Board() {
		timer = new Timer(TICK, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.tick_counter += 1;
		System.out.println(this.tick_counter);
	}
}

