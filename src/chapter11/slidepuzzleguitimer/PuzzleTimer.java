package chapter11.slidepuzzleguitimer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PuzzleTimer implements ActionListener {
	
	private PuzzleFrame frame;
	
	public PuzzleTimer(PuzzleFrame f) {
		frame = f;
		Timer timer = new Timer(1000, this);
		timer.setInitialDelay(0);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		frame.tick();
	}
}



