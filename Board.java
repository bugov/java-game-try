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

	private Image heroImage;

	public Board() {
		loadImages();
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
		drawTimer(g);
		drawHero(g);
	}

	private void drawHero(Graphics g) {
		g.drawImage(heroImage, 100, 100, this);
	}

	private void loadImages() {
		ImageIcon icon = new ImageIcon("hero.png");
    heroImage = icon.getImage();
	}

	private void drawTimer(Graphics g) {
		g.drawString("Timer: " + Integer.toString(this.tickCounter), 25, 25);
	}
}
