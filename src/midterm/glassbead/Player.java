package midterm.glassbead;

public class Player {
	int beads;
	
	public Player() {
		beads = 10;
	}
	
	void addBeads(int n) {
		beads += n;
	}
	
	void removeBeads(int n) {
		beads -= n;
	}
	
	int getBeads() {
		return beads;
	}
	
	boolean lose() {
		return beads == 0;
	}
}
