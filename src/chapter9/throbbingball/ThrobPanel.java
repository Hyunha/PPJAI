package chapter9.throbbingball;

import java.awt.*;
import javax.swing.*;

public class ThrobPanel extends JPanel {
	private int panel_size, location, ball_size;
	private Color c = Color.red;
	private ThrobbingBall ball;
	
	public ThrobPanel(int size, ThrobbingBall b) {
		panel_size = size; 
		location = size / 2; 
		ball_size = size / 3; 
		ball = b;
		setSize(size, size);
	}
	
	public Color getColor() { 
		return c; 
	}
	
	public void setColor(Color new_color) { 
		c = new_color; 
	}	
	
	public void paintComponent(Graphics g) { 
		g.setColor(Color.white); 
		g.fillRect(0, 0, panel_size, panel_size); 
		g.setColor(c); 
		if (ball.isLarge())
			g.fillOval(location-ball_size/2,location-ball_size/2,ball_size,ball_size); 
		else 
			g.fillOval(location-ball_size/4,location-ball_size/4,ball_size/2,ball_size/2); 
	}

}
