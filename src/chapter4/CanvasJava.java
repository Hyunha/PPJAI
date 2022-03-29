package chapter4;

import javax.swing.*;
import java.awt.*;

public class CanvasJava extends JPanel {
	public CanvasJava() {
		JFrame frame = new JFrame();
		frame.setTitle("Canvas");
		frame.setSize(300, 200);
		frame.getContentPane().add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
		g.drawString("Java!", 100, 60);
	}

	// test code
	public static void main(String[] args) {
		new CanvasJava();
	}
}
