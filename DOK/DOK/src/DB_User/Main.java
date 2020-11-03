package DB_User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBSelectUserInfo connection = new DBSelectUserInfo();
		System.out.println(connection.isUser("kny030303", "kny12345"));
		//System.out.println("관리자 여부:"+coneection.addUser("qwersdru", "555", "권네수", 030307, "12346589", "스릴러", "로맨스"));
		
	}

}
