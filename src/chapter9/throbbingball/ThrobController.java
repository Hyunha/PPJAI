package chapter9.throbbingball;

public class ThrobController {
	private ThrobPanel writer;
	private ThrobbingBall ball;
	private int time;
	
	public ThrobController(ThrobPanel w, ThrobbingBall b, int delay_time) {
		writer = w; 
		ball = b; 
		time = delay_time;
	}
	
	public void run() {
		while(true) {
			ball.throb();
			writer.repaint();
			delay();
		}
	}
	
	private void delay() {
		try { Thread.sleep(time); } 
		catch (InterruptedException e) {}
	}


}
