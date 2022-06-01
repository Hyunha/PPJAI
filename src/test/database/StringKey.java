package test.database;

public class StringKey implements Key {
	
	private String key;
	
	public StringKey(String i) {
		key = i;
	}
	
	public boolean equals(Key k) {
		return key.equals(((StringKey)k).getStringKey());
	}
	
	public String getStringKey() {
		return key;
	}

}
