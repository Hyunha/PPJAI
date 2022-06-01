package test.mydata;

import test.database.Key;
import test.database.Record;

public class Password implements Record {

	private Key userid;
	private String password;
	
	public Password(Key id, String pwd) {
		password = pwd;
		userid = id;
	}
	@Override
	public Key getKey() {
		// TODO Auto-generated method stub
		return userid;
	}

	public String getPassword() {
		return password;
	}
}
