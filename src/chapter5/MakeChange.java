package chapter5;

public class MakeChange {

	public static void main(String[] args) {
		int dollars = Integer.parseInt(args[0]);
		int cents = Integer.parseInt(args[1]);
		if (dollars < 0) {
			System.out.println("Error: negative dollars: " + dollars);
		} else {
			if (cents < 0) {
				System.out.println("Error: negative cents: " + cents);
			} else {
				if (cents > 99) {
					System.out.println("Error: bad cents: " + cents);
				} else {
					int money = dollars * 100 + cents;
					System.out.println("quarters = " + (money / 25));
					money = money % 25;
					System.out.println("dimes = " + (money / 10));
					money = money % 10;
					System.out.println("nickels = " + (money / 5));
					money = money % 5;
					System.out.println("pennies = " + money);
				}
			}
		}
	}
}
