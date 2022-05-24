package chapter9.throbbingball;

import java.awt.*;
import javax.swing.*;

public class ThrobFrame extends JFrame {
	
	public ThrobFrame(int size, ThrobPanel p, ColorButton b) {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(p, BorderLayout.CENTER);
		cp.add(b, BorderLayout.SOUTH);
		setTitle("Throb"); 
		setSize(size, size+40); 
		setVisible(true);
	}

}
