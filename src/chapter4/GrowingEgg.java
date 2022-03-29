package chapter4;

import java.awt.*;
import javax.swing.*;

public class GrowingEgg extends JPanel {
	
	private final int NET_SIZE = 400;

	private int egg_width = 60;
	private int egg_height = 40;
	private int x = 170;
	private int y = 180;

	public GrowingEgg() {
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle("Egg");
		f.setSize(NET_SIZE, NET_SIZE+28);
		f.setVisible(true);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, NET_SIZE, NET_SIZE);
		g.setColor(Color.yellow);
		g.fillOval(x, y, egg_width, egg_height);
	}

	public static void main(String[] args) {
		new GrowingEgg();
	}
}
