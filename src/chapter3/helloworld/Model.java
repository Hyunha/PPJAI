package chapter3.helloworld;

public class Model {

	String greeting_msg_en = "Hello, World!";
	String greeting_msg_ko = "안녕하세요!";

	String createGreetings() {
		return greeting_msg_ko;
	}

	String createGreetingsKorean() {
		return greeting_msg_ko;
	}

	String createGreetingsEnglish() {
		return greeting_msg_en;
	}
}
