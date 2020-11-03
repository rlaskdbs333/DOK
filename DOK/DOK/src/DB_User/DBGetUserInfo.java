package DB_User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBGetUserInfo {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBGetUserInfo() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userInfo_DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류:"+e.getMessage());
		}
	}
	public String[] getUserInfo(String userId) {
		return null;
		
	}
}
