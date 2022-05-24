package chapter9.throbbingball;

public class ThrobbingBall {
	private boolean is_large = true;
	
	public boolean isLarge() {
		return is_large;
	}
	
	public void throb() {
		is_large = ! is_large;
	}

}
