package midterm.glassbead;

public class GlassBeadGame {
	public static void main(String[] args) {
		Player p = new Player();
		Computer c = new Computer();
		Registrar r = new Registrar();
		GameController controller = new GameController();
		controller.play(p, c, r);		
	}
}
