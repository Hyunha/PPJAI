package chapter9.button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonFrame extends JFrame {
	private JLabel label = new JLabel("OK 누르세요!");
	
	public ButtonFrame() {
		Container cp = getContentPane();
		cp.add(label);
		cp.setLayout(new FlowLayout());
		JButton button = new JButton("OK");
		cp.add(button);
		setTitle("Button");
		setSize(200,200);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
