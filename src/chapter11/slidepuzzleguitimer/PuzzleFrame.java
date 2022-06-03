package chapter11.slidepuzzleguitimer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PuzzleFrame extends JFrame {
	
	private SlidePuzzleBoard board;
	private PuzzleButton[][] button_board;
	private int time_elapsed = 0;
	private JLabel time;
	private boolean stopped = true;
	private boolean started = false;
	
	public PuzzleFrame(SlidePuzzleBoard b) {
		board = b;
		button_board = new PuzzleButton[4][4];
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel p1 = new JPanel(new FlowLayout());
		JButton start =	new StartButton(board, this);
	    time = new JLabel();
		time.setText("00:00:00");
		stopped = true;
		started = false;
		p1.add(start);
		p1.add(time);
		JPanel p2 =	new JPanel(new GridLayout(4,4));		
		for (int row = 0; row < button_board.length; row++)
			for (int col = 0; col < button_board.length; col++) {
				button_board[row][col] = new PuzzleButton(board,this);
				p2.add(button_board[row][col]);
			}
		cp.add(p1, BorderLayout.NORTH);
		cp.add(p2, BorderLayout.CENTER);
		update();
		setTitle("Slide Puzzle");
		setSize(250,250);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void start() {
		started = true;
	}
	
	public void update() {
		PuzzlePiece pp;
		for (int row = 0; row < button_board.length; row++)
			for (int col = 0; col < button_board.length; col++) {
				pp = board.getPuzzlePiece(row, col);
				if (pp != null)
					button_board[row][col].setText(Integer.toString(pp.faceValue()));
				else if (stopped && !started)
					button_board[row][col].setText("Done");
				else
					button_board[row][col].setText("");
			}
		if (stopped && !started)
			time.setText("00:00:00");
		else
			time.setText(formatTimer(time_elapsed));
	}
	
	public void finish() {
		button_board[3][3].setText("Done");
		stopped = true;
		started = false;
		String msg = "소요시간 : " + formatTimer(time_elapsed);
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public void tick() {
		time_elapsed += 1;
		update();
	}
	
	public void timerReset() {
		time_elapsed = 0;
	}
	
	private String formatTimer(int time) {
		if (time < 60)
			return "00:00:" + fill0(time);
		else if (time >= 60 && time < 3600)
			return "00:" + fill0(time / 60) + ":" + fill0(time % 60);
		else {
			int hour = time / 3600;
			int second = time % 3600;
			return hour + ":" + fill0(second / 60) + ":" + fill0(second % 60);
		}
	}
	
	private String fill0(int n) {
		if (n < 10) return "0" + n;
		else return "" + n;
	}

}