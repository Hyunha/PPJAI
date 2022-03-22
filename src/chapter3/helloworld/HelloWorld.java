package chapter3.helloworld;

public class HelloWorld {

	public static void main(String[] args) {
		Controller ctrl = new Controller();
		Model md = new Model();
		View v = new View();
		ctrl.control(md, v);
	}

}
