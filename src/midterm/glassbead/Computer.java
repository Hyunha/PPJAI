package midterm.glassbead;

public class Computer {

	int beads;

	public Computer() {
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
	
	int pickForAttack(int player_beads) {
		int n = Math.min(Math.min(player_beads, beads), 5);
		int m = 1;
		return (int)(Math.random() * n) + m;
	}
	
	int pickForGuard() {
		int n = Math.min(beads, 5);
		int m = 0;
		return (int)(Math.random() * n) + m;
	}
	
	boolean pickEven() {
		int n = 6;
		int m = 1;
		return ((int)(Math.random() * n) + m % 2) == 0;
	}
}
