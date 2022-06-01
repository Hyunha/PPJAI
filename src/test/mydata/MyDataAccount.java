package test.mydata;

import test.database.Key;
import test.database.Record;

public class MyDataAccount implements Record {
	private int balance;
	private Key key;
	private String name;

	public MyDataAccount(int initial_amount, Key id, String n) {
		balance = initial_amount;
		key = id;
		name = n;
	}
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public boolean withdraw(int amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	
	public int getBalance() {
		return balance;
	}
	
	@Override
	public Key getKey() {
		return key;
	}
	
	public String getName() {
		return name;
	}
}
