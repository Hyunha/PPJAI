package chapter3.helloworld;

public class Controller {
	public void control(Model m, View v) {
		// using Standard Output
		// v.show(m.createGreetings());

		// using Swing Dialog
		// v.showSwing(m.createGreetings());

		// using Swing Dialog with Korean Message
		v.showSwing(m.createGreetingsKorean());
		// using Swing Dialog with English Message
		// v.showSwing(m.createGreetingsEnglish());
	}
}
