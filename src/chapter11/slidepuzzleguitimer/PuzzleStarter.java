package chapter11.slidepuzzleguitimer;

public class PuzzleStarter {
	
	public static void main(String[] args) {
		PuzzleFrame frame = new PuzzleFrame(new SlidePuzzleBoard());
		new PuzzleTimer(frame);
		
	}
}
