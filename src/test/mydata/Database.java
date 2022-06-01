package test.mydata;

import java.io.*;

import javax.swing.JOptionPane;

import test.database.Key;
import test.database.Record;
import test.database.StringKey;

public class Database {
	
	private Record[] base;
	private final static int NOT_FOUND = -1;
	private static File secret; 
	
	/** Constructor - Database 초기화 
	 * @param initial_size - 데이터베이스 규모 */
	public Database(int initial_size) {
		if (initial_size > 0)
			base = new Record[initial_size];
		else
			base = new Record[1];
	}

	/** findLocation - 데이터베이스에서 키가 k인 레코드의 인덱스 검 
	 * @param k - 검색할 레코드의 키 
	 * @return - 찾으면 해당 레코드의 인덱스  
	 *  return - 찾지 못하면 NOT_FOUND */
	private int findLocation(Key k) {
		for (int i = 0; i < base.length; i++)
			if (base[i] != null && base[i].getKey().equals(k))
				return i;
		return NOT_FOUND;
	}
	
	/** findEmpty - 데이터베이스에서 빈 자리 검색  
	 * @return - 찾으면 빈 자리 인덱스  
	 *  return - 찾지 못하면 NOT_FOUND */
	private int findEmpty() {
		for (int i = 0; i < base.length; i++)
			if (base[i] == null)
				return i;
		return NOT_FOUND;
	}
	
	/** find - 키가 k인 레코드를 데이터베이스에서 검색 
	 * @param k - 검색할 레코드의 키 
	 * @return - 찾으면 해당 레코드 주소 
	 *  return - 찾지 못하면 null */
	public Record find(Key k) {
		int index = findLocation(k);
		if (index == NOT_FOUND) 
			return null;
		else
			return base[index];		
	}
	
	/** delete - 키가 k인 레코드를 삭제 
	 * @param k - 삭제할 레코드의 키 
	 * @return - 성공적으로 삭제되면 true 
	 *  return - 키가 k인 레코드가 없으면 false */
	public boolean delete(Key k) {
		int index = findLocation(k);
		if (index == NOT_FOUND) 
			return false;
		else {
			base[index] = null;
			return true;
		}
	}

	/** insert - 레코드 r을 데이터베이스에 추가
	 * @param r - 데이터베이스에 추가할 레코드 r
	 * @return - 성공적으로 추가되면 true 
	 *  return - 추가에 실패하면 false */
	public boolean insert(Record r) {
		if (findLocation(r.getKey()) != NOT_FOUND) 
			return false;
		int index = findEmpty();
		if (index != NOT_FOUND) // found an empty slot
			base[index] = r;
		else { // database is full and gets more space
			Record[] temp = new Record[base.length * 2];
			for (int i = 0; i < base.length; i++)
				temp[i] = base[i]; 
			temp[base.length] = r;
			base = temp;
		}
		return true;
	}

	public static void file_load_and_save() throws IOException {
		Database db = new Database(4);
		
		// 파일 열어서 읽기
		FileReader reader = new FileReader(secret);
		BufferedReader br = new BufferedReader(reader);
		while(br.ready()) {
			String line = br.readLine();
			if ("!".equals(line)) break;
			
//			System.out.println(line);
			String[] id_pwd = line.split(":");
			StringKey user = new StringKey(id_pwd[0]);
			Password pwd1 = new Password(user, id_pwd[1]);
			boolean chk1 = db.insert(pwd1);
		}
		br.close(); // 모두 읽은 후 Reader 닫기
		
		boolean logon = false;
		boolean new_user = false;
		// 사용자에게 아이디/패스워드 입력 받기
		String userid = JOptionPane.showInputDialog("아이디?");
		String input = JOptionPane.showInputDialog("패스워드?");

		// 입력 받은 아이디로 Key 생성
		StringKey uid = new StringKey(userid);
		
		if (userid != null && input != null) { // 입력 받은 아이디/패스워드가 모두 null 이 아닌 경우
			// DB에서 Key와 일치하는 Record(Password) 찾기  
			Password pwd = (Password)db.find(uid);
			
			if (pwd != null && input.equals(pwd.getPassword())) { // 패스워드가 일치할 경우
				System.out.println(uid.getStringKey() + "님 안녕하세요.");
				logon = true;
			}
			if (pwd == null) {	// 해당 Key의 Record(Password)가 존재하지 않을 경우 
				// 새 Password를 생성해서
				pwd = new Password(uid, input);
				// db에 넣기
				db.insert(pwd);
				System.out.println(uid.getStringKey() + "님 처음뵙겠습니다.");
				logon = true;
				new_user = true;
			}
 		}
		if (!logon) {
			System.out.println("로그인에 실패했습니다.");
		}
		if (new_user) {
			// 새로운 계정이 추가된 경우, db를 파일에 쓰기
			FileWriter writer = new FileWriter(secret);
			BufferedWriter bw = new BufferedWriter(writer);
			for(int i = 0; i < db.base.length; i++) {
				if (db.base[i] != null) {
					Password pwd = (Password)db.base[i];
					String id = ((StringKey)pwd.getKey()).getStringKey();
					String pw  = pwd.getPassword();
					bw.write(id + ":" + pw);
					bw.newLine();
				}
			}
			bw.write("!");
			bw.newLine();
			bw.close();
		}
	}
	
	public static void create_dummy_db() throws IOException {
		FileWriter writer = new FileWriter(secret);
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write("hanyang:qwerty");
		bw.newLine();
		bw.write("univ:asdf");
		bw.newLine();
		bw.write("!");
		bw.newLine();
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		try {
			secret = new File("password.txt");
			file_load_and_save();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("password.txt 파일을 생성합니다.");
			create_dummy_db();
		}
	}
}











