package chapter9.throbbingball;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorButton extends JButton implements ActionListener{
	private ThrobPanel view;
	
	public ColorButton(ThrobPanel f) {
		super("OK");
		view = f;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Color c = view.getColor();
		if (c == Color.red)
			view.setColor(Color.blue);
		else
			view.setColor(Color.red);
	}



}
