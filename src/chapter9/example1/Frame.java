package chapter9.example1;
import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
	
	public Frame() {
		JLabel label = new JLabel("OK 누르세요!");
		JButton button = new JButton("OK");
		Container c = getContentPane(); // 화판 준비
		c.setLayout(new FlowLayout()); // 가로로 배치
		c.add(label);
		c.add(button);
		setTitle("Button");
		setSize(200,80);
		pack();
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Frame();
	}
}